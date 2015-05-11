package uit.se06.scholarshipweb.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "major", catalog = "scholarshipdatabase", uniqueConstraints = { @UniqueConstraint(columnNames = "major_name"), })
public class Major {

	// ============================================================
	// PROPERTIES
	// ============================================================

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "major_id", unique = true, nullable = false)
	private int majorId;

	@Column(name = "major_name", unique = true, nullable = false)
	private String majorName;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "scholarshipMajors")
	private List<Scholarship> scholarships;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public Major() {
	}

	public Major(int majorId, String majorName) {
		setMajorId(majorId);
		setMajorName(majorName);
	}

	// ============================================================
	// GETTERS & SETTERS
	// ============================================================

	public int getMajorId() {
		return majorId;
	}

	public void setMajorId(int majorId) {
		this.majorId = majorId;
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public List<Scholarship> getScholarships() {
		return scholarships;
	}

	public void setScholarships(List<Scholarship> scholarships) {
		this.scholarships = scholarships;
	}
}
