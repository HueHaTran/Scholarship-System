package uit.se06.scholarshipweb.bus;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.dao.IGenderDAO;
import uit.se06.scholarshipweb.dao.impl.JdbcGenderDAO;
import uit.se06.scholarshipweb.model.Gender;

public class GenderBUS {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(GenderBUS.class);

	private IGenderDAO dao;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public GenderBUS(SessionFactory sessionFactory) {
		dao = new JdbcGenderDAO(sessionFactory);
	}

	// ============================================================
	// METHODS
	// ============================================================

	public Gender findById(int id) {
		Gender entity = dao.findById(id);
		if (entity == null) {
			logger.info("Warning in " + this.getClass().getCanonicalName()
					+ ": " + "findById(" + id + ")" + " return null.");
		}
		return entity;
	}

	public Gender findByName(String name) {
		Gender entity = dao.findByName(name);
		if (entity == null) {
			logger.info("Warning in " + this.getClass().getCanonicalName()
					+ ": " + "findByName(" + name + ")" + " return null.");
		}
		return entity;
	}

	public List<Gender> list() {
		List<Gender> result = dao.list();
		if (result == null || (result != null && result.isEmpty())) {
			logger.info("Warning in " + this.getClass().getCanonicalName()
					+ ": " + "list()" + " return null or empty.");
		} 
		return result;
	}
}
