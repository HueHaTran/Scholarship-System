package uit.se06.scholarshipweb.dao.impl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.dao.IScholarshipDAO;
import uit.se06.scholarshipweb.model.AcademicLevel;
import uit.se06.scholarshipweb.model.Scholarship;

public class JdbcScholarshipDAO extends JdbcBaseDAO<Scholarship> implements
		IScholarshipDAO {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(JdbcScholarshipDAO.class);

	public final String COL_ID = "scholarship_id";
	public final String COL_NAME = "scholarship_name";
	public final String COL_DESCIPTION = "description";
	public final String COL_ORIGINAL_LINK = "original_link";
	public final String COL_COUNT = "count";
	public final String COL_DATE_END_REGISTER = "date_end_register";
	public final String COL_VALUE_MIN = "value_min";
	public final String COL_VALUE_MAX = "value_max";
	public final String COL_STUDENT_GENDER = "student_gender_id";
	public final String COL_STUDENT_CITIZENSHIP = "student_citizenship_id";
	public final String COL_STUDENT_RESIDENCE = "student_residence_id";
	public final String COL_STUDENT_RELIGION = "student_religion_id";
	public final String COL_STUDENT_ACADEMIC_LEVEL_DETAIL = "student_academic_level_detail_id";
	public final String COL_SCHOLARSHIP_TYPE = "scholarship_type_id";
	public final String COL_SCHOOL = "school_id";
	public final String COL_FORM_OF_PARTICIPATION = "form_of_participation_id";
	public final String COL_APPLICATION_DESCRIPTION = "application_description";
	public final String COL_SUPPORT_DESCRIPTION = "support_description";

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public JdbcScholarshipDAO(SessionFactory sessionFactory) {
		super(AcademicLevel.class, sessionFactory);
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
		return findBy(COL_ID, String.valueOf(id));
	}

	@Override
	public Scholarship findByName(String name) {
		return findBy(COL_NAME, name);
	}

	@Override
	public List<Scholarship> list() {
		return getAll();
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * not done
	 */
	public Scholarship findShortInfoById(int id) {
		List<Scholarship> resultList = null;

		StringBuilder builder = new StringBuilder();

		try {
			// query
			builder.append("SELECT ").append(COL_NAME);
			builder.append(", ").append(COL_SCHOOL);
			builder.append(", ").append(COL_DESCIPTION);

			builder.append(" FROM ").append(
					Scholarship.class.getCanonicalName());
			builder.append("  where ").append(COL_ID).append(" = :paramId");

			SQLQuery query = getSession().createSQLQuery(builder.toString());
			query.setParameter("paramId", id);

			resultList = query.list();

		} catch (Exception ex) {
			logger.error("Exception in " + this.getClass().getCanonicalName()
					+ ": Query '" + builder.toString()
					+ "' in findShortInfoById()");
		} finally {
			closeSession();
		}

		if (resultList != null && !resultList.isEmpty()) {
			Scholarship result = resultList.get(0);
			return result;
		} else {
			return null;
		}

	}

	// ============================================================
	// OTHER METHODS
	// ============================================================

}
