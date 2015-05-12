package uit.se06.scholarshipweb.bus;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.dao.IScholarshipTypeDAO;
import uit.se06.scholarshipweb.dao.impl.JdbcScholarshipTypeDAO;
import uit.se06.scholarshipweb.model.ScholarshipType;

public class ScholarshipTypeBUS {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(ScholarshipTypeBUS.class);

	private IScholarshipTypeDAO dao;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public ScholarshipTypeBUS(SessionFactory sessionFactory) {
		dao = new JdbcScholarshipTypeDAO(sessionFactory);
	}

	// ============================================================
	// METHODS
	// ============================================================

	public ScholarshipType findById(int id) {
		ScholarshipType entity = dao.findById(id);
		if (entity == null) {
			logger.info("Warning in " + this.getClass().getCanonicalName()
					+ ": " + "findById(" + id + ")" + " return null.");
		}
		return entity;
	}

	public ScholarshipType findByName(String name) {
		ScholarshipType entity = dao.findByName(name);
		if (entity == null) {
			logger.info("Warning in " + this.getClass().getCanonicalName()
					+ ": " + "findByName(" + name + ")" + " return null.");
		}
		return entity;
	}

	public List<ScholarshipType> list() {
		List<ScholarshipType> result = dao.list();
		if (result == null || (result != null && result.isEmpty())) {
			logger.info("Warning in " + this.getClass().getCanonicalName()
					+ ": " + "list()" + " return null or empty.");
		}
		return result;
	}
}
