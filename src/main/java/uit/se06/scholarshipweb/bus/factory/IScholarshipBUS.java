package uit.se06.scholarshipweb.bus.factory;

import java.util.List;

import uit.se06.scholarshipweb.model.Scholarship;
import uit.se06.scholarshipweb.viewmodel.FilterViewModel;
import uit.se06.scholarshipweb.viewmodel.OverviewScholarshipViewModel;
import uit.se06.scholarshipweb.viewmodel.ScholarshipViewModel;

public interface IScholarshipBUS extends IBUS<Scholarship> {

	ScholarshipViewModel findViewModelById(int id, boolean allowEmptyString);

	ScholarshipViewModel findViewModelByName(String name,
			boolean allowEmptyString);

	OverviewScholarshipViewModel convertToOverviewViewModel(
			Scholarship scholarship, boolean allowEmptyString);

	List<OverviewScholarshipViewModel> filter(FilterViewModel data,
			int pageNumber, int pageSize, boolean allowEmptyString, int maxResult);

	long countRowsListBy(FilterViewModel data);
}