package uit.se06.scholarshipweb.viewmodel;

public class OverviewScholarshipViewModel {

	// ============================================================
	// PROPERTIES
	// ============================================================

	private int id;
	private String name;
	private String schoolName;
	private String dateEndRegister;
	private String valueMin;
	private String valueMax;

	// ============================================================
	// CONSTRUCTORS
	// ============================================================
	public OverviewScholarshipViewModel() {
	}

	public OverviewScholarshipViewModel(int id, String name, String schoolName,
			String dateEndRegister, String valueMin, String valueMax) {
		this.id = id;
		this.name = name;
		this.schoolName = schoolName;
		this.dateEndRegister = dateEndRegister;
		this.valueMin = valueMin;
		this.valueMax = valueMax;
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

	public String getValueMin() {
		return valueMin;
	}

	public void setValueMin(String value) {
		this.valueMin = value;
	}

	public String getValueMax() {
		return valueMax;
	}

	public void setValueMax(String value) {
		this.valueMax = value;
	}
}
