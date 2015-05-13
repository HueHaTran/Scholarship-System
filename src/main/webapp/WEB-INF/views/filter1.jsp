<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/css/column.css" />"
	rel="stylesheet">
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
				<div class="content">
					<div class="question"><%=Localization.GENDER%></div>

					<div class="answer">Trả lời</div>

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