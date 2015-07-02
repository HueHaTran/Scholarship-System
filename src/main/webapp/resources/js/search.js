$(document).ready(function() {
	$('#search-text').autocomplete({
		source : function(request, response) {
			$.ajax({
				url : "./getAutocomplete",
				dataType : "JSON",
				data : {
					query : request.term,
					type : "0",
				},
				success : function(data) {
					response(data);
				}
			});
		},

		select : function(event, ui) {
			document.getElementById('search-text').value = ui.item.value;
			clickSearch('search-text');
		},
	});
	$('#search-text2').autocomplete({
		source : function(request, response) {
			$.ajax({
				url : "./getAutocomplete",
				dataType : "JSON",
				data : {
					query : request.term,
					type : "0",
				},
				success : function(data) {
					response(data);
				}
			});
		},

		select : function(event, ui) {
			document.getElementById('search-text2').value = ui.item.value;
			clickSearch('search-text2');
		},
	});

});

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
