package uit.se06.scholarshipweb.bus.serviceprovider.da;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.bus.factory.IScholarshipBUS;
import uit.se06.scholarshipweb.bus.util.Utility;
import uit.se06.scholarshipweb.dao.factory.DAOAbstractFactory;
import uit.se06.scholarshipweb.dao.factory.IDAO;
import uit.se06.scholarshipweb.dao.factory.IScholarshipDAO;
import uit.se06.scholarshipweb.model.Scholarship;
import uit.se06.scholarshipweb.model.ScholarshipSpecification;
import uit.se06.scholarshipweb.model.School;
import uit.se06.scholarshipweb.viewmodel.OverviewScholarshipViewModel;
import uit.se06.scholarshipweb.viewmodel.ScholarshipViewModel;

public class DAScholarshipBUS extends DABaseBUS<Scholarship> implements
		IScholarshipBUS {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(DAScholarshipBUS.class);

	private IScholarshipDAO dao;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public DAScholarshipBUS() {
		dao = DAOAbstractFactory.INS.getScholarshipDAO();
	}

	// ============================================================
	// MAIN METHODS
	// ============================================================

	@Override
	public ScholarshipViewModel findViewModelById(int id) {
		Scholarship scholarship = findById(id);
		ScholarshipViewModel entity = convertToViewModel(scholarship);
		return entity;
	}

	@Override
	public ScholarshipViewModel findViewModelByName(String name) {
		Scholarship scholarship = findByName(name);

		ScholarshipViewModel entity = convertToViewModel(scholarship);
		return entity;
	}

	@Override
	public OverviewScholarshipViewModel findOverviewById(int id) {
		Scholarship scholarship = dao.findShortInfoById(id);
		return convertToOverviewViewModel(scholarship);
	}

	@Override
	protected IDAO<Scholarship> getDAO() {
		return dao;
	}

	@Override
	protected Logger getLogger() {
		return logger;
	}

	// ============================================================
	// UTILITIES
	// ============================================================

	@Override
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
		entity.setScholarshipAcademicLevelDetail(Utility.getIns()
				.getNamesString(
						specification.getScholarshipAcademicLevelDetail()));
		entity.setScholarshipMajors(Utility.getIns().getNamesString(
				specification.getScholarshipMajors()));
		entity.setScholarshipType(Utility.getIns().getNameString(
				specification.getScholarshipType()));
		entity.setSchoolName(Utility.getIns().getNameString(
				specification.getSchool()));
		entity.setSponsorNames(Utility.getIns().getNamesString(
				specification.getSponsors()));
		entity.setStudentAcademicLevelDetail(Utility.getIns().getNameString(
				specification.getStudentAcademicLevelDetail()));
		entity.setStudentCitizenship(Utility.getIns().getNameString(
				specification.getStudentCitizenship()));
		entity.setStudentDisabilities(Utility.getIns().getNamesString(
				specification.getStudentDisabilities()));
		entity.setStudentEthnic(Utility.getIns().getNameString(
				specification.getStudentEthnic()));
		entity.setStudentFamilyPolicies(Utility.getIns().getNamesString(
				specification.getStudentFamilyPolicies()));
		entity.setStudentGender(Utility.getIns().getNameString(
				specification.getStudentGender()));
		entity.setStudentReligion(Utility.getIns().getNameString(
				specification.getStudentReligion()));
		entity.setStudentResidences(Utility.getIns().getNamesString(
				specification.getStudentResidences()));
		entity.setStudentTalents(Utility.getIns().getNamesString(
				specification.getStudentTalents()));
		entity.setStudentTerminalIllnesses(Utility.getIns().getNamesString(
				specification.getStudentTerminalIllnesses()));
		entity.setSupportDescription(Utility.getIns().getFormatString(
				specification.getSupportDescription()));
		entity.setValue(Utility.getIns().getMoneyString(
				scholarship.getValueMin(), scholarship.getValueMax()));

		return entity;
	}

}
