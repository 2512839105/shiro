<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html >
<html lang="zh-CN">
	<head>
		<title>云平台登录</title>
		<link rel="stylesheet" type="text/css" href="${ctx}/views/mainReport/static/css/element-ui.min.css" />
		<link rel="stylesheet" type="text/css" href="${ctx}/statics/css/reset.css" />
		<script type="text/javascript" src="${ctx}/statics/plugins/vue/vue.min.js"></script>
		<script type="text/javascript" src="${ctx}/views/mainReport/static/js/element-ui.min.js"></script>
	</head>
	<body>
		<div id="loginForm">
			<el-dialog width="30%" :show-close="isShowClose" title="登录" :visible.sync="dialogFormVisible">
			  <el-form :model="form">
			    <el-form-item label="用户名：" :label-width="formLabelWidth">
			      <el-input placeholder="请输入用户名" v-model="form.username"></el-input>
			    </el-form-item>
			    <el-form-item label="密码：" :label-width="formLabelWidth">
			      <el-input placeholder="请输入密码" type="password" v-model="form.password" @keyup.enter.native="login"></el-input>
			    </el-form-item>
			  </el-form>
			  <div slot="footer" class="dialog-footer">
			    <el-button type="primary" @click="login">确 定</el-button>
			  </div>
			</el-dialog>
		</div>
	
	
	<script type="text/javascript">
		var vm = new Vue({
			el: "#loginForm",
			data: {
				isShowClose: false,
				dialogFormVisible: true,
				form: {
		          username: '',
		          password: ''
		        },
		        formLabelWidth: '120px'
			},
			methods: {
				login: function () {
					var username = this.form.username
					var password = this.form.password
					if(username == 'admin' && password == '123456') {
						
					}
				}
			}
		})
	</script>
	</body>
</html>