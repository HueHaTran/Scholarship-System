package uit.se06.scholarshipweb.bus.factory;

import java.util.List;

import uit.se06.scholarshipweb.model.Country;
import uit.se06.scholarshipweb.model.Province;

public interface ICountryBUS {

	/**
	 * with detail
	 * 
	 * @param id
	 * @return
	 */
	public abstract Country findById(int id);

	/**
	 * with detail
	 * 
	 * @param name
	 * @return
	 */
	public abstract Country findByName(String name);

	/**
	 * general info only, no detail
	 * 
	 * @return
	 */
	public abstract List<Country> list();

	public abstract List<Province> listProvinceByCountry(int countryId);

}