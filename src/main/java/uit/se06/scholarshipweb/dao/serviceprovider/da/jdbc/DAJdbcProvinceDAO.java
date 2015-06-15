package uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.dao.factory.IProvinceDAO;
import uit.se06.scholarshipweb.dao.util.ILoadingRelatedEntityListener;
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

	private ILoadingRelatedEntityListener<Province> loadinglistener = new ILoadingRelatedEntityListener<Province>() {
		@Override
		public void load(Province entity) {
			Hibernate.initialize(entity.getCountry());
		}
	};

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
		return findBy(COL_ID, String.valueOf(id), loadinglistener);
	}

	@Override
	public Province findByName(String name) {
		return findBy(COL_NAME, name, loadinglistener);
	}

	@Override
	public Set<Province> listByCountry(int countryId) {
		return listBy(COL_COUNTRY_ID, String.valueOf(countryId));
	}

	@Override
	public Set<Province> listBasicInfoByCountry(int countryId) {
		return listBy(COL_COUNTRY_ID, String.valueOf(countryId));
	}
	// ============================================================
	// OTHER METHODS
	// ============================================================

	@Override
	public List<Integer> findIdListByCountryId(int countryId) {
		List<Integer> result = new ArrayList<Integer>();

		Set<Province> set = listByCountry(countryId);
		Iterator<Province> iter = set.iterator();

		while (iter.hasNext()) {
			result.add(((Province) iter.next()).getId());
		}

		return result;
	}

}
