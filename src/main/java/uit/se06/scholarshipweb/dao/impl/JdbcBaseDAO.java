package uit.se06.scholarshipweb.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;

public abstract class JdbcBaseDAO<T> {

	private SessionFactory sessionFactory;
	private Session session;

	private Class<?> modelClass;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public JdbcBaseDAO(Class<?> modelClass, SessionFactory sessionFactory) {
		this.modelClass = modelClass;
		this.sessionFactory = sessionFactory;
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

	protected void closeSession() {
		if (session != null && session.isOpen()) {
			session.close();
		}
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
			getLogger().error(
					"Exception in " + this.getClass().getCanonicalName()
							+ ": Query '" + builder.toString()
							+ "' in listBy()");
		} finally {
			closeSession();
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
		String queryString = "from " + modelClass.getCanonicalName();

		try {
			result = (List<T>) getSession().createQuery(queryString).list();
		} catch (Exception ex) {
			getLogger().error(
					"Exception in " + this.getClass().getCanonicalName()
							+ ": Query '" + queryString + "' in getAll()");
		} finally {
			closeSession();
		}
		return result;
	}

	protected abstract Logger getLogger();
}
