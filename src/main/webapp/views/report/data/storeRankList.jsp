<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/header.jsp" %>
<style>
    .sValue label{margin: 0;padding:0;font-weight:normal;line-height: 30px;}
    .sValue label input{margin: 0 4px 0 0;}
    .form-control {width:100% !important;height:30px !important}
    .showDate{display:inline-block;height:30px;line-height:30px;}
</style>

<!-- 门店数据列表 -->
<div class="main">
    <div class="contrain">
    	<div id="toolbar" role="group">
            <div class="btn-group" v-cloak>
            	<button v-for="(item, index) in btnData" :id="item.id" type="button" class="btn btn-default" :class="index == 0 ? 'active' : null">{{item.name}}</button>
            </div>
        </div>
        <div class="surround">
            <div class="fullcontent noOutwrap">
                <form action="" id="searchForm" class="form-inline form-search">
                    <div class="form-group clearfix form-100w">
                        <span class="eName col-md-3 col-sm-6 col-xs-12 col-lg-4">
                            <label class="text-info">门店名称：</label>
                            <span class="sValue">
                            	<input class="col-xs-12 form-control" type="text" @keyup.enter="btnSearch" placeholder="请输入门店名称" name="productName" data-op="LK"/>
                            </span>
                        </span>
                        <span class="eName col-md-3 col-sm-6 col-xs-12 col-lg-3">
                            <a href="javascript:void(0);" id="btnSearch" @click="btnSearch" style="position: relative;top: 3px;" class="button bPrimary"><i class="iconfont">&#xe614;</i>查询</a>
                            <a href="###" id="btnReset" @click="btnReset" style="position: relative;top: 3px;" class="button bSuccess"><i class="iconfont">&#xe615;</i>重置</a>
                        </span>
                    </div>
                </form>
                <div>
                    <table id="table" class="table-align table-striped table-hover table-condensed"data-mobile-responsive="true"></table>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    var marketInfoVm = new Vue({
    	el:".main",
    	data: function(){
    		return{
    			btnData:[
    				{
    					"id":"btnDay",
    					"name":"今日"
    				},{
    					"id":"btnMouth",
    					"name":"今月"
    				},{
    					"id":"btnYear",
    					"name":"今年"
    				}
    			]
    		}
    	},
    	methods:{
    		//初始化表格
    		initTableData: function(){
    			initBootstrapTable('#table', {
    	            //url: "${ctx}/base/supplier/listByPage.action",
    	            toolbar: '#toolbar',
    	            height: $(document.body).height() - 120,
    	            columns: [
    	                {field: 'productName',title: '门店名称',align: 'center', valign: 'middle',sortable: true},
    	                {field: 'percentage',title: '完成率',align: 'center', valign: 'middle',sortable: true,formatter: formatNumWan},
    	                {field: 'market',title: '销售',align: 'center',valign: 'middle',sortable: true ,formatter: formatNumWan},
    	                {field: 'gross',title: '毛利',align: 'center',valign: 'middle',sortable: true,formatter: formatNumWan},
    	                {field: 'guestFolio',title: '客单',width:120,align: 'center',valign: 'middle',sortable: true,formatter: formatNumWan},
    	                {field: 'passengerFlow',title: '客流',align: 'center',valign: 'middle',sortable: true,formatter: formatNumWan}
    	             ],
    	             data:[
    	            	 {
    	            		 productName: "健康大药房",
    	            		 percentage: "16456415615",
    	            		 market: "64848496",
    	            		 gross :"46494451",
    	            		 guestFolio :"46494451",
    	            		 passengerFlow :"46494451"
    	            	 },{
    	            		 productName: "健康大药房",
    	            		 percentage: "16456415615",
    	            		 market: "64848496",
    	            		 gross :"46494451",
    	            		 guestFolio :"46494451",
    	            		 passengerFlow :"46494451"
    	            	 },{
    	            		 productName: "健康大药房",
    	            		 percentage: "16456415615",
    	            		 market: "64848496",
    	            		 gross :"46494451",
    	            		 guestFolio :"46494451",
    	            		 passengerFlow :"46494451"
    	            	 }
    	             ]
    	        });
    		},
    		//初始化按钮组选中
    		initBtnGroupSelected: function(){
    			$(".btn-group .btn").on("click", function(){
    				$(this).addClass("active").siblings().removeClass("active");
    				$(".showDate .eName").eq($(this).index()).show().siblings().hide();
    			});
    		},
    		//初始化日期选择框
    		initDateSelected: function(){
    			$(".showDate .eName").eq($(".btn-group .btn.active").index()).show().siblings().hide();
    		},
    		//重置
    	    btnReset: function () {
    	        $("#searchForm")[0].reset();
    	        tableSearch("#table", "#searchForm");
    	    },
    	    //搜索
    	    btnSearch :function(){
    	    	tableSearch("#table", "#searchForm");
    	    },
    	  	//初始化按天查询
    	    initDay: function(){
    	    	var that = this;
    	    	laydate({
    	        	elem: '#day',
    	            format: 'YYYY-MM-DD',
    	            istime: false,
    	            max: laydate.now(),
    	            istoday: true,
    	            choose: function(dates){alert(111111)}
    	    	});
    	    },
    	  	//初始化按月查询
    	    initMouth: function(){
    	    	var that = this;
    	    	laydate({
    	        	elem: '#mouth',
    	            format: 'YYYY-MM',
    	            max: laydate.now(),
    	            choose: function(dates){alert(222222)}
    	    	});
    	    },
    	  //初始化按年查询
    	    initYear: function(){
    	    	var that = this;
    	    	laydate({
    	        	elem: '#year',
    	            format: 'YYYY',
    	            max: laydate.now(),
    	            choose: function(dates){alert(3333)}
    	    	});
    	    }
    	},
    	mounted:function(){
    		//初始化表格
    		this.initTableData();
    		//初始化按钮组选中
    		this.initBtnGroupSelected();
    		//皮肤
    	    laydate.skin('molv');
    		//初始化按天查询
    		this.initDay();
    		//初始化按月查询
    	    this.initMouth();
    	  	//初始化按年查询
    	    this.initYear();
    	  	//初始化日期选择框显示
    	  	this.initDateSelected();
    	}
    })
    
    
</script>
<%@include file="/common/footer.jsp" %>
