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

<title>Dormitory List</title>
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
		<h2 class="sub-header">宿舍管理  &nbsp;<button type="button" class="btn btn-primary" onclick="location='doaddDormitory.action'">增加宿舍</button></h2>
		<div class="table-responsive">
			<table class="table table-striped   table-hover ">
				<thead>
					<tr class="info">
						<td>编号</td>
						<td>楼宇</td>
						<td>宿舍号</td>
						<td>宿舍类型</td>
						<td>宿舍人数</td>
						<td>联系方式</td>
						<td align="center">操作</td>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="e" items="${list }">
					<tr>
						<td>${e.id }</td>
						<td>${e.b_id }</td>
						<td>${e.d_id }</td>
						<td>${e.dtype }</td>
						<td>${e.scount }</td>
						<td>${e.tel }</td>
						<td align="center">
							<a onclick="return check_return()" href="deleteDormitory.action?info.id=${e.id }">删除</a>&nbsp;&nbsp;
							<a href="doupdateDormitory.action?info.id=${e.id }">修改</a>
						</td>
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