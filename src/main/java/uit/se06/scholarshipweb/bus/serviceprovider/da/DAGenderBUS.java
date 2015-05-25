package uit.se06.scholarshipweb.bus.serviceprovider.da;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.bus.factory.IGenderBUS;
import uit.se06.scholarshipweb.dao.factory.DAOAbstractFactory;
import uit.se06.scholarshipweb.dao.factory.IDAO;
import uit.se06.scholarshipweb.dao.factory.IGenderDAO;
import uit.se06.scholarshipweb.model.Gender;

public class DAGenderBUS extends DABaseBUS<Gender> implements IGenderBUS {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(DAGenderBUS.class);

	private IGenderDAO dao;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public DAGenderBUS() {
		dao = DAOAbstractFactory.INS.getGenderDAO();
	}

	// ============================================================
	// METHODS
	// ============================================================

	@Override
	protected IDAO<Gender> getDAO() {
		return dao;
	}

	@Override
	protected Logger getLogger() {
		return logger;
	}
}
