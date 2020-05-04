$.SaveForm = function(options) {
	var defaults = {
		url : "",
		param : {},
		type : "post",
		dataType : "json",
		contentType : 'application/json',
		success : null,
		close : true,
		show : true
	};
	var options = $.extend(defaults, options);
	dialogLoading(true);
	window.setTimeout(function() {
		$.ajax({
			url : options.url,
			data : JSON.stringify(options.param),
			type : options.type,
			dataType : options.dataType,
			contentType : options.contentType,
			success : function(data) {
				if (data.statusCode == 500) {
                    if(options.show){
                        //dialogMsg(data.msg, 'error');
						errorMsg(data.msg);
                    }
				} else if (data.statusCode == 200) {
					options.success(data);
					//是否要显示提示信息
					if(options.show){
                        dialogMsg(data.msg, 'success');
					}
					if (options.close == true) {
						dialogClose();
					}
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				dialogLoading(false);
				//dialogMsg("保存异常", 'error');
				errorMsg("保存异常");
			},
			beforeSend : function() {
				dialogLoading(true);
			},
			complete : function() {
				dialogLoading(false);
			}
		});
	}, 500);
}

$.RemoveForm = function(options) {
	var defaults = {
		msg : "注：您确定要删除吗？该操作将无法恢复",
		url : "",
		param : [],
		type : "post",
		dataType : "json",
		contentType : 'application/json',
		success : null
	};
	var options = $.extend(defaults, options);
	dialogConfirm(options.msg, function() {
		dialogLoading(true);
		window.setTimeout(function() {
			var postdata = options.param;
			$.ajax({
				url : options.url,
				data : JSON.stringify(postdata),
				type : options.type,
				dataType : options.dataType,
				contentType : options.contentType,
				success : function(data) {
					if (data.statusCode == 500) {
                        dialogMsg(data.msg, "error");
					} else if (data.statusCode ==200) {
						dialogMsg(data.msg, 'success');
						options.success(data);
					}
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					dialogLoading(false);
					dialogMsg(errorThrown, 'error');
				},
				beforeSend : function() {
					dialogLoading(true);
				},
				complete : function() {
					dialogLoading(false);
				}
			});
		}, 500);
	});
}

/**
 * 初始化表单信息
 * @param options
 * @constructor
 */
$.SetForm = function(options, showLoading) {
    var defaults = {
        url : "",
        param : [],
        type : "post",
        dataType : "json",
        contentType : 'application/json',
        success : null
    };
    var options = $.extend(defaults, options);
    $.ajax({
        url : options.url,
        data : JSON.stringify(options.param),
        type : options.type,
        dataType : options.dataType,
        contentType : options.contentType,
        success : function(data) {
            if (data.statusCode == 500) {
                dialogMsg(data.msg, 'error');
            } else if (data.statusCode == 200) {
                options.success(data);
            }
        },
        error : function(XMLHttpRequest, textStatus, errorThrown) {
            dialogMsg(errorThrown, 'error');
        },
        beforeSend : function() {
            if(showLoading || showLoading === undefined){
                dialogLoading(true);
            }
        },
        complete : function() {
            dialogLoading(false);
        }
    });
}

$.ConfirmForm = function(options) {
	var defaults = {
		msg : "您确定要保存当前数据项修改操作吗？",
		url : "",
		param : {},
		type : "post",
		dataType : "json",
		contentType : 'application/json',
		success : null,
		close : true
	};
	var options = $.extend(defaults, options);
	dialogConfirm(options.msg, function() {
		$.SaveForm(options);
	});
}

$.ConfirmAjax = function(options) {
	var defaults = {
		msg : "您确定要保存当前操作结果吗？",
		url : "",
		param : {},
		type : "post",
		dataType : "json",
		contentType : options.contentType,
		success : null,
		close : true
	};
	var options = $.extend(defaults, options);
	dialogConfirm(options.msg, function() {
		dialogLoading(true);
		window.setTimeout(function() {
			var postdata = options.param;
			$.ajax({
				url : options.url,
				data : JSON.stringify(postdata),
				type : options.type,
				dataType : options.dataType,
				contentType : options.contentType,
				success : function(data) {
					if (data.statusCode == 500) {
						dialogAlert(data.msg, 'error');
					} else if (data.statusCode == 200) {
						dialogMsg(data.msg, 'success');
						options.success(data);
					}
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					dialogLoading(false);
					dialogMsg(errorThrown, 'error');
				},
				beforeSend : function() {
					dialogLoading(true);
				},
				complete : function() {
					dialogLoading(false);
				}
			});
		}, 500);
	});
}

/**
 * 提交json数据
 * @param ajaxData
 * @param requestUrl
 * @param handle
 */
function exeJsonCommand(ajaxData, requestUrl, handle) {
    $.ajax({
        type: "POST",
        cache: false,
        async: true,
        dataType: "json",
        contentType: 'application/json; charset=utf-8',//设置编码格式
        url: requestUrl+ "?currenttime=" + new Date().getTime(),
        data: JSON.stringify(ajaxData),
        success: function (returnData) {
            if (handle != null) {
                handle(returnData);
            }
            else {
                alert(returnData.msg);
            }
        }
    });
}

/**
 * 提交表单
 * @param ajaxData
 * @param requestUrl
 * @param handle
 */
function exeFormCommand(ajaxData, requestUrl, handle) {
    $.ajax({
        type: "POST",
        cache: false,
        async: true,
        dataType: "json",
        url: requestUrl,
        data: ajaxData + "&currenttime=" + new Date().getTime(),
        success: function (returnData) {
            if (handle != null) {

                handle(returnData);
            }
            else {
                alert(returnData.msg);
            }
        }
    });
}

function deleteCheckedCommand(thisButton, fieldName, requestUrl) {
    returnValue = false;
    if ($("span", thisButton).html() == "删除") {
        $("span", thisButton).html("稍后..");
        if (!window.confirm('确认要删除吗？')) {
            $("span", thisButton).html("删除");
            return;
        }
        $.ajax({
            type: "POST",
            cache: false,
            async: false,
            dataType: "json",
            url: requestUrl,
            data: $(":checked[name='" + fieldName + "']").serialize(),
            success: function (data) {
                alert(data.mess);
                if (data.state == 200) {
                    $(":checked[name='" + fieldName + "']").closest("tr").remove();
                    returnValue = true;
                }
                $("span", thisButton).html("删除");
            }
        });
    }
    return returnValue;
}


function exeSimpCommand(ajaxData, requestUrl, handle) {
    $.ajax({
        type: "POST",
        cache: false,
        async: true,
        dataType: "json",
        url: requestUrl,
        data: ajaxData + "&currenttime=" + new Date().getTime(),
        success: function (returnData) {
            if (handle != null) {
                handle(returnData);
            }
            else {
                showMsg(returnData.msg);
            }
        }
    });
}

function exeJsonSimpCommand(jsonObj, requestUrl, handle) {
    $.ajax({
        type: "POST",
        cache: false,
        async: true,
        dataType: "json",
        contentType: 'application/json; charset=utf-8',//设置编码格式
        url: requestUrl + (requestUrl.indexOf("?") > -1 ? "&currtime=" + new Date().getTime() : "?currtime=" + new Date().getTime()),
        data: JSON.stringify(jsonObj),
        success: function (returnData) {
            if (handle != null) {
                handle(returnData);
            }
            else {
                showMsg(returnData.msg);
            }
        }
    });
}