$(document).ready(function() {
	alert("enter");
	$('.select2-1').select2({
		tokenSeparators : [ ',', ' ' ],
		placeholder : "Tất cả",
	});
	$('.select2-2').select2({
		tokenSeparators : [ ',', ' ' ],
		allowClear : true,
		placeholder : "Tất cả",
	});

});
