package uit.se06.scholarshipweb.bus.serviceprovider.da;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.bus.factory.IAcademicLevelBUS;
import uit.se06.scholarshipweb.dao.factory.DAOAbstractFactory;
import uit.se06.scholarshipweb.dao.factory.IAcademicLevelDAO;
import uit.se06.scholarshipweb.dao.factory.IAcademicLevelDetailDAO;
import uit.se06.scholarshipweb.dao.factory.IDAO;
import uit.se06.scholarshipweb.model.AcademicLevel;

public class DAAcademicLevelBUS extends DABaseBUS<AcademicLevel> implements
		IAcademicLevelBUS {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(DACountryBUS.class);

	private IAcademicLevelDAO dao;
	private IAcademicLevelDetailDAO daoDetail;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public DAAcademicLevelBUS() {
		dao = DAOAbstractFactory.INS.getAcademicLevelDAO();
		daoDetail = DAOAbstractFactory.INS.getAcademicLevelDetailDAO();
	}

	// ============================================================
	// METHODS
	// ============================================================

	/**
	 * with detail
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public AcademicLevel findById(int id) {
		AcademicLevel entity = super.findById(id);

		if (entity != null) {
			entity.setAcademicLevelDetails(daoDetail
					.findByAcademicLevelId(entity.getId()));
		}

		return entity;
	}

	/**
	 * with detail
	 * 
	 * @param name
	 * @return
	 */
	@Override
	public AcademicLevel findByName(String name) {
		AcademicLevel entity = super.findByName(name);

		if (entity != null) {
			entity.setAcademicLevelDetails(daoDetail
					.findByAcademicLevelId(entity.getId()));
		}

		return entity;
	}

	/**
	 * with detail
	 * 
	 * @return
	 */
	@Override
	public List<AcademicLevel> listWithDetails() {
		List<AcademicLevel> result = new ArrayList<AcademicLevel>(
				dao.listWithDetails());
		if (result == null || (result != null && result.isEmpty())) {
			logger.info("Warning: " + "list()" + " return null or empty.");
		}
		Collections.sort(result, COMPARATOR);
		return result;
	}

	@Override
	protected IDAO<AcademicLevel> getDAO() {
		return dao;
	}

	@Override
	protected Logger getLogger() {
		return logger;
	}

	// ============================================================
	// OTHER METHODS
	// ============================================================

	public static final Comparator<AcademicLevel> COMPARATOR = new Comparator<AcademicLevel>() {
		public int compare(AcademicLevel entity1, AcademicLevel entity2) {
			return entity1.getId() - entity2.getId();
		}
	};
}
