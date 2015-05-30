package uit.se06.scholarshipweb.dao.factory;

import java.util.List;

import uit.se06.scholarshipweb.model.Scholarship;
import uit.se06.scholarshipweb.viewmodel.FilterViewModel;

public interface ISearchDAO {
	List<Scholarship> filterByHibernate(FilterViewModel entity, int pageNumber,
			int pageSize);

	List<Scholarship> filterByLucene(FilterViewModel entity, int pageNumber,
			int pageSize);

	List<Scholarship> getTopResult(String keyWord, int pageNumber, int pageSize);

	int getTopResultRowCount(String keyWord);
}
