package uit.se06.scholarshipweb.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import uit.se06.scholarshipweb.dao.ITalentDAO;
import uit.se06.scholarshipweb.model.AcademicLevel;
import uit.se06.scholarshipweb.model.Talent;

public class JdbcTalentDAO extends JdbcBaseDAO<Talent> implements ITalentDAO {

	// ============================================================
	// VARIABLES
	// ============================================================

	public final String COL_ID = "talent_id";
	public final String COL_NAME = "talent_name";

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public JdbcTalentDAO(SessionFactory sessionFactory) {
		super(AcademicLevel.class, sessionFactory);
	}

	// ============================================================
	// OVERRIDE METHODS
	// ============================================================

	@Override
	public Talent findById(int id) {
		return findBy(COL_ID, String.valueOf(id));
	}

	@Override
	public Talent findByName(String name) {
		return findBy(COL_NAME, name);
	}

	@Override
	public List<Talent> list() {
		return getAll();
	}

	// ============================================================
	// OTHER METHODS
	// ============================================================

}
