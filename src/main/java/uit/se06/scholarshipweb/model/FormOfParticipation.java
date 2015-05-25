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

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

@Entity
@Table(name = "form_of_participation", catalog = "scholarshipdatabase", uniqueConstraints = { @UniqueConstraint(columnNames = "form_of_participation_name"), })
@Indexed
public class FormOfParticipation  implements ISimpleModel{

	// ============================================================
	// PROPERTIES
	// ============================================================

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "form_of_participation_id", unique = true, nullable = false)
	private int formOfParticipationId;

	@Column(name = "form_of_participation_name", unique = true, nullable = false)
	@Field(index = Index.YES, analyze = Analyze.NO, store = Store.YES)
	private String formOfParticipationName;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "formOfParticipation")
	private List<ScholarshipSpecification> scholarships;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public FormOfParticipation() {
	}

	public FormOfParticipation(int formOfParticipationId,
			String formOfParticipationName) {
		setId(formOfParticipationId);
		setName(formOfParticipationName);
	}

	// ============================================================
	// GETTERS & SETTERS
	// ============================================================

	public int getId() {
		return formOfParticipationId;
	}

	public void setId(int formOfParticipationId) {
		this.formOfParticipationId = formOfParticipationId;
	}

	public String getName() {
		return formOfParticipationName;
	}

	public void setName(String formOfParticipationName) {
		this.formOfParticipationName = formOfParticipationName;
	}

	public List<ScholarshipSpecification> getScholarships() {
		return scholarships;
	}

	public void setScholarships(List<ScholarshipSpecification> scholarships) {
		this.scholarships = scholarships;
	}
}
