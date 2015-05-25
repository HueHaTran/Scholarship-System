package uit.se06.scholarshipweb.bus.util;

import uit.se06.scholarshipweb.bus.factory.BUSAbstractFactory;
import uit.se06.scholarshipweb.bus.factory.IGenderBUS;
import uit.se06.scholarshipweb.model.Gender;

public class InitialDatabase {

	IGenderBUS busGender = BUSAbstractFactory.INS.getGenderBUS();

	public void addEntity() {
		Gender gender = new Gender();
		gender.setName("nam");

		busGender.insert(gender);

		gender.setName("nữ");
		busGender.insert(gender);

	}
}
