<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Index</title>
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

				<div class="jumbotron">
					<h3>这是一个主页！！ 测试用</h3>
					<p>欢迎使用校园宿舍管理系统 Alpha</p>
					<p>登录类型 :${ type }</p>
					<p>Msg: ${ msg }</p>
					尚未完成的部分：<br>
					学生入住登记 <br>
					学生寝室调换 <br>
					学生迁出登记<br>
					学生缺寝登记<br>
					学生缺寝记录 <br>
					 迁出记录
				</div>
			</div>
		</div>
	</div>
</body>
</html>