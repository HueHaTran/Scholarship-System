package uit.se06.scholarshipweb.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	private int policyFamilyId;

	@Column(name = "family_policy_name", unique = true, nullable = false)
	private String policyFamilyName;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public FamilyPolicy(int policyFamilyId, String policyFamilyName) {
		setPolicyFamilyId(policyFamilyId);
		setPolicyFamilyName(policyFamilyName);
	}

	// ============================================================
	// GETTERS & SETTERS
	// ============================================================

	public int getPolicyFamilyId() {
		return policyFamilyId;
	}

	public void setPolicyFamilyId(int policyFamilyId) {
		this.policyFamilyId = policyFamilyId;
	}

	public String getPolicyFamilyName() {
		return policyFamilyName;
	}

	public void setPolicyFamilyName(String policyFamilyName) {
		this.policyFamilyName = policyFamilyName;
	}
}
