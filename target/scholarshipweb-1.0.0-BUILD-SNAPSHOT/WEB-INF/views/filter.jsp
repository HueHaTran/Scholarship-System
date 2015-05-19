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

<script src="<c:url value="/resources/js/filter.js" />"></script>

<%@ page import="uit.se06.scholarshipweb.bus.util.Contants"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bright future</title>
</head>
<body>
	<div id='nav-menu'>
		<%@include file="search-box.jsp"%>
		<ul class="nav-menu-ul">
			<li><a href="<c:url value="/" />"><span><%=Contants.MENU_HOME%></span></a></li>
			<li class='active'><a href="<c:url value="/search" />"><span><%=Contants.MENU_FILTER%></span></a></li>
			<li><a href='#'><span><%=Contants.MENU_CONTACT%></span></a></li>
		</ul>
	</div>

	<div class="container">
		<form id="msform">
			<!-- progressbar -->
			<ul id="progressbar">
				<li id="progressbar1" class="active" onclick="clickFilter(1,4)"><%=Contants.TITLE_FILTER1%></li>
				<li id="progressbar2" onclick="clickFilter(2,4)"><%=Contants.TITLE_FILTER2%></li>
				<li id="progressbar3" onclick="clickFilter(3,4)"><%=Contants.TITLE_FILTER3%></li>
				<li id="progressbar4" onclick="clickFilter(4,4)"><%=Contants.TITLE_FILTER4%></li>
			</ul>
			<!-- fieldsets -->
			<%@include file="filter1.jsp"%>
			<%@include file="filter2.jsp"%>
			<%@include file="filter3.jsp"%>
			<%@include file="filter4.jsp"%>
		</form>
	</div>
</body>
</html>