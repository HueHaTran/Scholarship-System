package uit.se06.scholarshipweb.dao.factory;

import java.util.Set;

public interface IDAO<T> {
	T findById(int id);

	T findByName(String name);

	Set<T> list();

	void insert(T entity);
}
