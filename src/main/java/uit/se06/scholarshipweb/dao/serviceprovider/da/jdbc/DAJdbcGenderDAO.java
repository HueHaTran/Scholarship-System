package uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.dao.factory.IGenderDAO;
import uit.se06.scholarshipweb.model.Gender;

public class DAJdbcGenderDAO extends DAJdbcBaseDAO<Gender> implements
		IGenderDAO {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(DAJdbcGenderDAO.class);

	public final String COL_ID = "gender_id";
	public final String COL_NAME = "gender_name";

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public DAJdbcGenderDAO() {
		super(Gender.class);
	}

	// ============================================================
	// OVERRIDE METHODS
	// ============================================================

	@Override
	protected Logger getLogger() {
		return logger;
	}

	@Override
	public Gender findById(int id) {
		return findBy(COL_ID, String.valueOf(id));
	}

	@Override
	public Gender findByName(String name) {
		return findBy(COL_NAME, name);
	}

	// ============================================================
	// OTHER METHODS
	// ============================================================

}
