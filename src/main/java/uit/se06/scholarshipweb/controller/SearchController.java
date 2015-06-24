package uit.se06.scholarshipweb.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import uit.se06.scholarshipweb.bus.factory.BUSAbstractFactory;
import uit.se06.scholarshipweb.bus.factory.ISearchBUS;
import uit.se06.scholarshipweb.bus.util.Constants;
import uit.se06.scholarshipweb.viewmodel.OverviewScholarshipViewModel;

@Controller
public class SearchController {
	private static final Logger logger = LoggerFactory
			.getLogger(SearchController.class);

	private ISearchBUS busSearch;

	public SearchController() {
		super();
		busSearch = BUSAbstractFactory.INS.getSearchBUS();
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView search(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("scholarship-list");

		String keyWord = "";
		try {
			if (request.getParameter("keyWord") != null) {
				keyWord = new String(request.getParameter("keyWord").trim()
						.getBytes("iso-8859-1"), "UTF-8");
				logger.info("Searching " + keyWord + "...");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		int noOfRecords = busSearch.getTopResultRowCount(keyWord);

		model.addObject("keyWord", keyWord);
		model.addObject("resultTotal", noOfRecords);// total records
													// page
		return model;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/searchSubView", produces = "application/json")
	public ModelAndView getSubView(@RequestBody String keyWord) {
		ModelAndView model = new ModelAndView("list-partition");

		List<OverviewScholarshipViewModel> list = busSearch.search(keyWord, 1,
				Constants.MAX_RESULT, Constants.MAX_RESULT);

		model.addObject("results", list);

		return model;
	}

}
