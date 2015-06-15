package uit.se06.scholarshipweb.dao.serviceprovider.da.hibernatesearch;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.search.FullTextQuery;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.dao.factory.DAOAbstractFactory;
import uit.se06.scholarshipweb.dao.factory.ISchoolDAO;
import uit.se06.scholarshipweb.dao.factory.ISearchDAO;
import uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc.DAJdbcScholarshipDAO;
import uit.se06.scholarshipweb.dao.util.HibernateUtil;
import uit.se06.scholarshipweb.model.Scholarship;
import uit.se06.scholarshipweb.model.ScholarshipSpecification;

public class DASearchDAO implements ISearchDAO {

	private Class<?> searchClass = ScholarshipSpecification.class;

	private static final Logger logger = LoggerFactory
			.getLogger(DASearchDAO.class);

	private ISchoolDAO daoSchool;

	public DASearchDAO() {
		daoSchool = DAOAbstractFactory.INS.getSchoolDAO();
	}

	// @SuppressWarnings("rawtypes")
	// public List<Scholarship> filterByLucene(FilterViewModel entity,
	// int pageNumber, int pageSize) {
	// List<Scholarship> result = new ArrayList<Scholarship>();
	//
	// SearchColumnConstant constants = SearchColumnConstant.getIns();
	//
	// Session session = HibernateUtil.getSessionAnnotationFactory()
	// .openSession();
	// FullTextSession fullTextSession = org.hibernate.search.Search
	// .getFullTextSession(session);
	// Transaction transaction = fullTextSession.beginTransaction();
	//
	// QueryBuilder builder = fullTextSession.getSearchFactory()
	// .buildQueryBuilder().forEntity(searchClass).get();
	//
	// org.apache.lucene.search.Query query = builder
	// .bool()
	// .must(builder.phrase().onField(constants.TAG_GENDER)
	// .sentence("nam").createQuery())
	// .must(builder.phrase().onField(constants.TAG_DISABILITY)
	// .sentence("liệt 1 chân").createQuery()).createQuery();
	//
	// org.hibernate.Query hibQuery = fullTextSession.createFullTextQuery(
	// query, searchClass, searchClass2);
	//
	// hibQuery.setFirstResult((pageNumber - 1) * pageSize);
	// hibQuery.setMaxResults(pageSize);
	//
	// // execute search
	// List list = hibQuery.list();
	// Iterator it = list.iterator();
	//
	// // add to result list
	// while (it.hasNext()) {
	// Object obj = it.next();
	// if (obj instanceof Scholarship) {
	// result.add((Scholarship) obj);
	// } else if (obj instanceof ScholarshipSpecification) {
	// result.add(((ScholarshipSpecification) obj).getScholarship());
	// }
	// }
	//
	// transaction.commit();
	// return result;
	// }

	public int getTopResultRowCount(String keyWord) {
		keyWord = keyWord.toLowerCase();

		Session session = HibernateUtil.getSessionAnnotationFactory()
				.openSession();
		FullTextSession fullTextSession = org.hibernate.search.Search
				.getFullTextSession(session);
		Transaction transaction = fullTextSession.beginTransaction();

		int result = (int) getSearchNewWordQuery(keyWord, fullTextSession)
				.list().size();

		transaction.commit();
		session.close();
		return result;
	}

	@SuppressWarnings("rawtypes")
	public List<Scholarship> getTopResult(String keyWord, int pageNumber,
			int pageSize) {
		keyWord = keyWord.toLowerCase();

		List<Scholarship> result = new ArrayList<Scholarship>();

		Session session = HibernateUtil.getSessionAnnotationFactory()
				.openSession();
		FullTextSession fullTextSession = org.hibernate.search.Search
				.getFullTextSession(session);
		Transaction transaction = fullTextSession.beginTransaction();

		org.hibernate.Query hibQuery = getSearchNewWordQuery(keyWord,
				fullTextSession);

		hibQuery.setFirstResult((pageNumber - 1) * pageSize);
		hibQuery.setMaxResults(pageSize);

		// execute search
		List list = hibQuery.list();
		Iterator it = list.iterator();

		// add to result list
		while (it.hasNext()) {
			Object obj = it.next();
			if (obj instanceof ScholarshipSpecification) {
				Scholarship entity = ((ScholarshipSpecification) obj)
						.getScholarship();
				if (!result.contains(entity)) {
					setSchool(entity);
					result.add(entity);
				}
			}
		}

		transaction.commit();
		session.close();
		return result;
	}

	private FullTextQuery getSearchNewWordQuery(String keyWord,
			FullTextSession fullTextSession) {
		SearchColumnConstant constants = SearchColumnConstant.getIns();

		// builder 1
		QueryBuilder builder = fullTextSession.getSearchFactory()
				.buildQueryBuilder().forEntity(searchClass).get();
		org.apache.lucene.search.Query query1 = builder
				.keyword()
				.onFields(constants.TAG_NAME, constants.TAG_DESCRIPTION,
						constants.TAG_APPLICATION_DESCRIPTION,
						constants.TAG_CITIZENSHIP, constants.TAG_DISABILITY,
						constants.TAG_ETHNIC, constants.TAG_FAMILY_POLICY,
						constants.TAG_FORM, constants.TAG_GENDER,
						constants.TAG_MAJOR, constants.TAG_RELIGION,
						constants.TAG_RESIDENCE, constants.TAG_SCHO_ACA,
						constants.TAG_SCHOOL, constants.TAG_SPONSOR,
						constants.TAG_STU_ACA,
						constants.TAG_SUPPORT_DESCRIPTION,
						constants.TAG_TALENT, constants.TAG_TERMINAL_ILL,
						constants.TAG_TYPE).matching(keyWord).createQuery();

		org.apache.lucene.search.BooleanQuery query = new BooleanQuery();
		query.add(query1, BooleanClause.Occur.SHOULD);

		FullTextQuery fullTextQuery = fullTextSession.createFullTextQuery(
				query, searchClass);
		return fullTextQuery;
	}

	private void setSchool(Scholarship scholarship) {
		if (scholarship.getId() == 0) {
			logger.error("id in getSchoolId(scholarshipId) is null!");
			return;
		}

		SessionFactory sessionFactory = HibernateUtil
				.getSessionAnnotationFactory();
		Session session = sessionFactory.openSession();

		StringBuilder sb = new StringBuilder();
		sb.append("SELECT " + DAJdbcScholarshipDAO.COL_SCHOOL);
		sb.append(" FROM " + DAJdbcScholarshipDAO.TABLE_SCHOLARSHIP_SPEC);
		sb.append(" WHERE " + DAJdbcScholarshipDAO.COL_ID + " = "
				+ scholarship.getId());

		Number n = null;

		try {
			n = (Number) session.createSQLQuery(sb.toString()).uniqueResult();
		} catch (Exception ex) {
			logger.error("Query '" + sb.toString()
					+ "' in getSchoolId(scholarshipId): " + ex.toString());
		} finally {
			session.close();
		}

		if (n == null) {
			scholarship.getScholarshipSpecification().setSchool(null);
			return;
		}

		int schoolId = n.intValue();
		scholarship.getScholarshipSpecification().setSchool(
				daoSchool.findById(schoolId));
	}
}
