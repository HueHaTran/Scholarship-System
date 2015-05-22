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

			<div class="left">
				<div class="content">
					<div class="question"><%=Contants.PROP_SCHOLARSHIP_TYPE%>:
					</div>
					<div class="answer">
						<label class="label_listbox"> <select
							name="combobox_scholarship_type">
								<option id="0" value="0" selected><%=Contants.TAG_ALL%></option>
								<c:forEach items="${meta_data_scholarship_type}"
									var="scholarship_type">
									<option value="${scholarship_type.getId()}">${scholarship_type.getName()}</option>
								</c:forEach>
						</select>
						</label>
					</div>
				</div>
			</div>

			<div class="right">
				<div class="content">
					<div class="question"><%=Contants.PROP_TALENT%>:
					</div>
					<div class="answer">
						<label class="label_listbox_mutiple"> <select
							class="select_mutiple" name="combobox_talent" multiple="multiple">
								<c:forEach items="${meta_data_talent}" var="talent">
									<option value="${talent.getId()}">${talent.getName()}</option>
								</c:forEach>
						</select>
						</label>

					</div>
				</div>
			</div>


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