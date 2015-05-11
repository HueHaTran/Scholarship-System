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
@Table(name = "ethnic", catalog = "scholarshipdatabase", uniqueConstraints = { @UniqueConstraint(columnNames = "ethnic_name"), })
public class Ethnic {

	// ============================================================
	// PROPERTIES
	// ============================================================

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ethnic_id", unique = true, nullable = false)
	private int ethnicId;

	@Column(name = "ethnic_name", unique = true, nullable = false)
	private String ethnicName;

	// "mappedBy"'s value is property'name, not column'name
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "studentEthnic")
	private List<Scholarship> scholarships;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public Ethnic() {
	}

	public Ethnic(int ethnicId, String ethnicName) {
		setEthnicId(ethnicId);
		setEthnicName(ethnicName);
	}

	// ============================================================
	// GETTERS & SETTERS
	// ============================================================

	public int getEthnicId() {
		return ethnicId;
	}

	public void setEthnicId(int ethnicId) {
		this.ethnicId = ethnicId;
	}

	public String getEthnicName() {
		return ethnicName;
	}

	public void setEthnicName(String ethnicName) {
		this.ethnicName = ethnicName;
	}

	public List<Scholarship> getScholarships() {
		return scholarships;
	}

	public void setScholarships(List<Scholarship> scholarships) {
		this.scholarships = scholarships;
	}
}