package uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;

import uit.se06.scholarshipweb.dao.factory.IDAO;
import uit.se06.scholarshipweb.dao.util.HibernateUtil;

public abstract class DAJdbcBaseDAO<T> implements IDAO<T> {

	private SessionFactory sessionFactory;
	private Session session;

	private Class<?> modelClass;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public DAJdbcBaseDAO(Class<?> modelClass) {
		this.modelClass = modelClass;
		this.sessionFactory = HibernateUtil.getSessionAnnotationFactory();
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
			builder.append("FROM ").append(modelClass.getSimpleName());
			builder.append("  WHERE ").append(name).append(" = :param1");

			Query query = getSession().createQuery(builder.toString())
					.setParameter("param1", value);

			resultList = query.list();

		} catch (Exception ex) {
			getLogger().error("Query '" + builder.toString() + "' in listBy()");
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
	public List<T> list() {
		List<T> result = null;
		String queryString = "FROM " + modelClass.getSimpleName();

		try {
			result = (List<T>) getSession().createQuery(queryString).list();
		} catch (Exception ex) {
			getLogger().error("Query '" + queryString + "' in getAll()");
		} finally {
			closeSession();
		}
		return result;
	}

	public void insert(T entity) {
		SessionFactory sessionfactory = HibernateUtil
				.getSessionAnnotationFactory();
		Session session = sessionfactory.openSession();

		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(entity);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.flush();
			session.refresh(entity);
			session.close();
		}
	}

	protected abstract Logger getLogger();
}
