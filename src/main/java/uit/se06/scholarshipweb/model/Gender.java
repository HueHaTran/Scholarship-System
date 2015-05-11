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
@Table(name = "gender", catalog = "scholarshipdatabase", uniqueConstraints = { @UniqueConstraint(columnNames = "gender_name"), })
public class Gender {

	// ============================================================
	// PROPERTIES
	// ============================================================

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "gender_id", unique = true, nullable = false)
	private int genderId;

	@Column(name = "gender_name", unique = true, nullable = false)
	private String genderName;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "studentGender")
	private List<Scholarship> scholarships;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public Gender() {
	}

	public Gender(int genderId, String genderName) {
		setGenderId(genderId);
		setGenderName(genderName);
	}

	// ============================================================
	// GETTERS & SETTERS
	// ============================================================

	public int getGenderId() {
		return genderId;
	}

	public void setGenderId(int genderId) {
		this.genderId = genderId;
	}

	public String getGenderName() {
		return genderName;
	}

	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}

	public List<Scholarship> getScholarships() {
		return scholarships;
	}

	public void setScholarships(List<Scholarship> scholarships) {
		this.scholarships = scholarships;
	}
}