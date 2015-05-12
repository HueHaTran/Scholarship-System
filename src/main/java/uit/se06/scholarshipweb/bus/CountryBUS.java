package uit.se06.scholarshipweb.bus;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.dao.ICountryDAO;
import uit.se06.scholarshipweb.dao.IProvinceDAO;
import uit.se06.scholarshipweb.dao.impl.JdbcCountryDAO;
import uit.se06.scholarshipweb.dao.impl.JdbcProvinceDAO;
import uit.se06.scholarshipweb.model.Country;

public class CountryBUS {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(CountryBUS.class);

	private ICountryDAO dao;
	private IProvinceDAO daoProvince;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public CountryBUS(SessionFactory sessionFactory) {
		dao = new JdbcCountryDAO(sessionFactory);
		daoProvince = new JdbcProvinceDAO(sessionFactory);
	}

	// ============================================================
	// METHODS
	// ============================================================

	/**
	 * with detail
	 * 
	 * @param id
	 * @return
	 */
	public Country findById(int id) {
		Country entity = dao.findById(id);
		if (entity == null) {
			logger.info("Warning in " + this.getClass().getCanonicalName()
					+ ": " + "findById(" + id + ")" + " return null.");
		} else {
			entity.setProvinces(daoProvince.listByCountry(entity.getCountryId()));
		}
		return entity;
	}

	/**
	 * with detail
	 * 
	 * @param name
	 * @return
	 */
	public Country findByName(String name) {
		Country entity = dao.findByName(name);
		if (entity == null) {
			logger.info("Warning in " + this.getClass().getCanonicalName()
					+ ": " + "findByName(" + name + ")" + " return null.");
		} else {
			entity.setProvinces(daoProvince.listByCountry(entity.getCountryId()));
		}
		return entity;
	}

	/**
	 * general info only, no detail
	 * 
	 * @return
	 */
	public List<Country> list() {
		List<Country> result = dao.list();
		if (result == null || (result != null && result.isEmpty())) {
			logger.info("Warning in " + this.getClass().getCanonicalName()
					+ ": " + "list()" + " return null or empty.");
		}
		return result;
	}
}