package uit.se06.scholarshipweb.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import uit.se06.scholarshipweb.bus.AcademicLevelBUS;
import uit.se06.scholarshipweb.dao.impl.util.HibernateUtil;
import uit.se06.scholarshipweb.model.AcademicLevel;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SearchController {

	private static final Logger logger = LoggerFactory
			.getLogger(SearchController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		// logger.info("Welcome home! The client locale is {}.", locale);
		//
		SessionFactory sessionFactory = HibernateUtil
				.getSessionAnnotationFactory();
		sessionFactory.openSession();

		AcademicLevelBUS dao = new AcademicLevelBUS(sessionFactory);
		AcademicLevel l1 = dao.findById(1);

		// AcademicLevel l1 = l.get(1);
		String name = l1.getName();
		int id = l1.getId();

		String child = l1.getAcademicLevelDetails().get(0).getAcademicLevel()
				.getName();

		logger.info("Something " + name + " " + id + " " + child, id + "");

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "filter";
	}

}
