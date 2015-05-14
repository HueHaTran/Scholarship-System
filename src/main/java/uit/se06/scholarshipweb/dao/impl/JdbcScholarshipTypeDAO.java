package uit.se06.scholarshipweb.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.dao.IScholarshipTypeDAO;
import uit.se06.scholarshipweb.model.ScholarshipType;

public class JdbcScholarshipTypeDAO extends JdbcBaseDAO<ScholarshipType>
		implements IScholarshipTypeDAO {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(JdbcScholarshipTypeDAO.class);

	public final String COL_ID = "scholarship_type_id";
	public final String COL_NAME = "scholarship_type_name";

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public JdbcScholarshipTypeDAO(SessionFactory sessionFactory) {
		super(ScholarshipType.class, sessionFactory);
	}

	// ============================================================
	// OVERRIDE METHODS
	// ============================================================

	@Override
	protected Logger getLogger() {
		return logger;
	}

	@Override
	public ScholarshipType findById(int id) {
		return findBy(COL_ID, String.valueOf(id));
	}

	@Override
	public ScholarshipType findByName(String name) {
		return findBy(COL_NAME, name);
	}

	@Override
	public List<ScholarshipType> list() {
		return getAll();
	}

	// ============================================================
	// OTHER METHODS
	// ============================================================

}
