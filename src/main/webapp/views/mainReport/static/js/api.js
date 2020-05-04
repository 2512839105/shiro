var appid = 'wx6061d5a96520f166'
var secrect = '5c5ee5e5b9165db90960a124573baa93'
var grant_type = 'authorization_code'
	
var REQUEST_OK = 200
	
var commParams = {
	appid:appid,
	secrect: secrect,
	grant_type: grant_type,
}


function getJSONParse(url, op, fn) {
	var data = $.extend({}, commParams, op)
	$.get(url, data, function (res) {
		res = JSON.parse(res)
		fn(res)
	})
}


// display/selectStoreNameRank.action
// 根据药品类别销售额 对品牌排行  对门店排行
//参数 dateType companyId codeId
function getCategoryRankAndType(op, fn) {
	var url = ctx + '/display/selectStoreNameRank.action'
	getJSONParse(url, op, fn)
}

// display/selectAll.action
// 获取F4 所有门店数量
//参数companyId
function getStoreAll(op, fn) {
	var url = ctx + '/display/selectAll.action'
	getJSONParse(url, op, fn)
}

// display/selectAllInterface.action
function getMoreData(op, fn) {
	var url = ctx +  '/display/selectAllInterface.action'
	getJSONParse(url, op, fn)
}

// display/realTimeSales.action
// 获取底部滚动条数据
// 参数companyId
function getScrollData(op, fn){
	var url = ctx + '/display/realTimeSales.action'
	getJSONParse(url, op, fn)
}

// display/sellAmountGoupByHour.action
// 获取每小时销售额
function getSellGoupByHour(op, fn) {
	var url = ctx + '/display/sellAmountGoupByHour.action'
	getJSONParse(url, op, fn)
}
