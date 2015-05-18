<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link href="<c:url value="/resources/css/site.css" />" rel="stylesheet">

<link href="<c:url value="/resources/css/homepage.css" />"
	rel="stylesheet">

<%@ page import="uit.se06.scholarshipweb.bus.util.Contants"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bright future</title>
</head>
<body>
	<div id='nav-menu'>
		<%@include file="search-box.jsp"%>
		<ul class="nav-menu-ul">
			<li class='active'><a href="<c:url value="/" />"><span><%=Contants.MENU_HOME%></span></a></li>
			<li><a href="<c:url value="/search" />"><span><%=Contants.MENU_FILTER%></span></a></li>
			<li><a href='#'><span><%=Contants.MENU_CONTACT%></span></a></li>
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