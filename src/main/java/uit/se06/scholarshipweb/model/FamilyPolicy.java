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
public class FamilyPolicy implements ISimpleModel {

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
		setId(familyPolicyId);
		setName(familyPolicyName);
	}

	// ============================================================
	// GETTERS & SETTERS
	// ============================================================

	public int getId() {
		return familyPolicyId;
	}

	public void setId(int familyPolicyId) {
		this.familyPolicyId = familyPolicyId;
	}

	public String getName() {
		return familyPolicyName;
	}

	public void setName(String familyPolicyName) {
		this.familyPolicyName = familyPolicyName;
	}

	public List<Scholarship> getScholarships() {
		return scholarships;
	}

	public void setScholarships(List<Scholarship> scholarships) {
		this.scholarships = scholarships;
	}
}
