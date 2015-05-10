package uit.se06.scholarshipweb.dao;

import java.util.List;

import uit.se06.scholarshipweb.model.Disability;

public interface IDisabilityDAO {
	Disability findById(int id);

	Disability findByName(String name);

	List<Disability> getAll();
}
