package uit.se06.scholarshipweb.bus.serviceprovider.da;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.bus.factory.ISponsorBUS;
import uit.se06.scholarshipweb.dao.factory.DAOAbstractFactory;
import uit.se06.scholarshipweb.dao.factory.IDAO;
import uit.se06.scholarshipweb.dao.factory.ISponsorDAO;
import uit.se06.scholarshipweb.model.Sponsor;

public class DASponsorBUS extends DABaseBUS<Sponsor> implements ISponsorBUS {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(DASponsorBUS.class);

	private ISponsorDAO dao;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public DASponsorBUS() {
		dao = DAOAbstractFactory.INS.getSponsorDAO();
	}

	// ============================================================
	// METHODS
	// ============================================================

	@Override
	protected IDAO<Sponsor> getDAO() {
		return dao;
	}

	@Override
	protected Logger getLogger() {
		return logger;
	}
}
