package uit.se06.scholarshipweb.bus.serviceprovider.da;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.bus.factory.ISchoolBUS;
import uit.se06.scholarshipweb.dao.factory.DAOAbstractFactory;
import uit.se06.scholarshipweb.dao.factory.IDAO;
import uit.se06.scholarshipweb.dao.factory.ISchoolDAO;
import uit.se06.scholarshipweb.model.School;

public class DASchoolBUS extends DABaseBUS<School> implements ISchoolBUS {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(DASchoolBUS.class);

	private ISchoolDAO dao;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public DASchoolBUS() {
		dao = DAOAbstractFactory.INS.getSchoolDAO();
	}

	// ============================================================
	// METHODS
	// ============================================================

	@Override
	protected IDAO<School> getDAO() {
		return dao;
	}

	@Override
	protected Logger getLogger() {
		return logger;
	}
}
