<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/dashboard.css" rel="stylesheet">

<script type="text/javascript">
	function check_return() {
		var con;
		con = confirm("是否删除?"); //在页面上弹出对话框
		if (con == true) {
			return true;
		} else
			return false;
	};
</script>
<div class="row">
	<div class="col-sm-3 col-md-2 sidebar" align="center">
		<ul class="nav nav-sidebar">
			<li><a href="index.action">后台首页</a></li>
		</ul>
		<%
			String flag = request.getSession().getAttribute("type").toString();
			if (flag.equals("1")) {
		%>
		<ul class="nav nav-sidebar">
			<li><a href="listManager.action">管理员管理</a></li>
			<li><a href="listStudent.action">学生管理</a></li>
			<li><a href="listBuild.action">楼宇管理</a></li>
			<li><a href="listDormitory.action">宿舍管理</a></li>

			<li><a href="dostuInRecord.action">学生入住登记</a></li>
			<li><a href="StuOut.jsp">学生迁出登记</a></li>
			<li><a href="listStuOut.action">迁出记录</a></li>
			<li><a href="StuExchange.jsp">学生寝室调换</a></li>
			<li><a href="StuAbsent.jsp">学生缺寝登记</a></li>
			<li><a href="StuAbsentList.jsp">学生缺寝记录</a></li>
		</ul>
		<%
			} else if (flag.equals("2")) {
		%>
		<ul class="nav nav-sidebar">
			<li><a href="listStudent.action">学生管理</a></li>

			<li><a href="#">学生缺寝登记</a></li>
			<li><a href="#">学生缺寝记录</a></li>
		</ul>
		<%
			} else if (flag.equals("3")) {
		%>
		<ul class="nav nav-sidebar">
			<li><a href="#">我的缺寝记录</a></li>
		</ul>
		<%
			}
		%>
		<script type="text/javascript">
			function check_quit() {
				var con;
				con = confirm("是否退出?"); //在页面上弹出对话框
				if (con == true) {
					location = 'quit.action';
					return true;
				} else
					return false;
			};
		</script>
		<ul class="nav nav-sidebar">
			<li><a href="RstPwd.jsp">修改密码</a></li>
			<li><a onclick="return check_quit()">退出系统</a></li>
		</ul>
	</div>
</div>

