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

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

@Entity
@Table(name = "terminal_ill", catalog = "scholarshipdatabase", uniqueConstraints = { @UniqueConstraint(columnNames = "terminal_ill_name"), })
@Indexed
public class TerminalIll implements ISimpleModel {

	// ============================================================
	// PROPERTIES
	// ============================================================

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "terminal_ill_id", unique = true, nullable = false)
	private int terminalIllId;

	@Column(name = "terminal_ill_name", unique = true, nullable = false)
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.YES)
	private String terminalIllName;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "studentTerminalIllnesses")
	private List<ScholarshipSpecification> scholarships;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public TerminalIll() {
	}

	public TerminalIll(int terminalIllId, String terminalIllName) {
		setId(terminalIllId);
		setName(terminalIllName);
	}

	// ============================================================
	// GETTERS & SETTERS
	// ============================================================

	public int getId() {
		return terminalIllId;
	}

	public void setId(int terminalIllId) {
		this.terminalIllId = terminalIllId;
	}

	public String getName() {
		return terminalIllName;
	}

	public void setName(String terminalIllName) {
		this.terminalIllName = terminalIllName;
	}

	public List<ScholarshipSpecification> getScholarships() {
		return scholarships;
	}

	public void setScholarships(List<ScholarshipSpecification> scholarships) {
		this.scholarships = scholarships;
	}
}
