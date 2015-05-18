package uit.se06.scholarshipweb.viewmodel;

import java.util.ArrayList;
import java.util.List;

import uit.se06.scholarshipweb.model.AcademicLevel;
import uit.se06.scholarshipweb.model.Major;

public class FilterAcademicLevel {

	// ============================================================
	// VARIABLES
	// ============================================================

	private List<AcademicLevel> academicLevels;
	private List<Major> majors;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public FilterAcademicLevel() {
		setAcademicLevels(new ArrayList<AcademicLevel>());
		setMajors(new ArrayList<Major>());
	}

	// ============================================================
	// GETTERS & SETTERS
	// ============================================================

	public List<AcademicLevel> getAcademicLevels() {
		return academicLevels;
	}

	public void setAcademicLevels(List<AcademicLevel> academicLevels) {
		this.academicLevels = academicLevels;
	}

	public List<Major> getMajors() {
		return majors;
	}

	public void setMajors(List<Major> majorss) {
		this.majors = majorss;
	}

}
