package uit.se06.scholarshipweb.bus.serviceprovider.da;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.bus.factory.IReligionBUS;
import uit.se06.scholarshipweb.dao.factory.DAOAbstractFactory;
import uit.se06.scholarshipweb.dao.factory.IReligionDAO;
import uit.se06.scholarshipweb.model.Religion;

public class DAReligionBUS implements IReligionBUS {

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
	public Religion findById(int id) {
		Religion entity = dao.findById(id);
		if (entity == null) {
			logger.info("Warning in: " + "findById(" + id + ")"
					+ " return null.");
		}
		return entity;
	}

	@Override
	public Religion findByName(String name) {
		Religion entity = dao.findByName(name);
		if (entity == null) {
			logger.info("Warning in: " + "findByName(" + name + ")"
					+ " return null.");
		}
		return entity;
	}

	@Override
	public List<Religion> list() {
		List<Religion> result = dao.list();
		if (result == null || (result != null && result.isEmpty())) {
			logger.info("Warning in: " + "list()" + " return null or empty.");
		}
		return result;
	}
}
