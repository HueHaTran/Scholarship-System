package uit.se06.scholarshipweb.dao.factory;

import java.util.Set;

import uit.se06.scholarshipweb.model.Province;

public interface IProvinceDAO extends IDAO<Province> {
	Set<Province> listByCountry(int countryId);
	Set<Province> listBasicInfoByCountry(int countryId);
}
