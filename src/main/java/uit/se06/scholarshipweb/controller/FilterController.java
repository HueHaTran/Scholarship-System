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
import uit.se06.scholarshipweb.bus.factory.BUSAbstractFactory;
import uit.se06.scholarshipweb.bus.factory.ICountryBUS;
import uit.se06.scholarshipweb.bus.factory.IScholarshipBUS;
import uit.se06.scholarshipweb.bus.util.Constants;
import uit.se06.scholarshipweb.model.Province;
import uit.se06.scholarshipweb.viewmodel.FilterViewModel;
import uit.se06.scholarshipweb.viewmodel.ListFilterAcademicLevel;
import uit.se06.scholarshipweb.viewmodel.ListFilterPersonalInfo;
import uit.se06.scholarshipweb.viewmodel.ListFilterScholarshipType;
import uit.se06.scholarshipweb.viewmodel.OverviewScholarshipViewModel;

/**
 * Handles requests for the application home page.
 */
@Controller
public class FilterController extends BaseController {

	private static final Logger logger = LoggerFactory
			.getLogger(FilterController.class);
	private static final String SPERATOR = "v";

	private FilterBUS bus;
	private ICountryBUS busCountry;
	private IScholarshipBUS busScholarship;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public FilterController() {
		super();

		bus = new FilterBUS();
		busCountry = BUSAbstractFactory.INS.getCountryBUS();
		busScholarship = BUSAbstractFactory.INS.getScholarshipBUS();
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
		try {
			id = Integer.parseInt(countryId);
		} catch (NumberFormatException e) {
			logger.error("Exception in " + this.getClass().getCanonicalName()
					+ ": " + e.toString());
			return new ArrayList<Province>();
		}

		List<Province> result = busCountry.listProvinceByCountry(id);

		ArrayList<Province> r2 = new ArrayList<Province>();
		for (Province province : result) {
			Province p = new Province();
			p.setId(province.getId());
			p.setName(province.getName());
			r2.add(p);
		}

		return r2;
	}

	@RequestMapping(value = "/filterResult", method = RequestMethod.GET)
	public ModelAndView filterResult(HttpServletRequest request) {

		ModelAndView model = new ModelAndView("filter-result");

		FilterViewModel filterModel = new FilterViewModel();
		filterModel.stuGender = getInt(request.getParameter("p1"));
		filterModel.stuCitizenship = getInt(request.getParameter("p2"));
		filterModel.stuResidenceCity = getInt(request.getParameter("p3"));
		filterModel.stuResidenceProvince = getInt(request.getParameter("p4"));
		filterModel.stuReligion = getInt(request.getParameter("p5"));
		filterModel.stuDisabilities = getListInt(request.getParameter("p6"));
		filterModel.stuTerminalIllnesses = getListInt(request
				.getParameter("p7"));
		filterModel.familyPolicy = getListInt(request.getParameter("p8"));
		filterModel.stuAca = getInt(request.getParameter("p9"));
		filterModel.stuAcaDetail = getInt(request.getParameter("p10"));
		filterModel.scholarAca = getInt(request.getParameter("p11"));
		filterModel.scholarAcaDetails = getInt(request.getParameter("p12"));
		filterModel.scholarMajors = getListInt(request.getParameter("p13"));
		filterModel.scholarType = getInt(request.getParameter("p14"));
		filterModel.talents = getListInt(request.getParameter("p15"));

		long noOfRecords = busScholarship.countRowsListBy(filterModel);

		model.addObject("filterModel", serialize(filterModel));
		model.addObject("resultTotal", noOfRecords);// total records

		return model;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/filterSubView", produces = "application/json")
	public ModelAndView getSubView(@RequestBody String data) {
		ModelAndView model = new ModelAndView("list-partition");

		FilterViewModel filterModel = deserial(data);

		List<OverviewScholarshipViewModel> list = busScholarship.filter(
				filterModel, 1, Constants.MAX_RESULT, false,
				Constants.MAX_RESULT); 
		
		model.addObject("results", list);

		return model;
	}

	private String serialize(FilterViewModel filterModel) {
		StringBuilder sb = new StringBuilder();

		sb.append(filterModel.stuGender).append(SPERATOR);// 1
		sb.append(filterModel.stuCitizenship).append(SPERATOR);
		sb.append(filterModel.stuResidenceCity).append(SPERATOR);
		sb.append(filterModel.stuResidenceProvince).append(SPERATOR);
		sb.append(filterModel.stuReligion).append(SPERATOR);// 5
		sb.append(
				filterModel.stuDisabilities.isEmpty() ? 0
						: serializeList(filterModel.stuDisabilities)).append(
				SPERATOR);
		sb.append(
				filterModel.stuTerminalIllnesses.isEmpty() ? 0
						: serializeList(filterModel.stuTerminalIllnesses))
				.append(SPERATOR);
		sb.append(
				filterModel.familyPolicy.isEmpty() ? 0
						: serializeList(filterModel.familyPolicy)).append(
				SPERATOR);
		sb.append(filterModel.stuAca).append(SPERATOR);
		sb.append(filterModel.stuAcaDetail).append(SPERATOR);// 10
		sb.append(filterModel.scholarAca).append(SPERATOR);
		sb.append(filterModel.scholarAcaDetails).append(SPERATOR);
		sb.append(
				filterModel.scholarMajors.isEmpty() ? 0
						: serializeList(filterModel.scholarMajors)).append(
				SPERATOR);
		sb.append(filterModel.scholarType).append(SPERATOR);
		sb.append(filterModel.talents.isEmpty() ? 0
				: serializeList(filterModel.talents));// 15

		return sb.toString();
	}

	private FilterViewModel deserial(String str) {
		if (str != null && !str.isEmpty()) {
			str = str.replace("\'", ""); 
			
			String[] params = str.split(SPERATOR);

			FilterViewModel filterModel = new FilterViewModel();

			filterModel.stuGender = getInt(params[0]);// 1
			filterModel.stuCitizenship = getInt(params[1]);// 2
			filterModel.stuResidenceCity = getInt(params[2]);// 3
			filterModel.stuResidenceProvince = getInt(params[3]);// 4
			filterModel.stuReligion = getInt(params[4]);// 5
			filterModel.stuDisabilities = getListInt(params[5]);// 6
			filterModel.stuTerminalIllnesses = getListInt(params[6]);// 7
			filterModel.familyPolicy = getListInt(params[7]);// 8
			filterModel.stuAca = getInt(params[8]);// 9
			filterModel.stuAcaDetail = getInt(params[9]);// 10
			filterModel.scholarAca = getInt(params[10]);// 11
			filterModel.scholarAcaDetails = getInt(params[11]);// 12
			filterModel.scholarMajors = getListInt(params[12]);// 13
			filterModel.scholarType = getInt(params[13]);// 14
			filterModel.talents = getListInt(params[14]);// 15
 
			return filterModel;
		} else {
			return null;
		}
	}

	private int getInt(String str) {
		int result = 0;

		if (str != null && !str.isEmpty()) {
			str = str.trim();
		} else {
			return result;
		}
		try {
			result = Integer.parseInt(str);
		} catch (Exception ex) {
			logger.error("Can't convert " + str + " to an integer!");

		}
		return result;
	}

	private List<Integer> getListInt(String str) {
		List<Integer> result = new ArrayList<Integer>();
		if (str == null) {
			return result;
		}
		String[] params = str.split("_");
		for (String string : params) {
			int value = getInt(string);
			if (value > 0) {
				result.add(value);
			}
		}
		return result;
	}

	private String serializeList(List<Integer> list) {
		if (list != null && !list.isEmpty()) {
			StringBuilder sb = new StringBuilder();
			sb.append(list.get(0));
			for (int i = 1; i < list.size(); i++) {
				sb.append("_").append(list.get(i));
			}
			return sb.toString();
		} else {
			return "";
		}
	}
}
