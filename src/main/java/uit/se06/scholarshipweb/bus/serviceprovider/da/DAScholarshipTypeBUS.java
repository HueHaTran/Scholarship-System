package uit.se06.scholarshipweb.bus.serviceprovider.da;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.bus.factory.IScholarshipTypeBUS;
import uit.se06.scholarshipweb.dao.factory.DAOAbstractFactory;
import uit.se06.scholarshipweb.dao.factory.IDAO;
import uit.se06.scholarshipweb.dao.factory.IScholarshipTypeDAO;
import uit.se06.scholarshipweb.model.ScholarshipType;

public class DAScholarshipTypeBUS extends DABaseBUS<ScholarshipType> implements
		IScholarshipTypeBUS {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(DAScholarshipTypeBUS.class);

	private IScholarshipTypeDAO dao;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public DAScholarshipTypeBUS() {
		dao = DAOAbstractFactory.INS.getScholarshipTypeDAO();
	}

	// ============================================================
	// METHODS
	// ============================================================

	@Override
	protected IDAO<ScholarshipType> getDAO() {
		return dao;
	}

	@Override
	protected Logger getLogger() {
		return logger;
	}
}
