<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

<%@ page import="uit.se06.scholarshipweb.bus.util.Constants"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title><%=Constants.WEB_NAME%> - <%=Constants.MENU_FILTER%></title>

<link href="<c:url value="/resources/css/result-content.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/site.css" />" rel="stylesheet">
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/freelancer.css" rel="stylesheet">
<link href="resources/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<script src="<c:url value="/resources/js/jquery-1.9.1.min.js" />"></script>
<script src="<c:url value="/resources/js/jquery.query-object.js" />"></script>
<script src="<c:url value="/resources/js/paging.js" />"></script>
</head>
<body>
	<div id="viewport">
		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-fixed-top">
			<div class="container">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<a class="navbar-brand" href="<c:url value="/" />"><%=Constants.WEB_NAME%></a>
					<%@include file="search-box.jsp"%>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">

					<ul class="nav navbar-nav navbar-right">
						<li class="page-scroll"><a href="<c:url value="/" />"><%=Constants.MENU_HOME%></a></li>
						<li class="page-scroll active"><a
							href="<c:url value="/filter" />"><%=Constants.MENU_FILTER%></a></li>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>

		<div class="content-section" id="filter-intro">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2><%=Constants.TITLE_FILTER4%></h2>
					<hr class="star-light">
				</div>
			</div>
			<div class="row">
				<div class="start-list-result">Có ${resultTotal} kết quả</div>
			</div>
			<br>

			<c:if test="${resultTotal!=0}">
				<div class="row">
					<div class="filter-fieldset">
						<%@include file="list-partition.jsp"%>
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
					</div>
				</div>
			</c:if>
		</div>

		<!-- Footer -->
		<%@include file="footer.jsp"%>
	</div>

	<!-- Custom Theme JavaScript -->
	<script src="resources/js/freelancer.js"></script>
</body>
</html>
