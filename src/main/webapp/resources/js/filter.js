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
	for (var i = index+1, len = total; i <= len; i++) {
		var currentStep = document.getElementById("progressbar" + i);
		if (currentStep.className.indexOf("active") != -1) {// contain word
			currentStep.className = currentStep.className.replace("active", "");
		}
	}

}
