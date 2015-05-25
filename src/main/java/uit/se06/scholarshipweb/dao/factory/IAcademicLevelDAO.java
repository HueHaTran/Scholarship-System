package uit.se06.scholarshipweb.dao.factory;

import java.util.List;

import uit.se06.scholarshipweb.model.AcademicLevel;

public interface IAcademicLevelDAO extends IDAO<AcademicLevel> {
	List<AcademicLevel> listWithDetails();
}
