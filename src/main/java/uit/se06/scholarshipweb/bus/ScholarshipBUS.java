package uit.se06.scholarshipweb.bus;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.bus.util.Utility;
import uit.se06.scholarshipweb.dao.IScholarshipDAO;
import uit.se06.scholarshipweb.dao.impl.JdbcScholarshipDAO;
import uit.se06.scholarshipweb.model.Scholarship;
import uit.se06.scholarshipweb.model.School;
import uit.se06.scholarshipweb.model.Sponsor;
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
		dao = new JdbcScholarshipDAO(sessionFactory);
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

		OverviewScholarshipViewModel entity = new OverviewScholarshipViewModel();

		// get
		List<Sponsor> sponsors = scholarship.getSponsors();
		School school = scholarship.getSchool();

		int min = scholarship.getValueMin();
		int max = scholarship.getValueMax();

		// set
		entity.setId(scholarship.getId());
		entity.setName(Utility.getIns().getNameString(scholarship));
		entity.setDateEndRegister(Utility.getIns().getDateString(
				scholarship.getDateEndRegister()));
		entity.setSponsorNames(Utility.getIns().getNamesString(sponsors));
		entity.setSchoolName(Utility.getIns().getNameString(school));
		entity.setValue(Utility.getIns().getMoneyString(min, max));

		return entity;
	}

	private ScholarshipViewModel convertToViewModel(Scholarship scholarship) {
		if (scholarship == null) {
			return null;
		}

		ScholarshipViewModel entity = new ScholarshipViewModel();
		entity.setId(scholarship.getId());
		entity.setName(Utility.getIns().getNameString(scholarship));
		entity.setDescription(Utility.getIns().getFormatString(
				scholarship.getDescription()));
		entity.setOriginalLink(Utility.getIns().getFormatString(
				scholarship.getOriginal_link()));
		entity.setApplicationDescription(Utility.getIns().getFormatString(
				scholarship.getApplicationDescription()));
		entity.setCount(Utility.getIns().getFormatNumberString(
				scholarship.getCount()));
		entity.setDateEndRegister(Utility.getIns().getDateString(
				scholarship.getDateEndRegister()));
		entity.setFormOfParticipation(Utility.getIns().getNameString(
				scholarship.getFormOfParticipation()));
		entity.setScholarshipAcademicLevelDetail(Utility
				.getIns()
				.getNamesString(scholarship.getScholarshipAcademicLevelDetail()));
		entity.setScholarshipMajors(Utility.getIns().getNamesString(
				scholarship.getScholarshipMajors()));
		entity.setScholarshipType(Utility.getIns().getNameString(
				scholarship.getScholarshipType()));
		entity.setSchoolName(Utility.getIns().getNameString(
				scholarship.getSchool()));
		entity.setSponsorNames(Utility.getIns().getNamesString(
				scholarship.getSponsors()));
		entity.setStudentAcademicLevelDetail(Utility.getIns().getNameString(
				scholarship.getStudentAcademicLevelDetail()));
		entity.setStudentCitizenship(Utility.getIns().getNameString(
				scholarship.getStudentCitizenship()));
		entity.setStudentDisabilities(Utility.getIns().getNamesString(
				scholarship.getStudentDisabilities()));
		entity.setStudentEthnic(Utility.getIns().getNameString(
				scholarship.getStudentEthnic()));
		entity.setStudentFamilyPolicies(Utility.getIns().getNamesString(
				scholarship.getStudentFamilyPolicies()));
		entity.setStudentGender(Utility.getIns().getNameString(
				scholarship.getStudentGender()));
		entity.setStudentReligion(Utility.getIns().getNameString(
				scholarship.getStudentReligion()));
		entity.setStudentResidences(Utility.getIns().getNamesString(
				scholarship.getStudentResidences()));
		entity.setStudentTalents(Utility.getIns().getNamesString(
				scholarship.getStudentTalents()));
		entity.setStudentTerminalIllnesses(Utility.getIns().getNamesString(
				scholarship.getStudentTerminalIllnesses()));
		entity.setSupportDescription(Utility.getIns().getFormatString(
				scholarship.getSupportDescription()));
		entity.setValue(Utility.getIns().getMoneyString(
				scholarship.getValueMin(), scholarship.getValueMax()));

		return entity;
	}
}
