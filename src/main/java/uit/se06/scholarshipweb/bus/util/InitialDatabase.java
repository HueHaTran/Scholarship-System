package uit.se06.scholarshipweb.bus.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import uit.se06.scholarshipweb.bus.factory.BUSAbstractFactory;
import uit.se06.scholarshipweb.bus.factory.ICountryBUS;
import uit.se06.scholarshipweb.bus.factory.IDisabilityBUS;
import uit.se06.scholarshipweb.bus.factory.IGenderBUS;
import uit.se06.scholarshipweb.bus.factory.IScholarshipBUS;
import uit.se06.scholarshipweb.model.Country;
import uit.se06.scholarshipweb.model.Disability;
import uit.se06.scholarshipweb.model.Province;
import uit.se06.scholarshipweb.model.Scholarship;
import uit.se06.scholarshipweb.model.ScholarshipSpecification;

public class InitialDatabase {

	IGenderBUS busGender = BUSAbstractFactory.INS.getGenderBUS();
	IScholarshipBUS busScholarship = BUSAbstractFactory.INS.getScholarshipBUS();
	IDisabilityBUS busDisability = BUSAbstractFactory.INS.getDisabilityBUS();
	ICountryBUS busCountry = BUSAbstractFactory.INS.getCountryBUS();

	public void populateData() {
		// Gender gender = new Gender();
		// gender.setName("nam");
		//
		// busGender.insert(gender);
		//
		// gender.setName("nữ");
		// busGender.insert(gender);
		//
		// Disability dis = new Disability();
		// dis.setName("Liệt 1 chân");
		//
		// busDisability.insert(dis);
		//
		// dis.setName("Liệt 2 chân");
		// busDisability.insert(dis);
		//
//		 Country country = new Country();
//		 country.setName("Việt Nam Country test");
		// busCountry.insert(country);

//		Province province = new Province();
//		province.setName("Hồ chí minh");
//		province.setCountry(busCountry.findById(1));
//		busCountry.insertProvince(province);
//		
//		province.setName("Hà nội");
//		busCountry.insertProvince(province);
		
		Scholarship scholarship = new Scholarship();
		ScholarshipSpecification spec = new ScholarshipSpecification();

		scholarship.setName("lalala");
		spec.setStudentGender(busGender.findById(2));
		spec.setStudentCitizenship(busCountry.findById(1));
		spec.setApplicationDescription("ứng viên phải nộp 2 bản sao cmnd, học bạ");
		spec.setApplicationDescription("nó đó lalala Dance");

		Set<Disability> listDis = new HashSet<Disability>(
				Arrays.asList(busDisability.findById(1),busDisability.findById(2)));
		spec.setStudentDisabilities(listDis);

		scholarship.setScholarshipSpecification(spec);

		spec.setScholarship(scholarship);

		busScholarship.insert(scholarship);

	}
}
