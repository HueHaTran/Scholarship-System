package uit.se06.scholarshipweb.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.dao.IProvinceDAO;
import uit.se06.scholarshipweb.model.AcademicLevel;
import uit.se06.scholarshipweb.model.Province;

public class JdbcProvinceDAO extends JdbcBaseDAO<Province> implements
		IProvinceDAO {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(JdbcProvinceDAO.class);

	public final String COL_ID = "province_id";
	public final String COL_NAME = "province_name";
	public final String COL_COUNTRY_ID = "country_id";

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
	protected Logger getLogger() {
		return logger;
	}

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

	@Override
	public List<Province> listByCountry(int countryId) {
		return listBy(COL_COUNTRY_ID, String.valueOf(countryId));
	}

	// ============================================================
	// OTHER METHODS
	// ============================================================

}
