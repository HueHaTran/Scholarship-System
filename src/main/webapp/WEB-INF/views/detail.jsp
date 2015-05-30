<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bright future - Detail</title>
<link href="<c:url value="/resources/css/result-content.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/site.css" />" rel="stylesheet">
<%@ page import="uit.se06.scholarshipweb.bus.util.Constants"%>
</head>
<body>
	<div class="container">
		<div id='nav-menu'>
			<%@include file="search-box.jsp"%>
			<ul class="nav-menu-ul">
				<li><a class="menu" href="<c:url value="/" />"><span><%=Constants.MENU_HOME%></span></a></li>
				<li><a class="menu" href="<c:url value="filter" />"><span><%=Constants.MENU_FILTER%></span></a></li>
				<li><a class="menu" href='#'><span><%=Constants.MENU_CONTACT%></span></a></li>
			</ul>
		</div>

		<fieldset class="filter-fieldset" id="search-page1">
			<h2>${result.getName()}</h2>

			<a href="all?id=${result.getId()}"><span class="title">${result.getName()}</span></a>

			<div class="detail">
				<div class="detail-head"><%=Constants.HEAD_RESULT_SCHOOL%>: <span
						class="detail-content">${result.getSchoolName()}</span>
				</div>
			</div>

			<div class="detail">
				<div class="detail-head"><%=Constants.HEAD_RESULT_VALUE%>: <span
						class="detail-content">${result.getValue()}</span>
				</div>
			</div>

			<div class="detail">
				<div class="detail-head"><%=Constants.HEAD_RESULT_DATE_END%>:
					<span class="detail-content">${result.getDateEndRegister()}</span>
				</div>
			</div>


			<div class="paging"></div>

		</fieldset>
</body>
</html>