package uit.se06.scholarshipweb.bus.factory;

import java.util.List;

import uit.se06.scholarshipweb.viewmodel.OverviewScholarshipViewModel;

public interface ISearchBUS {

	List<OverviewScholarshipViewModel> search(String keyWord, int pageNumber,
			int pageSize, int maxResult);

	int getTopResultRowCount(String keyWord);

}
