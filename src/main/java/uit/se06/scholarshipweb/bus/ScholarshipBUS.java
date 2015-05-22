package uit.se06.scholarshipweb.bus;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.bus.util.Utility;
import uit.se06.scholarshipweb.dao.factory.DAOAbstractFactory;
import uit.se06.scholarshipweb.dao.factory.IScholarshipDAO;
import uit.se06.scholarshipweb.model.Scholarship;
import uit.se06.scholarshipweb.model.ScholarshipSpecification;
import uit.se06.scholarshipweb.model.School;
import uit.se06.scholarshipweb.viewmodel.OverviewScholarshipViewModel;
import uit.se06.scholarshipweb.viewmodel.ScholarshipViewModel;

public class ScholarshipBUS {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(ScholarshipBUS.class);

	private IScholarshipDAO dao;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public ScholarshipBUS(SessionFactory sessionFactory) {
		dao = DAOAbstractFactory.INS.getScholarshipDAO();
	}

	// ============================================================
	// MAIN METHODS
	// ============================================================

	public ScholarshipViewModel findById(int id) {
		Scholarship scholarship = dao.findById(id);
		if (scholarship == null) {
			logger.info("Warning in: " + "findById(" + id + ")"
					+ " return null.");
			return null;
		}

		ScholarshipViewModel entity = convertToViewModel(scholarship);
		return entity;
	}

	public ScholarshipViewModel findByName(String name) {
		Scholarship scholarship = dao.findByName(name);
		if (scholarship == null) {
			logger.info("Warning in: " + "findByName(" + name + ")"
					+ " return null.");
			return null;
		}

		ScholarshipViewModel entity = convertToViewModel(scholarship);
		return entity;
	}

	public List<Scholarship> list() {
		List<Scholarship> result = dao.list();
		if (result == null || (result != null && result.isEmpty())) {
			logger.info("Warning in: " + "list()" + " return null or empty.");
		}
		return result;
	}

	public OverviewScholarshipViewModel findOverviewById(int id) {
		Scholarship scholarship = dao.findShortInfoById(id);
		return convertToOverviewViewModel(scholarship);
	}

	// ============================================================
	// UTILITIES
	// ============================================================

	public OverviewScholarshipViewModel convertToOverviewViewModel(
			Scholarship scholarship) {
		if (scholarship == null) {
			return null;
		}

		ScholarshipSpecification specification = scholarship
				.getScholarshipSpecification();

		OverviewScholarshipViewModel entity = new OverviewScholarshipViewModel();

		// get
		School school = specification.getSchool();

		int min = scholarship.getValueMin();
		int max = scholarship.getValueMax();

		// set
		entity.setId(scholarship.getId());
		entity.setName(Utility.getIns().getNameString(scholarship));
		entity.setDateEndRegister(Utility.getIns().getDateString(
				scholarship.getDateEndRegister()));
		entity.setSchoolName(Utility.getIns().getNameString(school));
		entity.setValue(Utility.getIns().getMoneyString(min, max));

		return entity;
	}

	private ScholarshipViewModel convertToViewModel(Scholarship scholarship) {
		if (scholarship == null) {
			return null;
		}

		ScholarshipSpecification specification = scholarship
				.getScholarshipSpecification();

		ScholarshipViewModel entity = new ScholarshipViewModel();
		entity.setId(scholarship.getId());
		entity.setName(Utility.getIns().getNameString(scholarship));
		entity.setDescription(Utility.getIns().getFormatString(
				specification.getDescription()));
		entity.setOriginalLink(Utility.getIns().getFormatString(
				specification.getOriginal_link()));
		entity.setApplicationDescription(Utility.getIns().getFormatString(
				specification.getApplicationDescription()));
		entity.setCount(Utility.getIns().getFormatNumberString(
				specification.getCount()));
		entity.setDateEndRegister(Utility.getIns().getDateString(
				scholarship.getDateEndRegister()));
		entity.setFormOfParticipation(Utility.getIns().getNameString(
				specification.getFormOfParticipation()));
		entity.setScholarshipAcademicLevelDetail(Utility
				.getIns()
				.getNamesString(scholarship.getScholarshipAcademicLevelDetail()));
		entity.setScholarshipMajors(Utility.getIns().getNamesString(
				scholarship.getScholarshipMajors()));
		entity.setScholarshipType(Utility.getIns().getNameString(
				specification.getScholarshipType()));
		entity.setSchoolName(Utility.getIns().getNameString(
				specification.getSchool()));
		entity.setSponsorNames(Utility.getIns().getNamesString(
				scholarship.getSponsors()));
		entity.setStudentAcademicLevelDetail(Utility.getIns().getNameString(
				specification.getStudentAcademicLevelDetail()));
		entity.setStudentCitizenship(Utility.getIns().getNameString(
				specification.getStudentCitizenship()));
		entity.setStudentDisabilities(Utility.getIns().getNamesString(
				scholarship.getStudentDisabilities()));
		entity.setStudentEthnic(Utility.getIns().getNameString(
				specification.getStudentEthnic()));
		entity.setStudentFamilyPolicies(Utility.getIns().getNamesString(
				scholarship.getStudentFamilyPolicies()));
		entity.setStudentGender(Utility.getIns().getNameString(
				specification.getStudentGender()));
		entity.setStudentReligion(Utility.getIns().getNameString(
				specification.getStudentReligion()));
		entity.setStudentResidences(Utility.getIns().getNamesString(
				scholarship.getStudentResidences()));
		entity.setStudentTalents(Utility.getIns().getNamesString(
				scholarship.getStudentTalents()));
		entity.setStudentTerminalIllnesses(Utility.getIns().getNamesString(
				scholarship.getStudentTerminalIllnesses()));
		entity.setSupportDescription(Utility.getIns().getFormatString(
				specification.getSupportDescription()));
		entity.setValue(Utility.getIns().getMoneyString(
				scholarship.getValueMin(), scholarship.getValueMax()));

		return entity;
	}
}
