package uit.se06.scholarshipweb.bus.serviceprovider.da;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.bus.factory.ITerminalIllBUS;
import uit.se06.scholarshipweb.dao.factory.DAOAbstractFactory;
import uit.se06.scholarshipweb.dao.factory.IDAO;
import uit.se06.scholarshipweb.dao.factory.ITerminalIllDAO;
import uit.se06.scholarshipweb.model.TerminalIll;

public class DATerminalIllBUS extends DABaseBUS<TerminalIll> implements
		ITerminalIllBUS {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(DATerminalIllBUS.class);

	private ITerminalIllDAO dao;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public DATerminalIllBUS() {
		dao = DAOAbstractFactory.INS.getTerminalIllDAO();
	}

	// ============================================================
	// METHODS
	// ============================================================

	@Override
	protected IDAO<TerminalIll> getDAO() {
		return dao;
	}

	@Override
	protected Logger getLogger() {
		return logger;
	}
}
