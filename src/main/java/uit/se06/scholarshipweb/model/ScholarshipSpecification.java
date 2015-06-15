package uit.se06.scholarshipweb.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Store;

@Entity
@Table(name = "scholarship_specification", catalog = "scholarshipdatabase")
@Indexed
public class ScholarshipSpecification {

	// ============================================================
	// PROPERTIES
	// ============================================================

	@Id
	@Column(name = "scholarship_id", unique = true, nullable = false)
	private int scholarshipId;

	@Column(name = "description", unique = false, nullable = true)
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String description;

	@Column(name = "original_link", unique = false, nullable = true)
	@Field(index = Index.YES, analyze = Analyze.NO, store = Store.YES)
	private String originalLink;

	@Column(name = "count", unique = false, nullable = false)
	private int count;

	@Column(name = "application_description", unique = false, nullable = true)
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String applicationDescription;

	@Column(name = "support_description", unique = false, nullable = true)
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String supportDescription;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "scholarship_id", referencedColumnName = "scholarship_id")
	@IndexedEmbedded
	private Scholarship scholarship;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_gender_id", referencedColumnName = "gender_id")
	@IndexedEmbedded
	private Gender studentGender;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_citizenship_id", referencedColumnName = "country_id")
	@IndexedEmbedded
	private Country studentCitizenship;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_ethnic_id", referencedColumnName = "ethnic_id")
	@IndexedEmbedded
	private Ethnic studentEthnic;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_religion_id", referencedColumnName = "religion_id")
	@IndexedEmbedded
	private Religion studentReligion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_academic_level_detail_id", referencedColumnName = "academic_level_detail_id")
	@IndexedEmbedded
	private AcademicLevelDetail studentAcademicLevelDetail;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "scholarship_type_id", referencedColumnName = "scholarship_type_id")
	@IndexedEmbedded
	private ScholarshipType scholarshipType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "school_id", referencedColumnName = "school_id")
	@IndexedEmbedded
	private School school;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "form_of_participation_id", referencedColumnName = "form_of_participation_id")
	@IndexedEmbedded
	private FormOfParticipation formOfParticipation;

	// many to many
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "scholarship_academic_level_detail", catalog = "scholarshipdatabase", joinColumns = { @JoinColumn(name = "scholarship_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "academic_level_detail_id", nullable = false, updatable = false) })
	@IndexedEmbedded
	private Set<AcademicLevelDetail> scholarshipAcademicLevelDetail;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "scholarship_family_policy", catalog = "scholarshipdatabase", joinColumns = { @JoinColumn(name = "scholarship_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "family_policy_id", nullable = false, updatable = false) })
	@IndexedEmbedded
	private Set<FamilyPolicy> studentFamilyPolicies;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "scholarship_disability", catalog = "scholarshipdatabase", joinColumns = { @JoinColumn(name = "scholarship_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "disability_id", nullable = false, updatable = false) })
	@IndexedEmbedded
	private Set<Disability> studentDisabilities;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "scholarship_terminal_ill", catalog = "scholarshipdatabase", joinColumns = { @JoinColumn(name = "scholarship_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "terminal_ill_id", nullable = false, updatable = false) })
	@IndexedEmbedded
	private Set<TerminalIll> studentTerminalIllnesses;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "scholarship_sponsor", catalog = "scholarshipdatabase", joinColumns = { @JoinColumn(name = "scholarship_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "sponsor_id", nullable = false, updatable = false) })
	@IndexedEmbedded
	private Set<Sponsor> sponsors;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "scholarship_major", catalog = "scholarshipdatabase", joinColumns = { @JoinColumn(name = "scholarship_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "major_id", nullable = false, updatable = false) })
	@IndexedEmbedded
	private Set<Major> scholarshipMajors;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "scholarship_talent", catalog = "scholarshipdatabase", joinColumns = { @JoinColumn(name = "scholarship_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "talent_id", nullable = false, updatable = false) })
	@IndexedEmbedded
	private Set<Talent> studentTalents;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "scholarship_student_residence", catalog = "scholarshipdatabase", joinColumns = { @JoinColumn(name = "scholarship_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "province_id", nullable = false, updatable = false) })
	@IndexedEmbedded
	private Set<Province> studentResidences;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public ScholarshipSpecification() {
	}

	// ============================================================
	// GETTERS & SETTERS
	// ============================================================

	public int getScholarshipId() {
		return scholarshipId;
	}

	public void setScholarshipId(int scholarshipId) {
		this.scholarshipId = scholarshipId;
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

	public Scholarship getScholarship() {
		return scholarship;
	}

	public void setScholarship(Scholarship scholarship) {
		this.scholarship = scholarship;
	}

	public Set<AcademicLevelDetail> getScholarshipAcademicLevelDetail() {
		return scholarshipAcademicLevelDetail;
	}

	public void setScholarshipAcademicLevelDetail(
			Set<AcademicLevelDetail> scholarshipAcademicLevelDetail) {
		this.scholarshipAcademicLevelDetail = scholarshipAcademicLevelDetail;
	}

	public Set<FamilyPolicy> getStudentFamilyPolicies() {
		return studentFamilyPolicies;
	}

	public void setStudentFamilyPolicies(Set<FamilyPolicy> studentFamilyPolicies) {
		this.studentFamilyPolicies = studentFamilyPolicies;
	}

	public Set<Disability> getStudentDisabilities() {
		return studentDisabilities;
	}

	public void setStudentDisabilities(Set<Disability> studentDisabilities) {
		this.studentDisabilities = studentDisabilities;
	}

	public Set<TerminalIll> getStudentTerminalIllnesses() {
		return studentTerminalIllnesses;
	}

	public void setStudentTerminalIllnesses(
			Set<TerminalIll> studentTerminalIllnesses) {
		this.studentTerminalIllnesses = studentTerminalIllnesses;
	}

	public Set<Sponsor> getSponsors() {
		return sponsors;
	}

	public void setSponsors(Set<Sponsor> sponsors) {
		this.sponsors = sponsors;
	}

	public Set<Major> getScholarshipMajors() {
		return scholarshipMajors;
	}

	public void setScholarshipMajors(Set<Major> scholarshipMajors) {
		this.scholarshipMajors = scholarshipMajors;
	}

	public Set<Talent> getStudentTalents() {
		return studentTalents;
	}

	public void setStudentTalents(Set<Talent> studentTalents) {
		this.studentTalents = studentTalents;
	}

	public Set<Province> getStudentResidences() {
		return studentResidences;
	}

	public void setStudentResidences(Set<Province> studentResidences) {
		this.studentResidences = studentResidences;
	}

}
