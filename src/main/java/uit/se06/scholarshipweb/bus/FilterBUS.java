package uit.se06.scholarshipweb.bus;

import java.util.ArrayList;

import uit.se06.scholarshipweb.dao.factory.DAOAbstractFactory;
import uit.se06.scholarshipweb.model.Province;
import uit.se06.scholarshipweb.viewmodel.FilterAcademicLevel;
import uit.se06.scholarshipweb.viewmodel.FilterPersonalInfo;
import uit.se06.scholarshipweb.viewmodel.FilterScholarshipType;

public class FilterBUS {

	private GenderBUS busGender;
	private DisabilityBUS busDisability;
	private TerminalIllBUS busTerminalIll;
	private FamilyPolicyBUS busFamilyPolicy;
	private CountryBUS busCountry;
	private ReligionBUS busReligion;

	private AcademicLevelBUS busAcademicLevel;
	private MajorBUS busMajor;

	private ScholarshipTypeBUS busScholarshipType;
	private TalentBUS busTalent;

	public FilterBUS() {
		if (DAOAbstractFactory.INS == null) {
			System.err.print("NULL!!!!!!!!!!!!!!!!!!!!!");
		}

		busGender = new GenderBUS();
		busDisability = new DisabilityBUS();
		busTerminalIll = new TerminalIllBUS();
		busFamilyPolicy = new FamilyPolicyBUS();
		busCountry = new CountryBUS();
		busReligion = new ReligionBUS();

		busAcademicLevel = new AcademicLevelBUS();
		busMajor = new MajorBUS();

		busScholarshipType = new ScholarshipTypeBUS();
		busTalent = new TalentBUS();
	}

	/**
	 * 
	 * @return
	 */
	public FilterPersonalInfo getPersonalInfo() {
		FilterPersonalInfo result = new FilterPersonalInfo();

		result.setCountries(busCountry.list());
		result.setDisabilities(busDisability.list());
		result.setFamilyPolicies(busFamilyPolicy.list());
		result.setGenders(busGender.list());
		result.setReligion(busReligion.list());
		result.setProvinces(new ArrayList<Province>());
		result.setTerminalIllnesses(busTerminalIll.list());

		return result;
	}

	public FilterAcademicLevel getAcademicLevelInfo() {
		FilterAcademicLevel result = new FilterAcademicLevel();
		result.setAcademicLevels(busAcademicLevel.listWithDetails());
		result.setMajors(busMajor.list());

		return result;
	}

	public FilterScholarshipType getScholarshipTypeInfo() {
		FilterScholarshipType result = new FilterScholarshipType();
		result.setScholarshipTypes(busScholarshipType.list());
		result.setTalents(busTalent.list());

		return result;
	}
}
