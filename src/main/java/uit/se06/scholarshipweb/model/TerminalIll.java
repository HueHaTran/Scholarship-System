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
@Table(name = "terminal_ill", catalog = "scholarshipdatabase", uniqueConstraints = { @UniqueConstraint(columnNames = "terminal_ill_name"), })
public class TerminalIll implements ISimpleModel {

	// ============================================================
	// PROPERTIES
	// ============================================================

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "terminal_ill_id", unique = true, nullable = false)
	private int terminalIllId;

	@Column(name = "terminal_ill_name", unique = true, nullable = false)
	private String terminalIllName;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "studentTerminalIllnesses")
	private List<Scholarship> scholarships;

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

	public List<Scholarship> getScholarships() {
		return scholarships;
	}

	public void setScholarships(List<Scholarship> scholarships) {
		this.scholarships = scholarships;
	}
}
