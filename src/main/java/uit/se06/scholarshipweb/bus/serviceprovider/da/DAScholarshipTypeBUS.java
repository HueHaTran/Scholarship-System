package uit.se06.scholarshipweb.bus.serviceprovider.da;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.bus.factory.IScholarshipTypeBUS;
import uit.se06.scholarshipweb.dao.factory.DAOAbstractFactory;
import uit.se06.scholarshipweb.dao.factory.IScholarshipTypeDAO;
import uit.se06.scholarshipweb.model.ScholarshipType;

public class DAScholarshipTypeBUS implements IScholarshipTypeBUS {

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
	public ScholarshipType findById(int id) {
		ScholarshipType entity = dao.findById(id);
		if (entity == null) {
			logger.info("Warning in: " + "findById(" + id + ")"
					+ " return null.");
		}
		return entity;
	}

	@Override
	public ScholarshipType findByName(String name) {
		ScholarshipType entity = dao.findByName(name);
		if (entity == null) {
			logger.info("Warning in: " + "findByName(" + name + ")"
					+ " return null.");
		}
		return entity;
	}

	@Override
	public List<ScholarshipType> list() {
		List<ScholarshipType> result = dao.list();
		if (result == null || (result != null && result.isEmpty())) {
			logger.info("Warning in: " + "list()" + " return null or empty.");
		}
		return result;
	}
}
