package uit.se06.scholarshipweb.bus.serviceprovider.da;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.bus.factory.IMajorBUS;
import uit.se06.scholarshipweb.dao.factory.DAOAbstractFactory;
import uit.se06.scholarshipweb.dao.factory.IDAO;
import uit.se06.scholarshipweb.dao.factory.IMajorDAO;
import uit.se06.scholarshipweb.model.Major;

public class DAMajorBUS extends DABaseBUS<Major> implements IMajorBUS {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(DAMajorBUS.class);

	private IMajorDAO dao;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public DAMajorBUS() {
		dao = DAOAbstractFactory.INS.getMajorDAO();
	}

	// ============================================================
	// METHODS
	// ============================================================

	@Override
	protected IDAO<Major> getDAO() {
		return dao;
	}

	@Override
	protected Logger getLogger() {
		return logger;
	}
}
