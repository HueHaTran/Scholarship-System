package uit.se06.scholarshipweb.model;

import static javax.persistence.GenerationType.IDENTITY;

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
@Table(name = "province", catalog = "scholarshipdatabase", uniqueConstraints = { @UniqueConstraint(columnNames = "province_name"), })
public class Province {

	// ============================================================
	// PROPERTIES
	// ============================================================

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "province_id", unique = true, nullable = false)
	private int provinceId;

	@Column(name = "province_name", unique = true, nullable = false)
	private String provinceName;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "country_id", referencedColumnName = "country_id")
	private Country country;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public Province(int provinceId, String provinceName, Country country) {
		setProvinceId(provinceId);
		setProvinceName(provinceName);
		setCountry(country);
	}

	// ============================================================
	// GETTERS & SETTERS
	// ============================================================

	public int getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
}
