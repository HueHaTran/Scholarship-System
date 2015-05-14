package uit.se06.scholarshipweb.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.dao.ITalentDAO;
import uit.se06.scholarshipweb.model.Talent;

public class JdbcTalentDAO extends JdbcBaseDAO<Talent> implements ITalentDAO {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(JdbcTalentDAO.class);

	public final String COL_ID = "talent_id";
	public final String COL_NAME = "talent_name";

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public JdbcTalentDAO(SessionFactory sessionFactory) {
		super(Talent.class, sessionFactory);
	}

	// ============================================================
	// OVERRIDE METHODS
	// ============================================================

	@Override
	protected Logger getLogger() {
		return logger;
	}

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
