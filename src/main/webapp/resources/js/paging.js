function searchPaging(s) {
	var link;

	var currentPage = s.innerHTML;

	location.search = jQuery.query.set("pageNum", currentPage);
}

function getParam(name) {
	if (name = (new RegExp('[?&]' + encodeURIComponent(name) + '=([^&]*)'))
			.exec(location.search))
		return decodeURIComponent(name[1]);
}

function filterPaging(s) {
	var link;

	var currentPage = s.innerHTML;

	location.search = jQuery.query.set("pageNum", currentPage);
}
