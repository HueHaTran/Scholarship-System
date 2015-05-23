package uit.se06.scholarshipweb.dao.proxy;

import uit.se06.scholarshipweb.dao.factory.DAOAbstractFactory;
import uit.se06.scholarshipweb.dao.factory.IAcademicLevelDAO;
import uit.se06.scholarshipweb.dao.factory.IAcademicLevelDetailDAO;
import uit.se06.scholarshipweb.dao.factory.ICountryDAO;
import uit.se06.scholarshipweb.dao.factory.IDisabilityDAO;
import uit.se06.scholarshipweb.dao.factory.IEthnicDAO;
import uit.se06.scholarshipweb.dao.factory.IFamilyPolicyDAO;
import uit.se06.scholarshipweb.dao.factory.IFormOfParticipationDAO;
import uit.se06.scholarshipweb.dao.factory.IGenderDAO;
import uit.se06.scholarshipweb.dao.factory.IMajorDAO;
import uit.se06.scholarshipweb.dao.factory.IProvinceDAO;
import uit.se06.scholarshipweb.dao.factory.IReligionDAO;
import uit.se06.scholarshipweb.dao.factory.IScholarshipDAO;
import uit.se06.scholarshipweb.dao.factory.IScholarshipTypeDAO;
import uit.se06.scholarshipweb.dao.factory.ISchoolDAO;
import uit.se06.scholarshipweb.dao.factory.ISponsorDAO;
import uit.se06.scholarshipweb.dao.factory.ITalentDAO;
import uit.se06.scholarshipweb.dao.factory.ITerminalIllDAO;
import uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc.DAJdbcAcademicLevelDAO;
import uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc.DAJdbcAcademicLevelDetailDAO;
import uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc.DAJdbcCountryDAO;
import uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc.DAJdbcDisabilityDAO;
import uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc.DAJdbcEthnicDAO;
import uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc.DAJdbcFamilyPolicyDAO;
import uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc.DAJdbcFormOfParticipationDAO;
import uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc.DAJdbcGenderDAO;
import uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc.DAJdbcMajorDAO;
import uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc.DAJdbcProvinceDAO;
import uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc.DAJdbcReligionDAO;
import uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc.DAJdbcScholarshipDAO;
import uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc.DAJdbcScholarshipTypeDAO;
import uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc.DAJdbcSchoolDAO;
import uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc.DAJdbcSponsorDAO;
import uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc.DAJdbcTalentDAO;
import uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc.DAJdbcTerminalIllDAO;

public class DAJdbcDAOFactory extends DAOAbstractFactory {

	@Override
	public IAcademicLevelDAO getAcademicLevelDAO() {
		return new DAJdbcAcademicLevelDAO();
	}

	@Override
	public IAcademicLevelDetailDAO getAcademicLevelDetailDAO() {
		return new DAJdbcAcademicLevelDetailDAO();
	}

	@Override
	public ICountryDAO getCountryDAO() {
		return new DAJdbcCountryDAO();
	}

	@Override
	public IDisabilityDAO getDisabilityDAO() {
		return new DAJdbcDisabilityDAO();
	}

	@Override
	public IEthnicDAO getEthnicDAO() {
		return new DAJdbcEthnicDAO();
	}

	@Override
	public IFamilyPolicyDAO getFamilyPolicyDAO() {
		return new DAJdbcFamilyPolicyDAO();
	}

	@Override
	public IFormOfParticipationDAO getFormOfParticipationDAO() {
		return new DAJdbcFormOfParticipationDAO();
	}

	@Override
	public IGenderDAO getGenderDAO() {
		return new DAJdbcGenderDAO();
	}

	@Override
	public IMajorDAO getMajorDAO() {
		return new DAJdbcMajorDAO();
	}

	@Override
	public IProvinceDAO getProvinceDAO() {
		return new DAJdbcProvinceDAO();
	}

	@Override
	public IReligionDAO getReligionDAO() {
		return new DAJdbcReligionDAO();
	}

	@Override
	public IScholarshipDAO getScholarshipDAO() {
		return new DAJdbcScholarshipDAO();
	}

	@Override
	public IScholarshipTypeDAO getScholarshipTypeDAO() {
		return new DAJdbcScholarshipTypeDAO();
	}

	@Override
	public ISchoolDAO getSchoolDAO() {
		return new DAJdbcSchoolDAO();
	}

	@Override
	public ISponsorDAO getSponsorDAO() {
		return new DAJdbcSponsorDAO();
	}

	@Override
	public ITalentDAO getTalentDAO() {
		return new DAJdbcTalentDAO();
	}

	@Override
	public ITerminalIllDAO getTerminalIllDAO() {
		return new DAJdbcTerminalIllDAO();
	}

}
