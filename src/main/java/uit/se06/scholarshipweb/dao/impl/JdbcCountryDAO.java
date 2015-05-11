package uit.se06.scholarshipweb.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import uit.se06.scholarshipweb.dao.ICountryDAO;
import uit.se06.scholarshipweb.model.AcademicLevel;
import uit.se06.scholarshipweb.model.Country;

public class JdbcCountryDAO extends JdbcBaseDAO<Country> implements ICountryDAO {

	// ============================================================
	// VARIABLES
	// ============================================================

	private final String COL_ID = "country_id";
	private final String COL_NAME = "country_name";

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public JdbcCountryDAO(SessionFactory sessionFactory) {
		super(AcademicLevel.class, sessionFactory);
	}

	// ============================================================
	// OVERRIDE METHODS
	// ============================================================

	@Override
	public Country findById(int id) {
		return findBy(COL_ID, String.valueOf(id));
	}

	@Override
	public Country findByName(String name) {
		return findBy(COL_NAME, name);
	}

	@Override
	public List<Country> list() {
		return getAll();
	}

	// ============================================================
	// OTHER METHODS
	// ============================================================

}
