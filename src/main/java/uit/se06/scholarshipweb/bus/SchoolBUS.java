package uit.se06.scholarshipweb.bus;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.dao.ISchoolDAO;
import uit.se06.scholarshipweb.dao.impl.JdbcSchoolDAO;
import uit.se06.scholarshipweb.model.School;

public class SchoolBUS {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(SchoolBUS.class);

	private ISchoolDAO dao; 

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public SchoolBUS(SessionFactory sessionFactory) {
		dao = new JdbcSchoolDAO(sessionFactory); 
	}

	// ============================================================
	// METHODS
	// ============================================================

	public School findById(int id) {
		School entity = dao.findById(id);
		if (entity == null) {
			logger.info("Warning in " + this.getClass().getCanonicalName()
					+ ": " + "findById(" + id + ")" + " return null.");
		}
		return entity;
	}

	public School findByName(String name) {
		School entity = dao.findByName(name);
		if (entity == null) {
			logger.info("Warning in " + this.getClass().getCanonicalName()
					+ ": " + "findByName(" + name + ")" + " return null.");
		}
		return entity;
	}

	public List<School> list() {
		List<School> result = dao.list();
		if (result == null || (result != null && result.isEmpty())) {
			logger.info("Warning in " + this.getClass().getCanonicalName()
					+ ": " + "list()" + " return null or empty.");
		}
		return result;
	}
}
