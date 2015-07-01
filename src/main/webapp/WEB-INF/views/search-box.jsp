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
<script src="<c:url value="/resources/js/updateHTTPRequest.js" />"></script>
</head>
<body>
	<div id='nav-wrap'>
		<ul style="padding: 0px">
			<li class='search'>
				<div class="input-group">
					<span class="input-group-btn">

						<button class="btn btn-default"
							onclick="clickSearch('search-text2')" id="btnSearch2">
							<img class='glyphicon' src="resources/img/zoom.png" />
						</button>

					</span> <input id="search-text2" class="form-control search-term"
						onkeydown="if (event.keyCode == 13) document.getElementById('btnSearch2').click()"
						type="text" placeholder="<%=Constants.HIDDEN_SEARCH_ALL%>"
						autocomplete="on" maxlength="60"></input>
				</div>
			</li>
		</ul>
	</div>
</body>
</html>