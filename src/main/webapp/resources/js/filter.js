var offset = -100;

function clickNextFilter(nextIndex) {
	var section = "#filter-section" + nextIndex;

	$('html, body').animate({
		scrollTop : $(section).offset().top + offset
	}, 1000);

	// mark on progress bar
	var id = "progressbar" + nextIndex;
	var currentStep = document.getElementById(id);
	if (currentStep.className.indexOf("active") == -1) {// not contain word
		currentStep.className += ' active'; // note the space
	}
}

function clickPrevFilter(prevIndex) {
	var section = "#filter-section" + prevIndex;

	$('html, body').animate({
		scrollTop : $(section).offset().top + offset
	}, 1000);

	// mark on progress bar
	var id = "progressbar" + (prevIndex + 1);
	var currentStep = document.getElementById(id);
	if (currentStep.className.indexOf("active") != -1) {// contain word
		currentStep.className = currentStep.className.replace("active", "");
	}
}

function clickFilter(index, total) {
	var section = "#filter-section" + index;

	$('html, body').animate({
		scrollTop : $(section).offset().top + offset
	}, 1000);
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

function clickSubmitFilter() {
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
		stuGender : getCheckedRadioValue("meta_data_gender"),// p1
		stuCitizenship : getComboboxValue("combobox_citizenship"),// p2
		stuResidenceCity : getComboboxValue("combobox_residence_province"),// p3
		stuResidenceProvince : getComboboxValue("combobox_residence_province"),// p4
		stuReligion : tempReligion,// p5
		stuDisabilities : getSelectedOptions("combobox_disability"),// p6
		stuTerminalIllnesses : getSelectedOptions("combobox_terminal_ill"),// p7
		familyPolicy : getSelectedOptions("combobox_family_policy"),// p8

		stuAca : tempStuAca,// p9
		stuAcaDetail : tempStuAcaDetail,// p10
		scholarAca : tempScholarAca,// p11
		scholarAcaDetails : tempScholarAcaDetail,// p12
		scholarMajors : getSelectedOptions("combobox_major"),// p13

		scholarType : getComboboxValue("combobox_scholarship_type"),// p14
		talents : getSelectedOptions("combobox_talent"),// p15
	}

	// get link
	var prefix = location.protocol + "//" + location.host;

	if (prefix.indexOf("scholar") == -1) {
		var pathArray = location.pathname.split('/');

		for (var i = 0; i < pathArray.length; i++) {
			if (pathArray[i].indexOf("scholar") != -1) {
				prefix = prefix + "/" + pathArray[i];
				break;
			}
		}
	}

	var link = prefix + "/filterResult?";// p1=" + text + "&pageNum=1";

	// set parameters
	link = link + "p1=" + data.stuGender;
	link = link + "&p2=" + data.stuCitizenship;
	link = link + "&p3=" + data.stuResidenceCity;
	link = link + "&p4=" + data.stuResidenceProvince;
	link = link + "&p5=" + data.stuReligion;
	link = link + "&p6=" + getListStr(data.stuDisabilities);
	link = link + "&p7=" + getListStr(data.stuTerminalIllnesses);
	link = link + "&p8=" + getListStr(data.familyPolicy);
	link = link + "&p9=" + data.stuAca;
	link = link + "&p10=" + data.stuAcaDetail;
	link = link + "&p11=" + data.scholarAca;
	link = link + "&p12=" + data.scholarAcaDetails;
	link = link + "&p13=" + getListStr(data.scholarMajors);
	link = link + "&p14=" + data.scholarType;
	link = link + "&p15=" + getListStr(data.talents);

	link = link + "&pageNum=1" + "&resultTotal=0";

	window.open(link);
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

function getListStr(list) {
	if (list.length == 0) {
		return 0;
	}

	var result = list[0];

	// loop through options in select list
	for (var i = 1, len = list.length; i < len; i++) {
		result = result + "_" + list[i];
	}
	return result;
}