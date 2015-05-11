package uit.se06.scholarshipweb.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import uit.se06.scholarshipweb.dao.IReligionDAO;
import uit.se06.scholarshipweb.model.AcademicLevel;
import uit.se06.scholarshipweb.model.Religion;

public class JdbcReligionDAO extends JdbcBaseDAO<Religion> implements IReligionDAO {

	// ============================================================
	// VARIABLES
	// ============================================================

	private final String COL_ID = "religion_id";
	private final String COL_NAME = "religion_name";

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public JdbcReligionDAO(SessionFactory sessionFactory) {
		super(AcademicLevel.class, sessionFactory);
	}

	// ============================================================
	// OVERRIDE METHODS
	// ============================================================

	@Override
	public Religion findById(int id) {
		return findBy(COL_ID, String.valueOf(id));
	}

	@Override
	public Religion findByName(String name) {
		return findBy(COL_NAME, name);
	}

	@Override
	public List<Religion> list() {
		return getAll();
	}

	// ============================================================
	// OTHER METHODS
	// ============================================================

}
