<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page import="uit.se06.scholarshipweb.bus.util.Constants"%>
<link href="<c:url value="/resources/css/nav-wrap.css" />"
	rel="stylesheet">


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="resources/css/autocomplete.css" rel="stylesheet"
	type="text/css" />
<script src="<c:url value="/resources/js/search.js" />"></script>
<script src="<c:url value="/resources/js/updateHTTPRequest.js" />"></script>

<!-- auto complete (add following to parent) 
<script src="<c:url value="/resources/js/jquery-1.10.2.js" />"></script>
<script src="<c:url value="/resources/js/jquery-ui-1.11.4.js" />"></script>
 end -->
 
</head>
<body>
	<div id='nav-wrap'>
		<ul style="padding: 0px">
			<li class='search'>
				<div class="input-group" style="left: -65%">
					<input id="search-text" class="form-control search-term"
						onkeydown="if (event.keyCode == 13) document.getElementById('btnSearch').click()"
						style="width: 500px" type="text"
						placeholder="<%=Constants.HIDDEN_SEARCH_ALL%>" autocomplete="on"
						maxlength="60"></input> <span class="input-group-btn">

						<button class="btn btn-default"
							onclick="clickSearch('search-text')" id="btnSearch">
							<img class='glyphicon' src="resources/img/zoom.png" />
						</button>

					</span>
				</div>
			</li>
		</ul>
	</div>
</body>
</html>