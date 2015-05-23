package uit.se06.scholarshipweb.bus.serviceprovider.da;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.bus.factory.IGenderBUS;
import uit.se06.scholarshipweb.dao.factory.DAOAbstractFactory;
import uit.se06.scholarshipweb.dao.factory.IGenderDAO;
import uit.se06.scholarshipweb.model.Gender;

public class DAGenderBUS implements IGenderBUS {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(DAGenderBUS.class);

	private IGenderDAO dao;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public DAGenderBUS() {
		dao = DAOAbstractFactory.INS.getGenderDAO();
	}

	// ============================================================
	// METHODS
	// ============================================================

	@Override
	public Gender findById(int id) {
		Gender entity = dao.findById(id);
		if (entity == null) {
			logger.info("Warning in: " + "findById(" + id + ")"
					+ " return null.");
		}
		return entity;
	}

	@Override
	public Gender findByName(String name) {
		Gender entity = dao.findByName(name);
		if (entity == null) {
			logger.info("Warning in: " + "findByName(" + name + ")"
					+ " return null.");
		}
		return entity;
	}

	@Override
	public List<Gender> list() {
		List<Gender> result = dao.list();
		if (result == null || (result != null && result.isEmpty())) {
			logger.info("Warning in: " + "list()" + " return null or empty.");
		}
		return result;
	}
}
