package uit.se06.scholarshipweb.bus;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.dao.ISponsorDAO;
import uit.se06.scholarshipweb.dao.impl.JdbcSponsorDAO;
import uit.se06.scholarshipweb.model.Sponsor;

public class SponsorBUS {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(SponsorBUS.class);

	private ISponsorDAO dao;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public SponsorBUS(SessionFactory sessionFactory) {
		dao = new JdbcSponsorDAO(sessionFactory);
	}

	// ============================================================
	// METHODS
	// ============================================================

	public Sponsor findById(int id) {
		Sponsor entity = dao.findById(id);
		if (entity == null) {
			logger.info("Warning in " + this.getClass().getCanonicalName()
					+ ": " + "findById(" + id + ")" + " return null.");
		}
		return entity;
	}

	public Sponsor findByName(String name) {
		Sponsor entity = dao.findByName(name);
		if (entity == null) {
			logger.info("Warning in " + this.getClass().getCanonicalName()
					+ ": " + "findByName(" + name + ")" + " return null.");
		}
		return entity;
	}

	public List<Sponsor> list() {
		List<Sponsor> result = dao.list();
		if (result == null || (result != null && result.isEmpty())) {
			logger.info("Warning in " + this.getClass().getCanonicalName()
					+ ": " + "list()" + " return null or empty.");
		}
		return result;
	}
}
