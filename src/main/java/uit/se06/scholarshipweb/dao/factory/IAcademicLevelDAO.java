package uit.se06.scholarshipweb.dao.factory;

import java.util.Set;

import uit.se06.scholarshipweb.model.AcademicLevel;

public interface IAcademicLevelDAO extends IDAO<AcademicLevel> {
	Set<AcademicLevel> listWithDetails();
}
