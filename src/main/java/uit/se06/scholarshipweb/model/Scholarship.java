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
import javax.persistence.ManyToOne;
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

	@Column(name = "description", unique = false, nullable = true)
	private String description;

	@Column(name = "original_link", unique = false, nullable = true)
	private String originalLink;

	@Column(name = "count", unique = false, nullable = false)
	private int count;

	@Column(name = "date_end_register", unique = false, nullable = true)
	private Date dateEndRegister;

	@Column(name = "value_min", unique = false, nullable = false)
	private int valueMin;

	@Column(name = "value_max", unique = false, nullable = false)
	private int valueMax;

	@Column(name = "application_description", unique = false, nullable = true)
	private String applicationDescription;

	@Column(name = "support_description", unique = false, nullable = true)
	private String supportDescription;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "student_gender_id", referencedColumnName = "gender_id")
	private Gender studentGender;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "student_citizenship_id", referencedColumnName = "country_id")
	private Country studentCitizenship;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "student_ethnic_id", referencedColumnName = "ethnic_id")
	private Ethnic studentEthnic;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "student_religion_id", referencedColumnName = "religion_id")
	private Religion studentReligion;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "student_academic_level_detail_id", referencedColumnName = "academic_level_detail_id")
	private AcademicLevelDetail studentAcademicLevelDetail;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "scholarship_type_id", referencedColumnName = "scholarship_type_id")
	private ScholarshipType scholarshipType;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "school_id", referencedColumnName = "school_id")
	private School school;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "form_of_participation_id", referencedColumnName = "form_of_participation_id")
	private FormOfParticipation formOfParticipation;

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
	}

	public Scholarship(int scholarshipId, String scholarshipName) {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOriginal_link() {
		return originalLink;
	}

	public void setOriginal_link(String original_link) {
		this.originalLink = original_link;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
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

	public String getApplicationDescription() {
		return applicationDescription;
	}

	public void setApplicationDescription(String applicationDescription) {
		this.applicationDescription = applicationDescription;
	}

	public String getSupportDescription() {
		return supportDescription;
	}

	public void setSupportDescription(String supportDescription) {
		this.supportDescription = supportDescription;
	}

	public Gender getStudentGender() {
		return studentGender;
	}

	public void setStudentGender(Gender studentGender) {
		this.studentGender = studentGender;
	}

	public Country getStudentCitizenship() {
		return studentCitizenship;
	}

	public void setStudentCitizenship(Country studentCitizenship) {
		this.studentCitizenship = studentCitizenship;
	}

	public Ethnic getStudentEthnic() {
		return studentEthnic;
	}

	public void setStudentEthnic(Ethnic studentEthnic) {
		this.studentEthnic = studentEthnic;
	}

	public Religion getStudentReligion() {
		return studentReligion;
	}

	public void setStudentReligion(Religion studentReligion) {
		this.studentReligion = studentReligion;
	}

	public AcademicLevelDetail getStudentAcademicLevelDetail() {
		return studentAcademicLevelDetail;
	}

	public void setStudentAcademicLevelDetail(
			AcademicLevelDetail studentAcademicLevelDetail) {
		this.studentAcademicLevelDetail = studentAcademicLevelDetail;
	}

	public ScholarshipType getScholarshipType() {
		return scholarshipType;
	}

	public void setScholarshipType(ScholarshipType scholarshipType) {
		this.scholarshipType = scholarshipType;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public FormOfParticipation getFormOfParticipation() {
		return formOfParticipation;
	}

	public void setFormOfParticipation(FormOfParticipation formOfParticipation) {
		this.formOfParticipation = formOfParticipation;
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
}
