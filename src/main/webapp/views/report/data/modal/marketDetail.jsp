<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglibs.jsp" %>
<div>
<style>
	.marketModalTit{font-size:18px;font-weight:600px;height:38px;line-height:38px;}
	.rankMsg{}
	.rankMsg .rankStore{color:#2ea2ff;font-weight:600;margin-right:3px;}
	.rankMsg .rankJi{font-weight:bold;margin-left:3px;font-size:13px;}
</style>
	<div class="marketDetailModal">
		<h3 class="marketModalTit text-center">大包店</h3>
		<p class="rankMsg text-center"><span class="rankStore">大包店</span>2018年5月综合得分356，排名第<span class="rankJi">2</span></p>
		<div class="table-box">
			<table id="detailTable" class="table-align table-striped table-hover table-condensed " data-mobile-responsive="true"></table>
		</div>
		<div class="bgroup text-right"></div>
	    <%@include file="/common/validate.jsp" %>
    </div>
    <script type="text/javascript">
		new Vue({
			el:".marketDetailModal",
			data:function(){
				return{
					
				}
			},
			methods:{
				//初始化表格
	    		initTableData: function(){
	    			initBootstrapTable('#detailTable', {
	    	            //url: "${ctx}/base/supplier/listByPage.action",
	    	            height: 300,
	    	            pagination:false,
	    	            columns: [
	    	            	{field: 'ranking',title: '指标',align: 'center', valign: 'middle',sortable: true},
	    	                {field: 'productName',title: '本期',align: 'center', valign: 'middle',sortable: true},
	    	                {field: 'percentage',title: '排名',align: 'center', valign: 'middle',sortable: true,formatter: formatNumWan},
	    	                {field: 'market',title: '变化',align: 'center',valign: 'middle',sortable: true ,formatter: formatNumWan},
	    	                {field: 'gross',title: '得分',align: 'center',valign: 'middle',sortable: true,formatter: formatNumWan}
	    	             ],
	    	             data:[
	    	            	 {
	    	            		 ranking:"销售额",
	    	            		 productName:"19465646",
	    	            		 percentage: "2",
	    	            		 market: "",
	    	            		 gross :"100"
	    	            	 },{
	    	            		 ranking:"毛利额",
	    	            		 productName:"19465646",
	    	            		 percentage: "2",
	    	            		 market: "",
	    	            		 gross :"100"
	    	            	 },{
	    	            		 ranking:"客流量",
	    	            		 productName:"19465646",
	    	            		 percentage: "2",
	    	            		 market: "",
	    	            		 gross :"100"
	    	            	 },{
	    	            		 ranking:"客单价",
	    	            		 productName:"19465646",
	    	            		 percentage: "2",
	    	            		 market: "",
	    	            		 gross :"100"
	    	            	 },{
	    	            		 ranking:"平均客品次",
	    	            		 productName:"19465646",
	    	            		 percentage: "2",
	    	            		 market: "",
	    	            		 gross :"100"
	    	            	 },{
	    	            		 ranking:"会员销售占比",
	    	            		 productName:"19465646",
	    	            		 percentage: "2",
	    	            		 market: "",
	    	            		 gross :"100"
	    	            	 }
	    	             ]
	    	        });
	    		},
			},
			mounted:function(){
				this.initTableData();
			}
		})
	 	//防止模态框高度 大于当前窗口高度显示bug
	    initModalSize(550)
    </script>
</div>