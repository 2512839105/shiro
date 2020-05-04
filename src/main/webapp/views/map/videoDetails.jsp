<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<title>好友面云平台</title>
<link rel="icon" href="${ctx}/statics/images/title-icon.ico" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/statics/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/statics/css/reset.css" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/views/map/statics/css/videoDetails.css" />
<link rel="stylesheet" type="text/css"
	href="https://at.alicdn.com/t/font_658799_kj0ujpdink.css" />
<script type="text/javascript"
	src="${ctx}/statics/js/jquery/jquery-1.11.3.min.js"></script>
<script type="text/javascript"
	src="${ctx}/statics/plugins/vue/vue.min.js"></script>
<script type="text/javascript" src="${ctx}/statics/js/js-cookie.js"></script>

</head>
<body>
<script src="https://open.ys7.com/sdk/js/1.4/ezuikit.js"></script>
	<div>
		<div class="videoDetails alertModel">
			<div class="container">
				<h2>嘉伦集团分店实时监控</h2>
				<div class="videoBox clearfix">
					<div id="divPlugin" class="plugin"></div>
					<video id="myPlayer" poster="" controls playsInline webkit-playsinline autoplay width="1200px" height="500px">
					    <source src="rtmp://rtmp.open.ys7.com/openlive/56121ecd3c744316a4342dfdde4dd44e.hd" type="" />
					    <source src="http://hls.open.ys7.com/openlive/56121ecd3c744316a4342dfdde4dd44e.hd.m3u8" type="application/x-mpegURL" />
					</video>
				</div>
				<div class="videoBox_history">
					<h3 class="text-center title-his" onclick="clickStartRealPlay()">返回当前</h3>
					<h3 class="text-center">历史监控</h3>
					<ul class="videoBox_history_list">
					</ul>
				</div>

				<fieldset class="login" style="display: none">
					<legend>登录</legend>
					<table cellpadding="0" cellspacing="3" border="0">
						<tr>
							<td class="tt">IP地址</td>
							<td><input id="loginip" type="text" class="txt"
								value="192.168.0.112" /></td>
							<td class="tt">端口号</td>
							<td><input id="port" type="text" class="txt" value="80" /></td>
						</tr>
						<tr>
							<td class="tt">用户名</td>
							<td><input id="username" type="text" class="txt"
								value="admin" /></td>
							<td class="tt">密码</td>
							<td><input id="password" type="password" class="txt"
								value="adminWVWPAO" /></td>
						</tr>
						<tr>
							<td class="tt">设备端口</td>
							<td colspan="2"><input id="deviceport" type="text"
								class="txt" />（可选参数）</td>
							<td>窗口分割数&nbsp; <select class="sel2"
								onchange="changeWndNum(this.value);">
									<option value="1" selected>1x1</option>
									<option value="2">2x2</option>
									<option value="3">3x3</option>
									<option value="4">4x4</option>
							</select>
							</td>
						</tr>
						<tr>
							<td class="tt">RTSP端口</td>
							<td colspan="3"><input id="rtspport" type="text" class="txt" />（可选参数）</td>
						</tr>
						<tr>
							<td colspan="4"><input type="button" class="btn" value="登录"
								onclick="clickLogin();" /> <input type="button" class="btn"
								value="退出" onclick="clickLogout();" /> <input type="button"
								class="btn2" value="获取基本信息" onclick="clickGetDeviceInfo();" />
							</td>
						</tr>
						<tr>
							<td class="tt">已登录设备</td>
							<td><select id="ip" class="sel"
								onchange="getChannelInfo();getDevicePort();"></select></td>
							<td class="tt">通道列表</td>
							<td><select id="channels" class="sel"></select></td>
						</tr>
					</table>
				</fieldset>
				<fieldset class="ipchannel" style="display: none">
					<legend>数字通道</legend>
					<table width="100%" cellpadding="0" cellspacing="3" border="0">
						<tr>
							<td><input type="button" class="btn" value="获取数字通道列表"
								onclick="clickGetDigitalChannelInfo();" /></td>
						</tr>
						<tr>
							<td>
								<div class="digitaltdiv">
									<table id="digitalchannellist" class="digitalchannellist"
										cellpadding="0" cellspacing="0" border="0"></table>
								</div>
							</td>
						</tr>
					</table>
				</fieldset>
				<fieldset class="localconfig" style="display: none">
					<legend>本地配置</legend>
					<table cellpadding="0" cellspacing="3" border="0">
						<tr>
							<td class="tt">播放性能</td>
							<td><select id="netsPreach" name="netsPreach" class="sel">
									<option value="0">最短延时</option>
									<option value="1">实时性好</option>
									<option value="2">均衡</option>
									<option value="3">流畅性好</option>
							</select></td>
							<td class="tt">图像尺寸</td>
							<td><select id="wndSize" name="wndSize" class="sel">
									<option value="0">充满</option>
									<option value="1">4:3</option>
									<option value="2">16:9</option>
							</select></td>
						</tr>
						<tr>
							<td class="tt">规则信息</td>
							<td><select id="rulesInfo" name="rulesInfo" class="sel">
									<option value="1">启用</option>
									<option value="0">禁用</option>
							</select></td>
							<td class="tt">抓图文件格式</td>
							<td><select id="captureFileFormat" name="captureFileFormat"
								class="sel">
									<option value="0">JPEG</option>
									<option value="1">BMP</option>
							</select></td>
						</tr>
						<tr>
							<td class="tt">录像文件打包大小</td>
							<td><select id="packSize" name="packSize" class="sel">
									<option value="0">256M</option>
									<option value="1">512M</option>
									<option value="2">1G</option>
							</select></td>
							<td class="tt">协议类型</td>
							<td><select id="protocolType" name="protocolType"
								class="sel">
									<option value="0">TCP</option>
									<option value="2">UDP</option>
							</select></td>
						</tr>
						<tr>
							<td class="tt">录像文件保存路径</td>
							<td colspan="3"><input id="recordPath" type="text"
								class="txt" />&nbsp;<input type="button" class="btn" value="浏览"
								onclick="clickOpenFileDlg('recordPath', 0);" /></td>
						</tr>
						<tr>
							<td class="tt">回放下载保存路径</td>
							<td colspan="3"><input id="downloadPath" type="text"
								class="txt" />&nbsp;<input type="button" class="btn" value="浏览"
								onclick="clickOpenFileDlg('downloadPath', 0);" /></td>
						</tr>
						<tr>
							<td class="tt">预览抓图保存路径</td>
							<td colspan="3"><input id="previewPicPath" type="text"
								class="txt" />&nbsp;<input type="button" class="btn" value="浏览"
								onclick="clickOpenFileDlg('previewPicPath', 0);" /></td>
						</tr>
						<tr>
							<td class="tt">回放抓图保存路径</td>
							<td colspan="3"><input id="playbackPicPath" type="text"
								class="txt" />&nbsp;<input type="button" class="btn" value="浏览"
								onclick="clickOpenFileDlg('playbackPicPath', 0);" /></td>
						</tr>
						<tr>
							<td class="tt">回放剪辑保存路径</td>
							<td colspan="3"><input id="playbackFilePath" type="text"
								class="txt" />&nbsp;<input type="button" class="btn" value="浏览"
								onclick="clickOpenFileDlg('playbackFilePath', 0);" /></td>
						</tr>
						<tr>
							<td class="tt">设备抓图保存路径</td>
							<td colspan="3"><input id="devicePicPath" type="text"
								class="txt" />&nbsp;<input type="button" class="btn" value="浏览"
								onclick="clickOpenFileDlg('devicePicPath', 0);" /></td>
						</tr>
						<tr>
							<td colspan="4"><input type="button" class="btn" value="获取"
								onclick="clickGetLocalCfg();" />&nbsp;<input type="button"
								class="btn" value="设置" onclick="clickSetLocalCfg();" /></td>
						</tr>
					</table>
				</fieldset>
			</div>
			<div class="main-control clearfix">
				<div class="main-td">
					<span class="glyphicon glyphicon-camera" title="拍照" onclick="clickCapturePic()"></span>	
				</div>
				<div class="main-center">
					<div class="main-body">
						<div>
							<button class="none-btn" onmousedown="mouseDownPTZControl(1);" onmouseup="mouseUpPTZControl();">
								<span class="glyphicon glyphicon-menu-up" ></span>
							</button>
						</div>
						<div style="height: 78px;padding-top: 14px;vertical-align: middle;">
							<button class="none-btn" onmousedown="mouseDownPTZControl(3);" onmouseup="mouseUpPTZControl();">
								<span class="glyphicon glyphicon-menu-left"></span>
							</button>
							<span style="display:inline-block;background: #f37f4c; height: 40px;width:40px; border-radius: 50%;margin: 0 12px;"></span>
							<button class="none-btn" onmousedown="mouseDownPTZControl(4);" onmouseup="mouseUpPTZControl();">
								<span class="glyphicon glyphicon-menu-right"></span>
							</button>
						</div>
						<div>
							<button class="none-btn" onmousedown="mouseDownPTZControl(2);" onmouseup="mouseUpPTZControl();">
								<span class="glyphicon glyphicon-menu-down"></span>
							</button>
						</div>
					</div>					
				</div>
				<div class="main-td">
					<span class="glyphicon glyphicon-facetime-video" title="录像"></span>	
				</div>
			</div>
			<div class="detail-report">
				<ul class="list-inline report_list">
                    <li class="report_cell" 
                        onclick="showReportModel('营业员销售汇总', '/views/report/data/staffInfo.jsp')">
                        <img src="${ctx}/statics/images/report-icon-0.png" />
                        <p>营业员销售汇总</p>
                    </li>
                    <li class="report_cell" 
                        onclick="showReportModel('销售速报', '/views/report/data/areaList.jsp')">
                        <img src="${ctx}/statics/images/report-icon-1.png" />
                        <p>销售汇总</p>
                    </li>
                    <li class="report_cell" 
                        onclick="showReportModel('店长速报', '/views/report/data/managerList.jsp')">
                        <img src="${ctx}/statics/images/report-icon-3.png" />
                        <p>店长速报</p>
                    </li>
                    <li class="report_cell" 
                        onclick="showReportModel('门店排行', '/views/report/data/marketInfo.jsp')">
                        <img src="${ctx}/statics/images/report-icon-4.png" />
                        <p>门店排行</p>
                    </li>
                </ul>
			</div>
			<div class="control hide">
				<fieldset class="preview" style="display: none">
					<legend>预览</legend>
					<table cellpadding="0" cellspacing="3" border="0">
						<tr>
							<td class="tt">码流类型</td>
							<td><select id="streamtype" class="sel">
									<option value="1">主码流</option>
									<option value="2">子码流</option>
									<option value="3">第三码流</option>
									<option value="4">转码码流</option>
							</select></td>
							<td><input type="button" class="btn" value="开始预览"
								onclick="clickStartRealPlay();" /> <input type="button"
								class="btn" value="停止预览" onclick="clickStopRealPlay();" /></td>
						</tr>
						<tr>
							<td class="tt">音量</td>
							<td><input type="text" id="volume" class="txt" value="50"
								maxlength="3" />&nbsp;<input type="button" class="btn"
								value="设置" onclick="clickSetVolume();" />（范围：0~100）</td>
							<td><input type="button" class="btn" value="打开声音"
								onclick="clickOpenSound();" /> <input type="button" class="btn"
								value="关闭声音" onclick="clickCloseSound();" /></td>
						</tr>
						<tr>
							<td class="tt">对讲通道</td>
							<td><select id="audiochannels" class="sel">

							</select> <input type="button" class="btn" value="获取通道"
								onclick="clickGetAudioInfo();" /></td>
							<td><input type="button" class="btn" value="开始对讲"
								onclick="clickStartVoiceTalk();" /> <input type="button"
								class="btn" value="停止对讲" onclick="clickStopVoiceTalk();" /></td>
						</tr>
						<tr>
							<td colspan="3"><input type="button" class="btn" value="抓图"
								onclick="clickCapturePic();" /> <input type="button"
								class="btn" value="开始录像" onclick="clickStartRecord('realplay');" />
								<input type="button" class="btn" value="停止录像"
								onclick="clickStopRecord('realplay');" /></td>
						</tr>
						<tr>
							<td colspan="3"><input type="button" class="btn2"
								value="启用电子放大" onclick="clickEnableEZoom();" /> <input
								type="button" class="btn2" value="禁用电子放大"
								onclick="clickDisableEZoom();" /> <input type="button"
								class="btn2" value="启用3D放大" onclick="clickEnable3DZoom();" /> <input
								type="button" class="btn2" value="禁用3D放大"
								onclick="clickDisable3DZoom();" /> <input type="button"
								class="btn" value="全屏" onclick="clickFullScreen();" /></td>
						</tr>
						<tr>
							<td colspan="3">分辨率：<input id="resolutionWidth" type="text"
								class="txt" /> x <input id="resolutionHeight" type="text"
								class="txt" /> <input type="button" class="btn" value="设备抓图"
								onclick="clickDeviceCapturePic();" />
							</td>
						</tr>
					</table>
				</fieldset>
				<fieldset class="draw" style="display: none">
					<legend>绘图</legend>
					<table cellpadding="0" cellspacing="3" border="0">
						<tr>
							<td><input type="button" class="btn" value="启用绘制"
								onclick="clickEnableDraw();" /> <input type="button"
								class="btn" value="禁用绘制" onclick="clickDisableDraw();" /></td>
						</tr>
						<tr>
							<td>图形ID：<input id="snapId" type="text" class="txt" /> 名称：<input
								id="snapName" type="text" class="txt" />
							</td>
						</tr>
						<tr>
							<td><input type="button" class="btn" value="添加图形"
								onclick="clickAddSnapPolygon()" /> <input type="button"
								class="btn" value="删除图形" onclick="clickDelSnapPolygon()" /> <input
								type="button" value="编辑图形"
								onclick="clickEditSnapPolygon()" /> <input type="button"
								class="btn" value="停止编辑" onclick="clickStopSnapPolygon()" /> <input
								type="button" value="获取图形"
								onclick="clickGetSnapPolygon()" /> <input type="button"
								class="btn" value="设置图形" onclick="clickSetSnapPolygon()" /></td>
						</tr>
						<tr>
							<td><input type="button" class="btn" value="清空图形"
								onclick="clickDelAllSnapPolygon()" /></td>
						</tr>
					</table>
				</fieldset>
				<fieldset class="ptz">
					<h3 class="title">云台控制</h3>
					<table cellpadding="0" cellspacing="3" border="0" class="left">
						<tr>
							<td>
								<input type="button" value="左上" class="btn btn-primary"
									onmousedown="mouseDownPTZControl(5);"
									onmouseup="mouseUpPTZControl();" />
								<input type="button" class="btn btn-primary"
									value="上" onmousedown="mouseDownPTZControl(1);"
									onmouseup="mouseUpPTZControl();" /> 
								<input type="button" value="右上" class="btn btn-primary"
									onmousedown="mouseDownPTZControl(7);"
									onmouseup="mouseUpPTZControl();" />
							</td>
						</tr>
						<tr>
							<td>
								<input type="button" value="左" class="btn btn-primary"
									onmousedown="mouseDownPTZControl(3);"
									onmouseup="mouseUpPTZControl();" />
								<input type="button" value="自动" class="btn btn-primary" onclick="mouseDownPTZControl(9);" />
								<input type="button" value="右" class="btn btn-primary"
									onmousedown="mouseDownPTZControl(4);"
									onmouseup="mouseUpPTZControl();" />
							</td>
						</tr>
						<tr>
							<td>
								<input type="button" value="左下" class="btn btn-primary"
									onmousedown="mouseDownPTZControl(6);"
									onmouseup="mouseUpPTZControl();" />
								<input type="button" class="btn btn-primary"
									value="下" onmousedown="mouseDownPTZControl(2);"
									onmouseup="mouseUpPTZControl();" />
								<input type="button" value="右下"  class="btn btn-primary"
								onmousedown="mouseDownPTZControl(8);" onmouseup="mouseUpPTZControl();" />
							</td>
						</tr>
					</table>
					<table cellpadding="0" cellspacing="3" border="0" class="left" style="margin: 0 40px;">
						<tr>
							<td class="tt">云台速度</td>
							<td>
								<select id="ptzspeed" class="form-control">
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4" selected>4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="7">7</option>
								</select>
							</td>
						</tr>
						<tr>
							<td class="tt">预置点号</td>
							<td><input id="preset" type="text" class="form-control" value="1" /></td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="button" class="btn btn-primary" value="设置" onclick="clickSetPreset();" />
								<input type="button" class="btn btn-primary" value="调用" onclick="clickGoPreset();" />
							</td>
						</tr>
					</table>
					<table cellpadding="0" cellspacing="3" border="0" class="left">
						<tr>
							<td>
								<input type="button" class="btn btn-primary" value="变倍+"
								onmousedown="PTZZoomIn()" onmouseup="PTZZoomStop()">
							</td>
							<td>
								<input type="button" class="btn btn-primary" value="变倍-"
								onmousedown="PTZZoomout()" onmouseup="PTZZoomStop()">
							</td>
						</tr>
						<tr>
							<td>
								<input type="button" class="btn btn-primary" value="变焦+"
									onmousedown="PTZFocusIn()" onmouseup="PTZFoucusStop()">
							</td>
							<td>
								<input type="button" class="btn btn-primary" value="变焦-"
									onmousedown="PTZFoucusOut()" onmouseup="PTZFoucusStop()">
								</td>
						</tr>
						<tr>
							<td>
								<input type="button" class="btn btn-primary" value="光圈+"
									onmousedown="PTZIrisIn()" onmouseup="PTZIrisStop()">
							</td>
							<td>
								<input type="button" class="btn btn-primary" value="光圈-"
									onmousedown="PTZIrisOut()" onmouseup="PTZIrisStop()">
							</td>
						</tr>
					</table>
				</fieldset>
				<fieldset>
					<h3 class="title">回放</h3>
					<table width="600px" cellpadding="0" cellspacing="3" border="0">
						<tr>
							<td class="tt">码流类型</td>
							<td>
								<select id="record_streamtype" class="form-control" style="width: auto;">
									<option value="1">主码流</option>
									<option value="2">子码流</option>
								</select>
							</td>
						</tr>
						<tr>
							<td class="tt">开始时间</td>
							<td>
								<input id="starttime" type="text" class="form-control" style="display:inline-block;width: 300px;"
									value="2013-12-10 00:00:00" />
								<span class="help">（时间格式：2013-11-11 12:34:56）</span>
							</td>
						</tr>
						<tr>
							<td class="tt">结束时间</td>
							<td>
								<input id="endtime" type="text" class="form-control" style="display:inline-block;width:300px;" value="2013-12-11 23:59:59" /> 
								<button class="btn btn-primary" onclick="clickRecordSearch(0)">搜索</button>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<div id="searchdiv" class="searchdiv">
									<table id="searchlist" class="searchlist" cellpadding="0"
										cellspacing="0" border="0"></table>
								</div>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<button class="btn btn-primary" onclick="clickStartPlayback()">开始回放</button>
								<button class="btn btn-primary" onclick="clickStopPlayback()">停止回放</button>
								<button class="btn btn-primary" onclick="clickReversePlayback()">倒放</button>
								<button class="btn btn-primary" onclick="clickFrame()">单帧</button>
								<input id="transstream" type="checkbox"/>&nbsp;<span class="help">启用转码码流</span>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<button class="btn btn-primary" onclick="clickPause()">暂停</button>
								<button class="btn btn-primary" onclick="clickResume()">恢复</button>
								<button class="btn btn-primary" onclick="clickPlayFast()">快放</button>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<button class="btn btn-primary" onclick="clickCapturePic()">抓图</button>
								<button class="btn btn-primary" onclick="clickStartRecord('playback')">开始剪辑</button>
								<button class="btn btn-primary" onclick="clickStopRecord('playback')">停止剪辑</button>
								<button class="btn btn-primary" onclick="clickGetOSDTime()">OSD时间</button>
								<input id="osdtime" type="text" class="form-control" style="display:inline-block;width:200px;" readonly />
							</td>
						</tr>
					</table>
				</fieldset>
				<fieldset class="maintain" style="display: none">
					<legend>系统维护</legend>
					<table width="100%" cellpadding="0" cellspacing="3" border="0">
						<tr>
							<td><input type="button" class="btn2" value="导出配置文件"
								onclick="clickExportDeviceConfig();" /> <input type="button"
								class="btn2" value="检查插件版本" onclick="clickCheckPluginVersion();" />
								<input type="button" class="btn2" value="远程配置库"
								onclick="clickRemoteConfig();" /> <input type="button"
								class="btn2" value="恢复默认参数" onclick="clickRestoreDefault();" />
							</td>
						</tr>
						<tr>
							<td><input id="configFile" type="text" class="txt" />&nbsp;<input
								type="button" value="浏览"
								onclick="clickOpenFileDlg('configFile', 1);" />&nbsp;<input
								type="button" value="导入配置文件"
								onclick="clickImportDeviceConfig();" /></td>
						</tr>
						<tr>
							<td><input id="upgradeFile" type="text" class="txt" />&nbsp;<input
								type="button" value="浏览"
								onclick="clickOpenFileDlg('upgradeFile', 1);" />&nbsp;<input
								type="button" value="升级"
								onclick="clickStartUpgrade();" /></td>
						</tr>
					</table>
				</fieldset>
				<fieldset class="ipparse" style="display: none">
					<legend>设备IP解析</legend>
					<table cellpadding="0" cellspacing="3" border="0">
						<tr>
							<td class="tt">模式</td>
							<td colspan="3"><select id="devicemode" class="sel"
								onchange="changeIPMode(this.value);">
									<option value="1">IPServer</option>
									<option value="2">HiDDNS</option>
							</select></td>
						</tr>
						<tr>
							<td class="tt">服务器地址</td>
							<td><input id="serveraddress" type="text" class="txt"
								value="" /></td>
							<td class="tt">端口号</td>
							<td><input id="serverport" type="text" class="txt"
								value="7071" /></td>
						</tr>
						<tr>
							<td class="tt">设备标识</td>
							<td><input id="deviceid" type="text" class="txt" value="" /></td>
							<td class="tt">&nbsp;</td>
							<td><input type="button" class="btn" value="获取设备IP"
								onclick="clickGetDeviceIP();" /></td>
						</tr>
					</table>
				</fieldset>
			</div>
			<div style="display: none">
				<fieldset class="operate">
					<legend>操作信息</legend>
					<div id="opinfo" class="opinfo"></div>
				</fieldset>
				<fieldset class="callback">
					<legend>事件回调信息</legend>
					<div id="cbinfo" class="cbinfo"></div>
				</fieldset>
			</div>
	</div>
</div>

<div class="reportModel hide">
    <p class="report-title" id="reportTitle"></p>
    <iframe width="100%" height="700" frameborder="0" id="reportIframe"></iframe>
    <i class="close" onclick="closeReport()">×<i>
</div>
</body>
<script type="text/javascript">
var ctx = '${ctx}'
if(Cookies.get("isLogin") !== 'true') {
	window.location.href= ctx + "/views/map/mapStoreList.jsp"
}
</script>
<script src="${ctx}/statics/js/video/codebase/webVideoCtrl.js"></script>
<script src="${ctx}/statics/js/video/cn/shengda.js"></script>

<script>


function getDay(day){  
       var today = new Date();  
         
       var targetday_milliseconds=today.getTime() + 1000*60*60*24*day;          
  
       today.setTime(targetday_milliseconds); //注意，这行是关键代码
         
       var tYear = today.getFullYear();  
       var tMonth = today.getMonth();  
       var tDate = today.getDate();  
       tMonth = doHandleMonth(tMonth + 1);  
       tDate = doHandleMonth(tDate);  
       return tYear+"-"+tMonth+"-"+tDate;  
}  
function doHandleMonth(month){  
       var m = month;  
       if(month.toString().length == 1){  
          m = "0" + month;  
       }  
       return m;  
}

function addElementLi(obj,value) {
　　　　var ul = document.getElementsByClassName(obj)[0];
        //videoBox_history_list
        
　　　　//添加 li
　　　　var li = document.createElement("li");
 
　　　　//设置 li 属性，如 id
　　　　li.setAttribute("class", "text-center");
　　　　li.setAttribute("onclick", "clickRollBack('"+value+"')");

        
        var p1 = document.createElement("p");
        var p2 = document.createElement("p");

        p1.setAttribute("class", "videoBox_history_cell_play");     
        p2.setAttribute("class", "videoBox_history_cell_time");
        p2.innerHTML=value;
        
　　　　ul.appendChild(li);
        li.appendChild(p1);
        li.appendChild(p2);
}

function showReportModel(name,src){
	$('.reportModel').removeClass('hide')
	var path = ctx + src
	$('#reportTitle').text(name)
	$('#reportIframe').attr('src', path)
}
function closeReport() {
	$('.reportModel').addClass('hide')
}

var wHeight = $(window).height()
$("#myPlayer").attr("height", (wHeight - 440) + 'px')
$(".videoBox").css("height", (wHeight - 440) + 'px')
$("#reportIframe").attr("height", wHeight - 210)
$(".videoBox_history").css("height", (wHeight - 440) + 'px')

$(window).resize(function(e) {
	if(!(wHeight > 1050)){
		$("#myPlayer").attr("height", ($(window).height() - 440) + 'px')
		$(".videoBox").css("height", ($(window).height() - 440) + 'px')
		$("#reportIframe").attr("height", $(window).height() - 210)
	} else {
		$("#reportIframe").attr("height", $(window).height() - 180)
	}
	
})




$(document).ready(function(){
	var ctx = "${ctx}";
	var host = ctx;
	var getToken = host+"/video/getToken.action";
	var getAddess = host+"/video/getVedioAddress.action";
	var hlsAddes = "";
	var rtmpAddes = "";
	var wsAddes = "";
	 $.ajax(getToken, {
		    success: function(json) {
		        var accessToken = json.data;
		        $.ajax({
		            url:getAddess,
		            data:{accessToken:accessToken},
		            success: function(obj) {
		                var accessTokenStr = obj.data;
		                var accessToken = JSON.parse(accessTokenStr).data[0];
		                hlsAddes =accessToken.hls;
		                rtmpAddes = accessToken.rtmp;
		                console.log(rtmpAddes)
		                console.log(hlsAddes)
		                $("#myVideo").find(".rtmpClass").attr("src",rtmpAddes);
		                $("#myVideo").find(".hlsClass").attr("src",hlsAddes);
		                
		            }
		         });
		    }
		 });
clickLogin();
changeWndNum(1);
for(var i=-1;i>-8;i--){
    addElementLi('videoBox_history_list',getDay(i));
}
$("#divPlugin").attr('style', 'display:none');
})
/* new Vue({
	el:".videoDetails",
	data:function(){
		return{
			reportModelStatus: false,
			reportList:[
				{
					name: "营业员销售汇总",
					src: "/views/report/data/staffInfo.jsp",
					icon: ctx + "/statics/images/report-icon-0.png"
				},
				{
					name: "销售汇总",
					src: "/views/report/data/marketList.jsp",
					icon: ctx + "/statics/images/report-icon-1.png"
				},
				{
					name: "销售速报",
					src: "/views/report/data/areaList.jsp",
					icon: ctx + "/statics/images/report-icon-2.png"
				},
				{
					name: "店长速报",
					src: "/views/report/data/managerList.jsp",
					icon: ctx + "/statics/images/report-icon-3.png"
				},
				{
					name: "门店排行",
					src: "/views/report/data/marketInfo.jsp",
					icon: ctx + "/statics/images/report-icon-4.png"
				}
			],
			reportModelName:"",
			iframeSrc:""
		}
	},
	mounted:function(){
		
	},
	methods:{
		//显示报表模态框
		showReportModel(name,src){
			this.reportModelStatus = true;
			this.reportModelName = name;
			
			this.iframeSrc =  ctx + src;
		}
	},
	<!-- 销售报表管理 -->
					<!--             <div class="report text-center">
                <h2>销售报表管理</h2>
                <ul class="list-inline report_list" v-cloak>
                    <li class="report_cell" v-for="(item,index) in reportList" :key="index" 
                        @mouseover="showReportModel(item.name,item.src)">
                        <i></i>
                        <p>{{item.name}}</p>
                    </li>
                </ul>
            </div>
            
            销售报表弹框
            <div class="reportModel" :style="{'display':reportModelStatus ? 'block' : 'none'}">
                <p class="text-center">{{reportModelName}}</p>
                <iframe width="100%" height="510px" frameborder="0" :src="iframeSrc"></iframe>
                <i class="close" @click="reportModelStatus = false">×<i>
            </div>  -->
}) */
var player = new EZUIPlayer('myPlayer');

</script>
</body>
</html>