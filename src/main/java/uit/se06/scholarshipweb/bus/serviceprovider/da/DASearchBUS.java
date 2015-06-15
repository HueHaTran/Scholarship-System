package uit.se06.scholarshipweb.bus.serviceprovider.da;

import java.util.ArrayList;
import java.util.List;

import uit.se06.scholarshipweb.bus.factory.ISearchBUS;
import uit.se06.scholarshipweb.bus.util.Constants;
import uit.se06.scholarshipweb.bus.util.Utility;
import uit.se06.scholarshipweb.dao.factory.DAOAbstractFactory;
import uit.se06.scholarshipweb.dao.factory.ISearchDAO;
import uit.se06.scholarshipweb.model.Scholarship;
import uit.se06.scholarshipweb.viewmodel.OverviewScholarshipViewModel;

public class DASearchBUS implements ISearchBUS {

	private ISearchDAO dao;

	public DASearchBUS() {
		dao = DAOAbstractFactory.INS.getSearchDAO();
	}

	// @Override
	// public void filterByLucene(FilterViewModel data, int pageNumber,
	// int pageSize) {
	// if (pageNumber <= 0) {
	// System.err.println(this.getClass().getCanonicalName()
	// + "pageNumber can't be smaller than 0");
	// return;
	// }
	// if (pageNumber * pageSize < maxResult) {
	// dao.filterByLucene(data, pageNumber, pageSize);
	// }
	// }

	// @Override
	// public void filterByHibernate(FilterViewModel data, int pageNumber,
	// int pageSize) {
	// if (pageNumber <= 0) {
	// System.err.println(this.getClass().getCanonicalName()
	// + "pageNumber can't be smaller than 0");
	// return;
	// }
	// if (pageNumber * pageSize < maxResult) {
	// dao.filterByHibernate(data, pageNumber, pageSize);
	// }
	// }

	@Override
	public List<OverviewScholarshipViewModel> search(String keyWord,
			int pageNumber, int pageSize, int maxResult) {
		if (pageNumber <= 0) {
			System.err.println(this.getClass().getCanonicalName()
					+ "pageNumber can't be smaller than 0");
		} else if (pageNumber * pageSize < maxResult) {
			List<Scholarship> listParent = dao.getTopResult(keyWord,
					pageNumber, pageSize);

			List<OverviewScholarshipViewModel> result = new ArrayList<OverviewScholarshipViewModel>();
			for (Scholarship s : listParent) {
				String date = Constants.TAG_NO_ANSWER;
				String schoolNames = Constants.TAG_NO_ANSWER;

				if (s.getScholarshipSpecification() != null
						&& s.getScholarshipSpecification().getSchool() != null) {
					schoolNames = s.getScholarshipSpecification().getSchool()
							.getName();
				}
				if (s.getDateEndRegister() != null) {
					date = Utility.getIns().getDateString(
							s.getDateEndRegister(), false);
				}
				result.add(new OverviewScholarshipViewModel(s.getId(), s
						.getName(), schoolNames, date,
						Utility.getIns().getMoneyString(s.getValueMin(),
								s.getValueMax(), false)));
			}
			return result;
		}
		return new ArrayList<OverviewScholarshipViewModel>();
	}

	@Override
	public int getTopResultRowCount(String keyWord) {
		return dao.getTopResultRowCount(keyWord);
	}
}
