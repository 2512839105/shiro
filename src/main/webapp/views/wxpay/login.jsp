<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%-- <%@include file="/common/header.jsp" %> --%>

<script type="text/javascript">
//判断是不是父窗口
if(parent.window == window){
}else{
    window.parent.location.href = "${ctx}/views/login.jsp";
}
</script>

<link rel="stylesheet" type="text/css" href="${ctx }/statics/css/login.css">

<div id="title" style="display:none;">系统登录</div>

<div id="wrap">
	<div class="login-logo"></div>
	<div id="main" class="clearfix">
	    
	    
	    <div class="login-form radius8">
		    <div class="login-form-bg">
		    	<img src="${ctx }/statics/images/logo-text.png" />
		    </div>
	        <!--<div class="cxlogo"><img src="images/cxLOGO.png" alt=""></div>-->
	        <div id="faceMsgContent" style="margin-bottom:10px;"><span id="faceMsg"></span><span id="faceTimerInfo"></span></div>
	        <form action="sasa" onsubmit="doLogin();return false;">
	            <div class="input-group">
	                <input type="text" class="form-control input-user" name="account" placeholder="账号或手机号码">
	                <div class="input-group-addon"><span class="iconfont icon-yonghu"></span></div>
	            </div>
	            <div class="input-group">
	                <input type="password" class="form-control" name="password" placeholder="密码">
	                <div class="input-group-addon"><span class="iconfont icon-suoding"></span></div>
	            </div>
	            <p class="text-right center-block"><a class="text-link" href="">忘记密码</a><span class="pull-left errorMessage" id="errorMessage"></span></p>
	            <p class="button center-block text-center"><button class="center-block radius8 submitButton" type="submit">登&nbsp;&nbsp;&nbsp;录</button></p>
	        </form>
	    </div>
	    <div class="login-video">
	    	<video id="video" width="380" height="380" style="object-fit: cover;" autoplay>您的浏览器不支持多媒体，请升级!</video>
	    	<canvas id="canvas" width="380" height="380">您的浏览器不支持多媒体，请升级!</canvas>
	    	<canvas id="canvas1" width="380" height="380">您的浏览器不支持多媒体，请升级!</canvas>
	    	
	    	<div class="video-arc">
	    		<div class="arc1 arc1Animate"></div>
	    		<div class="arc2 arc2Animate"></div>
	    	</div>
	    	
	    	<div class="video-mian-img"></div>
	    </div>
	</div>
</div>

<!-- 引入人脸识别所需js文件 -->
<script src="${ctx}/statics/plugins/face/clmtrackr.js"></script>
<script src="${ctx}/statics/plugins/face/model_pca_20_svm.js"></script>
<script src="${ctx}/statics/plugins/face/RecordRTC.js"></script>

<script type="text/javascript">

/* 调用视频*/
$('.login-form').css('marginTop', - $('.login-form').outerHeight(true)/2);
//获取DOM
var video = document.getElementById('video'),
	canvas1 = document.getElementById("canvas1"),  
	context1 = canvas1.getContext('2d'), 
	canvasInput = document.getElementById('canvas'),
	cc = canvasInput.getContext('2d'),
	userInfo = $(".input-user");
var promisifiedOldGUM = function(constraints) {
    var getUserMedia = (navigator.getUserMedia || navigator.webkitGetUserMedia || navigator.mozGetUserMedia);
    if(!getUserMedia) {
        return Promise.reject(new Error('getUserMedia在这浏览器没有实现'));
    }
    return new Promise(function(resolve, reject) {
        getUserMedia.call(navigator, constraints, resolve, reject);
    });
}
    
if(navigator.mediaDevices === undefined) {
  navigator.mediaDevices = {};
}
if(navigator.mediaDevices.getUserMedia === undefined) {
  navigator.mediaDevices.getUserMedia = promisifiedOldGUM;
}
var constraints = {video: true};
navigator.mediaDevices.getUserMedia(constraints).then(function(stream) {
    var video = document.querySelector('video');
    video.src = window.URL.createObjectURL(stream);
    video.onloadedmetadata = function(e) {
        video.play();
        $('.video-mian-img').addClass('hide')
    };
}).catch(function(err) {
    console.log(err);
});

//自定义操作
var setCustom = {
	is_alive_head : true,	//控制调用拍照功能
	postUrl : "${ctx}/third/face/user/match.action",		//抛送到后台的地址
}

//定义拍照  
function getPhoto() {
	stopGet();
    context1.drawImage(video, 0, 0,486,486);
    var dataURL = canvas1.toDataURL("image/png",1.0);
    uploadImg(dataURL);
}

//定义图片上传
function uploadImg(dataURL){
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
			console.info(result);
			if(result.statusCode == 200){ 
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
				/* showMsg(result.msg); */
				$("#faceMsgContent").removeClass("text-primary").removeClass("text-success").addClass("text-danger");
				$("#faceMsg").text("识别结果："+result.msg);
				
				faceTimer(3);
			}
		},
		error : function(){
			alert("图片未知错误!");
		}
	});
}

function faceTimer(times){
	if(times==0){
		getPhoto();
		
		return;
	}
	
	$("#faceTimerInfo").text("（"+times+"秒后重试！）");
	
	times--;
	
	setTimeout(function(){
		faceTimer(times);
	},1000)
}

//开始铺抓
(function startTrack() {
	var ctracker = new clm.tracker();
	ctracker.init(pModel);
	ctracker.start(video);
	cc.lineWidth = 3;

	function drawLoop() {
		cc.clearRect(0, 0, canvasInput.width, canvasInput.height);
		var positions = ctracker.getCurrentPosition();
		//检测到人脸时触发
		if(positions) {
			//检测到头部时触发
			if(setCustom.is_alive_head == true) {
				getPhoto();	//触发时调用拍照功能
			}
		}
		requestAnimationFrame(drawLoop);
	}
	drawLoop();
})();

//定义开始拍照
function stopGet(){
	setCustom.is_alive_head = false;
}

//定义停止拍照
function startGet(){
	setCustom.is_alive_head = true;
}
/* /调用视频 */
document.onkeydown = function(event) {
     var e = event || window.event || arguments.callee.caller.arguments[0];
     if(e && e.keyCode == 13) {
        doLogin();
     }
}

$(function(){
	addTitle();
})

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
		url : "${ctx}/sys/login/login.action",
		data : {"account": account, "password": password},
		type : "post",
		success : function(json){
            json = json || {};
            if (json.statusCode == 200) {
               window.location.href = "${ctx}/index.jsp";
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

//添加标题
function addTitle(){
    if($("head").children("title").length<1){
        if($("#title").length==1){
            var text = $("#title").text();
            $("head").append("<title>" + text + "</title>");
        }
    }
}

</script>

<%-- <%@include file="/common/footer.jsp" %> --%>