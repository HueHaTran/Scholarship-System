package uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.dao.factory.IScholarshipTypeDAO;
import uit.se06.scholarshipweb.model.ScholarshipType;

public class DAJdbcScholarshipTypeDAO extends DAJdbcBaseDAO<ScholarshipType>
		implements IScholarshipTypeDAO {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(DAJdbcScholarshipTypeDAO.class);

	public final String COL_ID = "scholarship_type_id";
	public final String COL_NAME = "scholarship_type_name";

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public DAJdbcScholarshipTypeDAO() {
		super(ScholarshipType.class);
	}

	// ============================================================
	// OVERRIDE METHODS
	// ============================================================

	@Override
	protected Logger getLogger() {
		return logger;
	}

	@Override
	public ScholarshipType findById(int id) {
		return findBy(COL_ID, String.valueOf(id));
	}

	@Override
	public ScholarshipType findByName(String name) {
		return findBy(COL_NAME, name);
	}

	// ============================================================
	// OTHER METHODS
	// ============================================================

}
