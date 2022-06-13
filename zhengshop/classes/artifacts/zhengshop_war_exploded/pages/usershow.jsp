<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>AdminLTE 3 | DataTables</title>

<!-- Google Font: Source Sans Pro -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/fontawesome-free/css/all.min.css">
<!-- DataTables -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/datatables-buttons/css/buttons.bootstrap4.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/dist/css/adminlte.min.css">
</head>
<script type="text/javascript">
	function mydelete(name, email, usercode) {
		if (confirm("是否确认删除？")) {

			location.href = "${pageContext.request.contextPath}/UserServlet?method=deleteUserBycode&name="
					+ name + "&email" + email + "&usercode=" + usercode;
		}
	}
</script>
<body class="hold-transition sidebar-mini">
	<div class="wrapper">


		<!-- 页面头部 -->
		<jsp:include page="header.jsp"></jsp:include>
		<!-- 页面头部 /-->

		<!-- 导航侧栏 -->
		<jsp:include page="aside.jsp"></jsp:include>
		<!-- 导航侧栏 /-->

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1>用户表</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
								<li class="breadcrumb-item active">DataTables</li>
							</ol>
						</div>
					</div>
				</div>
				<!-- /.container-fluid -->
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="container-fluid">

					<div class="card">
						<div class="card-header">
							<a
								href="${pageContext.request.contextPath}/UserServlet?method=addUser"
								class="btn btn-primary" />添加用户</a>

						</div>

						<div class="card-header">

							<form
								action="${pageContext.request.contextPath}/UserServlet?method=findAllUserByNameOrEmail&firstpage=0"
								method="post">
								<div style="float: left;">
									<input style="width: 200px; margin-left: 5px;"
										value="${ name }" name="name" type="text" class="form-control"
										placeholder="昵称">
								</div>
								<div style="float: left;">
									<input style="width: 200px; margin-left: 5px;"
										value="${ email }" name="email" type="text"
										class="form-control" placeholder="邮箱">
								</div>
								<div style="float: left;">
									<input type="submit" style="margin-left: 5px;" value="搜索"
										class="btn btn-primary" />
								</div>
								</from>
						</div>
						<!-- /.card-header -->
						<div class="card-body">
							<table id="example1" class="table table-bordered table-striped">
								<thead>
									<tr>
										<th>编号</th>
										<th>ID</th>
										<th>用户编号</th>
										<th>用户名</th>
										<th>密码</th>
										<th>昵称</th>
										<th>邮箱</th>
										<th>电话</th>
										<th>类型</th>
										<th>状态</th>
										<th>头像</th>
										<th>生日</th>
										<th>修改</th>
										<th>删除</th>
									</tr>
								</thead>
								<tbody>

									<c:forEach items="${ userlist }" var="ul" varStatus="i">


										<tr>
											<th>${ i.count }</th>
											<th>${ ul.id }</th>
											<th>${ ul.usercode }</th>
											<th>${ ul.username }</th>
											<th>${ ul.password }</th>
											<th>${ ul.name }</th>
											<th>${ ul.email }</th>
											<th>${ ul.phone }</th>
											<c:if test="${ ul.usertype == 0 }">
												<th>管理员</th>
											</c:if>
											<c:if test="${ ul.usertype == 1 }">
												<th>商家</th>
											</c:if>
											<c:if test="${ ul.usertype == 2 }">
												<th>普通用户</th>
											</c:if>
											<c:if test="${ ul.state == 0 }">
												<th>注销</th>
											</c:if>
											<c:if test="${ ul.state == 1 }">
												<th>正常</th>
											</c:if>
											<c:if test="${ ul.state == 2 }">
												<th>封号</th>
											</c:if>

											<th><img height="30" width="30"
												src="${pageContext.request.contextPath}/image/${ul.image }" />

											</th>
											<th>${ul.date }</th>
											<th><a class="active"
												href="${pageContext.request.contextPath}/UserServlet?method=userUpdate&name=${ ul.name }&email=${ ul.email }&usercode=${ul.usercode}">修改</a></th>
											<th><a class="active"
												href="javascript:mydelete('${ ul.name }','${ ul.email }','${ ul.usercode }')">删除</a></th>
										</tr>
									</c:forEach>


								</tbody>

							</table>
							<div class="card-tools" style="float: right; margin-top: 10px">
								<ul class="pagination pagination-sm">
									<c:if test="${ not empty userlist }">
										<c:if test="${ 0 == firstpage }">
											<li class="page-item"><a href="#"
												style="background: black;" class="page-link">&laquo;</a></li>
										</c:if>
										<c:if test="${ 0!=firstpage }">
											<li class="page-item"><a
												href="${pageContext.request.contextPath}/UserServlet?method=findAllUserByNameOrEmail&name=${ name }&email=${ email }&firstpage=${firstpage-1}"
												class="page-link">&laquo;</a></li>
										</c:if>


										<c:forEach begin="1" end="${maxPageNum}" step="1" var="i">

											<c:if test="${ i ==  firstpage }">
												<li class="page-item"><a href="#"
													style="background: black;" class="page-link">${i}</a></li>
											</c:if>

											<c:if test="${ i!= firstpage }">
												<li class="page-item"><a
													href="${pageContext.request.contextPath}/UserServlet?method=findAllUserByNameOrEmail&name=${ name }&email=${ email }&firstpage=${ i }"
													class="page-link">${ i }</a></li>
											</c:if>


										</c:forEach>
										<c:if test="${ maxPageNum==firstpage }">
											<li class="page-item"><a href="#"
												style="background: black;" class="page-link">&raquo;</a></li>
										</c:if>
										<c:if test="${ maxPageNum!=firstpage }">
											<li class="page-item"><a
												href="${pageContext.request.contextPath}/UserServlet?method=findAllUserByNameOrEmail&name=${ name }&email=${ email }&firstpage=${firstpage+1}"
												class="page-link">&raquo;</a></li>
										</c:if>
								</ul>
								</c:if>
							</div>
							<!-- /.col -->
						</div>

						<!-- /.row -->
					</div>
				</div>
				<!-- /.container-fluid -->
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
		<footer class="main-footer">
			<div class="float-right d-none d-sm-block">
				<b>Version</b> 3.1.0
			</div>
			<strong>Copyright &copy; 2014-2021 <a
				href="https://adminlte.io">AdminLTE.io</a>.
			</strong> All rights reserved.
		</footer>

		<!-- Control Sidebar -->
		<aside class="control-sidebar control-sidebar-dark">
			<!-- Control sidebar content goes here -->
		</aside>
		<!-- /.control-sidebar -->
	</div>
	<!-- ./wrapper -->

	<!-- jQuery -->
	<script
		src="${pageContext.request.contextPath}/plugins/jquery/jquery.min.js"></script>
	<!-- Bootstrap 4 -->
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- DataTables  & Plugins -->
	<script
		src="${pageContext.request.contextPath}/plugins/datatables/jquery.dataTables.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/datatables-buttons/js/dataTables.buttons.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/datatables-buttons/js/buttons.bootstrap4.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/jszip/jszip.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/pdfmake/pdfmake.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/pdfmake/vfs_fonts.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/datatables-buttons/js/buttons.html5.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/datatables-buttons/js/buttons.print.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/datatables-buttons/js/buttons.colVis.min.js"></script>
	<!-- AdminLTE App -->
	<script
		src="${pageContext.request.contextPath}/dist/js/adminlte.min.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="${pageContext.request.contextPath}/dist/js/demo.js"></script>
	<!-- Page specific script -->
	<script>
		$(function() {
			$("#11").addClass("nav-link active");
			$("#1-1").addClass("nav-link active");

		})
	</script>
</body>
</html>
