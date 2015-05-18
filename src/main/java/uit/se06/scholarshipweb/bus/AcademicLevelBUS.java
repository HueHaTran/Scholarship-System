package uit.se06.scholarshipweb.bus;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.dao.IAcademicLevelDAO;
import uit.se06.scholarshipweb.dao.IAcademicLevelDetailDAO;
import uit.se06.scholarshipweb.dao.impl.JdbcAcademicLevelDAO;
import uit.se06.scholarshipweb.dao.impl.JdbcAcademicLevelDetailDAO;
import uit.se06.scholarshipweb.model.AcademicLevel;

public class AcademicLevelBUS {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(CountryBUS.class);

	private IAcademicLevelDAO dao;
	private IAcademicLevelDetailDAO daoDetail;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public AcademicLevelBUS(SessionFactory sessionFactory) {
		dao = new JdbcAcademicLevelDAO(sessionFactory);
		daoDetail = new JdbcAcademicLevelDetailDAO(sessionFactory);
	}

	// ============================================================
	// METHODS
	// ============================================================

	/**
	 * with detail
	 * 
	 * @param id
	 * @return
	 */
	public AcademicLevel findById(int id) {
		AcademicLevel entity = dao.findById(id);

		if (entity == null) {
			logger.info("Warning: " + "findById(" + id + ")" + " return null.");
		} else {
			entity.setAcademicLevelDetails(daoDetail
					.findByAcademicLevelId(entity.getId()));
		}

		return entity;
	}

	/**
	 * with detail
	 * 
	 * @param name
	 * @return
	 */
	public AcademicLevel findByName(String name) {
		AcademicLevel entity = dao.findByName(name);

		if (entity == null) {
			logger.info("Warning: " + "findByName(" + name + ")"
					+ " return null.");
		} else {
			entity.setAcademicLevelDetails(daoDetail
					.findByAcademicLevelId(entity.getId()));
		}

		return entity;
	}

	/**
	 * general info only, no detail
	 * 
	 * @return
	 */
	public List<AcademicLevel> list() {
		List<AcademicLevel> result = dao.list();
		if (result == null || (result != null && result.isEmpty())) {
			logger.info("Warning: " + "list()" + " return null or empty.");
		}
		return result;
	}

	/**
	 * with detail
	 * 
	 * @return
	 */
	public List<AcademicLevel> listWithDetails() {
		List<AcademicLevel> result = dao.listWithDetails();
		if (result == null || (result != null && result.isEmpty())) {
			logger.info("Warning: " + "list()" + " return null or empty.");
		}
		return result;
	}
}
