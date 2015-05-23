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
import uit.se06.scholarshipweb.viewmodel.FilterAcademicLevel;
import uit.se06.scholarshipweb.viewmodel.FilterPersonalInfo;
import uit.se06.scholarshipweb.viewmodel.FilterScholarshipType;

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