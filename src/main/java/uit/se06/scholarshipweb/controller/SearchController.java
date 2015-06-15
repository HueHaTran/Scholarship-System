package uit.se06.scholarshipweb.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import uit.se06.scholarshipweb.bus.factory.BUSAbstractFactory;
import uit.se06.scholarshipweb.bus.factory.ISearchBUS;
import uit.se06.scholarshipweb.bus.util.Constants;
import uit.se06.scholarshipweb.model.Scholarship;
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
		int pageNumber = 1;
		try {
			if (request.getParameter("pageNum") != null) {
				pageNumber = Integer.parseInt(request.getParameter("pageNum")
						.trim());
			}
		} catch (NumberFormatException ex) {

		}
		if (keyWord != null && !keyWord.isEmpty()) {
			List<OverviewScholarshipViewModel> list = busSearch.search(keyWord,
					pageNumber, Constants.pageSize, Constants.maxResult);
			model.addObject("results", list);
		} else {
			model.addObject("results", new ArrayList<Scholarship>());
		}

		int noOfRecords = 0;
		String noOfRecordStr = request.getParameter("resultTotal");
		if (noOfRecordStr != null) {
			try {
				noOfRecords = Integer.parseInt(noOfRecordStr);
			} catch (Exception ex) {
			}
			if (noOfRecords == 0) {
				noOfRecords = busSearch.getTopResultRowCount(keyWord);
			}
		}
		int noOfPages = (int) Math
				.ceil((noOfRecords < Constants.maxResult ? noOfRecords
						: Constants.maxResult) * 1.0 / Constants.pageSize);

		System.err.println("Test noOfPage "+noOfPages+" max "+Constants.maxResult+" pagesze "+Constants.pageSize);
		
		model.addObject("keyWord", keyWord);
		model.addObject("noOfPages", noOfPages);// total page
		model.addObject("resultTotal", noOfRecords);// total records
		model.addObject("pageNumber", pageNumber);// current page
		model.addObject("pageSize", Constants.pageSize);// number of records per
														// page
		return model;
	}
}
