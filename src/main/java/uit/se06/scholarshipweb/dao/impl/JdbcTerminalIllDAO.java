package uit.se06.scholarshipweb.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import uit.se06.scholarshipweb.dao.ITerminalIllDAO;
import uit.se06.scholarshipweb.model.AcademicLevel;
import uit.se06.scholarshipweb.model.TerminalIll;

public class JdbcTerminalIllDAO extends JdbcBaseDAO<TerminalIll> implements ITerminalIllDAO {

	// ============================================================
	// VARIABLES
	// ============================================================

	public final String COL_ID = "terminal_ill_id";
	public final String COL_NAME = "terminal_ill_name";

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public JdbcTerminalIllDAO(SessionFactory sessionFactory) {
		super(AcademicLevel.class, sessionFactory);
	}

	// ============================================================
	// OVERRIDE METHODS
	// ============================================================

	@Override
	public TerminalIll findById(int id) {
		return findBy(COL_ID, String.valueOf(id));
	}

	@Override
	public TerminalIll findByName(String name) {
		return findBy(COL_NAME, name);
	}

	@Override
	public List<TerminalIll> list() {
		return getAll();
	}

	// ============================================================
	// OTHER METHODS
	// ============================================================

}
