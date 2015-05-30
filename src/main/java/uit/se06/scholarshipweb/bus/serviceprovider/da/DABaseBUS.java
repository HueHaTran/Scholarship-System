package uit.se06.scholarshipweb.bus.serviceprovider.da;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;

import uit.se06.scholarshipweb.dao.factory.IDAO;

public abstract class DABaseBUS<T> {

	// ============================================================
	// METHODS
	// ============================================================

	public T findById(int id) {
		T entity = getDAO().findById(id);

		if (entity == null) {
			getLogger().info(
					"Warning: " + "findById(" + id + ")" + " return null.");
		}

		return entity;
	}

	public T findByName(String name) {
		T entity = getDAO().findByName(name);

		if (entity == null) {
			getLogger().info(
					"Warning: " + "findByName(" + name + ")" + " return null.");
		}
		return entity;
	}

	public List<T> list() {
		List<T> result = new ArrayList<T>(getDAO().list());
		if (result == null || (result != null && result.isEmpty())) {
			getLogger().info("Warning: " + "list()" + " return null or empty.");
		}

		return result;
	}

	public void insert(T entity) {
		if (entity != null) {
			getDAO().insert(entity);
		}
	}

	// ============================================================
	// ABSTRACT METHODS
	// ============================================================

	protected abstract IDAO<T> getDAO();

	protected abstract Logger getLogger();

	// ============================================================
	// OTHER METHODS
	// ============================================================

}
