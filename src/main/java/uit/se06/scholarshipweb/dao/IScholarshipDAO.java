package uit.se06.scholarshipweb.dao;

import uit.se06.scholarshipweb.model.Scholarship;

public interface IScholarshipDAO extends IBasicDAO<Scholarship> {
	/**
	 * for getting general information (not detail, for showing in list of
	 * scholarships)
	 * 
	 * @param id
	 * @return
	 */
	Scholarship findShortInfoById(int id);

}
