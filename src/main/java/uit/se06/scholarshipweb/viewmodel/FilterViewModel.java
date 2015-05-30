package uit.se06.scholarshipweb.viewmodel;

import java.util.ArrayList;
import java.util.List;

public class FilterViewModel {
	public int stuGender = 0;
	public int stuCitizenship = 0;
	public int stuResidenceCity = 0;
	public int stuResidenceProvince = 0;
	public int stuReligion = 0;
	public List<Integer> stuDisabilities = new ArrayList<Integer>();
	public List<Integer> stuTerminalIllnesses = new ArrayList<Integer>();
	public List<Integer> familyPolicy = new ArrayList<Integer>();

	public int stuAca = 0;
	public int stuAcaDetail = 0;
	public int scholarAca = 0;
	public int scholarAcaDetails = 0;
	public List<Integer> scholarMajors = new ArrayList<Integer>();

	public int scholarType = 0;
	public List<Integer> talents = new ArrayList<Integer>();	
}
