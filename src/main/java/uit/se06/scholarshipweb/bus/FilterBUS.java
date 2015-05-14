package uit.se06.scholarshipweb.bus;

import java.util.ArrayList;

import org.hibernate.SessionFactory;

import uit.se06.scholarshipweb.model.Province;
import uit.se06.scholarshipweb.viewmodel.FilterPersonalInfo;

public class FilterBUS {

	private GenderBUS busGender;
	private DisabilityBUS busDisability;
	private TerminalIllBUS busTerminalIll;
	private FamilyPolicyBUS busFamilyPolicy;
	private CountryBUS busCountry;
	private ReligionBUS busReligion;

	public FilterBUS(SessionFactory sessionFactory) {
		busGender = new GenderBUS(sessionFactory);
		busDisability = new DisabilityBUS(sessionFactory);
		busTerminalIll = new TerminalIllBUS(sessionFactory);
		busFamilyPolicy = new FamilyPolicyBUS(sessionFactory);
		busCountry = new CountryBUS(sessionFactory);
		busReligion = new ReligionBUS(sessionFactory);
	}

	/**
	 * 
	 * @return
	 */
	public FilterPersonalInfo getPersonalInfo() {
		FilterPersonalInfo result = new FilterPersonalInfo();

		result.setCountries(busCountry.list());
		result.setDisabilities(busDisability.list());
		result.setFamilyPolicies(busFamilyPolicy.list());
		result.setGenders(busGender.list());
		result.setReligion(busReligion.list());
		result.setProvinces(new ArrayList<Province>());
		result.setTerminalIllnesses(busTerminalIll.list());
		
		return result;
	}

}
