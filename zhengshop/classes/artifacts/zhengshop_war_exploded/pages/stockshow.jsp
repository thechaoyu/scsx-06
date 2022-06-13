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
	function mydelete(goodname, goodtypecode, goodcode) {
		if (confirm("是否确认删除？")) {
			location.href = "${pageContext.request.contextPath}/GoodsServlet?method=deleteGoodBygoodcode&goodname="
					+ goodname + "&goodtypecode" + goodtypecode + "&goodcode=" + goodcode;
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
							<h1>库存表</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">家</a></li>
								<li class="breadcrumb-item active">库存表</li>
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

							<form
								action="${pageContext.request.contextPath}/StockServlet?method=findAllStock&firstpage=0"
								method="post">
								<div style="float: left;">
									<input style="width: 200px; margin-left: 5px;"
										value="${ goodname }" name="goodname" type="text"
										class="form-control" placeholder="商品名称">
								</div>
								<div style="float: left;">
									<select class="form-control" name="goodtypecode">
										<option value="">全部</option>
										<c:forEach items="${ goodtypearrayList }" var="gtl" varStatus="i">
											<c:if test="${ goodtypecode ==  gtl.goodtypecode }">
												<option selected value="${ gtl.goodtypecode }">${ gtl.typename }</option>
											</c:if>
											<c:if test="${ goodtypecode !=  gtl.goodtypecode }">
												<option value="${ gtl.goodtypecode }">${ gtl.typename }</option>
											</c:if>
											
										</c:forEach>
									</select>
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
										<th>商品编号</th>
										<th>商品名称</th>
										<th>商品价格</th>
										<th>商品打折后价格</th>
										<th>商品上传者</th>
										<th>商品数量</th>
										<th>图片</th>
										<th>日期</th>
										<th>商品类型</th>
										<th>添加库存</th>
										<th>减少库存</th>

									</tr>
								</thead>
								<tbody>

									<c:forEach items="${ goodlist }" var="gl" varStatus="i">
										<tr>
											<th><a
												href="${pageContext.request.contextPath}/GoodsServlet?method=findGoodDetailBygoodcode&goodcode=${ gl.goodcode }&goodname=${ gl.goodname }&goodtypecode=${ gl.goodType.goodtypecode }"
												class="btn btn-primary" />查看<br>详情<br>${ i.count }</a>
											</th>
											<th>${ gl.id }</th>
											<th>${ gl.goodcode }</th>
											<th>${ gl.goodname }</th>
											<th>${ gl.goodprice }</th>
											<th>${ gl.gooddiscount }</th>
											<th>${ gl.goodusercode }</th>
											<th>${ gl.stock.goodnumber }</th>
											

											<th><img height="30" width="30"
												src="${pageContext.request.contextPath}/image/upload/good/${gl.goodimagecode }" />

											</th>
											<th>${gl.gooddate }</th>
											<th>${gl.goodType.typename }</th>
											<th>
											<a class="active"
												href="${pageContext.request.contextPath}/StockServlet?method=addStock&stockcode=${ gl.stock.stockcode }&goodname=${ gl.goodname }&goodtypecode=${ gl.goodType.goodtypecode }&goodcode=${gl.goodcode}&firstpage=${firstpage}">增加<br>库存</a>
											</th>
											<th>
											<a class="active"
												href="${pageContext.request.contextPath}/StockServlet?method=deleteStock&stockcode=${ gl.stock.stockcode }&goodname=${ gl.goodname }&goodtypecode=${ gl.goodType.goodtypecode }&goodcode=${gl.goodcode}&firstpage=${firstpage}">减少<br>库存</a>
											</th>

										</tr>

									</c:forEach>


								</tbody>

							</table>
							<div class="card-tools" style="float: right; margin-top: 10px">
								<ul class="pagination pagination-sm">
									<c:if test="${ not empty goodlist }">
										<c:if test="${ 0 == firstpage }">
											<li class="page-item"><a href="#"
												style="background: black;" class="page-link">&laquo;</a></li>
										</c:if>
										<c:if test="${ 0!=firstpage }">
											<li class="page-item"><a
												href="${pageContext.request.contextPath}/StockServlet?method=findAllStock&goodname=${ goodname }&goodtypecode=${ goodtypecode }&firstpage=${firstpage-1}"
												class="page-link">&laquo;</a></li>
										</c:if>


										<c:forEach begin="1" end="${maxPageNum}" step="1" var="i">

											<c:if test="${ i ==  firstpage }">
												<li class="page-item"><a href="#"
													style="background: black;" class="page-link">${i}</a></li>
											</c:if>

											<c:if test="${ i!= firstpage }">
												<li class="page-item"><a
													href="${pageContext.request.contextPath}/StockServlet?method=findAllStock&goodname=${ goodname }&goodtypecode=${ goodtypecode }&firstpage=${ i }"
													class="page-link">${ i }</a></li>
											</c:if>


										</c:forEach>
										<c:if test="${ maxPageNum==firstpage }">
											<li class="page-item"><a href="#"
												style="background: black;" class="page-link">&raquo;</a></li>
										</c:if>
										<c:if test="${ maxPageNum!=firstpage }">
											<li class="page-item"><a
												href="${pageContext.request.contextPath}/StockServlet?method=findAllStock&goodname=${ goodname }&goodtypecode=${ goodtypecode }&firstpage=${firstpage+1}"
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
			$("#22").addClass("nav-link active");
			$("#2-3").addClass("nav-link active");

		})
	</script>
</body>
</html>
