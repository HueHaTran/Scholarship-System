package uit.se06.scholarshipweb.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import uit.se06.scholarshipweb.dao.IAcademicLevelDAO;
import uit.se06.scholarshipweb.dao.impl.util.HibernateUtil;
import uit.se06.scholarshipweb.model.AcademicLevel;

public class JdbcAcademicLevelDAO implements IAcademicLevelDAO {

	private final String TABLE_NAME = "academic_level";
	private final String COL_ID = "academic_level_id";
	private final String COL_NAME = "academic_level_name";

	@Override
	public AcademicLevel findById(int id) {
		SessionFactory sessionfactory = HibernateUtil
				.getSessionAnnotationFactory();
		Session session = sessionfactory.openSession();

		// query
		StringBuilder builder = new StringBuilder();
		builder.append("from ").append(TABLE_NAME);
		builder.append("  where ").append(COL_ID).append(" = :paramId");

		Query query = session.createQuery(builder.toString()).setParameter(
				"paramId", id);

		@SuppressWarnings("unchecked")
		List<AcademicLevel> resultList = query.list(); // unchecked

		if (resultList != null && !resultList.isEmpty()) {
			return resultList.get(0);
		} else {
			return null;
		}
	}

	@Override
	public AcademicLevel findByName(String name) {
		SessionFactory sessionfactory = HibernateUtil
				.getSessionAnnotationFactory();
		Session session = sessionfactory.openSession();

		// query
		StringBuilder builder = new StringBuilder();
		builder.append("from ").append(TABLE_NAME);
		builder.append("  where ").append(COL_ID).append(" = :paramName");

		Query query = session.createQuery(builder.toString()).setParameter(
				"paramName", name);

		@SuppressWarnings("unchecked")
		List<AcademicLevel> resultList = query.list(); // unchecked

		if (resultList != null && !resultList.isEmpty()) {
			return resultList.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<AcademicLevel> getAll() {
		SessionFactory sessionfactory = HibernateUtil
				.getSessionAnnotationFactory();
		Session session = sessionfactory.openSession();

		// query
		StringBuilder builder = new StringBuilder();
		builder.append("from ").append(TABLE_NAME);
		builder.append("  where ").append(COL_ID).append(" = :paramName");

		Query query = session.createQuery(builder.toString());

		@SuppressWarnings("unchecked")
		List<AcademicLevel> resultList = query.list(); // unchecked

		return resultList;
	}
}
