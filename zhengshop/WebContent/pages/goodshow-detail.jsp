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
							<a href="javascript:history.back(-1)" class="btn btn-primary">返回上一级</a>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">家</a></li>
								<li class="breadcrumb-item active">商品表</li>
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
						<div class="card-header">商品详情</div>
						<!-- /.card-header -->
						<div class="card-body">
							<table id="example1" class="table table-bordered table-striped">
								<thead>
									<tr>
										<th>ID</th>
										<th>商品编号</th>
										<th>商品名称</th>
										<th>商品明细</th>
										<th>商品价格</th>
										<th>商品打折后价格</th>
										<th>商品上传者</th>
										<th>商品状态</th>
										<th>日期</th>
										<th>商品类型</th>

									</tr>
								</thead>
								<tbody>
									<tr>
										<th>${ goods.id }</th>
										<th>${ goods.goodcode }</th>
										<th>${ goods.goodname }</th>
										<th>${ goods.gooddetail }</th>
										<th>${ goods.goodprice }</th>
										<th>${ goods.gooddiscount }</th>
										<th>${ goods.goodusercode }</th>
										<th>${ goods.goodstate }</th>
										<th>${ goods.gooddate }</th>
										<th>${ goods.goodtypecode }</th>
									</tr>

								</tbody>
								<thead>
									<tr>
										<th>图片</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										
										<th>
										<img height="200" width="200"
											src="${pageContext.request.contextPath}/image/upload/good/${images.image1 }" />
										</th>
										<th>
										<img height="200" width="200"
											src="${pageContext.request.contextPath}/image/upload/good/${images.image2 }" />
										</th>
										<th><img height="200" width="200"
											src="${pageContext.request.contextPath}/image/upload/good/${images.image3 }" />
										</th>
										<th><img height="200" width="200"
											src="${pageContext.request.contextPath}/image/upload/good/${images.image4 }" />
										</th>
										<th>
										 <img height="200" width="200"
											src="${pageContext.request.contextPath}/image/upload/good/${images.image5 }" />
										</th>
									</tr>

								</tbody>
							</table>

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
			$("#22").addClass("nav-link active");
			$("#2-1").addClass("nav-link active");

		})
	</script>
</body>
</html>
