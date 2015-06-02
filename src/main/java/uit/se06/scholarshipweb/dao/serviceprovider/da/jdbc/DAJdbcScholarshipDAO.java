package uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.dao.factory.DAOAbstractFactory;
import uit.se06.scholarshipweb.dao.factory.IScholarshipDAO;
import uit.se06.scholarshipweb.dao.util.HibernateUtil;
import uit.se06.scholarshipweb.dao.util.ILoadingRelatedEntityListener;
import uit.se06.scholarshipweb.model.Scholarship;
import uit.se06.scholarshipweb.model.ScholarshipSpecification;
import uit.se06.scholarshipweb.viewmodel.FilterViewModel;

public class DAJdbcScholarshipDAO extends DAJdbcBaseDAO<Scholarship> implements
		IScholarshipDAO {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(DAJdbcScholarshipDAO.class);

	public static final String COL_ID = "scholarship_id";
	public static final String COL_NAME = "scholarship_name";
	public static final String COL_DESCIPTION = "description";
	public static final String COL_ORIGINAL_LINK = "original_link";
	public static final String COL_COUNT = "count";
	public static final String COL_DATE_END_REGISTER = "date_end_register";
	public static final String COL_VALUE_MIN = "value_min";
	public static final String COL_VALUE_MAX = "value_max";
	public static final String COL_ACTIVE = "active";

	public static final String COL_STUDENT_GENDER = "student_gender_id";
	public static final String COL_STUDENT_CITIZENSHIP = "student_citizenship_id";
	public static final String COL_STUDENT_RELIGION = "student_religion_id";
	public static final String COL_STUDENT_ACADEMIC_LEVEL_DETAIL = "student_academic_level_detail_id";
	public static final String COL_SCHOLARSHIP_TYPE = "scholarship_type_id";
	public static final String COL_SCHOOL = "school_id";
	public static final String COL_FORM_OF_PARTICIPATION = "form_of_participation_id";
	public static final String COL_APPLICATION_DESCRIPTION = "application_description";
	public static final String COL_SUPPORT_DESCRIPTION = "support_description";

	public static final String COL_FAMILY_POLICY = "family_policy_id";
	public static final String COL_DISABILITY = "disability_id";
	public static final String COL_TERMINAL_ILL = "terminal_ill_id";
	public static final String COL_MAJOR = "major_id";
	public static final String COL_TALENT = "talent_id";
	public static final String COL_SCHOLAR_ACA = "academic_level_detail_id";
	public static final String COL_RESIDENCE_PROVINCE = "province_id";

	public static final String TABLE_SCHOLARSHIP = "scholarship";
	public static final String TABLE_SCHOLARSHIP_SPEC = "scholarship_specification";
	public static final String TABLE_SCHOLARSHIP_ACA = "scholarship_academic_level_detail";
	public static final String TABLE_FAMILY_POLICY = "scholarship_family_policy";
	public static final String TABLE_DISABILITY = "scholarship_disability";
	public static final String TABLE_TERMINAL_ILL = "scholarship_terminal_ill";
	public static final String TABLE_SPONSOR = "scholarship_sponsor";
	public static final String TABLE_MAJOR = "scholarship_major";

	public static final String TABLE_TALENT = "scholarship_talent";
	public static final String TABLE_RESIDENCE_PROVINCE = "scholarship_student_residence";

	private ILoadingRelatedEntityListener<Scholarship> scholarshipLoadinglistener = new ILoadingRelatedEntityListener<Scholarship>() {
		@Override
		public void load(Scholarship entity) {
			Hibernate.initialize(entity.getScholarshipSpecification());
			Hibernate.initialize(entity.getScholarshipSpecification()
					.getFormOfParticipation());
			Hibernate.initialize(entity.getScholarshipSpecification()
					.getScholarshipAcademicLevelDetail());
			Hibernate.initialize(entity.getScholarshipSpecification()
					.getScholarshipMajors());
			Hibernate.initialize(entity.getScholarshipSpecification()
					.getScholarshipType());
			Hibernate.initialize(entity.getScholarshipSpecification()
					.getSchool());
			Hibernate.initialize(entity.getScholarshipSpecification()
					.getSponsors());
			Hibernate.initialize(entity.getScholarshipSpecification()
					.getStudentAcademicLevelDetail());
			Hibernate.initialize(entity.getScholarshipSpecification()
					.getStudentCitizenship());
			Hibernate.initialize(entity.getScholarshipSpecification()
					.getStudentDisabilities());
			Hibernate.initialize(entity.getScholarshipSpecification()
					.getStudentEthnic());
			Hibernate.initialize(entity.getScholarshipSpecification()
					.getStudentFamilyPolicies());
			Hibernate.initialize(entity.getScholarshipSpecification()
					.getStudentGender());
			Hibernate.initialize(entity.getScholarshipSpecification()
					.getStudentReligion());
			Hibernate.initialize(entity.getScholarshipSpecification()
					.getStudentResidences());
			Hibernate.initialize(entity.getScholarshipSpecification()
					.getStudentTalents());
			Hibernate.initialize(entity.getScholarshipSpecification()
					.getStudentTerminalIllnesses());
		}
	};

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public DAJdbcScholarshipDAO() {
		super(Scholarship.class);
	}

	// ============================================================
	// OVERRIDE METHODS
	// ============================================================

	@Override
	protected Logger getLogger() {
		return logger;
	}

	@Override
	public Scholarship findById(int id) {
		return findBy(COL_ID, String.valueOf(id), scholarshipLoadinglistener);
	}

	@Override
	public Scholarship findByName(String name) {
		return findBy(COL_NAME, name, scholarshipLoadinglistener);
	}

	@Override
	public void insert(Scholarship entity) {
		SessionFactory sessionfactory = HibernateUtil
				.getSessionAnnotationFactory();
		Session session = sessionfactory.openSession();

		Transaction transaction = null;
		ScholarshipSpecification spec = entity.getScholarshipSpecification();

		try {
			transaction = session.beginTransaction();

			// remove mapping between scholarship and specification
			entity.setScholarshipSpecification(null);

			session.save(entity);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return;
		} finally {
			session.close();
		}

		// add specification
		int id = entity.getId();

		spec.setScholarship(entity);
		spec.setScholarshipId(id);
		insertSpec(spec);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Scholarship> listBy(FilterViewModel data, int pageNumber,
			int pageSize) {
		List<Scholarship> resultList = new ArrayList<Scholarship>();

		StringBuilder sb = new StringBuilder();
		String tempScholar = "s1";
		String tempSpec = "s2";

		// select
		sb.append("SELECT ");
		sb.append(tempScholar + "." + COL_NAME).append(", ");
		sb.append(tempScholar + "." + COL_ID).append(", ");
		sb.append(tempScholar + "." + COL_VALUE_MIN).append(", ");
		sb.append(tempScholar + "." + COL_VALUE_MAX).append(", ");
		sb.append(tempScholar + "." + COL_DATE_END_REGISTER).append(", ");
		sb.append(tempScholar + "." + COL_ACTIVE).append(", ");
		sb.append(tempSpec + "." + COL_SCHOOL).append(" ");

		sb = getFromWhereQuery(sb, data);

		try {
			Query query = getSession().createSQLQuery(sb.toString())
					.addEntity(tempScholar, Scholarship.class)
					.setFirstResult((pageNumber - 1) * pageSize)
					.setMaxResults(pageSize);

			resultList = (query.list());

		} catch (Exception ex) {
			getLogger().error(
					"Query '" + sb.toString()
							+ "' in listBy(FilterViewModel): " + ex.toString());
		} finally {
			closeSession();
		}

		return resultList;
	}

	@Override
	public long countRowsListBy(FilterViewModel data) {
		StringBuilder sb = new StringBuilder();
		long result = 0;

		// select
		sb.append("SELECT COUNT(*)");

		sb = getFromWhereQuery(sb, data);

		try {
			result = ((Number) getSession().createSQLQuery(sb.toString())
					.uniqueResult()).longValue();

		} catch (Exception ex) {
			getLogger().error(
					"Query '" + sb.toString()
							+ "' in listBy(FilterViewModel): " + ex.toString());
		} finally {
			closeSession();
		}

		return result;
	}

	// ============================================================
	// OTHER METHODS
	// ============================================================

	private void insertSpec(ScholarshipSpecification entity) {
		SessionFactory sessionfactory = HibernateUtil
				.getSessionAnnotationFactory();
		Session session = sessionfactory.openSession();

		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(entity);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	private StringBuilder getFromWhereQuery(StringBuilder sb,
			FilterViewModel data) {
		// variables
		String tempScholar = "s1";
		String tempSpec = "s2";
		String tempFam = "s3";
		String tempMajor = "s4";
		String tempDisability = "s5";
		String tempTalent = "s6";
		String tempScholarAca = "s7";
		String tempTerminalIll = "s8";

		// from
		sb.append("FROM ");
		sb.append(TABLE_SCHOLARSHIP).append(" ").append(tempScholar);
		sb.append(getJoinQuery(TABLE_SCHOLARSHIP_SPEC, tempScholar, tempSpec,
				COL_ID, COL_ID));
		if (!isNullOrEmpty(data.familyPolicy)) {
			sb.append(getJoinQuery(TABLE_FAMILY_POLICY, tempSpec, tempFam,
					COL_ID, COL_ID));
		}
		if (!isNullOrEmpty(data.scholarMajors)) {
			sb.append(getJoinQuery(TABLE_MAJOR, tempSpec, tempMajor, COL_ID,
					COL_ID));
		}
		if (!isNullOrEmpty(data.stuDisabilities)) {
			sb.append(getJoinQuery(TABLE_DISABILITY, tempSpec, tempDisability,
					COL_ID, COL_ID));
		}
		if (!isNullOrEmpty(data.stuTerminalIllnesses)) {
			sb.append(getJoinQuery(TABLE_TERMINAL_ILL, tempSpec,
					tempTerminalIll, COL_ID, COL_ID));
		}
		if (!isNullOrEmpty(data.talents)) {
			sb.append(getJoinQuery(TABLE_TALENT, tempSpec, tempTalent, COL_ID,
					COL_ID));
		}
		if (data.scholarAca != 0) {// user select to filter
			sb.append(getJoinQuery(TABLE_SCHOLARSHIP_ACA, tempSpec,
					tempScholarAca, COL_ID, COL_ID));
		}

		// where, check the impossible clause first to eliminate result
		boolean flagFirstClause = true;
		if (!isNullOrEmpty(data.familyPolicy)) {
			flagFirstClause = updateElementPrefix(flagFirstClause, sb, " && ");
			sb.append(getWhereInQuery(COL_FAMILY_POLICY, data.familyPolicy));
		}
		if (!isNullOrEmpty(data.scholarMajors)) {
			flagFirstClause = updateElementPrefix(flagFirstClause, sb, " && ");
			sb.append(getWhereInQuery(COL_MAJOR, data.scholarMajors));
		}
		if (!isNullOrEmpty(data.stuDisabilities)) {
			flagFirstClause = updateElementPrefix(flagFirstClause, sb, " && ");
			sb.append(getWhereInQuery(COL_DISABILITY, data.stuDisabilities));
		}
		if (!isNullOrEmpty(data.stuTerminalIllnesses)) {
			flagFirstClause = updateElementPrefix(flagFirstClause, sb, " && ");
			sb.append(getWhereInQuery(COL_TERMINAL_ILL,
					data.stuTerminalIllnesses));
		}
		if (!isNullOrEmpty(data.talents)) {
			flagFirstClause = updateElementPrefix(flagFirstClause, sb, " && ");
			sb.append(getWhereInQuery(COL_TALENT, data.talents));
		}
		if (data.scholarAca != 0) {
			flagFirstClause = updateElementPrefix(flagFirstClause, sb, " && ");
			if (data.scholarAcaDetails > 0) {// choose specify entity
				sb.append(getWhereEqualQuery(COL_SCHOLAR_ACA, data.scholarAca));
			} else {// choose all
				sb.append(getWhereInQuery(COL_SCHOLAR_ACA,
						DAOAbstractFactory.INS.getAcademicLevelDetailDAO()
								.findIdListByAcademicLevelId(data.scholarAca)));
			}
		}
		if (data.scholarType > 0) {
			flagFirstClause = updateElementPrefix(flagFirstClause, sb, " && ");
			sb.append(getWhereEqualQuery(COL_SCHOLARSHIP_TYPE, data.scholarType));
		}
		if (data.stuAca != 0) {
			flagFirstClause = updateElementPrefix(flagFirstClause, sb, " && ");
			if (data.stuAcaDetail > 0) {
				sb.append(getWhereEqualQuery(COL_STUDENT_ACADEMIC_LEVEL_DETAIL,
						data.stuAcaDetail));
			} else {
				sb.append(getWhereInQuery(COL_STUDENT_ACADEMIC_LEVEL_DETAIL,
						DAOAbstractFactory.INS.getAcademicLevelDetailDAO()
								.findIdListByAcademicLevelId(data.stuAca)));
			}
		}
		if (data.stuCitizenship > 0) {
			flagFirstClause = updateElementPrefix(flagFirstClause, sb, " && ");
			sb.append(getWhereEqualQuery(COL_STUDENT_CITIZENSHIP,
					data.stuCitizenship));
		}
		if (data.stuGender > 0) {
			flagFirstClause = updateElementPrefix(flagFirstClause, sb, " && ");
			sb.append(getWhereEqualQuery(COL_STUDENT_GENDER, data.stuGender));
		}
		if (data.stuReligion > 0) {
			flagFirstClause = updateElementPrefix(flagFirstClause, sb, " && ");
			sb.append(getWhereEqualQuery(COL_STUDENT_RELIGION, data.stuReligion));
		}
		if (data.stuResidenceProvince > 0) {
			flagFirstClause = updateElementPrefix(flagFirstClause, sb, " && ");
			sb.append(getWhereEqualQuery(COL_RESIDENCE_PROVINCE,
					data.stuResidenceProvince));
		}
		return sb;
	}

	private String getJoinQuery(String table2, String table1Alias,
			String table2Alias, String columnRelate1, String columnRelate2) {
		StringBuilder sb = new StringBuilder();

		sb.append(" INNER JOIN ").append(table2).append(" ")
				.append(table2Alias);

		sb.append(" ON ");

		sb.append(table1Alias).append(".").append(columnRelate1);
		sb.append(" = ");
		sb.append(table2Alias).append(".").append(columnRelate2);

		return sb.toString();
	}

	private String getWhereEqualQuery(String columnName, int value) {
		return columnName + " = " + value;
	}

	private String getWhereInQuery(String columnName, List<Integer> listId) {
		if (isNullOrEmpty(listId)) {
			return "";
		}

		if (listId.size() == 1) {
			return getWhereEqualQuery(columnName, listId.get(0));
		}
		StringBuilder sb = new StringBuilder();
		sb.append(columnName).append(" IN (");

		for (int i = 0; i < listId.size(); i++) {
			sb.append(listId.get(i));
			if (i == listId.size() - 1) {// the last one
				sb.append(")");// close clause
			} else {
				sb.append(", ");
			}
		}

		return sb.toString();
	}

	private boolean isNullOrEmpty(List<Integer> list) {
		return !(list != null && !list.isEmpty());
	}

	private boolean updateElementPrefix(boolean flagFirstClause,
			StringBuilder sb, String addedPrefix) {
		if (!flagFirstClause) {
			sb.append(addedPrefix);
		} else {
			sb.append(" WHERE ");
			flagFirstClause = false;
		}
		return flagFirstClause;
	}
}
