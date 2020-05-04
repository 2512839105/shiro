<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/header.jsp" %>
<style>
.conditionSearch{border-bottom:1px solid #ddd;width:100%;}
.conditionSearch .eName>a{height:30px;line-height:30px;}
.dataShow>.list-inline>li{padding-bottom:0px!important;}
.dataShow>.list-inline>li>.mian>.msg{bottom:-70px;}
.btn-group{position:relative;}
.btn-group>.storeName{font-size:14px;margin-top:5px;}
.btn-group>.storeName>span{font-weight:700;font-size:15;}
</style>

<!-- 销售速报 -->
<div class="dataReport" id="main">
    <div class="contrain">
        <!-- 数据显示 -->
        <div class="dataShow">
        	<!-- 条件搜索 -->
	    	<!-- <div class="conditionSearch">
	    		 <form action="" id="searchForm" class="form-inline form-search">
	                 <div class="form-group clearfix form-100w">
	                       <span class="eName col-md-3 col-sm-6 col-xs-12 col-lg-3">
	                           <label class="text-info">门店名称：</label>
	                           <span class="sValue">
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
	    	</div> -->
	    	<!-- 条件搜索 -->
	        <!-- 按钮组 -->
        	<div class="btn-group">
        		<button v-for="(item, index) in selectItems" 
        			@click="selectType(item.index, item.dateType)" 
        			class="btn btn-default"
        			:class="{active : currentIndex == index}">{{item.name}}</button>
        		<!-- <button @click="selectType('d')" class="btn btn-default">按天</button>
        		<button @click="selectType('w')" class="btn btn-default">按周</button>
        		<button @click="selectType('m')" class="btn btn-default">按月</button>
        		<button @click="selectType('y')" class="btn btn-default">按年</button> -->
        		<p class="storeName text-center">当前门店：<span>{{storeName}}</span></p>
        	</div>
        	<!-- /按钮组 -->
        	<ul class="list-inline clearfix">
        		<!-- 销售额 -->
        		<li class="col-xs-4">
        			<div class="mian">
        				<div id="marketList" class="DataList" style="height:580px;"></div>
        				<!-- <div class="msg">
        					<p class="day"><span class="bsi">今天指数：<em>20</em></span><span class="contrast">对比上涨：<em>15%</em></span></p>
        					<p class="week"><span class="bsi">今周指数：<em>200</em></span><span class="contrast">对比上涨：<em>15%</em></span></p>
        					<p class="moutg"><span class="bsi">今月指数：<em>2000</em></span><span class="contrast">对比上涨：<em>15%</em></span></p>
        					<p class="year"><span class="bsi">今年指数：<em>20000</em></span><span class="contrast">对比上涨：<em>15%</em></span></p>
        				</div> -->
        			</div>
        		</li>
        		<!-- /销售额 -->
        		<!-- 毛利率 -->
        		<li class="col-xs-4">
        			<div class="mian">
        				<div id="MaoriList" class="DataList" style="height:580px;"></div>
        				<!-- <div class="msg">
        					<p class="day"><span class="bsi">今天指数：<em>20</em></span><span class="contrast">对比上涨：<em>15%</em></span></p>
        					<p class="week"><span class="bsi">今周指数：<em>200</em></span><span class="contrast">对比上涨：<em>15%</em></span></p>
        					<p class="moutg"><span class="bsi">今月指数：<em>2000</em></span><span class="contrast">对比上涨：<em>15%</em></span></p>
        					<p class="year"><span class="bsi">今年指数：<em>20000</em></span><span class="contrast">对比上涨：<em>15%</em></span></p>
        				</div> -->
        			</div>
        		</li>
        		<!-- /毛利率 -->
        		<!-- 客流量 -->
        		<li class="col-xs-4">
        			<div class="mian">
        				<div id="personTimeList" class="DataList" style="height:580px;"></div>
        				<!-- <div class="msg">
        					<p class="day"><span class="bsi">今天指数：<em>20</em></span><span class="contrast">对比上涨：<em>15%</em></span></p>
        					<p class="week"><span class="bsi">今周指数：<em>200</em></span><span class="contrast">对比上涨：<em>15%</em></span></p>
        					<p class="moutg"><span class="bsi">今月指数：<em>2000</em></span><span class="contrast">对比上涨：<em>15%</em></span></p>
        					<p class="year"><span class="bsi">今年指数：<em>20000</em></span><span class="contrast">对比上涨：<em>15%</em></span></p>
        				</div> -->
        			</div>
        		</li>
        		<!-- /客流量 -->
        	</ul>
        </div>
        <!-- /数据显示 -->
    </div>
</div>

<script type="text/javascript" src="./statics/config.js"></script>
<script type="text/javascript">
	var ctx = "${ctx}"
	var storeId = window.localStorage.getItem("__storeId__")
	new Vue({
		el:"#main",
		data: function() {
			return {
				storeName: window.localStorage.getItem('__storeName__'),
				currentIndex: 1,
				selectItems: [{
					index: 0,
					dateType: 'd',
					name: '按天'
				},{
					index: 1,
					dateType: 'w',
					name: '按周'
				},{
					index: 2,
					dateType: 'm',
					name: '按月'
				},{
					index: 3,
					dateType: 'y',
					name: '按年'
				}]
			}
		},
		methods:{
			//按钮切换
			selectType: function(index, dateType) {
				this.currentIndex = index
				this._getAreaListData(dateType)
			},
			//按天查询数据
			btnDay: function(){
				var that = this;
				
				/* $.ajax({
					url:"${ctx}/report/report/sale/listReport.action",
					type:"GET",
					contentType: "application/json",
					data: "js_code=aer&appid=awere&secrect=aer&storeId=irEH75myQYWxzW4r&userId=aere&dateType=d",
					success:function(res){
						if(res.status == 200){
							console.log(res);
						 that.MarketListData = res.xiaoshoue[0];
							that.MaoriListData = res.maoli[0];
							that.PersonTimeListData = res.xiaoshoue[0];
						}else{
							msgAlert("提示", "查询数据有误，请刷新！", "error");
						}
					}
				}); */
			},
			//初始化销售额图表
			initMarketList :function(dateList, sellList){
				var that = this;
				// 基于准备好的dom，初始化echarts实例
		        var myChart = echarts.init(document.getElementById('marketList'));			
		        var option = {
		        	color:["#fe7c24"],
		            title: {
		                text: '销售额'
		            },
		            tooltip: {},
		            legend: {
		                data:['销售额']
		            },
		            xAxis: {
		                data: dateList
		            },
		            yAxis: {},
		            series: [{
		                name: '销售额',
		                type: 'bar',
		                stack: '总量',
		                label: {
		                    normal: {
		                        show: true,
		                        position: 'inside'
		                    }
		                },
		                data: sellList
		            }]
		        };
		        // 使用刚指定的配置项和数据显示图表。
		        myChart.setOption(option);
			},
			//初始化毛利额图表
			initMaoriList :function(dateList,profitList){
				var that = this;
				// 基于准备好的dom，初始化echarts实例
		        var myChart = echarts.init(document.getElementById('MaoriList'));

		        // 指定图表的配置项和数据
		        var option = {
		        	color:["#f3d024"],
		            title: {
		                text: '毛利额'
		            },
		            tooltip: {},
		            legend: {
		                data:['毛利额']
		            },
		            xAxis: {
		                data: dateList
		            },
		            yAxis: {},
		            series: [{
		                name: '毛利额',
		                type: 'bar',
		                stack: '总量',
		                label: {
		                    normal: {
		                        show: true,
		                        position: 'inside'
		                    }
		                },
		                data: profitList
		            }]
		        };
		        // 使用刚指定的配置项和数据显示图表。
		        myChart.setOption(option);
			},
			//初始化客流量图表
			initPersonTimeList :function(dateList, flowList){
				var that = this;
				// 基于准备好的dom，初始化echarts实例
		        var myChart = echarts.init(document.getElementById('personTimeList'));
		        // 指定图表的配置项和数据
		        var option = {
		        	color:["#00b3fe"],
		            title: {
		                text: '客流量（人次）'
		            },
		            tooltip: {},
		            legend: {
		                data:['客流量']
		            },
		            xAxis: {
		                data: dateList
		            },
		            yAxis: {},
		            series: [{
		                name: '客流量',
		                type: 'bar',
		                stack: '总量',
		                label: {
		                    normal: {
		                        show: true,
		                        position: 'inside'
		                    }
		                },
		                data: flowList
		            }]
		        };
		        // 使用刚指定的配置项和数据显示图表。
		        myChart.setOption(option);
			},
			//初始化数据
			_normalize: function(data) {
				var sell = data.xiaoshoue //销售额
			    var profit = data.maoli //毛利额
			    var flow = data.keliuliang //客流量
			    
				var dateList = [] // 日期
				var sellList = [] // 销售额
				var profitList = [] // 毛利额
				var flowList = [] // 客流
				if (sell.length <= 0 || profit.length <= 0 || flow.length <= 0) {
			        return
			    }
				for (var i = 0; i < sell.length; i++) {
				  if(sell[i].createDate.length > 8) {
					  dateList.push((sell[i].createDate).slice(5))
				  } else {
					  dateList.push(sell[i].createDate)
				  }
			      sellList.push(sell[i].sellAmount)
			      profitList.push(profit[i].grossProfit)
			      flowList.push(flow[i].flow)
			    }
				//初始化销售额图表
				this.initMarketList(dateList, sellList)
				//初始化毛利率图表
				this.initMaoriList(dateList, profitList)
				//初始化客流量图表
				this.initPersonTimeList(dateList, flowList)
			},
			_getAreaListData: function(dateType) {
				var that = this
				getAreaListData(storeId, dateType, function (res){
					var data = subRes(res)
					if(data.status === REQUEST_OK) {
						that._normalize(data.data)
					}
				})
			}
		},
		created:function(){	
		},
		mounted:function(){
			var that = this
			this._getAreaListData('w')
		}
	})
</script>
<%@include file="/common/footer.jsp" %>
