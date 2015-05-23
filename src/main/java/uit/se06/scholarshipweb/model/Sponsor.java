package uit.se06.scholarshipweb.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "sponsor", catalog = "scholarshipdatabase", uniqueConstraints = { @UniqueConstraint(columnNames = "sponsor_name"), })
public class Sponsor implements ISimpleModel {

	// ============================================================
	// PROPERTIES
	// ============================================================

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "sponsor_id", unique = true, nullable = false)
	private int sponsorId;

	@Column(name = "sponsor_name", unique = true, nullable = false)
	private String sponsorName;

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

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "sponsors")
	private List<ScholarshipSpecification> scholarships;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public Sponsor() {
	}

	public Sponsor(int sponsorId, String sponsorName, Province province) {
		setId(sponsorId);
		setName(sponsorName);
		setProvince(province);
	}

	// ============================================================
	// GETTERS & SETTERS
	// ============================================================

	public int getId() {
		return sponsorId;
	}

	public void setId(int sponsorId) {
		this.sponsorId = sponsorId;
	}

	public String getName() {
		return sponsorName;
	}

	public void setName(String sponsorName) {
		this.sponsorName = sponsorName;
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

	public List<ScholarshipSpecification> getScholarships() {
		return scholarships;
	}

	public void setScholarships(List<ScholarshipSpecification> scholarships) {
		this.scholarships = scholarships;
	}
}
