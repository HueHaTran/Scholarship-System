package uit.se06.scholarshipweb.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "scholarship_type", catalog = "scholarshipdatabase", uniqueConstraints = { @UniqueConstraint(columnNames = "scholarship_type_name"), })
public class ScholarshipType {

	// ============================================================
	// PROPERTIES
	// ============================================================

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "scholarship_type_id", unique = true, nullable = false)
	private int scholarshipTypeId;

	@Column(name = "scholarship_type_name", unique = true, nullable = false)
	private String scholarshipTypeName;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public ScholarshipType() {
	}

	public ScholarshipType(int scholarshipTypeId, String scholarshipTypeName) {
		setScholarshipTypeId(scholarshipTypeId);
		setScholarshipTypeName(scholarshipTypeName);
	}

	// ============================================================
	// GETTERS & SETTERS
	// ============================================================

	public int getScholarshipTypeId() {
		return scholarshipTypeId;
	}

	public void setScholarshipTypeId(int scholarshipTypeId) {
		this.scholarshipTypeId = scholarshipTypeId;
	}

	public String getScholarshipTypeName() {
		return scholarshipTypeName;
	}

	public void setScholarshipTypeName(String scholarshipTypeName) {
		this.scholarshipTypeName = scholarshipTypeName;
	}
}
