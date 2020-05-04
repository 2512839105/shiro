/**
 * 添加对话框
 * @param self
 * @param title
 * @param toUrl
 * @param formId
 * @param submitUrl
 */
function uploadModal(title, toUrl, submitUrl, formTag, excelTag, tableId,  width) {
    msgShow({
        title: title,
        url: toUrl,
        width: width ? width : 500,
        hideCloseButton:true,
        buttons: [{
            text: '导入',
            class: 'button bSuccess pinput',
            icon: 'icon-baocun',
            handler: function (event) {
                var modal = event.data.modal;
                msgConfirm("提示", "您确定要导入吗？导入后数据不能恢复！请仔细检查合对数据！", function (isConfirm) {
                    if(isConfirm){
                        importExcelData(formTag, excelTag, submitUrl, tableId, modal);
                    }
                })
            }
        }]
    });
}

/* 文件上传 */
function importExcelData(formTag, excelTag, submitUrl, tableId, modal){
    var excelName = $(excelTag).val();
    var point = excelName.lastIndexOf(".");
    var ext = excelName.substr(point+1);
    if(excelName == ""){
        errorMsg("请选择excel文件")
    }else if(ext != "xls" && ext !="xlsx" ){
        errorMsg("不是excel文件!")
    }else{
        var formData = new FormData($(formTag)[0]);
        dialogLoading(true);
        $.ajax({
            type: "POST",
            cache:false,
            processData: false,
            contentType: false,
            timeout:240000,
            dataType : "json",
            url:  submitUrl+"?v="+ new Date().getTime(),
            data: formData,
            success: function(json){
                dialogLoading(false);
                json = json || {};
                if (json.statusCode == 200) {
                    var msg = "";
                    $.each(json.data, function (i, obj) {
                        msg += obj.toString() + "\n";
                    })
                    msg ? msg : json.msg;
                    swal({
                        title: ' <small><font color="red">上传结果</font></small>',
                        text: '<textarea style="width:500px; height: 200px" autofocus>'+ msg + '</textarea>',
                        html:true,
                        customClass:'swal-win'
                    });
                    $(tableId).bootstrapTable('refresh');
                    //关闭弹框
                    $("#" + modal.id).iziModal('close');
                }else {
                    msgAlert("错误", json.msg, "error");
                    $("button.bSuccess").text("重新导入");
                }

            },error:function(msg){
                errorMsg("网络有误:"+msg);
            }
        });
    }
}


/**
 * 添加对话框
 * @param self
 * @param tableId
 * @param title
 * @param toUrl
 * @param formId
 * @param submitUrl
 */
function addModal(self, tableId, title, toUrl, formId, submitUrl, width) {
    msgDialog.call(self, '', tableId, {
        title: title,
        url: toUrl,
        width: width ? width : 900,
        buttons: [{
            text: '保存',
            class: 'button bSuccess pinput',
            icon: 'icon-baocun',
            handler: function (event) {
                var form = $(formId);
                var modal = event.data.modal;
                form.removeData("validator").removeData("unobtrusiveValidation");
                $.validator.unobtrusive.parse(form);
                if (!form.Validform()) {
                    var tabPaneId = form.find(".has-error:first").parents(".tab-pane").prop("id");
                    $('#myTab a:first').tab('show');
                    $('#myTab a:first').on('shown.bs.tab', function () {
                        $('#' + modal.id + ' form').Validform();
                    })
                    return false;
                }
                if (form.valid()) {
                    var para = form.serializeArray();
                    //提交之前禁用按钮
                    $(".bSuccess").attr("disabled", "true");
                    $.ajax({
                        url: submitUrl,
                        data: para,
                        type: "POST",
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

                } else {
                    //将验证不通过的tab显示
                    var tabPaneId = form.find(".tooltip:first").parents(".tab-pane").prop("id");
                    $('#myTab a[href="#' + tabPaneId + '"]').tab('show');
                    $('#myTab a[href="#' + tabPaneId + '"]').on('shown.bs.tab', function () {
                        $('#' + modal.id + ' form').valid();
                    })
                }
            }
        }]
    });
}


/**
 * 添加对话框
 * @param self
 * @param tableId
 * @param title
 * @param toUrl
 * @param formId
 * @param submitUrl
 */
function addModal(self, tableId, title, toUrl, formId, submitUrl, width) {
    msgDialog.call(self, '', tableId, {
        title: title,
        url: toUrl,
        width: width ? width : 900,
        buttons: [{
            text: '保存',
            class: 'button bSuccess pinput',
            icon: 'icon-baocun',
            handler: function (event) {
                var form = $(formId);
                var modal = event.data.modal;
                form.removeData("validator").removeData("unobtrusiveValidation");
                $.validator.unobtrusive.parse(form);
                if (!form.Validform()) {
                    var tabPaneId = form.find(".has-error:first").parents(".tab-pane").prop("id");
                    $('#myTab a:first').tab('show');
                    $('#myTab a:first').on('shown.bs.tab', function () {
                        $('#' + modal.id + ' form').Validform();
                    })
                    return false;
                }
                if (form.valid()) {
                    var para = form.serializeArray();
                    //提交之前禁用按钮
                    $(".bSuccess").attr("disabled", "true");
                    $.ajax({
                        url: submitUrl,
                        data: para,
                        type: "POST",
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

                } else {
                    //将验证不通过的tab显示
                    var tabPaneId = form.find(".tooltip:first").parents(".tab-pane").prop("id");
                    $('#myTab a[href="#' + tabPaneId + '"]').tab('show');
                    $('#myTab a[href="#' + tabPaneId + '"]').on('shown.bs.tab', function () {
                        $('#' + modal.id + ' form').valid();
                    })
                }
            }
        }]
    });
}

/**
 * 编辑对话框
 * @param self
 * @param data 选中的数据
 * @param tableId
 * @param title
 * @param toUrl
 * @param formId
 * @param submitUrl
 */
function editModal(self, data, tableId, title, toUrl, formId, submitUrl, width) {
    if (data.length != 1) {
        msgAlert("提示", "请选择一条数据进行操作！", "error");
        return;
    }
    msgDialog.call(self, '', tableId, {
        title: title,
        url: toUrl,
        width: width ? width : 900,
        buttons: [{
            text: '保存',
            class: 'button bSuccess pinput',
            icon: 'icon-baocun',
            handler: function (event) {
                var form = $(formId);
                var modal = event.data.modal;
                form.removeData("validator").removeData("unobtrusiveValidation");
                $.validator.unobtrusive.parse(form);
                if (!form.Validform()) {
                    var tabPaneId = form.find(".has-error:first").parents(".tab-pane").prop("id");
                    $('#myTab a[href="#' + tabPaneId + '"]').tab('show');
                    $('#myTab a[href="#' + tabPaneId + '"]').on('shown.bs.tab', function () {
                        $('#' + modal.id + ' form').Validform();
                    })
                    return false;
                }
                if (form.valid()) {
                    var para = form.serializeArray();
                    $.ajax({
                        url: submitUrl,
                        data: para,
                        type: "POST",
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
                } else {
                    //将验证不通过的tab显示
                    var tabPaneId = form.find(".tooltip:first").parents(".tab-pane").prop("id");
                    $('#myTab a[href="#' + tabPaneId + '"]').tab('show');
                    $('#myTab a[href="#' + tabPaneId + '"]').on('shown.bs.tab', function () {
                        $('#' + modal.id + ' form').valid();
                    })
                }
            }
        }]
    });
}

/**
 * 批量删除
 * @param tableId
 * @param submitUrl
 * @param modelIds
 * @param fn
 */
function deleteByIds(tableId, submitUrl, fn) {
    var data = $(tableId).bootstrapTable("getSelections");
    if (data.length == 0) {
        msgAlert("提示", "请至少选择一条数据进行操作！", "info");
        return;
    }
    if (typeof fn == "function" && fn(data)) {
        modelIds = (fn(data));
        modelIds = modelIds.substring(0, modelIds.length - 1);
        msgConfirm("确认要【删除】吗？", "【删除】后不可恢复！", function () {
            $.ajax({
                url: submitUrl,
                data: {modelIds: modelIds},
                type: "POST",
                success: function (json) {
                    json = json || {};
                    if (json.statusCode == 200) {
                        msgAlert("提示", "操作成功！", "success");
                        $("#table").bootstrapTable('refresh');
                    } else {
                        msgAlert("错误", json.msg, "error");
                    }
                }
            });
        });
    }
}


/**

 * 审批对话框

 * @param self
 * @param tableId
 * @param title
 * @param toUrl
 */
function auditModal(self, tableId, title, toUrl) {
    msgDialog.call(self, '', tableId, {
        title: title,
        url: toUrl,
        buttons: []
    }, true);
}

/**

 * 审批对话框
 * @param submitUrl
 * @param tableId
 * @param formId
 */
function audit(submitUrl, tableId, formId) {
    var form = $(formId);
    var para = form.serializeArray();
    $.ajax({
        url: submitUrl,
        data: para,
        type: "POST",
        success: function (json) {
            json = json || {};
            if (json.statusCode == 200) {
                msgAlert("提示", "操作成功！", "success");
                $(tableId).bootstrapTable('refresh');
            } else {
                msgAlert("错误", json.msg, "error");
            }
        }
    });
    //}
}



/**
 * 批量更新
 * @param tableId 表格 id
 * @param submitUrl 更新url
 * @param modelIds 表格选中主键id
 * @param title 提示内容
 * @param fn 回调函数
 * @auther charlin
 * @decription 用于表格批量更新，如审核、删除、启用、禁用等
 */
function updateByIds(tableId, submitUrl, title, fn) {
    var data = $(tableId).bootstrapTable("getSelections");
    if (data.length == 0) {
        msgAlert("提示", "请至少选择一条数据进行操作！", "info");
        return;
    }
    if (typeof fn == "function" && fn(data)) {
        modelIds = (fn(data));
        modelIds = modelIds.substring(0, modelIds.length - 1);
        msgConfirm("提示", "是否确认进行【"+title+"】操作", function () {
            $.ajax({
                url: submitUrl,
                data: {modelIds: modelIds},
                type: "POST",
                success: function (json) {
                    json = json || {};
                    if (json.statusCode == 200) {
                        msgAlert("提示", "操作成功！", "success");
                        $("#table").bootstrapTable('refresh');
                    } else {
                        errorMsg(json.msg);
                    }
                }
            });
        });
    }
}



/*
 提示框
 type:"warning","error", "success","info"
 */
function msgAlert(title, msg, type) {
    if(type == 'info') {
        type = 'warning'
    }
    if(title == '提示' && type == 'error'){
        type = 'warning'
    }
    swal({title: title, text: msg, type: type, confirmButtonText: "确认"});
}

function showMsg(msg) {
    swal({title: "提示", text: msg, type: "warning", confirmButtonText: "确认"});
}


function errorMsg(msg) {
    swal({title: "错误", text: msg, type: "error", confirmButtonText: "确认"});
}

//提示框定时消失
function msgAlertTimer(title, type, timer) {
    swal({title: title, type: type, timer: timer})
}

/*
 确认框
 */
function msgConfirm(title, msg, fun) {
    swal({
        title: title,
        text: msg,
        type: "warning",
        showCancelButton: true,
        confirmButtonColor: "#DD6B55",
        confirmButtonText: "确认",
        cancelButtonText: "取消",
        closeOnConfirm: false
    }, fun);
}


/*
 确认框，点确认后关闭
 */
function msgConfirm(title, msg, fun) {
    swal({
        title: title,
        text: msg,
        type: "warning",
        showCancelButton: true,
        confirmButtonColor: "#DD6B55",
        confirmButtonText: "确认",
        cancelButtonText: "取消",
        closeOnConfirm: true
    }, fun);
}


var dialog_zindex = 300;
/**
 *  弹框
 * @param submitUrl 提交url
 * @param tableId   提交后刷新的tableId
 * @param initOptions   弹框参数
 * @returns {boolean}
 */
function msgDialog(submitUrl, tableId, initOptions, closeFun, handleFun) {
    if (!initOptions.url) {
        alert('url为空');
        return false;
    }
    var $this = $(this);
    var modalId = '';
    if ($this.data("modalid")) {
        modalId = $this.data("modalid");
    } else {
        modalId = "modal-" + (new Date().getTime());
        var modalDiv = $('<div id="' + modalId + '" ></div>')
        $("body").append(modalDiv);
        modalId = '#' + modalId;
        $this.data("modalid", modalId);
    }

    var zindex = dialog_zindex + 2;
    var buttons = [];
    if (!isEmpty(submitUrl) && !initOptions.buttons) {
        buttons = [{
            text: '保存',
            class: 'button bSuccess',
            icon: 'icon-baocun',
            handler: function (event) {
                var modal = event.data.modal;
                var form = $('#' + modal.id + ' form');
                //如果验证没通过
                if (!form.Validform()) {
                    var tabPaneId = form.find(".has-error:first").parents(".tab-pane").prop("id");
                    $('#myTab a:first').tab('show');
                    $('#myTab a:first').on('shown.bs.tab', function () {
                        $('#' + modal.id + ' form').Validform();
                    })
                    return false;
                }
                if (form.valid()) {
                    var para = form.serializeArray();
                    $.ajax({
                        url: submitUrl,
                        data: para,
                        type: "POST",
                        success: function (json) {
                            json = json || {};
                            if (json.statusCode == 200) {
                                msgAlert("提示", "提交成功！", "success");
                                //关闭弹框
                                $("#" + modal.id).iziModal('close');
                                $(tableId).bootstrapTable('refresh');
                            } else if (json.msg) {
                                msgAlert("错误", json.msg, "error");
                            }
                            if (handleFun) {
                                handleFun(json);
                            }
                        }
                    });
                } else {
                    //将验证不通过的tab显示
                    if (('#' + modal.id + ' .tab-content').length > 0) {
                        var tabPaneId = form.find('.tooltip:first').parents('.tab-pane').prop('id');
                        $('#' + modal.id + ' .nav-tabs a[href="#' + tabPaneId + '"]').tab('show');
                        $('#' + modal.id + ' .nav-tabs a[href="#' + tabPaneId + '"]').on('shown.bs.tab', function () {
                            $('#' + modal.id + ' form').valid();
                        })
                    }
                }
            }
        }];
    } else {
    }
    var options = $.extend({
        title: '',
        headerColor: '#2C9ADB',
        width: 900,
        autoOpen: true,
        padding: '5px',
        closeButton: true,
        overlayClose: false,
        overlayColor: 'rgba(0, 0, 0, 0.6)',
        onOpening: function (modal) {
            //处理多弹出框层级问题
            var lastModel = $(modalId).prevAll(".iziModal:has(.iziModal-content)");//查找前面所有打开的弹框
            if (lastModel.length > 0) {
                zindex = parseInt(lastModel.css("z-index")) + 2;
                dialog_zindex = zindex;
                $(modalId).iziModal('setZindex', zindex);
            }
            /* modal.startLoading();*/
            $.get(setUrlParam(initOptions.url, 't', (new Date().getTime())), function (data) {
                var btnArr = new Array();
                btnArr.push($('<button id="btn-' + (new Date().getTime()) + '" type="button" data-izimodal-close="" class="button bDanger"><i class="iconfont icon-quxiao"></i>关闭</button>'));
                $.each(modal.options.buttons, function (i, n) {
                    var btn = $('<button id="btn-' + (new Date().getTime()) + '" type="button" class="' + n.class + '"><i class="iconfont ' + n.icon + '"></i>' + n.text + '</button>');
                    btn.bind("click", {modal: modal}, n.handler);
                    btn.data('modal', modal);
                    btnArr.push(btn);
                });

                data = $(data).find(".bgroup").prepend(btnArr).parents("div");
                $(modalId + " .iziModal-content").html(data);
                $(modalId + " .iziModal-content .selectpicker").selectpicker('refresh');//下拉插件
                modal.stopLoading();
            });
        },
        onOpened: function () {
            /*if (zindex > 999) {
             $(modalId).next().next().css("z-index", zindex - 1);
             }*/
        },
        onClosed: function () {
            $(modalId + " .iziModal-content").html('');
            $(modalId).iziModal('destroy');
            if (closeFun && typeof closeFun === "function") {
                closeFun();
            }
            removeMessage();
        },
        buttons: buttons
    }, initOptions || {});

    $(modalId).iziModal(options);
    zindex = dialog_zindex + 2
    dialog_zindex = zindex;
    $(modalId).iziModal('setZindex', zindex);
}

/**
 *  弹框
 * @param submitUrl 提交url
 * @param tableId   提交后刷新的tableId
 * @param initOptions   弹框参数
 * @returns {boolean}
 */
function msgShow(initOptions, openingFn) {
    if (!initOptions.url) {
        alert('url为空');
        return false;
    }
    var $this = $(this);
    var modalId = '';
    if ($this.data("modalid")) {
        modalId = $this.data("modalid");
    } else {
        modalId = "modal-" + (new Date().getTime());
        var modalDiv = $('<div id="' + modalId + '" ></div>')
        $("body").append(modalDiv);
        modalId = '#' + modalId;
        $this.data("modalid", modalId);
    }

    var zindex = dialog_zindex + 2;
    var buttons = [];
    var options = $.extend({
        title: '',
        headerColor: '#2C9ADB',
        width: 900,
        autoOpen: true,
        padding: '5px',
        closeButton: true,
        overlayClose: false,
        overlayColor: 'rgba(0, 0, 0, 0.6)',
        onOpening: function (modal) {
            //处理多弹出框层级问题
            var lastModel = $(modalId).prevAll(".iziModal:has(.iziModal-content)");//查找前面所有打开的弹框
            if (lastModel.length > 0) {
                zindex = parseInt(lastModel.css("z-index")) + 2;
                dialog_zindex = zindex;
                $(modalId).iziModal('setZindex', zindex);
            }
            //modal.startLoading();
            $.get(setUrlParam(initOptions.url, 't', (new Date().getTime())), function (data) {
                var btnArr = new Array();
                if(!initOptions.hideCloseButton){
                    btnArr.push($('<button id="btn-' + (new Date().getTime()) + '" type="button" data-izimodal-close="" class="button bDanger"><i class="iconfont icon-quxiao"></i>关闭</button>'));
                }

                var btns = modal.options.buttons;
                for (var i = 0; i < btns.length; i++) {
                    var n = btns[i];
                    var btn = $('<button id="btn-' + (n.id ? n.id : (new Date().getTime() + 1)) + '" type="button" class="' + n.class + '"><i class="iconfont ' + n.icon + '"></i>' + n.text + '</button>');
                    btn.bind("click", {modal: modal}, n.handler);
                    btn.data('modal', modal);
                    btnArr.push(btn);
                }
                data = $(data).find(".bgroup").prepend(btnArr).parents("div");
                $(modalId + " .iziModal-content").html(data);
                setTimeout(function () {
                    openingFn && typeof openingFn == "function" && openingFn(modal);
                }, 1000)
                modal.stopLoading();
            });

        },
        onOpened: function (e) {

        },
        onClosed: function () {
            $(modalId + " .iziModal-content").html('');
            $(modalId).iziModal('destroy');
            removeMessage();
        },
        buttons: buttons
    }, initOptions || {});

    $(modalId).iziModal(options);
    zindex = dialog_zindex + 2
    dialog_zindex = zindex;
    $(modalId).iziModal('setZindex', zindex);
}

//--导出相关弹框---------------------------------------------------------------------------------

/**
 * 导出
 * @param table
 * @param title
 */
function exportDatas(table, title, url) {
    var selectedData = table.bootstrapTable('getAllSelections');
    if (selectedData.length > 0) {
        $.each(selectedData, function (index, item) {
            delete item.id;
        });
        selectedData = toStringValue(selectedData);
        var jsonData = {"total": selectedData.length, "rows": selectedData};
        table.bootstrapTable('load', jsonData);
        table.tableExport({
            type: 'excel',
            fileName: title
        });
    } else {
        var params = table.bootstrapTable('getOptions');
        params.queryParams = function (params) {
            params.filters = getFiltersByForm(searchFormId);
            return params;
        }
        console.log("params.queryParams====" + params.queryParams)
        exeFormCommand(params, url, function (json) {
            var rows = json.rows;
            if (rows.length == 0) {
                errorMsg("导出失败");
                return;
            }
            msgConfirm("提示", "导出数据", function () {
                var jsonData = {"total": rows.length, "rows": rows};
                table.bootstrapTable('load', jsonData);
                table.tableExport({
                    type: 'excel',
                    escape:'true',
                    htmlContent:'true',
                    fileName: title
                });
            })
        })
    }
    table.bootstrapTable('refresh');
}


/**
 * 导出
 * @param table
 * @param title
 */
function exportList(table, title) {
    var selectedData = table.bootstrapTable('getAllSelections');
    if (selectedData.length > 0) {
        $.each(selectedData, function (index, item) {
            delete item.id;
        });
        //var jsonArr=JSON.stringify(selectedData);
        var jsonData = {"total": selectedData.length, "rows": selectedData};
        table.bootstrapTable('load', jsonData);
        table.tableExport({
            type: 'excel',
            fileName: title
        });
    } else {
        var allData = table.bootstrapTable('getData');
        if (allData.length == 0) {
            msgAlert("提示", "当前页面没有数据", "warning");
            return;
        }
        msgConfirmClose("提示", "导出当前页面所有数据,\n一次最多可导出1000条数据,选择每页显示\'1000\'条记录", function () {
            var jsonData = {"total": allData.length, "rows": allData};
            table.bootstrapTable('load', jsonData);
            table.tableExport({
                type: 'excel',
                fileName: title
            });
        })
    }
    table.bootstrapTable('refresh');
}

/**
 * 导出父子表
 * @param table 主表
 * @param title 导出主表表名
 * @param url 明细url地址
 * @param tableDetail 明细表
 * @param column 导出表时显示隐藏列
 * @param primaryKey 对应单号字段
 */
function exportDetailList(table, title, url, tableDetail,column,primaryKey) {
    var selectedData = table.bootstrapTable('getAllSelections');
    if (selectedData.length > 0) {
        $.each(selectedData, function (index, item) {
            delete item.id;
        });
        var jsonData = {"total": selectedData.length, "rows": selectedData};
        var rows = jsonData.rows;
        var urlData = ""
        var data = new Array();
        for(var inx in rows) {
            var param = new Object();
            param.name = primaryKey;
            param.value = rows[inx][primaryKey];
            data.push(param);
        }
        //发送请求，获取所有主表对应的明细数据
        $.ajax({
            url: url,
            type: "POST",
            data: data,
            success: function (json) {
                tableDetail.bootstrapTable('showColumn',column)
                tableDetail.bootstrapTable('load', json);
                tableDetail.tableExport({
                    type: 'excel',
                    fileName: title + "明细"
                });
                tableDetail.bootstrapTable('hideColumn',column)
                tableDetail.bootstrapTable('refresh');
            }
        });
        table.bootstrapTable('load', jsonData);
        table.tableExport({
            type: 'excel',
            fileName: title
        });
    } else {
        var allData = table.bootstrapTable('getData');
        if (allData.length == 0) {
            msgAlert("提示", "当前页面没有数据", "warning");
            return;
        }
        msgConfirmClose("提示", "导出当前页面所有数据,\n一次最多可导出1000条数据,选择每页显示\'1000\'条记录", function () {
            var jsonData = {"total": allData.length, "rows": allData};
            var rows = jsonData.rows;
            var urlData = ""
            var data = new Array();
            for(var inx in rows) {
                var param = new Object();
                param.name = primaryKey;
                param.value = rows[inx][primaryKey];
                data.push(param);
            }
            //发送请求，获取所有主表对应的明细数据
            $.ajax({
                url: url,
                type: "POST",
                data: data,
                success: function (json) {
                    tableDetail.bootstrapTable('showColumn',column)
                    tableDetail.bootstrapTable('load', json);
                    tableDetail.tableExport({
                        type: 'excel',
                        fileName: title + "明细"
                    });
                    tableDetail.bootstrapTable('hideColumn',column)
                    tableDetail.bootstrapTable('refresh');
                }
            });
            table.bootstrapTable('load', jsonData);
            table.tableExport({
                type: 'excel',
                fileName: title
            });
        })
    }
    table.bootstrapTable('refresh');
}

//--layUi弹出框---------------------------------------------------------------------------------
dialogOpen = function (opt) {
    var defaults = {
        id: 'layerForm',
        title: '',
        width: '',
        height: '',
        url: null,
        scroll: false,
        data: {},
        btn: ['确定', '取消'],
        success: function () {
        },
        yes: function () {
        }
    }
    var option = $.extend({}, defaults, opt), content = null;
    if (option.scroll) {
        content = [option.url]
    } else {
        content = [option.url, 'no']
    }
    layer.open({
        type: 2,
        id: option.id,
        title: option.title,
        closeBtn: 1,
        anim: -1,
        isOutAnim: false,
        shadeClose: false,
        shade: 0.3,
        area: [option.width, option.height],
        content: content,
        btn: option.btn,
        success: function () {
            option.success(option.id);
        },
        yes: function () {
            option.yes(option.id);
        }
    });
}

dialogContent = function (opt) {
    var defaults = {
        title: '系统窗口',
        width: '',
        height: '',
        content: null,
        data: {},
        btn: ['确定', '取消'],
        success: null,
        yes: null
    }
    var option = $.extend({}, defaults, opt);
    return layer.open({
        type: 1,
        title: option.title,
        closeBtn: 1,
        anim: -1,
        isOutAnim: false,
        shadeClose: false,
        shade: 0.3,
        area: [option.width, option.height],
        shift: 5,
        content: option.content,
        btn: option.btn,
        success: option.success,
        yes: option.yes
    });
}

dialogAjax = function (opt) {
    var defaults = {
        title: '系统窗口',
        width: '',
        height: '',
        url: null,
        data: {},
        btn: ['确定', '取消'],
        success: null,
        yes: null
    }
    var option = $.extend({}, defaults, opt);
    $.post(option.url, null, function (content) {
        layer.open({
            type: 1,
            title: option.title,
            closeBtn: 1,
            anim: -1,
            isOutAnim: false,
            shadeClose: false,
            shade: 0.3,
            area: [option.width, option.height],
            shift: 5,
            content: content,
            btn: option.btn,
            success: option.success,
            yes: option.yes
        });
    });
}

dialogAlert = function (content, type) {
    var msgType = {
        success: 1,
        error: 2,
        warn: 3,
        info: 7
    };
    if (isNullOrEmpty(type)) {
        type = 'info';
    }
    layer.alert(content, {
        icon: msgType[type],
        title: "系统提示",
        anim: -1,
        btnAlign: 'c',
        isOutAnim: false
    });
}

dialogConfirm = function (content, callBack) {
    layer.confirm(content, {
        area: '338px',
        icon: 7,
        anim: -1,
        isOutAnim: false,
        title: "系统提示",
        btn: ['确认', '取消'],
        btnAlign: 'c',
        yes: callBack
    });
}

dialogMsg = function (msg, type) {
    var msgType = {
        success: 1,
        error: 2,
        warn: 3,
        info: 7
    };
    if (isNullOrEmpty(type)) {
        type = 'info';
    }
    layer.msg(msg, {
        icon: msgType[type],
        time: 2500
    });
}

dialogClose = function () {
    var index = layer.getFrameIndex(window.name); //先得到当前iframe层的索引
    layer.close(index); //再执行关闭
}

dialogLoading = function (flag) {
    if (flag) {
        layer.load(0, {
            shade: [0.1, '#fff'],
            time: 1000
        });
    } else {
        layer.closeAll('loading');
    }
}



