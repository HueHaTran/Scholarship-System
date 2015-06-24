package uit.se06.scholarshipweb.bus.serviceprovider.da;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.bus.factory.ICountryBUS;
import uit.se06.scholarshipweb.dao.factory.DAOAbstractFactory;
import uit.se06.scholarshipweb.dao.factory.ICountryDAO;
import uit.se06.scholarshipweb.dao.factory.IDAO;
import uit.se06.scholarshipweb.dao.factory.IProvinceDAO;
import uit.se06.scholarshipweb.model.Country;
import uit.se06.scholarshipweb.model.Province;

public class DACountryBUS extends DABaseBUS<Country> implements ICountryBUS {

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
		Country entity = super.findById(id);
		if (entity != null) {
			entity.setProvinces(new HashSet<Province>(daoProvince
					.listByCountry(entity.getId())));
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
		Country entity = super.findByName(name);
		if (entity != null) {
			entity.setProvinces(new HashSet<Province>(daoProvince
					.listByCountry(entity.getId())));
		}
		return entity;
	}

	@Override
	public List<Province> listProvinceByCountry(int countryId) {
		List<Province> result = new ArrayList<Province>(
				daoProvince.listBasicInfoByCountry(countryId));

		if (result == null || (result != null && result.isEmpty())) {
			logger.info("Warning: " + "listProvinceByCountry(" + countryId
					+ ")" + " return null or empty.");
		} else {
			Collections.sort(result, COMPARATOR);
		}
		return result;
	}

	@Override
	public void insertProvince(Province entity) {
		if (entity != null) {
			daoProvince.insert(entity);
		}
	}

	@Override
	protected IDAO<Country> getDAO() {
		return dao;
	}

	@Override
	protected Logger getLogger() {
		return logger;
	}

	@Override
	public Province findProvinceById(int provinceId) {
		return daoProvince.findById(provinceId);
	}

	// ============================================================
	// OTHER METHODS
	// ============================================================

}
