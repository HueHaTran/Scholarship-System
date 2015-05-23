package uit.se06.scholarshipweb.bus.serviceprovider.da;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.bus.factory.ICountryBUS;
import uit.se06.scholarshipweb.dao.factory.DAOAbstractFactory;
import uit.se06.scholarshipweb.dao.factory.ICountryDAO;
import uit.se06.scholarshipweb.dao.factory.IProvinceDAO;
import uit.se06.scholarshipweb.model.Country;
import uit.se06.scholarshipweb.model.Province;

public class DACountryBUS implements ICountryBUS {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(DACountryBUS.class);

	private ICountryDAO dao;
	private IProvinceDAO daoProvince;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public DACountryBUS() {
		dao = DAOAbstractFactory.INS.getCountryDAO();
		daoProvince = DAOAbstractFactory.INS.getProvinceDAO();
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
	@Override
	public Country findById(int id) {
		Country entity = dao.findById(id);
		if (entity == null) {
			logger.info("Warning: " + "findById(" + id + ")" + " return null.");
		} else {
			entity.setProvinces(daoProvince.listByCountry(entity.getId()));
		}
		return entity;
	}

	/**
	 * with detail
	 * 
	 * @param name
	 * @return
	 */
	@Override
	public Country findByName(String name) {
		Country entity = dao.findByName(name);
		if (entity == null) {
			logger.info("Warning: " + "findByName(" + name + ")"
					+ " return null.");
		} else {
			entity.setProvinces(daoProvince.listByCountry(entity.getId()));
		}
		return entity;
	}

	/**
	 * general info only, no detail
	 * 
	 * @return
	 */
	@Override
	public List<Country> list() {
		List<Country> result = dao.list();
		if (result == null || (result != null && result.isEmpty())) {
			logger.info("Warning: " + "list()" + " return null or empty.");
		}
		return result;
	}

	@Override
	public List<Province> listProvinceByCountry(int countryId) {
		List<Province> result = daoProvince.listBasicInfoByCountry(countryId);
		if (result == null || (result != null && result.isEmpty())) {
			logger.info("Warning: " + "listProvinceByCountry(" + countryId
					+ ")" + " return null or empty.");
		}

		return result;
	}
}