package uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.dao.factory.ICountryDAO;
import uit.se06.scholarshipweb.model.Country;

public class DAJdbcCountryDAO extends DAJdbcBaseDAO<Country> implements
		ICountryDAO {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(DAJdbcCountryDAO.class);

	public final String COL_ID = "countryId";
	public final String COL_NAME = "countryName";

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public DAJdbcCountryDAO() {
		super(Country.class);
	}

	// ============================================================
	// OVERRIDE METHODS
	// ============================================================

	@Override
	protected Logger getLogger() {
		return logger;
	}

	@Override
	public Country findById(int id) {
		return findBy(COL_ID, String.valueOf(id));
	}

	@Override
	public Country findByName(String name) {
		return findBy(COL_NAME, name);
	}

	// ============================================================
	// OTHER METHODS
	// ============================================================

}
