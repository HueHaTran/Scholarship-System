package uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.dao.factory.IFamilyPolicyDAO;
import uit.se06.scholarshipweb.model.FamilyPolicy;

public class DAJdbcFamilyPolicyDAO extends DAJdbcBaseDAO<FamilyPolicy>
		implements IFamilyPolicyDAO {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(DAJdbcFamilyPolicyDAO.class);

	public final String COL_ID = "family_policy_id";
	public final String COL_NAME = "family_policy_name";

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public DAJdbcFamilyPolicyDAO() {
		super(FamilyPolicy.class);
	}

	// ============================================================
	// OVERRIDE METHODS
	// ============================================================

	@Override
	protected Logger getLogger() {
		return logger;
	}

	@Override
	public FamilyPolicy findById(int id) {
		return findBy(COL_ID, String.valueOf(id));
	}

	@Override
	public FamilyPolicy findByName(String name) {
		return findBy(COL_NAME, name);
	}

	// ============================================================
	// OTHER METHODS
	// ============================================================

}
