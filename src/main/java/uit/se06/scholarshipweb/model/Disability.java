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
@Table(name = "disability", catalog = "scholarshipdatabase", uniqueConstraints = { @UniqueConstraint(columnNames = "disability_name"), })
public class Disability {

	// ============================================================
	// PROPERTIES
	// ============================================================

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "disability_id", unique = true, nullable = false)
	private int disabilityId;

	@Column(name = "disability_name", unique = true, nullable = false)
	private String disabilityName;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "studentDisabilities")
	private List<Scholarship> scholarships;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public Disability() {
	}

	public Disability(int disabilityId, String disabilityName) {
		setDisabilityId(disabilityId);
		setDisabilityName(disabilityName);
	}

	// ============================================================
	// GETTERS & SETTERS
	// ============================================================

	public int getDisabilityId() {
		return disabilityId;
	}

	public void setDisabilityId(int disabilityId) {
		this.disabilityId = disabilityId;
	}

	public String getDisabilityName() {
		return disabilityName;
	}

	public void setDisabilityName(String disabilityName) {
		this.disabilityName = disabilityName;
	}

	public List<Scholarship> getScholarships() {
		return scholarships;
	}

	public void setScholarships(List<Scholarship> scholarships) {
		this.scholarships = scholarships;
	}
}