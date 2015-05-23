package uit.se06.scholarshipweb.bus.serviceprovider.da;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.bus.factory.IFamilyPolicyBUS;
import uit.se06.scholarshipweb.dao.factory.DAOAbstractFactory;
import uit.se06.scholarshipweb.dao.factory.IFamilyPolicyDAO;
import uit.se06.scholarshipweb.model.FamilyPolicy;

public class DAFamilyPolicyBUS implements IFamilyPolicyBUS {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(DAFamilyPolicyBUS.class);

	private IFamilyPolicyDAO dao;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public DAFamilyPolicyBUS() {
		dao = DAOAbstractFactory.INS.getFamilyPolicyDAO();
	}

	// ============================================================
	// METHODS
	// ============================================================

	@Override
	public FamilyPolicy findById(int id) {
		FamilyPolicy entity = dao.findById(id);
		if (entity == null) {
			logger.info("Warning in: " + "findById(" + id + ")"
					+ " return null.");
		}
		return entity;
	}

	@Override
	public FamilyPolicy findByName(String name) {
		FamilyPolicy entity = dao.findByName(name);
		if (entity == null) {
			logger.info("Warning in: " + "findByName(" + name + ")"
					+ " return null.");
		}
		return entity;
	}

	@Override
	public List<FamilyPolicy> list() {
		List<FamilyPolicy> result = dao.list();
		if (result == null || (result != null && result.isEmpty())) {
			logger.info("Warning in: " + "list()" + " return null or empty.");
		}
		return result;
	}
}
