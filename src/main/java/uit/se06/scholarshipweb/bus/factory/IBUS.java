package uit.se06.scholarshipweb.bus.factory;

import java.util.List;

public interface IBUS<T> {

	T findById(int id);

	T findByName(String name);

	List<T> list();

	void insert(T entity);
}
