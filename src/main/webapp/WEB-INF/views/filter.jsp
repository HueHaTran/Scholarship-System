<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link href="<c:url value="/resources/css/filter-form.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/site.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/nav-wrap.css" />"
	rel="stylesheet">
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/freelancer.css" rel="stylesheet">
<link href="resources/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<script src="<c:url value="/resources/js/jquery-1.9.1.min.js" />"></script>
<script src="<c:url value="/resources/js/filter.js" />"></script>

<%@ page import="uit.se06.scholarshipweb.bus.util.Constants"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=Constants.WEB_NAME%> - <%=Constants.MENU_FILTER%></title>
</head>
<body>

	<!-- Navigation -->
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">

			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header page-scroll">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#page-top"><%=Constants.WEB_NAME%></a>
				<div class="navbar-header page-scroll">
					<%@include file="search-box.jsp"%>
				</div>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li class="hidden"><a href="#page-top"></a></li>
					<li class="page-scroll"><a href="<c:url value="/" />"><%=Constants.MENU_HOME%></a></li>
					<li class="page-scroll active"><a
						href="<c:url value="/filter" />"><%=Constants.MENU_FILTER%></a></li>
				</ul>
			</div>
			<!-- progressbar -->
			<ul id="progressbar">
				<li id="progressbar1" class="active" onclick="clickFilter(1,3)"><%=Constants.TITLE_FILTER1%></li>
				<li id="progressbar2" onclick="clickFilter(2,3)"><%=Constants.TITLE_FILTER2%></li>
				<li id="progressbar3" onclick="clickFilter(3,3)"><%=Constants.TITLE_FILTER3%></li>
				<li id="progressbar4" onclick="clickSubmitFilter()"><%=Constants.TITLE_FILTER4%></li>
			</ul>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>

	<div>
		<!-- fieldsets -->
		<section class="success" id="filter-intro"
			style="padding-top: 200px; padding-bottom: 100px">
			<div class="container">
				<div class="row">
					<div class="col-lg-12 text-center">
						<h2><%=Constants.MENU_INTRO%></h2>
						<hr class="star-light">
						<p><%=Constants.HELP_FILTER%></p>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-8 col-lg-offset-2 text-center page-scroll">
						<a href="#filter-section1" class="btn btn-lg btn-outline"> <i
							class="fa fa-flag"></i> <%=Constants.BUTTON_START%>
						</a>
					</div>
				</div>
			</div>
		</section>


		<section class="colorstyle1" id="filter-section1">
			<div class="row">
				<%@include file="filter1.jsp"%>
			</div>
		</section>

		<section class="colorstyle1" id="filter-section2">
			<div class="row">
				<%@include file="filter2.jsp"%>
			</div>
		</section>

		<section class="colorstyle1" id="filter-section3"
			style="padding-bottom: 100px">
			<div class="row">
				<%@include file="filter3.jsp"%>
			</div>
		</section>
	</div>

	<!-- Footer -->
	<footer class="text-center">
		<%@include file="footer.jsp"%>
	</footer>
	
	<!-- jQuery -->
	<script src="resources/js/jquery.js"></script>

	<!-- Plugin JavaScript -->
	<script src="resources/js/jquery.easing.min.js"></script>
	<script src="resources/js/classie.js"></script>
	<script src="resources/js/cbpAnimatedHeader.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="resources/js/freelancer.js"></script>

</body>
</html>