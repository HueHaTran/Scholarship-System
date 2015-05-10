package uit.se06.scholarshipweb.dao;

import java.util.List;

import uit.se06.scholarshipweb.model.Scholarship;

public interface IScholarshipDAO {
	/**
	 * for getting general information (not detail, for showing in list of
	 * scholarships)
	 * 
	 * @param id
	 * @return
	 */
	Scholarship findShortInfoById(int id);

	/**
	 * get all detail information
	 * 
	 * @param id
	 * @return
	 */
	Scholarship findById(int id);

	Scholarship findByName(String name);

	List<Scholarship> getAll();

}
