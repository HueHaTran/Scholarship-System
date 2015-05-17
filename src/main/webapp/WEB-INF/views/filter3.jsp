<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/css/filter-content.css" />"
	rel="stylesheet">

<script src="<c:url value="/resources/js/filter-country.js" />"></script>
<script src="<c:url value="/resources/js/input-check.js" />"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page import="uit.se06.scholarshipweb.bus.util.Contants"%>
</head>
<body>
	<fieldset class="filter-fieldset" id="filter3">
		<h2 class="fs-title"><%=Contants.TITLE_FILTER3%></h2>
		<h3 class="fs-subtitle"><%=Contants.SUBTITLE_FILTER3%></h3>

		<div class="filter-info">
			<div class="heading"><%=Contants.HEAD_FILTER3_1%></div>

		</div>

		<div class="div-space"></div>

		<div style="clear: both;">
			<input type="button" name="previous"
				class="filter-previous action-button" value="Previous"
				onclick="clickPrevFilter('filter3', 'filter2', 2)" /> <input
				type="button" name="next" class="filter-next action-button"
				value="Sumit" onclick="clickNextFilter('filter3', 'filter4', 4)" />
		</div>
	</fieldset>

</body>
</html>