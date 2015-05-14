package uit.se06.scholarshipweb.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.dao.IFormOfParticipationDAO;
import uit.se06.scholarshipweb.model.FormOfParticipation;

public class JdbcFormOfParticipationDAO extends
		JdbcBaseDAO<FormOfParticipation> implements IFormOfParticipationDAO {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(JdbcFormOfParticipationDAO.class);

	public final String COL_ID = "form_of_participation_id";
	public final String COL_NAME = "form_of_participation_name";

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public JdbcFormOfParticipationDAO(SessionFactory sessionFactory) {
		super(FormOfParticipation.class, sessionFactory);
	}

	// ============================================================
	// OVERRIDE METHODS
	// ============================================================

	@Override
	protected Logger getLogger() {
		return logger;
	}

	@Override
	public FormOfParticipation findById(int id) {
		return findBy(COL_ID, String.valueOf(id));
	}

	@Override
	public FormOfParticipation findByName(String name) {
		return findBy(COL_NAME, name);
	}

	@Override
	public List<FormOfParticipation> list() {
		return getAll();
	}

	// ============================================================
	// OTHER METHODS
	// ============================================================

}
