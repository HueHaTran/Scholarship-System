package uit.se06.scholarshipweb.bus;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.dao.IMajorDAO;
import uit.se06.scholarshipweb.dao.impl.JdbcMajorDAO;
import uit.se06.scholarshipweb.model.Major;

public class MajorBUS {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(MajorBUS.class);

	private IMajorDAO dao;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public MajorBUS(SessionFactory sessionFactory) {
		dao = new JdbcMajorDAO(sessionFactory);
	}

	// ============================================================
	// METHODS
	// ============================================================

	public Major findById(int id) {
		Major entity = dao.findById(id);
		if (entity == null) {
			logger.info("Warning in: " + "findById(" + id + ")"
					+ " return null.");
		}
		return entity;
	}

	public Major findByName(String name) {
		Major entity = dao.findByName(name);
		if (entity == null) {
			logger.info("Warning in: " + "findByName(" + name + ")"
					+ " return null.");
		}
		return entity;
	}

	public List<Major> list() {
		List<Major> result = dao.list();
		if (result == null || (result != null && result.isEmpty())) {
			logger.info("Warning in: " + "list()" + " return null or empty.");
		}
		return result;
	}
}
