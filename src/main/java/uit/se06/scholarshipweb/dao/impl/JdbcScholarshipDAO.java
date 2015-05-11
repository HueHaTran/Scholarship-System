package uit.se06.scholarshipweb.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import uit.se06.scholarshipweb.dao.IScholarshipDAO;
import uit.se06.scholarshipweb.model.AcademicLevel;
import uit.se06.scholarshipweb.model.Scholarship;

public class JdbcScholarshipDAO extends JdbcBaseDAO<Scholarship> implements
		IScholarshipDAO {

	// ============================================================
	// VARIABLES
	// ============================================================

	private final String COL_ID = "scholarship_id";
	private final String COL_NAME = "scholarship_name";

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

	@Override
	/**
	 * not done
	 */
	public Scholarship findShortInfoById(int id) {
		// query
		StringBuilder builder = new StringBuilder();

		builder.append("from ").append(Scholarship.class.getCanonicalName());
		builder.append("  where ").append(COL_ID).append(" = :paramId");

		Query query = getSession().createQuery(builder.toString())
				.setParameter("paramId", id);

		@SuppressWarnings("unchecked")
		List<Scholarship> resultList = query.list();

		if (resultList != null && !resultList.isEmpty()) {
			return resultList.get(0);
		} else {
			return null;
		}
	}

	// ============================================================
	// OTHER METHODS
	// ============================================================

}
