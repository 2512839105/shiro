<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/uilibs.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<div>
		<form action="" id="videoEit">
			<ul class="form-list">					
						<input type="hidden" name="videoId" value="${model.videoId}">
					<li class="text-row">
			      		<div class="form-label">
			      			<label>排序</label>
			      		</div>
			      		<div class="form-input">
			      			<input class="form-control" type="text" id="appname" name="storeType"  placeholder="请输入类型" value="${model.storeType}" isvalid="yes" checkexpession="NotNull"  >
			      		</div>
			      	</li>	
					<li class="text-row">
			      		<div class="form-label">
			      			<label>排序</label>
			      		</div>
			      		<div class="form-input">
			      			<input class="form-control" type="text" id="appname" name="sort"  placeholder="请输入排序" value="${model.sort}" isvalid="yes" checkexpession="NotNull"  >
			      		</div>
			      	</li>
					
					<li class="text-row">
			      		<div class="form-label">
			      			<label>分类</label>
			      		</div>
			      		<div class="form-input">
			      			<input class="form-control" type="text" id="appname" name="category"  placeholder="请输入分类" value="${model.category}" isvalid="yes" checkexpession="NotNull"  >
			      		</div>
			      	</li>
			      	  <li class="text-row">
			      		<div class="form-label">
			      			<label>标题</label>
			      		</div>
			      		<div class="form-input">
			      			<input class="form-control" type="text" id="appname" name="title"  placeholder="请输入标题" value="${model.title}" isvalid="yes" checkexpession="NotNull"  >
			      		</div>
			      	</li>
			       
			      	<li class="text-row">
			      		<div class="form-label">
			      			<label>简介</label>
			      		</div>
			      		<div class="form-input">
			      			<input class="form-control" type="text" id="appname" name="introduc"  placeholder="请输入简介" value="${model.introduc}" isvalid="yes" checkexpession="NotNull"  >
			      		</div>
			      	</li>
			    <%--   	<li class="text-row">
			      		<div class="form-label">
			      			<label>备注</label>
			      		</div>
			      		<div class="form-input">
			      			<input class="form-control" type="text" name="remork" value="${model.remork}" placeholder="请输入备注"  isvalid="yes" checkexpession="Mobile" >
			      		</div>
			      	</li> --%>
			      	      </ul>
			<div class="bgroup text-right" style="margin-top: 78px;">
			<%--<button id="btnSave" type="submit" class="button bSuccess"><i class="iconfont icon-baocun"></i>保存</button>
            <button type="button" data-izimodal-close="" class="button bDanger"><i class="iconfont icon-quxiao"></i>关闭</button>--%>
			</div>
		</form>
		<%@include file="/common/validate.jsp" %>
</div>