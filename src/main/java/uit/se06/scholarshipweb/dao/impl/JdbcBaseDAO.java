package uit.se06.scholarshipweb.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JdbcBaseDAO<T> {

	protected Logger logger;

	private SessionFactory sessionFactory;

	protected Session session;

	private Class<?> modelClass;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public JdbcBaseDAO(Class<?> modelClass, SessionFactory sessionFactory) {
		this.modelClass = modelClass;
		this.sessionFactory = sessionFactory;
		logger = LoggerFactory.getLogger(modelClass);
	}

	// ============================================================
	// METHODS
	// ============================================================

	protected Session getSession() {
		if (session == null || (session != null && !session.isOpen())) {
			session = sessionFactory.openSession();
		}
		return session;
	}

	@SuppressWarnings("unchecked")
	protected List<T> listBy(String name, String value) {
		List<T> resultList = null;
		StringBuilder builder = new StringBuilder();

		try {
			// query
			builder.append("from ").append(modelClass.getCanonicalName());
			builder.append("  where ").append(name).append(" = :param1");

			Query query = getSession().createQuery(builder.toString())
					.setParameter("param1", value);

			resultList = query.list();

		} catch (Exception ex) {
			logger.error("Exception in " + this.getClass().getCanonicalName()
					+ ": Query '" + builder.toString() + "' in listBy()");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}

		return resultList;
	}

	protected T findBy(String name, String value) {
		List<T> list = listBy(name, value);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	protected List<T> getAll() {
		List<T> result = null;
		StringBuilder builder = new StringBuilder();

		try {
			result = (List<T>) getSession().createQuery(
					"from " + modelClass.getCanonicalName()).list();
		} catch (Exception ex) {
			logger.error("Exception in " + this.getClass().getCanonicalName()
					+ ": Query '" + builder.toString() + "' in getAll()");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return result;
	}
}
