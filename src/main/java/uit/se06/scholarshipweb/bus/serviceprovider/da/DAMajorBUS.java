package uit.se06.scholarshipweb.bus.serviceprovider.da;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.bus.factory.IMajorBUS;
import uit.se06.scholarshipweb.dao.factory.DAOAbstractFactory;
import uit.se06.scholarshipweb.dao.factory.IMajorDAO;
import uit.se06.scholarshipweb.model.Major;

public class DAMajorBUS implements IMajorBUS {

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
	public Major findById(int id) {
		Major entity = dao.findById(id);
		if (entity == null) {
			logger.info("Warning in: " + "findById(" + id + ")"
					+ " return null.");
		}
		return entity;
	}

	@Override
	public Major findByName(String name) {
		Major entity = dao.findByName(name);
		if (entity == null) {
			logger.info("Warning in: " + "findByName(" + name + ")"
					+ " return null.");
		}
		return entity;
	}

	@Override
	public List<Major> list() {
		List<Major> result = dao.list();
		if (result == null || (result != null && result.isEmpty())) {
			logger.info("Warning in: " + "list()" + " return null or empty.");
		}
		return result;
	}
}
