package uit.se06.scholarshipweb.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "school", catalog = "scholarshipdatabase", uniqueConstraints = { @UniqueConstraint(columnNames = "school_name"), })
public class School {

	// ============================================================
	// PROPERTIES
	// ============================================================

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "school_id", unique = true, nullable = false)
	private int schoolId;

	@Column(name = "school_name", unique = true, nullable = false)
	private String schoolName;

	@Column(name = "address", unique = false, nullable = true)
	private String address;

	@Column(name = "phone", unique = false, nullable = true)
	private String phone;

	@Column(name = "website", unique = false, nullable = true)
	private String website;

	@Column(name = "fax", unique = false, nullable = true)
	private String fax;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "province_id", referencedColumnName = "province_id")
	private Province province;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "school")
	private List<Scholarship> scholarships;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public School() {
	}

	public School(int schoolId, String schoolName, Province province) {
		setSchoolId(schoolId);
		setSchoolName(schoolName);
		setProvince(province);
	}

	// ============================================================
	// GETTERS & SETTERS
	// ============================================================

	public int getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public List<Scholarship> getScholarships() {
		return scholarships;
	}

	public void setScholarships(List<Scholarship> scholarships) {
		this.scholarships = scholarships;
	}
}
