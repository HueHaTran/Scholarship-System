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
@Table(name = "form_of_participation", catalog = "scholarshipdatabase", uniqueConstraints = { @UniqueConstraint(columnNames = "form_of_participation_name"), })
public class FormOfParticipation {

	// ============================================================
	// PROPERTIES
	// ============================================================

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "form_of_participation_id", unique = true, nullable = false)
	private int formOfParticipationId;

	@Column(name = "form_of_participation_name", unique = true, nullable = false)
	private String formOfParticipationName;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "formOfParticipation")
	private List<Scholarship> scholarships;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public FormOfParticipation() {
	}

	public FormOfParticipation(int formOfParticipationId,
			String formOfParticipationName) {
		setFormOfParticipationId(formOfParticipationId);
		setFormOfParticipationName(formOfParticipationName);
	}

	// ============================================================
	// GETTERS & SETTERS
	// ============================================================

	public int getFormOfParticipationId() {
		return formOfParticipationId;
	}

	public void setFormOfParticipationId(int formOfParticipationId) {
		this.formOfParticipationId = formOfParticipationId;
	}

	public String getFormOfParticipationName() {
		return formOfParticipationName;
	}

	public void setFormOfParticipationName(String formOfParticipationName) {
		this.formOfParticipationName = formOfParticipationName;
	}

	public List<Scholarship> getScholarships() {
		return scholarships;
	}

	public void setScholarships(List<Scholarship> scholarships) {
		this.scholarships = scholarships;
	}
}