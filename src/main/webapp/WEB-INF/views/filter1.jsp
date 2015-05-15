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
<script src="<c:url value="/resources/js/filter-country.js" />"></script>
<script src="<c:url value="/resources/js/input-check.js" />"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page import="uit.se06.scholarshipweb.bus.util.Contants"%>
</head>
<body>
	<fieldset id="filter-fieldset">
		<h2 class="fs-title">Đối tượng tham gia</h2>
		<h3 class="fs-subtitle">Thông tin cá nhân và gia đình của đối
			tượng tham gia</h3>

		<div class="filter-info">
			<div class="heading">Thông tin cá nhân</div>

			<div class="left">
				<!-- Content -->
				<div class="content">
					<div class="question"><%=Contants.PROP_GENDER%>:
					</div>
					<div class="answer">
						<label class="label_radio" for="0"> <input
							name="meta_data_gender" checked="checked" id="0" value="0"
							type="radio" /><%=Contants.TAG_ALL%>
						</label>
						<c:forEach items="${meta_data_gender}" var="gender">
							<label class="label_radio" for="${gender.getId()}"> <input
								name="meta_data_gender" id="${gender.getId()}"
								value="${gender.getId()}" type="radio" /> ${gender.getName()}
							</label>
						</c:forEach>
					</div>
				</div>

				<!-- Content -->
				<div class="content">
					<div class="question"><%=Contants.PROP_RELIGION%>:
					</div>
					<div class="answer">
						<c:choose>
							<c:when test="${fn:length(meta_data_religion) < 4}">
								<!-- size < 4 -->
								<label class="label_radio" for="0"> <input
									name="meta_data_religion" checked="checked" id="0" value="0"
									type="radio" /><%=Contants.TAG_ALL%>
								</label>
								<c:forEach items="${meta_data_religion}" var="religion">
									<label class="label_radio" for="${religion.getId()}"> <input
										name="meta_data_religion" id="${religion.getId()}"
										value="${religion.getId()}" type="radio" />
										${religion.getName()}
									</label>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<!-- size >=4 -->
								<div class="label_listbox">
									<select name="combobox_religion">
										<option value="0" selected><%=Contants.TAG_NOTHING%></option>
										<c:forEach items="${meta_data_religion}" var="religion">
											<option value="${religion.getId()}">${religion.getName()}</option>
										</c:forEach>
									</select>
								</div>
							</c:otherwise>
						</c:choose>
					</div>
				</div>

				<!-- Content -->
				<div class="content">
					<div class="question"><%=Contants.PROP_CITIZENSHIP%>:
					</div>
					<div class="answer">
						<label class="label_listbox"> <select
							name="combobox_citizenship">
								<option id="0" value="0" selected><%=Contants.TAG_ALL%></option>
								<c:forEach items="${meta_data_country}" var="citizenship">
									<option value="${citizenship.getId()}">${citizenship.getName()}</option>
								</c:forEach>
						</select>
						</label>
					</div>
				</div>


				<!-- Content -->
				<div class="content">
					<div class="question"><%=Contants.PROP_RESIDENCE%>:
					</div>
					<div class="answer">
						<label class="label_listbox"> <select
							name="combobox_citizenship" onchange="onChangeCountry(this)">
								<option id="0" value="0" selected><%=Contants.TAG_ALL%></option>
								<c:forEach items="${meta_data_country}" var="citizenship">
									<option value="${citizenship.getId()}">${citizenship.getName()}</option>
								</c:forEach>
						</select>
						</label>
						<div class="subtext">
							<i>Chọn <%=Contants.PROP_PROVINCE%>:
							</i>
						</div>
						<label class="label_listbox"> <select
							name="combobox_citizenship" id="combobox_residence_province">
						</select>
						</label>
					</div>
				</div>

			</div>

			<div class="right">
				<div class="content">
					<!-- Content -->
					<div class="content">
						<div class="question"><%=Contants.PROP_DISABILITY%>:
						</div>
						<div class="answer">
							<label class="label_listbox_mutiple"> <select
								class="select_mutiple" name="combobox_disability"
								multiple="multiple">
									<c:forEach items="${meta_data_disability}" var="disability">
										<option value="${disability.getId()}">${disability.getName()}</option>
									</c:forEach>
							</select>
							</label>
						</div>
					</div>
				</div>

			</div>



		</div>

		<div style="display: block;">
			<input type="button" name="next" class="filter-next action-button"
				value="Next" onclick="clickNextFilter()" />
		</div>
	</fieldset>

</body>
</html>