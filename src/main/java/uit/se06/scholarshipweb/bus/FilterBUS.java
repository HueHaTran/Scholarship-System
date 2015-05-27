package uit.se06.scholarshipweb.bus;

import java.util.ArrayList;

import uit.se06.scholarshipweb.bus.factory.BUSAbstractFactory;
import uit.se06.scholarshipweb.bus.factory.IAcademicLevelBUS;
import uit.se06.scholarshipweb.bus.factory.ICountryBUS;
import uit.se06.scholarshipweb.bus.factory.IDisabilityBUS;
import uit.se06.scholarshipweb.bus.factory.IFamilyPolicyBUS;
import uit.se06.scholarshipweb.bus.factory.IGenderBUS;
import uit.se06.scholarshipweb.bus.factory.IMajorBUS;
import uit.se06.scholarshipweb.bus.factory.IReligionBUS;
import uit.se06.scholarshipweb.bus.factory.IScholarshipTypeBUS;
import uit.se06.scholarshipweb.bus.factory.ITalentBUS;
import uit.se06.scholarshipweb.bus.factory.ITerminalIllBUS;
import uit.se06.scholarshipweb.model.Province;
import uit.se06.scholarshipweb.viewmodel.ListFilterAcademicLevel;
import uit.se06.scholarshipweb.viewmodel.ListFilterPersonalInfo;
import uit.se06.scholarshipweb.viewmodel.ListFilterScholarshipType;

public class FilterBUS {

	private IGenderBUS busGender;
	private IDisabilityBUS busDisability;
	private ITerminalIllBUS busTerminalIll;
	private IFamilyPolicyBUS busFamilyPolicy;
	private ICountryBUS busCountry;
	private IReligionBUS busReligion;

	private IAcademicLevelBUS busAcademicLevel;
	private IMajorBUS busMajor;

	private IScholarshipTypeBUS busScholarshipType;
	private ITalentBUS busTalent;

	public FilterBUS() {
		busGender = BUSAbstractFactory.INS.getGenderBUS();
		busDisability = BUSAbstractFactory.INS.getDisabilityBUS();
		busTerminalIll = BUSAbstractFactory.INS.getTerminalIllBUS();
		busFamilyPolicy = BUSAbstractFactory.INS.getFamilyPolicyBUS();
		busCountry = BUSAbstractFactory.INS.getCountryBUS();
		busReligion = BUSAbstractFactory.INS.getReligionBUS();

		busAcademicLevel = BUSAbstractFactory.INS.getAcademicLevelBUS();
		busMajor = BUSAbstractFactory.INS.getMajorBUS();

		busScholarshipType = BUSAbstractFactory.INS.getScholarshipTypeBUS();
		busTalent = BUSAbstractFactory.INS.getTalentBUS();
	}

	/**
	 * 
	 * @return
	 */
	public ListFilterPersonalInfo getPersonalInfo() {
		ListFilterPersonalInfo result = new ListFilterPersonalInfo();

		result.setCountries(busCountry.list());
		result.setDisabilities(busDisability.list());
		result.setFamilyPolicies(busFamilyPolicy.list());
		result.setGenders(busGender.list());
		result.setReligion(busReligion.list());
		result.setProvinces(new ArrayList<Province>());
		result.setTerminalIllnesses(busTerminalIll.list());

		return result;
	}

	public ListFilterAcademicLevel getAcademicLevelInfo() {
		ListFilterAcademicLevel result = new ListFilterAcademicLevel();
		result.setAcademicLevels(busAcademicLevel.listWithDetails());
		result.setMajors(busMajor.list());

		return result;
	}

	public ListFilterScholarshipType getScholarshipTypeInfo() {
		ListFilterScholarshipType result = new ListFilterScholarshipType();
		result.setScholarshipTypes(busScholarshipType.list());
		result.setTalents(busTalent.list());

		return result;
	}
}