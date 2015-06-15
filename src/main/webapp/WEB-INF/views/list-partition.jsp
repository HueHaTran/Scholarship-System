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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page import="uit.se06.scholarshipweb.bus.util.Constants"%>
</head>
<body>
	<c:forEach items="${results}" var="result">
		<div class="result-content">

			<a href="all?id=${result.getId()}"><span class="title title-link">${result.getName()}</span></a>

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
		</div>

	</c:forEach>

</body>
</html>