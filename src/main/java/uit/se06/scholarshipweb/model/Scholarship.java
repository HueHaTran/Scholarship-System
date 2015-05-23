package uit.se06.scholarshipweb.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

	public ScholarshipSpecification getScholarshipSpecification() {
		return scholarshipSpecification;
	}

	public void setScholarshipSpecification(
			ScholarshipSpecification scholarshipSpecification) {
		this.scholarshipSpecification = scholarshipSpecification;
	}
}
