package uit.se06.scholarshipweb.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class JdbcBaseDAO<T> {

	private SessionFactory sessionFactory;

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
		return sessionFactory.openSession();
	}

	protected List<T> listBy(String name, String value) {
		// query
		StringBuilder builder = new StringBuilder();

		builder.append("from ").append(modelClass.getCanonicalName());
		builder.append("  where ").append(name).append(" = :param1");

		Query query = getSession().createQuery(builder.toString())
				.setParameter("param1", value);

		@SuppressWarnings("unchecked")
		List<T> resultList = query.list();

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

	protected List<T> getAll() {
		@SuppressWarnings("unchecked")
		List<T> result = (List<T>) getSession().createQuery(
				"from " + modelClass.getCanonicalName()).list();
		return result;
	}
}
