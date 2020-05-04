/*
 * 功能：格式化大额数字
 * 作者：大雄
 * */
function formatNumWan (value){
	return typeof Number(value) !== 'number' ? value : (parseInt(value) > 9999 ? Math.floor(value/1000)/10 + '万' : value);
}

function toInt(str) {
    var value = parseInt(str, 10);
    if (isNaN(value)) {
        value = 0;
    }
    return value;
}

function trim(str) {
    if (str != null)
        return str.replace(/^\s+|\s+$/g, "");
    else
        return "";
}


function toStr(strValue) {
    if (strValue != null)
        return trim(strValue.toString());
    else
        return "";
}

function isEmpty(strValue) {
    if (strValue != "" && strValue != null && strValue != undefined) {
        return false;
    }
    return true;
}

function toDouble(str) {
    var value = parseFloat(str);
    if (isNaN(value)) {
        value = 0;
    }
    return value;
}

function isIntNum(val){
	var regPos = / ^\d+$/; // 非负整数
	var regNeg = /^\-[1-9][0-9]*$/; // 负整数
	if(regPos.test(val) || regNeg.test(val)){
		return true;
	}else{
		return false;
	}
}

function isNumber(val){

	var regPos = /^\d+(\.\d+)?$/; //非负浮点数
	var regNeg = /^(-(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*)))$/; //负浮点数
	if(regPos.test(val) || regNeg.test(val)){
		return true;
	}else{
		return false;
	}

}

function formatNum(num, fix) {
    if (typeof(fix) == "undefined") {
        fix = 2;
    }
    return num.toFixed(fix);
}

function rgExpValidate(str, pattern) {
    var re = new RegExp(pattern, "ig");
    if (str != null && str.match(re)) {
        return true;
    }
    return false;
}


function required(fieldValue) {
    var value = trim(fieldValue);
    if (value.length > 0)
        return true;
    else
        return false;
}


function validateEmail(email) {

    if (!required(email) || email.indexOf('<') > -1) {
        return false;
    }
    if (!rgExpValidate(email, "\\w+([-+.\']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*")) {
        return false;
    }
    return true;
}


function validateSelectCheckBox(fieldName) {
    var fieldArray = document.getElementsByName(fieldName);
    for (var i = 0; i < fieldArray.length; i++) {
        if (fieldArray[i].checked)
            return true;
    }
    return false;
}


/**
 *全选
 */
function selectAll(checked, fieldName) {
    $(":checkbox[name='" + fieldName + "']").attr('checked', checked);
}


/**
 *Checkbox做单选
 */
function chooseCheckbox(thisCheckbox, checkboxs) {
    if (thisCheckbox.checked) {
        if (!checkboxs) {
            checkboxs = thisCheckbox.name;
        }
        var checkboxArray = checkboxs.split(",");
        for (var i = 0; i < checkboxArray.length; i++) {
            $(":checkbox[name='" + checkboxArray[i] + "']").attr("checked", false);
        }
        thisCheckbox.checked = true;
    }
}

/**
 *全选,记录编号
 */
function selectMultiRecord(thisButton, sourseField, descField) {
    $(":checkbox[name='" + sourseField + "']").attr('checked', thisButton.checked);
    //逐条处理
    $(":checkbox[name='" + sourseField + "']").each(function () {
        selectRecord(this, descField);
    });
}


/**
 *单个选取，记录编号
 */
function selectRecord(thisButton, descField) {
    var values = $("#" + descField).val();
    var existIndex = values.indexOf(";" + thisButton.value + ";")
    //追加
    if (thisButton.checked) {
        if (existIndex == -1) {
            if (values.length == 0) {
                $("#" + descField).val(";");
            }
            $("#" + descField).val($("#" + descField).val() + thisButton.value + ";");
        }
    }
    //缩减
    else {
        if (existIndex != -1) {
            $("#" + descField).val(values.substring(0, existIndex) + values.substr(existIndex + thisButton.value.length + 1));
        }
    }
}


function isInt(str) {
    if (str.match(/[^0-9]/g)) {
        return false;
    }
    return true;
}


function isDecimal(str) {
    if (str.match(/[^0-9.]/g)) {
        return false;
    }
    if (str.length > 0 && (str.indexOf(".") == 0 || str.indexOf(".") == str.length - 1 || str.indexOf(".") != str.lastIndexOf("."))) {
        return false;
    }
    return true;
}


function checkForm(formEle) {
    var formField = $(formEle).get(0);
    for (var index = 0; index < formField.elements.length; index++) {
        if (!checkField(formField.elements[index])) {
            return false;
        }
    }
    return true;
}


function checkFields(parentNode) {
    returnValue = true;
    $(":input", parentNode).each(function (i) {
        if (!checkField(this)) {
            returnValue = false;
            return false;
        }
    });
    return returnValue;
}


function checkField(fieldEle) {
    var field = $(fieldEle).get(0);
    if (!field) {
        alert("没有找到对应的栏位" + fieldEle);
        return false;
    }
    if (field.disabled) {
        return true;
    }
    var checkType = toStr(field.getAttribute("checkType")).toUpperCase();
    if (checkType.length < 1) {
        return true;
    }
    field.value = trim(field.value);
    if (checkType.indexOf('R') > -1) {
        if (!required(field.value)) {
            if (!showDialog(field, "R")) {
                return false
            }
        }
    }
    if (checkType.indexOf('I') > -1) {
        if (!isInt(field.value)) {
            if (!showDialog(field, "I")) {
                return false
            }
        }
    }
    if (checkType.indexOf('D') > -1) {
        if (!isDecimal(field.value)) {
            if (!showDialog(field, "D")) {
                return false
            }
        }
    }
    //数字或字母
    if (checkType.indexOf('LN') > -1) {
        if (!isLetterNumber(field.value)) {
            if (!showDialog(field, "LN")) {
                return false
            }
        }
    }
    //长度size
    if (checkType.indexOf('S') > -1) {
        var maxLength = toInt(checkType.slice(checkType.indexOf('(') + 1, checkType.indexOf(')')));
        if (trim(field.value).length > maxLength) {
            if (!showDialog(field, "S", maxLength)) {
                return false
            }
        }
    }
    return true;
}

function isLetterNumber(value) {
    if (value.match(/[^A-Za-z0-9\u4e00-\u9fa5\s]/g)) {
        return false;
    }
    return true;
}

function getMess(key, mess) {
    if (mess.indexOf(key) > -1) {

        var re = new RegExp(key + "\{(\.+?)\}", "ig");
        var resultArray = re.exec(mess);
        if (resultArray != null && resultArray.length > 1) {
            return resultArray[1];
        }
        else {
            return mess;
        }
    }
    else {
        return mess;
    }
}


function showDialog(field, key, desc) {
    var mess = null;
    var label = $("label[for='" + field.getAttribute("name") + "']");
    if (field.getAttribute("mess") != null) {
        mess = getMess(key, field.getAttribute("mess"));
    }
    else if (label.size() > 0) {
        if ("R" == key) {
            mess = "请填写" + label.html();
        }
        else if ("I" == key) {
            mess = label.html() + "必须是整数";
        }
        else if ("D" == key) {
            mess = label.html() + "不是有效的数字";
        }
        else if ("LN" == key) {
            mess = label.html() + "必须是数字或字母";
        }
        else if ("S" == key) {
            mess = label.html() + "的长度不可超过" + desc + "个字符";
        }
    }
    else {
        alert(field.getAttribute("id") + "无mess");
    }
    var dialogType = field.getAttribute("checkType").toUpperCase();
    if (dialogType.indexOf('C') > -1) {
        if (!window.confirm(mess)) {
            return false;
        }
    }
    else {
        sy.alertMsg(mess + "!");
        try {
            field.select();
            field.focus();
        }
        catch (e) {
        }
        return false;
    }
    return true;
}

function getContent(fieldName) {
    var oEditor = FCKeditorAPI.GetInstance(fieldName);
    return $.trim(oEditor.GetXHTML(true));
}


function fckOnload(fck) {
    $('#ubbloading').hide();
    if (fck.src.length > 0) {
        $('#pk_content').hide();
        $(fck).show();
    }
}


function resetForm(resetField, isAlter) {
    resetFields($(resetField).closest('table'), isAlter);
}

function resetFields(resetFields, isAlter) {
    if (isAlter && !window.confirm('确定要清空吗？')) {
        return;
    }
    //清空表頭欄位
    $("select,:text,:file,textarea,input[type='hidden']", $(resetFields)).each(
        function () {
            //alert(this.value);
            this.value = '';
        }
    );
}


function validateFile(suffix, thisFilesuffix) {
    if (thisFilesuffix.length < 1) {
        alert('请正确选择文件！');
        return false;
    }
    var re = new RegExp(".*\\b" + thisFilesuffix + "\\b.*", "ig");
    if (!suffix.match(re)) {
        alert("文件格式仅能是如下几种: " + suffix);
        return false;
    }
    return true;
}


function disabletForm() {
    $(':button').each(function () {
            this.disabled = true;
        }
    );
}

function submitFileForm(fileType) {
    if ($.trim(document.uploadfileForm.title.value).length < 1) {
        alert('请输入标题文件！');
        document.uploadfileForm.title.focus();
        return false;
    }
    if ($.trim(document.uploadfileForm.memo.value).length > 200) {
        alert('备注不可大于200个字符！');
        document.uploadfileForm.memo.focus();
        return false;
    }
    if (document.uploadfileForm.uploadfile.value.length < 1) {
        alert('请选择上传的文件！');
        return false;
    }
    if (!validateFile(fileType, document.uploadfileForm.uploadfile.value.replace(/.+\./g, ''))) {
        return false;
    }
    disabletForm();
    document.uploadfileForm.submit();
}


$(this).ajaxError(function (event, xMLHttpReq, ajaxOptions, thrownError) {
    if (xMLHttpReq != null && xMLHttpReq.status != 0) {
        alert(xMLHttpReq.status + "系统超时!，请刷新页面!");
    } else {
        //alert("操作错误，请刷新页面!");
    }
});


$(this).ajaxComplete(function (event, xhr, settings) {
    if (xhr.responseText == 'timeOut') {
        window.location = "http://" + window.location.host;
    }
});


function customCancelBubble(evt) {
    var e = (evt) ? evt : window.event;
    if (window.event) {
        e.cancelBubble = true;
    }
    else {
        e.stopPropagation();
    }
}


function expansion(thisButton, areaObj) {
    var imgsrc = $("img", thisButton).attr("src");
    if (imgsrc.indexOf("/images/expansion.gif") != -1) {
        $("img", thisButton).attr("src", imgsrc.substring(0, imgsrc.indexOf("/images/expansion.gif")) + "/images/notExpansion.gif");
        $(thisButton).closest("fieldset").css("padding-bottom", "15px");
    }
    else {
        $("img", thisButton).attr("src", imgsrc.substring(0, imgsrc.indexOf("/images/notExpansion.gif")) + "/images/expansion.gif");
        $(thisButton).closest("fieldset").css("padding-bottom", "5px");
    }
    areaObj.toggle();
}


function closeSignWin() {
    $("#fullForm").remove();
    $("#signWin").remove();
}


function cancelOnclick(evt) {
    var e = (evt) ? evt : window.event;
    if (window.event) {
        e.cancelBubble = true;
    }
    else {
        e.stopPropagation();
    }
}

function onDrag(e) {
    var d = e.data;
    d.left = repair(d.left);
    d.top = repair(d.top);

    function repair(v) {
        var r = parseInt(v / 20) * 20;
        if (Math.abs(v % 20) > 10) {
            r += v > 0 ? 20 : -20;
        }
        return r;
    }
}

function downloadFileEle(value, rowData, rowIndex) {
    var div = '<a href="#" onclick="return downloadFile(\'' + rowData.filePath + '\');">' + value + '</a>';
    return div;
}

function downloadFile(filePath) {
    if (!filePath || filePath.lastIndexOf(".") < 0) {
        alert("文件路径有误");
    } else {
        var namesub = filePath.substr(filePath.lastIndexOf(".") + 1).toLowerCase();
        if (namesub == "jpg" || namesub == "jpeg" || namesub == "gif" || namesub == "png" || namesub == "jpg") {
            //top.sy.dialogSimp({width:700,height:500,title:'查看子明细', href : filePath});
            window.open(filePath, '_blank');
        } else {
            window.open('/workflow/central!exportFile.action?filePath=' + filePath, '_self');
        }
    }
    return false;
}


function formatProgress(value) {
    if (value) {
        var s = '<div style="width:100%;border:1px solid #ccc">' +
            '<div style="width:' + value + '%;background:#58A307;color:#000">' + value + '%' + '</div>'
        '</div>';
        return s;
    } else {
        return '';
    }
}

/**
 * //封装bootstrapTable初始化方法
 * height:$(window).height() - $("#toolbar").height() - 60,
 * 示例;请看views/purchase/list.jsp
 * @param tableId 主表
 * @param initOptions 参数
 * @param detailTableId 明细表
 * @param fn1 主要处理点击主表加载明细表内容
 * @param fn2 初始时主表加载明细表内容
 */
function initBootstrapTable(tableId, initOptions, detailTableId, fn1, fn2) {
    var options = $.extend({
        pagination: true,
        pageNumber: 1,
        pageList: [10, 25, 50, 100, 500, 1000],
        pageSize: 10,
        sidePagination: "server",
        showToggle: false,//显示切换按钮
        search: false, //不显示 搜索框
        showColumns: true, //不显示下拉框（选择显示的列）
        smartDisplay: false,//智能显示分页按钮
        paginationPreText: "上一页",
        paginationNextText: "下一页",
        method: "post",
        clickToSelect: true,
        sortName: "createDate",
        showExport: true,
        exportTypes: ['excel', 'csv', 'txt'],
        sortOrder: "desc",
        formatNoMatches: function () {
            return "暂无数据";
        },
        onLoadError: function (status) {
            $(tableId).bootstrapTable('removeAll');
            alert("请求出错，请稍后再试");
        },
        formatLoadingMessage: function () {
            return "请稍等，正在加载中...";
        },
        responseHandler: function (res) {
            if (res.statusCode && res.statusCode != 200) {
                alert(res.msg);
                return null;
            }
            return res;
        },
        onClickRow: function (row, $element, field) {
            $(tableId).bootstrapTable("uncheckAll");
            $(tableId).bootstrapTable("check", $element.data('index'));
            if (detailTableId) {
                typeof fn1 == "function" && fn1(row);
            }
            return false;
        },
        onCheck: function (row) {
            if (detailTableId) {
                var count = 0;
                $(tableId).find("input:checkbox[name=btSelectItem]:checked").each(function (i) {
                    count++;
                });
                if (count > 1) {
                    typeof fn1 == "function" && fn1("");
                } else {
                    typeof fn1 == "function" && fn1(row);
                }
            }
        },
        onCheckAll: function (rows) {
            if (detailTableId) {
                $(detailTableId).bootstrapTable("removeAll");
            }
        },
        onDblClickRow: function (row, $element) {
            $(tableId).bootstrapTable("uncheckAll");
            $(tableId).bootstrapTable("check", $element.data('index'));
            if (detailTableId) {
                typeof fn1 == "function" && fn1(row);
            }
            //如果编辑按钮存在，就触发事件
            if ($("#btnEdit")) {
                //如果有模态框打开就返回不触发事件
                if ($(".iziModal").css('display') == 'block') {
                    return
                }
                $("#btnEdit").trigger("click")
            }
        },
        onUncheck: function (row, $element) {
            if (detailTableId) {
                var count = 0;
                $(tableId).find("input:checkbox[name=btSelectItem]:checked").each(function (i) {
                    count++;
                });
                if (count == 1) {
                    var checkedRow = $(tableId).bootstrapTable("getSelections");
                    typeof fn1 == "function" && fn1(checkedRow[0]);
                } else {
                    $(detailTableId).bootstrapTable("removeAll");
                }
            }
        },
        onPostBody: function () {
      		document.onkeyup = function(e){
   	       		 var e = window.event || e || e.which;
   	       		 var currKey = e.keyCode||e.charCode;
   	       		 //如果有模态框打开就返回不触发事件
               	 if($(".iziModal").css('display') == 'block'){
               		return
               	 }
   	       		 if(e && currKey == 37) {
   	       			 $(tableId).bootstrapTable('prevPage')
   	       		 }else if(e && currKey == 39){
   	       			 $(tableId).bootstrapTable('nextPage')
   	       		 }
           	}

            //默认选中第一行
            if (detailTableId) {
                var data = $(tableId).bootstrapTable("getData");
                if (data.length > 0) {
                    $(tableId).bootstrapTable("check", 0);
                    var defaultSelectRows = $(tableId).bootstrapTable("getSelections");
                    if (fn2) {
                        typeof fn2 == "function" && fn2(defaultSelectRows[0]);
                    } else {
                        typeof fn1 == "function" && fn1(defaultSelectRows[0]);
                    }
                }
            }
            
            $(tableId).bootstrapTable("resetWidth");
        }
    }, initOptions || {});
    //options.url +='?t='+ new Date().getTime();
    options.url = setUrlParam(options.url, "t", new Date().getTime());
    $(tableId).bootstrapTable(options);
    return $(tableId);
}

//删除行
function deleteSelect(obj, tableId) {
    var $this = $(obj);
    var tr = $this.parents("tr");
    var index = tr.data("index");
    var uqid = tr.data("uniqueid");
    $(tableId).bootstrapTable("removeByUniqueId", uqid);
}

//确认选择并赋值
function selectDataConfirm(data, tableId) {
    if (typeof selectedProduct === 'function') {
        //关闭弹窗
        var modal = $(tableId).parents(".iziModal");
        selectedProduct(data, modal);
    }
}

//searchForm和bootstrapTable结合的搜索方法
function tableSearch(tableId, searchFormId, url) {
    var params = $(tableId).bootstrapTable('getOptions');
    if (url) {
        params.url = url;
    }
    params.url = setUrlParam(params.url, "t", new Date().getTime());
    params.queryParams = function (params) {
        params.filters = getFiltersByForm(searchFormId);
        return params;
    }
    $(tableId).bootstrapTable('refresh', params)
}

function getFiltersByForm(searchFormId) {
    var filters = new Array();
    var j = 0;
    $.each($("form" + searchFormId + " input,form" + searchFormId + " select,form" + searchFormId + " checked"), function (i, n) {
        var field = $(n);
        op = field.attr("data-op");
        if (op) {
            if (field[0].nodeName == "SELECT") {
                if (field.val() != '-1' && field.val() != '') {
                    filters[j] = {field: field.attr("name"), data: field.val(), op: op};
                    j++;
                }
            } else {
                if (field.val()) {
                    //如果是日期字段
                    if (field.parent().hasClass("pdate") && (op == "LE" || op == "LT")) {
                        filters[j] = {field: field.attr("name"), data: field.val() + " 23:59:59", op: op};
                    } else {
                        filters[j] = {field: field.attr("name"), data: field.val(), op: op};
                    }

                    j++;
                }
            }
        }
    });
    //params.Filters = [{ Field: 'BS_EntryName', Data: '11', op: 'like' }];
    return filters;
}

//searchForm和bootstrapTable结合的搜索方法
function bootstrapTableSearch(tableId, searchFormId) {
    var params = $(tableId).bootstrapTable('getOptions');
    params.queryParams = function (params) {
        eval("params.page=" + params.pageNumber);
        eval("params.rows=" + params.pageSize);
        var j = 2;
        $.each($("form" + searchFormId).serializeArray(), function (i, field) {
            var str = "params." + field.name + "='" + field.value + "'";
            eval(str);
            j++;
        });
        return params;
    }
    $(tableId).bootstrapTable('refresh', params);
}



/*
 初始化图片上传
 fileListId：图片列表容器Id，
 filePickerId：选择图片按钮Id
 valueId：上传成功后存放图片路径Id
 */
function initImageUploader(fileListId, filePickerId, valueId) {
    var $fileList = $(fileListId),
        //优化retina, 在retina下这个值是2
        ratio = window.devicePixelRatio || 1,
        //缩略图大小
        thumbnailWidth = 100 * ratio,
        thumbnailHeight = 100 * ratio,
        //Web Uploader实例
        uploader;

    // 初始化Web Uploader
    uploader = WebUploader.create({
        auto: true,// 自动上传。
        swf: '/js/Uploader.swf',//swf文件路径
        server: '/base/file/fileUpload.action',// 文件接收服务端。
        //选择文件的按钮。可选。
        //内部根据当前运行是创建，可能是input元素，也可能是flash.
        pick: {
            id: filePickerId,
            multiple: false
        },
        accept: {//只允许选择文件，可选。
            title: '图片',
            extensions: 'gif,jpg,jpeg,bmp,png',
            mimeTypes: 'image/gif,image/jpeg,image/jpg,image/png,image/bmp'
        }
    });
    //当有文件添加进来的时候
    uploader.on('fileQueued', function (file) {
        var $li = $(
                '<div id="' + file.id + '" class="file-item thumbnail">' +
                '<img>' +
                '<div class="info">' + file.name + '</div>' +
                '</div>'
            ),
            $img = $li.find('img');
        $fileList.html('');
        $fileList.append($li);

        //创建缩略图
        uploader.makeThumb(file, function (error, src) {
            if (error) {
                $img.replaceWith('<span>不能预览</span>');
                return;
            }
            $img.attr('src', src);
        }, thumbnailWidth, thumbnailHeight);
    });

    //文件上传过程中创建进度条实时显示。
    uploader.on('uploadProgress', function (file, percentage) {
        var $li = $('#' + file.id),
            $percent = $li.find('.progress span');
        //避免重复创建
        if (!$percent.length) {
            $percent = $('<p class="progress"><span></span></p>')
                .appendTo($li)
                .find('span');
        }
        $percent.css('width', percentage * 100 + '%');
    });

    // 文件上传成功，给item添加成功class, 用样式标记上传成功。
    uploader.on('uploadSuccess', function (file, response) {
        var $li = $('#' + file.id),
            $error = $li.find('div.success');
        if (response.statusCode == 200) {
            $('#' + file.id).addClass('upload-state-done');
            // 避免重复创建
            if (!$error.length) {
                $error = $('<div class="success"></div>').appendTo($li);
            }
            $(valueId).val(response.data);
            $error.text('上传成功');
        } else {
            // 避免重复创建
            if (!$error.length) {
                $error = $('<div class="error"></div>').appendTo($li);
            }
            $error.text(response.msg);
        }
    });

    // 文件上传失败，现实上传出错。
    uploader.on('uploadError', function (file) {
        var $li = $('#' + file.id),
            $error = $li.find('div.error');

        // 避免重复创建
        if (!$error.length) {
            $error = $('<div class="error"></div>').appendTo($li);
        }

        $error.text('上传失败');
    });


    //完成上传完了，成功或者失败，先删除进度条。
    uploader.on('uploadComplete', function (file) {
        $('#' + file.id).find('.progress').remove();
    });
}


/*
 初始化文件上传
 fileListId：图片列表容器Id，
 filePickerId：选择图片按钮Id
 valueId：上传成功后存放图片路径Id
 */
function initFileUploader(fileListId, filePickerId, valueId) {
    var $fileList = $(fileListId),
        //优化retina, 在retina下这个值是2
        ratio = window.devicePixelRatio || 1,
        //Web Uploader实例
        uploader;

    // 初始化Web Uploader
    uploader = WebUploader.create({
        auto: true,// 自动上传。
        swf: '/file/admin/js/Uploader.swf',//swf文件路径
        server: '/base/file/fileUpload.action',// 文件接收服务端。
        //选择文件的按钮。可选。
        //内部根据当前运行是创建，可能是input元素，也可能是flash.
        pick: filePickerId
    });
    // 当有文件被添加进队列的时候
    uploader.on('fileQueued', function (file) {
        var $list = $('<div id="' + file.id + '" class="item">' +
            '<h4 class="info">' + file.name + '</h4>' +
            '<p class="state">等待上传...</p>' +
            '</div>');

        $fileList.html('');
        $fileList.append($list);
    });

    // 文件上传过程中创建进度条实时显示。
    uploader.on('uploadProgress', function (file, percentage) {
        var $li = $('#' + file.id),
            $percent = $li.find('.progress .progress-bar');

        // 避免重复创建
        if (!$percent.length) {
            $percent = $('<div class="progress progress-striped active">' +
                '<div class="progress-bar" role="progressbar" style="width: 0%">' +
                '</div>' +
                '</div>').appendTo($li).find('.progress-bar');
        }
        $li.find('p.state').text('上传中...');
        $percent.css('width', percentage * 100 + '%');
    });

    //文件上传成功，给item添加成功class, 用样式标记上传成功。
    uploader.on('uploadSuccess', function (file, response) {
        $('#' + file.id).find('p.state').text('已上传');
        $('#' + file.id).addClass('upload-state-done');
        var nameId = valueId + "_Name";//名称
        if ($(nameId).length > 0) {//存在文件名称保存控件
            $(nameId).val(file.name);
        }
        $(valueId).val(response.data);
    });

    //文件上传失败，现实上传出错。
    uploader.on('uploadError', function (file) {
        var $li = $('#' + file.id),
            $error = $li.find('div.error');
        // 避免重复创建
        if (!$error.length) {
            $error = $('<div class="error"></div>').appendTo($li);
        }
        $error.text('上传失败');
    });

    //完成上传完了，成功或者失败，先删除进度条。
    uploader.on('uploadComplete', function (file) {
        $('#' + file.id).find('.progress').remove();
        $('#' + file.id).find('.state').remove();
    });
}

//---bootstraptable格式化------------------------------------------------------------------------------------------

/*
 格式化Checkbox
 */
function formatterCheckbox(value, row, index) {
    return '<input type="checkbox" ' + (value == 1 ? 'checked="checked"' : '') + '" disabled="disabled" />';
}

/*
 格式化Checkbox
 */
function formatterAmount(value, row, index) {
    return fixNum(value);
}

/**
 *
 * 格式化状态
 * @param value
 * @param row
 * @param index
 * @returns {string}
 */
function formatterStatus(value, row, index) {
    return value == 1 ? '<span class="radiu5 audit bSuccess">是</span>' : '<span class="radiu5 audit bDanger">否</span>';
}

/**
 * 格式启用禁用
 * @param value
 * @param row
 * @param index
 * @returns {string}
 */
function formatterState(value, row, index) {
    return value == 1 ? '<span class="radiu5 audit bSuccess">正常</span>' : '<span class="radiu5 audit bDanger">停用</span>';
}

function formatterNull(value, row, index) {
    return value == null ? '' : value;
}

/**
 * 格式化促销
 * @param value
 * @param row
 * @param index
 * @returns {string}
 */
function formatterPromotion(value, row, index) {
    return value == 1 ? '<span class="radiu5 audit bDanger" onclick="showPromotion()">促</span>' : (value == 2) ? '<span class="radiu5 audit bGray"">促</span>' : '-';
}

/**
 * 格式化促销
 * @param value
 * @param row
 * @param index
 * @returns {string}
 */
function formatterHasPromotion(value, row, index) {
    return value == 1 ? '<span class="radiu5 audit bDanger" onclick="showPromotion()">有</span>' : '-';
}

/**
 * 格式化退货
 * @param value
 * @param row
 * @param index
 * @returns {string}
 */
function formatterReturnStatus(value, row, index) {
    return (value == 0 || value == null) ? '<span class="radiu5 audit bSuccess">无</span>' : '<span class="radiu5 audit bDanger">有</span>';
}

/**
 * 格式化显示明细
 * @param value
 * @param row
 * @param index
 * @returns {string}
 */
function formatterOperation(value, row, index) {
    return '<a class="a3" href="#" onclick="showDetail(' + row + ')"><i class="iconfont icon-yulan""></i>预览</a>';
}

/*
 格式化审核状态
 */
function formatterAuditState(value, row, index) {
    return value == 1 ? '<span class="radiu5 audit bSuccess">通过</span>' :
        (value == -1 ? '<span class="radiu5 audit bDanger">未通过</span>' : '<span class="radiu5 audit bDanger">未审核</span>');
}

/*
 格式化审批终止
 */
function formatterIsAudit(value, row, index) {
    return value == 1 ? '<span class="radiu5 audit bDanger">终止</span>' :
        '<span class="radiu5 audit bDefault">终止</span>';
}
/*
 格式化性别
 */
function formatterSex(value, row, index) {
    return value == 1 ? "男" : (value == 2 ? "女" : "其它");
}

/**
 * 格式化表格序号
 */
function formatterIndex(value, row, index) {
    var pageSize = $('#table').bootstrapTable('getOptions').pageSize;//通过表的#id 可以得到每页多少条
    var pageNumber = $('#table').bootstrapTable('getOptions').pageNumber;//通过表的#id 可以得到当前第几页

    //判断是否为数字
    if (!$.isNumeric(pageSize))
        pageSize = 0;

    return pageSize * (pageNumber - 1) + index + 1;
}

/**
 * 格式化支付方式
 * @param value
 * @param row
 * @param index
 * @returns {string}
 */
function formatterPayMethod(value, row, index) {
    var result = "";
    switch (value) {
        case 1:
            result = '<span class="radiu5 audit bPrimary">现金</span>'
            break;
        case 2:
            result = '<span class="radiu5 audit bSuccess">支付宝</span>'
            break;
        case 3:
            result = '<span class="radiu5 audit bInfo">微信</span>'
            break;
        case 4:
            result = '<span class="radiu5 audit bWarning">银联</span>'
            break;
        case 5:
            result = '<span class="radiu5 audit bDanger">医保</span>'
            break;
        default:
            result = '<span class="radiu5 audit bDanger">其它</span>'
    }
    return result;
}


/**
 * 格式化新闻类型
 * @param value
 * @param row
 * @param index
 * @returns {string}
 */
function formatternewsMethod(value, row, index) {
    var result = "";
    switch (value) {
        case "1":
            result = '<span class="radiu5 audit bPrimary">促销活动</span>'
            break;
        case "2":
            result = '<span class="radiu5 audit bSuccess">通知</span>'
            break;
        case "3":
            result = '<span class="radiu5 audit bInfo">公告</span>'
            break;
    }
    return result;
}


/**
 * 格式化快捷方式菜单类型
 * @param value
 * @param row
 * @param index
 * @returns {string}
 */
function formattermenusMethod(value, row, index) {
    var result = "";
    switch (value) {
        case 1:
            result = '<span class="radiu5 audit bPrimary">报表</span>'
            break;
        case 2:
            result = '<span class="radiu5 audit bSuccess">链接入口</span>'
            break;
    }
    return result;
}




/*
 获取url参数值
 */
function getUrlParam(url, name) //
{
    var result = '';
    var str = url.substr(url.indexOf('?') + 1);
    if (str.indexOf('&') != -1) {
        var arr = str.split('&');
        for (i in arr) {
            if (arr[i].split('=')[0] == name)
                result = arr[i].split('=')[1];
        }
    }
    else {
        result = url.substr(url.indexOf('=') + 1)
    }
    result = result.replace(/#modal-\d+/g, '');
    return result;
}
/*
 设置url参数值
 */
function setUrlParam(url, name, value) {
    if (!url) {
        return url;
    }
    var str = "";
    if (url.indexOf('?') != -1)
        str = url.substr(url.indexOf('?') + 1);
    else
        return url + "?" + name + "=" + value;
    var returnurl = "";
    var setparam = "";
    var arr;
    var modify = "0";

    if (str.indexOf('&') != -1) {
        arr = str.split('&');

        for (i in arr) {
            if (arr[i].split('=')[0] == name) {
                setparam = value;
                modify = "1";
            }
            else {
                setparam = arr[i].split('=')[1];
            }
            returnurl = returnurl + arr[i].split('=')[0] + "=" + setparam + "&";
        }

        returnurl = returnurl.substr(0, returnurl.length - 1);

        if (modify == "0")
            if (returnurl == str)
                returnurl = returnurl + "&" + name + "=" + value;
    }
    else {
        if (str.indexOf('=') != -1) {
            arr = str.split('=');

            if (arr[0] == name) {
                setparam = value;
                modify = "1";
            }
            else {
                setparam = arr[1];
            }
            returnurl = arr[0] + "=" + setparam;
            if (modify == "0")
                if (returnurl == str)
                    returnurl = returnurl + "&" + name + "=" + value;
        }
        else
            returnurl = name + "=" + value;
    }
    return url.substr(0, url.indexOf('?')) + "?" + returnurl;
}
/*
 删除url参数值
 */
function delUrlParam(url, name) {
    var str = "";

    if (url.indexOf('?') != -1)
        str = url.substr(url.indexOf('?') + 1);
    else
        return url;
    var arr = "";
    var returnurl = "";
    var setparam = "";
    if (str.indexOf('&') != -1) {
        arr = str.split('&');
        for (i in arr) {
            if (arr[i].split('=')[0] != name) {
                returnurl = returnurl + arr[i].split('=')[0] + "=" + arr[i].split('=')[1] + "&";
            }
        }
        return url.substr(0, url.indexOf('?')) + "?" + returnurl.substr(0, returnurl.length - 1);
    }
    else {
        arr = str.split('=');
        if (arr[0] == name)
            return url.substr(0, url.indexOf('?'));
        else
            return url;
    }
}

$(function () {
    //去空白
    //$(":text").bind("blur", function(){this.value=$.trim(this.value);});
    $(":text").bind("blur", function () {
        this.value = $.trim(this.value.replace(/</g, '＜').replace(/\"/g, '“').replace(/\'/g, '‘'));
    });
    $("textarea").bind("blur", function () {
        this.value = $.trim(this.value);
    });
    //背景图片
    try {
        document.execCommand("BackgroundImageCache", false, true);
    }
    catch (exception) {
    }
});

function stopEventBubble(event) {
    var e = event || window.event;
    if (e && e.stopPropagation) {
        e.stopPropagation();
    }
    else {
        e.cancelBubble = true;
    }
}


function bindKeyUpDown(tableId) {
    var selIndex = 0;
    $("#" + tableId).keyup(function (e) {
        var data = $(this).bootstrapTable("getData");
        var length = data.length;
        $(this).bootstrapTable("check", 0)
        if (e.keyCode == 38) {//up
            if (selIndex > 0) {
                $(this).bootstrapTable("check", selIndex - 1);
                selIndex = selIndex - 1 == 0 ? 0 : selIndex - 1;
            }
            else
                return;
        } else if (e.keyCode == 40) {//down
            if (selIndex != length - 1) {
                $(this).bootstrapTable("check", selIndex + 1);
                selIndex = selIndex + 1 == length - 1 ? length - 1 : selIndex + 1;
            }
            else
                return;
        }
    });
}

/**
 * 把form表彰数据转化为josn
 * @param form
 * @returns {{}}
 */
function getFormJson(form) {
    var o = {};
    var a = $(form).serializeArray();
    $.each(a, function () {
        if (o[this.name] != "on") {
            if (o[this.name] !== undefined) {
                if (!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value || '');
            } else {
                o[this.name] = this.value || '';
            }
        }
    });
    return o;
}

/**
 * jquery 初始化form插件，传入一个json对象，为form赋值
 */
(function ($) {
    $.fn.extend({
        initForm: function (options) {
            //默认参数
            var defaults = {
                formdata: "",
                isDebug: true   //是否需要调试，这个用于开发阶段，发布阶段请将设置为false，默认为false,true将会把name value打印出来
            }
            //如果传入的json字符串，将转为json对象
            var tempData = "";
            if ($.type(options) === "string") {
                defaults.formdata = JSON.parse(options);
            } else {
                defaults.formdata = options;
            }
            //设置参数
            // var setting = $.extend({}, defaults, tempData);
            var setting = defaults;
            var form = this;
            formdata = setting.formdata;

            //如果传入的json对象为空，则不做任何操作
            if (!$.isEmptyObject(formdata)) {
                var debugInfo = "";
                $.each(formdata, function (key, value) {
                    //是否开启调试，开启将会把name value打印出来
                    if (setting.isDebug) {
                        debugInfo += "name:" + key + "; value:" + value + "\r\n ";
                    }
                    //表单处理
                    var formField = form.find("[name='" + key + "']");
                    if ($.type(formField[0]) === "undefined") {
                        if (setting.isDebug) {
                            console.warn("can not find name:[" + key + "] in form!!!"); //没找到指定name的表单
                        }
                    } else {
                        var fieldTagName = formField[0].tagName.toLowerCase();
                        if (fieldTagName == "input") {
                            if (formField.attr("type") == "radio") {
                                $("input:radio[name='" + key + "'][value='" + value + "']").attr("checked", "checked");
                            } else if (formField.attr("type") == "checkbox") {
                                $("input:checkbox[name='" + key + "'][value='" + value + "']").attr("checked", "checked");
                            } else {
                                formField.val(value);
                            }
                        } else if (fieldTagName == "label") {
                            formField.html(value);
                        } else {
                            formField.val(value);
                        }
                    }
                    //图片链接处理form.find("img[fieldata=img_url]")
                    var formImage = form.find("img[fieldata=" + key + "]");
                    if ($.type(formImage[0]) != "undefined") {
                        formImage.attr("src", value);
                    }
                    //a链接处理
                    var formLink = form.find("a[fieldata=" + key + "]");
                    if ($.type(formLink[0]) != "undefined") {
                        formLink.attr("href", value);
                    }
                })
                if (setting.isDebug) {
                    console.log(debugInfo);
                }
            }
            return form;    //返回对象，提供链式操作
        }
    });
})(jQuery)


// 对Date的扩展，将 Date 转化为指定格式的String
// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
Date.prototype.Format = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "H+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
    //调用：
    //var time1 = new Date().Format("yyyy-MM-dd");
    //var time2 = new Date().Format("yyyy-MM-dd HH:mm:ss");
}

/**
 * 格式化成日期时间
 * @param time
 * @param patter
 * @returns {*}
 */
function formateDateByPatter(date, patter) {
    var datetime = new Date();
    datetime.setDate(date);
    var year = datetime.getFullYear();
    var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
    var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
    var hour = datetime.getHours() < 10 ? "0" + datetime.getHours() : datetime.getHours();
    var minute = datetime.getMinutes() < 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();
    var second = datetime.getSeconds() < 10 ? "0" + datetime.getSeconds() : datetime.getSeconds();
    return year + patter + month + patter + date;
}

/**
 * 格式化成日期时间
 * @param time
 * @param patter
 * @returns {*}
 */
function timeStamp2Date(time, patter) {
    var datetime = new Date();
    datetime.setTime(time);
    var year = datetime.getFullYear();
    var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
    var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
    var hour = datetime.getHours() < 10 ? "0" + datetime.getHours() : datetime.getHours();
    var minute = datetime.getMinutes() < 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();
    var second = datetime.getSeconds() < 10 ? "0" + datetime.getSeconds() : datetime.getSeconds();
    return year + patter + month + patter + date;
}

/**
 * 格式化为时间
 * @param time
 * @param patter
 * @returns {string}
 */
function timeStamp2Datetime(time, patter) {
    var datetime = new Date();
    datetime.setTime(time);
    var year = datetime.getFullYear();
    var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
    var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
    var hour = datetime.getHours() < 10 ? "0" + datetime.getHours() : datetime.getHours();
    var minute = datetime.getMinutes() < 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();
    var second = datetime.getSeconds() < 10 ? "0" + datetime.getSeconds() : datetime.getSeconds();
    return year + patter + month + patter + date + " " + hour + ":" + minute + ":" + second;
}

/**
 * 计算月份差
 * @param date1
 * @param date2
 * @returns {number}
 */
function getMonthNumber(date1, date2) {
    //默认格式为"20030303",根据自己需要改格式和方法
    var year1 = date1.substr(0, 4);
    var year2 = date2.substr(0, 4);
    var month1 = date1.substr(4, 2);
    var month2 = date2.substr(4, 2);
    var len = (year2 - year1) * 12 + (month2 - month1);
    return len;
}


//将对象的数字值转为字符串
function toStringValue(obj) {
    if (obj instanceof Array) {
        var arr = [];
        for (var i = 0; i < obj.length; i++) {
            arr[i] = toStringValue(obj[i]);
        }
        return arr;
    } else if (typeof obj == 'object') {
        for (var p in obj) {
            obj[p] = toStringValue(obj[p]);
        }
    } else if (typeof obj == 'number') {
        obj = obj  + ' ' ;
    } else if (typeof obj == 'string') {
        if(isNumber(obj)){
            //obj = '<td style="mso-number-format:\'\@\';">' + obj +'</td>';
            //obj = '<span  style="mso-number-format:\'\@\';">' + obj + '</span>';
            obj = obj  + ' ' ;
        }
    }
    return obj;
}

function isNumber(val){
    var regPos = /^\d+(\.\d+)?$/; //非负浮点数
    var regNeg = /^(-(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*)))$/; //负浮点数
    if(regPos.test(val) || regNeg.test(val)){
        return true;
    }else{
        return false;
    }
}

$.fn.serializeObject = function () {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function () {
        if (o[this.name]) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};

function getSelectIndex(btsTable) {
    var value = parseInt(btsTable.find('.selected').attr('data-index'), 10);
    if (isNaN(value)) {
        value = -1;
    }
    return value;
}

function tableLineWriteBack(tb) {
    tb.delegate(".pinput", "blur", function () {
        var $this = $(this);
        var tr = $this.parents("tr");
        var index = tr.data("index");
        var rows = tb.bootstrapTable("getData");
        var row = rows[index];
        var name = $(this).attr("name");
        //console.log(""+index+":"+row[name]+"-->"+$this.val());
        row[name] = $this.val();
        tb.bootstrapTable("updateRow", index, row);
    });
}

function deleteCommand(datagridObj, idField, requestUrl, reLoad, delField, checkValue) {
    var selRow = $("#tb_data").bootstrapTable("getSelections");
    if (selRow && selRow.length > 0) {
        if (checkValue) {
            if (selRow[0][delField] == checkValue) {
                errorMsg("本行不可删除！");
                return;
            }
        }
        msgConfirm("删除提醒", "确认删除第" + (getSelectIndex($("#tb_data")) + 1) + "行吗？", function () {
            exeSimpCommand(idField + "=" + selRow[0][idField], requestUrl, function (returnData) {
                if (returnData.statusCode == 200) {
                    showMsg(returnData.msg);
                    if (reLoad) {
                        datagridObj.bootstrapTable('refresh');
                    }
                } else {
                    errorMsg(returnData.msg);
                }
            });
        });
    } else {
        errorMsg("请选取要删除的数据行！")
    }
}

/**
 * 格式化值 1.11
 */
function fixNum(value) {
    if (value) {
        var valueStr = value.toString()
        if (valueStr.indexOf('.') !== -1 && valueStr.split('.')[1].length > 2) {
            var sub = valueStr.split('.')[1];
            if (sub.substr(0, 2) == '00') {
                return valueStr.split('.')[0];
            } else {
                return value.toFixed(2)
            }
        }
    }
    return value;
}

/**
 * 初始化字典下拉列表
 * @param rootPath 根路径
 * @param codeType 对应的类形:如brandType
 * @param selectTag 下拉列表的tag
 * @param value 默认值:如 ${model.brandType}
 * @param inputTag  对应的brandTypeName，便于在查找时不用再次请求服务器查询值
 */
function initSystemCode(rootPath, codeType, selectTag, value, inputTag) {
    var url = rootPath + "/system/categoryCode/listByCodeType.action?codeType=" + codeType;
    var optionStr = '';
    initSelect(url, selectTag, value, inputTag, function (jsonObj) {
        if (value && value == jsonObj.codeValue) {
            optionStr += "<option value=\"" + jsonObj.codeValue + "\"  selected>" + jsonObj.codeName + "</option>";
        } else {
            optionStr += "<option value=\"" + jsonObj.codeValue + "\" >" + jsonObj.codeName + "</option>";
        }
        return optionStr;
    })
};

/**
 * 初始化收银员
 * @param rootPath 根路径
 * @param codeType 对应的类形:如brandType
 * @param selectTag 下拉列表的tag
 * @param value 默认值:如 ${model.brandType}
 * @param inputTag  对应的brandTypeName，便于在查找时不用再次请求服务器查询值
 */
function initSeller(rootPath, selectTag, inputTag) {
    var url = rootPath + "/system/user/listSeller.action?v=" + new Date().getTime();
    var optionStr = '';
    initSelect(url, selectTag, null, inputTag, function (jsonObj) {
        var sellerValue = getCookie('sellerInfo');
        if (sellerValue && sellerValue == jsonObj.userId) {
            optionStr += "<option value=\"" + jsonObj.userId + "\"  selected>" + jsonObj.userName + "</option>";
        } else {
            optionStr += "<option value=\"" + jsonObj.userId + "\" >" + jsonObj.userName + "</option>";
        }
        return optionStr;
    });
};

function initLogType(rootPath, selectTag, inputTag) {
    var url = rootPath + "/sys/sysoperatelog/listLogType.action";
    var optionStr = '';
    initSelect(url, selectTag, null, inputTag, function (jsonObj) {
        if (jsonObj.logType == 1) {
            optionStr += "<option value=\"" + jsonObj.logType + "\" >正常日志 </option>";
        } else if (jsonObj.logType == 2) {
            optionStr += "<option value=\"" + jsonObj.logType + "\" >错误日志 </option>";
        }
        return optionStr;

    });
};

/**
 * 初始化下拉选择框
 * @param rootPath
 * @param selectTag
 * @param value
 * @param inputTag
 */
function initSelect(url, selectTag, value, inputTag, fun) {
    $.ajax({
        url: url,
        type: "post",
        dataType: "json",
        contentType: "application/json",
        traditional: true,
        success: function (json) {
            if (json && json.rows) {
                var data = json.rows;
                var optionStr = "";
                for (var i in data) {
                    var jsonObj = data[i];
                    if (fun && typeof fun === "function") {
                        optionStr = fun(jsonObj);
                    }
                }
                $(selectTag).append(optionStr);
            }

        },
        error: function (msg) {
            dialogMsg(msg, "error");
        }
    });

    $(selectTag).change(function () {
        if (inputTag) {
            $(inputTag).val($(this).find("option:selected").text())
        }
    })
}

/**
 * 初始化编辑窗口自动输入问题
 * @param editForm
 * @param focusTag
 */
function initAutoEnter(editForm, focusId) {
    $(focusId).focus();
    //回车监听
    $(editForm).delegate(".pinput", "keyup", function (e) {
        e.preventDefault();
        if ($(editForm + " .pinput").is(":focus")) {
            var pinput = $(editForm + " .pinput");
            var index = pinput.index(this);
            if (e.keyCode == 13 || e.which == 13) {
                var pinputNext = pinput[index + 1];
                pinputNext.focus(); // 设置焦点
                pinputNext.select(); // 选中文字
            }
        }
    });

    $("select").change(function (e) {
        var pinput = $(editForm + " .pinput");
        var index = pinput.index(this);
        if (e.type == "change") {
            pinput[index + 1].focus(); // 设置焦点
            pinput[index + 1].select(); // 选中文字
        }
    })
}

/**
 * 初始化自动输入框数据
 * @param tableId  "#tableEdit"
 * @param inputTag   "input[name='amount']"
 */
function initInputValue(tableId, inputTag) {
    //绑定事件
    $(tableId).on("input", inputTag, function () {
        var value = $(this).val();
        var max = parseInt($(this).attr("max"));
        if (isNaN(value)) {
            value = 0;
        } else if (value > max) {
            value = max;
        } else if (value < 1) {
            value = 1;
        }
        $(this).val(value);
    });
}

/**
 * 移除页眉和页脚
 */
function remove_ie_header_and_footer() {
    var hkey_path;
    hkey_path = "HKEY_CURRENT_USER\\Software\\Microsoft\\Internet Explorer\\PageSetup\\";
    try {
        var RegWsh = new ActiveXObject("WScript.Shell");
        RegWsh.RegWrite(hkey_path + "header", "");
        RegWsh.RegWrite(hkey_path + "footer", "");
    } catch (e) {
    }
}

//--vue----------------------------------------------------------

var url = function (name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null)return unescape(r[2]);
    return null;
}

//权限判断
function hasPermission(permission) {
    if (isNullOrEmpty(window.parent.perms)) {
        return false;
    }
    if (window.parent.perms.indexOf(permission) > -1) {
        return true;
    } else {
        return false;
    }
}

//权限角色
function hasRole(role) {
    if (isNullOrEmpty(window.parent.roles)) {
        return false;
    }
    if (window.parent.roles.indexOf(role) > -1) {
        return true;
    } else {
        return false;
    }
}

toUrl = function (href) {
    window.location.href = href;
}

$.fn.bootstrapTableEx = function (opt) {
    var defaults = {
        url: '',
        dataField: "rows",
        method: 'post',
        dataType: 'json',
        selectItemName: 'id',
        clickToSelect: true,
        pagination: true,
        smartDisplay: false,
        pageSize: 10,
        pageList: [10, 20, 30, 40, 50],
        paginationPreText: '上一页',
        paginationNextText: '下一页',
        sidePagination: 'server',
        queryParamsType: null,
        columns: []
    }
    var option = $.extend({}, defaults, opt);
    $(this).bootstrapTable(option);
}

formatDate = function (v, format) {
    if (!v) return "";
    var d = v;
    if (typeof v === 'string') {
        if (v.indexOf("/Date(") > -1)
            d = new Date(parseInt(v.replace("/Date(", "").replace(")/", ""), 10));
        else
            d = new Date(Date.parse(v.replace(/-/g, "/").replace("T", " ").split(".")[0]));//.split(".")[0] 用来处理出现毫秒的情况，截取掉.xxx，否则会出错
    }
    var o = {
        "M+": d.getMonth() + 1,
        "d+": d.getDate(),
        "h+": d.getHours(),
        "m+": d.getMinutes(),
        "s+": d.getSeconds(),
        "q+": Math.floor((d.getMonth() + 3) / 3),
        "S": d.getMilliseconds()
    };
    if (/(y+)/.test(format)) {
        format = format.replace(RegExp.$1, (d.getFullYear() + "").substr(4 - RegExp.$1.length));
    }
    for (var k in o) {
        if (new RegExp("(" + k + ")").test(format)) {
            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
        }
    }
    return format;
}

isNullOrEmpty = function (obj) {
    if ((typeof (obj) == "string" && obj == "") || obj == null || obj == undefined) {
        return true;
    } else {
        return false;
    }
}

isNotNullOrEmpty = function (obj) {
    if ((typeof (obj) == "string" && obj == "") || obj == null || obj == undefined) {
        return false;
    } else {
        return true;
    }
}

checkedArray = function (id) {
    var isOK = true;
    if (id == undefined || id == "" || id == 'null' || id == 'undefined') {
        isOK = false;
        showMsg('您没有选中任何数据项！');
    }
    return isOK;
}

checkedRow = function (id) {
    var isOK = true;
    if (id == undefined || id == "" || id == 'null' || id == 'undefined') {
        isOK = false;
        showMsg('您没有选中任何数据项！');
    } else if (id.length > 1) {
        isOK = false;
        showMsg('您只能选择一条数据项！');
    }
    return isOK;
}

reload = function () {
    location.reload();
    return false;
}



$.fn.GetWebControls = function (keyValue) {
    var reVal = "";
    $(this).find('input,select,textarea').each(function (r) {
        var id = $(this).attr('id');
        var type = $(this).attr('type');
        switch (type) {
            case "checkbox":
                if ($("#" + id).is(":checked")) {
                    reVal += '"' + id + '"' + ':' + '"1",'
                } else {
                    reVal += '"' + id + '"' + ':' + '"0",'
                }
                break;
            default:
                var value = $("#" + id).val();
                if (value == "") {
                    value = "&nbsp;";
                }
                reVal += '"' + id + '"' + ':' + '"' + $.trim(value) + '",'
                break;
        }
    });
    reVal = reVal.substr(0, reVal.length - 1);
    if (!keyValue) {
        reVal = reVal.replace(/&nbsp;/g, '');
    }
    reVal = reVal.replace(/\\/g, '\\\\');
    reVal = reVal.replace(/\n/g, '\\n');
    var postdata = jQuery.parseJSON('{' + reVal + '}');
    return postdata;
};

$.fn.SetWebControls = function (data) {
    var $id = $(this)
    for (var key in data) {
        var id = $id.find('#' + key);
        if (id.attr('id')) {
            var type = id.attr('type');
            var value = $.trim(data[key]).replace(/&nbsp;/g, '');
            switch (type) {
                case "checkbox":
                    if (value == 1) {
                        id.attr("checked", 'checked');
                    } else {
                        id.removeAttr("checked");
                    }
                    break;
                default:
                    id.val(value);
                    break;
            }
        }
    }
}

$.currentIframe = function () {
    return $(window.parent.document).contents().find('#main')[0].contentWindow;;
}


// 判断各种浏览器，找到正确的方法
function launchFullscreen(element) {
    if (element.requestFullscreen) {
        element.requestFullscreen();
    } else if (element.mozRequestFullScreen) {
        element.mozRequestFullScreen();
    } else if (element.webkitRequestFullscreen) {
        element.webkitRequestFullscreen();
    } else if (element.msRequestFullscreen) {
        element.msRequestFullscreen();
    }
}

/**
 * 日期查询初始化
 *
 * @returns
 */
function laydateQueryInit(isInit) {
    //皮肤
    laydate.skin('molv');
    if(isInit || typeof isInit === "undefined"){
        $("#start").val(laydate.now(-7));
        $("#end").val(laydate.now());
    }
    var start = {
        elem: '#start',
        format: 'YYYY-MM-DD',
        istime: false,
        max: laydate.now(),
        istoday: true
    };
    var end = {
        elem: '#end',
        format: 'YYYY-MM-DD',
        istime: false,
        istoday: true,
        choose: function (datas) {
            start.max = datas; //结束日选好后，重置开始日的最大日期
            if (datas < $("#start").val())
                $("#start").val(datas);
        }
    };

    laydate(start);
    laydate(end);
}

/**
 * 以什么开始
 * @param str
 * @returns {boolean}
 */
String.prototype.startWith=function(str){
    var reg=new RegExp("^"+str);
    return reg.test(this);
}

/**
 * 以什么结束
 * @param str
 * @returns {boolean}
 */
String.prototype.endWith = function (str) {
    var reg = new RegExp(str + "$");
    return reg.test(this);
}

/**
 * 强力获取焦点
 * @param tag
 */
jQuery.prototype.forceFocus = function (tag) {
    setTimeout(function () {
        tag.focus();
    }, 10);
}

//传数据到cookie去
function setCookie(name, value, day) {
    var d = new Date();
    d.setDate(d.getDate() + day);
    var str = name + '=' + value + ';expires=' + d;
    document.cookie = str;
}

//获取cookie数据
function getCookie(name) {
    var c = document.cookie;
    var value = '';
    var cookies = c.split(';');
    for (var i = 0; i < cookies.length; i++) {
        var cookie = cookies[i];
        if (cookie && cookie.indexOf(trim(name)) != -1) {
            var arr = cookie.split('=');
            value = arr[1];
            break;
        }
    }
    return value;
}
//传数据到cookie去
function setJsonCookie(name, value, day) {
    var d = new Date();
    d.setDate(d.getDate() + day);
    var str = name + '=' + JSON.stringify(value) + ';expires=' + d;
    document.cookie = str;
}

//获取cookie数据
function getJsonCookie(name) {
    var c = document.cookie;
    var cookie = c.split(';');
    for (var i = 0; i < cookie.length; i++) {
        var arr = cookie[i].split('=');
        if (arr[0] == name) {
            return JSON.parse(arr[1]);
        }
    }
    return '';
}

/**
 * 合并json对象
 * @param jsonbject1
 * @param jsonbject2
 * @returns {{}}
 */
$.mergeJsonObject = function (jsonbject1, jsonbject2) {
    var resultJsonObject = {};
    for (var attr in jsonbject1) {
        resultJsonObject[attr] = jsonbject1[attr];
    }
    for (var attr in jsonbject2) {
        resultJsonObject[attr] = jsonbject2[attr];
    }
    return resultJsonObject;
};

/**
 * 清空表单
 * @param form
 */
function resetForm(form) {
    form.find('input[type=text],select,input[type=hidden]').each(function () {
        $(this).val('');
    });
}


/*
 * 克隆对象
 */
function clone(obj) {
    function Clone() {
    }

    Clone.prototype = obj;
    var o = new Clone();
    for (var a in o) {
        if (typeof o[a] == "object") {
            o[a] = clone(o[a]);
        }
    }
    return o;
}

/**
 * 阻止默认
 * @param e
 * @returns {boolean}
 */
function stopDefault(e) {
    if (e && e.preventDefault) {
        e.preventDefault();
    }
    else {
        e.keyCode = 0;
        window.event.returnValue = false;
    }
}


function judgeFilde(groupSearch) {
    var searchValue = $(groupSearch).val();
    if (/^\d+$/.test(searchValue) && searchValue.length < 8) { //判断货号
        $(groupSearch).attr("name", "productCode")
    } else if (/[\u4E00-\u9FA5]/g.test(searchValue)) {        //判断商品名

        $(groupSearch).attr("name", "productName")
    } else if (/^[0-9]{13}$/.test(searchValue)) {          //判断条码
        $(groupSearch).attr("name", "barCode")
    }else if (/^[A-Za-z0-9]+$/.test(searchValue)) {            //判断助记名

        $(groupSearch).attr("name", "mnemonicName")
    }  else {                                                //为空
        $(groupSearch).attr("name", "productCode")
    }

}
//防止模态框高度 大于窗口高度 显示bug
//mHeight 模态框高度
function initModalSize(mHeight) {
 	if($(window).height() <= mHeight) {
 		$('.iziModal').animate({"top": '26px'},'fast')
 	}
 	$(window).resize(function () {
 		if($(window).height() <= mHeight) {
 	    	$('.iziModal').css({'top': '26px','margin-top':'-26px'})
 		}else {
 			$('.iziModal').css({'top': '50%'})
 		}
 		
 	})
}

var dialog_zindex = 999;
function msgDialog(submitUrl, tableId, initOptions, closeFun , handleFun) {
    if (!initOptions.url) {
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
    if (submitUrl && !initOptions.buttons) {
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
                    $(".loadding-btn").removeClass("hide")
                    $.ajax({
                        url: submitUrl,
                        data: para,
                        type: "POST",
                        success: function (json) {
                        	$(".loadding-btn").addClass("hide")
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
        width: 1000,
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
                $(modalId + " .iziModal-content").find(".bgroup").append('<div class="la-ball-fall loadding-btn hide"><div></div><div></div><div></div></div>')
                $(modalId + " .iziModal-content .selectpicker").selectpicker('refresh');//下拉插件
                modal.stopLoading();
            });
        },
        onOpened: function () {
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


function msgAlert(title, msg, type) {
	if(type == 'info') {
		type = 'warning'
	}
	if(title == '提示' && type == 'error'){
		type = 'warning'
	}
    swal({title: title, text: msg, type: type, confirmButtonText: "确认"});
}

