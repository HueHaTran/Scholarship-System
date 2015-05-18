package uit.se06.scholarshipweb.bus;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.dao.IFamilyPolicyDAO;
import uit.se06.scholarshipweb.dao.impl.JdbcFamilyPolicyDAO;
import uit.se06.scholarshipweb.model.FamilyPolicy;

public class FamilyPolicyBUS {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(FamilyPolicyBUS.class);

	private IFamilyPolicyDAO dao;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public FamilyPolicyBUS(SessionFactory sessionFactory) {
		dao = new JdbcFamilyPolicyDAO(sessionFactory);
	}

	// ============================================================
	// METHODS
	// ============================================================

	public FamilyPolicy findById(int id) {
		FamilyPolicy entity = dao.findById(id);
		if (entity == null) {
			logger.info("Warning in: " + "findById(" + id + ")"
					+ " return null.");
		}
		return entity;
	}

	public FamilyPolicy findByName(String name) {
		FamilyPolicy entity = dao.findByName(name);
		if (entity == null) {
			logger.info("Warning in: " + "findByName(" + name + ")"
					+ " return null.");
		}
		return entity;
	}

	public List<FamilyPolicy> list() {
		List<FamilyPolicy> result = dao.list();
		if (result == null || (result != null && result.isEmpty())) {
			logger.info("Warning in: " + "list()" + " return null or empty.");
		}
		return result;
	}
}
