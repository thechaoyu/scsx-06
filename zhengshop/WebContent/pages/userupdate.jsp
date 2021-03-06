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
<!-- Google Font: Source Sans Pro -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/fontawesome-free/css/all.min.css">
<!-- daterange picker -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.css">
<!-- iCheck for checkboxes and radio inputs -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
<!-- Bootstrap Color Picker -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/bootstrap-colorpicker/css/bootstrap-colorpicker.min.css">
<!-- Tempusdominus Bootstrap 4 -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
<!-- Select2 -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/select2/css/select2.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/select2-bootstrap4-theme/select2-bootstrap4.min.css">
<!-- Bootstrap4 Duallistbox -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/bootstrap4-duallistbox/bootstrap-duallistbox.min.css">
<!-- BS Stepper -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/bs-stepper/css/bs-stepper.min.css">
<!-- dropzonejs -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/dropzone/min/dropzone.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/dist/css/adminlte.min.css">
</head>

<script type="text/javascript">
	function upimg() {

		//alert("---");
		document.getElementById("imagehead").src = "${pageContext.request.contextPath}/img/dui.png";

	}
</script>
<body class="hold-transition sidebar-mini">
	<div class="wrapper">


		<!-- ???????????? -->
		<jsp:include page="header.jsp"></jsp:include>
		<!-- ???????????? /-->

		<!-- ???????????? -->
		<jsp:include page="aside.jsp"></jsp:include>
		<!-- ???????????? /-->

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<a href="javascript:history.back(-1)" class="btn btn-primary">???????????????</a>
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
					<div class="card card-primary" align="center">
						<div class="card-header">
							<h3 class="card-title">??????????????????</h3>
						</div>
						<!-- /.card-header -->
						<!-- form start -->
						<form
							action="${pageContext.request.contextPath}/UserServlet?method=updateUserSubmit"
							method="post" enctype="multipart/form-data">
							<div class="card-body">
								<div class="col-sm-6">
									<label>????????????</label>
									<div class="form-group">
										<input type="hidden" name="id" value="${ user.id }" /> <input
											type="hidden" name="usercode" value="${ user.usercode }" />
										<input type="text" name="username" value="${ user.username }"
											class="form-control" placeholder="????????????">
									</div>
								</div>
								<div class="col-sm-6">
									<label>??????</label>
									<div class="form-group">
										<input type="text" name="name" class="form-control"
											value="${ user.name }" placeholder="??????">
									</div>
								</div>
								<div class="col-sm-6">
									<label>??????</label>
									<div class="form-group">
										<input type="text" name="password" class="form-control"
											value="${ user.password }" placeholder="??????">
									</div>
								</div>
								<div class="col-sm-6">
									<label>????????????</label>
									<div class="form-group">
										<input type="password" class="form-control"
											id="exampleInputPassword1" placeholder="????????????">
									</div>
								</div>
								<div class="col-sm-6">
									<div class="form-group">
										<label>??????</label> <input type="text" name="email"
											class="form-control" value="${ user.email }"
											id="exampleInputEmail1" placeholder="??????">
									</div>
								</div>

								<div class="col-sm-6">
									<div class="form-group">
										<label>??????</label> <input type="text" name="phone"
											class="form-control" value="${ user.phone }" placeholder="??????">
									</div>
								</div>
								<div class="col-sm-6">
									<!-- select -->
									<div class="form-group">
										<label>????????????</label> <select class="form-control"
											name="usertype">
											<c:if test="${ user.usertype == 0 }">
												<option selected value="0">?????????</option>
												<option value="1">??????</option>
												<option value="2">????????????</option>
											</c:if>
											<c:if test="${ user.usertype == 1 }">
												<option value="0">?????????</option>
												<option selected value="1">??????</option>
												<option value="2">????????????</option>
											</c:if>
											<c:if test="${ user.usertype == 2 }">
												<option value="0">?????????</option>
												<option value="1">??????</option>
												<option selected value="2">????????????</option>
											</c:if>
										</select>
									</div>
								</div>
								<div class="col-sm-6">
									<!-- select -->
									<div class="form-group">
										<label>????????????</label> <select class="form-control" name="state">

											<c:if test="${ user.state == 0 }">
												<option selected value="0">??????</option>
												<option value="1">??????</option>
												<option value="2">??????</option>
											</c:if>
											<c:if test="${ user.state == 1 }">
												<option value="0">??????</option>
												<option selected value="1">??????</option>
												<option value="2">??????</option>
											</c:if>
											<c:if test="${ user.state == 2 }">
												<option value="0">??????</option>
												<option value="1">??????</option>
												<option selected value="2">??????</option>
											</c:if>
										</select>
									</div>
								</div>
								<div class="col-sm-6">
									<div class="form-group">
										<label>??????????????? </label>
										<div class="input-group date" id="reservationdatetime"
											data-target-input="nearest">
											<input type="text" name="date"
												class="form-control datetimepicker-input"
												data-target="#reservationdatetime" value="${ user.date }" />
											<div class="input-group-append"
												data-target="#reservationdatetime"
												data-toggle="datetimepicker">
												<div class="input-group-text">
													<i class="fa fa-calendar"></i>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="col-sm-6">
									<label>????????? </label> <img height="200" width="200"
										id="imagehead"
										src="${pageContext.request.contextPath}/image/${user.image }">
									<div class="form-group">
										<div class="input-group">
											<div class="custom-file">
												<input type="file" onclick="upimg()" name="image" class="custom-file-input"
													id="exampleInputFile"> <label
													class="custom-file-label" for="exampleInputFile"
													>????????????</label>
											</div>

										</div>
									</div>
								</div>

							</div>
							<!-- /.card-body -->


							<div class="card-footer">
								<input type="submit" value="??????" class="btn btn-primary" />
							</div>
						</form>
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
	<!-- Select2 -->
	<script
		src="${pageContext.request.contextPath}/plugins/select2/js/select2.full.min.js"></script>
	<!-- Bootstrap4 Duallistbox -->
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap4-duallistbox/jquery.bootstrap-duallistbox.min.js"></script>
	<!-- InputMask -->
	<script
		src="${pageContext.request.contextPath}/plugins/moment/moment.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/inputmask/jquery.inputmask.min.js"></script>
	<!-- date-range-picker -->
	<script
		src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.js"></script>
	<!-- bootstrap color picker -->
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-colorpicker/js/bootstrap-colorpicker.min.js"></script>
	<!-- Tempusdominus Bootstrap 4 -->
	<script
		src="${pageContext.request.contextPath}/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
	<!-- Bootstrap Switch -->
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-switch/js/bootstrap-switch.min.js"></script>
	<!-- BS-Stepper -->
	<script
		src="${pageContext.request.contextPath}/plugins/bs-stepper/js/bs-stepper.min.js"></script>
	<!-- dropzonejs -->
	<script
		src="${pageContext.request.contextPath}/plugins/dropzone/min/dropzone.min.js"></script>
	<script>
		$(function() {
			//Initialize Select2 Elements
			$('.select2').select2()

			//Initialize Select2 Elements
			$('.select2bs4').select2({
				theme : 'bootstrap4'
			})

			//Datemask dd/mm/yyyy
			$('#datemask').inputmask('dd/mm/yyyy', {
				'placeholder' : 'dd/mm/yyyy'
			})
			//Datemask2 mm/dd/yyyy
			$('#datemask2').inputmask('mm/dd/yyyy', {
				'placeholder' : 'mm/dd/yyyy'
			})
			//Money Euro
			$('[data-mask]').inputmask()

			//Date picker
			$('#reservationdate').datetimepicker({
				format : 'L'
			});

			//Date and time picker
			$('#reservationdatetime').datetimepicker({
				icons : {
					time : 'far fa-clock'
				}
			});

			//Date range picker
			$('#reservation').daterangepicker()
			//Date range picker with time picker
			$('#reservationtime').daterangepicker({
				timePicker : true,
				timePickerIncrement : 30,
				locale : {
					format : 'MM/DD/YYYY hh:mm A'
				}
			})
			//Date range as a button
			$('#daterange-btn').daterangepicker(
					{
						ranges : {
							'Today' : [ moment(), moment() ],
							'Yesterday' : [ moment().subtract(1, 'days'),
									moment().subtract(1, 'days') ],
							'Last 7 Days' : [ moment().subtract(6, 'days'),
									moment() ],
							'Last 30 Days' : [ moment().subtract(29, 'days'),
									moment() ],
							'This Month' : [ moment().startOf('month'),
									moment().endOf('month') ],
							'Last Month' : [
									moment().subtract(1, 'month').startOf(
											'month'),
									moment().subtract(1, 'month')
											.endOf('month') ]
						},
						startDate : moment().subtract(29, 'days'),
						endDate : moment()
					},
					function(start, end) {
						$('#reportrange span').html(
								start.format('MMMM D, YYYY') + ' - '
										+ end.format('MMMM D, YYYY'))
					})

			//Timepicker
			$('#timepicker').datetimepicker({
				format : 'LT'
			})

			//Bootstrap Duallistbox
			$('.duallistbox').bootstrapDualListbox()

			//Colorpicker
			$('.my-colorpicker1').colorpicker()
			//color picker with addon
			$('.my-colorpicker2').colorpicker()

			$('.my-colorpicker2').on(
					'colorpickerChange',
					function(event) {
						$('.my-colorpicker2 .fa-square').css('color',
								event.color.toString());
					})

			$("input[data-bootstrap-switch]").each(function() {
				$(this).bootstrapSwitch('state', $(this).prop('checked'));
			})

		})
		// BS-Stepper Init
		document.addEventListener('DOMContentLoaded', function() {
			window.stepper = new Stepper(document.querySelector('.bs-stepper'))
		})

		// DropzoneJS Demo Code Start
		Dropzone.autoDiscover = false

		// Get the template HTML and remove it from the doumenthe template HTML and remove it from the doument
		var previewNode = document.querySelector("#template")
		previewNode.id = ""
		var previewTemplate = previewNode.parentNode.innerHTML
		previewNode.parentNode.removeChild(previewNode)

		var myDropzone = new Dropzone(document.body, { // Make the whole body a dropzone
			url : "/target-url", // Set the url
			thumbnailWidth : 80,
			thumbnailHeight : 80,
			parallelUploads : 20,
			previewTemplate : previewTemplate,
			autoQueue : false, // Make sure the files aren't queued until manually added
			previewsContainer : "#previews", // Define the container to display the previews
			clickable : ".fileinput-button" // Define the element that should be used as click trigger to select files.
		})

		myDropzone.on("addedfile", function(file) {
			// Hookup the start button
			file.previewElement.querySelector(".start").onclick = function() {
				myDropzone.enqueueFile(file)
			}
		})

		// Update the total progress bar
		myDropzone
				.on(
						"totaluploadprogress",
						function(progress) {
							document
									.querySelector("#total-progress .progress-bar").style.width = progress
									+ "%"
						})

		myDropzone.on("sending", function(file) {
			// Show the total progress bar when upload starts
			document.querySelector("#total-progress").style.opacity = "1"
			// And disable the start button
			file.previewElement.querySelector(".start").setAttribute(
					"disabled", "disabled")
		})

		// Hide the total progress bar when nothing's uploading anymore
		myDropzone.on("queuecomplete", function(progress) {
			document.querySelector("#total-progress").style.opacity = "0"
		})

		// Setup the buttons for all transfers
		// The "add files" button doesn't need to be setup because the config
		// `clickable` has already been specified.
		document.querySelector("#actions .start").onclick = function() {
			myDropzone.enqueueFiles(myDropzone
					.getFilesWithStatus(Dropzone.ADDED))
		}
		document.querySelector("#actions .cancel").onclick = function() {
			myDropzone.removeAllFiles(true)
		}
		// DropzoneJS Demo Code End
	</script>
</body>
</html>
