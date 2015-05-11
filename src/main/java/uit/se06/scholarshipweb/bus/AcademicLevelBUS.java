package uit.se06.scholarshipweb.bus;

import org.hibernate.SessionFactory;

import uit.se06.scholarshipweb.dao.IAcademicLevelDAO;
import uit.se06.scholarshipweb.dao.IAcademicLevelDetailDAO;
import uit.se06.scholarshipweb.dao.impl.JdbcAcademicLevelDAO;
import uit.se06.scholarshipweb.dao.impl.JdbcAcademicLevelDetailDAO;
import uit.se06.scholarshipweb.model.AcademicLevel;

public class AcademicLevelBUS {

	private IAcademicLevelDAO dao;
	private IAcademicLevelDetailDAO daoDetail;

	public AcademicLevelBUS(SessionFactory sessionFactory) {
		dao = new JdbcAcademicLevelDAO(sessionFactory);
		daoDetail = new JdbcAcademicLevelDetailDAO(sessionFactory);
	}

	public AcademicLevel findById(int id) {
		AcademicLevel entity = dao.findById(id);
		entity.setAcademicLevelDetails(daoDetail.findByAcademicLevelId(entity
				.getAcademicLevelId()));
		return entity;
	}

}
