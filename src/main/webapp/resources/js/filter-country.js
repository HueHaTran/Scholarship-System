function onChangeCountry(s) {
	var dataString = s[s.selectedIndex].value;

	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "./get_province",
		data : countryId = dataString,
		dataType : "text",
		success : function(msg) {
			data = JSON.parse(msg);
			if (msg != "false") {
				var sel = document
						.getElementById('combobox_residence_province');
				for (var i = 0, len = data.length; i < len; ++i) {
					var opt = document.createElement('option');
					opt.innerHTML = data[i][1];
					opt.value = data[i][0];
					sel.appendChild(opt);
				}
			}
		},
		error : function() {
			alert("Error retrieving data!");
		}
	});
}
