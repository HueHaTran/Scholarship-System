<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bright future - Search</title>
<link href="<c:url value="/resources/css/result-content.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/site.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.9.1.min.js" />"></script>
<script src="<c:url value="/resources/js/jquery.query-object.js" />"></script>
<script src="<c:url value="/resources/js/paging.js" />"></script>
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
			<h2>KẾT QUẢ</h2>
			<div class="start-list-result">Có ${resultTotal} kết quả</div>

			<c:forEach items="${results}" var="result">
				<div class="result-content">

					<a href="all?id=${result.getId()}"><span
						class="title title-link">${result.getName()}</span></a>

					<div class="detail">
						<div class="detail-head"><%=Constants.HEAD_RESULT_SCHOOL%>:
							<span class="detail-content">${result.getSchoolName()}</span>
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

			<div class="paging">

				<%--For displaying Page numbers--%>
				<c:forEach var="i" begin="1" end="${noOfPages}">
					<c:choose>
						<c:when test="${pageNumber== i}">
							<div class="page-box page-box-current"
								onclick="filterPaging(this)">
								<c:out value="${i}" />
							</div>
						</c:when>
						<c:otherwise>
							<div class="page-box" onclick="filterPaging(this)">
								<c:out value="${i}" />
							</div>
						</c:otherwise>
					</c:choose>
				</c:forEach>

			</div>

		</fieldset>
	</div>
</body>
</html>
