<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>RST Pwd</title>
</head>


<script type="text/javascript">
	function checkContent() {
		if(form.pwd0.value==""){
			alert("原密码不能为空");
			form.pwd0.focus();
			return false
		}
		if(form.pwd1.value==""){
			alert("请输入新密码");
			form.pwd1.focus();
			return false
		}
		if(form.pwd2.value==""){
			alert("请再次输入密码");
			form.pwd2.focus();
			return false
		}
		if(form.pwd1.value != form.pwd2.value ){
			alert("两次密码不一致");
			return false;
		}
		this.form.submit();
	};
</script>
<body>

	<%@ include file="Top.jsp"%>
	<div class="row">
		<!-- 1号row -->
		<div class="col-md-2 bg-info"  align="center"  >
			<%@ include file="Left.jsp"%>
		</div>
		<!-- 2号row -->
		<div class="table-responsive col-md-8">
			<form name="form" method="post" action="rstPwd.action" >
				<table class="table">
					<tr>
						<td>用户名</td>
						<td>${uname }</td>
					</tr>
					<tr>
						<td>原密码</td>
						<td><input type="text" class="form-control"  name="pwd0" value=""></td>
					</tr>
					<tr>
						<td>新密码</td>
						<td><input type="text" class="form-control"  name="pwd1" value=""></td>
					</tr>
					<tr>
						<td>再次输入</td>
						<td><input type="text" class="form-control"  name="pwd2" value=""></td>
					</tr>
				</table>
				<button type="button" class="btn btn-info" name="button" onclick="return checkContent()">提交</button> ${msg }
			</form>
		</div>
	</div>
</body>
</html>