<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/header.jsp" %>
<style>
	.eName{display:none;}
    .sValue label{margin: 0;padding:0;font-weight:normal;line-height: 30px;}
    .sValue label input{margin: 0 4px 0 0;}
    .form-control {width:100% !important;height:30px !important}
    .showDate{display:inline-block;height:30px;line-height:30px;}
</style>

<!-- 门店排行 -->
<div class="main">
    <div class="contrain">
    	<div id="toolbar" role="group">
            <div class="btn-group selectDate" v-cloak>
            	<button v-for="(item, index) in btnData" :dateType="item.dateType" :id="item.id" type="button" @click="changeDate($event, item.dateType, index)" class="btn btn-default" :class="index == 2 ? 'active' : null">{{item.name}}</button>
            </div>
           <!--<div class="showDate">
            	按天
            	<span class="eName" style="display:block;"><label class="text-info">按天查看：</label><span class="sValue pdate"><input class="form-control" id="day" type="text"  placeholder="格式：2000-01-01"  name="firstPayDate" data-op="GT" ><i class="iconfont">&#xe613;</i></span></span>
            	按周
            	<span class="eName" style="display:inline-block!important;">
					<span style="color:#0071cc;font-weight:700;width:180px;display:inline-block;text-align:right;">按周查看：</span>
            		<div class="btn-group btnSelectWeek" v-cloak>
		            	<button  type="button" v-for="(item, index) in btnSelectWeek" @click="onChangeSelectWeek($event,index)" class="btn btn-default" :class="{'active':!index}">{{item.name}}</button>
		            </div>
            	</span>
            	按月
            	<span class="eName"><label class="text-info">按月查看：</label><span class="sValue pdate"><input class="form-control" id="mouth" type="text" placeholder="格式：2000-01" @change="initDateIptChange($event)" name="firstPayDate" data-op="GT" ><i class="iconfont">&#xe613;</i></span></span>
            	按年
            	<span class="eName"><label class="text-info">按年查看：</label><span class="sValue pdate"><input class="form-control" id="year" type="text" placeholder="格式：2000"  name="firstPayDate" data-op="GT" ><i class="iconfont">&#xe613;</i></span></span>
            </div> -->
        </div>
        <div class="surround">
            <div class="fullcontent noOutwrap">
               <!--  <form action="" class="form-inline form-search">
	                 <div class="form-group clearfix form-100w">
	                       <span class="eName col-md-3 col-sm-6 col-xs-12 col-lg-3" style="display:block;">
	                           <label class="text-info">门店名称：</label>
	                           <span class="sValue">
	                           	<select id="storeName" class="selectpicker" name="storeId" data-op="EQ"  data-live-search="true" data-live-search-placeholder="搜索" v-model="selectStore" v-cloak>
	                           		<option value="-1">请选择</option>
                                	<option v-for="(store, index) in storeData" :value="store.storeId">{{store.storeName}}</option> 
                                </select>
	                           </span>
	                      </span>
	                  </div>
	            </form> -->
                <div>
                    <table id="table" class="table-align table-striped table-hover table-condensed"data-mobile-responsive="true"></table>
                </div>
            </div>
        </div>
    </div>
</div>


<script type="text/javascript" src="./statics/config.js"></script>
<script type="text/javascript">
var ctx = "${ctx}";
    var marketInfoVm = new Vue({
    	el:".main",
    	data: function(){
    		return{
    			btnData:[
    				{"id":"btnDay", "dateType":"1", "name":"当天"},
    				{"id":"btnWeek", "dateType":"2","name":"近七天"},
    				{"id":"btnMouth", "dateType":"3","name":"本月"},
    				{"id":"btnYear", "dateType":"4","name":"今年"}
    			],
    			storeData:[],
    			selectStore:"-1",
    			btnSelectWeek:[{"name":"今周"},{"name":"上周"},{"name":"上上周"}],
    			initTabelData:[{"lessProfit":4128.880,"sellAmount":53453.342,"storeName":"珠海港昌分店","storeId":"f874e1ef049211e8","grossProfit":29716.304,"storeCode":"10218"},{"lessProfit":747.737,"sellAmount":36734.408,"storeName":"珠海上栅分店","storeId":"f875246e049211e8","grossProfit":17650.986,"storeCode":"10289"},{"lessProfit":2296.930,"sellAmount":10712.070,"storeName":"测试账号(发单不下推)","storeId":"f88332f9049211e8","grossProfit":2536.090,"storeCode":"90000"},{"lessProfit":597.650,"sellAmount":2641.150,"storeName":"珠海市绿惠康医药有限公司","storeId":"062fbece-a239-11e8-8305-5254000bcdd0","grossProfit":1269.100,"storeCode":"32200"}]
    		}
    	},
    	methods:{
    		//初始化表格
    		initTableData: function(data){
    			var that = this;
    			initBootstrapTable('#table', {
    	            toolbar: '#toolbar',
    	            height: $(document.body).height() - 20,
    	           	showToggle: false, //切换按钮
	                showExport: false,
	                showColumns: false, //下拉框（选择显示的列）
	                singleSelect: true,
	                pagination :false,
    	            uniqueId:"storeId",
    	            columns: [
    	            	{field: 'storeId', title: '门店id',align: 'center',valign: 'middle', sortable: true, visible:false},
    	            	{field: 'ranking',title: '排名',align: 'center', valign: 'middle',
    	            		formatter: function(value,row,index){
    	            			return index + 1		
    	            		}
    	            	},
    					{field: 'storeCode', title: '门店编号', align: 'center', valign: 'middle'},
    	                {field: 'storeName',title: '门店名称',align: 'center', valign: 'middle'},
    	                {field: 'sellAmount',title: '销售额',align: 'center',valign: 'middle',formatter: formatNumWan},
    	                {field: 'grossProfit',title: '毛利',align: 'center',valign: 'middle',formatter: formatNumWan},
    	                {field: 'lessProfit',title: '让利',align: 'center',valign: 'middle',formatter: formatNumWan},
    	                /* {field: '', title: '&nbsp;&nbsp;&nbsp;操作&nbsp;&nbsp;&nbsp;', align: 'center', valign: 'middle', sortable:true, formatter:function(value,row,index){
    	                	var str = '<a class="a3" href="#" onclick="marketInfoVm.showDetail(\''+row.accountId+'\')"><i class="iconfont icon-yulan"></i>预览</a>';
    	                    return str;
    	                }}, */
    	             ],
    	             data: data
    	        });
    		},
    		//初始化按钮组选中
    		changeDate: function(e, dateType, index){
    			//debugger
    			//var storeId = this.selectStore == '-1' ? "" : this.selectStore;
    			var time = this.initGetDate(dateType);
    			$(e.currentTarget).addClass("active").siblings().removeClass("active");
    			$(".showDate .eName").eq(index).show().siblings().hide();
    			this._getStoreRank(dateType)
    		},
    		initGetDate: function(dateType){
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
					return year+"-"+mouth+"-"+day;
				}else if(dateType == 'w'){
					return thisWeek;
				}else if(dateType == 'm'){
					return year+"-"+mouth;
				}else if(dateType == 'y'){
					return year;
				}
    		},
    		//初始化周
    		onChangeSelectWeek: function(e, index){
    			var storeId = this.selectStore == '-1' ? "" : this.selectStore;
    			var thisTime = this.initGetDate('w');
    			var week = index == '0' ? thisTime : (index == '1' ? thisTime-1 : (index == '2' ? thisTime-2 : '0'));
    			$(e.currentTarget).addClass("active").siblings().removeClass("active");
    			this.getData("w",storeId, week);
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
    	  	//预览按钮
            btnPreview: function() {
                var data = $("#table").bootstrapTable("getSelections");
                if (data.length != 1) {
                    msgAlert("提示", "请选择一条数据进行操作！", "error");
                    return;
                }
                this.$options.methods.showDetail(data[0].accountId);
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
    	            choose: function(dates){
    	            	var storeId = that.selectStore == '-1' ? "" : that.selectStore;
    	            	that.getData("d",storeId, dates);
    	            }
    	    	});
    	    },
    	  	//初始化按月查询
    	    initMouth: function(){
    	    	var that = this;
    	    	laydate({
    	        	elem: '#mouth',
    	            format: 'YYYY-MM',
    	            max: laydate.now(),
    	            choose: function(dates){
    	            	var storeId = that.selectStore == '-1' ? "" : that.selectStore;
    	            	that.getData("m",storeId, dates);
    	            }
    	    	});
    	    },
    	  //初始化按年查询
    	    initYear: function(){
    	    	var that = this;
    	    	laydate({
    	        	elem: '#year',
    	            format: 'YYYY',
    	            max: laydate.now(),
    	            choose: function(dates){
    	            	var storeId = that.selectStore == '-1' ? "" : that.selectStore;
    	            	that.getData("y",storeId, dates);
    	            }
    	    	});
    	    },
    	    //获取远程数据
    	    getData : function(dateType,storeId, createDate, cb){
    	    	var that = this,newArr = [];
        		$.ajax({
    				url: reportHost + "/report/report/sale/listDetailedMonitor.action",
    				type:"GET",
    				dataType:"jsonp",
    				contentType: "application/json",
    				jsonp:"callback",
    				data: "js_code=aer&appid=awere&secrect=aer&storeId="+storeId+"&userId=aere&dateType="+dateType+"&createDate="+createDate+"",
    				success: function(res){
    					if(res.status == 200){
    						newArr = res.data;
    						newArr.sort(function(a, b){
    							if(!isNaN(Number(a.sellAmount)) && !isNaN(Number(b.sellAmount))){
    								return b.sellAmount - a.sellAmount;
    							}
    						});
    						$.each(newArr, function(i){ this.ranking = i+1; });
    						that.initTabelData = newArr;
    						$("#table").bootstrapTable('refreshOptions', {data: that.initTabelData});
    						typeof cb == 'function' ? cb(newArr) : '';
    					}else{
    						msgAlert("提示", "查询数据有误，请刷新！", "error");
    					}
    				}
    			})
    	    },
    		//获取门店排行数据
    	    _getStoreRank: function(dateType) {
    	    	var that = this
    	    	$("#table").bootstrapTable('showLoading')
    	    	getStoreRank(dateType, function(res){
    	    		$("#table").bootstrapTable('hideLoading')
    	    		if(res.length) {
    	    			var data = {
    	    				rows: res,
    	    				total: res.length
    	    			}
    	    			$("#table").bootstrapTable('load', data)
    	    		}
    	    	})
    	    }
    	},
    	created:function() {
    		var that = this;
    		var time = that.initGetDate('d');
    		that.getData("d","", time, function(data){
    			that.storeData = data;
    		});
    	},
    	watch: {
    		selectStore: function (newVal, oldVal) {
    			var dateType = $(".selectDate button.active").attr("dateType");
    			var time = this.initGetDate(dateType);
    			var storeId = newVal == '-1' ? "" : newVal;
    			this.getData(dateType,storeId, time);
    		}
    	},
    	mounted:function(){
    		//初始化表格
    		this.initTableData();
    		this._getStoreRank(3)
    		/* //皮肤
    	    laydate.skin('molv');
    		//初始化按天查询
    		this.initDay();
    		//初始化按月查询
    	    this.initMouth();
    	  	//初始化按年查询
    	    this.initYear();
    	  	//初始化日期选择框显示
    	  	this.initDateSelected(); */
    	}
    })
    
    
</script>
<%@include file="/common/footer.jsp" %>
