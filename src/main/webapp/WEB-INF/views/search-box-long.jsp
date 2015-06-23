<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page import="uit.se06.scholarshipweb.bus.util.Constants"%>
<link href="<c:url value="/resources/css/nav-wrap.css" />"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<c:url value="/resources/js/search.js" />"></script>
</head>
<body>
	<div id='nav-wrap'>
		<ul style="padding: 0px">
			<li class='search'>
				<form>
					<div class="input-group" style="left: -80%">
						<input id="search-text" class="form-control search-term"
							style="width: 500px" type="text"
							placeholder="<%=Constants.HIDDEN_SEARCH_ALL%>" autocomplete="on"
							maxlength="60"></input> <span class="input-group-btn">

							<button class="btn btn-default" onclick="clickSearch()">
								<img class='glyphicon' src="resources/img/zoom.png" />
							</button>

						</span>
					</div>
				</form>
			</li>
		</ul>
	</div>
</body>
</html>