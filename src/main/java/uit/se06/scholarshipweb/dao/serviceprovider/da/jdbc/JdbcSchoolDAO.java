package uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.dao.factory.ISchoolDAO;
import uit.se06.scholarshipweb.model.School;

public class JdbcSchoolDAO extends JdbcBaseDAO<School> implements ISchoolDAO {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(JdbcSchoolDAO.class);

	public final String COL_ID = "school_id";
	public final String COL_NAME = "school_name";
	public final String COL_PROVICE_ID = "province_id";
	public final String COL_ADDRESS = "address";
	public final String COL_PHONE = "phone";
	public final String COL_WEBSITE = "website";
	public final String COL_FAX = "fax";

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public JdbcSchoolDAO() {
		super(School.class);
	}

	// ============================================================
	// OVERRIDE METHODS
	// ============================================================

	@Override
	protected Logger getLogger() {
		return logger;
	}

	@Override
	public School findById(int id) {
		return findBy(COL_ID, String.valueOf(id));
	}

	@Override
	public School findByName(String name) {
		return findBy(COL_NAME, name);
	}

	@Override
	public List<School> list() {
		return getAll();
	}

	// ============================================================
	// OTHER METHODS
	// ============================================================

}
