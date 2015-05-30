package uit.se06.scholarshipweb.bus.factory;

import java.util.List;

import uit.se06.scholarshipweb.viewmodel.FilterViewModel;
import uit.se06.scholarshipweb.viewmodel.OverviewScholarshipViewModel;

public interface ISearchBUS {
	void filterByLucene(FilterViewModel data, int pageNumber, int pageSize);

	void filterByHibernate(FilterViewModel data, int pageNumber, int pageSize);

	List<OverviewScholarshipViewModel> search(String keyWord, int pageNumber,
			int pageSize);

	int getTopResultRowCount(String keyWord);
}
