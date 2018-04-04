<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<link href="css/bootstrap.min.css" rel="stylesheet">
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
<div class="container-fluid">
	<div class="col-md-1"></div>
	<div class="col-md-10">
	
	<br>
	<button type="button" class="btn btn-primary btn-block" onclick="location='index.action'" >后台首页</button>
	<br>
	
	<% 
	String flag =request.getSession().getAttribute("type").toString();
	if(flag.equals("1")) { %>
		<br>
		<button type="button" class="btn btn-primary btn-block" onclick="location='listManager.action'" >管理员管理</button>
		<br>
		<button type="button" class="btn btn-primary btn-block" onclick="location='#'" disabled="disabled">学生管理</button>
		<br>
		<button type="button" class="btn btn-primary btn-block" onclick="location='#'" disabled="disabled">楼宇管理</button>
		<br>
		<button type="button" class="btn btn-primary btn-block" onclick="location='#'" disabled="disabled">宿舍管理</button>
		<br>
		<button type="button" class="btn btn-primary btn-block" onclick="location='#'" disabled="disabled">学生入住登记</button>
		<br>
		<button type="button" class="btn btn-primary btn-block" onclick="location='#'" disabled="disabled">学生寝室调换</button>
		<br>
		<button type="button" class="btn btn-primary btn-block" onclick="location='#'" disabled="disabled">学生迁出登记</button>
		<br>
		<button type="button" class="btn btn-primary btn-block" onclick="location='#'" disabled="disabled">学生缺寝登记</button>
		<br>
		<button type="button" class="btn btn-primary btn-block" onclick="location='#'" disabled="disabled">学生缺寝记录</button>
		<br>
		<button type="button" class="btn btn-primary btn-block" onclick="location='#'" disabled="disabled">迁出记录</button>
	<% } else if(flag.equals("2")){ %>
		<br>
		<button type="button" class="btn btn-primary btn-block" onclick="location='#'" disabled="disabled">学生管理</button>
		<br>
		<button type="button" class="btn btn-primary btn-block" onclick="location='#'" disabled="disabled">学生缺寝登记</button>
		<br>
		<button type="button" class="btn btn-primary btn-block" onclick="location='#'" disabled="disabled">学生缺寝记录</button>
		<br>
	<%	}else if(flag.equals("3")) { %>
		<br>
		<button type="button" class="btn btn-primary btn-block" onclick="location='#'" disabled="disabled">我的缺寝记录</button>
		<br>
	<%  } %>
		<script type="text/javascript">
		function check_quit(){
			var con;
			con=confirm("是否退出?"); //在页面上弹出对话框
			if(con==true){
				location='quit.action';
				return true;
			}
			else
				return false;
		};
		</script>
		<br>
		<button type="button" class="btn btn-primary btn-block" onclick="location='RstPwd.jsp'" >修改密码</button>
		<br>
		<button type="button" class="btn btn-primary btn-block" onclick="return check_quit()" >退出系统</button>
		<br>
	</div>
</div>
</div>