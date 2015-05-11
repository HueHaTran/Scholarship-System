package uit.se06.scholarshipweb.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "family_policy", catalog = "scholarshipdatabase", uniqueConstraints = { @UniqueConstraint(columnNames = "family_policy_name"), })
public class FamilyPolicy {

	// ============================================================
	// PROPERTIES
	// ============================================================

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "family_policy_id", unique = true, nullable = false)
	private int familyPolicyId;

	@Column(name = "family_policy_name", unique = true, nullable = false)
	private String familyPolicyName;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "studentFamilyPolicies")
	private List<Scholarship> scholarships;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public FamilyPolicy() {
	}

	public FamilyPolicy(int familyPolicyId, String familyPolicyName) {
		setFamilyPolicyId(familyPolicyId);
		setFamilyPolicyName(familyPolicyName);
	}

	// ============================================================
	// GETTERS & SETTERS
	// ============================================================

	public int getFamilyPolicyId() {
		return familyPolicyId;
	}

	public void setFamilyPolicyId(int familyPolicyId) {
		this.familyPolicyId = familyPolicyId;
	}

	public String getFamilyPolicyName() {
		return familyPolicyName;
	}

	public void setFamilyPolicyName(String familyPolicyName) {
		this.familyPolicyName = familyPolicyName;
	}

	public List<Scholarship> getScholarships() {
		return scholarships;
	}

	public void setScholarships(List<Scholarship> scholarships) {
		this.scholarships = scholarships;
	}
}
