package uit.se06.scholarshipweb.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "religion", catalog = "scholarshipdatabase", uniqueConstraints = { @UniqueConstraint(columnNames = "religion_name"), })
public class Religion {

	// ============================================================
	// PROPERTIES
	// ============================================================

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "religion_id", unique = true, nullable = false)
	private int religionId;

	@Column(name = "religion_name", unique = true, nullable = false)
	private String religionName;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public Religion(int religionId, String religionName) {
		setReligionId(religionId);
		setReligionName(religionName);
	}

	// ============================================================
	// GETTERS & SETTERS
	// ============================================================

	public int getReligionId() {
		return religionId;
	}

	public void setReligionId(int religionId) {
		this.religionId = religionId;
	}

	public String getReligionName() {
		return religionName;
	}

	public void setReligionName(String religionName) {
		this.religionName = religionName;
	}
}
