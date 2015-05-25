package uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc;

import java.util.List;

import org.hibernate.SQLQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.dao.factory.IProvinceDAO;
import uit.se06.scholarshipweb.model.Province;

public class DAJdbcProvinceDAO extends DAJdbcBaseDAO<Province> implements
		IProvinceDAO {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(DAJdbcProvinceDAO.class);

	public final String COL_ID = "province_id";
	public final String COL_NAME = "province_name";
	public final String COL_COUNTRY_ID = "country_id";

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public DAJdbcProvinceDAO() {
		super(Province.class);
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
	public List<Province> listByCountry(int countryId) {
		return listBy(COL_COUNTRY_ID, String.valueOf(countryId));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Province> listBasicInfoByCountry(int countryId) {
		List<Province> resultList = null;
		StringBuilder builder = new StringBuilder();

		try {
			// query
			builder.append("SELECT " + COL_ID + ", " + COL_NAME);
			builder.append(" FROM ").append(Province.class.getSimpleName());
			builder.append(" WHERE ").append(COL_COUNTRY_ID)
					.append(" = :paramId");

			SQLQuery query = getSession().createSQLQuery(builder.toString());
			query.setParameter("paramId", countryId);

			resultList = query.list();
		} catch (Exception ex) {
			getLogger().error("Query '" + builder.toString() + "' in listBy()");
		} finally {
			closeSession();
		}

		return resultList;

	}
	// ============================================================
	// OTHER METHODS
	// ============================================================

}
