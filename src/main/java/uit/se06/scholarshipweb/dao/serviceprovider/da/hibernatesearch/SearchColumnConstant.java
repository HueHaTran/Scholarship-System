package uit.se06.scholarshipweb.dao.serviceprovider.da.hibernatesearch;

public class SearchColumnConstant {

	private static SearchColumnConstant INS;

	public static SearchColumnConstant getIns() {
		if (INS == null) {
			INS = new SearchColumnConstant();
		}
		return INS;
	}

	private SearchColumnConstant() {
	}

	public final String DOT = ".";

	// scholarship

	public final String TAG_NAME = "scholarship.scholarshipName";

	// specification

	public final String TAG_DESCRIPTION = "description";
	public final String TAG_LINK = "originalLink";
	public final String TAG_APPLICATION_DESCRIPTION = "applicationDescription";
	public final String TAG_SUPPORT_DESCRIPTION = "supportDescription";
	public final String TAG_GENDER = "studentGender" + DOT + "genderName";
	public final String TAG_CITIZENSHIP = "studentCitizenship" + DOT
			+ "countryName";
	public final String TAG_ETHNIC = "studentEthnic" + DOT + "ethnicName";
	public final String TAG_RELIGION = "studentReligion" + DOT + "religionName";
	public final String TAG_STU_ACA = "studentAcademicLevelDetail" + DOT
			+ "academicLevelDetailName";
	public final String TAG_TYPE = "scholarshipType" + DOT
			+ "scholarshipTypeName";
	public final String TAG_SCHOOL = "school" + DOT + "schoolName";
	public final String TAG_FORM = "formOfParticipation" + DOT
			+ "formOfParticipationName";
	public final String TAG_SCHO_ACA = "scholarshipAcademicLevelDetail" + DOT
			+ "academicLevelDetailName";
	public final String TAG_FAMILY_POLICY = "studentFamilyPolicies" + DOT
			+ "familyPolicyName";
	public final String TAG_DISABILITY = "studentDisabilities" + DOT
			+ "disabilityName";
	public final String TAG_TERMINAL_ILL = "studentTerminalIllnesses" + DOT
			+ "terminalIllName";
	public final String TAG_SPONSOR = "sponsors" + DOT + "sponsorName";
	public final String TAG_MAJOR = "scholarshipMajors" + DOT + "majorName";
	public final String TAG_TALENT = "studentTalents" + DOT + "talentName";
	public final String TAG_RESIDENCE = "studentResidences" + DOT
			+ "provinceName";

	public final String[] allFields = new String[] { TAG_NAME, TAG_DESCRIPTION,
			TAG_LINK, TAG_APPLICATION_DESCRIPTION, TAG_SUPPORT_DESCRIPTION,
			TAG_GENDER, TAG_CITIZENSHIP, TAG_ETHNIC, TAG_RELIGION, TAG_STU_ACA,
			TAG_TYPE, TAG_SCHOOL, TAG_FORM, TAG_SCHO_ACA, TAG_FAMILY_POLICY,
			TAG_DISABILITY, TAG_TERMINAL_ILL, TAG_SPONSOR, TAG_MAJOR,
			TAG_TALENT, TAG_RESIDENCE };
}
