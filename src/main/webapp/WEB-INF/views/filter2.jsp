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
	<fieldset class="filter-fieldset" id="filter2">
		<h2 class="fs-title"><%=Contants.TITLE_FILTER2%></h2>
		<h3 class="fs-subtitle"><%=Contants.SUBTITLE_FILTER2%></h3>

		<div class="filter-info">
			<div class="heading"><%=Contants.HEAD_FILTER2_1%></div>

		</div>

		<div class="div-space"></div>

		<div style="clear: both;">
			<input type="button" name="previous"
				class="filter-previous action-button" value="Previous"
				onclick="clickPrevFilter('filter2', 'filter1', 1)" /> <input
				type="button" name="next" class="filter-next action-button"
				value="Next" onclick="clickNextFilter('filter2', 'filter3', 3)" />
		</div>
	</fieldset>

</body>
</html>