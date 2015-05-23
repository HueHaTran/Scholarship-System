package uit.se06.scholarshipweb.bus.serviceprovider.da;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.bus.factory.ISchoolBUS;
import uit.se06.scholarshipweb.dao.factory.DAOAbstractFactory;
import uit.se06.scholarshipweb.dao.factory.ISchoolDAO;
import uit.se06.scholarshipweb.model.School;

public class DASchoolBUS implements ISchoolBUS {

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
	public School findById(int id) {
		School entity = dao.findById(id);
		if (entity == null) {
			logger.info("Warning in: " + "findById(" + id + ")"
					+ " return null.");
		}
		return entity;
	}

	@Override
	public School findByName(String name) {
		School entity = dao.findByName(name);
		if (entity == null) {
			logger.info("Warning in: " + "findByName(" + name + ")"
					+ " return null.");
		}
		return entity;
	}

	@Override
	public List<School> list() {
		List<School> result = dao.list();
		if (result == null || (result != null && result.isEmpty())) {
			logger.info("Warning in: " + "list()" + " return null or empty.");
		}
		return result;
	}
}
