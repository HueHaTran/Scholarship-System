package uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.dao.factory.ISponsorDAO;
import uit.se06.scholarshipweb.model.Sponsor;

public class JdbcSponsorDAO extends JdbcBaseDAO<Sponsor> implements ISponsorDAO {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(JdbcSponsorDAO.class);

	public final String COL_ID = "sponsor_id";
	public final String COL_NAME = "sponsor_name";
	public final String COL_PROVICE_ID = "province_id";
	public final String COL_ADDRESS = "address";
	public final String COL_PHONE = "phone";
	public final String COL_WEBSITE = "website";
	public final String COL_FAX = "fax";

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public JdbcSponsorDAO() {
		super(Sponsor.class);
	}

	// ============================================================
	// OVERRIDE METHODS
	// ============================================================

	@Override
	protected Logger getLogger() {
		return logger;
	}

	@Override
	public Sponsor findById(int id) {
		return findBy(COL_ID, String.valueOf(id));
	}

	@Override
	public Sponsor findByName(String name) {
		return findBy(COL_NAME, name);
	}

	@Override
	public List<Sponsor> list() {
		return getAll();
	}

	// ============================================================
	// OTHER METHODS
	// ============================================================

}
