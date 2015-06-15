<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page import="uit.se06.scholarshipweb.bus.util.Constants"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
</head>
<body>
	<div class="footer-above">
		<div class="container">
			<div class="row">
				<div class="footer-col col-md-4">
					<h3>
						<%=Constants.INFO_TITLE_CONTACT%></h3>
					<p>
						<%=Constants.INFO_CONTACT%>
					</p>
				</div>
				<div class="footer-col col-md-4">
					<h3><%=Constants.WEB_NAME%></h3>
				</div>
				<div class="footer-col col-md-4">
					<h3><%=Constants.INFO_TITLE_AUTHOR%></h3>
					<p>
						<%=Constants.INFO_AUTHOR%>
					</p>
				</div>
			</div>
		</div>
	</div>
	<div class="footer-below">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					Copyright &copy;
					<%=Constants.WEB_NAME%>
					2015
				</div>
			</div>
		</div>
	</div>
</body>
</html>