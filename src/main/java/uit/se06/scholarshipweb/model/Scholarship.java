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
	private Date date_end_register;

	@Column(name = "value_min", unique = false, nullable = false)
	private int value_min;

	@Column(name = "value_max", unique = false, nullable = false)
	private int value_max;

	@Column(name = "application_description", unique = false, nullable = true)
	private String application_description;

	@Column(name = "support_description", unique = false, nullable = true)
	private String support_description;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "student_gender_id", referencedColumnName = "gender_id")
	private Gender studentGender;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

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
}
