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

<title>Student Update</title>
</head>
<script type="text/javascript">
	function checkContent() {
		if(document.getElementById('name').value==""){
			alert("姓名不能为空");
			return false
		}
		if(document.getElementById('sex').value==""){
			confirm("性别不能为空");
			return false
		}
		if(document.getElementById('uname').value==""){
			confirm("用户名不能为空");
			return false
		}
		if(document.getElementById('pwd1').value!="" && document.getElementById('pwd2').value!=document.getElementById('pwd1').value ){
			alert("两次密码不一致");
			return false;
		}else if(document.getElementById('pwd1').value=="" && document.getElementById('pwd2').value!="" || 
				 document.getElementById('pwd1').value=="" && document.getElementById('pwd2').value!=""){
			alert("两次密码不一致");
			return false;
		}
		this.form.submit();
	};
</script>
<body>
<!-- 头部 -->
<%@ include file="Top.jsp"%>
<div class="container-fluid">
	<div class="row">
		<!-- 左部 -->
			<%@ include file="Left.jsp"%>
		<!-- 主体 -->
		
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

			<div class="row">
				<div class="col-md-1"></div>
				<div class="col-md-8">
					<form name="form" method="post" action="updateStudent.action">
					<br><br>
						<div class="form-group">
							<label>修改学生信息</label>
						</div>
						<div class="form-group">
						
						<label>编号:${info.id}</label><br>
							<input type="hidden" class="form-control" name="info.id"  value="${info.id}"> 
							
							<label>姓名:</label>
							<input type="text" class="form-control" id="name" name="info.sname" placeholder="姓名" value="${info.sname }">
						</div>
						<div class="form-group">
							<label>性别:</label>
							<input type="text" class="form-control" id="sex" name="info.ssex" placeholder="性别：男，女" value="${info.ssex }">
						</div>
						<div class="form-group">
							<label>用户名:</label>
							<input type="text" class="form-control" id="uname" name="info.suname" placeholder="用户名" value="${info.suname }">
						</div>
						<div class="form-group">
							<label>密码:<a style="color: #F00">(不修改则不填写)</a></label>
							<input type="password" id="pwd1" class="form-control" placeholder="密码" value="">
						</div>
						<div class="form-group">
							<label>重复密码:</label>
							<input type="password" id="pwd2" class="form-control" name="info.spwd" placeholder="密码" value="">
						</div>
						<div class="form-group">
							<label>联系方式:</label>
							<input type="text" id="tel" class="form-control" name="info.tel" placeholder="联系方式" value="${info.tel }">
						</div>
						
						<button type="button" class="btn btn-info" name="button" onclick="return checkContent()">提交</button>
						&nbsp;
						<button type="button" class="btn btn-info" name="button" onclick="javascript:history.back(-1);">返回</button>
					</form>
				</div>
			</div>
		</div>
		</div>
	</div>
</body>
</html>