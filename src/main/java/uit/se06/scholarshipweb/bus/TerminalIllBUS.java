package uit.se06.scholarshipweb.bus;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.dao.ITerminalIllDAO;
import uit.se06.scholarshipweb.dao.impl.JdbcTerminalIllDAO;
import uit.se06.scholarshipweb.model.TerminalIll;

public class TerminalIllBUS {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(TerminalIllBUS.class);

	private ITerminalIllDAO dao;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public TerminalIllBUS(SessionFactory sessionFactory) {
		dao = new JdbcTerminalIllDAO(sessionFactory);
	}

	// ============================================================
	// METHODS
	// ============================================================

	public TerminalIll findById(int id) {
		TerminalIll entity = dao.findById(id);
		if (entity == null) {
			logger.info("Warning in: " + "findById(" + id + ")"
					+ " return null.");
		}
		return entity;
	}

	public TerminalIll findByName(String name) {
		TerminalIll entity = dao.findByName(name);
		if (entity == null) {
			logger.info("Warning in: " + "findByName(" + name + ")"
					+ " return null.");
		}
		return entity;
	}

	public List<TerminalIll> list() {
		List<TerminalIll> result = dao.list();
		if (result == null || (result != null && result.isEmpty())) {
			logger.info("Warning in: " + "list()" + " return null or empty.");
		}
		return result;
	}
}
