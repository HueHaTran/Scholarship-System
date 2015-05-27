package uit.se06.scholarshipweb.viewmodel;

import java.util.ArrayList;
import java.util.List;

import uit.se06.scholarshipweb.model.ScholarshipType;
import uit.se06.scholarshipweb.model.Talent;

public class ListFilterScholarshipType {

	// ============================================================
	// VARIABLES
	// ============================================================

	private List<ScholarshipType> scholarshipTypes;
	private List<Talent> talents;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public ListFilterScholarshipType() {
		scholarshipTypes = new ArrayList<ScholarshipType>();
		talents = new ArrayList<Talent>();
	}

	// ============================================================
	// GETTERS & SETTERS
	// ============================================================

	public List<ScholarshipType> getScholarshipTypes() {
		return scholarshipTypes;
	}

	public void setScholarshipTypes(List<ScholarshipType> scholarshipTypes) {
		this.scholarshipTypes = scholarshipTypes;
	}

	public List<Talent> getTalents() {
		return talents;
	}

	public void setTalents(List<Talent> talents) {
		this.talents = talents;
	}
}
