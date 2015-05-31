function clickSearch() {
	var text = document.getElementById('search-text').value;
	if (text != "") {

		// get link
		var prefix = location.protocol + "//" + location.host;

		if (prefix.indexOf("scholar") == -1) {
			var pathArray = location.pathname.split('/');

			for (var i = 0; i < pathArray.length; i++) {
				if (pathArray[i].indexOf("scholar") != -1) {
					prefix = prefix + "/" + pathArray[i];
					break;
				}
			}
		}

		var link = prefix + "/search?keyWord=" + text + "&pageNum=1";
		window.open(link);
	}
}


