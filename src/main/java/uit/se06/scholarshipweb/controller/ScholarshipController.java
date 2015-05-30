package uit.se06.scholarshipweb.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import uit.se06.scholarshipweb.bus.factory.BUSAbstractFactory;
import uit.se06.scholarshipweb.bus.factory.IScholarshipBUS;
import uit.se06.scholarshipweb.viewmodel.ScholarshipViewModel;

@Controller
public class ScholarshipController {
	private static final Logger logger = LoggerFactory
			.getLogger(ScholarshipController.class);

	private IScholarshipBUS busScholarship;

	public ScholarshipController() {
		super();
		busScholarship = BUSAbstractFactory.INS.getScholarshipBUS();
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ModelAndView search(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("search");

		String idStr = request.getParameter("id").trim();

		int id = 0;
		try {
			id = Integer.parseInt(idStr);
		} catch (NumberFormatException ex) {
			logger.error(ex.toString());
			return model;
		}

		ScholarshipViewModel entity = busScholarship.findViewModelById(id);

		model.addObject("entity", entity);
		return model;
	}
}
