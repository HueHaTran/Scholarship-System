package uit.se06.scholarshipweb.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "scholarship", catalog = "scholarshipdatabase", uniqueConstraints = { @UniqueConstraint(columnNames = "scholarship_name"), })
public class Scholarship implements ISimpleModel {

	// ============================================================
	// PROPERTIES
	// ============================================================

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "scholarship_id", unique = true, nullable = false)
	private int scholarshipId;

	@Column(name = "scholarship_name", unique = false, nullable = false)
	private String scholarshipName;

	@Column(name = "date_end_register", unique = false, nullable = true)
	private Date dateEndRegister;

	@Column(name = "value_min", unique = false, nullable = false)
	private int valueMin;

	@Column(name = "value_max", unique = false, nullable = false)
	private int valueMax;

	//

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "scholarship", cascade = CascadeType.ALL)
	private ScholarshipSpecification scholarshipSpecification;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "scholarship_academic_level_detail", catalog = "scholarshipdatabase", joinColumns = { @JoinColumn(name = "scholarship_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "academic_level_detail_id", nullable = false, updatable = false) })
	private List<AcademicLevelDetail> scholarshipAcademicLevelDetail;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "scholarship_family_policy", catalog = "scholarshipdatabase", joinColumns = { @JoinColumn(name = "scholarship_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "family_policy_id", nullable = false, updatable = false) })
	private List<FamilyPolicy> studentFamilyPolicies;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "scholarship_disability", catalog = "scholarshipdatabase", joinColumns = { @JoinColumn(name = "scholarship_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "disability_id", nullable = false, updatable = false) })
	private List<Disability> studentDisabilities;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "scholarship_terminal_ill", catalog = "scholarshipdatabase", joinColumns = { @JoinColumn(name = "scholarship_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "terminal_ill_id", nullable = false, updatable = false) })
	private List<TerminalIll> studentTerminalIllnesses;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "scholarship_sponsor", catalog = "scholarshipdatabase", joinColumns = { @JoinColumn(name = "scholarship_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "sponsor_id", nullable = false, updatable = false) })
	private List<Sponsor> sponsors;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "scholarship_major", catalog = "scholarshipdatabase", joinColumns = { @JoinColumn(name = "scholarship_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "major_id", nullable = false, updatable = false) })
	private List<Major> scholarshipMajors;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "scholarship_talent", catalog = "scholarshipdatabase", joinColumns = { @JoinColumn(name = "scholarship_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "talent_id", nullable = false, updatable = false) })
	private List<Talent> studentTalents;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "scholarship_student_residence", catalog = "scholarshipdatabase", joinColumns = { @JoinColumn(name = "scholarship_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "province_id", nullable = false, updatable = false) })
	private List<Province> studentResidences;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public Scholarship() {
		scholarshipSpecification = new ScholarshipSpecification();
	}

	public Scholarship(int scholarshipId, String scholarshipName) {
		this();
		setId(scholarshipId);
		setName(scholarshipName);
	}

	// ============================================================
	// GETTERS & SETTERS
	// ============================================================

	public int getId() {
		return scholarshipId;
	}

	public void setId(int scholarshipId) {
		this.scholarshipId = scholarshipId;
	}

	public String getName() {
		return scholarshipName;
	}

	public void setName(String scholarshipName) {
		this.scholarshipName = scholarshipName;
	}

	public Date getDateEndRegister() {
		return dateEndRegister;
	}

	public void setDateEndRegister(Date dateEndRegister) {
		this.dateEndRegister = dateEndRegister;
	}

	public int getValueMin() {
		return valueMin;
	}

	public void setValueMin(int valueMin) {
		this.valueMin = valueMin;
	}

	public int getValueMax() {
		return valueMax;
	}

	public void setValueMax(int valueMax) {
		this.valueMax = valueMax;
	}

	public List<AcademicLevelDetail> getScholarshipAcademicLevelDetail() {
		return scholarshipAcademicLevelDetail;
	}

	public void setScholarshipAcademicLevelDetail(
			List<AcademicLevelDetail> scholarshipAcademicLevelDetail) {
		this.scholarshipAcademicLevelDetail = scholarshipAcademicLevelDetail;
	}

	public List<FamilyPolicy> getStudentFamilyPolicies() {
		return studentFamilyPolicies;
	}

	public void setStudentFamilyPolicies(
			List<FamilyPolicy> studentFamilyPolicies) {
		this.studentFamilyPolicies = studentFamilyPolicies;
	}

	public List<Disability> getStudentDisabilities() {
		return studentDisabilities;
	}

	public void setStudentDisabilities(List<Disability> studentDisabilities) {
		this.studentDisabilities = studentDisabilities;
	}

	public List<TerminalIll> getStudentTerminalIllnesses() {
		return studentTerminalIllnesses;
	}

	public void setStudentTerminalIllnesses(
			List<TerminalIll> studentTerminalIllnesses) {
		this.studentTerminalIllnesses = studentTerminalIllnesses;
	}

	public List<Sponsor> getSponsors() {
		return sponsors;
	}

	public void setSponsors(List<Sponsor> sponsors) {
		this.sponsors = sponsors;
	}

	public List<Major> getScholarshipMajors() {
		return scholarshipMajors;
	}

	public void setScholarshipMajors(List<Major> scholarshipMajors) {
		this.scholarshipMajors = scholarshipMajors;
	}

	public List<Talent> getStudentTalents() {
		return studentTalents;
	}

	public void setStudentTalents(List<Talent> studentTalents) {
		this.studentTalents = studentTalents;
	}

	public List<Province> getStudentResidences() {
		return studentResidences;
	}

	public void setStudentResidences(List<Province> studentResidences) {
		this.studentResidences = studentResidences;
	}

	public ScholarshipSpecification getScholarshipSpecification() {
		return scholarshipSpecification;
	}

	public void setScholarshipSpecification(
			ScholarshipSpecification scholarshipSpecification) {
		this.scholarshipSpecification = scholarshipSpecification;
	}
}
