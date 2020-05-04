function initCountUp(el, op, start) {
	var commomParam = {
		useEasing: true, 
		useGrouping: true, 
		separator: '', 
		decimal: '.', 
	}
	start = start || 0
	var options = $.extend({}, commomParam, op)
	return new CountUp(el, start, 0, 0, 2, options);
}

//补零
function prefixZero(money) {
	var result = []
	var moneyL = money.toString().length
	for(var i = moneyL; i < 10; i++) {
		if(i % 3 === 0) {
			result.unshift(',')
		}
		result.unshift(0)
	}
	return result.join('')
}


//根据时间戳 格式化时间日期
function initDateForTime(time) {
	var date = new Date(time)
	return date.getHours() + '点' + date.getMinutes() +'分'
}

//补0
function p(s) {
    return s < 10 ? '0' + s: s;
}

//获取当前时间
function getNowTime() {
	var myDate = new Date();	
	var year=myDate.getFullYear();	//获取当前年
	var month=myDate.getMonth()+1;	//获取当前月
	var date=myDate.getDate(); 		//获取当前日
	var h=myDate.getHours();       //获取当前小时数(0-23)
	var m=myDate.getMinutes();     //获取当前分钟数(0-59)
	var s=myDate.getSeconds();  
	return year+'-'+p(month)+"-"+p(date)+" "+p(h)+':'+p(m)+":"+p(s)
}

