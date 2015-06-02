package uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.dao.factory.IAcademicLevelDetailDAO;
import uit.se06.scholarshipweb.dao.util.ILoadingRelatedEntityListener;
import uit.se06.scholarshipweb.model.AcademicLevelDetail;

public class DAJdbcAcademicLevelDetailDAO extends
		DAJdbcBaseDAO<AcademicLevelDetail> implements IAcademicLevelDetailDAO {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(DAJdbcAcademicLevelDetailDAO.class);

	public final String COL_ID = "academic_level_detail_id";
	public final String COL_NAME = "academic_level_detail_name";
	public final String COL_ACADEMIC_LEVEL_ID = "academic_level_id";

	private ILoadingRelatedEntityListener<AcademicLevelDetail> loadinglistener = new ILoadingRelatedEntityListener<AcademicLevelDetail>() {
		@Override
		public void load(AcademicLevelDetail entity) {
			Hibernate.initialize(entity.getAcademicLevel());
		}
	};

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public DAJdbcAcademicLevelDetailDAO() {
		super(AcademicLevelDetail.class);
	}

	// ============================================================
	// OVERRIDE METHODS
	// ============================================================

	@Override
	protected Logger getLogger() {
		return logger;
	}

	@Override
	public AcademicLevelDetail findById(int id) {
		return findBy(COL_ID, String.valueOf(id), loadinglistener);
	}

	@Override
	public AcademicLevelDetail findByName(String name) {
		return findBy(COL_NAME, name, loadinglistener);
	}

	@Override
	public Set<AcademicLevelDetail> findByAcademicLevelId(int academicLevelId) {
		return listBy(COL_ACADEMIC_LEVEL_ID, String.valueOf(academicLevelId));
	}

	@Override
	public List<Integer> findIdListByAcademicLevelId(int academicLevelId) {
		List<Integer> result = new ArrayList<Integer>();

		Set<AcademicLevelDetail> set = findByAcademicLevelId(academicLevelId);
		Iterator<AcademicLevelDetail> iter = set.iterator();

		while (iter.hasNext()) {
			result.add(((AcademicLevelDetail) iter.next()).getId());
		}

		return result;
	}

	// ============================================================
	// OTHER METHODS
	// ============================================================

}
