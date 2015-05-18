function onChangeCountry(s) {
	var dataString = s[s.selectedIndex].value;

	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "./get_province",
		async : false,
		data : countryId = dataString,
		dataType : "text",
		success : function(msg) {
			alert("enter");
			data = JSON.parse(msg);
			if (msg != "false") {
				var sel = document
						.getElementById('combobox_residence_province');

				var len = data.length;
				if (len == 0) {
					sel.disabled = true;
				} else {
					sel.disabled = false;
				}

				for (var i = 0; i < len; ++i) {
					createOption(sel, data[i][0], data[i][1]);
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