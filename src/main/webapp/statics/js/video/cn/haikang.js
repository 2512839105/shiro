
var deviceport='';
var rtspport='';
var g_iWndIndex = 0;
var ipAddress = '';
// 登录
function clickLogin() {
    var szIP = '192.168.0.117',
        szPort = '80',
        szUsername = 'admin',
        szPassword = 'adminWXWPAO';

    if ("" == szIP || "" == szPort) {
        return;
    }

    var szDeviceIdentify = szIP + "_" + szPort;

    var iRet = WebVideoCtrl.I_Login(szIP, 1, szPort, szUsername, szPassword, {
        success: function (xmlDoc) {            
            setTimeout(function () {
				ipAddress = szDeviceIdentify;
                getChannelInfo();
                getDevicePort(szDeviceIdentify);
            }, 10);
        },
        error: function (status, xmlDoc) {
			alert("请重新确认最新IP地址");
        }
    });

    if (-1 == iRet) {
        showOPInfo(szDeviceIdentify + " 已登录过！");
    }
}

// 获取通道
function getChannelInfo() {
    var szDeviceIdentify = 1,
        oSel = $("#channels").empty();

    if (null == szDeviceIdentify) {
        return;
    }

    // 模拟通道
    WebVideoCtrl.I_GetAnalogChannelInfo(szDeviceIdentify, {
        async: false,
        success: function (xmlDoc) {
        }
    });
    // 数字通道
    WebVideoCtrl.I_GetDigitalChannelInfo(szDeviceIdentify, {
        async: false,
        success: function (xmlDoc) {
            var oChannels = $(xmlDoc).find("InputProxyChannelStatus");

            $.each(oChannels, function (i) {
                var id = $(this).find("id").eq(0).text(),
                    name = $(this).find("name").eq(0).text(),
                    online = $(this).find("online").eq(0).text();
                if ("false" == online) {// 过滤禁用的数字通道
                    return true;
                }
                if ("" == name) {
                    name = "IPCamera " + (i < 9 ? "0" + (i + 1) : (i + 1));
                }
            });
        }
    });
    // 零通道
    WebVideoCtrl.I_GetZeroChannelInfo(szDeviceIdentify, {
        async: false,
        success: function (xmlDoc) {
            var oChannels = $(xmlDoc).find("ZeroVideoChannel");
            
            $.each(oChannels, function (i) {
                var id = $(this).find("id").eq(0).text(),
                    name = $(this).find("name").eq(0).text();
                if ("" == name) {
                    name = "Zero Channel " + (i < 9 ? "0" + (i + 1) : (i + 1));
                }
                if ("true" == $(this).find("enabled").eq(0).text()) {// 过滤禁用的零通道
                }
            });
        }
    });
}

// 获取端口
function getDevicePort(szDeviceIdentify) {

    if (null == szDeviceIdentify) {
        return;
    }

    var oPort = WebVideoCtrl.I_GetDevicePort(szDeviceIdentify);
    if (oPort != null) {
		deviceport = oPort.iDevicePort;
		rtspport = oPort.iRtspPort；
    }
}


function clickStartRealPlay(iStreamType) {
    var oWndInfo = WebVideoCtrl.I_GetWindowStatus(g_iWndIndex),
        szDeviceIdentify = ipAddress,
        iRtspPort = parseInt(rtspport, 10),
        iChannelID = parseInt('1', 10),
        bZeroChannel = true,
        szInfo = "";


    if (null == szDeviceIdentify) {
        return;
    }

    var startRealPlay = function () {
        WebVideoCtrl.I_StartRealPlay(szDeviceIdentify, {
            iRtspPort: iRtspPort,
            iStreamType: iStreamType,
            iChannelID: iChannelID,
            bZeroChannel: bZeroChannel,
            success: function () {
              
            }
        });
    };

    if (oWndInfo != null) {// 已经在播放了，先停止
        WebVideoCtrl.I_Stop({
            success: function () {
                startRealPlay();
            }
        });
    } else {
        startRealPlay();
    }
}