package uit.se06.scholarshipweb.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.dao.IDisabilityDAO;
import uit.se06.scholarshipweb.model.Disability;

public class JdbcDisabilityDAO extends JdbcBaseDAO<Disability> implements
		IDisabilityDAO {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(JdbcDisabilityDAO.class);

	public final String COL_ID = "disability_id";
	public final String COL_NAME = "disability_name";

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public JdbcDisabilityDAO(SessionFactory sessionFactory) {
		super(Disability.class, sessionFactory);
	}

	// ============================================================
	// OVERRIDE METHODS
	// ============================================================

	@Override
	protected Logger getLogger() {
		return logger;
	}

	@Override
	public Disability findById(int id) {
		return findBy(COL_ID, String.valueOf(id));
	}

	@Override
	public Disability findByName(String name) {
		return findBy(COL_NAME, name);
	}

	@Override
	public List<Disability> list() {
		return getAll();
	}

	// ============================================================
	// OTHER METHODS
	// ============================================================

}
