package uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.dao.factory.IAcademicLevelDAO;
import uit.se06.scholarshipweb.model.AcademicLevel;

public class DAJdbcAcademicLevelDAO extends DAJdbcBaseDAO<AcademicLevel>
		implements IAcademicLevelDAO {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(DAJdbcAcademicLevelDAO.class);

	public final String COL_ID = "academic_level_id";
	public final String COL_NAME = "academic_level_name";

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public DAJdbcAcademicLevelDAO() {
		super(AcademicLevel.class);
	}

	// ============================================================
	// OVERRIDE METHODS
	// ============================================================

	@Override
	protected Logger getLogger() {
		return logger;
	}

	@Override
	public AcademicLevel findById(int id) {
		return findBy(COL_ID, String.valueOf(id));
	}

	@Override
	public AcademicLevel findByName(String name) {
		return findBy(COL_NAME, name);
	}

	@Override
	public Set<AcademicLevel> list() {
		Set<AcademicLevel> result = super.list();
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<AcademicLevel> listWithDetails() {
		Set<AcademicLevel> result = null;
		String queryString = "FROM " + AcademicLevel.class.getSimpleName();

		try {
			result = new HashSet<AcademicLevel>(getSession().createQuery(
					queryString).list());
			for (AcademicLevel entity : result) {
				Hibernate.initialize(entity.getAcademicLevelDetails());
			}
		} catch (Exception ex) {
			getLogger().error("Query '" + queryString + "' in getAll()");
		} finally {
			closeSession();
		}

		return result;
	}

}
