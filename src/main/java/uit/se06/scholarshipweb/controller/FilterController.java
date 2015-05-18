package uit.se06.scholarshipweb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import uit.se06.scholarshipweb.bus.CountryBUS;
import uit.se06.scholarshipweb.bus.FilterBUS;
import uit.se06.scholarshipweb.dao.impl.util.HibernateUtil;
import uit.se06.scholarshipweb.model.Province;
import uit.se06.scholarshipweb.viewmodel.FilterAcademicLevel;
import uit.se06.scholarshipweb.viewmodel.FilterPersonalInfo;
import uit.se06.scholarshipweb.viewmodel.FilterScholarshipType;

/**
 * Handles requests for the application home page.
 */
@Controller
public class FilterController {

	private static final Logger logger = LoggerFactory
			.getLogger(FilterController.class);

	private FilterBUS bus;
	private CountryBUS busCountry;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public FilterController() {
		logger.info("Enter Filter's controller");// test
		SessionFactory sessionFactory = HibernateUtil
				.getSessionAnnotationFactory();
		bus = new FilterBUS(sessionFactory);
		busCountry = new CountryBUS(sessionFactory);
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
		FilterAcademicLevel entity2 = bus.getAcademicLevelInfo();
		FilterScholarshipType entity3 = bus.getScholarshipTypeInfo();

		data.addObject("meta_data_gender", entity.getGenders());
		data.addObject("meta_data_country", entity.getCountries());
		// Provinces: no need to add province
		data.addObject("meta_data_religion", entity.getReligion());
		data.addObject("meta_data_disability", entity.getDisabilities());
		data.addObject("meta_data_terminal_ill", entity.getTerminalIllnesses());
		data.addObject("meta_data_family_policy", entity.getFamilyPolicies());

		data.addObject("meta_data_academic_level", entity2.getAcademicLevels());
		data.addObject("meta_data_major", entity2.getMajors());

		data.addObject("meta_data_scholarship_type",
				entity3.getScholarshipTypes());
		data.addObject("meta_data_talent", entity3.getTalents());

		return data;
	}

	@RequestMapping(value = "/get_province", method = RequestMethod.POST, produces = "application/json; MediaType.APPLICATION_JSON_VALUE")
	public @ResponseBody List<Province> getProvincesFromCountry(
			HttpServletRequest request, @RequestBody String countryId) {
		int id;
		try {
			id = Integer.parseInt(countryId);
		} catch (NumberFormatException e) {
			logger.info("Exception in " + this.getClass().getCanonicalName()
					+ ": " + e.toString());
			return new ArrayList<Province>();
		}

		List<Province> result = busCountry.listProvinceByCountry(id);
		return result;
	}
}
