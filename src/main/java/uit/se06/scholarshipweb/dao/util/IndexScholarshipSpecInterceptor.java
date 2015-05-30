package uit.se06.scholarshipweb.dao.util;

import org.hibernate.search.indexes.interceptor.EntityIndexingInterceptor;
import org.hibernate.search.indexes.interceptor.IndexingOverride;

import uit.se06.scholarshipweb.model.ScholarshipSpecification;

/**
 * Conditional indexing: to index or not based on entity state
 * 
 * @author chx93
 *
 */
public class IndexScholarshipSpecInterceptor implements
		EntityIndexingInterceptor<ScholarshipSpecification> {

	// ============================================================
	// OVERRIDE METHODS
	// ============================================================

	@Override
	public IndexingOverride onAdd(ScholarshipSpecification entity) {
		// only index scholarship when it is active
		if (allowIndexing(entity)) {
			return IndexingOverride.APPLY_DEFAULT;
		}
		return IndexingOverride.SKIP;
	}

	@Override
	public IndexingOverride onCollectionUpdate(ScholarshipSpecification entity) {
		return onUpdate(entity);
	}

	@Override
	public IndexingOverride onDelete(ScholarshipSpecification entity) {
		return IndexingOverride.APPLY_DEFAULT;
	}

	@Override
	public IndexingOverride onUpdate(ScholarshipSpecification entity) {
		if (allowIndexing(entity)) {
			return IndexingOverride.UPDATE;
		}
		return IndexingOverride.REMOVE;
	}

	// ============================================================
	// CONDITIONS
	// ============================================================

	private boolean allowIndexing(ScholarshipSpecification entity) {
		return entity.getScholarship().getIsActive() == true;
	}
}
