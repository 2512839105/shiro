<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/header.jsp" %>
<style>
.conditionSearch{border-bottom:1px solid #ddd;width:100%;}
.conditionSearch .eName>a{height:30px;line-height:30px;}
.dataShow>.list-inline>li{padding-bottom:0px!important;}
</style>
<!-- 区域速报 -->
<div class="dataReport">
    <div class="contrain">
        <!-- 数据显示 -->
        <div class="dataShow">
        	<!-- 条件搜索 -->
	    	<div class="conditionSearch">
	    		 <form action="" id="searchForm" class="form-inline form-search">
	                 <div class="form-group clearfix form-100w">
	                       <span class="eName col-md-3 col-sm-6 col-xs-12 col-lg-3">
	                           <label class="text-info">门店名称：</label>
	                           <span class="sValue">
	                           	<!-- <input type="text" class="form-control" placeholder="请输入门店名称" id="storeName" name="storeId" data-op="EQ" /> -->
	                           	<select id="storeName" class="selectpicker" name="storeId" data-op="EQ"  data-live-search="true" data-live-search-placeholder="搜索" >
                                	<option value="">请选择</option>
                                </select>
	                           </span>
	                      </span>
	                      <span class="eName col-md-3 col-sm-6 col-xs-12 col-lg-2">
	                          <a href="###" id="btnSearch" class="button bPrimary"><i  class="iconfont">&#xe614;</i>查询</a>
	                          <a href="###" id="btnReset" class="button bSuccess"><i class="iconfont">&#xe615;</i>重置</a>
	                      </span>
	                  </div>
	            </form>
	    	</div>
	    	<!-- 条件搜索 -->
	        <!-- 按钮组 -->
        	<div class="btn-group">
        		<button type="button" class="btn btn-default active">按天</button>
        		<button type="button" class="btn btn-default">按周</button>
        		<button type="button" class="btn btn-default">按月</button>
        		<button type="button" class="btn btn-default">按年</button>
        	</div>
        	<!-- /按钮组 -->
        	<ul class="list-inline clearfix">
        		<!-- 图标数据 -->
        		<li class="col-xs-12">
        			<div class="mian">
        				<div id="areaInfo" class="DataList" style="height:450px;"></div>
        				<!-- <div class="msg">
        					<p class="day"><span class="bsi">今天指数：<em>20</em></span><span class="contrast">对比上涨：<em>15%</em></span></p>
        					<p class="week"><span class="bsi">今周指数：<em>200</em></span><span class="contrast">对比上涨：<em>15%</em></span></p>
        					<p class="moutg"><span class="bsi">今月指数：<em>2000</em></span><span class="contrast">对比上涨：<em>15%</em></span></p>
        					<p class="year"><span class="bsi">今年指数：<em>20000</em></span><span class="contrast">对比上涨：<em>15%</em></span></p>
        				</div> -->
        			</div>
        		</li>
        		<!-- /图标数据 -->
        	</ul>
        </div>
        <!-- /数据显示 -->
    </div>
</div>
<script type="text/javascript" src="./statics/config.js"></script>
<script type="text/javascript">
	new Vue({
		el:".main",
		data:function(){
			return{
				//定义图表数据
				MarketListData :[],
			}
		},
		methods:{
			//初始化图表
			initAreaList :function(){
				var that = this;
				// 基于准备好的dom，初始化echarts实例
		        var myChart = echarts.init(document.getElementById('areaInfo'));
				//获取当前日期
				var date = new Date();
				//获取当前月
				var mouth = date.getMonth() + 1;
				//获取当前日 
				var day = date.getDate();
		        // 指定图表的配置项和数据
		        var option = {
		            title: {
		                text: '区域速报门店详细'
		            },
		            tooltip: {
		            	trigger: 'axis',
		                axisPointer : {            // 坐标轴指示器，坐标轴触发有效
		                    type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
		                }
		            },
		            legend: {
		                data:['完成率',"销售","毛利","客单","客流"]
		            },
		            xAxis: {
		            	type : 'category',
		                data: [mouth+"月"+(day-6), mouth+"月"+(day-5), mouth+"月"+(day-4), mouth+"月"+(day-3), mouth+"月"+(day-2), mouth+"月"+(day-1), mouth+"月"+day]
		            },
		            yAxis: {
		                type: 'value'
		            },
		            series: [{
		                name: '完成率',
		                type: 'bar',
		                markPoint : {
		                    data : [
		                        {type : 'max', name: '最大值'},
		                        {type : 'min', name: '最小值'}
		                    ]
		                },
		                markLine : {
		                    data : [
		                        {type : 'average', name: '平均值'}
		                    ]
		                },
		                data: [5, 20, 36, 10, 10, 200,20]
		            },{
		                name: '销售',
		                type: 'bar',
		                markPoint : {
		                    data : [
		                        {type : 'max', name: '最大值'},
		                        {type : 'min', name: '最小值'}
		                    ]
		                },
		                markLine : {
		                    data : [
		                        {type : 'average', name: '平均值'}
		                    ]
		                },
		                data: [5, 20, 36, 10, 10, 20,20]
		            },{
		                name: '毛利',
		                type: 'bar',
		                markPoint : {
		                    data : [
		                        {type : 'max', name: '最大值'},
		                        {type : 'min', name: '最小值'}
		                    ]
		                },
		                markLine : {
		                    data : [
		                        {type : 'average', name: '平均值'}
		                    ]
		                },
		                data: [5, 20, 36, 10, 10, 20,20]
		            },{
		                name: '客单',
		                type: 'bar',
		                markPoint : {
		                    data : [
		                        {type : 'max', name: '最大值'},
		                        {type : 'min', name: '最小值'}
		                    ]
		                },
		                markLine : {
		                    data : [
		                        {type : 'average', name: '平均值'}
		                    ]
		                },
		                data: [5, 20, 36, 10, 10, 20,20]
		            },{
		                name: '客流',
		                type: 'bar',
		                markPoint : {
		                    data : [
		                        {type : 'max', name: '最大值'},
		                        {type : 'min', name: '最小值'}
		                    ]
		                },
		                markLine : {
		                    data : [
		                        {type : 'average', name: '平均值'}
		                    ]
		                },
		                data: [5, 20, 36, 10, 10, 20,20]
		            }]
		        };
		        // 使用刚指定的配置项和数据显示图表。
		        myChart.setOption(option);
			}
		},
		mounted:function(){
			//初始化图表
			this.initAreaList();
		}
	})
</script>
<%@include file="/common/footer.jsp" %>
