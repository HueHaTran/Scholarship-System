package uit.se06.scholarshipweb.bus;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.dao.factory.DAOAbstractFactory;
import uit.se06.scholarshipweb.dao.factory.ITerminalIllDAO;
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

	public TerminalIllBUS() {
		dao = DAOAbstractFactory.INS.getTerminalIllDAO();
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
