package uit.se06.scholarshipweb.bus;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.dao.IAcademicLevelDAO;
import uit.se06.scholarshipweb.dao.IAcademicLevelDetailDAO;
import uit.se06.scholarshipweb.dao.impl.JdbcAcademicLevelDAO;
import uit.se06.scholarshipweb.dao.impl.JdbcAcademicLevelDetailDAO;
import uit.se06.scholarshipweb.model.AcademicLevel;

public class AcademicLevelBUS {
	private static final Logger logger = LoggerFactory
			.getLogger(CountryBUS.class);

	private IAcademicLevelDAO dao;
	private IAcademicLevelDetailDAO daoDetail;

	public AcademicLevelBUS(SessionFactory sessionFactory) {
		dao = new JdbcAcademicLevelDAO(sessionFactory);
		daoDetail = new JdbcAcademicLevelDetailDAO(sessionFactory);
	}

	public AcademicLevel findById(int id) {
		AcademicLevel entity = dao.findById(id);

		if (entity == null) {
			logger.info("Exception in " + this.getClass().getCanonicalName()
					+ ": " + "findById(" + id + ")" + " return null.");
		} else {
			entity.setAcademicLevelDetails(daoDetail
					.findByAcademicLevelId(entity.getAcademicLevelId()));
		}

		return entity;
	}
}
