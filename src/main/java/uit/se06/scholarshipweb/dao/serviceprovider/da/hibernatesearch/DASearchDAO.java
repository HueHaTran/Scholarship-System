package uit.se06.scholarshipweb.dao.serviceprovider.da.hibernatesearch;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.query.dsl.QueryBuilder;

import uit.se06.scholarshipweb.dao.util.HibernateUtil;
import uit.se06.scholarshipweb.model.Gender;
import uit.se06.scholarshipweb.model.Scholarship;

public class DASearchDAO {

	private final String TAG_SCHOLAR_SPEC = "scholarshipSpecification";
	private final String TAG_DOT = ".";

	@SuppressWarnings("unchecked")
	public List<Scholarship> getTopResult(String keyWord, int count) {
		Session session = HibernateUtil.getSessionAnnotationFactory()
				.openSession();
		FullTextSession fullTextSession = org.hibernate.search.Search
				.getFullTextSession(session);
		Transaction tx = fullTextSession.beginTransaction();
		QueryBuilder qb = fullTextSession.getSearchFactory()
				.buildQueryBuilder().forEntity(Gender.class).get();
		org.apache.lucene.search.Query query = qb.keyword()
				.onFields(TAG_SCHOLAR_SPEC + TAG_DOT + "studentGender")
				.matching("nam").createQuery();
		// wrap Lucene query in a org.hibernate.Query
		org.hibernate.Query hibQuery = fullTextSession.createFullTextQuery(
				query, Scholarship.class);
		// execute search
		List<Scholarship> result = hibQuery.list();
		Iterator<Scholarship> it = result.iterator();

		System.err.println("result: " + result.size());

		while (it.hasNext()) {
			Scholarship entity = (Scholarship) it.next();
			System.err.println(entity.getId() + " " + entity.getName());
		}
		tx.commit();
		return result;
	}
}
