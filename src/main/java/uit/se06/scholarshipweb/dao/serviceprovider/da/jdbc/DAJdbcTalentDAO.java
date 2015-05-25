package uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.dao.factory.ITalentDAO;
import uit.se06.scholarshipweb.model.Talent;

public class DAJdbcTalentDAO extends DAJdbcBaseDAO<Talent> implements
		ITalentDAO {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(DAJdbcTalentDAO.class);

	public final String COL_ID = "talent_id";
	public final String COL_NAME = "talent_name";

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public DAJdbcTalentDAO() {
		super(Talent.class);
	}

	// ============================================================
	// OVERRIDE METHODS
	// ============================================================

	@Override
	protected Logger getLogger() {
		return logger;
	}

	@Override
	public Talent findById(int id) {
		return findBy(COL_ID, String.valueOf(id));
	}

	@Override
	public Talent findByName(String name) {
		return findBy(COL_NAME, name);
	}

	// ============================================================
	// OTHER METHODS
	// ============================================================

}
