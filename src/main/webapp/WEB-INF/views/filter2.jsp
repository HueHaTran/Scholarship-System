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
			<div class="full">
				<div class="content">
					<div class="question"><%=Contants.PROP_STUDENT_ACADEMIC_LEVEL_DETAIL%>:
					</div>
					<div class="answer">
						<label class="label_radio"> <input
							name="meta_data_student_aca" checked="checked" id="0" value="0"
							type="radio" /><%=Contants.TAG_ALL%>
						</label>
						<c:set var="aca_id_count" value="${0}" scope="page" />
						<c:forEach items="${meta_data_academic_level}"
							var="student_academic_level">
							<c:set var="aca_id_count" value="${aca_id_count+1}" scope="page" />
							<div class="full">
								<div class="left">
									<label class="label_radio"> <input
										name="meta_data_student_aca"
										id="${student_academic_level.getId()}"
										value="${student_academic_level.getId()}" type="radio" />
										${student_academic_level.getName()}
									</label>
								</div>
								<div class="right">
									<c:choose>
										<c:when
											test="${fn:length(student_academic_level.getAcademicLevelDetails()) > 0}">

											<div class="label_listbox">
												<select name="combo_student_aca_${aca_id_count}">
													<option value="0" selected><%=Contants.TAG_ALL%></option>
													<c:forEach
														items="${student_academic_level.getAcademicLevelDetails()}"
														var="student_academic_detail">
														<option value="${student_academic_detail.getId()}">${student_academic_detail.getName()}</option>
													</c:forEach>
												</select>
											</div>
										</c:when>
									</c:choose>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>

		<div class="div-space"></div>
		<div class="filter-info">
			<div class="heading"><%=Contants.HEAD_FILTER2_2%></div>

			<div class="full">
				<div class="content">
					<div class="question"><%=Contants.PROP_SCHOLARSHIP_ACADEMIC_LEVEL_DETAIL%>:
					</div>
					<div class="answer">
						<label class="label_radio"> <input
							name="meta_data_scholarship_aca" checked="checked" id="0"
							value="0" type="radio" /><%=Contants.TAG_ALL%>
						</label>
						<c:set var="aca_id_count2" value="${0}" scope="page" />
						<c:forEach items="${meta_data_academic_level}"
							var="scholarship_academic_level">
							<c:set var="aca_id_count2" value="${aca_id_count2+1}"
								scope="page" />
							<div class="full">
								<div class="left">
									<label class="label_radio"> <input
										name="meta_data_scholarship_aca"
										id="${scholarship_academic_level.getId()}"
										value="${scholarship_academic_level.getId()}" type="radio" />
										${scholarship_academic_level.getName()}
									</label>
								</div>
								<div class="right">
									<c:choose>
										<c:when
											test="${fn:length(scholarship_academic_level.getAcademicLevelDetails()) > 0}">
											<div class="label_listbox">
												<select name="combo_scholarship_aca_${aca_id_count2}">
													<option value="0" selected><%=Contants.TAG_ALL%></option>
													<c:forEach
														items="${scholarship_academic_level.getAcademicLevelDetails()}"
														var="scholarship_academic_detail">
														<option value="${scholarship_academic_detail.getId()}">${scholarship_academic_detail.getName()}</option>
													</c:forEach>
												</select>
											</div>
										</c:when>
									</c:choose>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>

			<div class="left">
				<div class="content">
					<div class="question"><%=Contants.PROP_SCHOLARSHIP_MAJOR%>:
					</div>
					<div class="answer">
						<label class="label_listbox_mutiple"> <select
							class="select_mutiple" name="combobox_major" multiple="multiple">
								<c:forEach items="${meta_data_major}" var="major">
									<option value="${major.getId()}">${major.getName()}</option>
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
				onclick="clickPrevFilter('filter2', 'filter1', 1)" /> <input
				type="button" name="next" class="filter-next action-button"
				value="Next" onclick="clickNextFilter('filter2', 'filter3', 3)" />
		</div>
	</fieldset>

</body>
</html>