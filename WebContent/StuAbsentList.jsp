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

<title>Student Absent List</title>
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
			
			<h2 class="sub-header"> 缺寝记录&nbsp; </h2>
			
				<div class="table-responsive">
					<table class="table table-striped   table-hover ">
						<thead>
							<tr class="info">
								<td>编号</td>
								<td>学生姓名</td>
								<td>所在楼宇</td>
								<td>寝室编号</td>
								<td>时间</td>
								<td>原因</td>
								<td align="center">操作</td>
							</tr>
						</thead>
						<tbody>
								<tr>
									<td>制作中</td>
									<td>test</td>
									<td>test</td>
									<td>test</td>
									<td>test</td>
									<td>test</td>
									<td align="center"><a onclick="return check_return()"
										href="#">删除</a>&nbsp;&nbsp; <a
										href="#">修改</a></td>
								</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>