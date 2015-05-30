function clickNextFilter(currentElementId, nextElementId, nextIndex) {
	// hide current field set
	var currentFieldset = document.getElementById(currentElementId);
	currentFieldset.style.display = "none";

	// display next field set
	var next = document.getElementById(nextElementId);
	next.style.display = "block";

	// mark on progress bar
	var id = "progressbar" + nextIndex;
	var currentStep = document.getElementById(id);
	if (currentStep.className.indexOf("active") == -1) {// not contain word
		currentStep.className += ' active'; // note the space
	}
}

function clickPrevFilter(currentElementId, prevElementId, prevIndex) {
	// hide current field set
	var currentFieldset = document.getElementById(currentElementId);
	currentFieldset.style.display = "none";

	// display previous field set
	var prev = document.getElementById(prevElementId);
	prev.style.display = "block";

	// mark on progress bar
	var id = "progressbar" + (prevIndex + 1);
	var currentStep = document.getElementById(id);
	if (currentStep.className.indexOf("active") != -1) {// contain word
		currentStep.className = currentStep.className.replace("active", "");
	}
}

function clickFilter(index, total) {
	// field set
	for (var i = 1, len = total; i <= len; i++) {
		var currentFieldset = document.getElementById("filter" + i);
		if (i != index) {
			// hide all
			currentFieldset.style.display = "none";
		} else {
			// except from the chosen one
			currentFieldset.style.display = "block";
		}
	}

	// progress bar
	// display all 'li' from index '0' to 'current one'
	for (var i = 1, len = index; i <= len; i++) {
		var currentStep = document.getElementById("progressbar" + i);
		if (currentStep.className.indexOf("active") == -1) {// not contain word
			currentStep.className += ' active'; // note the space
		}
	}
	// hide all 'li' from index 'next one' to 'total'
	for (var i = index + 1, len = total; i <= len; i++) {
		var currentStep = document.getElementById("progressbar" + i);
		if (currentStep.className.indexOf("active") != -1) {// contain word
			currentStep.className = currentStep.className.replace("active", "");
		}
	}
}

function clickSubmitFilter(currentElementId) {
	var tempReligion = 0;
	var tempStuAca, tempStuAcaDetail = 0;
	var tempScholarAca, tempScholarAcaDetail = 0;

	if (existInputName("meta_data_religion")) {
		tempReligion = getCheckedRadioValue("meta_data_religion");
	} else if (existDocumentId("combobox_religion")) {
		tempReligion = getComboboxValue("combobox_religion");
	}

	tempStuAca = getCheckedRadioValue("meta_data_student_aca");
	if (existDocumentId("combo_student_aca_" + tempStuAca)) {
		tempStuAcaDetail = getComboboxValue("combo_student_aca_" + tempStuAca);
	}

	tempScholarAca = getCheckedRadioValue("meta_data_scholarship_aca");
	if (existDocumentId("combo_scholarship_aca_" + tempScholarAca)) {
		tempScholarAcaDetail = getComboboxValue("combo_scholarship_aca_"
				+ tempScholarAca);
	}

	var data = {
		stuGender : getCheckedRadioValue("meta_data_gender"),
		stuCitizenship : getComboboxValue("combobox_citizenship"),
		stuResidenceCity : getComboboxValue("combobox_residence_province"),
		stuResidenceProvince : getComboboxValue("combobox_residence_province"),
		stuReligion : tempReligion,
		stuDisabilities : getSelectedOptions("combobox_disability"),
		stuTerminalIllnesses : getSelectedOptions("combobox_terminal_ill"),
		familyPolicy : getSelectedOptions("combobox_family_policy"),

		stuAca : tempStuAca,
		stuAcaDetail : tempStuAcaDetail,
		scholarAca : tempScholarAca,
		scholarAcaDetails : tempScholarAcaDetail,
		scholarMajors : getSelectedOptions("combobox_major"),

		scholarType : getComboboxValue("combobox_scholarship_type"),
		talents : getSelectedOptions("combobox_talent"),
	}

	$
			.ajax({
				type : "POST",
				contentType : "application/json",
				url : "./getFilterResult",
				data : JSON.stringify(data),
				dataType : "text",
				success : function(msg) {
					data = JSON.parse(msg);
					if (msg != "false") {

						// ============== user interface ======================
						// hide current field set
						var currentFieldset = document
								.getElementById(currentElementId);
						currentFieldset.style.display = "none";

						// display final field set
						var next = document.getElementById("filter4");
						next.style.display = "block";

						// mark on progress bar
						for (var i = 1; i <= 4; i++) {
							var id = "progressbar" + i;
							var step = document.getElementById(id);
							if (step.className.indexOf("active") == -1) {// not
								// contain
								// word
								step.className += ' active'; // note the
								// space
							}
						}

					}
				},
				error : function() {
					alert("Error retrieving data!");
				}
			});

}

// ==================================================================
// Utilities
// ==================================================================

function getCheckedRadioValue(name) {
	var elements = document.getElementsByName(name);

	for (var i = 0, len = elements.length; i < len; ++i) {
		if (elements[i].checked) {
			return elements[i].value;
		}
	}
}

function getComboboxValue(id) {
	var element = document.getElementById(id);
	return element.options[element.selectedIndex].value;

}

function getSelectedOptions(id) {
	var sel = document.getElementById(id);
	var opts = [], opt;

	// loop through options in select list
	for (var i = 0, len = sel.options.length; i < len; i++) {
		opt = sel.options[i];

		// check if selected
		if (opt.selected) {
			opts.push(opt.value);
		}
	}
	return opts;
}

function existDocumentId(id) {
	if ($('#' + id).length > 0) {
		// exist
		return true;
	} else {
		// not exist
		return false;
	}
}

function existInputName(name) {
	if (!document.getElementsByName(name)) {
		return false;
	} else {
		return true;
	}
}