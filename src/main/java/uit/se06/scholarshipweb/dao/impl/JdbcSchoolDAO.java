package uit.se06.scholarshipweb.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import uit.se06.scholarshipweb.dao.ISchoolDAO;
import uit.se06.scholarshipweb.model.AcademicLevel;
import uit.se06.scholarshipweb.model.School;

public class JdbcSchoolDAO extends JdbcBaseDAO<School> implements ISchoolDAO {

	// ============================================================
	// VARIABLES
	// ============================================================

	private final String COL_ID = "school_id";
	private final String COL_NAME = "school_name";

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public JdbcSchoolDAO(SessionFactory sessionFactory) {
		super(AcademicLevel.class, sessionFactory);
	}

	// ============================================================
	// OVERRIDE METHODS
	// ============================================================

	@Override
	public School findById(int id) {
		return findBy(COL_ID, String.valueOf(id));
	}

	@Override
	public School findByName(String name) {
		return findBy(COL_NAME, name);
	}

	@Override
	public List<School> list() {
		return getAll();
	}

	// ============================================================
	// OTHER METHODS
	// ============================================================

}
