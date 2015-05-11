package uit.se06.scholarshipweb.dao;

import java.util.List;

public interface IBasicDAO<T> {
	T findById(int id);

	T findByName(String name);

	List<T> list();
}
