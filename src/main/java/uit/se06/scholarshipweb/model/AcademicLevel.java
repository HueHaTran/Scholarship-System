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

import org.hibernate.annotations.Sort;
import org.hibernate.annotations.SortType;

@Entity
@Table(name = "academic_level", catalog = "scholarshipdatabase", uniqueConstraints = { @UniqueConstraint(columnNames = "academic_level_name"), })
public class AcademicLevel implements ISimpleModel{

	// ============================================================
	// PROPERTIES
	// ============================================================

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "academic_level_id", unique = true, nullable = false)
	private int academicLevelId;

	@Column(name = "academic_level_name", unique = true, nullable = false)
	private String academicLevelName;

	// "mappedBy"'s value is property'name, not column'name
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "academicLevel")
	private List<AcademicLevelDetail> academicLevelDetails;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public AcademicLevel() {
	}

	public AcademicLevel(int academicLevelId, String academicLevelName) {
		setId(academicLevelId);
		setName(academicLevelName);
	}

	// ============================================================
	// GETTERS & SETTERS
	// ============================================================

	public int getId() {
		return academicLevelId;
	}

	public void setId(int academicLevelId) {
		this.academicLevelId = academicLevelId;
	}

	public String getName() {
		return academicLevelName;
	}

	public void setName(String academicLevelName) {
		this.academicLevelName = academicLevelName;
	}

	public List<AcademicLevelDetail> getAcademicLevelDetails() {
		return academicLevelDetails;
	}

	public void setAcademicLevelDetails(
			List<AcademicLevelDetail> academicLevelDetails) {
		this.academicLevelDetails = academicLevelDetails;
	}
}
