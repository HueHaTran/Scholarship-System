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
@Table(name = "talent", catalog = "scholarshipdatabase", uniqueConstraints = { @UniqueConstraint(columnNames = "talent_name"), })
public class Talent {

	// ============================================================
	// PROPERTIES
	// ============================================================

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "talent_id", unique = true, nullable = false)
	private int talentId;

	@Column(name = "talent_name", unique = true, nullable = false)
	private String talentName;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "studentTalents")
	private List<Scholarship> scholarships;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public Talent() {
	}

	public Talent(int talentId, String talentName) {
		setTalentId(talentId);
		setTalentName(talentName);
	}

	// ============================================================
	// GETTERS & SETTERS
	// ============================================================

	public int getTalentId() {
		return talentId;
	}

	public void setTalentId(int talentId) {
		this.talentId = talentId;
	}

	public String getTalentName() {
		return talentName;
	}

	public void setTalentName(String talentName) {
		this.talentName = talentName;
	}

	public List<Scholarship> getScholarships() {
		return scholarships;
	}

	public void setScholarships(List<Scholarship> scholarships) {
		this.scholarships = scholarships;
	}
}
