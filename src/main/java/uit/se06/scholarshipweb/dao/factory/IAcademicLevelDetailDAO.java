package uit.se06.scholarshipweb.dao.factory;

import java.util.List;
import java.util.Set;

import uit.se06.scholarshipweb.model.AcademicLevelDetail;

public interface IAcademicLevelDetailDAO extends IDAO<AcademicLevelDetail> {
	Set<AcademicLevelDetail> findByAcademicLevelId(int academicLevelId);

	List<Integer> findIdListByAcademicLevelId(int academicLevelId);
}
