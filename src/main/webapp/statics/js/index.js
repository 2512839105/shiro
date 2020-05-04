/**
 *左侧导航折叠伸展 
 */
function navShow() {
	var treeObj = $.fn.zTree.getZTreeObj("tree");

	colAuto();
	leftStatus();
	
	$(window).resize(function() {
		leftStatus();
	})
	//导航按钮折叠伸展切换
	$('.sidebar-toggler').click(function() {
		$("body").toggleClass('page-sidebar-closed');
		if($('.page-sidebar-closed').length == '0') {
			leftExpand();
		} else {
			leftColspan();
		}

	})

	//点开导航,伸展

	$('html').on('click', '.page-sidebar-closed .sidebar li > a .iconfont', function() {
		$("body").removeClass('page-sidebar-closed');
		leftExpand();
	})

	//在手机端,点击左侧菜单选项,自动收缩
	function colAuto() {

		$('.main .sidebar-menu').on('click', 'a', function() {
			if($(window).width() <= 770) {
				if(!$(this).parent().children('span').hasClass('noline_close') && !$(this).parent().children('span').hasClass('noline_open')) {
					console.log($(window).width());
					//				console.log($(this).parent().children('span').attr('class'));
					$("body").addClass('page-sidebar-closed');
					leftColspan();
				}
			}
		})
	}
	
	//判断窗口大小,左侧导航伸缩
	function leftStatus () {
		if($(window).width() <= 770) {
			$("body").addClass('page-sidebar-closed');
			leftColspan();
		} else if($(window).width() > 770) {
			$("body").removeClass('page-sidebar-closed');
			leftExpand();
		}
	}
	
	//折叠动画
	function leftColspan() {
		$("ul.sidebar-menu").stop(true).animate({ left: '35px' });
		$('.main .left-side').stop(true).animate({ marginLeft: '35px' });
		$('.sidebar .head-info').stop(true).fadeOut('fast');
		treeObj.expandAll(false);
		treeObj.cancelSelectedNode();
	}

	//伸展动画
	function leftExpand() {
		$("ul.sidebar-menu").stop(true).animate({ left: '225px' });
		$('.main .left-side').stop(true).animate({ marginLeft: '225px' });
		$('.sidebar .head-info').stop(true, true).fadeIn('fast');
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

// function placeholderSupport() {
//     return 'placeholder' in document.createElement('input');
// }
//兼容旧版本浏览器placeholder属性
function suportPlaceholder(argument) {

	var placeholder = 'placeholder' in document.createElement('input');
	if(!placeholder) { // 判断浏览器是否支持 placeholder
		$('[placeholder]').focus(function() {
			var input = $(this);
			if(input.val() == input.attr('placeholder')) {
				input.val('');
				input.removeClass('placeholder');
			}
		}).blur(function() {
			var input = $(this);
			if(input.val() == '' || input.val() == input.attr('placeholder')) {
				input.addClass('placeholder');
				input.val(input.attr('placeholder'));
			}
		}).blur();
	};

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

//弹出框垂直居中
function modalValign() {
	$('.modal').each(function() {
		var marginTop = $(this).find('.modal-dialog').height() / 2;
		var contentHeight = $(this).find('.modal-content').height();
		$(this).removeClass('show');
		if(contentHeight >= $(window).height()) {
			$(this).find('.modal-dialog').css({ 'top': '50px', 'marginTop': 0 });
		} else {
			$(this).find('.modal-dialog').css({ 'top': $(window).height() / 2, 'marginTop': -marginTop });
		}
	})

	window.onresize = function() {
		$('.modal').each(function() {
			$(this).addClass('show');
			marginTop = $(this).find('.modal-dialog').height() / 2;
			contentHeight = $(this).find('.modal-content').height();
			$(this).removeClass('show');

			if(contentHeight >= $(window).height()) {
				$(this).find('.modal-dialog').css({ 'top': '50px', 'marginTop': 0 });
			} else {
				$(this).find('.modal-dialog').css({ 'top': $(window).height() / 2, 'marginTop': -marginTop });
			}
		})
	}
}

//  ========== 
//  = 左侧菜单搜索筛选 = 
//  ========== 
function leftSearch() {
	var searchTree = $(".searchTree input");
	var treeObj = $.fn.zTree.getZTreeObj("tree");
	searchTree.keyup(function() {
		var input = $(this).val();
		if(input.length > 0) {

			treeObj.expandAll(true);
			$("#tree").children('li').css('display', 'none');

			$("#tree").find('li').filter(function(index) {
				return $(this).text().indexOf(input) >= 0;
			}).css("display", "block");
			//			$("li").filter(function(index) {
			//              return $(this).text().indexOf(input) >= 0;
			//          }).css("display", "block");

		} else {
			treeObj.expandAll(false);
			$("#tree").children('li').css('display', 'block');
		}
	})
}
//  ========== 
//  = 浏览器滚动插件 = 
//  ========== 
function yScroll() {

	$(".sidebar,.right-side").mCustomScrollbar({
		scrollInertia: 550, //滚动平滑度
		callbacks: {
			onTotalScrollOffset: 230, //到达顶部偏移度
		}
	});

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

function loadEvents() {

}
//选项卡右键关闭菜单
!function(t,n,i,e){var o=function(t,n){this.init(t,n)};o.prototype={init:function(t,n){this.ele=t,this.defaults={menu:[{text:"鑿滃崟涓€",callback:function(){}}],target:function(t){},width:"auto",itemHeight:28,bgColor:"#fff",color:"#333",fontSize:14,hoverColor:"none",hoverBgColor:"#f5f5f5"},this.opts=i.extend(!0,{},this.defaults,n),this.random=(new Date).getTime()+parseInt(1e3*Math.random()),this.eventBind()},renderMenu:function(){var t=this,n="#uiContextMenu_"+this.random;if(!(i(n).size()>0)){var e=this.opts.menu,o='<ul class="ui-context-menu" id="uiContextMenu_'+this.random+'">';i.each(e,function(t,n){n.icon?o+='<li class="ui-context-menu-item"><a href="javascript:void(0);"><img class="icon" src="'+n.icon+'"/><span>'+n.text+"</span></a></li>":o+='<li class="ui-context-menu-item"><a href="javascript:void(0);"><span>'+n.text+"</span></a></li>"}),o+="</ul>",i("body").append(o).find(".ui-context-menu").hide(),this.initStyle(n),i(n).on("click",".ui-context-menu-item",function(n){t.menuItemClick(i(this)),n.stopPropagation()})}},initStyle:function(t){var n=this.opts;i(t).css({width:n.width,backgroundColor:n.bgColor}).find(".ui-context-menu-item a").css({color:n.color,fontSize:n.fontSize,height:n.itemHeight,lineHeight:n.itemHeight+"px"}).hover(function(){i(this).css({backgroundColor:n.hoverBgColor,color:n.hoverColor})},function(){i(this).css({backgroundColor:n.bgColor,color:n.color})})},menuItemClick:function(t){var n=this,i=t.index();t.parent(".ui-context-menu").hide(),n.opts.menu[i].callback&&"function"==typeof n.opts.menu[i].callback&&n.opts.menu[i].callback()},setPosition:function(t){i("#uiContextMenu_"+this.random).css({left:t.clientX+2,top:t.clientY+2}).show()},eventBind:function(){var t=this;this.ele.on("contextmenu",function(n){n.preventDefault(),t.renderMenu(),t.setPosition(n),t.opts.target&&"function"==typeof t.opts.target&&t.opts.target(i(this))}),i(n).on("click",function(){i(".ui-context-menu").hide()})}},i.fn.contextMenu=function(t){return new o(this,t),this}}(window,document,jQuery);

//页面加载方法
addLoadEvent(suportPlaceholder);
addLoadEvent(yScroll);