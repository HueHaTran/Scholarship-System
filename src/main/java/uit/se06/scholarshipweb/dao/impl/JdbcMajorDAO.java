package uit.se06.scholarshipweb.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import uit.se06.scholarshipweb.dao.IMajorDAO;
import uit.se06.scholarshipweb.model.AcademicLevel;
import uit.se06.scholarshipweb.model.Major;

public class JdbcMajorDAO extends JdbcBaseDAO<Major> implements IMajorDAO {

	// ============================================================
	// VARIABLES
	// ============================================================

	private final String COL_ID = "major_id";
	private final String COL_NAME = "major_name";

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
