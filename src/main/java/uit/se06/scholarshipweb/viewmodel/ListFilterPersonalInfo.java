package uit.se06.scholarshipweb.viewmodel;

import java.util.ArrayList;
import java.util.List;

import uit.se06.scholarshipweb.model.Country;
import uit.se06.scholarshipweb.model.Disability;
import uit.se06.scholarshipweb.model.FamilyPolicy;
import uit.se06.scholarshipweb.model.Gender;
import uit.se06.scholarshipweb.model.Province;
import uit.se06.scholarshipweb.model.Religion;
import uit.se06.scholarshipweb.model.TerminalIll;

public class ListFilterPersonalInfo {

	// ============================================================
	// VARIABLES
	// ============================================================

	private List<Gender> genders;
	private List<Religion> religion;
	private List<Country> countries;
	private List<Province> provinces;
	private List<Disability> disabilities;
	private List<TerminalIll> terminalIllnesses;
	private List<FamilyPolicy> familyPolicies;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public ListFilterPersonalInfo() {
		genders = new ArrayList<Gender>();
		religion = new ArrayList<Religion>();
		countries = new ArrayList<Country>();
		provinces = new ArrayList<Province>();
		disabilities = new ArrayList<Disability>();
		terminalIllnesses = new ArrayList<TerminalIll>();
		familyPolicies = new ArrayList<FamilyPolicy>();
	}

	// ============================================================
	// GETTERS & SETTERS
	// ============================================================

	public List<Gender> getGenders() {
		return genders;
	}

	public void setGenders(List<Gender> genders) {
		this.genders = genders;
	}

	public List<Religion> getReligion() {
		return religion;
	}

	public void setReligion(List<Religion> religion) {
		this.religion = religion;
	}

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

	public List<Province> getProvinces() {
		return provinces;
	}

	public void setProvinces(List<Province> provinces) {
		this.provinces = provinces;
	}

	public List<Disability> getDisabilities() {
		return disabilities;
	}

	public void setDisabilities(List<Disability> disabilities) {
		this.disabilities = disabilities;
	}

	public List<TerminalIll> getTerminalIllnesses() {
		return terminalIllnesses;
	}

	public void setTerminalIllnesses(List<TerminalIll> terminalIllnesses) {
		this.terminalIllnesses = terminalIllnesses;
	}

	public List<FamilyPolicy> getFamilyPolicies() {
		return familyPolicies;
	}

	public void setFamilyPolicies(List<FamilyPolicy> familyPolicies) {
		this.familyPolicies = familyPolicies;
	}
}
