
/* 调用视频*/
//获取DOM
var video = document.getElementById('video'),
	canvas1 = document.getElementById("canvas1"),  
	context1 = canvas1.getContext('2d'), 
	canvasInput = document.getElementById('canvas'),
	cc = canvasInput.getContext('2d'),
	userInfo = $(".input-user");
//自定义操作
var setCustom = {
	is_alive_head : true,
	postUrl : ctx + "/third/face/user/match.action"		//抛送到后台的地址
}
var wHeight = $(window).height(),
	stimer = null,
	constraints = {video: true},
	faceTimerTimeout = null,
	num = 0,
	startLoopPa = false,
	isUserInput = false,
	ctracker = null;

//打开摄像头
if (navigator.mediaDevices && navigator.mediaDevices.getUserMedia) {
    navigator.mediaDevices.getUserMedia({
        video: true
    }).then(function(stream) {
        mediaStreamTrack = typeof stream.stop === 'function' ? stream : stream.getTracks()[1];
        video.src = (window.URL || window.webkitURL).createObjectURL(stream);
		$(".video-mian-img").hide();
    }).catch(function(err) {
    })
}


//定义拍照  
function getPhoto() {
    context1.drawImage(video, 0, 0,486,486);
    var dataURL = canvas1.toDataURL("image/png",1.0);
    uploadImg(dataURL);
}

//定义图片上传
function uploadImg(dataURL, rootPath){
	var postData = {};
	postData['fileStr'] = dataURL;
	$("#faceMsgContent").removeClass("text-success").removeClass("text-danger").addClass("text-primary");
	$("#faceMsg").text("识别中...");
	$("#faceTimerInfo").empty();
	$.ajax({
		type:"post",
		url: setCustom.postUrl,
		data: postData,
		async: false,
		dataType: "json",
		success : function(result){
			if(result.statusCode == 200){ 
				if(isUserInput)
					return;
				if(result.msg=="success"){
                    userInfo.val(result.data);
                    $("#faceMsgContent").removeClass("text-primary").removeClass("text-danger").addClass("text-success");
                    var password = $("input[name='password']").val();
                    if(password!=null&&password.trim().length>0){
                    	doLogin();
                    }
                }else{
                    $("#faceMsgContent").removeClass("text-primary").removeClass("text-success").addClass("text-danger");
                }
                $("#faceMsg").text("识别结果："+result.data);
                
			}else{
				$("#faceMsgContent").removeClass("text-primary").removeClass("text-success").addClass("text-danger");
				$("#faceMsg").text("识别结果："+result.msg);
				
				faceTimer(3);
			}
		},
		error : function(){
			//alert("图片未知错误!");
		}
	});
}



function faceTimer(times){
	if(times==0){
		if(startLoopPa){
			getPhoto();
		}
		return;
	}
	
	$("#faceTimerInfo").text("（"+times+"秒后重试！）");
	
	times--;
	
	faceTimerTimeout = setTimeout(function(){
		faceTimer(times);
	},1000)
}

$(function(){
	var isClm = new clm.tracker() || null;
	stimer = setInterval(function(){
		if(isClm){
			startTrack();
			video.play();
			clearInterval(stimer);
		}
	},30);
	$("input[name='account']").focus(function(){
		if(faceTimerTimeout!=null){
			ctracker.stop();
			mediaStreamTrack && mediaStreamTrack.stop();
			$(".video-mian-img").show();
			isUserInput = true;
			clearTimeout(faceTimerTimeout);
			faceTimerTimeout = null;
			$("#faceMsgContent").removeClass("text-success").removeClass("text-danger").addClass("text-primary").text("已转为手动输入！");
		}
	})
});

//开始铺抓
function startTrack() {
	ctracker = new clm.tracker();
	ctracker.init();
	ctracker.start(video);
	drawLoop();
	function drawLoop() {
		requestAnimFrame(drawLoop);
		cc.clearRect(0, 0, canvasInput.width, canvasInput.height);
		facePosition = ctracker.getCurrentPosition();
		if (facePosition) {
			startLoopPa = true;
			ctracker.draw(canvasInput);
			if(setCustom.is_alive_head){
				getPhoto();
				setCustom.is_alive_head = false;
			}
		}
	}
}
/* /调用视频 */
document.onkeydown = function(event) {
     var e = event || window.event || arguments.callee.caller.arguments[0];
     if(e && e.keyCode == 13) {
        doLogin();
     }
}

function doLogin(){
	var account = $("input[name='account']").val();
	var password = $("input[name='password']").val();

	var message = "";
	if(account.trim().length<1)
		message = "用户名不能为空！";
	else if(password.length<1)
		message = "密码不能为空！";
		
	$("#errorMessage").text(message);
	
	if(message.length>0)
	    return;

	var buttonObj = $("button[type='submit']");
	buttonObj.attr("disabled", "disabled");
	buttonObj.stop(true).animate({"backgroundColor": "#f09595"}, 500);
	
	$.ajax({
		url : ctx + "/admin/login/login.action",
		data : {"account": account, "password": password},
		type : "post",
		success : function(json){
            json = json || {};
            if (json.statusCode == 200) {
               window.location.href = ctx + "/";
            } else {
                $("#errorMessage").text(json.msg);
            }
		},
		error : function(){
            errorMsg("系统错误");
		},
		complete : function(){
			buttonObj.removeAttr("disabled");
			buttonObj.stop(true).animate({"backgroundColor": "#399b7f"}, 500);
		}
	})
}