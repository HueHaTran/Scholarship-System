package uit.se06.scholarshipweb.bus.serviceprovider.da;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.bus.factory.ISponsorBUS;
import uit.se06.scholarshipweb.dao.factory.DAOAbstractFactory;
import uit.se06.scholarshipweb.dao.factory.ISponsorDAO;
import uit.se06.scholarshipweb.model.Sponsor;

public class DASponsorBUS implements ISponsorBUS {

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
	public Sponsor findById(int id) {
		Sponsor entity = dao.findById(id);
		if (entity == null) {
			logger.info("Warning in: " + "findById(" + id + ")"
					+ " return null.");
		}
		return entity;
	}

	@Override
	public Sponsor findByName(String name) {
		Sponsor entity = dao.findByName(name);
		if (entity == null) {
			logger.info("Warning in: " + "findByName(" + name + ")"
					+ " return null.");
		}
		return entity;
	}

	@Override
	public List<Sponsor> list() {
		List<Sponsor> result = dao.list();
		if (result == null || (result != null && result.isEmpty())) {
			logger.info("Warning in: " + "list()" + " return null or empty.");
		}
		return result;
	}
}
