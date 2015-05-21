function onAcademicLevelChanged(academicLevelRadioName, detailElementId) {
	var radio = $('input[name=' + academicLevelRadioName + ']');

	var checkedValue = radio.filter(':checked').val();

	if (checkedValue) {
		alert("true");
	} else {
		alert("false");
	}
}