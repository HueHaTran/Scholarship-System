package uit.se06.scholarshipweb.bus.serviceprovider.da;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.bus.factory.IFamilyPolicyBUS;
import uit.se06.scholarshipweb.dao.factory.DAOAbstractFactory;
import uit.se06.scholarshipweb.dao.factory.IDAO;
import uit.se06.scholarshipweb.dao.factory.IFamilyPolicyDAO;
import uit.se06.scholarshipweb.model.FamilyPolicy;

public class DAFamilyPolicyBUS extends DABaseBUS<FamilyPolicy> implements
		IFamilyPolicyBUS {

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
	protected IDAO<FamilyPolicy> getDAO() {
		return dao;
	}

	@Override
	protected Logger getLogger() {
		return logger;
	}
}
