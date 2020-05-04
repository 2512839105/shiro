<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/header.jsp" %>
<style>
.dataReport,.contrain{height:auto!important;background:#f9f9f9!important;padding:0!important;}
.boxBg{padding:8px!important;background:#ffffff;margin-bottom:8px;}
.conditionSearch{border-bottom:1px solid #ddd;width:100%;}
.conditionSearch .eName>a{height:30px;line-height:30px;}
.dataShow>.list-inline>li{padding-bottom:0px!important;}
.dataShow>.list-inline>li>.mian>.msg{bottom:-70px;}
.dataBox>.palBox{display:none;}
.dataBox>.active{display:block!important;}
.dataShow .list-inline>li{padding-bottom:0px;}
.dataShow .list-inline>li>.mian>.msg{bottom:0px;}

.storeCol6{position:relative;}
.storeCol6 .selectOl{position:absolute;top:-6px;right:77px;}
.btn-group>.storeName{font-size:14px;margin-top:5px;}
.btn-group>.storeName>span{font-weight:700;font-size:15;}
</style>
<!-- 店长速报 -->
<div class="dataReport">
    <div class="contrain">
        <!-- 数据显示 -->
        <div class="dataShow managerList">
        	<!-- 条件搜索 -->
	    	<!-- <div class="conditionSearch boxBg">
	    		 <form action="" id="searchForm" class="form-inline form-search">
	                 <div class="form-group clearfix form-100w">
	                       <span class="eName col-md-3 col-sm-6 col-xs-12 col-lg-3">
	                           <label class="text-info">门店名称：</label>
	                           <span class="sValue">
	                           	<select id="storeName" class="selectpicker" name="storeId" data-op="EQ"  data-live-search="true" data-live-search-placeholder="搜索" v-model="selectStore" v-cloak>
                                	<option v-for="(store, index) in storeData" :value="store.storeId">{{store.storeName}}</option>
                                </select>
	                           </span>
	                      </span>
	                  </div>
	            </form>
	    	</div> -->
	    	<!-- 条件搜索 -->
	        <!-- 按钮组 -->
        	<div class="btn-group boxBg" v-cloak>
        		<button v-for="(item, index) in btnData" :id="item.id" :date_type="item.dateType" type="button" @click="btnChangeActive(item.id,$event,item.dateType)" class="btn btn-default" :class="index == 0 ? 'active' : null">{{item.name}}</button>
        		<p class="storeName text-center">当前门店：<span>{{storeName}}</span></p>
        	</div>
        	<!-- /按钮组 -->
	        <div class="dataBox">
	        	<div class="rigthTime palBox active clearfix">
	        		<!-- <div class="row boxBg">
	        			比对今天和昨天
		        		<div class="comparison-date col-xs-9">
		        			<div id="comparison-date-list" class="DataList" style="height:350px;"></div>
		        		</div>
		        		/比对今天和昨天
		        		<div class="comparison-textInfo col-xs-3">
		        			<table class="table" style="margin-top:30px;">
		        				<thead>
		        					<tr>
		        						<td>顺序</td>
		        						<td>关键词</td>
		        						<td>今日占比</td>
		        						<td>昨日占比</td>
		        					</tr>
		        				</thead>
		        				<tbody v-cloak>
		        					<tr v-for="(item, index) in toLastData.xData"><td>{{index}}</td><td>{{item}}</td><td>{{toLastData.lastDate[index] != 'undefined' || toLastData.thisDate[index] != 'undefined' ? parseFloat(toLastData.thisDate[index]/(toLastData.thisDate[index] + toLastData.lastDate[index])).toFixed(2) : '-'}}</td><td>{{ toLastData.lastDate[index] != 'undefined' || toLastData.thisDate[index] != 'undefined' ? parseFloat(toLastData.lastDate[index]/(toLastData.thisDate[index] + toLastData.lastDate[index])).toFixed(2) : "-"}}</td></tr>
		        				</tbody>
		        			</table>
		        		</div>
	        		</div> -->
	        		<div class="row boxBg">
	        			<!-- 门店业绩曲线图 -->
	        			<div class="storePerformance storeCol6 col-xs-12">
	        				<div id="Performance-list" class="DataList" style="height:600px;"></div>
	        				<div class="selectOl">
	        					<form class="form-inline">
	        						<div class="form-group">
	        							<div class="radio">
									        <label>
									          <input type="radio" class="form-control" id="Performance-jin7Day" value="Performance-jin7Day" name="Performance-selectDay" v-model="radioCheck" /> 近7天
									        </label>
									    </div>
	        						</div>
	        						<div class="form-group">
	        							<div class="radio">
									        <label>
									          <input type="radio" class="form-control" id="Performance-jin3Month" value="Performance-jin3Month" name="Performance-selectDay" v-model="radioCheck" /> 近6月
									        </label>
									    </div>
	        						</div>
	        					</form>
	        				</div>
	        			</div>
	        			<!-- /门店业绩曲线图 -->
	        		</div>
	        	</div>
	        	<div class="dateData palBox">
	        		<ul class="list-inline clearfix">
		        		<!-- 销售额 -->
		        		<li class="col-xs-4">
		        			<div class="mian">
		        				<div id="marketList" class="DataList" style="height:500px;width:600px;"></div>
		        			</div>
		        		</li>
		        		<!-- /销售额 -->
		        		<!-- 毛利率 -->
		        		<li class="col-xs-4">
		        			<div class="mian">
		        				<div id="MaoriList" class="DataList" style="height:500px;width:600px;"></div>
		        			</div>
		        		</li>
		        		<!-- /毛利率 -->
		        		<!-- 客流量 -->
		        		<li class="col-xs-4">
		        			<div class="mian">
		        				<div id="personTimeList" class="DataList" style="height:500px;width:600px;"></div>
		        			</div>
		        		</li>
		        		<!-- /客流量 -->
		        	</ul>
	        	</div>	
	        </div>
        </div>
        <!-- /数据显示 -->
    </div>
</div>


<script type="text/javascript" src="./statics/config.js"></script>
<script type="text/javascript">
var ctx = "${ctx}";
var storeId = window.localStorage.getItem('__storeId__')
	var managerListVm = new Vue({
		el:".managerList",
		data:function(){
			return{
				btnData:[
					{ "id":"btnForWith", "name":"即时", "dateType":"r"},
					{ "id":"btnDay", "name":"按天", "dateType":"d" },
					{ "id":"btnWeek", "name":"按周", "dateType":"w" },
					{ "id":"btnMonth", "name":"按月", "dateType":"m" },
					{ "id":"btnYear", "name":"按年", "dateType":"y" }
				],
				storeName: window.localStorage.getItem('__storeName__'),
				findGetData:{},
				isTypeData:{"storeId":""},
				store:{"storeId":"", "storeName":""},
				toLastData:{"xData":[], "thisDate":[], "lastDate":[]},
				radioCheck:"Performance-jin7Day",
				storeData:[],
				selectStore:""
			}
		},
		methods:{
			//获取数据
			getData: function(dateType, cb, that){
				var that = managerListVm ? managerListVm : that;
				var storeId = that.store.storeId;
				var MaoriListData = {"MaoriListDataX":[], "MaoriListDataY":[]};
				var marketListData = {"marketListDataX":[], "marketListDataY":[]};
				var personTimeListData = {"personTimeListDataX":[], "personTimeListDataY":[]};
				var huiyuanListData = {"huiyuanListDataX":[], "huiyuanListDataY":[]};
				that.isTypeData[storeId] = {};
				//初始化data值
				if(that.findGetData[storeId]){
					that.isTypeData[storeId][dateType] = that.findGetData[storeId][dateType];
				}
				var findGetDataStoreId = that.findGetData[storeId];
				var isTypeDataSType = that.isTypeData[storeId][dateType];
				
				if( findGetDataStoreId == undefined || isTypeDataSType == undefined){
					$.ajax({
						url: reportHost + "/report/report/sale/shopChief.action",
						type:"GET",
						dataType:"jsonp",
						contentType: "application/json",
						jsonp:"callback",
						data: "js_code=aer&appid=awere&secrect=aer&storeId="+storeId+"&userId=aere&dateType="+dateType+"",
						success: function(res){
							if(res.status == 200){
								that.findGetData[storeId] = {};
								eachData(res.data, dateType);
								that.findGetData[storeId][dateType] = res.data;
							}else{
								msgAlert("提示", "查询数据有误，请刷新！", "error");
							}
							cb({"MaoriListData":MaoriListData,"marketListData":marketListData,"personTimeListData":personTimeListData,"huiyuanListData":huiyuanListData});
						}
					})
				}else{
					eachData(that.isTypeData[storeId][dateType], dateType);
					cb({"MaoriListData":MaoriListData,"marketListData":marketListData,"personTimeListData":personTimeListData,"huiyuanListData":huiyuanListData});
				}
				
				function eachData(data, dateType){
					$.each(data.maoli, function(i){
						var that = this;
						MaoriListData.MaoriListDataX.push(data.maoli ? that.createDate : '');
						MaoriListData.MaoriListDataY.push(Math.abs(data.maoli ? that.grossProfit : ''));
					});
					$.each(data.xiaoshoue, function(i){
						var that = this;
						marketListData.marketListDataX.push(data.xiaoshoue ? that.createDate : '');
						marketListData.marketListDataY.push(Math.abs(data.xiaoshoue ? that.sellAmount : ''));
					});
					$.each(data.keliuliang, function(i){
						var that = this;
						personTimeListData.personTimeListDataX.push(data.keliuliang ? that.createDate : '');
						personTimeListData.personTimeListDataY.push(data.keliuliang ? that.flow : '');
					});
					if(dateType == 'r'){
						$.each(data.huiyuan, function(i){
							var that = this;
							huiyuanListData.huiyuanListDataX.push(data.huiyuan ? that.createDate : '');
							huiyuanListData.huiyuanListDataY.push(data.huiyuan ? that.sellPrice : '');
						});
					}
				}
			},
			//按钮组选中状态切换和切换按需查看信息
			btnChangeActive: function(id,e,dateType){
				//切换面板显示状态
				var that = this
				if(id == "btnForWith"){
					$(e.currentTarget).addClass("active").siblings().removeClass("active");
					$(".palBox").eq(0).addClass("active").siblings().removeClass("active");
				}else{
					$(e.currentTarget).addClass("active").siblings().removeClass("active");
					$(".palBox").eq(1).addClass("active").siblings().removeClass("active");
					managerListVm.$options.methods.initTabData(dateType);
					console.log(dateType)
					getAreaListData(storeId, dateType, function (res){
						var data = subRes(res)
						if(data.status === REQUEST_OK) {
							that._normalize(data.data)
						}
					})
				}
			},
			//初始化销售额、毛利、客流量
			initTabData: function(dateType){
				managerListVm.initMarketList("undefined");
				managerListVm.initMaoriList("undefined");
				managerListVm.initPersonTimeList("undefined");
				managerListVm.$options.methods.getData(dateType, function(jsonData){
					managerListVm.initMarketList(jsonData);
					managerListVm.initMaoriList(jsonData);
					managerListVm.initPersonTimeList(jsonData);
				});
			},
			/* 
				功能：获取时间信息
				参数：day=1 代表查询今天的日期， day=2代表查询今天和昨天的信息，day=3代表查询今天、昨天、前天的信息...
			*/
			getDateInfo :function(obj){
				var type = obj.type,dateNum = obj.dateNum;
				var dateObj = {};
				var date = new Date();
				var year = date.getFullYear();
				var mouth = String(date.getMonth()+1).length != 2 ? String(0)+String(date.getMonth()+1) : String(date.getMonth()+1);
				
				if(type == "d"){
					for(var i=0; i<dateNum; i++){
						date.setTime(new Date().getTime()-24*60*60*1000*i);
						dateObj["date"+String(i)] = date.getFullYear()+"-"+(String(date.getMonth()+1).length != 2 ? "0"+String(date.getMonth()+1):String(date.getMonth()+1))+"-"+(String(date.getDate()).length != 2 ? "0"+String(date.getDate()) : String(date.getDate()));
					}
				}else if(type == 'm'){
					for(var j=0; j<dateNum; j++){
						var thisY = mouth - j == '0' ? parseInt(year)-(1 + Math.floor(j/12)) : parseInt(year)-(Math.floor(j/12));
						var thisM = mouth - j == "0" ? "12" : (String(mouth - j).length != 2 ? "0"+String(mouth - j) : String(mouth - j));
						dateObj["date"+String(j)] = thisY+"-"+thisM;
					}
				}
				return dateObj;
			},
			//初始化今天和昨天图表
			initComparisonList :function(){
				var that = this;
				// 基于准备好的dom，初始化echarts实例
		        var myChart = echarts.init(document.getElementById('comparison-date-list'));
		        // 指定图表的配置项和数据
		        var option = {
		        	color:["#f3d024","#3bbbe0"],
		            title: {text: '实时总览', subtext: '今昨两天数据对比' },
		            tooltip: { trigger: 'axis', axisPointer: { type: 'cross',label: {backgroundColor: '#283b56' } } },
		            legend: {data:["今日","昨日"]},
		            xAxis: { type : 'category', data: ['正在加载数据...'] },
		            yAxis: { type:"value" },
		            series: [{ name: '今日', type: 'bar', label: { normal: { show: true, position: 'inside' } }, data: ['正在加载数据...']},
		            	{name: '昨日', type: 'bar', label: { normal: { show: true, position: 'inside' } }, data: ['正在加载数据...']}
		            ]
		        };
		        myChart.setOption(option);
		        that.getData("r", function(jsonData){
		        	var xData= ["毛利", "销售额", "客流量", "会员销售"],
		        		thisDate = [],
		        		lastDate = [];
		        	
		        	//获取需求时间信息
		        	var newDateObj = that.getDateInfo({"type":"d","dateNum":2});
		        	
					$.each(jsonData, function(jsonI){
						var index1 = jsonData[jsonI][jsonI+'X'].indexOf(newDateObj.date0);
						var index2 = jsonData[jsonI][jsonI+'X'].indexOf(newDateObj.date1);
						if(index1 != "-1"){ thisDate.push(jsonData[jsonI][jsonI+'Y'][index1]); }
						if(index2 != "-1"){ lastDate.push(jsonData[jsonI][jsonI+'Y'][index2]); }
					});
					
					//重新初始化今天和昨天图表
					option.xAxis.data = xData;
					option.series[0].data = thisDate;
					option.series[1].data = lastDate;
					myChart.setOption(option);
					
					//重新初始化右侧表格数据
					that.toLastData.xData = xData;
					that.toLastData.thisDate = thisDate;
					that.toLastData.lastDate = lastDate;
		        }, that);
			},
			//获取门店业绩数据
			getPerformanceData : function(obj,cb){
				var that = this,type = obj.type,data=[];
				data[type]=[],data[type].xData=[],data[type].yData=[];
				data[type].dateInfo = that.getDateInfo(obj);
				that.getData("r", function(jsonData){
					var XSE = jsonData.marketListData;
					$.each(XSE.marketListDataX, function(i){
						$.each(data[type].dateInfo, function(j){
							if(XSE.marketListDataX[i] == data[type].dateInfo[j]){
								data[type].xData.push(XSE.marketListDataX[i]);
								data[type].yData.push(XSE.marketListDataY[XSE.marketListDataX.indexOf(XSE.marketListDataX[i])]);
							}
						})
					});
					cb(data);
				}, that);
			},
			//初始化门店业绩图表
			initPerformance :function(opt){
				if(typeof opt == 'undefined'){
					throw "参数错误";return false;
				}
				var that = this;
		        var myChart = echarts.init(document.getElementById('Performance-list'));
		        var option = {
		        	color:["#f3d024"],
		            title: {text: '门店业绩曲线图'},
		            tooltip: {trigger: 'axis', axisPointer: { type: 'cross',label: {backgroundColor: '#283b56' } }},
		            legend: {data: (opt.name ? [opt.name] : ['近7天']) },
		            xAxis: { type : 'category', data: (opt.xData.length != 0 ? opt.xData : ["正在加载数据..."] ) },
		            yAxis: {type:"value"},
		            series: [{
		                name: (opt.name ? opt.name : '近7天'),
		                type: 'line',
		                label: {
		                    normal: { show: true, position: 'inside' }
		                },
		                data: (opt.yData.length != 0 ? opt.yData : ["正在加载数据..."])
		            }]
		        };
		        myChart.setOption(option);
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
		            tooltip: {},
		            legend: { data:[option.name] },
		            xAxis: { data: (jData == 'undefined' ? ['正在加载数据...'] : jData[el+'Data'][el+'DataX']) },
		            yAxis: {},
		            series: [{
		                name: option.name,
		                type: 'bar',
		                stack: '总量',
		                label: {
		                    normal: { show: true, position: 'inside' }
		                },
		                data: (jData == 'undefined' ? ['正在加载数据...'] : jData[el+'Data'][el+'DataY'])
		            }]
				}
				var myChart = echarts.init(document.getElementById(el));
				myChart.setOption(opt);
			},
			//初始化销售额图表
			initMarketList :function(jsonData){
				managerListVm.$options.methods.initChart(
					{"el":"marketList","color":"#fe7c24", "text":"销售额（万元）", "name":"销售额","jData":jsonData}
				);
			},
			//初始化毛利率图表
			initMaoriList :function(jsonData){
				managerListVm.$options.methods.initChart(
					{"el":"MaoriList","color":"#f3d024", "text":"毛利率（万元）", "name":"毛利率","jData":jsonData}
				);
			},
			//初始化客流量图表
			initPersonTimeList :function(jsonData){
				managerListVm.$options.methods.initChart(
					{"el":"personTimeList","color":"#00b3fe", "text":"客流量（人次）", "name":"客流量","jData":jsonData}
				);
			},
			//监听单选按钮变化更新数据
			watchRadioCheck :function(type, dateNum, name){
				var that = this;
				that.getPerformanceData({"type":type,"dateNum":dateNum}, function(data){
					that.initPerformance({"name":name, "xData": data[type].xData, "yData": data[type].yData});
				});
			},
			//获取折线图数据
			_getStopChief: function(storeId, dateType) {
				var that = this;
				getShopChief(storeId, 'r', function(res) {
					if(res.data.xiaoshoue.length > 0){
						var sale = res.data.xiaoshoue
						var dayList = [] //近七天
					    var dayDate = [] //近七天数据
					    var mouthList = [] //近六个月
					    var mouthDate = [] //近六个月数据
					    for (var i = 0; i < sale.length; i++) {
					      if (sale[i].createDate.length > 7) {
					        dayList.push(sale[i].sellAmount)
					        dayDate.push(sale[i].createDate)
					      } else {
					        mouthList.push(sale[i].sellAmount)
					        mouthDate.push(sale[i].createDate)
					      }
					    }
						that.dayList = dayList
						that.dayDate = dayDate
						that.mouthList = mouthList
						that.mouthDate = mouthDate
						that.initPerformance({
							yData: dayList,
							xData: dayDate
						})
					}
				})
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
				  dateList.push(sell[i].createDate)
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
			}
		},
		watch:{
			//监听用户点击的是近7天的单选按钮还是近3月的单选按钮
			radioCheck: function(newVal, oldVal){
				if(newVal != "Performance-jin3Month"){
					this.initPerformance({
						yData: this.dayList,
						xData: this.dayDate,
						name: '近7天'
					})
				}else{
					this.initPerformance({
						yData: this.mouthList,
						xData: this.mouthDate,
						name: '近6个月'
					})
				}
			},
			selectStore :function(newVal, oldVal){
				var that = this;
				var storeName = $("#storeName option[value="+newVal+"]").text();
				if(storeName){
					that.store.storeId = newVal;
					that.store.storeName = $("#storeName option[value="+newVal+"]").text();
				}
				var dataType = $(".btn-group button.active").attr("date_type");
				debugger
				if(dataType == 'r'){
					//初始化今天和昨天图表
					this.initComparisonList();
					//初始化门店业绩
					this.watchRadioCheck("d", 7, "近7天");
				}else{
					//that.initTabData(dataType);
				}
			}
		},
		mounted: function(){
			this._getStopChief(storeId)
		}
	})
</script>
<%@include file="/common/footer.jsp" %>
