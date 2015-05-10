package uit.se06.scholarshipweb.dao;

import java.util.List;

import uit.se06.scholarshipweb.model.AcademicLevel;
import uit.se06.scholarshipweb.model.AcademicLevelDetail;

public interface IAcademicLevelDetailDAO {
	AcademicLevelDetail findById(int id);

	AcademicLevelDetail findByName(String name);

	AcademicLevelDetail findByAcademicLevel(AcademicLevel academicLevel);

	List<AcademicLevelDetail> getAll();

}
