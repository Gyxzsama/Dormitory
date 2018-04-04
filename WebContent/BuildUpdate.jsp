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

<title>Manager Update</title>
</head>
<script type="text/javascript">
	function checkContent() {
		if(document.getElementById('name').value==""){
			alert("名称不能为空");
			return false
		}
		if(document.getElementById('type').value==""){
			alert("类型不能为空");
			return false
		}else if(document.getElementById('type').value != "男" && document.getElementById('type').value != "女"){
			alert("请输入正确楼宇类型");
			return false
		}
		
		this.form.submit();
	};
</script>
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
						<form name="form" method="post" action="updateBuild.action">
							<br><br>
							<div class="form-group">
								<label>修改楼宇信息</label>
							</div>
							<div class="form-group">
								<label>编号:${info.id}</label><br>
								<input type="hidden" class="form-control" name="info.id"  value="${info.id}"> 
							</div>
							
							<div class="form-group">
								<label>名称:</label><input type="text" id="name" class="form-control" name="info.bname" placeholder="姓名" value="${info.bname }">
							</div>
							<div class="form-group">
								<label>类型:</label><input type="text" id="type" class="form-control" name="info.btype" placeholder="男，女" value="${info.btype }">
							</div>
							
							<button type="button" class="btn btn-info" name="button" onclick="return checkContent()">提交</button>
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