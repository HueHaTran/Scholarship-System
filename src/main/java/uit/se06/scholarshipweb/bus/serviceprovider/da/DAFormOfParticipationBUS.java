package uit.se06.scholarshipweb.bus.serviceprovider.da;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.bus.factory.IFormOfParticipationBUS;
import uit.se06.scholarshipweb.dao.factory.DAOAbstractFactory;
import uit.se06.scholarshipweb.dao.factory.IDAO;
import uit.se06.scholarshipweb.dao.factory.IFormOfParticipationDAO;
import uit.se06.scholarshipweb.model.FormOfParticipation;

public class DAFormOfParticipationBUS extends DABaseBUS<FormOfParticipation>
		implements IFormOfParticipationBUS {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(DAFormOfParticipationBUS.class);

	private IFormOfParticipationDAO dao;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public DAFormOfParticipationBUS() {
		dao = DAOAbstractFactory.INS.getFormOfParticipationDAO();
	}

	// ============================================================
	// METHODS
	// ============================================================

	@Override
	protected IDAO<FormOfParticipation> getDAO() {
		return dao;
	}

	@Override
	protected Logger getLogger() {
		return logger;
	}
}
