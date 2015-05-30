<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/css/nav-wrap.css" />"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<c:url value="/resources/js/search.js" />"></script>
</head>
<body>

	<div id="temp-storage-search" style="display: none;"></div>
	<div id='nav-wrap'>
		<ul>
			<li class='search'>
				<form>
					<div class="input-group">
						<span class="input-group-btn">

							<button class="btn btn-default" type="submit"
								onclick="clickSearch()">
								<img class='glyphicon' src="resources/img/zoom.png" />
							</button>

						</span> <input id="search-text" class="form-control search-term"
							type="text" placeholder="Tìm kiếm từ khóa" autocomplete="on"
							maxlength="60"></input>
					</div>
				</form>
			</li>
		</ul>
	</div>
</body>
</html>