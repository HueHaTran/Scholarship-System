package uit.se06.scholarshipweb.bus.serviceprovider.da;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.bus.factory.IDisabilityBUS;
import uit.se06.scholarshipweb.dao.factory.DAOAbstractFactory;
import uit.se06.scholarshipweb.dao.factory.IDAO;
import uit.se06.scholarshipweb.dao.factory.IDisabilityDAO;
import uit.se06.scholarshipweb.model.Disability;

public class DADisabilityBUS extends DABaseBUS<Disability> implements
		IDisabilityBUS {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(DADisabilityBUS.class);

	private IDisabilityDAO dao;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public DADisabilityBUS() {
		dao = DAOAbstractFactory.INS.getDisabilityDAO();
	}

	// ============================================================
	// METHODS
	// ============================================================

	@Override
	protected IDAO<Disability> getDAO() {
		return dao;
	}

	@Override
	protected Logger getLogger() {
		return logger;
	}
}
