package uit.se06.scholarshipweb.viewmodel;

public class OverviewScholarshipViewModel {

	// ============================================================
	// PROPERTIES
	// ============================================================

	private int id;
	private String name;
	private String schoolName;
	private String dateEndRegister;
	private String value;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================
	public OverviewScholarshipViewModel() {
	}

	public OverviewScholarshipViewModel(int id, String name, String schoolName,
			String dateEndRegister, String value) {
		this.id = id;
		this.name = name;
		this.schoolName = schoolName;
		this.dateEndRegister = dateEndRegister;
		this.value = value;
	}

	// ============================================================
	// GETTERS & SETTERS
	// ============================================================

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolNames) {
		this.schoolName = schoolNames;
	}

	public String getDateEndRegister() {
		return dateEndRegister;
	}

	public void setDateEndRegister(String dateEndRegister) {
		this.dateEndRegister = dateEndRegister;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
