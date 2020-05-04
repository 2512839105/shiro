$(function() {
	$(".main").not('.posPage').mCustomScrollbar({
		theme: 'minimal-dark',
		scrollInertia: 550,
		mouseWheelPixels: 220,
	});

	var surround = $(".main").not('.posPage').find('.surround');
	var contrain = $('.contrain');
	var bgroup = $(".bgroup:first").not('#toolbar');
	//	console.log(bgroup.outerHeight());
	if(surround.length > 0) {
		//		surround.height( $(window).height() - 60);
		surround.css('min-height', $(window).height() - parseInt(contrain.css('padding-top')) - parseInt(contrain.css('padding-bottom')) - parseInt(contrain.css('margin-top')) - parseInt(contrain.css('margin-bottom')) - bgroup.outerHeight());
	}
})

function tableScroll(firHeight, secHeight) {
    if($(".main.posPage").length == 1) {
        return false;
    }
    var n = $(".surround").find('.table-responsive .fixed-table-body');
    var wrapHeight = $(".surround").css('min-height');
    var formSearch = $(".fullcontent > .form-search");
    var formHeight;
    var nHeight = [];
    var tHeight = [];
    tHeight[0] = firHeight ? firHeight : 0.5;
    tHeight[1] = secHeight ? secHeight : 0.5;

    //查询框高度
    if(formSearch.length > 0) {

        formHeight = formSearch.outerHeight(true);

    } else {
        formHeight = 0;
    }

    if(n.length == 2) {
        n.each(function (index) {
            var pageHeight = $(this).parent().find(".pagination-detail").outerHeight(true);
            var fixedbar = $(this).parent().parent().find(".fixed-table-toolbar").addClass('clearfix');
            var barHeight = fixedbar.outerHeight(true);

            nHeight[index] = (parseInt(wrapHeight) - formHeight - 20 - 20) * tHeight[index] - barHeight - pageHeight - 1;
         /* $(this).css('max-height', nHeight[index] - 2)*/
            $(this).css('max-height', 'auto');
        })
    } else if((n.length == 1)) {
        var pageHeight = n.parent().find(".pagination-detail").outerHeight(true);
        var fixedbar = n.parent().parent().find(".fixed-table-toolbar").addClass('clearfix');
        var barHeight = fixedbar.outerHeight(true);
        var nHeight = parseInt(wrapHeight) - barHeight - pageHeight - formHeight - 20;
       /* $(this).css('max-height', nHeight - 2);*/
        $(this).css('max-height', 'auto')
    }

   /* n.mCustomScrollbar({
        theme: 'minimal-dark',
        scrollInertia: 550,
        mouseWheelPixels: 220,
        axis: 'xy'
    });*/

}

//重置弹出框翻页后行数
function resetSelect() {
	productModal.find('tr.selected').removeClass('selected');
	setTimeout(function() {
		productModal.find('tbody tr').eq(0).find('input[type="radio"]').focus();
	}, 0);
	productModal.find('tbody tr').eq(0).find('input[type="radio"]').focus();
	productModal.find('tbody tr').eq(0).find('input[type="radio"]').click();
	productModal.find('tbody tr').eq(0).addClass('selected');
	$(".diySearch").focus();
	setTimeout(function() {
		$(".diySearch").focus();
	}, 0);
}

//滚动条
/*function scroolClass(className) {
	$("." + className).mCustomScrollbar({
		theme: 'minimal-dark',
		scrollInertia: 550,
		mouseWheelPixels: 220,
	});
}*/

//页面全屏
function toggleFullScreen() {
	if(!document.fullscreenElement && // alternative standard method
		!document.mozFullScreenElement && !document.webkitFullscreenElement) { // current working methods
		if(document.documentElement.requestFullscreen) {
			document.documentElement.requestFullscreen();
		} else if(document.documentElement.mozRequestFullScreen) {
			document.documentElement.mozRequestFullScreen();
		} else if(document.documentElement.webkitRequestFullscreen) {
			document.documentElement.webkitRequestFullscreen(Element.ALLOW_KEYBOARD_INPUT);
		}
	} else {
		if(document.cancelFullScreen) {
			document.cancelFullScreen();
		} else if(document.mozCancelFullScreen) {
			document.mozCancelFullScreen();
		} else if(document.webkitCancelFullScreen) {
			document.webkitCancelFullScreen();
		}
	}
}

function searchControl() {
	var showbutton = $('.moretext').find('span');
	var morechoice = $('.morechoice');
	showbutton.click(function() {
		console.log($('.content').height());
		if(morechoice.hasClass('ch-closed')) {
			morechoice.stop(true).slideToggle();
			morechoice.removeClass('ch-closed');
			showbutton.html('收起 <i class="iconfont icon-shangjiantou"></i>');

		} else {
			morechoice.stop(true).slideToggle();
			morechoice.addClass('ch-closed');
			showbutton.html('显示更多选项 <i class="iconfont icon-open"></i>');
		}
	})
}

//  ========== 
//  = ztree下拉选择框公用JS = 
//  ========== 
function beforeClick(treeId, treeNode) {
	var zTree = $.fn.zTree.getZTreeObj("treeSelect");
	zTree.checkNode(treeNode, !treeNode.checked, null, true);
	return false;
}

function onCheck(e, treeId, treeNode) {
	var zTree = $.fn.zTree.getZTreeObj("treeSelect"),
		nodes = zTree.getCheckedNodes(true),
		v = "";
	for(var i = 0, l = nodes.length; i < l; i++) {
		v += nodes[i].name + ",";
	}
	if(v.length > 0) v = v.substring(0, v.length - 1);
	var cityObj = $("#citySel");
	cityObj.attr("value", v);
}

function addLoadEvent(func) {
	var oldonload = window.onload;
	if(typeof window.onload != 'function') {
		window.onload = func;
	} else {
		window.onload = function() {
			oldonload();
			func();
		}
	}
}

function upFile() {
	// 文件上传
	var $ = jQuery,
		$list = $('#thelist'),
		$btn = $('#ctlBtn'),
		state = 'pending',
		uploader;

	uploader = WebUploader.create({

		// 不压缩image
		resize: false,

		// swf文件路径
		swf: 'js/Uploader.swf',
		// swf: BASE_URL + '/js/Uploader.swf',

		// 文件接收服务端。
		server: 'http://webuploader.duapp.com/server/fileupload.php',

		// 选择文件的按钮。可选。
		// 内部根据当前运行是创建，可能是input元素，也可能是flash.
		pick: '#picker'
	});

	// 当有文件添加进来的时候
	uploader.on('fileQueued', function(file) {
		var FE = getFileExtension(file.name);
		var feclass;
		// alert(FE);
		switch(FE) {
			case 'doc':
			case 'docx':
				feclass = 'icon-word';
				break;
			case 'xls':
			case 'xlsx':
				feclass = 'icon-excel';
				break;
			case 'pdf':
				feclass = 'icon-pdf';
				break;
			case 'zip':
			case '7z':
			case 'rar':
				feclass = 'icon-zip';
				break;
			default:
				feclass = 'icon-file';

		}
		$list.append('<div id="' + file.id + '" class="item">' +
			'<span class="iconfont ' + feclass + '"></span>' +
			'<h4 class="info">' + file.name + '</h4>' +
			'<p class="state">等待上传...</p>' +
			'</div>');
	});

	// 文件上传过程中创建进度条实时显示。
	uploader.on('uploadProgress', function(file, percentage) {
		var $li = $('#' + file.id),
			$percent = $li.find('.progress .progress-bar');

		// 避免重复创建
		if(!$percent.length) {
			$percent = $('<div class="progress progress-striped active">' +
				'<div class="progress-bar" role="progressbar" style="width: 0%">' +
				'</div>' +
				'</div>').appendTo($li).find('.progress-bar');
		}

		$li.find('p.state').text('上传中');

		$percent.css('width', percentage * 100 + '%');
	});

	uploader.on('uploadSuccess', function(file) {
		$('#' + file.id).find('p.state').text('已上传');
	});

	uploader.on('uploadError', function(file) {
		$('#' + file.id).find('p.state').text('上传出错');
	});

	uploader.on('uploadComplete', function(file) {
		$('#' + file.id).find('.progress').fadeOut();
	});

	uploader.on('all', function(type) {
		if(type === 'startUpload') {
			state = 'uploading';
		} else if(type === 'stopUpload') {
			state = 'paused';
		} else if(type === 'uploadFinished') {
			state = 'done';
		}

		if(state === 'uploading') {
			$btn.text('暂停上传');
		} else {
			$btn.text('开始上传');
		}
	});

	$btn.on('click', function() {
		if(state === 'uploading') {
			uploader.stop();
		} else {
			uploader.upload();
		}
	});
}

//获取文件后缀
function getFileExtension(fileName) {
	var fileExtension = fileName.substring(fileName.lastIndexOf('.') + 1);
	return fileExtension;
}

//兼容旧版本浏览器placeholder属性
function placeholderSupport() {
	return 'placeholder' in document.createElement('input');
}

//兼容旧版本浏览器getElementsByClassName
function getElementsByClassName(node, classname) {
	if(node.getElementsByClassName) {
		//使用现有方法
		return node.getElementsByClassName(classname);
	} else {
		var results = new Array();
		var elems = node.getElementsByTagName("*");
		for(var i = 0; i < elems.length; i++) {
			if(elems[i].className.indexOf(classname) != -1) {
				results[results.length] = elems[i];
			}
		}
		return results;
	}
}

/*显示自定义对话框
 *tableClassName  string 表格ClassName
 *inputTdClass  输入框父元素td的ClassName
 */
function productModal(tableIdName, inputTdClass) {
	var tableId = $("#" + tableIdName);
	var inputTd = $("." + inputTdClass);

	var productModal = $(".productModal");
	showButton = $(".testButton");
	closeButton = $(".productModal .modalContent .closeDivModal");

	showButton.click(function() {
		productModal.stop().fadeIn();
		var i = 0;
		var tbody = $("#table4 tbody");
		tbody.find('tr').eq(i).click();
		tbody.find('tr').eq(i).addClass('selected');
		tbody.find('tr').eq(i).find('input[type="radio"]').attr("checked", 'checked');
		var iMax = tbody.find('tr').length - 1;

		document.onkeydown = function(event) {
			if(event.keyCode == 38) {
				event.keyCode = 0;　
				event.returnValue = false;
				i -= 1;
				if(i < 0) {
					i = iMax
				}
				tableUpDown(tbody, i);
			}
			if(event.keyCode == 40) {
				event.keyCode = 0;　
				event.returnValue = false;
				i += 1;
				if(i > iMax) {
					i = 0;
				}
				tableUpDown(tbody, i);
			}
		}
	})

	//关闭自定义对话框
	closeButton.click(function() {
		$(this).parents('.productModal').stop().fadeOut();
	})
}

//
function tableUpDown(table, i) {
	////	console.log(iMax);
	//	console.log(i);
	//	console.log(table.find('tr').eq(i).attr('data-index'));
	table.find('tr.selected').removeClass('selected');
	setTimeout(function() {
		table.find('tr').eq(i).find('input[type="radio"]').focus();
	}, 0);

	table.find('tr').eq(i).find('input[type="radio"]').click();
	//	table.find('tr').eq(i).find('input[type="radio"]').focus();
	table.find('tr').eq(i).addClass('selected');

	//	table.find('tr').eq(i).addClass('selected').find('input[type="radio"]').click();
	//	table.find('tr').eq(i).focus();
}

//加载公用函数
function loadEvents() {

}

addLoadEvent(loadEvents);
addLoadEvent(tableScroll);

$(function() {  
    $('.tooltip').on('show.bs.tooltip', function() {  
        alert("Alert message on show");  
    })  
});  
