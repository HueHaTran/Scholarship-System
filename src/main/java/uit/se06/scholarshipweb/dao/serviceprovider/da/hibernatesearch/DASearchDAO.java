package uit.se06.scholarshipweb.dao.serviceprovider.da.hibernatesearch;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.query.dsl.QueryBuilder;

import uit.se06.scholarshipweb.dao.util.HibernateUtil;
import uit.se06.scholarshipweb.model.Scholarship;
import uit.se06.scholarshipweb.model.ScholarshipSpecification;
import uit.se06.scholarshipweb.viewmodel.FilterViewModel;

public class DASearchDAO {

	private Class<?> searchClass = ScholarshipSpecification.class;
	private Class<?> searchClass2 = Scholarship.class;

	public Set<Scholarship> filter(FilterViewModel entity) {
		Set<Scholarship> result = new HashSet<Scholarship>();

		SearchColumnConstant constants = SearchColumnConstant.getIns();

		Session session = HibernateUtil.getSessionAnnotationFactory()
				.openSession();
		FullTextSession fullTextSession = org.hibernate.search.Search
				.getFullTextSession(session);
		Transaction transaction = fullTextSession.beginTransaction();
 
		QueryBuilder builder = fullTextSession.getSearchFactory()
				.buildQueryBuilder().forEntity(searchClass).get();
 
		
		
		
		return result;
	}

	@SuppressWarnings("rawtypes")
	public Set<Scholarship> getTopResult(String keyWord, int count) {
		Set<Scholarship> result = new HashSet<Scholarship>();
		SearchColumnConstant constants = SearchColumnConstant.getIns();

		Session session = HibernateUtil.getSessionAnnotationFactory()
				.openSession();
		FullTextSession fullTextSession = org.hibernate.search.Search
				.getFullTextSession(session);
		Transaction transaction = fullTextSession.beginTransaction();

		// builder 1
		QueryBuilder builder = fullTextSession.getSearchFactory()
				.buildQueryBuilder().forEntity(searchClass).get();
		org.apache.lucene.search.Query query1 = builder
				.keyword()
				.onFields(constants.TAG_DESCRIPTION,
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

		// builder 2
		QueryBuilder builder2 = fullTextSession.getSearchFactory()
				.buildQueryBuilder().forEntity(searchClass2).get();
		org.apache.lucene.search.Query query2 = builder2.keyword()
				.onFields(constants.TAG_NAME).matching(keyWord).createQuery();

		org.apache.lucene.search.BooleanQuery query = new BooleanQuery();
		query.add(query1, BooleanClause.Occur.SHOULD);
		query.add(query2, BooleanClause.Occur.SHOULD);

		org.hibernate.Query hibQuery = fullTextSession.createFullTextQuery(
				query, searchClass, searchClass2);

		hibQuery.setMaxResults(count);

		// execute search
		List list = hibQuery.list();
		Iterator it = list.iterator();

		// add to result list
		while (it.hasNext()) {
			Object obj = it.next();
			if (obj instanceof Scholarship) {
				result.add((Scholarship) obj);
			} else if (obj instanceof ScholarshipSpecification) {
				result.add(((ScholarshipSpecification) obj).getScholarship());
			}
		}

		transaction.commit();
		return result;
	}
}
