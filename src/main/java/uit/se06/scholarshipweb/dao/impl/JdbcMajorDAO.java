package uit.se06.scholarshipweb.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.dao.IMajorDAO;
import uit.se06.scholarshipweb.model.AcademicLevel;
import uit.se06.scholarshipweb.model.Major;

public class JdbcMajorDAO extends JdbcBaseDAO<Major> implements IMajorDAO {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(JdbcMajorDAO.class);

	public final String COL_ID = "major_id";
	public final String COL_NAME = "major_name";

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public JdbcMajorDAO(SessionFactory sessionFactory) {
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
	public Major findById(int id) {
		return findBy(COL_ID, String.valueOf(id));
	}

	@Override
	public Major findByName(String name) {
		return findBy(COL_NAME, name);
	}

	@Override
	public List<Major> list() {
		return getAll();
	}

	// ============================================================
	// OTHER METHODS
	// ============================================================

}
