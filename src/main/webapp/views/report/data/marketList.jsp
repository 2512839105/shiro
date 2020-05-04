<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/header.jsp" %>

<!-- 销售汇总 -->
<div class="dataReport">
    <div class="contrain">
        <!-- 数据显示 -->
        <div class="dataShow marketListBox">
	        <!-- 按钮组 -->
        	<div class="btn-group">
        		<button v-cloak type="button" v-for="(item, index) in btnData" :id="item.id" @click="btnChangeActive($event, item.dataType)" class="btn btn-default" :class="index == 0 ? 'active' : null" >{{item.name}}</button>
        	</div>
        	<!-- /按钮组 -->
        	<ul class="list-inline clearfix">
        		<!-- 销售额 -->
        		<li class="col-xs-4">
        			<div class="mian">
        				<div id="marketList" class="DataList" style="height:400px;"></div>
        				<div class="msg">
        					<p class="day" v-cloak><span class="bsi">今{{selectedDateType.name}}指数：<em>{{selectedDateType.thisD.XSE}}</em></span><span class="contrast">对比上涨：<em>{{ selectedDateType.thisD.XSE == 0 ? "0%" : String(((parseFloat(selectedDateType.thisD.XSE)-parseFloat(selectedDateType.lastD.XSE))/parseFloat(selectedDateType.lastD.XSE)*100).toFixed(2))+"%"}}</em></span></p>
        				</div>
        			</div>
        		</li>
        		<!-- /销售额 -->
        		<!-- 毛利率 -->
        		<li class="col-xs-4">
        			<div class="mian">
        				<div id="MaoriList" class="DataList" style="height:400px;"></div>
        				<div class="msg">
        					<p class="day" v-cloak><span class="bsi">今{{selectedDateType.name}}指数：<em>{{selectedDateType.thisD.MLL}}</em></span><span class="contrast">对比上涨：<em>{{ selectedDateType.thisD.MLL == 0 ? "0%" : String(((parseFloat(selectedDateType.thisD.MLL)-parseFloat(selectedDateType.lastD.MLL))/parseFloat(selectedDateType.lastD.MLL)*100).toFixed(2))+"%"}}</em></span></p>
        				</div>
        			</div>
        		</li>
        		<!-- /毛利率 -->
        		<!-- 客流量 -->
        		<li class="col-xs-4">
        			<div class="mian">
        				<div id="personTimeList" class="DataList" style="height:400px;"></div>
        				<div class="msg">
        					<p class="day" v-cloak><span class="bsi">今{{selectedDateType.name}}指数：<em>{{selectedDateType.thisD.KLL}}</em></span><span class="contrast">对比上涨：<em>{{ selectedDateType.thisD.KLL == 0 ? "0%" : String(((parseFloat(selectedDateType.thisD.KLL)-parseFloat(selectedDateType.lastD.KLL))/parseFloat(selectedDateType.lastD.KLL)*100).toFixed(2))+"%"}}</em></span></p>
        				</div>
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
	var marketListBoxVm = new Vue({
		el:".marketListBox",
		data:function(){
			return{
				btnData:[
					{ "id":"btnDay", "name":"按天", "dataType":"d" },
					{ "id":"btnWeek", "name":"按周", "dataType":"w" },
					{ "id":"btnMonth", "name":"按月", "dataType":"m" },
					{ "id":"btnYear", "name":"按年", "dataType":"y" }
				],
				findGetData:{
					"btnDayData":[],	//按天查询的数据
					"btnWeekData":[],	//按周查询的数据
					"btnMonthData":[],	//按月查询的数据
					"btnYearData":[]	//按年查询的数据
				},
				isTypeData:{},
				selectedDateType:{
					"name":"天",
					"thisD":{"XSE":"","KLL":"","MLL":""},
					"lastD":{"XSE":"","KLL":"","MLL":""}
				},
				contrast:{
					"day":{ "thisDate":{"XSE":"","KLL":"","MLL":""}, "lastDate":{"XSE":"","KLL":"","MLL":""} },
					"week":{ "thisDate":{"XSE":"","KLL":"","MLL":""}, "lastDate":{"XSE":"","KLL":"","MLL":""} },
					"month":{ "thisDate":{"XSE":"","KLL":"","MLL":""}, "lastDate":{"XSE":"","KLL":"","MLL":""} },
					"year":{ "thisDate":{"XSE":"","KLL":"","MLL":""}, "lastDate":{"XSE":"","KLL":"","MLL":""} }
				}
			}
		},
		methods:{
			/* 
				功能：获取当前的数据对比
			*/
			getCurDate: function(dateType){
				var that = this;
				var date = new Date();
				var date2 = new Date();
				var year = date.getFullYear();
				var mouth = String(date.getMonth()+1).length != 2 ? String(0)+String(date.getMonth()+1) : String(date.getMonth()+1);
				var day = String(date.getDate()).length != 2 ? String(0)+String(date.getDate()) : String(date.getDate());
				date2.setMonth(0);
				date2.setDate(1);
				var thisWeek = Math.ceil(Math.ceil((date-date2)/(24*60*60*1000))/7);
				if(dateType == 'd'){
					(function(that){
						var thisD = year+'-'+mouth+'-'+day;
						date.setTime(date.getTime()-24*60*60*1000);
						var lastD = date.getFullYear()+"-"+(String(date.getMonth()+1).length != 2 ? "0"+String(date.getMonth()+1):String(date.getMonth()+1))+"-"+(String(date.getDate()).length != 2 ? "0"+String(date.getDate()) : String(date.getDate()));
						eachPushContrast(thisD, lastD, 'btnDayData', that);
					})(that);
				}else if(dateType == 'w'){
					(function(that){
						var thisD = year+'-'+thisWeek;
						var lastD = year+'-'+(thisWeek-1);
						eachPushContrast(thisD, lastD, 'btnWeekData', that);
					})(that);
				}else if(dateType == 'm'){
					(function(that){
						var thisD = year+'-'+mouth;
						var LastY = mouth == '01' ? parseInt(year)-1 : year;
						var LastM = mouth == '01' ? '12' : String(parseInt(mouth)-1).length != 2 ? "0"+String(parseInt(mouth)-1) : String(parseInt(mouth)-1);
						var lastD = LastY+'-'+LastM;
						eachPushContrast(thisD, lastD, 'btnMonthData', that);
					})(that);
				}else if(dateType == 'y'){
					(function(that){
						var thisD = year;
						var lastD = parseInt(year)-1;
						eachPushContrast(thisD, lastD, 'btnYearData', that);
					})(that);
				}
				function eachPushContrast(thisD, lastD, dateType, that){
					var date = dateType == 'btnDayData' ? 'day' : ( dateType == 'btnWeekData' ? 'week' : ( dateType == 'btnMonthData' ? 'month' : ( dateType == 'btnYearData' ? 'year' : null ) ) );
					var contrast = that.contrast[date];
					var findGetData = that.findGetData[dateType];
					for(var i in findGetData.xiaoshoue){
						if(findGetData.xiaoshoue[i].createDate == thisD){
							contrast.thisDate.XSE = findGetData.xiaoshoue[i].sellAmount
						}else if(findGetData.xiaoshoue[i].createDate == lastD){
							contrast.lastDate.XSE = findGetData.xiaoshoue[i].sellAmount
						}
					}
					for(var j in findGetData.maoli){
						if(findGetData.maoli[j].createDate == thisD){
							contrast.thisDate.MLL = findGetData.maoli[j].grossProfit
						}else if(findGetData.maoli[j].createDate == lastD){
							contrast.lastDate.MLL = findGetData.maoli[j].grossProfit
						}
					}
					for(var k in findGetData.keliuliang){
						if(findGetData.keliuliang[k].createDate == thisD){
							contrast.thisDate.KLL = findGetData.keliuliang[k].flow
						}else if(findGetData.keliuliang[k].createDate == lastD){
							contrast.lastDate.KLL = findGetData.keliuliang[k].flow
						}
					}
				}
			},
			//获取数据
			getData: function(dataType, cb, that){
				var MaoriListData = {"MaoriListXData":[], "MaoriListYData":[]};
				var marketListData = {"marketListXData":[], "marketListYData":[]};
				var personTimeListData = {"personTimeListXData":[], "personTimeListYData":[]};
				var findGetType = dataType == 'd' ? 'btnDayData' : ( dataType == 'w' ? 'btnWeekData' : (dataType == 'm' ? 'btnMonthData' : (dataType == 'y' ? 'btnYearData' : "") ) );
				//初始化data值
				that.isTypeData[dataType] = that.findGetData[findGetType];
				
				if(that.isTypeData[dataType].length == 0){
					$.ajax({
						url: reportHost + "/report/report/sale/listReport.action",
						type:"GET",
						dataType:"jsonp",
						contentType: "application/json",
						jsonp:"callback",
						data: "js_code=aer&appid=awere&secrect=aer&userId=aere&dateType="+dataType+"",
						success: function(res){
							if(res.status == 200){
								eachData(res.data, dataType);
								that.findGetData[findGetType] = res.data;
							}else{
								msgAlert("提示", "查询数据有误，请刷新！", "error");
							}
							cb({"MaoriListData":MaoriListData,"marketListData":marketListData,"personTimeListData":personTimeListData});
						}
					})
				}else{
					eachData(that.isTypeData[dataType], dataType);
					cb({"MaoriListData":MaoriListData,"marketListData":marketListData,"personTimeListData":personTimeListData});
				}
				
				function eachData(data, dataType){
					var filterType = dataType == 'd' ? '日' : ( dataType == 'w' ? '周' : (dataType == 'm' ? '月' : (dataType == 'y' ? '年' : "") ) );
					$.each(data.maoli, function(i){
						var that = this;
						MaoriListData.MaoriListXData.push(this.createDate + filterType);
						MaoriListData.MaoriListYData.push(that.grossProfit);
					});
					$.each(data.xiaoshoue, function(i){
						var that = this;
						marketListData.marketListXData.push(this.createDate + filterType);
						marketListData.marketListYData.push(that.sellAmount);
					});
					$.each(data.keliuliang, function(i){
						personTimeListData.personTimeListXData.push(this.createDate + filterType);
						personTimeListData.personTimeListYData.push(this.flow);
					});
				}
			},
			//按钮组选中状态切换和切换按需查看信息
			btnChangeActive: function(e,dataType){
				var dateT =  dataType == 'd' ? '日' : ( dataType == 'w' ? '周' : (dataType == 'm' ? '月' : (dataType == 'y' ? '年' : "") ) );
				$(e.currentTarget).addClass("active").siblings().removeClass("active");
				marketListBoxVm.$options.methods.initTabData(dataType, this);
				this.selectedDateType.name = dateT;
			},
			//初始化销售额、毛利、客流量、对比信息
			initTabData: function(dataType, that){
				var dateT = dataType == 'd' ? 'day' : ( dataType == 'w' ? 'week' : (dataType == 'm' ? 'month' : (dataType == 'y' ? 'year' : "") ) );
				that.initMarketList("undefined");
				that.initMaoriList("undefined");
				that.initPersonTimeList("undefined");
				that.getData(dataType, function(jsonData){
					that.initMarketList(jsonData);
					that.initMaoriList(jsonData);
					that.initPersonTimeList(jsonData);
					that.getCurDate(dataType);
					//初始化对比信息值
					that.selectedDateType.thisD.XSE = that.contrast[dateT].thisDate.XSE;
					that.selectedDateType.thisD.KLL = that.contrast[dateT].thisDate.KLL;
					that.selectedDateType.thisD.MLL = that.contrast[dateT].thisDate.MLL;
					that.selectedDateType.lastD.XSE = that.contrast[dateT].lastDate.XSE;
					that.selectedDateType.lastD.KLL = that.contrast[dateT].lastDate.KLL;
					that.selectedDateType.lastD.MLL = that.contrast[dateT].lastDate.MLL;
				}, that);
			},
			//初始化销售额、毛利、客流量图表的选项(options)
			/*  option{ "color" :"", "text" : "", "name" : "", "Xdata" : "", "Ydata" : "" } */
			initChart :function(option){
				if(typeof option == 'undefined'){
					throw "参数错误";return false;
				}
				var el = option.el,jData = option.jData;
				var opt =  {
					color:[option.color],
		            title: { text: option.text },
		            tooltip: {
		            	trigger: 'axis',
		                 axisPointer: {
		                     type: 'cross',
		                     label: {
		                         backgroundColor: '#283b56'
		                     }
		                 }
		            },
		            legend: { data:[option.name] },
		            xAxis: { data: (jData == 'undefined' ? ['正在加载数据...'] : jData[el+'Data'][el+'XData']) },
		            yAxis: {},
		            series: [{
		                name: option.name,
		                type: 'bar',
		                stack: '总量',
		                label: {
		                    normal: { show: true, position: 'inside' }
		                },
		                data: (jData == 'undefined' ? ['正在加载数据...'] : jData[el+'Data'][el+'YData'])
		            }]
				}
				var myChart = echarts.init(document.getElementById(el));
				myChart.setOption(opt);
			},
			//初始化销售额图表
			initMarketList :function(jsonData){
				var initChart = this.initChart ? this.initChart : marketListBoxVm.$options.methods.initChart;
				initChart(
					{"el":"marketList","color":"#fe7c24", "text":"销售额（万元）", "name":"销售额","jData":jsonData}
				);
			},
			//初始化毛利率图表
			initMaoriList :function(jsonData){
				var initChart = this.initChart ? this.initChart : marketListBoxVm.$options.methods.initChart;
				initChart(
					{"el":"MaoriList","color":"#f3d024", "text":"毛利率（万元）", "name":"毛利率","jData":jsonData}
				);
			},
			//初始化客流量图表
			initPersonTimeList :function(jsonData){
				var initChart = this.initChart ? this.initChart : marketListBoxVm.$options.methods.initChart;
				initChart(
					{"el":"personTimeList","color":"#00b3fe", "text":"客流量（人次）", "name":"客流量","jData":jsonData}
				);
			},
		},
		mounted:function(){
			//初始化销售额、毛利率、客流量
			this.initTabData("d", this);
		}
	})
</script>
<%@include file="/common/footer.jsp" %>

