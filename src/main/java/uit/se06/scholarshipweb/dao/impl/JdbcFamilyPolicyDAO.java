package uit.se06.scholarshipweb.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import uit.se06.scholarshipweb.dao.IFamilyPolicyDAO;
import uit.se06.scholarshipweb.model.AcademicLevel;
import uit.se06.scholarshipweb.model.FamilyPolicy;

public class JdbcFamilyPolicyDAO extends JdbcBaseDAO<FamilyPolicy> implements IFamilyPolicyDAO {

	// ============================================================
	// VARIABLES
	// ============================================================

	public final String COL_ID = "family_policy_id";
	public final String COL_NAME = "family_policy_name";

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public JdbcFamilyPolicyDAO(SessionFactory sessionFactory) {
		super(AcademicLevel.class, sessionFactory);
	}

	// ============================================================
	// OVERRIDE METHODS
	// ============================================================

	@Override
	public FamilyPolicy findById(int id) {
		return findBy(COL_ID, String.valueOf(id));
	}

	@Override
	public FamilyPolicy findByName(String name) {
		return findBy(COL_NAME, name);
	}

	@Override
	public List<FamilyPolicy> list() {
		return getAll();
	}

	// ============================================================
	// OTHER METHODS
	// ============================================================

}
