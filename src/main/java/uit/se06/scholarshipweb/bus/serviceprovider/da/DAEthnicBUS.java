package uit.se06.scholarshipweb.bus.serviceprovider.da;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.bus.factory.IEthnicBUS;
import uit.se06.scholarshipweb.dao.factory.DAOAbstractFactory;
import uit.se06.scholarshipweb.dao.factory.IDAO;
import uit.se06.scholarshipweb.dao.factory.IEthnicDAO;
import uit.se06.scholarshipweb.model.Ethnic;

public class DAEthnicBUS extends DABaseBUS<Ethnic> implements IEthnicBUS {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(DAEthnicBUS.class);

	private IEthnicDAO dao;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public DAEthnicBUS() {
		dao = DAOAbstractFactory.INS.getEthnicDAO();
	}

	// ============================================================
	// METHODS
	// ============================================================

	@Override
	protected IDAO<Ethnic> getDAO() {
		return dao;
	}

	@Override
	protected Logger getLogger() {
		return logger;
	}
}
