package uit.se06.scholarshipweb.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import uit.se06.scholarshipweb.dao.util.HibernateUtil;
import uit.se06.scholarshipweb.model.Gender;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController extends BaseController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
 
		
		Session session = HibernateUtil.getSessionAnnotationFactory()
				.openSession();
		FullTextSession fullTextSession = org.hibernate.search.Search
				.getFullTextSession(session);
		Transaction tx = fullTextSession.beginTransaction();
		QueryBuilder qb = fullTextSession.getSearchFactory()
				.buildQueryBuilder().forEntity(Gender.class).get();
		org.apache.lucene.search.Query query = qb.keyword()
				.onFields("genderName").matching("gay").createQuery();
		// wrap Lucene query in a org.hibernate.Query
		org.hibernate.Query hibQuery = fullTextSession.createFullTextQuery(
				query, Gender.class);
		// execute search
		List result = hibQuery.list();
		Iterator<Gender> it = result.iterator();
		
		System.err.println("result: "+result.size());
		
		while (it.hasNext()) {
			Gender book1 = (Gender) it.next();
			System.err.println(book1.getId()+" "+book1.getName());
		}
		tx.commit();

		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

}
