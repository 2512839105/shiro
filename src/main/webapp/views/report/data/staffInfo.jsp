<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/header.jsp" %>
<link rel="stylesheet" type="text/css" href="${ctx}/views/report/data/statics/staff.css"/>

<!-- 员工详情 -->
<div class="dataReport">
    <div class="contrain">
    	<div class="row">
    		<!-- 左侧员工列表 -->
    		<div class="row-left col-xs-3">
    			<!-- 头部搜索 -->
    			<div class="top-search">
    				<form action="" id="searchForm" class="form-inline form-search">
		                 <div class="form-group clearfix form-100w">
		                      <!--  <span class="eName col-xs-9">
			                           <span class="sValue col-xs-12" style="margin:0!important;">
			                           		<input type="text" class="form-control" placeholder="门店名称/员工姓名/工号" />
			                           </span>
		                      </span>
		                      <span class="eName col-xs-3">
		                          <a href="###" id="btnSearch" class="button bPrimary"><i class="iconfont">&#xe614;</i>查询</a>
		                      </span> -->
		                  </div>
		            </form>
		             <h3 style="font-size: 18px;font-weight: bold;">当前门店：{{storeName}}</h3>
    			</div>
    			<!-- /头部搜索 -->
    			<!-- 员工列表 -->
    			<div class="staffList">
    				<table id="table" class="table-align table-striped table-hover table-condensed" data-mobile-responsive="true"></table>
    			</div>
    			<!-- /员工列表 -->
    		</div>
    		<!-- /左侧员工列表 -->
    		
    		<!-- 右侧员工列表 -->
    		<div class="row-right col-xs-12">
    			<!-- 数据显示 -->
		        <div class="dataShow">
			    	<!-- 当前员工账号 -->
			    	<div class="curStaffInfo boxBg text-center">
			    		<div class="media">
			    			<div class="media-left">
			    				<img src="${ctx }/statics/images/login-face.png" class="media-object" />
			    			</div>
			    			<div class="media-body text-left">
			    				<p class="media-heading">{{seller}}<span>银牌营业员</span></p>
			    				<p class="media-rank">本月排名：2</p>
			    				<p class="media-msg">注：本月数据不包含当天</p>
			    			</div>
			    		</div>
			    	</div>
			    	<!-- /当前员工账号 -->
			    	
			        <div class="dataBox">
			        	<div class="rigthTime palBox active clearfix">
			        		<div class="row boxBg">
			        			<!-- 比对今天和昨天 -->
				        		<div class="comparison-date col-xs-8">
				        			<div id="comparison-date-list" class="DataList" style="height:350px;"></div>
				        		</div>
				        		<!-- /比对今天和昨天 -->
				        		<div class="comparison-textInfo col-xs-4">
				        			<table class="table" style="margin-top:30px;">
				        				<thead>
				        					<tr>
				        						<td>顺序</td>
				        						<td>关键词</td>
				        						<td>本月占比</td>
				        						<td>上月占比</td>
				        					</tr>
				        				</thead>
				        				<tbody>
				        					<tr><td>1</td><td>销售额占比</td><td>{{nowSellAmountScale}}%</td><td>{{lastSellAmountScale.toFixed(2)}}%</td></tr>
				        					<tr><td>2</td><td>毛利占比</td><td>{{nowGrossProfitScale}}%</td><td>{{lastGrossProfitScale.toFixed(2)}}%</td></tr>
				        					<tr><td>3</td><td>客流占比</td><td>{{nowFlowScale}}%</td><td>{{lastFlowScale.toFixed(2)}}%</td></tr>
				        					<tr><td>4</td><td>客单价占比</td><td>{{nowFlowPriceScale}}%</td><td>{{lastFlowPriceScale.toFixed(2)}}%</td></tr>
				        				</tbody>
				        			</table>
				        		</div>
			        		</div>
			        		<div class="row boxBg">
			        			<!-- 个人业绩曲线图 -->
			        			<div class="storePerformance storeCol6 ">
			        				<div id="Performance-list" class="DataList" style="height:400px;"></div>
			        				<div class="selectOl">
			        					<form class="form-inline">
			        						<div class="form-group">
			        							<div class="radio">
											        <label>
											          <input type="radio" class="form-control" id="Performance-jin7Day" value='d' v-model="checkDateType" /> 近7天
											        </label>
											    </div>
			        						</div>
			        						<div class="form-group">
			        							<div class="radio">
											        <label>
											          <input type="radio" class="form-control" id="Performance-jin3Month" value='m' v-model="checkDateType" /> 近6月
											        </label>
											    </div>
			        						</div>
			        					</form>
			        				</div>
			        			</div>
			        			<!-- /个人业绩曲线图 -->
			        			<!-- 门店品类完成率曲线图 -->
			        			<!-- <div class="storeCategory storeCol6 col-xs-6">
			        				<div id="Category-list" class="DataList" style="height:300px;"></div>
			        				<div class="selectOl">
			        					<form class="form-inline">
			        						<div class="form-group">
			        							<div class="radio">
											        <label>
											          <input type="radio" class="form-control" id="Category-jin7Day" checked="checked" name="Category-selectDay" /> 近7天
											        </label>
											    </div>
			        						</div>
			        						<div class="form-group">
			        							<div class="radio">
											        <label>
											          <input type="radio" class="form-control" id="Category-jin3Month" name="Category-selectDay" /> 近3月
											        </label>
											    </div>
			        						</div>
			        					</form>
			        				</div>
			        			</div> -->
			        			<!-- /门店品类完成率曲线图 -->
			        		</div>
			        		<!-- <div class="row boxBg">
			        			本月门店销售类别分布
			        			<div class="storeClassifyFB col-xs-12">
			        				<div id="storeClassifyFB-list" class="DataList" style="height:350px;"></div>
			        			</div>
			        			/本月门店销售类别分布
			        		</div> -->
			        	</div>
			        </div>
		        </div>
		        <!-- /数据显示 -->
    		</div>
    		<!-- /右侧员工列表 -->
    	</div>
    </div>
</div>

<script type="text/javascript" src="./statics/config.js"></script>
<script type="text/javascript">
var ctx = "${ctx}"
var storeId = window.localStorage.getItem("__storeId__")
	new Vue({
		el:".dataReport",
		data:function(){
			return{
				storeName: window.localStorage.getItem('__storeName__'),
				//定义销售额的数据
				MarketListData :[],
				//定义毛利率的数据
				MaoriListData: [],
				//定义客流量的数据
				PersonTimeListData :[],
				checkDateType: 'm',
				selectUserId: '',
				selectStoreId: '',
				seller: '',
				lastSellAmountScale: 0,
				lastGrossProfitScale: 0,
				lastFlowScale: 0,
				lastFlowPriceScale: 0
			}
		},
		computed:{
			nowSellAmountScale: function() {
				return (100 - this.lastSellAmountScale).toFixed(2)
			},
			nowGrossProfitScale: function() {
				return (100 - this.lastGrossProfitScale).toFixed(2)
			},
			nowFlowScale: function() {
				return (100 - this.lastFlowScale).toFixed(2)
			},
			nowFlowPriceScale: function() {
				return (100 - this.lastFlowPriceScale).toFixed(2)
			}
		},
		methods:{
			//初始化表格
    		initTableData: function(){
    			var that = this
    			initBootstrapTable('#table', {
    	            //url: "${ctx}/base/supplier/listByPage.action",
    	            height: $(document.body).height() - 100,
    	            pagination:false,
    	            columns: [
    	            	{radio: true},
    	            	{field: 'userId', title: '用户id',align: 'center',valign: 'middle', sortable: true, visible:false},
    	            	{field: 'rank', title: '排行',align: 'center',valign: 'middle',
    	            		formatter: function(value, row, index) {
    	            			return index + 1
    	            		}	
    	            	},
    	            	{field: 'seller',title: '名称',align: 'center', valign: 'middle'},
    	                {field: 'userAccount',title: '工号',align: 'center', valign: 'middle'},
    	                {field: 'sell',title: '销售额',align: 'center', valign: 'middle',formatter: formatNumWan}
    	                /* {field: '', title: '&nbsp;&nbsp;&nbsp;操作&nbsp;&nbsp;&nbsp;', align: 'center', valign: 'middle', formatter:function(value,row,index){
    	                	var str = '<a class="a3" href="#" onclick="marketInfoVm.showDetail(\''+row.accountId+'\')"><i class="iconfont icon-yulan"></i>详细</a>';
    	                    return str;
    	                }}, */
    	             ],
    	             onCheck: function(row) {
    	            	 that.userId = row.userId
    	            	 that.storeId = row.storeId
    	            	 that.seller = row.seller
    	            	 that._getStaffDetail()
    	             }
    	        });
    		},
			//初始化今天和昨天图表
			initComparisonList :function(xData, yData){
				var that = this;
				// 基于准备好的dom，初始化echarts实例
		        var myChart = echarts.init(document.getElementById('comparison-date-list'));
		        // 指定图表的配置项和数据
		        var option = {
		        	color:["#f3d024","#3bbbe0"],
		            title: {
		                text: '实时总览',
		                subtext: '本月和上月数据对比'
		            },
		            tooltip:{},
		            legend:{},
		            xAxis: {
		            	type : 'category',
		                data: xData
		            },
		            yAxis: {
		            	type:"value"
		            },
		            series: [{
		                name: '上月',
		                type: 'bar',
		                label: {
		                    normal: {
		                        show: true,
		                        position: 'inside'
		                    }
		                },
		                data: yData.last
		            },{
		                name: '本月',
		                type: 'bar',
		                label: {
		                    normal: {
		                        show: true,
		                        position: 'inside'
		                    }
		                },
		                data: yData.now
		            }]
		        };
		        // 使用刚指定的配置项和数据显示图表。
		        myChart.setOption(option);
			},
			//初始化个人业绩曲线图
			initPerformance :function(dateList, sellList){
				var that = this;
				// 基于准备好的dom，初始化echarts实例
		        var myChart = echarts.init(document.getElementById('Performance-list'));
		      	//获取当前日期
				var date = new Date();
				//获取当前月
				var mouth = date.getMonth() + 1;
				//获取当前日 
				var day = date.getDate();
				var name = this.checkDateType === 'm' ? '近6个月' : '近七天';
				console.log(name)
		        // 指定图表的配置项和数据
		        var option = {
		        	color:["#f3d024","#3bbbe0"],
		            title: {
		                text: '个人业绩曲线图',
		            },
		            tooltip: {trigger: 'axis', axisPointer: { type: 'cross',label: {backgroundColor: '#283b56' } }},
		            legend: {
		                data:[name]
		            },
		            xAxis: {
		            	type : 'category',
		                data: dateList
		            },
		            yAxis: {
		            	type:"value"
		            },
		            series: [{
		                name: name,
		                type: 'line',
		                label: {
		                    normal: { show: true, position: 'inside' }
		                },
		                data: sellList
		            }]
		        };
		        // 使用刚指定的配置项和数据显示图表。
		        myChart.setOption(option);
			},
			//初始化品类完成率图表
			initCategory :function(){
				var that = this;
				// 基于准备好的dom，初始化echarts实例
		        var myChart = echarts.init(document.getElementById('Category-list'));
		      	//获取当前日期
				var date = new Date();
				//获取当前月
				var mouth = date.getMonth() + 1;
				//获取当前日 
				var day = date.getDate();
		        // 指定图表的配置项和数据
		        var option = {
		        	color:["#f3d024","#3bbbe0"],
		            title: {
		                text: '个人品类完成率'
		            },
		            tooltip: {},
		            legend: {
		                data:["近7天"]
		            },
		            xAxis: {
		            	type : 'category',
		                data: [mouth+"月"+(day-6), mouth+"月"+(day-5), mouth+"月"+(day-4), mouth+"月"+(day-3), mouth+"月"+(day-2), mouth+"月"+(day-1), mouth+"月"+day]
		            },
		            yAxis: {
		            	type:"value"
		            },
		            series: [{
		                name: '近7天',
		                type: 'line',
		                label: {
		                    normal: {
		                        show: true,
		                        position: 'inside'
		                    }
		                },
		                data: [5, 20, 36, 10, 10, 20,80]
		            }]
		        };
		        // 使用刚指定的配置项和数据显示图表。
		        myChart.setOption(option);
			},
			//初始化本月门店销售类别分布图表
			initStoreClassifyFB :function(){
				var that = this;
				// 基于准备好的dom，初始化echarts实例
		        var myChart = echarts.init(document.getElementById('storeClassifyFB-list'));
		      	//获取当前日期
				var date = new Date();
				//获取当前月
				var mouth = date.getMonth() + 1;
				//获取当前日 
				var day = date.getDate();
		        // 指定图表的配置项和数据
		        var option = {
		        	color:["#f3d024","#3bbbe0"],
		            title: {
		                text: '本月个人销售类别分布'
		            },
		            tooltip: {},
		            legend: {
		                data:["本月"]
		            },
		            xAxis: {
		            	type : 'category',
		                data: ["期初类别","中西成药","医疗器械","保健品","健康食品","生活用品"]
		            },
		            yAxis: {
		            	type: 'value',
		                min: 0,
		                max: 100,
		            },
		            series: [{
		                name: '本月',
		                type: 'bar',
		                label: {
		                    normal: {
		                        show: true,
		                        position: 'inside'
		                    }
		                },
		                data: [5, 20, 36, 10, 10,80]
		            }]
		        };
		        // 使用刚指定的配置项和数据显示图表。
		        myChart.setOption(option);
			},
			_getStaffRank: function(storeId) {
				getStaffRank(storeId, function(res){
					if(res.length) {
						var data = {
							rows: res,
							total: res.length
						}
						$("#table").bootstrapTable("load", data)
						$("#table").bootstrapTable("check", 0)
					}
				})
			},
			_getStaffDetail: function() {
				var that = this	
				this._getStaffDetailCvs()
				this._getEmployeePerformance()
			},
			_getStaffDetailCvs: function() {
				var that = this
				getStaffCvs({
					storeId: this.storeId,
					userId: this.userId,
					dateType: this.checkDateType
				}, function(res) {			
					if(res.length) {
						var dateList = []
						var sellList = []
						$.each(res, function(index, item) {
							dateList.push(item.createDate)
							sellList.push(item.sellAmount)
						})
						that.initPerformance(dateList, sellList)
					}		
				})
			},
			_getEmployeePerformance: function() {
				var that = this
				getEmployeePerformance({
					storeId: this.storeId,
					userId: this.userId,
					seller: this.seller,
					dateType: 'm'
				}, function(res) {
					if(res.length) {
						var lastData = []
						var nowData = []
						lastData.push(res[0].sellAmount)
						lastData.push(res[0].grossProfit)
						lastData.push(res[0].flow)
						lastData.push(parseInt(res[0].sellAmount / res[0].flow))
						nowData.push(res[1].sellAmount)
						nowData.push(res[1].grossProfit)
						nowData.push(res[1].flow)
						nowData.push(parseInt(res[1].sellAmount / res[1].flow))
						
						//计算占比			
						that.lastSellAmountScale = (lastData[0] / (lastData[0] + nowData[0])) * 100
						that.lastGrossProfitScale = (lastData[1] / (lastData[1] + nowData[1])) * 100
						that.lastFlowScale = (lastData[2] / (lastData[2] + nowData[2])) * 100
						that.lastFlowPriceScale = (lastData[3] / (lastData[3] + nowData[3])) * 100
						var xData = ['销售额',"毛利","客流","客单价"]
						var yData ={
							last: lastData,
							now: nowData
						}
						that.initComparisonList(xData, yData)
					}					
				})
			}
		},
		watch: {
			checkDateType: function(newValue, oldValue) {
				this._getStaffDetailCvs()
			}
		},
		mounted:function(){
			//初始化今天和昨天图表
			//this.initComparisonList();
			//初始化门店业绩图表
			//this.initPerformance();
			
			//初始化品类完成率图表
			//this.initCategory();
			//初始化本月门店销售类别分布图表
			//this.initStoreClassifyFB();
			//初始化员工表格数据
			this.initTableData()
			//获取员工表格数据
			this._getStaffRank(storeId)
		}
	})
</script>
<%@include file="/common/footer.jsp" %>
