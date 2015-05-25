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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

@Entity
@Table(name = "province", catalog = "scholarshipdatabase", uniqueConstraints = { @UniqueConstraint(columnNames = "province_name"), })
@Indexed
public class Province implements ISimpleModel {

	// ============================================================
	// PROPERTIES
	// ============================================================

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "province_id", unique = true, nullable = false)
	private int provinceId;

	@Column(name = "province_name", unique = true, nullable = false)
	@Field(index = Index.YES, analyze = Analyze.NO, store = Store.YES)
	private String provinceName;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "country_id", referencedColumnName = "country_id")
	private Country country;

	// "mappedBy"'s value is property'name, not column'name
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "province")
	private List<School> schools;

	// "mappedBy"'s value is property'name, not column'name
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "province")
	private List<Sponsor> sponsors;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "studentResidences")
	private List<ScholarshipSpecification> scholarshipsWithResidence;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public Province() {
	}

	public Province(int provinceId, String provinceName, Country country) {
		setId(provinceId);
		setName(provinceName);
		setCountry(country);
	}

	// ============================================================
	// GETTERS & SETTERS
	// ============================================================

	public int getId() {
		return provinceId;
	}

	public void setId(int provinceId) {
		this.provinceId = provinceId;
	}

	public String getName() {
		return provinceName;
	}

	public void setName(String provinceName) {
		this.provinceName = provinceName;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<ScholarshipSpecification> getScholarshipsWithResidence() {
		return scholarshipsWithResidence;
	}

	public void setScholarshipsWithResidence(
			List<ScholarshipSpecification> scholarshipsWithResidence) {
		this.scholarshipsWithResidence = scholarshipsWithResidence;
	}
}
