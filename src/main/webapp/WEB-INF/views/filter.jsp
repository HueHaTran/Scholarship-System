<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link href="<c:url value="/resources/css/site.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/filter-form.css" />"
	rel="stylesheet">
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/freelancer.css" rel="stylesheet">
<link href="resources/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<style type="text/css">
.row-filter {
	padding-bottom: 80px;
}
</style>

<script src="<c:url value="/resources/js/jquery-1.9.1.min.js" />"></script>
<script src="<c:url value="/resources/js/filter.js" />"></script>

<%@ page import="uit.se06.scholarshipweb.bus.util.Constants"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=Constants.WEB_NAME%> - <%=Constants.MENU_FILTER%></title>
</head>
<body>
	<div id="viewport">
		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-fixed-top">
			<div class="container">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<a class="navbar-brand" href="<c:url value="/" />"><%=Constants.WEB_NAME%></a>
					<%@include file="search-box.jsp"%>
				</div>

				<div class="navbar-header">
					<!-- progressbar -->
					<ul id="progressbar">
						<li id="progressbar1" class="active" onclick="clickFilter(1,3)"><%=Constants.TITLE_FILTER1%></li>
						<li id="progressbar2" onclick="clickFilter(2,3)"><%=Constants.TITLE_FILTER2%></li>
						<li id="progressbar3" onclick="clickFilter(3,3)"><%=Constants.TITLE_FILTER3%></li>
						<li id="progressbar4" onclick="clickSubmitFilter()"><%=Constants.TITLE_FILTER4%></li>
					</ul>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">

					<ul class="nav navbar-nav navbar-right">
						<li class="page-scroll"><a href="<c:url value="/" />"><%=Constants.MENU_HOME%></a></li>
						<li class="page-scroll active"><a
							href="<c:url value="/filter" />"><%=Constants.MENU_FILTER%></a></li>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>

		<div>
			<!-- fieldsets -->
			<div class="content-section" id="filter-intro"
				style="padding-bottom: 0">
				<div class="container">
					<div class="row">
						<div class="col-lg-12 text-center">
							<h2><%=Constants.MENU_INTRO%></h2>
							<hr class="star-light">
							<p><%=Constants.HELP_FILTER%></p>
						</div>
					</div>
					<br>
				</div>

				<div class="row row-filter" id="filter-section1">
					<%@include file="filter1.jsp"%>
				</div>

				<div class="row row-filter" id="filter-section2">
					<%@include file="filter2.jsp"%>
				</div>

				<div class="row row-filter" id="filter-section3">
					<%@include file="filter3.jsp"%>
				</div>
			</div>
		</div>

		<!-- Footer -->
		<%@include file="footer.jsp"%>

		<!-- Custom Theme JavaScript -->
		<script src="resources/js/freelancer.js"></script>

	</div>
</body>
</html>