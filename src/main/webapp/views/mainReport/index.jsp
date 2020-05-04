<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<title>好友面云平台</title>
	<link rel="icon" href="${ctx}/statics/images/title-icon.ico" />
	<link rel="stylesheet" type="text/css" href="${ctx}/statics/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="${ctx}/views/mainReport/static/css/swiper-3.4.2.min.css" />
	<link rel="stylesheet" type="text/css" href="${ctx}/views/mainReport/static/css/element-ui.min.css" />	
	<link rel="stylesheet" type="text/css" href="${ctx}/statics/css/reset.css" />
	<link rel="stylesheet" type="text/css" href="${ctx}/views/mainReport/static/css/index.css" />
	<script type="text/javascript" src="${ctx}/statics/js/echarts.js"></script>
	<script type="text/javascript" src="${ctx}/statics/js/jquery/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="${ctx}/statics/js/jquery/jquery.liMarquee.js"></script>
	<script type="text/javascript" src="${ctx}/statics/js/js-cookie.js"></script>
	<script type="text/javascript" src="${ctx}/views/mainReport/static/js/countUp.js"></script>
	<script type="text/javascript" src="${ctx}/statics/plugins/vue/vue.min.js"></script>
	<script type="text/javascript" src="${ctx}/views/mainReport/static/js/element-ui.min.js"></script>
	<script type="text/javascript" src="${ctx}/views/mainReport/static/js/swiper-3.4.2.jquery.min.js"></script>
	
</head>
<body>
	<div id="main">
		<div class="container">
			<div class="left">
				<div class="city-search">
					<div class="city-search-content">
						<span>企业名称:</span>
					    <el-dropdown trigger="click" @command="handleDropSelect">
					      <span class="el-dropdown-link">
					        {{dropDowmMsg}}
							<i class="el-icon-arrow-down el-icon--right"></i>
					      </span>
					      <el-dropdown-menu slot="dropdown">
					      	<el-dropdown-item :command="item.companyId" v-for="item in companyList">{{item.companyName}}</el-dropdown-item>
					      </el-dropdown-menu>
					    </el-dropdown>	    
					</div>
				</div>
				<div class="item">
					<div class="left-title">
						<img src="${ctx}/statics/images/mainReport/hot-sell.png" width="174" height="42" />
					</div>
					<div class="detail left-top">
						<div class="swiper-container">
							<div class="swiper-wrapper">
								<div class="swiper-slide"
									v-for="items in categoryPages">
									<ul class="detail-nav">
										<li class="detail-item"
											:class="currentIndexType === item.codeId ? 'active' : ''"
											v-for="(item, index) in items"
											@click="selectTypeItem(item.codeId)"
											:title="item.codeName">
											{{item.codeName}}
										</li>
									</ul>
								</div>
							</div>
						</div>
						<div class="rank" ref="categoryRank">
							<div class="rank-body">
								<div class="rank-title">
									商品销售额排行
								</div>
								<div class="rank-items">
									<div class="rank-item rank-category" v-for="(item, index) of categoryProductRanks">
										<div>{{index + 1}}</div>
										<div class="text-hidden" :title="item.productName">{{item.productName}}</div>
									</div>
								</div>
							</div>
							<div class="rank-body">
								<div class="rank-title">
									商家销售额排行
								</div>
								<div class="rank-items">
									<div class="rank-item rank-category" v-for="(item, index) of categoryStoreRanks">
										<div>{{index + 1}}</div>
										<div class="text-hidden" :title="item.storeName">{{item.storeName}}</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="item">
					<div class="left-title">
						<img src="${ctx}/statics/images/mainReport/product-sell.png" width="264" height="43" />
					</div>
					<div class="detail left-bottom">
						<div class="detail-title">
							<div class="title-item">
								<div>药店总数</div>
								<div class="drug-store-count"><span ref="storeCount">{{storeCount}}</span> / <span ref="storeAllCount">{{storeAllCount}}(家)</span></div>
							</div>
							<div class="title-item">
								<div>会员总数</div>
								<div class="drug-product-count" ref="memberCount">{{memberCount}}</div>
							</div>
						</div>
						<div class="detail-body">
							<div class="rank-items">
								<div class="rank-item" v-for="(item, index) of storeSellRanks">
									<div>{{index + 1}}</div>
									<div class="text-hidden">{{item.storeName}}</div>
								</div>
							</div>
							<div class="drug-canvas">
								<div id='drugProductCanvas' class="drug-product-canvas"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="center">
				<div class="center-content">
					<ul class="nav">
						<li class="nav-item" 
							:class="item.dateType === currentIndex ? 'active': '' " 
							v-for="(item, index) in selectItems"
							@click="selectItem(item.dateType)">
							{{item.name}}
						</li>
					</ul>
					<!-- <ul class="money">
						<li class="money-icon">￥</li>
						<li :class="item == ',' ? 'money-icon' : 'money-item'"
							v-for="item in normolizeMoney">
							{{item}}
						</li>
					</ul> -->
					<div class="count-money" ref="money"></div>
					
					<div class="order">
						<div class="order-item">订单数：<span ref="orderNum">{{orderNum}}</span></div>
						<div class="order-item">无线成交占比：{{orderScale}}%</div>
						<div class="order-item">客流量： <span ref="flow">{{flow}}</span></div>
						<div class="order-item">成交商品数：<span ref="orderDeal">{{orderDeal}}</span></div>
					</div>
					<div class="canvas-report">
						<div class="canvas-bg"></div>
						<div id="sellCanvas" class="sell-canvas"></div>
					</div>
				</div>
			</div>
			<div class="right">
				<div class="now-time">
					<time>{{nowTime}}</time>
					<span @click="toggleFullScreen" 
						class="glyphicon"
						:class="!isFullScreen ? 'glyphicon-resize-full' : 'glyphicon-resize-small' ">全屏</span>
				</div>
				<div class="item">
					<div class="right-title">
						<img src="${ctx}/statics/images/mainReport/area.png" width="279" height="42" />
					</div>
					<div class="detail right-top">
						<div class="city-detail">
							<div class="city-title-body">
								<div class="city-title">广东</div>
								<div class="data-body">
									<div>2018</div>
									<div class="now-body"></div>
								</div>
								<div class="data-body">
									<div>2017</div>
									<div class="yes-body"></div>
								</div>
							</div>
							<div class="city-canvas">
								<img src="${ctx}/statics/images/mainReport/city-hot.png" width="307" height="208">
							</div>
						</div>
						<div class="city-rank">
							<div class="city-rank-body">
								<div class="city-rank-title">
									消费省排行
								</div>
								<ul class="city-rank-items">
									<li class="city-rank-item" v-for="(item, index) of provinceRanks">
										<div>{{index + 1}}</div>
										<div class="item-detail">
											<div>{{item.adds}}</div>
											<div class="progress">
											    <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" 
											    	:style="{width: (100 - index * 18) + '%'}">
											        <span class="sr-only">60% Complete</span>
											    </div>
											</div>
										</div>
									</li>
								</ul>
							</div>
							<div class="city-rank-body">
								<div class="city-rank-title">
									消费地区排行
								</div>
								<ul class="city-rank-items">
									<li class="city-rank-item" v-for="(item, index) of cityRanks">
										<div>{{index + 1}}</div>
										<div class="item-detail">
											<div class="city-adds-sell">
												<div>{{item.adds}}</div>
												<div>{{item.sell}}</div>
											</div>
											<div class="progress">
											    <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" 
											    	:style="{width: (100 - index * 18) + '%'}">
											        <span class="sr-only">60% Complete</span>
											    </div>
											</div>
										</div>
									</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<div class="item">
					<div class="right-title">
						<img src="${ctx}/statics/images/mainReport/payment.png" width="263" height="42" />
					</div>
					<div class="detail right-bottom">
						<div class="detail-title detail-right">
							<div class="title-item">
								<div>处方药销售总额</div>
								<div class="drug-product-count" ref="rxDrugSellAmount"></div>
							</div>
							<div class="title-item">
								<div>OTC销售总额</div>
								<div class="drug-product-count" ref="isRxDrugSellAmount">{{isRxDrugSellAmount}}</div>
							</div>
						</div>
						<div class="detail-body">
							<div class="rank-items">
								<div class="rank-item" v-for="(item, index) of payMentRanks">
									<div>{{index + 1}}</div>
									<div class="text-hidden">{{item}}</div>
								</div>
							</div>
							<div class="drug-canvas">
								<div id='payMentCanvas' class="drug-product-canvas"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="footer-container">
			<div class="footer-img"></div>
			<div class="footer" v-html="scrollData">
			</div>
		</div>
		<el-dialog width="30%" :show-close="isShowClose" title="登录" :visible.sync="dialogFormVisible">
		  <el-form :model="form">
		    <el-form-item label="用户名：" :label-width="formLabelWidth">
		      <el-input v-model="form.username"></el-input>
		    </el-form-item>
		    <el-form-item label="密码：" :label-width="formLabelWidth">
		      <el-input v-model="form.password" type="password" @keyup.enter.native="login"></el-input>
		    </el-form-item>
		  </el-form>
		  <div slot="footer" class="dialog-footer">
		    <el-button type="primary" @click="login">确 定</el-button>
		  </div>
		</el-dialog>
	</div>
	
<script type="text/javascript" src="${ctx}/views/mainReport/static/js/api.js"></script>
<script type="text/javascript" src="${ctx}/views/mainReport/static/js/util.js"></script>
<script type="text/javascript">
var ctx = "${ctx}"
var Loadding = undefined
var vm = new Vue({
	el: '#main',
	data: {
		isShowClose: false,
		dialogFormVisible: true,
		form: {
          username: '',
          password: ''
        },
        formLabelWidth: '120px',
		nowTime: "", //当前时间
		isFullScreen: false, //是否全屏
		currentIndex: 4, // 当前dateType 类型
		currentIndexType: 0, //当前药品分类Id
		scrollData: '', //底部滚动html
		money: 0, // 中间大屏幕 的值
		orderNum: 0, // 订单数
		flow: 0, //客流量
		orderScale: 0, // 成交占比
		orderDeal: 0, // 成交商品
		storeCount: 0, // 上线门店总数
		storeAllCount: 0, //F4所有门店总数
		memberCount: 0, //会员总数
		storeSellRanks: [], // 门店销售排行
		payMentRanks: [], // 支付方式排行
		rxDrugSellAmount: 0,// 处方销售总额
		provinceRanks: [{
			adds: '广东'
		}], // 省排行
		cityRanks: [], // 市排行
		categoryItems: [], // 药品分类
		categoryStoreRanks: [], // 药品分类商家销售额排行
		categoryProductRanks: [], // 药品分类 商品销售额排行
		companyId: '', // 企业Id
		companyList: [{
			companyId: '',
			companyName: '所有'
		},{
			companyId: '117e9b2e-4767-11e8-900e-5254000bcdd0',
			companyName: '广缘医药'
		},{
			companyId: 'b2ca4bf2-4766-11e8-900e-5254000bcdd0',
			companyName: '嘉伦连锁'
		}],
		dropDowmMsg: '所有',
		selectItems: [{
			name: '今天',
			dateType: 1
		},{
			name: '昨天',
			dateType: 2
		},{
			name: '本周',
			dateType: 3
		},{
			name: '本月',
			dateType: 4
		},{
			name: '本年',
			dateType: 5
		}]
	},
	computed: {
		normolizeMoney: function() {
			var moneyList = this.money.toString().split('')
			var result= [], counter = 0;
			if(moneyList.length < 10) {
				for(var j = moneyList.length; j < 10;j++) {
					moneyList.unshift(0)
				}
			}
			for(var i = moneyList.length - 1; i >= 0; i--) {
				counter++;
				result.unshift(moneyList[i])
				if(!(counter % 3 && i != 0)) {
					result.unshift(',')
				}
			}
			if(result.length < 9) {
				for(var j = result.length; j < 9; j++) {
					result.unshift(0)
				}
			}
			if(result[0] === ',') {
				result.shift()
			}
			return result
		},
		// 药品分类导航 分页显示
		categoryPages: function() {
			var categoryList = this.categoryItems
			var pages = []
			$.each(categoryList, function(index, item) {
				var page = Math.floor(index / 5)
				if (!pages[page]) {
					pages[page] = []
				}
				pages[page].push(item)
			})
			return pages
		},
		isRxDrugSellAmount: function() {
			var rxDrug = this.money - this.rxDrugSellAmount
			if(this.countUpIsRxDrugSellAmount) {
				this.countUpIsRxDrugSellAmount.update(rxDrug)
			}
			return rxDrug
		}
	},
	methods: {
		login: function() {
			//登录成功
			if( this.form.username === 'admin' && this.form.password ==='123456') {
				this.dialogFormVisible = false
				//设置cookie
				Cookies.set("isLogin", true)
				this.toggleFullScreen()
				//初始化数据
				this._initDateType()
				//每20秒 获取一次最新数据
				var that = this
				var timer = setInterval(function() {
					that._getMoreData({dateType: that.currentIndex, companyId: that.companyId})
					that._getSellGoupByHour({companyId: that.companyId})
				}, 20000)
			}		
		},
		selectItem: function(dateType) {
			this.currentIndex = dateType
			//重新获取数据
			this._initDateType()
		},
		selectTypeItem: function(codeId) {
			this.currentIndexType = codeId
			this._getCategoryRankAndType({dateType: this.currentIndex}, codeId)
		},
		handleDropSelect: function(command) {
			var that = this
			$.each(this.companyList, function(index, item) {
				if(item.companyId === command) {
					that.dropDowmMsg = item.companyName
				}
			})
			this.companyId = command
			this._initDateType()
		},
		toggleFullScreen: function() {
	         if (!document.fullscreenElement && // alternative standard method
	            !document.mozFullScreenElement && !document.webkitFullscreenElement) { // current working methods
	            if (document.documentElement.requestFullscreen) {
	                document.documentElement.requestFullscreen();
	            } else if (document.documentElement.mozRequestFullScreen) {
	                document.documentElement.mozRequestFullScreen();
	            } else if (document.documentElement.webkitRequestFullscreen) {
	                document.documentElement.webkitRequestFullscreen(Element.ALLOW_KEYBOARD_INPUT);
	            }
	        } else {
	            if (document.cancelFullScreen) {
	                document.cancelFullScreen();
	            } else if (document.mozCancelFullScreen) {
	                document.mozCancelFullScreen();
	            } else if (document.webkitCancelFullScreen) {
	                document.webkitCancelFullScreen();
	            }
	        }
	        this.isFullScreen = !this.isFullScreen 
		},
		initSellReport: function(dateList,sellList) {
			var option = {
				title: {
	                text: '成交额',
	                textStyle: {
	                	color: '#48c1e7'
	                }
	            },
	            tooltip: {
	                trigger: 'axis',
	                axisPointer: {
	                    type: 'cross',
	                    label: {
	                    	precision: 0,
	                    	fontWeight: 'bold',
	                    	fontSize: 20
	                    }
	                },
	                textStyle: {
	                	fontWeight: 'bold'
	                },
	                backgroundColor: '#e95f85'
	            },
			    xAxis: {
			        type: 'category',
			        data: dateList,
			        axisLine:{
                        lineStyle:{
                            color:'#48c1e7',
                            width:4
                        }
                    },
                    axisLabel: {
				    	fontSize: 20,
				    	fontWeight: 'bold'
				    }
			    },
			    yAxis: {
			        type: 'value',
			        axisLine:{
                        lineStyle:{
                            color:'#48c1e7',
                            width:4
                        }
                    },
				    axisLabel: {
				    	fontSize: 20,
				    	fontWeight: 'bold'
				    }
			    },
			    series: [{
			        data: sellList,
			        type: 'line',
			        smooth: true,
			        label: {
	                    normal: { show: true, position: 'inside' }
	                },
				    lineStyle:{
				    	width: 4,
		                color:'#e40f24'
		         	}
			    }]
			}
			var myChart = echarts.init(document.getElementById('sellCanvas'))
			myChart.setOption(option);
		},
		initStoreSell: function(storeList, sellAmountList) {
			var option = {
	        	color:["#00b3fe"],
	        	title: {
	                text: '金额',
	                textStyle: {
	                	color: '#48c1e7'
	                }
	            },
	            xAxis: {
	                data: storeList,
	                axisLine:{
                        lineStyle:{
                            color:'#48c1e7',
                            width:4
                        }
                    },
                    axisLabel: {  
                   	   interval:0,  
	                   	formatter:function(value)  
	                    {    
	                        var ret = "";//拼接加\n返回的类目项  
	                        var maxLength = 4;//每项显示文字个数  
	                        var valLength = value.length;//X轴类目项的文字个数  
	                        var rowN = Math.ceil(valLength / maxLength); //类目项需要换行的行数  
	                        if (rowN > 1)//如果类目项的文字大于3,  
	                        {
	                            for (var i = 0; i < rowN; i++) {  
	                                var temp = "";//每次截取的字符串  
	                                var start = i * maxLength;//开始截取的位置  
	                                var end = start + maxLength;//结束截取的位置  
	                                //这里也可以加一个是否是最后一行的判断，但是不加也没有影响，那就不加吧  
	                                temp = value.substring(start, end) + "\n";  
	                                ret += temp; //凭借最终的字符串  
	                            }  
	                            return ret;  
	                        }  
	                        else {  
	                            return value;  
	                        }  
	                    }   
                   	}
	            },
	            grid: {
	                x: 0,
	                y: 34
                },
	            yAxis: {
	            	axisLine:{
                        lineStyle:{
                            color:'#48c1e7',
                            width:4
                        }
                    }
	            },
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
	                data: sellAmountList
	            }]
	        }
			var myChart = echarts.init(document.getElementById('drugProductCanvas'))
			myChart.setOption(option);
		},
		initpayMent: function(payTypeList, sellAmountList) {
			var option = {
	        	color:["#00b3fe"],
	        	title: {
	                text: '数量',
	                textStyle: {
	                	color: '#48c1e7'
	                }
	            },
	            xAxis: {
	                data: payTypeList,
	                axisLine:{
                        lineStyle:{
                            color:'#48c1e7',
                            width:4
                        }
                    }
	            },
	            grid: {
	                x: 0,
	                y: 34
                },
	            yAxis: {
	            	axisLine:{
                        lineStyle:{
                            color:'#48c1e7',
                            width:4
                        }
                    }
	            },
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
	                data: sellAmountList
	            }]
	        }
			var myChart = echarts.init(document.getElementById('payMentCanvas'))
			myChart.setOption(option);
		},
		_normalizeStoreRank: function(data, that) {
			var list = data.list
			if(list.length > 4) {
				list.length = 4
			}
			var storeList = []
			var sellAmountList = []
			$.each(list, function(index, item) {
				storeList.push(item.storeName)
				sellAmountList.push(parseInt(item.sellAmount).toFixed())
			})
			that.storeSellRanks = list
			that.storeCount = data.storeCount
			that.initStoreSell(storeList,sellAmountList)
			that.countUpStoreCount.update(that.storeCount)
		},
		_normalizePayMentRanks: function(list, that) {
			var payTypeList = []
			var sellAmountList = []
			$.each(list, function (index, item) {
				payTypeList.push(item.payType)
				sellAmountList.push(item['SUM(sellAmount)'].toFixed())
			})
			//赋值，初始化报表
			that.payMentRanks = payTypeList
			that.initpayMent(payTypeList, sellAmountList)
		},
		_normalizeStoreOrder: function(data, that) {
			var lastMoney = that.money
			that.money = data.sellAmount ? data.sellAmount.toFixed() : 0
			that.orderDeal = data.saleCount ? data.saleCount.toFixed() : 0
			that.orderNum = data.saleOrderNo ? data.saleOrderNo : 0
			that.orderScale = data.online ? data.online : 0
			that.flow = data.flow ? data.flow : 0
			
			that.countUpOrderDeal.update(that.orderDeal)
			that.countUpOrderNum.update(that.orderNum)
			that.countUpFlow.update(that.flow)
			var prefix = prefixZero(that.money)
			prefix = "￥" + prefix
			that.countUpMoney = new initCountUp(that.$refs.money, {prefix: prefix, separator: ','}, lastMoney)
			that.countUpMoney.update(that.money)
		},
		_normalizeCityRank: function(data, that) {
			data.shift()
			var cityRanks = []			
			$.each(data, function(index, item) {
				if(item.adds){
					item.sell = item.sell.toFixed(0)
					cityRanks.push(item)
				}
			})
			that.cityRanks = cityRanks
		},
		_getCategoryRankAndType: function(op, codeId) {
			var that = this
			op.codeId = codeId
			op.companyId = this.companyId

			getCategoryRankAndType(op, function(res) {
				if(res.data && res.list) {
					that.categoryStoreRanks = res.data
					that.categoryProductRanks = res.list
				}
			})
		},
		_getStoreAll: function(op) {
			var that = this
			getStoreAll(op, function(res) {
				that.storeAllCount = res.storeAllCount
				that.countUpStoreAllCount.update(that.storeAllCount)
			})
		},
		_getMoreData: function(op) {
			var that = this
			getMoreData(op, function(res) {
				Loadding.close()
				that.categoryItems = res.categoryRank //左上角 药品分类
				if(res.categoryRank.length) {
					that.selectTypeItem(res.categoryRank[0].codeId)
				} else {
					that.categoryStoreRanks = []
					that.categoryProductRanks = []
				}
				that.memberCount = res.memberCount['COUNT(1)'] //会员数量
				if(res.rxDrugRank) {
					that.rxDrugSellAmount = res.rxDrugRank.RxSell//处方药销售额
				} else {
					that.rxDrugSellAmount = 0
				}
			    
				that._normalizeCityRank(res.regionRank.data, that) //区域排行
				that._normalizePayMentRanks(res.payRank, that)  //支付方式排行
				if(res.allSellMount) {
					that._normalizeStoreOrder(res.allSellMount[0], that) //中间 订单数据 
				} else {
					that._normalizeStoreOrder({}, that)
				}
				
				that._normalizeStoreRank(res.storeRank, that) //门店排行
				
				that.countUpMemberCount.update(that.memberCount)
				that.countUpRxDrugSellAmount.update(that.rxDrugSellAmount)
			})
		},
		_getScrollData: function(op) {
			var that = this
			getScrollData(op, function(res) {
				var html = ''
				if(res.length) {
					$.each(res,function(index,item) {
						var time = initDateForTime(item.createDate)
						if(index < 10){
						html += '<span>' + item.storeName + time + '销售' +
							item.productName + item.saleCount + item.unit +'</span>'
						}
					})
								
				} else {
					html = '暂无最新销售数据'
				}
				that.scrollData = html	
			})
		},
		_getSellGoupByHour: function(op) {
			var that = this
			getSellGoupByHour(op, function(res) {
				if(res.length){
					var dateList = []
					var sellList = []
					$.each(res, function(index, item) {
						dateList.push(item.hours)
						sellList.push((item.sellAmount).toFixed())
					})
					that.initSellReport(dateList, sellList)
				}
			})
		},
		//切换需要重新获取一次数据
		_initDateType: function() {
			Loadding = this.$loading({
	          lock: true,
	          text: '加载中...',
	          background: 'rgba(0, 0, 0, 0.5)'
	        });
			var dateType = this.currentIndex
			var companyId = this.companyId
			this._getStoreAll({companyId: companyId})
			this._getMoreData({dateType: dateType, companyId: companyId})
			this._getSellGoupByHour({companyId: companyId})
			this._getScrollData({companyId: companyId})
		},
		//初始化 数字滚动插件
		_initCountUp: function() {
			this.countUpFlow = new initCountUp(this.$refs.flow)
			this.countUpOrderDeal = new initCountUp(this.$refs.orderDeal)
			this.countUpOrderNum = new initCountUp(this.$refs.orderNum)
			this.countUpRxDrugSellAmount = new initCountUp(this.$refs.rxDrugSellAmount, {suffix: '(元)'})
			this.countUpIsRxDrugSellAmount = new initCountUp(this.$refs.isRxDrugSellAmount, {suffix: '(元)'})
			this.countUpStoreCount = new initCountUp(this.$refs.storeCount)
			this.countUpStoreAllCount = new initCountUp(this.$refs.storeAllCount)
			this.countUpMemberCount = new initCountUp(this.$refs.memberCount)
		},
		_initScrollTimer: function() {
			var that = this
			//获取实时滚动 距离 ，当触底时 重新获取滚动数据
			var scrollTimer = setInterval(function(){
				var width = $('.str_move').css('width') || 0
				var left = $('.str_move').css('left') || 0
				if(width === 0 || left === 0) {
					return
				}
				width = parseInt(width.substring(0, width.length - 2))
				left = Math.abs(parseInt(left.substring(0, left.length - 2))) + 100
				if(width < left) {
					that._getScrollData({companyId: that.companyId})
				}
			}, 1000)
		}
	},
	watch: {
		scrollData: function() {
			this.$nextTick(function() {
				 $('.footer').liMarquee({
			        circular: false,
			        runshort: false
			    });
			})
		}
	},
	mounted: function() {
		if(Cookies.get("isLogin") == 'true') {
			this.form.username = 'admin'
			this.form.password = '123456'
			this.login()
		}
		//初始化数字滚动插件
		this._initCountUp()	
		this.$nextTick(function() {
			this.mySwiper = new Swiper('.swiper-container', {
				observer: true
			})
			
		})
		var that = this
		//右上角时间
		setInterval(function() {
			that.nowTime = getNowTime()
		}, 1000)
		this._initScrollTimer()
	}
})
</script>
</body>
</html>