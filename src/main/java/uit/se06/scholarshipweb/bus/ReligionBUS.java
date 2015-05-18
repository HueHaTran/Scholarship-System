package uit.se06.scholarshipweb.bus;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.dao.IReligionDAO;
import uit.se06.scholarshipweb.dao.impl.JdbcReligionDAO;
import uit.se06.scholarshipweb.model.Religion;

public class ReligionBUS {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(ReligionBUS.class);

	private IReligionDAO dao;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public ReligionBUS(SessionFactory sessionFactory) {
		dao = new JdbcReligionDAO(sessionFactory);
	}

	// ============================================================
	// METHODS
	// ============================================================

	public Religion findById(int id) {
		Religion entity = dao.findById(id);
		if (entity == null) {
			logger.info("Warning in: " + "findById(" + id + ")"
					+ " return null.");
		}
		return entity;
	}

	public Religion findByName(String name) {
		Religion entity = dao.findByName(name);
		if (entity == null) {
			logger.info("Warning in: " + "findByName(" + name + ")"
					+ " return null.");
		}
		return entity;
	}

	public List<Religion> list() {
		List<Religion> result = dao.list();
		if (result == null || (result != null && result.isEmpty())) {
			logger.info("Warning in: " + "list()" + " return null or empty.");
		}
		return result;
	}
}
