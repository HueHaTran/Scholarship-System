package uit.se06.scholarshipweb.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

@Entity
@Table(name = "academic_level_detail", catalog = "scholarshipdatabase", uniqueConstraints = { @UniqueConstraint(columnNames = "academic_level_detail_name"), })
@Indexed
public class AcademicLevelDetail implements ISimpleModel {

	// ============================================================
	// PROPERTIES
	// ============================================================

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "academic_level_detail_id", unique = true, nullable = false)
	private int academicLevelDetailId;

	@Column(name = "academic_level_detail_name", unique = true, nullable = false)
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.YES)
	private String academicLevelDetailName;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "academic_level_id", referencedColumnName = "academic_level_id")
	private AcademicLevel academicLevel;

	// "mappedBy"'s value is property'name, not column'name
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "studentAcademicLevelDetail")
	private Set<ScholarshipSpecification> scholarshipsWithStudentAcademicLevelDetail;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "scholarshipAcademicLevelDetail")
	private Set<ScholarshipSpecification> scholarships;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public AcademicLevelDetail() {
	}

	public AcademicLevelDetail(int academicLevelDetailId,
			String academicLevelDetailName) {
		setId(academicLevelDetailId);
		setName(academicLevelDetailName);
	}

	// ============================================================
	// GETTERS & SETTERS
	// ============================================================

	public int getId() {
		return academicLevelDetailId;
	}

	public void setId(int academicLevelDetailId) {
		this.academicLevelDetailId = academicLevelDetailId;
	}

	public String getName() {
		return academicLevelDetailName;
	}

	public void setName(String academicLevelDetailName) {
		this.academicLevelDetailName = academicLevelDetailName;
	}

	public AcademicLevel getAcademicLevel() {
		return academicLevel;
	}

	public void setAcademicLevel(AcademicLevel academicLevel) {
		this.academicLevel = academicLevel;
	}

	public Set<ScholarshipSpecification> getScholarships() {
		return scholarships;
	}

	public void setScholarships(Set<ScholarshipSpecification> scholarships) {
		this.scholarships = scholarships;
	}

	public Set<ScholarshipSpecification> getScholarshipsWithStudentAcademicLevelDetail() {
		return scholarshipsWithStudentAcademicLevelDetail;
	}

	public void setScholarshipsWithStudentAcademicLevelDetail(
			Set<ScholarshipSpecification> scholarshipsWithStudentAcademicLevelDetail) {
		this.scholarshipsWithStudentAcademicLevelDetail = scholarshipsWithStudentAcademicLevelDetail;
	}
}
