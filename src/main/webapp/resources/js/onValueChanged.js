var radioAcaStu = "meta_data_student_aca";
var radioAcaScholar = "meta_data_scholarship_aca";

var comboAcaStu = "combo_student_aca_";
var comboAcaScholar = "combo_scholarship_aca_";

var oldAcaStu = null;
var oldAcaScholar = null;

$(document).ready(
		function() {
			oldAcaStu = document.querySelector('input[name = ' + radioAcaStu
					+ ']:checked').id;
			oldAcaScholar = document.querySelector('input[name = '
					+ radioAcaScholar + ']:checked').id;

			// enable current 'detail'
			if (oldAcaStu != 0) {
				enable(comboAcaStu + oldAcaStu, false);
			}

			if (oldAcaScholar != 0) {
				enable(comboAcaScholar + oldAcaScholar, false);
			}
		});

function onAcademicLevelChanged(radioName, childNamePrefix) {
	var childId = document.querySelector('input[name = ' + radioName
			+ ']:checked').id;

	var oldId = null;

	if (radioName == radioAcaStu) {
		oldId = oldAcaStu;
	} else if (radioName == radioAcaScholar) {
		oldId = oldAcaScholar;
	}

	if (oldId != 0) {
		// hide old 'detail'
		enable(childNamePrefix + oldId, true);
	}

	if (childId != 0) {
		// enable current 'detail'
		enable(childNamePrefix + childId, false);
	}

	if (radioName == radioAcaStu) {
		oldAcaStu = childId;
	} else if (radioName == radioAcaScholar) {
		oldAcaScholar = childId;
	}
}

function enable(eleId, isDisabled) {
	var sel = document.getElementById(eleId);
	sel.disabled = isDisabled;
}