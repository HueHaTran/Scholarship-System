package uit.se06.scholarshipweb.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "scholarship_type", catalog = "scholarshipdatabase", uniqueConstraints = { @UniqueConstraint(columnNames = "scholarship_type_name"), })
public class ScholarshipType implements ISimpleModel {

	// ============================================================
	// PROPERTIES
	// ============================================================

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "scholarship_type_id", unique = true, nullable = false)
	private int scholarshipTypeId;

	@Column(name = "scholarship_type_name", unique = true, nullable = false)
	private String scholarshipTypeName;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "scholarshipType")
	private List<Scholarship> scholarships;

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

	public List<Scholarship> getScholarships() {
		return scholarships;
	}

	public void setScholarships(List<Scholarship> scholarships) {
		this.scholarships = scholarships;
	}
}
