package uit.se06.scholarshipweb.dao;

import java.util.List;

import uit.se06.scholarshipweb.model.AcademicLevel;

public interface IAcademicLevelDAO {
	AcademicLevel findById(int id);

	AcademicLevel findByName(String name);

	List<AcademicLevel> getAll();

}
