package uit.se06.scholarshipweb.util;

import javax.management.relation.Relation;

import uit.se06.scholarshipweb.bus.factory.BUSAbstractFactory;
import uit.se06.scholarshipweb.bus.factory.IAcademicLevelBUS;
import uit.se06.scholarshipweb.bus.factory.ICountryBUS;
import uit.se06.scholarshipweb.bus.factory.IEthnicBUS;
import uit.se06.scholarshipweb.bus.factory.IFormOfParticipationBUS;
import uit.se06.scholarshipweb.bus.factory.IGenderBUS;
import uit.se06.scholarshipweb.bus.factory.IReligionBUS;
import uit.se06.scholarshipweb.bus.factory.IScholarshipTypeBUS;
import uit.se06.scholarshipweb.model.AcademicLevel;
import uit.se06.scholarshipweb.model.AcademicLevelDetail;
import uit.se06.scholarshipweb.model.Country;
import uit.se06.scholarshipweb.model.Ethnic;
import uit.se06.scholarshipweb.model.FormOfParticipation;
import uit.se06.scholarshipweb.model.Gender;
import uit.se06.scholarshipweb.model.Province;
import uit.se06.scholarshipweb.model.Religion;
import uit.se06.scholarshipweb.model.ScholarshipType;

public class DataGenerator {

	public static void main(String[] args) {
		BUSAbstractFactory factory = BUSAbstractFactory.INS;

		addGender(factory);
		addAcademicLevel(factory);
		addAcademicLevelDetail(factory);
		addReligion(factory);
		addCountry(factory);
		addProvince(factory);
		addEthnic(factory);
		addFormOfPart(factory);
		addScholarType(factory);
	}

	private static void addGender(BUSAbstractFactory factory) {
		IGenderBUS bus = factory.getGenderBUS();

		String[] array = new String[] { "nam", "nữ", "khác" };

		for (int i = 0; i < array.length; i++) {
			Gender e = new Gender();
			e.setName(array[i]);
			bus.insert(e);
		}
	}

	private static void addAcademicLevel(BUSAbstractFactory factory) {
		IAcademicLevelBUS bus = factory.getAcademicLevelBUS();

		String[] array = new String[] { "tiểu học", "trung học cơ sở",
				"trung học phổ thông", "trung tâm giáo dục thường xuyên",
				"trường giáo dưỡng", "dự bị đại học", "trung cấp, dạy nghề",
				"cao đẳng", "đại học", "cao học", "nghiên cứu sinh" };

		for (int i = 0; i < array.length; i++) {
			AcademicLevel e = new AcademicLevel();
			e.setName(array[i]);
			bus.insert(e);
		}
	}

	private static void addAcademicLevelDetail(BUSAbstractFactory factory) {
		IAcademicLevelBUS bus = factory.getAcademicLevelBUS();

		String[] array = new String[] { "Lớp 1", "Lớp 2", "Lớp 3", "Lớp 4",
				"Lớp 5" };
		for (int i = 0; i < array.length; i++) {
			AcademicLevelDetail e = new AcademicLevelDetail();
			e.setName(array[i]);
			e.setAcademicLevel(bus.findById(1));
			bus.insertAcademicLevelDetail(e);
		}

		array = new String[] { "Lớp 6", "Lớp 7", "Lớp 8", "Lớp 9" };
		for (int i = 0; i < array.length; i++) {
			AcademicLevelDetail e = new AcademicLevelDetail();
			e.setName(array[i]);
			e.setAcademicLevel(bus.findById(2));
			bus.insertAcademicLevelDetail(e);
		}

		array = new String[] { "Lớp 10", "Lớp 11", "Lớp 12" };
		for (int i = 0; i < array.length; i++) {
			AcademicLevelDetail e = new AcademicLevelDetail();
			e.setName(array[i]);
			e.setAcademicLevel(bus.findById(3));
			bus.insertAcademicLevelDetail(e);
		}

		array = new String[] { "trung tâm giáo dục thường xuyên" };
		for (int i = 0; i < array.length; i++) {
			AcademicLevelDetail e = new AcademicLevelDetail();
			e.setName(array[i]);
			e.setAcademicLevel(bus.findById(4));
			bus.insertAcademicLevelDetail(e);
		}

		array = new String[] { "trường giáo dưỡng" };
		for (int i = 0; i < array.length; i++) {
			AcademicLevelDetail e = new AcademicLevelDetail();
			e.setName(array[i]);
			e.setAcademicLevel(bus.findById(5));
			bus.insertAcademicLevelDetail(e);
		}

		array = new String[] { "năm 1" };
		for (int i = 0; i < array.length; i++) {
			AcademicLevelDetail e = new AcademicLevelDetail();
			e.setName(array[i]);
			e.setAcademicLevel(bus.findById(6));
			bus.insertAcademicLevelDetail(e);
		}

		array = new String[] { "năm 1", "năm 2" };// day nghe
		for (int i = 0; i < array.length; i++) {
			AcademicLevelDetail e = new AcademicLevelDetail();
			e.setName(array[i]);
			e.setAcademicLevel(bus.findById(7));
			bus.insertAcademicLevelDetail(e);
		}

		array = new String[] { "năm 1", "năm 2", "năm 3" };
		for (int i = 0; i < array.length; i++) {
			AcademicLevelDetail e = new AcademicLevelDetail();
			e.setName(array[i]);
			e.setAcademicLevel(bus.findById(8));
			bus.insertAcademicLevelDetail(e);
		}

		array = new String[] { "năm 1", "năm 2", "năm 3", "năm 4", "năm 5",
				"năm 6" };
		for (int i = 0; i < array.length; i++) {
			AcademicLevelDetail e = new AcademicLevelDetail();
			e.setName(array[i]);
			e.setAcademicLevel(bus.findById(9));
			bus.insertAcademicLevelDetail(e);
		}

		array = new String[] { "năm 1", "năm 2", "năm 3" };
		for (int i = 0; i < array.length; i++) {
			AcademicLevelDetail e = new AcademicLevelDetail();
			e.setName(array[i]);
			e.setAcademicLevel(bus.findById(10));
			bus.insertAcademicLevelDetail(e);
		}

		array = new String[] { "năm 1" };
		for (int i = 0; i < array.length; i++) {
			AcademicLevelDetail e = new AcademicLevelDetail();
			e.setName(array[i]);
			e.setAcademicLevel(bus.findById(11));
			bus.insertAcademicLevelDetail(e);
		}
	}

	private static void addReligion(BUSAbstractFactory factory) {
		IReligionBUS bus = factory.getReligionBUS();

		String[] array = new String[] { "Phật giáo", "Thiên chúa giáo",
				"Hồi giáo" };

		for (int i = 0; i < array.length; i++) {
			Religion e = new Religion();
			e.setName(array[i]);
			bus.insert(e);
		}
	}

	private static void addCountry(BUSAbstractFactory factory) {
		ICountryBUS bus = factory.getCountryBUS();

		String[] array = new String[] { "Việt Nam", "Mỹ", "Pháp", "Malaysia",
				"Singapore", "Hongkong", "Đài Loan", "Trung Quốc",
				"Tây Ban Nha", "Đức", "Ấn Độ", "Ý", "Úc", "Bồ Đào Nha" };

		for (int i = 0; i < array.length; i++) {
			Country e = new Country();
			e.setName(array[i]);
			bus.insert(e);
		}
	}

	private static void addProvince(BUSAbstractFactory factory) {
		ICountryBUS bus = factory.getCountryBUS();

		String[] array = new String[] { "Hồ Chí Minh", "Đà Nẵng", "Hà Nội",
				"Vũng Tàu", "Đà Lạt", "Nha Trang", "Cà Mau" };

		for (int i = 0; i < array.length; i++) {
			Province e = new Province();
			e.setName(array[i]);
			e.setCountry(bus.findById(1));
			bus.insertProvince(e);
		}

		array = new String[] { "Alabama", "Alaska", "Arizona", "Arkansas",
				"California", "Colorado", "Connecticut", "Delaware", "Florida",
				"Georgia", "Hawaii" };

		for (int i = 0; i < array.length; i++) {
			Province e = new Province();
			e.setName(array[i]);
			e.setCountry(bus.findById(2));
			bus.insertProvince(e);
		}
	}

	private static void addEthnic(BUSAbstractFactory factory) {
		IEthnicBUS bus = factory.getEthnicBUS();

		String[] array = new String[] { "Kinh", "Hoa", "Nùng", "Khơ Mú" };

		for (int i = 0; i < array.length; i++) {
			Ethnic e = new Ethnic();
			e.setName(array[i]);
			bus.insert(e);
		}
	}

	private static void addFormOfPart(BUSAbstractFactory factory) {
		IFormOfParticipationBUS bus = factory.getFormOfParticipationBUS();

		String[] array = new String[] { "xét tuyển", "thi tuyển", "phỏng vấn" };

		for (int i = 0; i < array.length; i++) {
			FormOfParticipation e = new FormOfParticipation();
			e.setName(array[i]);
			bus.insert(e);
		}
	}

	private static void addScholarType(BUSAbstractFactory factory) {
		IScholarshipTypeBUS bus = factory.getScholarshipTypeBUS();

		String[] array = new String[] { "chính phủ" };

		for (int i = 0; i < array.length; i++) {
			ScholarshipType e = new ScholarshipType();
			e.setName(array[i]);
			bus.insert(e);
		}
	}

}
