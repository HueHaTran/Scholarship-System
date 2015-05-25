package uit.se06.scholarshipweb.dao.util;

import org.hibernate.search.indexes.interceptor.EntityIndexingInterceptor;
import org.hibernate.search.indexes.interceptor.IndexingOverride;

import uit.se06.scholarshipweb.model.Scholarship;

/**
 * Conditional indexing: to index or not based on entity state
 * 
 * @author chx93
 *
 */
public class IndexScholarshipInterceptor implements
		EntityIndexingInterceptor<Scholarship> {

	// ============================================================
	// OVERRIDE METHODS
	// ============================================================

	@Override
	public IndexingOverride onAdd(Scholarship entity) {
		// only index scholarship when it is active
		if (allowIndexing(entity)) {
			return IndexingOverride.APPLY_DEFAULT;
		}
		return IndexingOverride.SKIP;
	}

	@Override
	public IndexingOverride onCollectionUpdate(Scholarship entity) {
		if (allowIndexing(entity)) {
			return IndexingOverride.UPDATE;
		}
		return IndexingOverride.REMOVE;
	}

	@Override
	public IndexingOverride onDelete(Scholarship entity) {
		return IndexingOverride.APPLY_DEFAULT;
	}

	@Override
	public IndexingOverride onUpdate(Scholarship entity) {
		return onUpdate(entity);
	}

	// ============================================================
	// CONDITIONS
	// ============================================================

	private boolean allowIndexing(Scholarship entity) {
		return entity.getIsActive() == true;
	}

}
