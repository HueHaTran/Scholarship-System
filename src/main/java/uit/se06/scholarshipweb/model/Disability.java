package uit.se06.scholarshipweb.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
}
