package uit.se06.scholarshipweb.dao.factory;

import java.util.List;

import uit.se06.scholarshipweb.model.Scholarship;

public interface ISearchDAO {

	List<Scholarship> getTopResult(String keyWord, int pageNumber, int pageSize);

	int getTopResultRowCount(String keyWord);
}
