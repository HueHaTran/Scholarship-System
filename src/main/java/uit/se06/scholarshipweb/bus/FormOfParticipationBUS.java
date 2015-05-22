package uit.se06.scholarshipweb.bus;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.dao.factory.DAOAbstractFactory;
import uit.se06.scholarshipweb.dao.factory.IFormOfParticipationDAO;
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

	public FormOfParticipationBUS() {
		dao = DAOAbstractFactory.INS.getFormOfParticipationDAO();
	}

	// ============================================================
	// METHODS
	// ============================================================

	public FormOfParticipation findById(int id) {
		FormOfParticipation entity = dao.findById(id);
		if (entity == null) {
			logger.info("Warning in: " + "findById(" + id + ")"
					+ " return null.");
		}
		return entity;
	}

	public FormOfParticipation findByName(String name) {
		FormOfParticipation entity = dao.findByName(name);
		if (entity == null) {
			logger.info("Warning in: " + "findByName(" + name + ")"
					+ " return null.");
		}
		return entity;
	}

	public List<FormOfParticipation> list() {
		List<FormOfParticipation> result = dao.list();
		if (result == null || (result != null && result.isEmpty())) {
			logger.info("Warning in: " + "list()" + " return null or empty.");
		}
		return result;
	}
}
