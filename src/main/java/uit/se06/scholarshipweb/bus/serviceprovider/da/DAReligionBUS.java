package uit.se06.scholarshipweb.bus.serviceprovider.da;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.bus.factory.IReligionBUS;
import uit.se06.scholarshipweb.dao.factory.DAOAbstractFactory;
import uit.se06.scholarshipweb.dao.factory.IDAO;
import uit.se06.scholarshipweb.dao.factory.IReligionDAO;
import uit.se06.scholarshipweb.model.Religion;

public class DAReligionBUS extends DABaseBUS<Religion> implements IReligionBUS {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(DAReligionBUS.class);

	private IReligionDAO dao;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public DAReligionBUS() {
		dao = DAOAbstractFactory.INS.getReligionDAO();
	}

	// ============================================================
	// METHODS
	// ============================================================

	@Override
	protected IDAO<Religion> getDAO() {
		return dao;
	}

	@Override
	protected Logger getLogger() {
		return logger;
	}
}
