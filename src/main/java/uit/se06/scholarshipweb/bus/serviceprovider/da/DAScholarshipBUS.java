package uit.se06.scholarshipweb.bus.serviceprovider.da;

import java.util.ArrayList;
import java.util.List;

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
import uit.se06.scholarshipweb.viewmodel.FilterViewModel;
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
	public ScholarshipViewModel findViewModelById(int id,
			boolean allowEmptyString) {
		Scholarship scholarship = findById(id);
		ScholarshipViewModel entity = convertToViewModel(scholarship,
				allowEmptyString);
		return entity;
	}

	@Override
	public ScholarshipViewModel findViewModelByName(String name,
			boolean allowEmptyString) {
		Scholarship scholarship = findByName(name);

		ScholarshipViewModel entity = convertToViewModel(scholarship,
				allowEmptyString);
		return entity;
	}

	@Override
	public List<OverviewScholarshipViewModel> filter(FilterViewModel data,
			int pageNumber, int pageSize, boolean allowEmptyString,
			int maxResult) {
		if (pageNumber <= 0) {
			System.err.println(this.getClass().getCanonicalName()
					+ "pageNumber can't be smaller than 0");
		} else if (pageNumber * pageSize <= maxResult) {
			List<OverviewScholarshipViewModel> result = new ArrayList<OverviewScholarshipViewModel>();

			List<Scholarship> list = dao.listBy(data, pageNumber, pageSize);
			for (Scholarship scholarship : list) {
				result.add(convertToOverviewViewModel(scholarship,
						allowEmptyString));
			}
			return result;
		}
		return new ArrayList<OverviewScholarshipViewModel>();
	}

	@Override
	public long countRowsListBy(FilterViewModel data) {
		return dao.countRowsListBy(data);
	}

	@Override
	public List<String> findScholarshipNameWithKeyword(String keyword, int size) {
		List<Scholarship> resultEntity = dao.findScholarshipWithKeyword(
				keyword, size);
		List<String> result = new ArrayList<String>();
		if (resultEntity != null) {
			for (Scholarship s : resultEntity) {
				if (!result.contains(s.getName())) {
					result.add(s.getName());
				}
			}
		}
		return result;
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
			Scholarship scholarship, boolean allowEmptyString) {
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
		entity.setName(Utility.getIns().getNameString(scholarship,
				allowEmptyString));
		entity.setDateEndRegister(Utility.getIns().getDateString(
				scholarship.getDateEndRegister(), allowEmptyString));
		if (school != null) {
			entity.setSchoolName(Utility.getIns().getNameString(school,
					allowEmptyString));
		}
		entity.setValueMin(Utility.getIns().getMoneyString(min,
				allowEmptyString));
		entity.setValueMax(Utility.getIns().getMoneyString(max,
				allowEmptyString));

		return entity;
	}

	private ScholarshipViewModel convertToViewModel(Scholarship scholarship,
			boolean allowEmptyString) {
		if (scholarship == null) {
			return null;
		}

		ScholarshipSpecification specification = scholarship
				.getScholarshipSpecification();

		ScholarshipViewModel entity = new ScholarshipViewModel();
		entity.setId(scholarship.getId());
		entity.setName(Utility.getIns().getNameString(scholarship,
				allowEmptyString));
		entity.setDescription(Utility.getIns().getFormatString(
				specification.getDescription(), allowEmptyString));
		entity.setOriginalLink(Utility.getIns().getFormatString(
				specification.getOriginal_link(), allowEmptyString));
		entity.setApplicationDescription(Utility.getIns().getFormatString(
				specification.getApplicationDescription(), allowEmptyString));
		entity.setCount(Utility.getIns().getFormatNumberString(
				specification.getCount(), allowEmptyString));
		entity.setDateEndRegister(Utility.getIns().getDateString(
				scholarship.getDateEndRegister(), allowEmptyString));
		entity.setFormOfParticipation(Utility.getIns().getNameString(
				specification.getFormOfParticipation(), allowEmptyString));
		entity.setScholarshipAcademicLevelDetail(Utility.getIns()
				.getNamesString(
						specification.getScholarshipAcademicLevelDetail(),
						allowEmptyString));
		entity.setScholarshipMajors(Utility.getIns().getNamesString(
				specification.getScholarshipMajors(), allowEmptyString));
		entity.setScholarshipType(Utility.getIns().getNameString(
				specification.getScholarshipType(), allowEmptyString));
		entity.setSchoolName(Utility.getIns().getNameString(
				specification.getSchool(), allowEmptyString));
		entity.setSponsorNames(Utility.getIns().getNamesString(
				specification.getSponsors(), allowEmptyString));
		entity.setStudentAcademicLevelDetail(Utility.getIns()
				.getNameString(specification.getStudentAcademicLevelDetail(),
						allowEmptyString));
		entity.setStudentCitizenship(Utility.getIns().getNameString(
				specification.getStudentCitizenship(), allowEmptyString));
		entity.setStudentDisabilities(Utility.getIns().getNamesString(
				specification.getStudentDisabilities(), allowEmptyString));
		entity.setStudentEthnic(Utility.getIns().getNameString(
				specification.getStudentEthnic(), allowEmptyString));
		entity.setStudentFamilyPolicies(Utility.getIns().getNamesString(
				specification.getStudentFamilyPolicies(), allowEmptyString));
		entity.setStudentGender(Utility.getIns().getNameString(
				specification.getStudentGender(), allowEmptyString));
		entity.setStudentReligion(Utility.getIns().getNameString(
				specification.getStudentReligion(), allowEmptyString));
		entity.setStudentResidences(Utility.getIns().getNamesString(
				specification.getStudentResidences(), allowEmptyString));
		entity.setStudentTalents(Utility.getIns().getNamesString(
				specification.getStudentTalents(), allowEmptyString));
		entity.setStudentTerminalIllnesses(Utility.getIns().getNamesString(
				specification.getStudentTerminalIllnesses(), allowEmptyString));
		entity.setSupportDescription(Utility.getIns().getFormatString(
				specification.getSupportDescription(), allowEmptyString));
		entity.setValueMin(Utility.getIns().getMoneyString(
				scholarship.getValueMin(), allowEmptyString));
		entity.setValueMax(Utility.getIns().getMoneyString(
				scholarship.getValueMax(), allowEmptyString));

		return entity;
	}

}
