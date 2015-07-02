function clickSearch(idTextbox) {
	var text = document.getElementById(idTextbox).value;
	if (text != "") {
		text = text.replace(" ", "+");
		if (urlContainKey(null, "search?")) {
			var link = null;
			link = updateQueryString("keyWord", text, link);
			location.replace(link);
		} else {
			var link = "search?";
			link = updateQueryString("keyWord", text, link);
			location.replace(link);
		}
	}
}
