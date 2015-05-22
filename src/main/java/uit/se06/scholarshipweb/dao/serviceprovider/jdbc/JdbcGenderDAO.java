package uit.se06.scholarshipweb.dao.serviceprovider.jdbc;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.dao.factory.IGenderDAO;
import uit.se06.scholarshipweb.model.Gender;

public class JdbcGenderDAO extends JdbcBaseDAO<Gender> implements IGenderDAO {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(JdbcGenderDAO.class);

	public final String COL_ID = "gender_id";
	public final String COL_NAME = "gender_name";

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public JdbcGenderDAO() {
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

	@Override
	public List<Gender> list() {
		return getAll();
	}

	// ============================================================
	// OTHER METHODS
	// ============================================================

}
