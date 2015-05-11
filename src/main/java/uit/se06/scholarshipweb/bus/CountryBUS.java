package uit.se06.scholarshipweb.bus;

import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import uit.se06.scholarshipweb.dao.ICountryDAO;
import uit.se06.scholarshipweb.dao.impl.JdbcCountryDAO;
import uit.se06.scholarshipweb.model.Country;

public class CountryBUS {

	private static final Logger logger = LoggerFactory
			.getLogger(CountryBUS.class);

	private ICountryDAO dao;

	public CountryBUS(SessionFactory sessionFactory) {
		dao = new JdbcCountryDAO(sessionFactory);
	}

	public Country findById(int id) {
		Country entity = dao.findById(id);
		if (entity == null) {
			logger.info("Exception in " + this.getClass().getCanonicalName()
					+ ": " + "findById(" + id + ")" + " return null.");
		}
		return entity;
	}
}
