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

<title>Student in</title>
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
						<form method="post" action="stuInRecord.action">
							<br> <br>
							<div class="form-group">
								<label>学生入住:</label>
							</div>
							<div class="form-group">
								<div class="row">
									<div class="col-xs-5">
										<label>楼宇:</label>
										<s:select class="form-control" name="info.b_id" list="blist"
											listKey="id" listValue="id" headerKey="0" headerValue="请选择"
											value="info.b_id"
											onchange="location='dostuInRecord.action?info.b_id='+this.value;" />
										<label>宿舍号:</label>
										<s:select class="form-control" name="info.d_id" list="dlist"
											listKey="id" listValue="d_id" headerKey="0"
											headerValue="请选择" />
										<label>学号:</label> 
										<input type="text" class="form-control" name="info.s_id" placeholder="学号" value="">
									</div>
								</div>
							</div>
							<div class="form-group">
								<button type="button" class="btn btn-info" name="button"
									onclick="this.form.submit()">提交</button>
								<span style="color: #F00">${msg }</span>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>