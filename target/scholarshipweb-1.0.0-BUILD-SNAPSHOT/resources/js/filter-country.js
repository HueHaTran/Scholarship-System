function onChangeCountry(s) {
	var countryId = s[s.selectedIndex].value;
	alert(countryId);// ok
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "./get_province",
		data : countryId,
		dataType : "json",
		success : function(msg) {
			alert("start proccessing");
			data = JSON.parse(msg);
			alert("data mess: " + data.length);
			alert("here mess: " + msg);

			alert("start proccessing");
			var provinces = msg;
			var sel = document.getElementById('combobox_residence_province');
			for (var i = 0; i < provinces.length; i++) {
				var opt = document.createElement('option');
				opt.innerHTML = provinces[i].getName();
				opt.value = provinces[i].getId();
				sel.appendChild(opt);
			}
		},
		  error : function () { alert("Error retrieving employee data!"); }
	}); 

}
 