package uit.se06.scholarshipweb.dao.factory;

import java.util.Set;

import uit.se06.scholarshipweb.model.Scholarship;

public interface ISearchDAO {
	public Set<Scholarship> getTopResult(String keyWord, int count);
}
