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

<title>Student Out List</title>
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
			
			<h2 class="sub-header"> 迁出记录&nbsp; </h2>
			
				<div class="table-responsive">
					<table class="table table-striped   table-hover ">
						<thead>
							<tr class="info">
								<td>编号</td>
								<td>学生姓名</td>
								<td>所在楼宇</td>
								<td>寝室编号</td>
								<td>原因</td>
							</tr>
						</thead>
						<tbody>
								<c:forEach var="e" items="${list }">
								<tr>
									<td>${e.id }</td>
									<td>${e.s_id }</td>
									<td>${e.b_id }</td>
									<td>${e.d_id }</td>
									<td>${e.remarks }</td>
								</tr>
								</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>