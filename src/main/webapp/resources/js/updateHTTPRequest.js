function updateQueryString(key, value, url) {
	if (!url)
		url = window.location.href;
	var re = new RegExp("([?&])" + key + "=.*?(&|#|$)(.*)", "gi"), hash;

	if (re.test(url)) {
		if (typeof value !== 'undefined' && value !== null)
			return url.replace(re, '$1' + key + "=" + value + '$2$3');
		else {
			hash = url.split('#');
			url = hash[0].replace(re, '$1$3').replace(/(&|\?)$/, '');
			if (typeof hash[1] !== 'undefined' && hash[1] !== null)
				url += '#' + hash[1];
			return url;
		}
	} else {
		if (typeof value !== 'undefined' && value !== null) {
			var separator = url.indexOf('?') !== -1 ? '&' : '?';
			hash = url.split('#');
			url = hash[0] + separator + key + '=' + value;
			if (typeof hash[1] !== 'undefined' && hash[1] !== null)
				url += '#' + hash[1];
			return url;
		} else
			return url;
	}
}

function removeURLParameter(sourceURL, key) {
	if (!sourceURL) {
		sourceURL = window.location.href;
	}
	var rtn = sourceURL.split("?")[0], param, params_arr = [], queryString = (sourceURL
			.indexOf("?") !== -1) ? sourceURL.split("?")[1] : "";
	if (queryString !== "") {
		params_arr = queryString.split("&");
		for (var i = params_arr.length - 1; i >= 0; i -= 1) {
			param = params_arr[i].split("=")[0];
			if (param === key || param == "") {
				params_arr.splice(i, 1);
			}
		}
		rtn = rtn + "?" + params_arr.join("&");
	}
	return rtn;
}

function urlContainKey(sourceURL, key) {
	if (!sourceURL) {
		sourceURL = window.location.href;
	}

	return sourceURL.indexOf(key) !== -1;
}