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
import uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc.JdbcAcademicLevelDAO;
import uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc.JdbcAcademicLevelDetailDAO;
import uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc.JdbcCountryDAO;
import uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc.JdbcDisabilityDAO;
import uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc.JdbcEthnicDAO;
import uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc.JdbcFamilyPolicyDAO;
import uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc.JdbcFormOfParticipationDAO;
import uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc.JdbcGenderDAO;
import uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc.JdbcMajorDAO;
import uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc.JdbcProvinceDAO;
import uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc.JdbcReligionDAO;
import uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc.JdbcScholarshipDAO;
import uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc.JdbcScholarshipTypeDAO;
import uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc.JdbcSchoolDAO;
import uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc.JdbcSponsorDAO;
import uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc.JdbcTalentDAO;
import uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc.JdbcTerminalIllDAO;

public class JdbcDAOConnectionFactory extends DAOAbstractFactory {

	@Override
	public IAcademicLevelDAO getAcademicLevelDAO() {
		return new JdbcAcademicLevelDAO();
	}

	@Override
	public IAcademicLevelDetailDAO getAcademicLevelDetailDAO() {
		return new JdbcAcademicLevelDetailDAO();
	}

	@Override
	public ICountryDAO getCountryDAO() {
		return new JdbcCountryDAO();
	}

	@Override
	public IDisabilityDAO getDisabilityDAO() {
		return new JdbcDisabilityDAO();
	}

	@Override
	public IEthnicDAO getEthnicDAO() {
		return new JdbcEthnicDAO();
	}

	@Override
	public IFamilyPolicyDAO getFamilyPolicyDAO() {
		return new JdbcFamilyPolicyDAO();
	}

	@Override
	public IFormOfParticipationDAO getFormOfParticipationDAO() {
		return new JdbcFormOfParticipationDAO();
	}

	@Override
	public IGenderDAO getGenderDAO() {
		return new JdbcGenderDAO();
	}

	@Override
	public IMajorDAO getMajorDAO() {
		return new JdbcMajorDAO();
	}

	@Override
	public IProvinceDAO getProvinceDAO() {
		return new JdbcProvinceDAO();
	}

	@Override
	public IReligionDAO getReligionDAO() {
		return new JdbcReligionDAO();
	}

	@Override
	public IScholarshipDAO getScholarshipDAO() {
		return new JdbcScholarshipDAO();
	}

	@Override
	public IScholarshipTypeDAO getScholarshipTypeDAO() {
		return new JdbcScholarshipTypeDAO();
	}

	@Override
	public ISchoolDAO getSchoolDAO() {
		return new JdbcSchoolDAO();
	}

	@Override
	public ISponsorDAO getSponsorDAO() {
		return new JdbcSponsorDAO();
	}

	@Override
	public ITalentDAO getTalentDAO() {
		return new JdbcTalentDAO();
	}

	@Override
	public ITerminalIllDAO getTerminalIllDAO() {
		return new JdbcTerminalIllDAO();
	}

}
