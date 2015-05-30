package uit.se06.scholarshipweb.bus.factory;

public abstract class BUSAbstractFactory {

	// ============================================================
	// VARIABLES
	// ============================================================

	public static BUSAbstractFactory INS;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	protected BUSAbstractFactory() {

	}

	// ============================================================
	// METHODS
	// ============================================================

	public abstract ISearchBUS getSearchBUS();

	public abstract IAcademicLevelBUS getAcademicLevelBUS();

	public abstract ICountryBUS getCountryBUS();

	public abstract IDisabilityBUS getDisabilityBUS();

	public abstract IEthnicBUS getEthnicBUS();

	public abstract IFamilyPolicyBUS getFamilyPolicyBUS();

	public abstract IFormOfParticipationBUS getFormOfParticipationBUS();

	public abstract IGenderBUS getGenderBUS();

	public abstract IMajorBUS getMajorBUS();

	public abstract IReligionBUS getReligionBUS();

	public abstract IScholarshipBUS getScholarshipBUS();

	public abstract IScholarshipTypeBUS getScholarshipTypeBUS();

	public abstract ISchoolBUS getSchoolBUS();

	public abstract ISponsorBUS getSponsorBUS();

	public abstract ITalentBUS getTalentBUS();

	public abstract ITerminalIllBUS getTerminalIllBUS();

}
