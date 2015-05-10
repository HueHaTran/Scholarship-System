package uit.se06.scholarshipweb.dao.impl;

import java.util.List;

import uit.se06.scholarshipweb.dao.IDisabilityDAO;
import uit.se06.scholarshipweb.model.Disability;

public class JdbcDisabilityDAO implements IDisabilityDAO {

	private String COL_ID = "disability_id";
	private String COL_Name = "disability_name";

	@Override
	public Disability findById(int id) {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public List<Disability> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Disability findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
