<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Main Sidebar Container -->

<aside class="main-sidebar sidebar-dark-primary elevation-4">
	<!-- Brand Logo -->
	<a href="index3.html" class="brand-link"> <img
		src="${pageContext.request.contextPath}/dist/img/AdminLTELogo.png"
		alt="AdminLTE Logo" class="brand-image img-circle elevation-3"
		style="opacity: .8"> <span class="brand-text font-weight-light">郑冲冲</span>
	</a>

	<!-- Sidebar -->
	<div class="sidebar">
		<!-- Sidebar user panel (optional) -->
		<div class="user-panel mt-3 pb-3 mb-3 d-flex">
			<div class="image">
				<img
					src="${pageContext.request.contextPath}/dist/img/AdminLTELogo.png"
					class="img-circle elevation-2" alt="User Image">
			</div>
			<div class="info">
				<a href="#" class="d-block">郑冲冲</a>
			</div>
		</div>

		<!-- SidebarSearch Form -->
		<div class="form-inline">
			<div class="input-group" data-widget="sidebar-search">
				<input class="form-control form-control-sidebar" type="search"
					placeholder="搜索" aria-label="Search">
				<div class="input-group-append">
					<button class="btn btn-sidebar">
						<i class="fas fa-search fa-fw"></i>
					</button>
				</div>
			</div>
		</div>

		<!-- Sidebar Menu -->
		<nav class="mt-2">
			<ul class="nav nav-pills nav-sidebar flex-column"
				data-widget="treeview" role="menu" data-accordion="false">
				<!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
				<li class="nav-item menu-open"><a id="11" href="#"
					class="nav-link"> <i
						class="nav-icon fas fa-tachometer-alt"></i>
						<p>
							客户信息管理 <i class="right fas fa-angle-left"></i>
						</p>
				</a>
					<ul class="nav nav-treeview">
						<li class="nav-item"><a id="1-1"
							href="${pageContext.request.contextPath}/UserServlet?method=findAllUserByNameOrEmail&name=&email=&firstpage=0"
							class="nav-link"> <i class="far fa-circle nav-icon"></i>
								<p>账号管理</p>
						</a></li>
						

					</ul></li>


				<!-- ============================ -->
				<li class="nav-item menu-open">
				<a id="22" href="#" class="nav-link"> 
						<i class="nav-icon fas fa-tachometer-alt"></i>
						<p>
							商品信息管理 <i class="right fas fa-angle-left"></i>
						</p>
				</a>
					<ul class="nav nav-treeview">
						<li class="nav-item">
						
							<a id="2-0" href="${pageContext.request.contextPath}/GoodsTypeServlet?method=findCountGoodtypeByTypename&typename=&firstpage=0"  
								class="nav-link"> <i class="far fa-circle nav-icon"></i>
									<p>商品类型管理</p>
							</a>
							
						</li>
						<li class="nav-item">
						
							<a id="2-1" href="${pageContext.request.contextPath}/GoodsServlet?method=findAllGoodsByNameOrType&goodname=&goodtypecode=&firstpage=0"  
								class="nav-link"> <i class="far fa-circle nav-icon"></i>
									<p>商品管理</p>
							</a>
							
						</li>
						<li class="nav-item">
						
							<a id="2-2" href="${pageContext.request.contextPath}/GoodsServlet?method=findAllGoodsByNameOrTypeExamine&goodname=&goodtypecode=&firstpage=0"  
							class="nav-link">
									<i class="far fa-circle nav-icon"></i>
									<p>商品审核管理</p>
							</a>
						
						</li>
						<li class="nav-item">
						
							<a id="2-3" href="${pageContext.request.contextPath}/StockServlet?method=findAllStock&goodname=&goodtypecode=&firstpage=0" class="nav-link">
									<i class="far fa-circle nav-icon"></i>
									<p>所有库存管理</p>
							</a>
						
						</li>
						<li class="nav-item">
						
							<a id="2-4" href="${pageContext.request.contextPath}/StockServlet?method=findAllStockByUser1&goodname=&goodtypecode=&firstpage=0" class="nav-link">
									<i class="far fa-circle nav-icon"></i>
									<p>商家库存管理</p>
							</a>
						
						</li>
						<li class="nav-item">
						
							<a id="2-5" href="${pageContext.request.contextPath}/OrdersServlet?method=findAllOrdersByOrdercode&ordercode=&firstpage=0" class="nav-link">
									<i class="far fa-circle nav-icon"></i>
									<p>订单管理</p>
							</a>
						
						</li>
						<li class="nav-item">
						
							<a id="2-6" href="${pageContext.request.contextPath}/OrdersServlet?method=findAllOrdersByOrdercodeAndUsercode&ordercode=&firstpage=0" class="nav-link">
									<i class="far fa-circle nav-icon"></i>
									<p>商家订单管理</p>
							</a>
						
						</li>
					</ul>
					</li>

			</ul>
		</nav>
		<!-- /.sidebar-menu -->
	</div>
	<!-- /.sidebar -->
</aside>
