package uit.se06.scholarshipweb.bus.proxy;

import uit.se06.scholarshipweb.bus.factory.BUSAbstractFactory;
import uit.se06.scholarshipweb.bus.factory.IAcademicLevelBUS;
import uit.se06.scholarshipweb.bus.factory.ICountryBUS;
import uit.se06.scholarshipweb.bus.factory.IDisabilityBUS;
import uit.se06.scholarshipweb.bus.factory.IEthnicBUS;
import uit.se06.scholarshipweb.bus.factory.IFamilyPolicyBUS;
import uit.se06.scholarshipweb.bus.factory.IFormOfParticipationBUS;
import uit.se06.scholarshipweb.bus.factory.IGenderBUS;
import uit.se06.scholarshipweb.bus.factory.IMajorBUS;
import uit.se06.scholarshipweb.bus.factory.IReligionBUS;
import uit.se06.scholarshipweb.bus.factory.IScholarshipBUS;
import uit.se06.scholarshipweb.bus.factory.IScholarshipTypeBUS;
import uit.se06.scholarshipweb.bus.factory.ISchoolBUS;
import uit.se06.scholarshipweb.bus.factory.ISearchBUS;
import uit.se06.scholarshipweb.bus.factory.ISponsorBUS;
import uit.se06.scholarshipweb.bus.factory.ITalentBUS;
import uit.se06.scholarshipweb.bus.factory.ITerminalIllBUS;
import uit.se06.scholarshipweb.bus.serviceprovider.da.DAAcademicLevelBUS;
import uit.se06.scholarshipweb.bus.serviceprovider.da.DACountryBUS;
import uit.se06.scholarshipweb.bus.serviceprovider.da.DADisabilityBUS;
import uit.se06.scholarshipweb.bus.serviceprovider.da.DAEthnicBUS;
import uit.se06.scholarshipweb.bus.serviceprovider.da.DAFamilyPolicyBUS;
import uit.se06.scholarshipweb.bus.serviceprovider.da.DAFormOfParticipationBUS;
import uit.se06.scholarshipweb.bus.serviceprovider.da.DAGenderBUS;
import uit.se06.scholarshipweb.bus.serviceprovider.da.DAMajorBUS;
import uit.se06.scholarshipweb.bus.serviceprovider.da.DAReligionBUS;
import uit.se06.scholarshipweb.bus.serviceprovider.da.DAScholarshipBUS;
import uit.se06.scholarshipweb.bus.serviceprovider.da.DAScholarshipTypeBUS;
import uit.se06.scholarshipweb.bus.serviceprovider.da.DASchoolBUS;
import uit.se06.scholarshipweb.bus.serviceprovider.da.DASearchBUS;
import uit.se06.scholarshipweb.bus.serviceprovider.da.DASponsorBUS;
import uit.se06.scholarshipweb.bus.serviceprovider.da.DATalentBUS;
import uit.se06.scholarshipweb.bus.serviceprovider.da.DATerminalIllBUS;

public class DirectAccessBUSFactory extends BUSAbstractFactory {

	@Override
	public ISearchBUS getSearchBUS() {
		return new DASearchBUS();
	}

	@Override
	public IAcademicLevelBUS getAcademicLevelBUS() {
		return new DAAcademicLevelBUS();
	}

	@Override
	public ICountryBUS getCountryBUS() {
		return new DACountryBUS();
	}

	@Override
	public IDisabilityBUS getDisabilityBUS() {
		return new DADisabilityBUS();
	}

	@Override
	public IEthnicBUS getEthnicBUS() {
		return new DAEthnicBUS();
	}

	@Override
	public IFamilyPolicyBUS getFamilyPolicyBUS() {
		return new DAFamilyPolicyBUS();
	}

	@Override
	public IFormOfParticipationBUS getFormOfParticipationBUS() {
		return new DAFormOfParticipationBUS();
	}

	@Override
	public IGenderBUS getGenderBUS() {
		return new DAGenderBUS();
	}

	@Override
	public IMajorBUS getMajorBUS() {
		return new DAMajorBUS();
	}

	@Override
	public IReligionBUS getReligionBUS() {
		return new DAReligionBUS();
	}

	@Override
	public IScholarshipBUS getScholarshipBUS() {
		return new DAScholarshipBUS();
	}

	@Override
	public IScholarshipTypeBUS getScholarshipTypeBUS() {
		return new DAScholarshipTypeBUS();
	}

	@Override
	public ISchoolBUS getSchoolBUS() {
		return new DASchoolBUS();
	}

	@Override
	public ISponsorBUS getSponsorBUS() {
		return new DASponsorBUS();
	}

	@Override
	public ITalentBUS getTalentBUS() {
		return new DATalentBUS();
	}

	@Override
	public ITerminalIllBUS getTerminalIllBUS() {
		return new DATerminalIllBUS();
	}

}
