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

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

@Entity
@Table(name = "talent", catalog = "scholarshipdatabase", uniqueConstraints = { @UniqueConstraint(columnNames = "talent_name"), })
@Indexed
public class Talent implements ISimpleModel {

	// ============================================================
	// PROPERTIES
	// ============================================================

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "talent_id", unique = true, nullable = false)
	private int talentId;

	@Column(name = "talent_name", unique = true, nullable = false)
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.YES)
	private String talentName;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "studentTalents")
	private List<ScholarshipSpecification> scholarships;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public Talent() {
	}

	public Talent(int talentId, String talentName) {
		setId(talentId);
		setName(talentName);
	}

	// ============================================================
	// GETTERS & SETTERS
	// ============================================================

	public int getId() {
		return talentId;
	}

	public void setId(int talentId) {
		this.talentId = talentId;
	}

	public String getName() {
		return talentName;
	}

	public void setName(String talentName) {
		this.talentName = talentName;
	}

	public List<ScholarshipSpecification> getScholarships() {
		return scholarships;
	}

	public void setScholarships(List<ScholarshipSpecification> scholarships) {
		this.scholarships = scholarships;
	}
}
