package uit.se06.scholarshipweb.dao.factory;

import java.util.List;

import uit.se06.scholarshipweb.model.Province;

public interface IProvinceDAO extends IBasicDAO<Province> {
	List<Province> listByCountry(int countryId);
	List<Province> listBasicInfoByCountry(int countryId);
}
