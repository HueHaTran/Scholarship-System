package uit.se06.scholarshipweb.dao;

import java.util.List;

import uit.se06.scholarshipweb.model.AcademicLevel;

public interface IAcademicLevelDAO extends IBasicDAO<AcademicLevel> {
	List<AcademicLevel> listWithDetails();
}
