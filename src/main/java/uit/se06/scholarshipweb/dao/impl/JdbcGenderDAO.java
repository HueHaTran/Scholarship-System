package uit.se06.scholarshipweb.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import uit.se06.scholarshipweb.dao.IGenderDAO;
import uit.se06.scholarshipweb.model.AcademicLevel;
import uit.se06.scholarshipweb.model.Gender;

public class JdbcGenderDAO extends JdbcBaseDAO<Gender> implements IGenderDAO {

	// ============================================================
	// VARIABLES
	// ============================================================

	private final String COL_ID = "gender_id";
	private final String COL_NAME = "gender_name";

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public JdbcGenderDAO(SessionFactory sessionFactory) {
		super(AcademicLevel.class, sessionFactory);
	}

	// ============================================================
	// OVERRIDE METHODS
	// ============================================================

	@Override
	public Gender findById(int id) {
		return findBy(COL_ID, String.valueOf(id));
	}

	@Override
	public Gender findByName(String name) {
		return findBy(COL_NAME, name);
	}

	@Override
	public List<Gender> list() {
		return getAll();
	}

	// ============================================================
	// OTHER METHODS
	// ============================================================

}
