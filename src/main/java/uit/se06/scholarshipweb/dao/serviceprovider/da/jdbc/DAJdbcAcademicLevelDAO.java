package uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.dao.factory.IAcademicLevelDAO;
import uit.se06.scholarshipweb.model.AcademicLevel;

public class DAJdbcAcademicLevelDAO extends DAJdbcBaseDAO<AcademicLevel> implements
		IAcademicLevelDAO {

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
	public List<AcademicLevel> list() {
		List<AcademicLevel> result = getAll();
		Collections.sort(result, COMPARATOR);
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AcademicLevel> listWithDetails() {
		List<AcademicLevel> result = null;
		String queryString = "FROM " + AcademicLevel.class.getSimpleName();

		try {
			result = (List<AcademicLevel>) getSession()
					.createQuery(queryString).list();
			for (AcademicLevel entity : result) {
				Hibernate.initialize(entity.getAcademicLevelDetails());
			}
		} catch (Exception ex) {
			getLogger().error("Query '" + queryString + "' in getAll()");
		} finally {
			closeSession();
		}

		Collections.sort(result, COMPARATOR);
		return result;
	}

	// ============================================================
	// OTHER METHODS
	// ============================================================

	public static final Comparator<AcademicLevel> COMPARATOR = new Comparator<AcademicLevel>() {
		// Overriding the compare method to sort the age
		public int compare(AcademicLevel entity1, AcademicLevel entity2) {
			return entity1.getId() - entity2.getId();
		}
	};
}
