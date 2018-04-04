<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/signin.css" rel="stylesheet">
<link href="Wopop_files/style_log.css" rel="stylesheet" type="text/css" />
<title>Login</title>
</head>

<body class="login">
	<div class="login_m">
	<br/><br/><p align="center" style="font-size:30px">宿舍管理系统登录</p><br/><br/>
		<div class="login_boder">
			<div class="login_padding" id="login_model">
			
				<form method="post" action="dologin.action">
				<div class="row">
					<h2>用户名</h2>
					<label> <input type="text" name="uname" 
						class="txt_input txt_input2"
						onfocus="if (value ==&#39;Your name&#39;){value =&#39;&#39;}"
						onblur="if (value ==&#39;&#39;){value=&#39;Your name&#39;}"
						value="Your name" />
					</label>
					<h2>密码</h2>
					<label> <input type="password" name="pwd" 
						class="txt_input"
						onfocus="if (value ==&#39;******&#39;){value =&#39;&#39;}"
						onblur="if (value ==&#39;&#39;){value=&#39;******&#39;}"
						value="******" />
					</label> 
					</div>
					<br>
					<br>
					<div class="row">
					<div class="col-md-6">
						<select class="form-control" name="select">
							<option value="1" selected>系统管理员</option>
							<option value="2">楼宇管理员</option>
							<option value="3" >学生用户</option>
						</select>
					</div>
					<div class="col-md-6" align="center">
						<button type="button" class="btn btn-primary btn-block" onclick="this.form.submit()" >登录 </button>
						<span style="color: #F00">${msg }</span>
					</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<br/>
	<br/>
	<p align="center">湖北工业大学-14gb计算1-01410251Y15-高杨兴子</p>
</body>
</html>