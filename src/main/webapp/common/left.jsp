<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<script type="text/javascript" src="${ctx}/statics/js/jquery.ztree.core.min.js"></script> 
<style type='text/css'>
	a:hover {text-decoration:none}
    .word-state .work-side{width: 190px;background: #fff;box-sizing: border-box;border-right:1px solid #ccc}
	.word-state .work-side > ul > li{border-bottom:1px solid #ccc;}
	.word-state .work-side > ul > li:after{content:"."; display:block; height:0; clear:both; visibility:hidden;}
	.word-state .work-side > ul > li > a{font-size: 16px; display: block;width: 100%; height: 40px; line-height: 40px;
		color:#8c8b89;padding:0 15px;
	}
	.word-state .work-side > ul > li > a span i{height:40px;line-height:40px;font-size:14px;}
	.word-state .work-side > ul > li > ul > li{display: block;font-size: 14px; height:40px; line-height:40px;}
	.word-state .work-side span.button{ padding:0;}
	.word-state .work-side > ul > li > ul > li ul{display: none!important;}
	.word-state .work-side a{ color: #000;cursor: pointer;display:block;padding:0 10px 0 32px;transition:.2s;}
	.word-state .work-side a + ul li a:hover{background:#65b157;color:#fff;}
	.word-state .work-side a:link{ color: #bdbdc5;}
	.word-state .work-side a:visited{ color: #bdbdc5;height:40px;line-height: 40px;text-align: center;-moz-border-radius:3px; -webkit-border-radius:3px; border-radius:3px;font-size: 14px;letter-spacing: 2px;}    
	.transRotate{
	transition:transform .2s;-webkit-transform:rotate(-90deg);-moz-transform:rotate(-90deg);
	-ms-transform:rotate(-90deg);-o-transform:rotate(-90deg);transform:rotate(-90deg);
}
</style>
    
<div class="container word-state" style="position:relative;">
	<div class="work-side pull-left">
		<ul id="mall-tree" >
	
	    </ul>
        <%-- <div class="menu-box">
            <h3 class='setTop'><span id="bar-name">银达通</span><span class="glyphicon glyphicon-triangle-bottom right-indirectior"></span></h3>
            <ul class="list-group" id="group3-list">
	            <li><a href="javascript:iframeSrc('${ctx}/views/cloudPay/paymentList.jsp')">账号管理</a></li>
	            <li><a href="javascript:iframeSrc('${ctx}/views/cloudPay/apiList.jsp')">应用程序</a></li>
	            <li><a href="javascript:iframeSrc('${ctx}/views/cloudPay/apiList.jsp')">友德医充值</a></li>
	            <li><a href="${ctx}/views/developer/apiListdeveloper.jsp">我的应用程序</a></li>
	            <li><a href="${ctx}/views/developer/paymentListdeveloper.jsp">我的账号</a></li>
            </ul>
        </div>
        <div class="menu-box">
            <h3 class='setTop'><span>订单查询</span><span class="glyphicon glyphicon-triangle-bottom right-indirectior"></span></h3>
            <ul class="list-group" id="group3-list">
	            <li><a href="javascript:iframeSrc('${ctx}/views/cloudPay/orderQuery/orderDetails.jsp')" >订单明细</a></li>
	            <li><a href="javascript:iframeSrc('${ctx}/views/cloudPay/orderQuery/returnDetails.jsp')" >退款明细</a></li>
	             <li><a href="javascript:iframeSrc('${ctx}/views/cloudPay/orderQuery/orderReport.jsp')" >订单报表</a></li>
	            <li><a href="javascript:iframeSrc('${ctx}/views/cloudPay/orderQuery/returnReport.jsp')" >退款报表</a></li> 
	          
	            <li><a href="${ctx}/views/cloudPay/orderQuery/subMerchantTransaction.jsp" >子商户交易汇总</a></li>
            </ul>
        </div> --%>
    </div>   
    <script type="text/javascript">
    var isadmin="${currentUser.isadmin}"  
    var jsonuser = {
    		"statusCode": 200,
    		"msg": "success",
    		"data": [{
    			"menuId": "46fb95def69f40fea73d7fc952761d11",
    			"parentId": "0",
    			"name": "订单查询",
    			"url": null,
    			"perms": null,
    			"type": 0,
    			"icon": "iconfont icon-jiekouguanli",
    			"orderNum": null,
    			"createDate": null,
    			"modifyDate": null,
    			"deleteFlag": null,
    			"status": null,
    			"hasUnion": null,
    			"canDefinite": null,
    			"open": null,   		
    			"list": [{
    				"menuId": "0f6b04ed73894f0fbadb9ab52f1747b7",
    				"parentId": "46fb95def69f40fea73d7fc952761d11",
    				"name": "订单明细",
    				"url": "/views/cloudPay/orderQuery/orderDetails.jsp",
    				"perms": null,
    				"type": 1,
    				"icon": null,
    				"orderNum": null,
    				"createDate": null,
    				"modifyDate": null,
    				"deleteFlag": null,
    				"status": null,
    				"hasUnion": null,
    				"canDefinite": null,
    				"open": null,
    				"list": null,
    				"parentName": null
    			}, {
    				"menuId": "1b2e3e1cff174f95b85400343c9af562",
    				"parentId": "46fb95def69f40fea73d7fc952761d11",
    				"name": "退款明细",
    				"url": "/views/cloudPay/orderQuery/returnDetails.jsp",
    				"perms": null,
    				"type": 1,
    				"icon": null,
    				"orderNum": null,
    				"createDate": null,
    				"modifyDate": null,
    				"deleteFlag": null,
    				"status": null,
    				"hasUnion": null,
    				"canDefinite": null,
    				"open": null,
    				"list": null,
    				"parentName": null
    			}, {
    				"menuId": "4725cc455c0c4a8d9a3992497a95b190",
    				"parentId": "46fb95def69f40fea73d7fc952761d11",
    				"name": "订单报表",
    				"url": "/views/cloudPay/orderQuery/orderReport.jsp",
    				"perms": null,
    				"type": 1,
    				"icon": "iconfont icon-shujujiekou",
    				"orderNum": null,
    				"createDate": null,
    				"modifyDate": null,
    				"deleteFlag": null,
    				"status": null,
    				"hasUnion": null,
    				"canDefinite": null,
    				"open": null,
    				"list": null,
    				"parentName": null
    			}, {
    				"menuId": "abd0ba4d0fdd453988287565953481c2",
    				"parentId": "46fb95def69f40fea73d7fc952761d11",
    				"name": "退款报表",
    				"url": "/views/cloudPay/orderQuery/returnReport.jsp",
    				"perms": null,
    				"type": 1,
    				"icon": null,
    				"orderNum": null,
    				"createDate": null,
    				"modifyDate": null,
    				"deleteFlag": null,
    				"status": null,
    				"hasUnion": null,
    				"canDefinite": null,
    				"open": null,
    				"list": null,
    				"parentName": null
    			}],
    			"parentName": null
    		},{
    			"menuId": "7d07e639aa644cd4b84c80514c452012",
    			"parentId": "0",
    			"name": "银达通",
    			"url": null,
    			"perms": null,
    			"type": 0,
    			"icon": "iconfont icon-shouye",
    			"orderNum": null,
    			"createDate": null,
    			"modifyDate": null,
    			"deleteFlag": null,
    			"status": null,
    			"hasUnion": null,
    			"canDefinite": null,
    			"open": null,
    			"list": [{
    				"menuId": "22470b0638324de9b458a4478522b650",
    				"parentId": "7d07e639aa644cd4b84c80514c452012",
    				"name": "微信对账",
    				"url": "/views/cloudPay/wxpayReconciliation.jsp",
    				"perms": null,
    				"type": 1,
    				"icon": null,
    				"orderNum": null,
    				"createDate": null,
    				"modifyDate": null,
    				"deleteFlag": null,
    				"status": null,
    				"hasUnion": null,
    				"canDefinite": null,
    				"open": null,
    				"list": null,
    				"parentName": null
    			}, {
    				"menuId": "95fd0a511f4649c584e7a4b066ce3290",
    				"parentId": "7d07e639aa644cd4b84c80514c452012",
    				"name": "阿里对账",
    				"url": "/views/cloudPay/wxpayReconciliation.jsp",
    				"perms": null,
    				"type": 1,
    				"icon": "iconfont icon-fukuan",
    				"orderNum": null,
    				"createDate": null,
    				"modifyDate": null,
    				"deleteFlag": null,
    				"status": null,
    				"hasUnion": null,
    				"canDefinite": null,
    				"open": null,
    				"list": null,
    				"parentName": null
    			}],
    			"parentName": null
    		}],
    		"rows": null
    	}
    
    
    var json = {
    		"statusCode": 200,
    		"msg": "success",
    		"data": [{
    			"menuId": "7d07e639aa644cd4b84c80514c4520ba",
    			"parentId": "0",
    			"name": "银达通",
    			"url": null,
    			"perms": null,
    			"type": 0,
    			"icon": "iconfont icon-shouye",
    			"orderNum": null,
    			"createDate": null,
    			"modifyDate": null,
    			"deleteFlag": null,
    			"status": null,
    			"hasUnion": null,
    			"canDefinite": null,
    			"open": null,
    			"list": [{
    				"menuId": "22470b0638324de9b458a4478522b650",
    				"parentId": "7d07e639aa644cd4b84c80514c4520ba",
    				"name": "账号管理",
    				"url": "/views/cloudPay/paymentList.jsp",
    				"perms": null,
    				"type": 1,
    				"icon": null,
    				"orderNum": null,
    				"createDate": null,
    				"modifyDate": null,
    				"deleteFlag": null,
    				"status": null,
    				"hasUnion": null,
    				"canDefinite": null,
    				"open": null,
    				"list": null,
    				"parentName": null
    			}, {
    				"menuId": "95fd0a511f4649c584e7a4b066ce3290",
    				"parentId": "7d07e639aa644cd4b84c80514c4520ba",
    				"name": "应用程序",
    				"url": "/views/cloudPay/apiList.jsp",
    				"perms": null,
    				"type": 1,
    				"icon": "iconfont icon-fukuan",
    				"orderNum": null,
    				"createDate": null,
    				"modifyDate": null,
    				"deleteFlag": null,
    				"status": null,
    				"hasUnion": null,
    				"canDefinite": null,
    				"open": null,
    				"list": null,
    				"parentName": null
    			}],
    			"parentName": null
    		}, {
    			"menuId": "46fb95def69f40fea73d7fc952761d11",
    			"parentId": "0",
    			"name": "订单查询",
    			"url": null,
    			"perms": null,
    			"type": 0,
    			"icon": "iconfont icon-jiekouguanli",
    			"orderNum": null,
    			"createDate": null,
    			"modifyDate": null,
    			"deleteFlag": null,
    			"status": null,
    			"hasUnion": null,
    			"canDefinite": null,
    			"open": null,
    		
    			"list": [{
    				"menuId": "0f6b04ed73894f0fbadb9ab52f1747b7",
    				"parentId": "46fb95def69f40fea73d7fc952761d11",
    				"name": "订单明细",
    				"url": "/views/cloudPay/orderQuery/orderDetails.jsp",
    				"perms": null,
    				"type": 1,
    				"icon": null,
    				"orderNum": null,
    				"createDate": null,
    				"modifyDate": null,
    				"deleteFlag": null,
    				"status": null,
    				"hasUnion": null,
    				"canDefinite": null,
    				"open": null,
    				"list": null,
    				"parentName": null
    			}, {
    				"menuId": "1b2e3e1cff174f95b85400343c9af562",
    				"parentId": "46fb95def69f40fea73d7fc952761d11",
    				"name": "退款明细",
    				"url": "/views/cloudPay/orderQuery/returnDetails.jsp",
    				"perms": null,
    				"type": 1,
    				"icon": null,
    				"orderNum": null,
    				"createDate": null,
    				"modifyDate": null,
    				"deleteFlag": null,
    				"status": null,
    				"hasUnion": null,
    				"canDefinite": null,
    				"open": null,
    				"list": null,
    				"parentName": null
    			}, {
    				"menuId": "4725cc455c0c4a8d9a3992497a95b190",
    				"parentId": "46fb95def69f40fea73d7fc952761d11",
    				"name": "订单报表",
    				"url": "/views/cloudPay/orderQuery/orderReport.jsp",
    				"perms": null,
    				"type": 1,
    				"icon": "iconfont icon-shujujiekou",
    				"orderNum": null,
    				"createDate": null,
    				"modifyDate": null,
    				"deleteFlag": null,
    				"status": null,
    				"hasUnion": null,
    				"canDefinite": null,
    				"open": null,
    				"list": null,
    				"parentName": null
    			}, {
    				"menuId": "abd0ba4d0fdd453988287565953481c2",
    				"parentId": "46fb95def69f40fea73d7fc952761d11",
    				"name": "退款报表",
    				"url": "/views/cloudPay/orderQuery/returnReport.jsp",
    				"perms": null,
    				"type": 1,
    				"icon": null,
    				"orderNum": null,
    				"createDate": null,
    				"modifyDate": null,
    				"deleteFlag": null,
    				"status": null,
    				"hasUnion": null,
    				"canDefinite": null,
    				"open": null,
    				"list": null,
    				"parentName": null
    			}],
    			"parentName": null
    		},{
    			"menuId": "7d07e639aa644cd4b84c80514c452012",
    			"parentId": "0",
    			"name": "支付对账",
    			"url": null,
    			"perms": null,
    			"type": 0,
    			"icon": "iconfont icon-shouye",
    			"orderNum": null,
    			"createDate": null,
    			"modifyDate": null,
    			"deleteFlag": null,
    			"status": null,
    			"hasUnion": null,
    			"canDefinite": null,
    			"open": null,
    			"list": [{
    				"menuId": "22470b0638324de9b458a4478522b650",
    				"parentId": "7d07e639aa644cd4b84c80514c452012",
    				"name": "微信对账",
    				"url": "/views/cloudPay/orderQuery/wxpayReconciliation.jsp",
    				"perms": null,
    				"type": 1,
    				"icon": null,
    				"orderNum": null,
    				"createDate": null,
    				"modifyDate": null,
    				"deleteFlag": null,
    				"status": null,
    				"hasUnion": null,
    				"canDefinite": null,
    				"open": null,
    				"list": null,
    				"parentName": null
    			}, {
    				"menuId": "95fd0a511f4649c584e7a4b066ce3290",
    				"parentId": "7d07e639aa644cd4b84c80514c452012",
    				"name": "阿里对账",
    				"url": "/views/cloudPay/orderQuery/alipayReconciliation.jsp",
    				"perms": null,
    				"type": 1,
    				"icon": "iconfont icon-fukuan",
    				"orderNum": null,
    				"createDate": null,
    				"modifyDate": null,
    				"deleteFlag": null,
    				"status": null,
    				"hasUnion": null,
    				"canDefinite": null,
    				"open": null,
    				"list": null,
    				"parentName": null
    			}],
    			"parentName": null
    		}],
    		"rows": null
    	}
    
	$(document).ready(function () {
		$(document).on("click", "#mall-tree > li >a", function(){
	    	$(this).find("i").toggleClass("transRotate");
	    });
		//--加载菜单------------------------------------
		 /* $.ajax({
			type:"GET",
			url:'${ctx}/system/menu/listUserMenu.action?v=${version}',		
			cache:false,
			dataType:"json",
			success:function (json){ */
				//--父菜单----------
				
				if(isadmin==1)
				{
					var rows = json.data;
				}else{
					var rows = jsonuser.data;				
				}
				
				var zNodes = [];
				
				//$.each(rows, function (i, item) {
				for(var i = 0; i<rows.length; i++){
					var item = rows[i];
					var parentNode = {
						"id": item.menuId,
						"name": item.name + "<i class='glyphicon glyphicon-triangle-bottom pull-right'></i>",
						"pId": item.parentId,
						"seq": item.orderNum
					};

					zNodes.push(parentNode);

					//---二级菜单---------------------------------------------
					var list = item.list;
					if(list != null && list.length >0){
						//$.each(list, function (i, item) {
						for(var j = 0; j<list.length; j++) {
							var childItem = list[j];
							var childNode = {
								"id": childItem.menuId,
								"name": "<span class='" + childItem.icon + "'></span>" + childItem.name,
								"pId": childItem.parentId,
								"seq": childItem.orderNum
							};
							var childList = childItem.list;
							if(childList == null || childList.length == 0){
								childNode.click = "tabShow('" + childItem.name + "','${ctx}" + childItem.url + "')";
							}
							zNodes.push(childNode);

							//---三级菜单-------------------------------------------------------------
							if(childList != null && childList.length > 0){
								for(var k = 0; k<childList.length; k++) {
									var grandsonItem =  childList[k];
									var grandsonNode = {
										"click": "tabShow('" + grandsonItem.name + "','${ctx}" + grandsonItem.url + "')",
										"id": grandsonItem.menuId,
										"name": "<span class='" + grandsonItem.icon + "'></span>" + grandsonItem.name,
										"pId": grandsonItem.parentId,
										"seq": grandsonItem.orderNum
									};
									zNodes.push(grandsonNode);
								}
							}

						}
					}
				}

				$.fn.zTree.init($("#mall-tree"), setting, zNodes);
				var treeObj = $.fn.zTree.getZTreeObj("mall-tree");
				treeObj.expandAll(true);
			/* } 
		}); */
	});

    //  ==========
    //  = ztree设置结束 =
    //  ==========
    function tabShow(title, url) {
        if (url != "") {
            console.log(url);
            $('iframe').attr('src', url);
        }

    }
    
</script>
    
    
   
		 	
		 	