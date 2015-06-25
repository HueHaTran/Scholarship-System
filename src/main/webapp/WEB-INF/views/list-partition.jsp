<%@page import="uit.se06.scholarshipweb.controller.FilterController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/css/filter-content.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/DT_bootstrap.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap.min.2.3.2.css" />"
	rel="stylesheet">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%@ page import="uit.se06.scholarshipweb.bus.util.Constants"%>

<style type="text/css">
.search_filter:focus {
	border-color: #66AFE9;
	outline: 0px none;
	box-shadow: 0px 1px 1px rgba(0, 0, 0, 0.075) inset, 0px 0px 8px
		rgba(102, 175, 233, 0.6);
}
</style>
</head>
<body>
	<table class="table table-striped table-bordered dataTable no-footer"
		id="myTable">
		<thead>
			<tr>
				<th><%=Constants.HEAD_RESULT_NAME%></th>
				<th><%=Constants.HEAD_RESULT_SCHOOL%></th>
				<th><%=Constants.HEAD_RESULT_VALUE_MIN%></th>
				<th><%=Constants.HEAD_RESULT_VALUE_MAX%></th>
				<th><%=Constants.HEAD_RESULT_DATE_END%></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${results}" var="result">
				<tr>
					<td style="width: 25%; text-decoration: none;"><a
						class="title-link" href="all?id=${result.getId()}">${result.getName()}</a></td>
					<td>${result.getSchoolName()}</td>
					<td>${result.getValueMin()}</td>
					<td>${result.getValueMax()}</td>
					<td>${result.getDateEndRegister()}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</body>

</html>