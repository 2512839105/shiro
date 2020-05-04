var reportHost = 'https://dzxiaomi.asdzy.com'
var appid = 'wx6061d5a96520f166'
var secrect = '5c5ee5e5b9165db90960a124573baa93'
var grant_type = 'authorization_code'
	
var REQUEST_OK = 200
	
var commParams = {
	appid:appid,
	secrect: secrect,
	grant_type: grant_type,
}

//截取字符串
function subRes(res) {
	res = res.slice(5, -1)
	res = res.replace(/'/g, '"')
	return JSON.parse(res)
}

/**
 * 销售速报
 * dateTye d
 * */
function getAreaListData(storeId, dateType, fn){
	var url = ctx + "/report/report/sale/listReport.action"
	var data = $.extend({}, commParams, {dateType: dateType, storeId: storeId})
	$.get(url, data, fn)
}


/**
 * 店长速报
 * dateTye d
 * */
function getShopChief(storeId, dateType, fn) {
	var url = ctx + "/report/report/sale/shopChief.action" 
	var data = $.extend({}, commParams, {dateType: dateType, storeId: storeId})
	$.get(url, data, function(res) {
		fn(subRes(res))
	})
}

/**
 * 门店排行
 * dateType 1天 2周 3月 4年
 * */
function getStoreRank(dateType, fn) {
	var url = ctx + "/report/report/sale/Rankings.action" 
	var data = $.extend({}, commParams, {dateType: dateType})
	$.get(url, data, function(res) {
		fn(JSON.parse(res))
	})
}

/**
 * 门店员工排行
 * */
function getStaffRank(storeId, fn) {
	var url = ctx + "/report/report/sale/personalRankings.action"
	var data = $.extend({}, commParams, {storeId: storeId})
	$.get(url, data, function(res) {
		fn(JSON.parse(res))
	})
}

/**
 * 员工本月 和上个月
 * dateType
 * storeId
 * userId
 * seller
 * */
function getEmployeePerformance(op, fn) {
	var url = ctx + "/report/report/sale/employeePerformance.action"
	var data = $.extend({}, commParams, op)
	$.get(url, data, function(res) {
		fn(JSON.parse(res))
	})
}

/**
 * 员工业绩 个人曲线图
 * dateType
 * storeId
 * userId
 * */
function getStaffCvs(op, fn) {
	var url = ctx + "/report/report/sale/personalSales.action"
	var data = $.extend({}, commParams, op)
	$.get(url, data, function(res) {
		fn(JSON.parse(res))
	})
}




