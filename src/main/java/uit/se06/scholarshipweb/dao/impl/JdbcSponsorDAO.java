package uit.se06.scholarshipweb.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import uit.se06.scholarshipweb.dao.ISponsorDAO;
import uit.se06.scholarshipweb.model.AcademicLevel;
import uit.se06.scholarshipweb.model.Sponsor;

public class JdbcSponsorDAO extends JdbcBaseDAO<Sponsor> implements ISponsorDAO {

	// ============================================================
	// VARIABLES
	// ============================================================

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

	public JdbcSponsorDAO(SessionFactory sessionFactory) {
		super(AcademicLevel.class, sessionFactory);
	}

	// ============================================================
	// OVERRIDE METHODS
	// ============================================================

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
