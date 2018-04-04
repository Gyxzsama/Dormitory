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

<title>Student Add</title>
</head>

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
					<form method="post" action="addStudent.action">
					<br><br>
						<div class="form-group">
							<label>增加学生信息</label>
						</div>
						<div class="form-group">
							<label>姓名:</label><input type="text" class="form-control" name="info.sname" placeholder="姓名">
						</div>
						<div class="form-group">
							<label>性别:</label><input type="text" class="form-control" name="info.ssex" placeholder="性别：男，女">
						</div>
						<div class="form-group">
							<label>用户名:</label><input type="text" class="form-control" name="info.suname" placeholder="用户名">
						</div>
						<div class="form-group">
							<label>密码:</label><input type="text" class="form-control" name="info.spwd" placeholder="密码">
						</div>
						<div class="form-group">
							<label>联系方式:</label><input type="text" class="form-control" name="info.tel" placeholder="联系方式">
						</div>
						<button type="button" class="btn btn-info" name="button" onclick="this.form.submit()">提交</button>
						&nbsp;&nbsp;
						<button type="button" class="btn btn-info" name="button" onclick="javascript:history.back(-1);">返回</button>
					</form>
				</div>
			</div>
			</div>
		</div>
	</div>
</body>
</html>