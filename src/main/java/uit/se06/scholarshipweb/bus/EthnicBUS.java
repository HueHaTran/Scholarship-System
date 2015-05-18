package uit.se06.scholarshipweb.bus;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.dao.IEthnicDAO;
import uit.se06.scholarshipweb.dao.impl.JdbcEthnicDAO;
import uit.se06.scholarshipweb.model.Ethnic;

public class EthnicBUS {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(EthnicBUS.class);

	private IEthnicDAO dao;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public EthnicBUS(SessionFactory sessionFactory) {
		dao = new JdbcEthnicDAO(sessionFactory);
	}

	// ============================================================
	// METHODS
	// ============================================================

	public Ethnic findById(int id) {
		Ethnic entity = dao.findById(id);
		if (entity == null) {
			logger.info("Warning in: " + "findById(" + id + ")"
					+ " return null.");
		}
		return entity;
	}

	public Ethnic findByName(String name) {
		Ethnic entity = dao.findByName(name);
		if (entity == null) {
			logger.info("Warning in: " + "findByName(" + name + ")"
					+ " return null.");
		}
		return entity;
	}

	public List<Ethnic> list() {
		List<Ethnic> result = dao.list();
		if (result == null || (result != null && result.isEmpty())) {
			logger.info("Warning in: " + "list()" + " return null or empty.");
		}
		return result;
	}
}
