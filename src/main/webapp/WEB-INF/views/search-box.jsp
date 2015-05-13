<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/css/nav-wrap.css" />"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div id='nav-wrap'>
		<ul>
			<li class='search'>
				<form action="http://scholarship/all">
					<div class="input-group">
						<span class="input-group-btn">
							<button class="btn btn-default" type="submit">
								<img class='glyphicon' src="resources/img/zoom.png" />
							</button>
						</span> <input class="form-control search-term" type="text"
							placeholder="Tìm kiếm từ khóa" autocomplete="on" maxlength="60"
							value="" name="q"></input>
					</div>
				</form>
			</li>
		</ul>
	</div>
</body>
</html>