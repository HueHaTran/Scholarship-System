package uit.se06.scholarshipweb.bus.serviceprovider.da;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;

import uit.se06.scholarshipweb.dao.factory.IDAO;
import uit.se06.scholarshipweb.model.ISimpleModel;

public abstract class DABaseBUS<T extends ISimpleModel> {

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
		Set<T> set = getDAO().list();
		if (set == null) {
			getLogger().info("Warning: " + "list()" + " return null or empty.");
			return null;
		}
		List<T> result = new ArrayList<T>(set);
		if (result == null || (result != null && result.isEmpty())) {
			getLogger().info("Warning: " + "list()" + " return null or empty.");
		} else {
			Collections.sort(result, COMPARATOR);
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

	protected static final Comparator<ISimpleModel> COMPARATOR = new Comparator<ISimpleModel>() {
		public int compare(ISimpleModel entity1, ISimpleModel entity2) {
			if (entity1 == entity2) {
				return 0;
			}
			if (entity1 == null) {
				return -1;
			}
			if (entity2 == null) {
				return 1;
			}
			return entity1.getName().compareTo(entity2.getName());
		}
	};
}
