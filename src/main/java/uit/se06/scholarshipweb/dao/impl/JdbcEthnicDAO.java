package uit.se06.scholarshipweb.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import uit.se06.scholarshipweb.dao.IEthnicDAO;
import uit.se06.scholarshipweb.model.AcademicLevel;
import uit.se06.scholarshipweb.model.Ethnic;

public class JdbcEthnicDAO extends JdbcBaseDAO<Ethnic> implements IEthnicDAO {

	// ============================================================
	// VARIABLES
	// ============================================================

	private final String COL_ID = "ethnic_id";
	private final String COL_NAME = "ethnic_name";

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public JdbcEthnicDAO(SessionFactory sessionFactory) {
		super(AcademicLevel.class, sessionFactory);
	}

	// ============================================================
	// OVERRIDE METHODS
	// ============================================================

	@Override
	public Ethnic findById(int id) {
		return findBy(COL_ID, String.valueOf(id));
	}

	@Override
	public Ethnic findByName(String name) {
		return findBy(COL_NAME, name);
	}

	@Override
	public List<Ethnic> list() {
		return getAll();
	}

	// ============================================================
	// OTHER METHODS
	// ============================================================

}
