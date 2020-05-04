<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<title>视频上传</title>
	<link rel="stylesheet" type="text/css" href="${ctx}/statics/css/reset.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/statics/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/statics/css/bootstrap-table.min.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/statics/css/sweetalert.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/statics/css/iziModal.min.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/statics/css/webuploader.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/statics/css/styles.css">
	<style type="text/css">
		.main {padding: 20px;}
		textarea {resize: none}
		.webuploader-my-pick{top:0px;/* width:100%; */padding:10px 15px;border: 1px solid #fff;border-radius: 3px;text-align:center;position: relative;display: inline-block;cursor: pointer;background: #00b7ee!important}
	</style>
</head>

<body>
<div class="main">
	<div id="toolbar">
		<div class="btn-group">
			<button id="btnAdd" type="button" class="btn btn-default">新增</button>
			<button id="btnEdit" type="button" class="btn btn-default">修改</button>
			<button id="btnDelete" type="button" class="btn btn-default">删除</button>
		</div>
	</div>
	<div>
		<table id="table" class="table-striped table-hover table-condensed"> </table>
	</div>
</div>
<div id="addModal">
	<form id="addForm">
		 <div class="form-group">
			<label>门店类型：</label>
			<textarea class="form-control" name="storeType" id="storeType" type="text" isvalid="yes" checkexpession="NotNull"></textarea>
		</div>
	  <div class="form-group">
			<label>排序：</label>
			<textarea class="form-control" name="sore" id="sort" type="text" isvalid="yes" checkexpession="NotNull"></textarea>
		</div>
	   <div class="form-group">
			<label>分类：</label>
			<textarea class="form-control" name="category" id="category" type="text" isvalid="yes" checkexpession="NotNull"></textarea>
		</div>
		<div class="form-group">
			<label>标题：</label>
			<input class="form-control" name="title" id="title" type="text" isvalid="yes" checkexpession="NotNull" />
		</div>
		<div class="form-group">
			<label>简介：</label>
			<textarea class="form-control" name="introduc" id="introduc" isvalid="yes" checkexpession="NotNull"></textarea>
		</div>
		<div class="form-group">
			<label>上传视频：</label>
			<div id="videoUpload">上传视频</div>
		</div>
		<div class="form-group pull-right">
			<button class="btn btn-primary" id="save" type="button">保存</button>
		</div>
	</form>
</div>

<script type="text/javascript" src="${ctx}/statics/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="${ctx}/statics/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${ctx}/statics/js/bootstrap-table.min.js"></script>
<script type="text/javascript" src="${ctx}/statics/js/bootstrap-table-zh-CN.js"></script>
<script type="text/javascript" src="${ctx}/statics/js/sweetalert.min.js"></script>
<script type="text/javascript" src="${ctx}/statics/js/iziModal.min.js"></script>
<script type="text/javascript" src="${ctx}/statics/js/common.js"></script>
<script type="text/javascript" src="${ctx}/statics/js/webuploader.min.js"></script>
<script type="text/javascript" src="${ctx}/statics/js/jquery/jquery.validate.js"></script>
<script type="text/javascript" src="${ctx}/statics/js/jquery/jquery.validate.messages_zh.js"></script>
<script type="text/javascript" src="${ctx}/statics/js/jquery/jquery.validate.unobtrusive.min.js"></script>
<script type="text/javascript" src="${ctx}/statics/js/jquery/jquery-validate.bootstrap-tooltip.min.js"></script>
<script type="text/javascript">
if(window.location.hash) {
	window.location.hash = ""
}

$("#addModal").iziModal({
	headerColor: '#337ab7',
	title: '添加视频',
	width: 400,
	padding: 20
})

//保存上传路径
var filePath ='';

$(function () {
	initBootstrapTable("table",{
		url: '${ctx}/video/selectModelsByPages.action',
		height: $(window).height() - 100,
		responseHandler: function (res) {
    		return {
    			'rows': res.records,
    			'total': res.total
    		}
    	},
		toolbar: '#toolbar',
		columns: [
			{checkbox: true},
			{field: 'videoId', title: 'id', align: 'center', valign: 'middle'},
			{field: 'sort', title: '排序', align: 'center', valign: 'middle'},
			{field: 'category', title: '分类', align: 'center', valign: 'middle'},
			{field: 'title', title: '标题', align: 'center', valign: 'middle'},
			{field: 'storeType', title: '门店类型', align: 'center', valign: 'middle'},
			{field: 'introduc', title: '简介', align: 'center', valign: 'middle'},
			{field: 'link', title: '地址', align: 'center', valign: 'middle'},
			{field: 'uploadDate', title: '上传时间', align: 'center', valign: 'middle', formatter:function(value, row, index) {
				return new Date(value).Format("yyyy年MM月dd日HH:mm:ss")
			}},
		]
	})
	//添加
    $("#btnAdd").click(function () {
        $("#addModal").iziModal('open')
    });
 	
	//上传文件
	videoUpload()	 
	
 
	$("#btnDelete").click(function() {
    //获取所有被选中的记录
    var rows = $("#table").bootstrapTable("getSelections");
       
    if (rows.length== 0) {
        alert("请先选择要删除的记录!");
        return;
    }
    var ids = '';
    for (var i = 0; i < rows.length; i++) {
        ids += rows[i]['videoId'] + ",";
    }
    ids = ids.substring(0, ids.length - 1);
    deleteUser(ids);
});	
	//删除
	function deleteUser(ids) {
	    var msg = "您真的确定要删除吗？";
	    if (confirm(msg) == true) {
	        $.ajax({
	            url: "${ctx}/video/deleteVideoById.action",
	            type: "post",
	            data: {
	            	videoId: ids
	            },
	            success: function (data) {
	                alert(data.msg);
	                //重新加载记录
	                //重新加载数据
	                $("#table").bootstrapTable('refresh', {url: '${ctx}/video/selectModelsByPages.action'});
	            }
	        });
	    }
	};
	
	  $(document).on('click', '#btnEdit', function (event) {

		   var data = $("#table").bootstrapTable("getSelections");
        if (data.length != 1) {
            msgAlert("提示", "请选择一条数据进行操作！", "error");
            return;
        }		
			 	//event.preventDefault();//防止url 打开
			 	 		 	
			 var toUrl = '${ctx}/video/findVideoByIds.action?videoId='+data[0].videoId;
	         var submitUrl = "${ctx}/video/updateVideo.action";
	         reAddModal(this, '#table', '编辑',toUrl, '#videoEit', submitUrl, 400);			   
		});
	
	function reAddModal(self, tableId, title, toUrl, formId, submitUrl, width) {
		msgDialog.call(self, '', tableId, {
			title: title,
			url: toUrl,
			width: width ? width : 900,
			buttons: [{
				text: '保存',
				class: 'button bSuccess pinput',
				icon: 'icon-baocun',
				handler: function (event) {
					var modal = event.data.modal;
					if($("#appname").val()){
						var para = $(formId).serializeArray();
						var form = $(formId)
						form.removeData("validator").removeData("unobtrusiveValidation");
				        $.validator.unobtrusive.parse(form);
						form.validate({
							rules: {
								sort: "required" ,
								category: 'required',
								title: 'required',
								introduc: 'required',
								storeType:'required'
							}
						})
						//提交之前禁用按钮
						if($(formId).valid()) {
							$(".bSuccess").attr("disabled", "true");
							$.ajax({
								url: submitUrl,
								data: para,
								type: "POST",
								dataType:"json",
								success: function (json) {
									json = json || {};
									if (json.statusCode == 200) {
										msgAlert("提示", "提交成功！", "success");
										$(tableId).bootstrapTable('refresh');
									} else {
										msgAlert("错误", json.msg, "error");
									}
									//关闭弹框
									$("#" + modal.id).iziModal('close');
								}
							});
						}
						
					}else{
						msgAlert("错误", "", "error");
					}
				}
			}]
		});
	}  
	
	
	//保存
	$("#save").click(function(){
	 
		 var title=$("#title").val();
		 var introduc=$("#introduc").val();
		 var category=$("#category").val();
		 var sort=$("#sort").val();
		 var storeType=$("#storeType").val();
		 var data={filePath:filePath,title:title,introduc:introduc,category:category,sort:sort,storeType:storeType};
		// var videoId = new Array('b494e521e90343f8abe9d3cbced711e5','e1a3a1a780234800a58502b53f9a6fb8')
        //url:"${ctx}/video/deleteVideoById.action?videoId="+videoId,
        var form =  $("#addForm")
        form.removeData("validator").removeData("unobtrusiveValidation");
        $.validator.unobtrusive.parse(form);
		form.validate({
			rules: {
				sore: "required" ,
				category: 'required',
				title: 'required',
				introduc: 'required',
				storeType:'required'
			}
		})
		if(form.valid()) {
	        $.ajax({
	             url: "${ctx}/video/insertModel.action", 
	             data:data,
	            type: "POST",
	            success: function (json) {
	                json = json || {};
	                if (json.statusCode == 200) {
	                	$("#addModal").iziModal("close")
	                    swal({    
	                    	title: "提示",    
	                    	text: "提交成功！",    
	                    	type: "success",   
	                    }, function(){   
	                    	window.location.reload();
	                    });
	                   
	                    //url: '${ctx}/video/selectModelsByPage.action'
	                } else if (json.msg) {
	                    msgAlert("错误", json.msg, "error");
	                }
	            }
	        });  
        }
	});
	
 
	
})

//上传
function videoUpload(){
    uploader = WebUploader.create({
      auto: true,
      fileNumLimit: 1, //视频数量限制
      server: '${ctx}/video/upload.action',// 文件接收服务端。
      pick: '#videoUpload',
        accept: {
          title: 'video',
          extensions: 'mp4,flv,avi,mkv,rmvb,ogv,webm',
        }
      
    })

    uploader.on('uploadProgress', function (file, percentage) {
    	console.log(percentage)
    	var num = parseInt(percentage * 100)
    	$("#videoUpload .webuploader-pick").remove();
        $("#videoUpload .webuploader-my-pick").remove();
        var textObj = $("#videoUpload").prepend("<div class='webuploader-my-pick'></div>").children(".webuploader-my-pick");
        textObj.text("上传中...").css({"backgroundColor":"#00b7ee!important","color":"#fff"})
    });
    
    
    // 文件上传失败，显示上传出错。
    uploader.on('uploadError', function (file) {
    	$('#videoUpload .webuploader-my-pick').text("上传失败")
       // videoUploadSuccessFun('上传失败');
    });
    
    // 文件上传成功，给item添加成功class, 用样式标记上传成功。
    uploader.on('uploadSuccess', function (file, response) {
     	console.log('success')
    	filePath=response.data;
    	 //alert(JSON.stringify(response.data));
    	 //alert(filePath);
        $('#videoUpload .webuploader-my-pick').text('上传成功')
        var value = response.data;
        if(value.match(/^\/\/.+/)){
            value = value.substring(1, value.length);
        }       
        $("#storeVideo").val(value); 
    });
       
}

</script>
</body>
</html>