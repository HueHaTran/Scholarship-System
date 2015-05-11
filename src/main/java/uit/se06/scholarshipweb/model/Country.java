package uit.se06.scholarshipweb.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "country", catalog = "scholarshipdatabase", uniqueConstraints = { @UniqueConstraint(columnNames = "country_name"), })
public class Country {

	// ============================================================
	// PROPERTIES
	// ============================================================

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "country_id", unique = true, nullable = false)
	private int countryId;

	@Column(name = "country_name", unique = true, nullable = false)
	private String countryName;

	// "mappedBy"'s value is property'name, not column'name
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
	private List<Province> provinces;

	// "mappedBy"'s value is property'name, not column'name
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "studentCitizenship")
	private List<Scholarship> scholarshipsWithStudentCitizenship;

	// "mappedBy"'s value is property'name, not column'name
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "studentResidence")
	private List<Scholarship> scholarshipsWithStudentResidence;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public Country() {
	}

	public Country(int countryId, String countryName) {
		setCountryId(countryId);
		setCountryName(countryName);
	}

	// ============================================================
	// GETTERS & SETTERS
	// ============================================================

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public List<Scholarship> getScholarshipsWithStudentCitizenship() {
		return scholarshipsWithStudentCitizenship;
	}

	public void setScholarshipsWithStudentCitizenship(
			List<Scholarship> scholarshipsWithStudentCitizenship) {
		this.scholarshipsWithStudentCitizenship = scholarshipsWithStudentCitizenship;
	}

	public List<Scholarship> getScholarshipsWithStudentResidence() {
		return scholarshipsWithStudentResidence;
	}

	public void setScholarshipsWithStudentResidence(
			List<Scholarship> scholarshipsWithStudentResidence) {
		this.scholarshipsWithStudentResidence = scholarshipsWithStudentResidence;
	}
}