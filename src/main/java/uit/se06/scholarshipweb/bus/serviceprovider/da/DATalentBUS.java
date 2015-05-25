package uit.se06.scholarshipweb.bus.serviceprovider.da;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.bus.factory.ITalentBUS;
import uit.se06.scholarshipweb.dao.factory.DAOAbstractFactory;
import uit.se06.scholarshipweb.dao.factory.IDAO;
import uit.se06.scholarshipweb.dao.factory.ITalentDAO;
import uit.se06.scholarshipweb.model.Talent;

public class DATalentBUS extends DABaseBUS<Talent> implements ITalentBUS {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(DATalentBUS.class);

	private ITalentDAO dao;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public DATalentBUS() {
		dao = DAOAbstractFactory.INS.getTalentDAO();
	}

	// ============================================================
	// METHODS
	// ============================================================

	@Override
	protected IDAO<Talent> getDAO() {
		return dao;
	}

	@Override
	protected Logger getLogger() {
		return logger;
	}
}
