<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery-3.2.1.js"></script>

<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header" >
			<a class="navbar-brand" href="#" >校园宿舍管理系统</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">欢迎： ${uname }</a></li>
				<li><a href="RstPwd.jsp">修改密码</a></li>
				<li><a onclick="return check_quit()">退出系统</a></li>
			</ul>
		</div>
	</div>
</nav>