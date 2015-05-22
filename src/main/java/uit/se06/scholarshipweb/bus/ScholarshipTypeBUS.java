package uit.se06.scholarshipweb.bus;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.dao.factory.DAOAbstractFactory;
import uit.se06.scholarshipweb.dao.factory.IScholarshipTypeDAO;
import uit.se06.scholarshipweb.model.ScholarshipType;

public class ScholarshipTypeBUS {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(ScholarshipTypeBUS.class);

	private IScholarshipTypeDAO dao;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public ScholarshipTypeBUS() {
		dao = DAOAbstractFactory.INS.getScholarshipTypeDAO();
	}

	// ============================================================
	// METHODS
	// ============================================================

	public ScholarshipType findById(int id) {
		ScholarshipType entity = dao.findById(id);
		if (entity == null) {
			logger.info("Warning in: " + "findById(" + id + ")"
					+ " return null.");
		}
		return entity;
	}

	public ScholarshipType findByName(String name) {
		ScholarshipType entity = dao.findByName(name);
		if (entity == null) {
			logger.info("Warning in: " + "findByName(" + name + ")"
					+ " return null.");
		}
		return entity;
	}

	public List<ScholarshipType> list() {
		List<ScholarshipType> result = dao.list();
		if (result == null || (result != null && result.isEmpty())) {
			logger.info("Warning in: " + "list()" + " return null or empty.");
		}
		return result;
	}
}
