package uit.se06.scholarshipweb.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

@Entity
@Table(name = "disability", catalog = "scholarshipdatabase", uniqueConstraints = { @UniqueConstraint(columnNames = "disability_name"), })
@Indexed
public class Disability implements ISimpleModel {

	// ============================================================
	// PROPERTIES
	// ============================================================

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "disability_id", unique = true, nullable = false)
	private int disabilityId;

	@Column(name = "disability_name", unique = true, nullable = false)
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.YES)
	private String disabilityName;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "studentDisabilities")
	private Set<ScholarshipSpecification> scholarships;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public Disability() {
	}

	public Disability(int disabilityId, String disabilityName) {
		setId(disabilityId);
		setName(disabilityName);
	}

	// ============================================================
	// GETTERS & SETTERS
	// ============================================================

	public int getId() {
		return disabilityId;
	}

	public void setId(int disabilityId) {
		this.disabilityId = disabilityId;
	}

	public String getName() {
		return disabilityName;
	}

	public void setName(String disabilityName) {
		this.disabilityName = disabilityName;
	}

	public Set<ScholarshipSpecification> getScholarships() {
		return scholarships;
	}

	public void setScholarships(Set<ScholarshipSpecification> scholarships) {
		this.scholarships = scholarships;
	}
}
