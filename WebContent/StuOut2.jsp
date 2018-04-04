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

<title>Student out</title>
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
					<form method="post" action="StuOut.action">
					<br><br>
						<div class="form-group">
							<label>学生迁出</label>
						</div>
							<input type="hidden" name="sinfo.id"  value="${sinfo.id}"> 
							<input type="hidden" name="sinfo.sname"  value="${sinfo.sname }">
							<input type="hidden" name="sinfo.ssex"  value="${sinfo.ssex }">
							<input type="hidden" name="sinfo.tel" value="${sinfo.tel }">
							<input type="hidden" name="ininfo.b_id" value="${ininfo.b_id }">
							<input type="hidden" name="dinfo.d_id" value="${dinfo.d_id }">
							
							<input type="hidden" name="ininfo.id" value="${ininfo.id }">
							<div class="form-group">
							<label>学号:${sinfo.id}</label>
							</div>
							<div class="form-group">
							<label>姓名:${sinfo.sname }</label>
							</div>
							<div class="form-group">
							<label>性别:${sinfo.ssex }</label>
							</div>
							<div class="form-group">
							<label>联系方式:${sinfo.tel }</label>
							</div>
							<div class="form-group">
							<label>所在楼宇:${ininfo.b_id }</label>
							</div>
							<div class="form-group">
							<label>所在宿舍:${dinfo.d_id }</label>
							</div>
							
							<div class="form-group">
							<label>原因：</label>
							<input type="text" name="remarks"  class="form-control">
							</div>
						
						
						<button type="button" class="btn btn-info" name="button" onclick="this.form.submit()">提交</button>
						&nbsp;
						<button type="button" class="btn btn-info" name="button" onclick="location='StuOut.jsp'">返回</button>
						<span style="color: #F00">${msg }</span>
					</form>
				</div>
			</div>
			</div>
		</div>
	</div>
</body>
</html>