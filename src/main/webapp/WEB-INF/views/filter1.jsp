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
<script src="<c:url value="/resources/js/input-check.js" />"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page import="uit.se06.scholarshipweb.bus.util.Localization"%>
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
					<div class="question"><%=Localization.GENDER%>:
					</div>
					<div class="answer">
						<label class="label_radio" for="-1"> <input
							name="meta_data_gender" checked="checked" id="-1" value="-1"
							type="radio" />Tất cả
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
					<div class="question"><%=Localization.RELIGION%>:
					</div>
					<div class="answer">

						<c:choose>
							<c:when test="${fn:length(meta_data_religion) < 4}">
								<!-- size < 4 -->
								<label class="label_radio" for="-1"> <input
									name="meta_data_religion" checked="checked" id="-1" value="-1"
									type="radio" />Tất cả
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
							</c:otherwise>
						</c:choose>

					</div>
				</div>
			</div>

			<div class="right">
				<div class="content">
					<div class="question">Câu hỏi 2</div>

					<div class="answer">Trả lời</div>
				</div>

			</div>



		</div>


		<input type="button" name="next" class="filter-next action-button"
			value="Next" onclick="clickNextFilter()" />
	</fieldset>

</body>
</html>