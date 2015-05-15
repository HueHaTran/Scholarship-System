function onChangeCountry(s) {
	var dataString = s[s.selectedIndex].value;
	alert(dataString);// ok
	// var data = {
	// dataString : dataString,
	// }

	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "./get_province",
		data : countryId = dataString,
		dataType : "text",
		success : function(msg) {
			alert("yeahyeah! " + msg);
			data = JSON.parse(msg);
			if (msg == "false") {
				alert("false");
			} else {
				alert("true " + data.length);

				var sel = document
						.getElementById('combobox_residence_province');
				for (var i = 0, len = data.length; i < len; ++i) {
					alert(i);
					alert(i + " " + data[i].getName());
					var opt = document.createElement('option');
					opt.innerHTML = data[i].getName();
					opt.value = data[i].getId();
					sel.appendChild(opt);
				}
			}
		},
		error : function() {
			alert("Error retrieving employee data!");
		}
	});

}
