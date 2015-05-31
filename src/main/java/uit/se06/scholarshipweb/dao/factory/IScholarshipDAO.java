package uit.se06.scholarshipweb.dao.factory;

import java.util.List;

import uit.se06.scholarshipweb.model.Scholarship;
import uit.se06.scholarshipweb.viewmodel.FilterViewModel;

public interface IScholarshipDAO extends IDAO<Scholarship> {

	List<Scholarship> listBy(FilterViewModel data, int pageNumber, int pageSize);

	int countRowsListBy(FilterViewModel data);
}
