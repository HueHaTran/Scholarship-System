package uit.se06.scholarshipweb.bus.factory;

import java.util.List;

import uit.se06.scholarshipweb.model.Country;
import uit.se06.scholarshipweb.model.Province;

public interface ICountryBUS extends IBUS<Country> {

	List<Province> listProvinceByCountry(int countryId);

	void insertProvince(Province entity);
}