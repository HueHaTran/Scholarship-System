package uit.se06.scholarshipweb.bus;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.dao.IDisabilityDAO;
import uit.se06.scholarshipweb.dao.impl.JdbcDisabilityDAO;
import uit.se06.scholarshipweb.model.Disability;

public class DisabilityBUS {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(DisabilityBUS.class);

	private IDisabilityDAO dao;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public DisabilityBUS(SessionFactory sessionFactory) {
		dao = new JdbcDisabilityDAO(sessionFactory);
	}

	// ============================================================
	// METHODS
	// ============================================================

	public Disability findById(int id) {
		Disability entity = dao.findById(id);
		if (entity == null) {
			logger.info("Warning in " + this.getClass().getCanonicalName()
					+ ": " + "findById(" + id + ")" + " return null.");
		}
		return entity;
	}

	public Disability findByName(String name) {
		Disability entity = dao.findByName(name);
		if (entity == null) {
			logger.info("Warning in " + this.getClass().getCanonicalName()
					+ ": " + "findByName(" + name + ")" + " return null.");
		}
		return entity;
	}

	public List<Disability> list() {
		List<Disability> result = dao.list();
		if (result == null || (result != null && result.isEmpty())) {
			logger.info("Warning in " + this.getClass().getCanonicalName()
					+ ": " + "list()" + " return null or empty.");
		}
		return result;
	}
}
