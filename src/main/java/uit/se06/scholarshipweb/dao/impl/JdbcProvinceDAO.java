package uit.se06.scholarshipweb.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import uit.se06.scholarshipweb.dao.IProvinceDAO;
import uit.se06.scholarshipweb.model.AcademicLevel;
import uit.se06.scholarshipweb.model.Province;

public class JdbcProvinceDAO extends JdbcBaseDAO<Province> implements IProvinceDAO {

	// ============================================================
	// VARIABLES
	// ============================================================

	private final String COL_ID = "province_id";
	private final String COL_NAME = "province_name";

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public JdbcProvinceDAO(SessionFactory sessionFactory) {
		super(AcademicLevel.class, sessionFactory);
	}

	// ============================================================
	// OVERRIDE METHODS
	// ============================================================

	@Override
	public Province findById(int id) {
		return findBy(COL_ID, String.valueOf(id));
	}

	@Override
	public Province findByName(String name) {
		return findBy(COL_NAME, name);
	}

	@Override
	public List<Province> list() {
		return getAll();
	}

	// ============================================================
	// OTHER METHODS
	// ============================================================

}
