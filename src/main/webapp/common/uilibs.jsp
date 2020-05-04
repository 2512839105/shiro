<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglibs.jsp" %>
<c:set var="version" value="<%=System.currentTimeMillis()%>"/>
<!-- 标题图标 -->
<link rel="icon" href="${ctx}/statics/images/title-icon.ico" type="image/x-icon"/>
<!--bootstrap基础样式-->
<link rel="stylesheet" type="text/css" href="${ctx}/statics/css/bootstrap.min.css">
<!--拖拽样式-->
<link rel="stylesheet" type="text/css" href="${ctx}/statics/css/dragtable.css"/>
<!--表格样式-->
<link rel="stylesheet" href="${ctx}/statics/css/bootstrap-table.min.css">
<!--自定义滚动条样式-->
<link rel="stylesheet" type="text/css" href="${ctx}/statics/css/jquery.mCustomScrollbar.min.css"/>
<!--模态框样式-->
<link rel="stylesheet" type="text/css" href="${ctx}/statics/css/iziModal.min.css"/>
<!--弹出框样式-->
<link rel="stylesheet" type="text/css" href="${ctx}/statics/css/sweetalert.css"/>
<!--slect标签样式-->
<link rel="stylesheet" href="${ctx}/statics/css/bootstrap-select.min.css"/>
<!--jqgrid自定义样式-->
<link rel="stylesheet" href="${ctx}/statics/plugins/jqgrid/ui.jqgrid-bootstrap.css">
<link rel="stylesheet" href="${ctx}/statics/plugins/treegrid/jquery.treegrid.css">
<link rel="stylesheet" href="${ctx}/statics/plugins/ztree/css/metroStyle/metroStyle.css">
<%--<link rel="stylesheet" href="${ctx}/statics/plugins/ztree/css/zTreeStyle/zTreeStyle.css">--%>
<!--自定义样式-->
<link rel="stylesheet" href="${ctx}/statics/css/common.css?v=${version}">
<link rel="stylesheet" href="${ctx}/statics/css/common.min.css?v=${version}">
<link rel="stylesheet" href="${ctx}/statics/css/style.css?v=${version}">
<!--图标样式-->
<link rel="stylesheet" href="${ctx}/statics/css/font-awesome.min.css?v=${version}">
<link rel="stylesheet" href="${ctx}/statics/css/iconfont.css?v=${version}">
<!--打印样式-->
<link rel="stylesheet" href="${ctx}/statics/css/print.css?v=${version}" media="print">
<!-- 数据报表样式 -->
<link rel="stylesheet" type="text/css" href="${ctx }/statics/css/dataReport.css"/>

<!--JQ库-->
<script type="text/javascript" src="${ctx}/statics/js/jquery/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="${ctx}/statics/js/jquery/jquery-ui.min.js"></script>
<script type="text/javascript" src="${ctx}/statics/js/jquery/jquery.form.js"></script>
<!--bootstrap插件-->
<script type="text/javascript" src="${ctx}/statics/js/bootstrap/bootstrap.min.js"></script>
<!--表格插件-->
<script type="text/javascript" src="${ctx}/statics/js/bootstrap/bootstrap-table.min.js"></script>
<script type="text/javascript" src="${ctx}/statics/js/bootstrap/bootstrap-table-mobile.js"></script>
<script type="text/javascript" src="${ctx}/statics/js/bootstrap/bootstrap-table-zh-CN.js"></script>
<!--表格列拖拽插件-->
<script type="text/javascript" src="${ctx}/statics/js/jquery/jquery.dragtable.js"></script>
<script type="text/javascript" src="${ctx}/statics/js/jquery/jquery.dragsort.js"></script>
<script type="text/javascript" src="${ctx}/statics/js/bootstrap/bootstrap-table-reorder-columns.min.js"></script>
<!--模态框插件-->
<script type="text/javascript" src="${ctx}/statics/plugins/izmodal/iziModal.min.js"></script>
<!--滚动条插件-->
<script type="text/javascript" src="${ctx}/statics/js/jquery/jquery.mousewheel.min.js"></script>
<script type="text/javascript" src="${ctx}/statics/js/jquery/jquery.mCustomScrollbar.min.js"></script>
<!--日期插件-->
<script type="text/javascript" src="${ctx}/statics/plugins/laydate/laydate.js"></script>
<!--select美化 插件-->
<script type="text/javascript" src="${ctx}/statics/js/bootstrap/bootstrap-select.min.js"></script>
<!--弹出框插件-->
<script type="text/javascript" src="${ctx}/statics/js/sweetalert.min.js"></script>
<!--导出 插件-->
<script type="text/javascript" src="${ctx}/statics/js/bootstrap/bootstrap-table-export.js"></script>
<!--导出 插件 兼容IE-->
<script type="text/javascript" src="${ctx}/statics/js/xlsx.core.min.js"></script>
<script type="text/javascript" src="${ctx}/statics/js/blob.js"></script>
<script type="text/javascript" src="${ctx}/statics/js/FileSaver.min.js"></script>
<script type="text/javascript" src="${ctx}/statics/js/tableExport.js"></script>
<!--layer 插件-->
<script type="text/javascript" src="${ctx}/statics/plugins/layer/layer.js?v=${version}"></script>
<!--vue 插件-->
<script type="text/javascript" src="${ctx}/statics/plugins/vue/vue.min.js?v=${version}"></script>
<!--ztree 插件-->
<script type="text/javascript" src="${ctx}/statics/plugins/ztree/jquery.ztree.all.min.js?v=${version}"></script>
<!--treegrid 插件-->
<script type="text/javascript" src="${ctx}/statics/plugins/treegrid/jquery.treegrid.min.js"></script>
<script type="text/javascript" src="${ctx}/statics/plugins/treegrid/jquery.treegrid.bootstrap3.js"></script>
<script type="text/javascript" src="${ctx}/statics/plugins/treegrid/jquery.treegrid.extension.js"></script>
<script type="text/javascript" src="${ctx}/statics/plugins/treegrid/tree.table.js"></script>
<!--jqgrid 插件-->
<script type="text/javascript" src="${ctx}/statics/plugins/jqgrid/grid.locale-cn.js"></script>
<script type="text/javascript" src="${ctx}/statics/plugins/jqgrid/jquery.jqGrid.min.js"></script>
<!--validator 插件-->
<script type="text/javascript" src="${ctx}/statics/plugins/validator/validator.js"></script>
<!--自定义-->
<script type="text/javascript" src="${ctx}/statics/js/form.js"></script>
<script type="text/javascript" src="${ctx}/statics/js/public.js?v=${version}"></script>
<script type="text/javascript" src="${ctx}/statics/js/common.js?v=${version}"></script>
<script type="text/javascript" src="${ctx}/statics/js/dialogUtil.js?v=${version}"></script>
<script type="text/javascript" src="${ctx}/statics/js/importUtil.js?v=${version}"></script>
<script type="text/javascript" src="${ctx}/statics/js/selectoption.js"></script>
<!-- 图标插件 -->
<script type="text/javascript" src="${ctx }/statics/js/echarts.js"></script>
