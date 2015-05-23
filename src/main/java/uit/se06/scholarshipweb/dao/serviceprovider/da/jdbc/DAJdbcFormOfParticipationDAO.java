package uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.dao.factory.IFormOfParticipationDAO;
import uit.se06.scholarshipweb.model.FormOfParticipation;

public class DAJdbcFormOfParticipationDAO extends
		DAJdbcBaseDAO<FormOfParticipation> implements IFormOfParticipationDAO {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(DAJdbcFormOfParticipationDAO.class);

	public final String COL_ID = "form_of_participation_id";
	public final String COL_NAME = "form_of_participation_name";

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public DAJdbcFormOfParticipationDAO() {
		super(FormOfParticipation.class );
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
