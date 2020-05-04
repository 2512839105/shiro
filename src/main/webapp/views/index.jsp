<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/header.jsp" %>
<style type="text/css">
.iframe {height: calc(100% - 80px); overflow: hidden}
</style>
<body>
	<header>
		<nav class="navbar navbar-default">
	  <div class="container-fluid">
	    <!-- Brand and toggle get grouped for better mobile display -->
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand" href="#">店长小蜜</a>
	    </div>
	
	    <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	        <li><a href="javascript:changeIframe('${ctx}/views/report/data/areaInfo.jsp')">区域速报</a></li>
	        <li><a href="javascript:changeIframe('${ctx}/views/report/data/areaList.jsp')">销售速报</a></li>
	        <li><a href="javascript:changeIframe('${ctx}/views/report/data/managerList.jsp')">门店排行</a></li>
	        <li><a href="javascript:changeIframe('${ctx}/views/report/data/marketInfo.jsp')">店长速报</a></li>
	        <li><a href="javascript:changeIframe('${ctx}/views/report/data/marketList.jsp')">销售汇总</a></li>
	        <li><a href="javascript:changeIframe('${ctx}/views/report/data/staffInfo.jsp')">员工详情</a></li> 
	      </ul>
	    </div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
	</nav>
	</header>
	<main class='iframe'>
		<iframe id="iframe" width="100%" height="100%" frameborder="0" src="${ctx}/views/report/data/areaList.jsp"></iframe>
	</main>
</body>
<script type="text/javascript">
	function changeIframe(src) {
		iframe.src = src
	}
</script>
</html>