package uit.se06.scholarshipweb.viewmodel;

import java.util.ArrayList;
import java.util.List;

import uit.se06.scholarshipweb.model.ISimpleModel;

public class ListFilterPersonalInfo {

	// ============================================================
	// VARIABLES
	// ============================================================

	private List<? extends ISimpleModel> genders;
	private List<? extends ISimpleModel> religion;
	private List<? extends ISimpleModel> countries;
	private List<? extends ISimpleModel> provinces;
	private List<? extends ISimpleModel> disabilities;
	private List<? extends ISimpleModel> terminalIllnesses;
	private List<? extends ISimpleModel> familyPolicies;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public ListFilterPersonalInfo() {
		genders = new ArrayList<ISimpleModel>();
		religion = new ArrayList<ISimpleModel>();
		countries = new ArrayList<ISimpleModel>();
		provinces = new ArrayList<ISimpleModel>();
		disabilities = new ArrayList<ISimpleModel>();
		terminalIllnesses = new ArrayList<ISimpleModel>();
		familyPolicies = new ArrayList<ISimpleModel>();
	}

	// ============================================================
	// GETTERS & SETTERS
	// ============================================================

	public List<? extends ISimpleModel> getGenders() {
		return genders;
	}

	public void setGenders(List<? extends ISimpleModel> genders) {
		this.genders = genders;
	}

	public List<? extends ISimpleModel> getReligion() {
		return religion;
	}

	public void setReligion(List<? extends ISimpleModel> religion) {
		this.religion = religion;
	}

	public List<? extends ISimpleModel> getCountries() {
		return countries;
	}

	public void setCountries(List<? extends ISimpleModel> countries) {
		this.countries = countries;
	}

	public List<? extends ISimpleModel> getProvinces() {
		return provinces;
	}

	public void setProvinces(List<? extends ISimpleModel> provinces) {
		this.provinces = provinces;
	}

	public List<? extends ISimpleModel> getDisabilities() {
		return disabilities;
	}

	public void setDisabilities(List<? extends ISimpleModel> disabilities) {
		this.disabilities = disabilities;
	}

	public List<? extends ISimpleModel> getTerminalIllnesses() {
		return terminalIllnesses;
	}

	public void setTerminalIllnesses(
			List<? extends ISimpleModel> terminalIllnesses) {
		this.terminalIllnesses = terminalIllnesses;
	}

	public List<? extends ISimpleModel> getFamilyPolicies() {
		return familyPolicies;
	}

	public void setFamilyPolicies(List<? extends ISimpleModel> familyPolicies) {
		this.familyPolicies = familyPolicies;
	}
}
