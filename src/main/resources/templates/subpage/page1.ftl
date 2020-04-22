<!DOCTYPE html>
<html>
<head>
  	<#import "../common/common.macro.ftl" as netCommon>
	<@netCommon.commonStyle />
	<!-- daterangepicker -->
<#--    <link rel="stylesheet" href="${request.contextPath}/static/adminlte/bower_components/bootstrap-daterangepicker/daterangepicker.css">-->
    <!-- daterangepicker -->
<#--	<script src="${request.contextPath}/static/adminlte/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>-->
	<script src="https://cdn.staticfile.org/jquery/3.1.1/jquery.min.js"></script>
<#--    <script src="${request.contextPath}/static/adminlte/bower_components/moment/moment.min.js"></script>-->
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.20/datatables.min.css"/>
	<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.20/datatables.min.js"></script>
    <title>策略组服务管理</title>
</head>
<body class="hold-transition skin-blue sidebar-mini ">
<div class="wrapper">
	<!-- header -->
	<@netCommon.commonHeader />
	<!-- left -->
	<@netCommon.commonLeft "page1" />
	
	<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper">
 		<section class="content-header">
			<h1>数据表格展示页面</h1>
		</section>

		<!-- Main content -->
		<section class="content">
			<div class="row" >
				<table  id="datatables" class="display compact" style="width:90%">
				</table>
			</div>
		</section>
		<!-- /.content -->
	</div>
	<!-- /.content-wrapper -->
	
	<!-- footer -->
	<@netCommon.commonFooter />
</div>
<@netCommon.commonScript />

<script src="${request.contextPath}/static/adminlte/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="${request.contextPath}/static/adminlte/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<script src="${request.contextPath}/static/js/page1.1.js"></script>
</body>
</html>
