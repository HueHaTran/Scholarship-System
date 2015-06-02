function onChangeCountry(s, provinceElementId) {
	var dataString = s[s.selectedIndex].value;

	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "./getProvincesFromCountry",
		data : countryId = dataString,
		dataType : "text",
		success : function(msg) {
			var data = JSON.parse(msg);
			if (msg != "false") {
				var sel = document.getElementById(provinceElementId);

				var len = data.length;
				if (len == 0) {
					sel.disabled = true;
				} else {
					sel.disabled = false;
				}

				for (var i = 0; i < len; ++i) {
					createOption(sel, data[i].id, data[i].name);
				}
			}
		},
		error : function() {
			alert("Error retrieving data!");
		}
	});
}

function createOption(selector, id, value) {
	var opt = document.createElement('option');
	opt.innerHTML = value;
	opt.value = id;
	selector.appendChild(opt);
}