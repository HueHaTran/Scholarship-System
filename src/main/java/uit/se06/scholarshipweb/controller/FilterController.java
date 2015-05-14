package uit.se06.scholarshipweb.controller;

import java.util.Locale;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import uit.se06.scholarshipweb.bus.FilterBUS;
import uit.se06.scholarshipweb.dao.impl.util.HibernateUtil;
import uit.se06.scholarshipweb.viewmodel.FilterPersonalInfo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class FilterController {

	private static final Logger logger = LoggerFactory
			.getLogger(FilterController.class);

	private FilterBUS bus;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public FilterController() {
		logger.info("Enter Filter's controller");// test
		SessionFactory sessionFactory = HibernateUtil
				.getSessionAnnotationFactory();
		bus = new FilterBUS(sessionFactory);
	}

	// ============================================================
	// REQUESTS
	// ============================================================

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView home(Locale locale) {
		logger.info("Welcome to " + this.getClass().getCanonicalName()
				+ "! The client locale is {}.", locale);

		ModelAndView data = new ModelAndView("filter");
		FilterPersonalInfo entity = bus.getPersonalInfo();

		data.addObject("meta_data_gender", entity.getGenders());
		data.addObject("meta_data_country", entity.getCountries());
		//data.addObject("meta_data_province", entity.getProvinces());
		data.addObject("meta_data_religion", entity.getReligion());
		data.addObject("meta_data_disability", entity.getDisabilities());
		data.addObject("meta_data_terminal_ill", entity.getTerminalIllnesses());

		return data;
	}
}
