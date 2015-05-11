package uit.se06.scholarshipweb.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import uit.se06.scholarshipweb.dao.IAcademicLevelDAO;
import uit.se06.scholarshipweb.model.AcademicLevel;
 
public class JdbcAcademicLevelDAO extends JdbcBaseDAO<AcademicLevel> implements
		IAcademicLevelDAO {

	// ============================================================
	// VARIABLES
	// ============================================================

	private final String COL_ID = "academic_level_id";
	private final String COL_NAME = "academic_level_name";

	// ============================================================
	// CONSTRUCTORS
	// ============================================================
 
	
	public JdbcAcademicLevelDAO(SessionFactory sessionFactory) {
		super(AcademicLevel.class, sessionFactory);
	}

	// ============================================================
	// OVERRIDE METHODS
	// ============================================================

	@Override
	public AcademicLevel findById(int id) {
		return findBy(COL_ID, String.valueOf(id));
	}

	@Override
	public AcademicLevel findByName(String name) {
		return findBy(COL_NAME, name);
	}

	@Override
	public List<AcademicLevel> list() {
		return getAll();
	}

	// ============================================================
	// OTHER METHODS
	// ============================================================

}
