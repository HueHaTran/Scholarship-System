package uit.se06.scholarshipweb.dao.factory;

import java.util.List;

import uit.se06.scholarshipweb.model.Scholarship;

public interface ISearchDAO {
	public List<Scholarship> getTopResult(String keyWord, int count);
}
