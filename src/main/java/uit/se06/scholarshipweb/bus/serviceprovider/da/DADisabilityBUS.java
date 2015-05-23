package uit.se06.scholarshipweb.bus.serviceprovider.da;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.bus.factory.IDisabilityBUS;
import uit.se06.scholarshipweb.dao.factory.DAOAbstractFactory;
import uit.se06.scholarshipweb.dao.factory.IDisabilityDAO;
import uit.se06.scholarshipweb.model.Disability;

public class DADisabilityBUS implements IDisabilityBUS {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(DADisabilityBUS.class);

	private IDisabilityDAO dao;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public DADisabilityBUS() {
		dao = DAOAbstractFactory.INS.getDisabilityDAO();
	}

	// ============================================================
	// METHODS
	// ============================================================

	@Override
	public Disability findById(int id) {
		Disability entity = dao.findById(id);
		if (entity == null) {
			logger.info("Warning in " + this.getClass().getCanonicalName()
					+ ": " + "findById(" + id + ")" + " return null.");
		}
		return entity;
	}

	@Override
	public Disability findByName(String name) {
		Disability entity = dao.findByName(name);
		if (entity == null) {
			logger.info("Warning in " + this.getClass().getCanonicalName()
					+ ": " + "findByName(" + name + ")" + " return null.");
		}
		return entity;
	}

	@Override
	public List<Disability> list() {
		List<Disability> result = dao.list();
		if (result == null || (result != null && result.isEmpty())) {
			logger.info("Warning in " + this.getClass().getCanonicalName()
					+ ": " + "list()" + " return null or empty.");
		}
		return result;
	}
}
