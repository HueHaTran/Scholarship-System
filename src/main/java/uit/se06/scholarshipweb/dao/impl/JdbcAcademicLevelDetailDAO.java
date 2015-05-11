package uit.se06.scholarshipweb.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import uit.se06.scholarshipweb.dao.IAcademicLevelDetailDAO;
import uit.se06.scholarshipweb.model.AcademicLevel;
import uit.se06.scholarshipweb.model.AcademicLevelDetail;

public class JdbcAcademicLevelDetailDAO extends
		JdbcBaseDAO<AcademicLevelDetail> implements IAcademicLevelDetailDAO {

	// ============================================================
	// VARIABLES
	// ============================================================

	private final String COL_ID = "academic_level_detail_id";
	private final String COL_NAME = "academic_level_detail_name";
	private final String COL_ACADEMIC_LEVEL_ID = "academic_level_id";

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public JdbcAcademicLevelDetailDAO(SessionFactory sessionFactory) {
		super(AcademicLevelDetail.class, sessionFactory);
	}

	// ============================================================
	// OVERRIDE METHODS
	// ============================================================

	@Override
	public AcademicLevelDetail findById(int id) {
		return findBy(COL_ID, String.valueOf(id));
	}

	@Override
	public AcademicLevelDetail findByName(String name) {
		return findBy(COL_NAME, name);
	}

	@Override
	public List<AcademicLevelDetail> list() {
		return getAll();
	}

	@Override
	public List<AcademicLevelDetail> findByAcademicLevelId(int academicLevelId) {
		return listBy(COL_ACADEMIC_LEVEL_ID, String.valueOf(academicLevelId));
	}

	// ============================================================
	// OTHER METHODS
	// ============================================================

}
