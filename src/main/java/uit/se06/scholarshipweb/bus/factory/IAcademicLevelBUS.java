package uit.se06.scholarshipweb.bus.factory;

import java.util.List;

import uit.se06.scholarshipweb.model.AcademicLevel;
import uit.se06.scholarshipweb.model.AcademicLevelDetail;

public interface IAcademicLevelBUS extends IBUS<AcademicLevel> {

	/**
	 * with detail
	 * 
	 * @return
	 */
	List<AcademicLevel> listWithDetails();

	void insertAcademicLevelDetail(AcademicLevelDetail entity);

}