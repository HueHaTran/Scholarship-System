package uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.dao.factory.IEthnicDAO;
import uit.se06.scholarshipweb.model.Ethnic;

public class DAJdbcEthnicDAO extends DAJdbcBaseDAO<Ethnic> implements IEthnicDAO {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(DAJdbcEthnicDAO.class);

	public final String COL_ID = "ethnic_id";
	public final String COL_NAME = "ethnic_name";

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public DAJdbcEthnicDAO() {
		super(Ethnic.class);
	}

	// ============================================================
	// OVERRIDE METHODS
	// ============================================================

	@Override
	protected Logger getLogger() {
		return logger;
	}

	@Override
	public Ethnic findById(int id) {
		return findBy(COL_ID, String.valueOf(id));
	}

	@Override
	public Ethnic findByName(String name) {
		return findBy(COL_NAME, name);
	}

	@Override
	public List<Ethnic> list() {
		return getAll();
	}

	// ============================================================
	// OTHER METHODS
	// ============================================================

}
