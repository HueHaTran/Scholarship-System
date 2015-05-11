<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link href="<c:url value="/resources/css/site.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/nav-wrap.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/homepage.css" />"
	rel="stylesheet">
<!--  
<script src="<c:url value="/resources/js/bootstrap.js" />"></script> 
<script src="<c:url value="/resources/js/jquery-1.10.2.js" />"></script> 
<script src="<c:url value="/resources/js/modernizr-2.6.2.js" />"></script> 
<script src="<c:url value="/resources/js/respond.js" />"></script>
 -->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bright future</title>
</head>
<body>
	<div id='nav-menu'>
		<%@include file="search-box.jsp"%>
		<ul class="nav-menu-ul">
			<li class='active'><a href="<c:url value="/" />"><span>Trang
						chủ</span></a></li>
			<li><a href="<c:url value="/search" />"><span>Tìm
						kiếm học bổng</span></a></li>
			<li><a href='#'><span>Liên hệ</span></a></li>
		</ul>

	</div>

	<div class="homepage-main">
		<img class="homepage-main-bg" src="resources/img/home-img.png" />
		<div class="homepage-introduce">
			<p class="p-title">Bright Future</p>
			<p class="p-subtitle">Hệ thống tìm kiếm thông tin học bổng online</p>
		</div>
	</div>
</body>
</html>