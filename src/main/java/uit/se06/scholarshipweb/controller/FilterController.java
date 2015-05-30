package uit.se06.scholarshipweb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import uit.se06.scholarshipweb.bus.FilterBUS;
import uit.se06.scholarshipweb.bus.factory.ICountryBUS;
import uit.se06.scholarshipweb.bus.serviceprovider.da.DACountryBUS;
import uit.se06.scholarshipweb.model.Province;
import uit.se06.scholarshipweb.model.Scholarship;
import uit.se06.scholarshipweb.viewmodel.FilterViewModel;
import uit.se06.scholarshipweb.viewmodel.ListFilterAcademicLevel;
import uit.se06.scholarshipweb.viewmodel.ListFilterPersonalInfo;
import uit.se06.scholarshipweb.viewmodel.ListFilterScholarshipType;

/**
 * Handles requests for the application home page.
 */
@Controller
public class FilterController extends BaseController {

	private static final Logger logger = LoggerFactory
			.getLogger(FilterController.class);

	private FilterBUS bus;
	private ICountryBUS busCountry;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public FilterController() {
		super();
		logger.info("Enter Filter's controller");// test

		bus = new FilterBUS();
		busCountry = new DACountryBUS();
	}

	// ============================================================
	// REQUESTS
	// ============================================================

	@RequestMapping(value = "/filter", method = RequestMethod.GET)
	public ModelAndView home(Locale locale) {

		logger.info("Welcome to " + this.getClass().getCanonicalName()
				+ "! The client locale is {}.", locale);

		ModelAndView data = new ModelAndView("filter");
		ListFilterPersonalInfo entity = bus.getPersonalInfo();
		ListFilterAcademicLevel entity2 = bus.getAcademicLevelInfo();
		ListFilterScholarshipType entity3 = bus.getScholarshipTypeInfo();

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

	@RequestMapping(value = "/getProvincesFromCountry", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody List<Province> getProvincesFromCountry(
			HttpServletRequest request, @RequestBody String countryId) {
		int id;
		logger.info("Enter getProvincesFromCountry() in Filter Controller");
		try {
			id = Integer.parseInt(countryId);
		} catch (NumberFormatException e) {
			logger.error("Exception in " + this.getClass().getCanonicalName()
					+ ": " + e.toString());
			return new ArrayList<Province>();
		}

		List<Province> result = busCountry.listProvinceByCountry(id);

		for (Province p : result) {
			System.err.println("Size:ttt " + p);
		}

		System.err.println("Size:ttt " + result.size());

		return result;
	}

	@RequestMapping(value = "/getFilterResult", method = RequestMethod.POST, produces = "application/json; MediaType.APPLICATION_JSON_VALUE")
	public @ResponseBody List<Scholarship> getFilterResult(
			HttpServletRequest request, @RequestBody FilterViewModel data) {
		logger.info("Enter getFilterResult() in Filter Controller");

		return new ArrayList<Scholarship>();
	}
}
