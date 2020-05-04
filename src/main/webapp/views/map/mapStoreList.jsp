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
    <link rel="stylesheet" type="text/css" href="${ctx}/views/mainReport/static/css/element-ui.min.css" />	
    <link rel="stylesheet" type="text/css" href="${ctx}/statics/css/reset.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/views/map/statics/css/mapStore.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/statics/css/jquery.mCustomScrollbar.min.css" />
    <link rel="stylesheet" type="text/css" href="https://at.alicdn.com/t/font_658799_kj0ujpdink.css" />
    <script type="text/javascript" src="${ctx}/statics/js/jquery/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="${ctx}/statics/plugins/vue/vue.min.js"></script>
    <script type="text/javascript" src="${ctx}/views/mainReport/static/js/element-ui.min.js"></script>
    <script type="text/javascript" src="${ctx}/statics/js/jquery/jquery.mCustomScrollbar.min.js"></script>
    <script type="text/javascript" src="${ctx}/statics/js/city.js"></script>
    <script type="text/javascript" src="${ctx}/statics/js/js-cookie.js"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=mQTUWhZ4tEqNpxjyFcsYgKaRFPGbItbc"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/library/Heatmap/2.0/src/Heatmap_min.js"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/library/TextIconOverlay/1.2/src/TextIconOverlay_min.js"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/library/MarkerClusterer/1.2/src/MarkerClusterer_min.js"></script>
</head>
<body>
    <div id="mapStoreList" class="clearfix">
        <div class="map_left pull-left">
            <div class="map_left_title">好有面云平台</div>
            <h3 class="map_left_rank text-center">药店排行榜</h3>
            <p class="map_left_rank_egs text-center">DRUG STORE RANKINGS</p>
            <div class="map_left_inner">
                <p class="map_left_inner_top clearfix" v-cloak>
                    <span class="pull-left">药店总数</span>
                    <span class="pull-right">{{AllStoreList.length}} 家</span>
                </p>
                <!-- <div class="input-group input-group-sm map_left_inner_search">
                      <input type="text" class="form-control" placeholder="输入门店名称" v-model="searchStoreNameModel" 
                          @keyup.enter="searchStoreName" aria-describedby="basic-addon2">
                      <span class="input-group-btn">
                        <button class="btn btn-default" @click="searchStoreName" type="button">搜索</button>
                    </span>
                </div> -->
                <div class="mCustomScrollbar">
                    <ul class="map_left_inner_list" v-cloak>
                        <li class="map_left_inner_cell cleafix" v-for="(item,index) in AllStoreList"
                        :key="item.storeId" @click="selectStoreLocation(item)">
                            <span class="sort pull-left">{{(index+1)}}</span>
                            <span class="name">{{item.storeName}}</span>
                            <span class="sale pull-right text-right">{{item.sellAmount | formatNumWan}}</span>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="map_right pull-right">
            <div class="map_right_areaScreen clearfix" v-cloak>
                <div class="map_right_areaScreen_cell">
                    <span class="pull-left">地区筛选:</span>
                    <span class="locationCityName" @click="toggleCity">{{locationCityName}}
                        <i class="iconfont icon-zhankai"></i>
                    </span>
                </div>
                
                <div class="map_right_areaScreen_cell clearfix">
                    <input type="text" class="pull-left searchText" @focus="getComponyData" 
                        @keyup="getComponyData" v-model="searchCompanyNameModel" placeholder="输入集团/公司名称" />
                    
                    <div class="selectStoreModel">
                        <ul class="selectStoreModel_list">
                            <li v-for="(item,index) in companyList" :key="index" 
                            @click="clickSelectCompony($event,item.companyName,item.companyId)">{{item.companyName}}</li>
                        </ul>
                        
                        <p class="data-loading text-center" v-show="loadGetStoreStatus">数据加载中...</p>
                    </div>
                </div>
                
                <div class="map_right_areaScreen_cell clearfix">
                    <input type="text" class="pull-left searchText" @focus="getStoreNameData"
                      @keyup="getStoreNameData" v-model="searchCompanyAndStoreNameModel" placeholder="输入门店名称" />
                    <button  class="pull-right">搜索</button>
                    
                    <div class="selectStoreModel">
                        <ul class="selectStoreModel_list">
                            <li v-for="(item,index) in storeList" :key="index" 
                            @click="clickSelectStore($event,item.storeName,item.storeAddress)">{{item.storeName}}</li>
                        </ul>
                        
                        <p class="data-loading text-center" v-show="loadGetStoreStatus">数据加载中...</p>
                    </div>
                </div>
                
                <!-- 城市模态框 -->
                <div class="city_model">
                    <p class="city_model_locationCity">
                        当前城市: {{locationCityName}}
                    </p>
                    <div class="city_model_omit">
                        <p>省份:</p>
                        <ul class="list-inline">
                            <li v-for="(item,key,index) in omitData" :key="key">
                                <a href="javascript:;" :data-key="key" @dblclick="locationOmit(item.name)"
                                @click="selectOmitCityData(key,item.name)">{{item.name}}</a>
                            </li>
                        </ul>
                    </div>
                    <div class="city_model_omit">
                        <p>城市:</p>
                        <ul class="list-inline">
                            <li v-for="(item,key,index) in omitCityData" :key="key" @click="cityLocation(item.name)">
                                <a href="javascript:;" :data-key="key">{{item.name}}</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div id="allmap" @click="closeAlertModel" style="width: 100%;height:100vh;"></div>
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
    
    
    
<script type="text/javascript">
var ctx = "${ctx}";
var host = ctx;
var time = null;
 
var mapStoreListVm = new Vue({
    el:"#mapStoreList",
    data:function(){
        return{
        	isShowClose: false,
    		dialogFormVisible: false,
    		formLabelWidth: '120px',
    		form: {
              username: '',
              password: ''
            },
            AllStoreList:[],
            companyList:[],
            storeList:[],
            searchCompanyNameModel:"",
            searchCompanyAndStoreNameModel:"",
            activeCompanyId:"",
            locationCityName:'',
            toggleCityStatus:0,
            loadGetStoreStatus:true,
            omitData:[],
            omitCityData:[],
            pointArr:[]
        }
    },
    created:function(){
        this.initGetData();
        
        //滚动条
        this.$nextTick(function(){
            $(".map_left_inner_list").mCustomScrollbar({axis: "y" });
        })
    },
    mounted:function(){
    	if(Cookies.get("isLogin") == 'true') {
    		/* this.form.username = 'admin'
    		this.form.password = '123456'
    		this.login() */
    	} else {
    		this.dialogFormVisible = true
    	}
    	
        this.locationCity();
        // this.initMapHot()
    },
    methods:{
    	login: function() {
    		//登录成功
    		if(this.form.username == "admin" && this.form.password == "123456") {
    			this.dialogFormVisible = false
    			Cookies.set("isLogin", true)
    		}
    	},
        initJsonp:function(url,data,cb){
            $.ajax({
                 type : "get",
                 url : host + url,
                 data:data,
                 dataType : "json",
                 success : function(res){ 
                    if(res.msg == '成功'){
                        cb(res)
                    }
                 },
                 error:function(res){
                     alert("请求错误");
                 }
             });
        },
        //热力图
        initMapHot: function() {
        	 var map = new BMap.Map("allmap");
        	 map.centerAndZoom(new BMap.Point(116.418261, 39.921984), 15);
        	 map.enableScrollWheelZoom(); 
        	 var points =[

        		    {"lng":116.41929,"lat":39.915908,"count":54},
        		    {"lng":116.422116,"lat":39.919658,"count":21},
        		    {"lng":116.4183,"lat":39.925015,"count":15},
        		    {"lng":116.421969,"lat":39.913527,"count":3},
        		    {"lng":116.422936,"lat":39.921854,"count":24},
        		    {"lng":116.41905,"lat":39.929217,"count":12},
        		    {"lng":116.424579,"lat":39.914987,"count":57},
        		    {"lng":116.42076,"lat":39.915251,"count":70},
        		    {"lng":116.425867,"lat":39.918989,"count":8}];
        	heatmapOverlay = new BMapLib.HeatmapOverlay({"radius":100,"visible":true});
        	map.addOverlay(heatmapOverlay);
        	heatmapOverlay.setDataSet({data: points, max:200});
        	heatmapOverlay.show();
        },
        //初始化时请求数据
        initGetData:function(){
            var that = this;
            this.initJsonp("/displayMonitor/selectStoreRankRegion.action",{},function(res){
                var data = res.data;
                /* data.sort(function(a,b){
                    return parseFloat(a.sellAmount) - parseFloat(b.sellAmount);
                }); */
                that.AllStoreList = data;
                that.addressParse({"data":data,"that":that});
            });
        },
        //定位当前城市
        locationCity :function(){
            var that = this;
            var map = new BMap.Map("allmap");
            
            //获取当前城市定位
            var myCity = new BMap.LocalCity();
            myCity.get(function(result){
                var cityName = result.name;
                if(cityName){
                    map.setCenter(cityName);
                    that.locationCityName = cityName;
                }
            });
        },
        //地址解析
        addressParse:function(obj){
            if(!obj.data instanceof Array){
                throw new Error("传入参数错误")
                return false
            }
            var myGeo = new BMap.Geocoder();
            var map = new BMap.Map("allmap");
            var that = obj.that;
            			
            if(obj.data.length == 1) {
            	if(obj.data[0].storeAddress){
	            	myGeo.getPoint(obj.data[0].storeAddress, function(point) {
	            		if(point) {
	            			var i = 8
	            			map.centerAndZoom(point, i);
	            			var zoomTimer = setInterval(function() {
	            				i = i +2
	            				map.centerAndZoom(point, i);
	            				if(i > 20) {
	            					clearInterval(zoomTimer)
	            				}
	            			}, 250)
	            			map.enableScrollWheelZoom();
	            			var marker = new BMap.Marker(point);
	            			marker.addEventListener("click", function() {
                            	that.showVideoModel(obj.data[0])
                            })
                            var label = new BMap.Label(obj.data[0].storeName, {offset: new BMap.Size(20,0)});
	            			label.setStyle({color: "#4a7e8b",fontSize: "16px", fontWeight: "bold", border:"none"})
                            map.addOverlay(marker);	
	            			marker.setLabel(label);
	            		} else {
	            			alert("您选择的门店暂无详细地址")
	            		}
	            		
	            	})
            	}
            } else {         	
               	map.centerAndZoom(new BMap.Point(116.404, 39.915), 5);
                map.enableScrollWheelZoom();          
                
                var pointArr = [];
                var markers = [];
                var dataArr = obj.data;
                var maxNum = dataArr.length;
                var i = 0;
                
                (function eachAddress(j){
                    if(j < maxNum){
                        if(dataArr[j].storeAddress){
                            myGeo.getPoint(dataArr[j].storeAddress, function(point){
                                if (point) {
                                    var marker = new BMap.Marker(point);
                                    marker.addEventListener("click", function() {
                                    	that.showVideoModel(dataArr[j])
                                    });
                                    
                                    var label = new BMap.Label(obj.data[j].storeName, {offset: new BMap.Size(30,0)});
                                    label.setStyle({color: "#4a7e8b",fontSize: "16px", fontWeight: "bold", border:"none"})
        	            			marker.setLabel(label);
                                    markers.push(marker);
                                    
                                    pointArr.push({"storeName":dataArr[j].storeName,"point":point});
                                }
                                eachAddress(++i);
                            });
                        }else{
                            console.log("解析地址失败或解析地址不存在:"+dataArr[j]);
                            eachAddress(++i);
                        }
                    }else{
                        new BMapLib.MarkerClusterer(map, {markers: markers});
                        
                        that.getMapZoom(map,pointArr,obj.zoom);
                        return false;
                    }
                })(i);
                
                // 查看省/城市
                if(obj.defualtData){
                    myGeo.getPoint(obj.defualtData, function(point){
                        map.centerAndZoom(point, 8);
                    })
                }
            	
            }
        },
        //监听地图的缩放
        getMapZoom:function(map,pointArr,zoom){
            var scrollFunc = function(e){
                e=e || window.event;
                if(map.getZoom() >= 13 || zoom){
                    showTextLabel(pointArr);
                }else{
                    //移除文本
                    var allOverlay = map.getOverlays();
                    for (var j = 0; j< allOverlay.length; j++){
                        map.removeOverlay(allOverlay[j]);
                    }
                }
            }
            /*注册事件*/
            if(document.addEventListener){
                document.addEventListener('DOMMouseScroll',scrollFunc,false);
            }//W3C
            window.onmousewheel=document.onmousewheel=scrollFunc;//IE/Opera/Chrome
            
            //当zoom为true时无需滚动自动触发
            zoom ? showTextLabel(pointArr) : '';
            
            function showTextLabel(pointArr){
                for(var i =0,len=pointArr.length;i<len;i++){
                    //添加文本
                    var label = new BMap.Label(pointArr[i].storeName, {
                      position : pointArr[i].point,
                      offset   : new BMap.Size(10, -18)
                    });
                    label.setStyle({
                         color : "#4a7e8b",
                         fontSize : "16px",
                         height : "10px",
                         lineHeight : "10px",
                         fontFamily:"微软雅黑",
                           border:"none",
                           background:"transparent"
                     });
                    map.addOverlay(label);
                }
            }
        },
        //选择门店定位
        selectStoreLocation:function(item){
            if(item.storeAddress){
                this.addressParse({"data": [item],"that":this,"zoom":true});
            }else{
                alert("解析地址不能为空");
                return;
            }
        },
        //城市定位
        cityLocation:function(cityName){
            //this.addressParse(this.AllStoreList,this,cityName);
            this.addressParse({"data":this.AllStoreList,"that":this,"defualtData":cityName});
            this.locationCityName = cityName;
        },
        //打开监控视频页面
        showVideoModel:function(data){
        	window.localStorage.setItem("__storeId__", data.storeId)
        	window.localStorage.setItem("__storeName__", data.storeName)
            window.open(ctx+"/views/map/videoDetails.jsp")
        },
        //切换选择城市模态框
        toggleCity:function(){
            var that = this.$data;
            if(that.toggleCityStatus){
                $(".city_model").animate({"top":'70px',"opacity":'0'},230,function(){
                    $(this).css({"display":"none"})
                })
                that.toggleCityStatus = 0
            }else{
                $(".city_model").css({"display":"block"}).animate({"top":'36px',"opacity":'1'},230)
                that.toggleCityStatus = 1;
                
                //获取省信息
                that.omitData = city;
            }
        },
        //双击省定位
        locationOmit:function(omitName){
            clearTimeout(time);
            //this.addressParse(this.AllStoreList,this,omitName);
            
            this.addressParse({"data":this.AllStoreList,"that":this,"defualtData":omitName});
            
            this.locationCityName = omitName;
        },
        //获取城市列表
        selectOmitCityData:function(key,name){
            clearTimeout(time);
            var that = this;
            time = setTimeout(function(){
                if(city[key].child.length == 0){
                    that.cityLocation(name);
                }else{
                    that.omitCityData = city[key].child;
                }
            },300)
        },
        //获取集团/公司信息
        getComponyData:function(event){
            var target = event.path[1];
            var that = this;
            var companyName = this.searchCompanyNameModel;
            $(target).children(".selectStoreModel").show().animate({"top":"35px","opacity":1});
            
            if(companyName){
                this.initJsonp("/displayMonitor/selectStoreByCompany.action",{"companyName":companyName},function(res){
                    that.loadGetStoreStatus = false;
                    that.companyList = res.data;
                });
            }
        },
        //获取门店名称信息
        getStoreNameData:function(event){
            var target = event.path[1];
            var that = this;
            var storeName = this.searchCompanyAndStoreNameModel;
            var companyId = this.activeCompanyId;
            $(target).children(".selectStoreModel").show().animate({"top":"35px","opacity":1});
            
            if(storeName){
                this.initJsonp("/displayMonitor/selectStoreByName.action",
                {"storeName":storeName,"companyId":companyId},function(res){
                    that.loadGetStoreStatus = false;
                    that.storeList = res.data;
                });
            }
        },
        //点击选择集团/公司
        clickSelectCompony:function(event,companyName,companyId){
            this.searchCompanyNameModel = companyName;
            this.activeCompanyId = companyId;
            this.removeModel(event);
        },
        //点击确定选择门店
        clickSelectStore:function(event,storeName,storeAddress){
            this.searchCompanyAndStoreNameModel = storeName;
            
            this.addressParse({"data":[{"storeAddress":storeAddress,"storeName":storeName}],"that":this});
            this.removeModel(event);
        },
        //隐藏查询模态框
        removeModel:function(event){
            var target = event.path[2];
            this.loadGetStoreStatus = true;
            $(target).animate({"top":"50px","opacity":0}).hide();
        },
        closeAlertModel:function(){
            $(".selectStoreModel").animate({"top":"50px","opacity":0}).hide();
            $(".searchText")[0].blur();
        },
        
    },
    filters:{
         formatNumWan: function(value){
        	if(!value) {
        		return ''
        	}
            return typeof Number(value) !== 'number' ? value : (parseInt(value) > 9999 ? Math.floor(value/1000)/10+"(万)" : Number(value).toFixed(2)+"(元)");
        }
    }
})

function setGradient(){
 	/*格式如下所示:
	{
  		0:'rgb(102, 255, 0)',
 	 	.5:'rgb(255, 170, 0)',
	  	1:'rgb(255, 0, 0)'
	}*/
 	var gradient = {};
 	var colors = document.querySelectorAll("input[type='color']");
 	colors = [].slice.call(colors,0);
 	colors.forEach(function(ele){
		gradient[ele.getAttribute("data-key")] = ele.value; 
 	});
    heatmapOverlay.setOptions({"gradient":gradient});
}
</script>
</body>
</html>