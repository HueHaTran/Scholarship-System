function onAcademicLevelChanged(radioName, childNamePrefix) {
	var childId = document.querySelector('input[name = ' + radioName
			+ ']:checked').id;

	var sel2 = document.getElementById(childNamePrefix + childId);
	
	sel2.disabled = false;
}