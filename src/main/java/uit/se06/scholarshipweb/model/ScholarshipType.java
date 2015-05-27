package uit.se06.scholarshipweb.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

import uit.se06.scholarshipweb.dao.util.IndexScholarshipSpecInterceptor;

@Entity
@Table(name = "scholarship_type", catalog = "scholarshipdatabase", uniqueConstraints = { @UniqueConstraint(columnNames = "scholarship_type_name"), })
// index exception class
@Indexed(interceptor = IndexScholarshipSpecInterceptor.class)
public class ScholarshipType implements ISimpleModel {

	// ============================================================
	// PROPERTIES
	// ============================================================

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "scholarship_type_id", unique = true, nullable = false)
	private int scholarshipTypeId;

	@Column(name = "scholarship_type_name", unique = true, nullable = false)
	@Field(index = Index.YES, analyze = Analyze.NO, store = Store.YES)
	private String scholarshipTypeName;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "scholarshipType")
	private Set<ScholarshipSpecification> scholarships;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public ScholarshipType() {
	}

	public ScholarshipType(int scholarshipTypeId, String scholarshipTypeName) {
		setId(scholarshipTypeId);
		setName(scholarshipTypeName);
	}

	// ============================================================
	// GETTERS & SETTERS
	// ============================================================

	public int getId() {
		return scholarshipTypeId;
	}

	public void setId(int scholarshipTypeId) {
		this.scholarshipTypeId = scholarshipTypeId;
	}

	public String getName() {
		return scholarshipTypeName;
	}

	public void setName(String scholarshipTypeName) {
		this.scholarshipTypeName = scholarshipTypeName;
	}

	public Set<ScholarshipSpecification> getScholarships() {
		return scholarships;
	}

	public void setScholarships(Set<ScholarshipSpecification> scholarships) {
		this.scholarships = scholarships;
	}
}
