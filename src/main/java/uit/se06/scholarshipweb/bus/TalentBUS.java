package uit.se06.scholarshipweb.bus;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.dao.ITalentDAO;
import uit.se06.scholarshipweb.dao.impl.JdbcTalentDAO;
import uit.se06.scholarshipweb.model.Talent;

public class TalentBUS {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(TalentBUS.class);

	private ITalentDAO dao;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public TalentBUS(SessionFactory sessionFactory) {
		dao = new JdbcTalentDAO(sessionFactory);
	}

	// ============================================================
	// METHODS
	// ============================================================

	public Talent findById(int id) {
		Talent entity = dao.findById(id);
		if (entity == null) {
			logger.info("Warning in: " + "findById(" + id + ")"
					+ " return null.");
		}
		return entity;
	}

	public Talent findByName(String name) {
		Talent entity = dao.findByName(name);
		if (entity == null) {
			logger.info("Warning in: " + "findByName(" + name + ")"
					+ " return null.");
		}
		return entity;
	}

	public List<Talent> list() {
		List<Talent> result = dao.list();
		if (result == null || (result != null && result.isEmpty())) {
			logger.info("Warning in " + this.getClass().getCanonicalName()
					+ ": " + "list()" + " return null or empty.");
		}
		return result;
	}
}
