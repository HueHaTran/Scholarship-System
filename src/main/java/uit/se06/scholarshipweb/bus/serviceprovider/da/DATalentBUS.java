package uit.se06.scholarshipweb.bus.serviceprovider.da;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.bus.factory.ITalentBUS;
import uit.se06.scholarshipweb.dao.factory.DAOAbstractFactory;
import uit.se06.scholarshipweb.dao.factory.ITalentDAO;
import uit.se06.scholarshipweb.model.Talent;

public class DATalentBUS implements ITalentBUS {

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
	public Talent findById(int id) {
		Talent entity = dao.findById(id);
		if (entity == null) {
			logger.info("Warning in: " + "findById(" + id + ")"
					+ " return null.");
		}
		return entity;
	}

	@Override
	public Talent findByName(String name) {
		Talent entity = dao.findByName(name);
		if (entity == null) {
			logger.info("Warning in: " + "findByName(" + name + ")"
					+ " return null.");
		}
		return entity;
	}

	@Override
	public List<Talent> list() {
		List<Talent> result = dao.list();
		if (result == null || (result != null && result.isEmpty())) {
			logger.info("Warning in " + this.getClass().getCanonicalName()
					+ ": " + "list()" + " return null or empty.");
		}
		return result;
	}
}
