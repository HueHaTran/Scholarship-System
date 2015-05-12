package uit.se06.scholarshipweb.bus;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.dao.IFormOfParticipationDAO;
import uit.se06.scholarshipweb.dao.impl.JdbcFormOfParticipationDAO;
import uit.se06.scholarshipweb.model.FormOfParticipation;

public class FormOfParticipationBUS {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(FormOfParticipationBUS.class);

	private IFormOfParticipationDAO dao;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public FormOfParticipationBUS(SessionFactory sessionFactory) {
		dao = new JdbcFormOfParticipationDAO(sessionFactory);
	}

	// ============================================================
	// METHODS
	// ============================================================

	public FormOfParticipation findById(int id) {
		FormOfParticipation entity = dao.findById(id);
		if (entity == null) {
			logger.info("Warning in " + this.getClass().getCanonicalName()
					+ ": " + "findById(" + id + ")" + " return null.");
		}
		return entity;
	}

	public FormOfParticipation findByName(String name) {
		FormOfParticipation entity = dao.findByName(name);
		if (entity == null) {
			logger.info("Warning in " + this.getClass().getCanonicalName()
					+ ": " + "findByName(" + name + ")" + " return null.");
		}
		return entity;
	}

	public List<FormOfParticipation> list() {
		List<FormOfParticipation> result = dao.list();
		if (result == null || (result != null && result.isEmpty())) {
			logger.info("Warning in " + this.getClass().getCanonicalName()
					+ ": " + "list()" + " return null or empty.");
		}
		return result;
	}
}