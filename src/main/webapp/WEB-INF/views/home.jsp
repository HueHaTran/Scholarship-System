<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<%@ page import="uit.se06.scholarshipweb.bus.util.Constants"%>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title><%=Constants.WEB_NAME%></title>

<link href="<c:url value="/resources/css/site2.css" />" rel="stylesheet">
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/freelancer.css" rel="stylesheet">
<link href="resources/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
</head>

<body id="page-top" class="index">
	<div id="viewport">
		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
					<a class="navbar-brand" href="<c:url value="/" />"><%=Constants.WEB_NAME%></a>
				</div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav navbar-right">
						<li class="hidden"><a href="#page-top"></a></li>
						<li class="page-scroll active"><a href="<c:url value="/" />"><%=Constants.MENU_HOME%></a></li>
						<li class="page-scroll"><a href="<c:url value="/filter" />"><%=Constants.MENU_FILTER%></a></li>
					</ul>
				</div>
			</div>
		</nav>

		<div class="home-page" style="display: inline-block; width: 100%">
			<div style="float: left; position: relative; left: 50%">
				<div style="float: left; position: relative; left: -50%">
					<img class="img-responsive" style="margin-top: 50px" src="resources/img/home-intro.png"
						alt="">
					<div class="intro-text">
						<p
							style="font-size: 50px; text-align: center; width: 100%; color: #FFF; text-shadow: 0px 2px 0px rgba(20, 20, 20, 0.3), 0px 0px 10px rgba(20, 20, 20, 0.35);"><%=Constants.WEB_NAME%></p>
						<div class="row">
							<%@include file="search-box-long.jsp"%>
						</div>
						<div class="row" style="margin-bottom: 30px">
							<div class="col-lg-8 col-lg-offset-2 text-center">
								<a href="<c:url value="filter" />"
									class="btn btn-lg btn-outline"> <i class="fa fa-flag"></i>
									<%=Constants.BUTTON_FILTER_SCHOLARSHIP%>
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Footer -->
		<%@include file="footer2.jsp"%>
	</div>

</body>
</html>
