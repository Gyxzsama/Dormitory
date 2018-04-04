<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head><!-- 虎     -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Build Add</title>
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
						<form method="post" action="addBuild.action">
						<br><br>
							<div class="form-group">
								<label>增加宿舍楼</label>
							</div>
							<div class="form-group">
								<label>名称:</label><input type="text" class="form-control" name="info.bname" placeholder="姓名">
							</div>
							<div class="form-group">
								<label>类型:</label><input type="text" class="form-control" name="info.btype" placeholder="男，女">
							</div>
							
							<button type="button" class="btn btn-info" name="button" onclick="this.form.submit()">提交</button>
							&nbsp;
							<button type="button" class="btn btn-info" name="button" onclick="javascript:history.back(-1);">返回</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>