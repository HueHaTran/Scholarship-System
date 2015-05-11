package uit.se06.scholarshipweb.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "academic_level_detail", catalog = "scholarshipdatabase", uniqueConstraints = { @UniqueConstraint(columnNames = "academic_level_detail_name"), })
public class AcademicLevelDetail {

	// ============================================================
	// PROPERTIES
	// ============================================================

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "academic_level_detail_id", unique = true, nullable = false)
	private int academicLevelDetailId;

	@Column(name = "academic_level_detail_name", unique = true, nullable = false)
	private String academicLevelDetailName;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "academic_level_id", referencedColumnName = "academic_level_id")
	private AcademicLevel academicLevel;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public AcademicLevelDetail() {
	}

	public AcademicLevelDetail(int academicLevelDetailId,
			String academicLevelDetailName) {
		setAcademicLevelDetailId(academicLevelDetailId);
		setAcademicLevelDetailName(academicLevelDetailName);
	}

	// ============================================================
	// GETTERS & SETTERS
	// ============================================================

	public int getAcademicLevelDetailId() {
		return academicLevelDetailId;
	}

	public void setAcademicLevelDetailId(int academicLevelDetailId) {
		this.academicLevelDetailId = academicLevelDetailId;
	}

	public String getAcademicLevelDetailName() {
		return academicLevelDetailName;
	}

	public void setAcademicLevelDetailName(String academicLevelDetailName) {
		this.academicLevelDetailName = academicLevelDetailName;
	}

	public AcademicLevel getAcademicLevel() {
		return academicLevel;
	}

	public void setAcademicLevel(AcademicLevel academicLevel) {
		this.academicLevel = academicLevel;
	}
}
