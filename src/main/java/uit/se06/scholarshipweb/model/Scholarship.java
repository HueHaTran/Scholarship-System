package uit.se06.scholarshipweb.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

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
@Table(name = "scholarship", catalog = "scholarshipdatabase", uniqueConstraints = { @UniqueConstraint(columnNames = "scholarship_name"), })
public class Scholarship {

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
	private String original_link;

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
	@JoinColumn(name = "student_residence_id", referencedColumnName = "country_id")
	private Country studentResidence;

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

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public Scholarship() {
	}

	public Scholarship(int scholarshipId, String scholarshipName) {
		setScholarshipId(scholarshipId);
		setScholarshipName(scholarshipName);
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

	public String getScholarshipName() {
		return scholarshipName;
	}

	public void setScholarshipName(String scholarshipName) {
		this.scholarshipName = scholarshipName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOriginal_link() {
		return original_link;
	}

	public void setOriginal_link(String original_link) {
		this.original_link = original_link;
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

	public Country getStudentResidence() {
		return studentResidence;
	}

	public void setStudentResidence(Country studentResidence) {
		this.studentResidence = studentResidence;
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
}
