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
import org.hibernate.search.annotations.ContainedIn;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

@Entity
@Table(name = "gender", catalog = "scholarshipdatabase", uniqueConstraints = { @UniqueConstraint(columnNames = "gender_name"), })
@Indexed
public class Gender implements ISimpleModel {

	// ============================================================
	// PROPERTIES
	// ============================================================

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "gender_id", unique = true, nullable = false)
	private int genderId;

	@Column(name = "gender_name", unique = true, nullable = false)
	@Field(index = Index.YES, analyze = Analyze.NO, store = Store.YES)
	private String genderName;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "studentGender")
	@ContainedIn
	private Set<ScholarshipSpecification> scholarships;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public Gender() {
	}

	public Gender(int genderId, String genderName) {
		setId(genderId);
		setName(genderName);
	}

	// ============================================================
	// GETTERS & SETTERS
	// ============================================================

	public int getId() {
		return genderId;
	}

	public void setId(int genderId) {
		this.genderId = genderId;
	}

	public String getName() {
		return genderName;
	}

	public void setName(String genderName) {
		this.genderName = genderName;
	}

	public Set<ScholarshipSpecification> getScholarships() {
		return scholarships;
	}

	public void setScholarships(Set<ScholarshipSpecification> scholarships) {
		this.scholarships = scholarships;
	}
}
