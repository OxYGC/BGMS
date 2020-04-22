<#macro commonStyle>
	<#-- favicon -->
	<link rel="icon" href="${request.contextPath}/static/favicon.ico" />
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap -->
    <link rel="stylesheet" href="${request.contextPath}/static/adminlte/bower_components/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="${request.contextPath}/static/adminlte/bower_components/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="${request.contextPath}/static/adminlte/bower_components/Ionicons/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="${request.contextPath}/static/adminlte/dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="${request.contextPath}/static/adminlte/dist/css/skins/_all-skins.min.css">
	<link rel="stylesheet" href="${request.contextPath}/static/adminlte/bower_components/PACE/themes/blue/pace-theme-flash.css">
<#--	<link rel="icon" href="${request.contextPath}/static/favicon.ico" />-->
</#macro>
<#macro commonScript>
	<!-- jQuery 2.1.4 -->
	<script src="${request.contextPath}/static/adminlte/bower_components/jquery/jquery.min.js"></script>
	<!-- Bootstrap 3.3.5 -->
	<script src="${request.contextPath}/static/adminlte/bower_components/bootstrap/js/bootstrap.min.js"></script>
	<!-- FastClick -->
	<script src="${request.contextPath}/static/adminlte/bower_components/fastclick/fastclick.js"></script>
	<!-- AdminLTE App -->
	<script src="${request.contextPath}/static/adminlte/dist/js/adminlte.min.js"></script>
	<!-- jquery.slimscroll -->
	<script src="${request.contextPath}/static/adminlte/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
    <!-- pace -->
    <script src="${request.contextPath}/static/adminlte/bower_components/PACE/pace.min.js"></script>
    <#-- jquery cookie -->
	<script src="${request.contextPath}/static/plugins/jquery/jquery.cookie.js"></script>
	<#-- jquery.validate -->
	<script src="${request.contextPath}/static/plugins/jquery/jquery.validate.min.js"></script>
	<#-- layer -->
	<script src="${request.contextPath}/static/plugins/layer/layer.js"></script>
	<#-- common -->
<#--    <script src="${request.contextPath}/static/js/common.1.js"></script>-->
	<script>
		var base_url = '${request.contextPath}';
	</script>
</#macro>

<#macro commonHeader>
	<header class="main-header">
		<a href="${request.contextPath}/" class="logo">
			<span class="logo-mini"><b>CMS</b></span>
			<span class="logo-lg"><b>后台服务管理</b></span>
		</a>
		<nav class="navbar navbar-static-top" role="navigation">

			<a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>

			<div class="navbar-custom-menu">
				<ul class="nav navbar-nav">
					<#-- login user -->
					<li class="dropdown">
						<a href="javascript:" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
<#--							欢迎 ${Request["LOGIN_IDENTITY"].username}-->
							欢迎 你
							<span class="caret"></span>
						</a>
						<ul class="dropdown-menu" role="menu">
							<li id="updatePwd" ><a href="javascript:">修改密码</a></li>
							<li id="logoutBtn" ><a href="javascript:">注销</a></li>
						</ul>
					</li>
				</ul>
			</div>

		</nav>
	</header>

</#macro>

<#macro commonLeft pageName >
	<!-- Left side column. contains the logo and sidebar -->
	<aside class="main-sidebar">
		<!-- sidebar: style can be found in sidebar.less -->
		<section class="sidebar">
			<!-- sidebar menu: : style can be found in sidebar.less -->
			<ul class="sidebar-menu">
                <li class="header">导航</li>
                <li class="nav-click <#if pageName == "index">active</#if>" ><a href="${request.contextPath}/"><i class="fa fa-circle-o text-aqua"></i><span>首页</span></a></li>
                <#--自定义页面-->
				<li class="nav-click <#if pageName == "page1">active</#if>" ><a href="${request.contextPath}/page1"><i class="fa fa-circle-o text-aqua"></i><span>页面1</span></a></li>
				<li class="nav-click <#if pageName == "page2">active</#if>" ><a href="${request.contextPath}/page2"><i class="fa fa-circle-o text-yellow"></i><span>页面2</span></a></li>
				<li class="nav-click <#if pageName == "page3">active</#if>" ><a href="${request.contextPath}/page3"><i class="fa fa-circle-o text-green"></i><span>页面3</span></a></li>
				<li class="nav-click <#if pageName == "help">active</#if>" ><a href="${request.contextPath}/help"><i class="fa fa-circle-o text-gray"></i><span>帮助文档</span></a></li>
			</ul>
		</section>
		<!-- /.sidebar -->
	</aside>
</#macro>

<#macro commonControl >
	<!-- Control Sidebar -->
	<aside class="control-sidebar control-sidebar-dark">
		<!-- Create the tabs -->
		<ul class="nav nav-tabs nav-justified control-sidebar-tabs">
			<li class="active"><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>
			<li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a></li>
		</ul>
		<!-- Tab panes -->

	</aside>

	<div class="control-sidebar-bg"></div>
</#macro>

<#macro commonFooter >
	<footer class="main-footer">
        Powered by <b>IOOIEE.COM</b> 1.0.1
		<div class="pull-right hidden-xs">
            <strong>Copyright &copy; 2015-2020 &nbsp;
                <a href="https://www.baidu.com/" target="_blank" >Cheney</a>
                <a href="https://www.baidu.com/" target="_blank" >管理系统</a>
            </strong><!-- All rights reserved. -->
		</div>
	</footer>
</#macro>