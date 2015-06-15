package uit.se06.scholarshipweb.util;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import uit.se06.scholarshipweb.bus.factory.BUSAbstractFactory;
import uit.se06.scholarshipweb.bus.factory.IAcademicLevelBUS;
import uit.se06.scholarshipweb.bus.factory.ICountryBUS;
import uit.se06.scholarshipweb.bus.factory.IDisabilityBUS;
import uit.se06.scholarshipweb.bus.factory.IEthnicBUS;
import uit.se06.scholarshipweb.bus.factory.IFamilyPolicyBUS;
import uit.se06.scholarshipweb.bus.factory.IFormOfParticipationBUS;
import uit.se06.scholarshipweb.bus.factory.IGenderBUS;
import uit.se06.scholarshipweb.bus.factory.IMajorBUS;
import uit.se06.scholarshipweb.bus.factory.IReligionBUS;
import uit.se06.scholarshipweb.bus.factory.IScholarshipBUS;
import uit.se06.scholarshipweb.bus.factory.IScholarshipTypeBUS;
import uit.se06.scholarshipweb.bus.factory.ISchoolBUS;
import uit.se06.scholarshipweb.bus.factory.ISponsorBUS;
import uit.se06.scholarshipweb.bus.factory.ITalentBUS;
import uit.se06.scholarshipweb.bus.factory.ITerminalIllBUS;
import uit.se06.scholarshipweb.bus.serviceprovider.da.DACountryBUS;
import uit.se06.scholarshipweb.model.AcademicLevel;
import uit.se06.scholarshipweb.model.AcademicLevelDetail;
import uit.se06.scholarshipweb.model.Country;
import uit.se06.scholarshipweb.model.Disability;
import uit.se06.scholarshipweb.model.Ethnic;
import uit.se06.scholarshipweb.model.FamilyPolicy;
import uit.se06.scholarshipweb.model.FormOfParticipation;
import uit.se06.scholarshipweb.model.Gender;
import uit.se06.scholarshipweb.model.Major;
import uit.se06.scholarshipweb.model.Province;
import uit.se06.scholarshipweb.model.Religion;
import uit.se06.scholarshipweb.model.Scholarship;
import uit.se06.scholarshipweb.model.ScholarshipSpecification;
import uit.se06.scholarshipweb.model.ScholarshipType;
import uit.se06.scholarshipweb.model.School;
import uit.se06.scholarshipweb.model.Sponsor;
import uit.se06.scholarshipweb.model.Talent;
import uit.se06.scholarshipweb.model.TerminalIll;

public class DataGenerator {

	public static void main() {
		System.out.println("Start generating...");

		BUSAbstractFactory factory = BUSAbstractFactory.INS;
		//
		// addDisability(factory);
		// addGender(factory);
		// addAcademicLevel(factory);
		// addAcademicLevelDetail(factory);
		// addReligion(factory);
		// addCountry(factory);
		// addProvince(factory);
		// addEthnic(factory);
		// addFormOfPart(factory);
		// addScholarType(factory);
		// addMajor(factory);
		// addTalent(factory);
		// addTerminalIll(factory);
		// addFamilyPolicy(factory);
		// addSponsor(factory);
		// addSchool(factory);
		//
		//addScholarship(factory);

		System.out.println("Finish generating!");
	}

	private static void addScholarship(BUSAbstractFactory factory) {
		IScholarshipBUS busScholar = factory.getScholarshipBUS();
		ICountryBUS busCountry = factory.getCountryBUS();
		IAcademicLevelBUS busAca = factory.getAcademicLevelBUS();
		IFamilyPolicyBUS busFam = factory.getFamilyPolicyBUS();
		IEthnicBUS busEthnic = factory.getEthnicBUS();
		ISponsorBUS busSponsor = factory.getSponsorBUS();
		IFormOfParticipationBUS busForm = factory.getFormOfParticipationBUS();
		IMajorBUS busMajor = factory.getMajorBUS();
		ITalentBUS busTalent = factory.getTalentBUS();
		IDisabilityBUS busDis = factory.getDisabilityBUS();
		ITerminalIllBUS busTerminalIll = factory.getTerminalIllBUS();
		ISchoolBUS busSchool = factory.getSchoolBUS();
		IScholarshipTypeBUS busType = factory.getScholarshipTypeBUS();
		IGenderBUS busGender = factory.getGenderBUS();
		IReligionBUS busReligion = factory.getReligionBUS();

		for (int i = 50; i < 50; i++) {
			Scholarship s = new Scholarship();
			ScholarshipSpecification spec = new ScholarshipSpecification();

			s.setName("Học bổng " + i);

			s.setDateEndRegister(getRandomDate());
			s.setValueMax(getRandom(2000000, 5000000));
			s.setValueMin(getRandom(6000000, 7000000));

			if (random()) {
				spec.setApplicationDescription(getRandomApplicationDescription());
			}
			if (random()) {
				spec.setCount(getRandom(1, 10));
			}
			if (random()) {
				spec.setDescription(getRandomDescription());
			}
			if (random()) {
				spec.setFormOfParticipation(busForm.findById(getRandom(1, 3)));
			}
			if (random()) {
				spec.setOriginal_link("www.google.com");
			}

			if (random()) {
				Set<AcademicLevelDetail> set = new HashSet<AcademicLevelDetail>();
				int randomStart = getRandom(1, 3);
				int randomLen = getRandom(1, 5);
				for (int i1 = randomStart; i1 < randomLen; i1++) {
					set.add(busAca.findAcademicLevelDetailById(i1));
				}
				spec.setScholarshipAcademicLevelDetail(set);
			}

			if (random()) {
				Set<Major> set = new HashSet<Major>();
				int randomStart = getRandom(1, 3);
				int randomLen = getRandom(1, 5);
				for (int i1 = randomStart; i1 < randomLen; i1++) {
					set.add(busMajor.findById(i1));
				}
				spec.setScholarshipMajors(set);
			}
			if (random()) {
				spec.setScholarshipType(busType.findById(1));
			}
			if (random()) {
				spec.setSchool(busSchool.findById(getRandom(1, 6)));
			}
			if (random()) {
				Set<Sponsor> set = new HashSet<Sponsor>();
				set.add(busSponsor.findById(1));
				spec.setSponsors(set);
			}
			if (random()) {
				spec.setStudentAcademicLevelDetail(busAca
						.findAcademicLevelDetailById(getRandom(1, 5)));
			}
			if (random()) {
				spec.setStudentCitizenship(busCountry.findById(getRandom(1, 5)));
			}
			if (random()) {
				spec.setStudentGender(busGender.findById(getRandom(1, 3)));
			}
			if (random()) {
				Set<Disability> set = new HashSet<Disability>();
				int randomStart = getRandom(1, 2);
				int randomLen = getRandom(1, 2);
				for (int i1 = randomStart; i1 < randomLen; i1++) {
					set.add(busDis.findById(i1));
				}
				spec.setStudentDisabilities(set);
			}
			if (random()) {
				spec.setStudentEthnic(busEthnic.findById(getRandom(1, 4)));
			}
			if (random()) {
				spec.setStudentReligion(busReligion.findById(getRandom(1, 3)));
			}
			if (random()) {
				Set<Province> set = new HashSet<Province>();
				int randomStart = getRandom(1, 3);
				int randomLen = getRandom(1, 5);
				for (int i1 = randomStart; i1 < randomLen; i1++) {
					set.add(busCountry.findProvinceById(i1));
				}
				spec.setStudentResidences(set);
			}
			if (random()) {
				Set<FamilyPolicy> set = new HashSet<FamilyPolicy>();
				int randomStart = getRandom(1, 1);
				int randomLen = getRandom(1, 2);
				for (int i1 = randomStart; i1 < randomLen; i1++) {
					set.add(busFam.findById(i1));
				}
				spec.setStudentFamilyPolicies(set);
			}
			if (random()) {
				Set<Talent> set = new HashSet<Talent>();
				int randomStart = getRandom(1, 1);
				int randomLen = getRandom(1, 2);
				for (int i1 = randomStart; i1 < randomLen; i1++) {
					set.add(busTalent.findById(i1));
				}
				spec.setStudentTalents(set);
			}
			if (random()) {
				Set<TerminalIll> set = new HashSet<TerminalIll>();
				set.add(busTerminalIll.findById(1));
				spec.setStudentTerminalIllnesses(set);
			}
			if (random()) {
				spec.setSupportDescription(getRandomSupportDescription());
			}
			s.setScholarshipSpecification(spec);
			spec.setScholarship(s);

			busScholar.insert(s);
		}

	}

	private static Date getRandomDate() {
		int randYear = getRandom(2013 - 1900, 2020 - 1900);
		int randMonth = getRandom(0, 11);
		int randDay = getRandom(1, 28);

		return new Date(randYear, randMonth, randDay);
	}

	private static String getRandomApplicationDescription() {
		StringBuilder sb = new StringBuilder();
		sb.append("Ứng viên gửi hồ sơ bao gồm:");
		if (random()) {
			sb.append("\n- Giới thiệu bản thân.");
		}
		if (random()) {
			sb.append("\n- Trình bày nguyện vọng và lý do để được chọn nhận học bổng.");
		}
		if (random()) {
			sb.append("\n- 3 tấm ảnh 3x4.");
		}
		if (random()) {
			sb.append("\n- Photocopy các giấy chứng nhận liên quan.");
		}
		return sb.toString();
	}

	private static String getRandomDescription() {
		int rand = getRandom(0, 5);
		if (rand == 0) {
			return "Chương trình đào tạo lớn nhất quốc gia, được các chuyên gia đánh giá cao.";
		} else if (rand == 1) {
			return "Hỗ trợ kinh tế lớn dành cho các ứng viên hiếu học";
		} else if (rand == 2) {
			return "Học bổng toàn phần lớn nhất trong năm.";
		} else if (rand == 3) {
			return "Hỗ trợ kinh tế lớn dành cho các ứng viên hiếu học";
		} else if (rand == 4) {
			return "Học bổng thu hút nhiều nhà tài trợ lớn.";
		} else {
			return "Học bổng chắp cánh ước mơ";
		}
	}

	private static String getRandomSupportDescription() {
		StringBuilder sb = new StringBuilder();
		sb.append("Vui lòng liên hệ để biết thêm chi tiết:");
		int rand = getRandom(0, 5);
		if (rand == 0) {
			sb.append("\n- SĐT (Ms Nhàn): 0123 221 6482");
		} else if (rand == 1) {
			sb.append("\n- SĐT (Ms Hiền): 091 326 6536");
		} else if (rand == 2) {
			sb.append("\n- SĐT (Mr Minh): 0122 531 9485");
		} else if (rand == 3) {
			sb.append("\n- SĐT (Mr Hiếu): 0122 221 3280");
		} else if (rand == 4) {
			sb.append("\n- SĐT (Ms Ngọc): 0122 4232 2483");
		} else {
			sb.append("\n- SĐT (Ms Bích): 091 623 143t");
		}
		return sb.toString();
	}

	private static void addSchool(BUSAbstractFactory factory) {
		ISchoolBUS bus = factory.getSchoolBUS();
		ICountryBUS busCountry = factory.getCountryBUS();

		String[] array = new String[] { "National University of Singapore (NUS)" };

		for (int i = 0; i < array.length; i++) {
			School e = new School();
			e.setName(array[i]);
			e.setProvince(busCountry.findProvinceById(19));
			bus.insert(e);
		}

		array = new String[] { "Đại học công nghệ thông tin",
				"Đại học khoa học tự nhiên", "Đại học Y Phạm Ngọc Thạch",
				"Đại học Y Dược", "Đại học Kinh tế" };

		for (int i = 0; i < array.length; i++) {
			School e = new School();
			e.setName(array[i]);
			e.setProvince(busCountry.findProvinceById(1));
			bus.insert(e);
		}
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

	private static void addDisability(BUSAbstractFactory factory) {
		IDisabilityBUS bus = factory.getDisabilityBUS();

		String[] array = new String[] { "1 chân", "2 chân", "1 tay", "2 tay" };

		for (int i = 0; i < array.length; i++) {
			Disability e = new Disability();
			e.setName(array[i]);
			bus.insert(e);
		}
	}

	private static void addAcademicLevel(BUSAbstractFactory factory) {
		IAcademicLevelBUS bus = factory.getAcademicLevelBUS();

		String[] array = new String[] { "Tiểu học", "Trung học cơ sở",
				"Trung học phổ thông", "Trung tâm giáo dục thường xuyên",
				"Trường giáo dưỡng", "Dự bị đại học", "Trung cấp, dạy nghề",
				"Cao đẳng", "Đại học", "Cao học", "Nghiên cứu sinh" };

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

		array = new String[] { "Trung tâm giáo dục thường xuyên" };
		for (int i = 0; i < array.length; i++) {
			AcademicLevelDetail e = new AcademicLevelDetail();
			e.setName(array[i]);
			e.setAcademicLevel(bus.findById(4));
			bus.insertAcademicLevelDetail(e);
		}

		array = new String[] { "Trường giáo dưỡng" };
		for (int i = 0; i < array.length; i++) {
			AcademicLevelDetail e = new AcademicLevelDetail();
			e.setName(array[i]);
			e.setAcademicLevel(bus.findById(5));
			bus.insertAcademicLevelDetail(e);
		}

		array = new String[] { "Năm 1" };
		for (int i = 0; i < array.length; i++) {
			AcademicLevelDetail e = new AcademicLevelDetail();
			e.setName(array[i]);
			e.setAcademicLevel(bus.findById(6));
			bus.insertAcademicLevelDetail(e);
		}

		array = new String[] { "Năm 1", "Năm 2" };// day nghe
		for (int i = 0; i < array.length; i++) {
			AcademicLevelDetail e = new AcademicLevelDetail();
			e.setName(array[i]);
			e.setAcademicLevel(bus.findById(7));
			bus.insertAcademicLevelDetail(e);
		}

		array = new String[] { "Năm 1", "Năm 2", "Năm 3" };
		for (int i = 0; i < array.length; i++) {
			AcademicLevelDetail e = new AcademicLevelDetail();
			e.setName(array[i]);
			e.setAcademicLevel(bus.findById(8));
			bus.insertAcademicLevelDetail(e);
		}

		array = new String[] { "Năm 1", "Năm 2", "Năm 3", "Năm 4", "Năm 5",
				"Năm 6" };
		for (int i = 0; i < array.length; i++) {
			AcademicLevelDetail e = new AcademicLevelDetail();
			e.setName(array[i]);
			e.setAcademicLevel(bus.findById(9));
			bus.insertAcademicLevelDetail(e);
		}

		array = new String[] { "Năm 1", "Năm 2", "Năm 3" };
		for (int i = 0; i < array.length; i++) {
			AcademicLevelDetail e = new AcademicLevelDetail();
			e.setName(array[i]);
			e.setAcademicLevel(bus.findById(10));
			bus.insertAcademicLevelDetail(e);
		}

		array = new String[] { "Năm 1" };
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

		String[] array = new String[] { "Singapore" };

		for (int i = 0; i < array.length; i++) {
			Province e = new Province();
			e.setName(array[i]);
			e.setCountry(bus.findById(5));
			bus.insertProvince(e);
		}

		array = new String[] { "Hồ Chí Minh", "Đà Nẵng", "Hà Nội", "Vũng Tàu",
				"Đà Lạt", "Nha Trang", "Cà Mau" };

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

	private static void addMajor(BUSAbstractFactory factory) {
		IMajorBUS bus = factory.getMajorBUS();
		String[] array = new String[] { "Kinh tế", "Quản trị kinh doanh",
				"Marketing", "Quản trị kinh doanh du lịch và lữ hành",
				"Kế toán", "Tài chính ngân hàng", "Luật kinh tế",
				"Kỹ thuật cơ khí", "Kỹ thuật cơ - Điện tử",
				"Kỹ thuật điện - điện tử",
				"Kỹ thuật điều khiển và tự động hóa",
				"Kỹ thuật điện tử truyền thông", "Kỹ thuật máy tính",
				"Kỹ thuật môi trường", "Sư phạm kỹ thuật công nghiệp",
				"Kỹ thuật công trình xây dựng", "Quản lý công nghiệp",
				"Kinh tế công nghiệp", "Sư phạm", "Y đa khoa", "Điều dưỡng",
				"Dược học", "Y dược dự phòng", "Răng Hàm Mặt", "Toán học",
				"Toán học ứng dụng", "Công nghệ sinh học",
				"Khoa học môi trường", "Quản lý tài nguyên và môi trường",
				"Báo chí - truyền thông", "Công tác xã hội", "Luật",
				"Công nghệ thông tin", "Hệ thống thông tin",
				"Kỹ thuật phần phềm", "Khoa học máy tính",
				"Công nghệ kỹ thuật điện tử - truyền thông",
				"Mạng máy tính và truyền thông", "Truyền thông đa phương tiện",
				"Quản trí văn phòng", "Kinh doanh quốc tế", "Nông nghiệp",
				"Công nghệ dệt may", "Kỹ thuật mỏ", "Công nghệ thực phẩm" };

		for (int i = 0; i < array.length; i++) {
			Major e = new Major();
			e.setName(array[i]);
			bus.insert(e);
		}
	}

	private static void addTalent(BUSAbstractFactory factory) {
		ITalentBUS bus = factory.getTalentBUS();
		String[] array = new String[] { "Ca hát", "Hội họa", "Thể thao" };

		for (int i = 0; i < array.length; i++) {
			Talent e = new Talent();
			e.setName(array[i]);
			bus.insert(e);
		}
	}

	private static void addFamilyPolicy(BUSAbstractFactory factory) {
		IFamilyPolicyBUS bus = factory.getFamilyPolicyBUS();

		String[] array = new String[] { "Xóa đói giảm nghèo",
				"Có công với cách mạng" };

		for (int i = 0; i < array.length; i++) {
			FamilyPolicy e = new FamilyPolicy();
			e.setName(array[i]);
			bus.insert(e);
		}
	}

	private static void addTerminalIll(BUSAbstractFactory factory) {
		ITerminalIllBUS bus = factory.getTerminalIllBUS();

		String[] array = new String[] { "Ung thư" };

		for (int i = 0; i < array.length; i++) {
			TerminalIll e = new TerminalIll();
			e.setName(array[i]);
			bus.insert(e);
		}
	}

	private static void addSponsor(BUSAbstractFactory factory) {
		ISponsorBUS bus = factory.getSponsorBUS();
		ICountryBUS busCountry = new DACountryBUS();

		String[] array = new String[] { "Uniliver" };

		for (int i = 0; i < array.length; i++) {
			Sponsor e = new Sponsor();
			e.setName(array[i]);
			e.setProvince(busCountry.listProvinceByCountry(1).get(0));
			bus.insert(e);
		}
	}

	private static boolean random() {
		int rand = getRandom(0, 1);
		if (rand == 0) {
			return true;
		} else {
			return false;
		}
	}

	private static int getRandom(int min, int max) {
		return (int) (java.lang.Math.random() * (max - min + 1) + min);
	}

}
