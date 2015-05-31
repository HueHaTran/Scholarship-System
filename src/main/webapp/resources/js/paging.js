function searchPaging(s) {
	var link;

	var currentPage = s.innerHTML;

	location.search = jQuery.query.set("pageNum", currentPage);
//	var link = jQuery.param.querystring( location.href, 'pageNum='
//			+ currentPage);
//	window.open(link);
}

function getParam(name) {
	if (name = (new RegExp('[?&]' + encodeURIComponent(name) + '=([^&]*)'))
			.exec(location.search))
		return decodeURIComponent(name[1]);
}