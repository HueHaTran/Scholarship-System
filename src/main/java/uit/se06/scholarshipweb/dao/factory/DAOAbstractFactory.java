package uit.se06.scholarshipweb.dao.factory;

public abstract class DAOAbstractFactory {

	// ============================================================
	// VARIABLES
	// ============================================================

	public static DAOAbstractFactory INS;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	protected DAOAbstractFactory() {
	}

	// ============================================================
	// METHODS
	// ============================================================

	public abstract IAcademicLevelDAO getAcademicLevelDAO();

	public abstract IAcademicLevelDetailDAO getAcademicLevelDetailDAO();

	public abstract ICountryDAO getCountryDAO();

	public abstract IDisabilityDAO getDisabilityDAO();

	public abstract IEthnicDAO getEthnicDAO();

	public abstract IFamilyPolicyDAO getFamilyPolicyDAO();

	public abstract IFormOfParticipationDAO getFormOfParticipationDAO();

	public abstract IGenderDAO getGenderDAO();

	public abstract IMajorDAO getMajorDAO();

	public abstract IProvinceDAO getProvinceDAO();

	public abstract IReligionDAO getReligionDAO();

	public abstract IScholarshipDAO getScholarshipDAO();

	public abstract IScholarshipTypeDAO getScholarshipTypeDAO();

	public abstract ISchoolDAO getSchoolDAO();

	public abstract ISponsorDAO getSponsorDAO();

	public abstract ITalentDAO getTalentDAO();

	public abstract ITerminalIllDAO getTerminalIllDAO();

}
