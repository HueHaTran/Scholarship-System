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

<link href="<c:url value="/resources/css/site.css" />" rel="stylesheet">
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/freelancer.css" rel="stylesheet">
<link href="resources/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link
	href="http://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic"
	rel="stylesheet" type="text/css">

</head>

<body id="page-top" class="index">
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
				<!-- <div class="navbar-header page-scroll">
					<%@include file="search-box.jsp"%>
				</div> -->
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li class="hidden"><a href="#page-top"></a></li>
					<li class="page-scroll"><a href="#portfolio"><%=Constants.MENU_SEARCH_SCHOLAR_NAME%></a></li>
					<li class="page-scroll"><a href="#about"><%=Constants.MENU_INTRO%></a></li>
					<li class="page-scroll"><a href="#contact"><%=Constants.MENU_CONTACT%></a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>

	<!-- Header -->
	<header>
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<img class="img-responsive" src="resources/img/home-intro.png"
						alt="">
					<div class="intro-text">
						<span class="name"><%=Constants.WEB_NAME%></span>
						<hr class="star-light">
						<span class="skills">Hệ thống tìm kiếm thông tin học bổng</span>
					</div>
				</div>
			</div>
		</div>
	</header>

	<!-- Portfolio Grid Section -->
	<section id="portfolio" class="colorstyle1">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2><%=Constants.MENU_SEARCH_SCHOLAR_NAME%></h2>
					<hr class="star-light">
					<div style="float: left; position: relative;; left: 50%">
						<div style="float: left; position: relative;; left: -50%">
							<%@include file="search-box.jsp"%>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- About Section -->
	<section class="success" id="about">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2><%=Constants.MENU_INTRO%></h2>
					<hr class="star-light">
				</div>
			</div>
			<div class="row">
				<div class="col-lg-4 col-lg-offset-2">
					<p><%=Constants.SUBTITLE_INTRO1%></p>
				</div>
				<div class="col-lg-4">
					<p><%=Constants.SUBTITLE_INTRO2%></p>
				</div>
				<div class="row" style="clear: both;">
					<div class="text-center">
						<p><%=Constants.HELP_FILTER%></p>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2 text-center">
					<a href="<c:url value="filter" />" class="btn btn-lg btn-outline">
						<i class="fa fa-flag"></i> <%=Constants.BUTTON_FILTER_SCHOLARSHIP%>
					</a>
				</div>
			</div>
		</div>
	</section>

	<!-- Contact Section -->
	<section id="contact">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2><%=Constants.MENU_CONTACT%></h2>
					<hr class="star-primary">
				</div>
			</div>
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2">
					<!-- To configure the contact form email address, go to mail/contact_me.php and update the email address in the PHP file on line 19. -->
					<!-- The form should work on most web servers, but if the form is not working you may need to configure your web server differently. -->
					<form name="sentMessage" id="contactForm" novalidate>
						<div class="row control-group">
							<div
								class="form-group col-xs-12 floating-label-form-group controls">
								<label><%=Constants.USER_NAME%></label> <input type="text"
									class="form-control" placeholder="<%=Constants.USER_NAME%>"
									id="name" required
									data-validation-required-message="<%=Constants.MESSAGE_ENTER_NAME%>">
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<div class="row control-group">
							<div
								class="form-group col-xs-12 floating-label-form-group controls">
								<label><%=Constants.USER_EMAIL%></label> <input type="email"
									class="form-control" placeholder="<%=Constants.USER_EMAIL%>"
									id="email" required
									data-validation-required-message="<%=Constants.MESSAGE_ENTER_MAIL%>">
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<div class="row control-group">
							<div
								class="form-group col-xs-12 floating-label-form-group controls">
								<label><%=Constants.USER_MESSAGE%></label>
								<textarea rows="5" class="form-control"
									placeholder="<%=Constants.USER_MESSAGE%>" id="message" required
									data-validation-required-message="<%=Constants.MESSAGE_ENTER_MESSAGE%>"></textarea>
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<br>
						<div id="success"></div>
						<div class="row">
							<div class="form-group col-xs-12">
								<button style="min-width: 50px" type="submit"
									class="btn btn-success btn-lg"><%=Constants.BUTTON_SEND%></button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>

	<!-- Footer -->
	<footer class="text-center">
		<%@include file="footer.jsp"%>
	</footer>

	<!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
	<div class="scroll-top page-scroll visible-xs visible-sm">
		<a class="btn btn-primary" href="#page-top"> <i
			class="fa fa-chevron-up"></i>
		</a>
	</div>

	<!-- jQuery -->
	<script src="resources/js/jquery.js"></script>

	<!-- Plugin JavaScript -->
	<script src="resources/js/jquery.easing.min.js"></script>
	<script src="resources/js/classie.js"></script>
	<script src="resources/js/cbpAnimatedHeader.js"></script>

	<!-- Contact Form JavaScript -->
	<script src="resources/js/jqBootstrapValidation.js"></script>
	<script src="resources/js/contact_me.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="resources/js/freelancer.js"></script>

</body>
</html>
