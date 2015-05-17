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

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bright future</title>
</head>
<body>
	<div id='nav-menu'>
		<%@include file="search-box.jsp"%>
		<ul class="nav-menu-ul">
			<li><a href="<c:url value="/" />"><span>Trang chủ</span></a></li>
			<li class='active'><a href="<c:url value="/search" />"><span>Tìm
						kiếm học bổng</span></a></li>
			<li><a href='#'><span>Liên hệ</span></a></li>
		</ul>
	</div>

	<div class="container">
		<form id="msform">
			<!-- progressbar -->
			<ul id="progressbar">
				<li id="progressbar1" class="active" onclick="clickFilter(1,4)">Đối
					tượng tham gia</li>
				<li id="progressbar2" onclick="clickFilter(2,4)">Trình độ học
					vấn</li>
				<li id="progressbar3" onclick="clickFilter(3,4)">Loại học bổng</li>
				<li id="progressbar4" onclick="clickFilter(4,4)">Kết quả</li>
			</ul>
			<!-- fieldsets -->
			<%@include file="filter1.jsp"%>
			<%@include file="filter2.jsp"%>
			<%@include file="filter3.jsp"%>
			<%@include file="filter4.jsp"%>

			<fieldset id="filter-fieldset">
				<h2 class="fs-title">Loại học bổng</h2>
				<h3 class="fs-subtitle">Thông tin chi tiết khác của học bổng</h3>
				<input type="button" name="previous"
					class="filter-previous action-button" value="Previous" /> <input
					type="submit" name="submit" class="filter-submit action-button"
					value="Submit" />
			</fieldset>

			<fieldset id="filter-fieldset">
				<h2 class="fs-title">Kết quả</h2>
				<h3 class="fs-subtitle">Có n kết quả</h3>
				<input type="button" name="again" class="filter-again action-button"
					value="Again" /> <input type="button" name="homepage"
					class="filter-homepage action-button" value="Homepage" />
			</fieldset>
		</form>
	</div>
</body>
</html>