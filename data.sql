INSERT INTO gender(gender_name) VALUES ('Nam');
INSERT INTO gender(gender_name) VALUES ('Nữ');

INSERT INTO religion(religion_name) VALUES ('Phật giáo');
INSERT INTO religion(religion_name) VALUES ('Thiên chúa giáo');

INSERT INTO academic_level(academic_level_name) VALUES ('Tiểu học');
INSERT INTO academic_level(academic_level_name) VALUES ('THCS');
INSERT INTO academic_level(academic_level_name) VALUES ('THPT');
INSERT INTO academic_level(academic_level_name) VALUES ('Trung cấp');
INSERT INTO academic_level(academic_level_name) VALUES ('Cao đẳng');
INSERT INTO academic_level(academic_level_name) VALUES ('Đại học');
INSERT INTO academic_level(academic_level_name) VALUES ('Cao học');
INSERT INTO academic_level(academic_level_name) VALUES ('Tiến sĩ');

INSERT INTO academic_level_detail(academic_level_detail_name,academic_level_id) 
VALUES ('Lớp 1',1);
INSERT INTO academic_level_detail(academic_level_detail_name,academic_level_id) 
VALUES ('Lớp 2',1);
INSERT INTO academic_level_detail(academic_level_detail_name,academic_level_id) 
VALUES ('Lớp 3',1);
INSERT INTO academic_level_detail(academic_level_detail_name,academic_level_id) 
VALUES ('Lớp 4',1);
INSERT INTO academic_level_detail(academic_level_detail_name,academic_level_id) 
VALUES ('Lớp 5',1);

INSERT INTO academic_level_detail(academic_level_detail_name,academic_level_id) 
VALUES ('Lớp 6',2);
INSERT INTO academic_level_detail(academic_level_detail_name,academic_level_id) 
VALUES ('Lớp 7',2);
INSERT INTO academic_level_detail(academic_level_detail_name,academic_level_id) 
VALUES ('Lớp 8',2);
INSERT INTO academic_level_detail(academic_level_detail_name,academic_level_id) 
VALUES ('Lớp 9',2);

INSERT INTO academic_level_detail(academic_level_detail_name,academic_level_id) 
VALUES ('Lớp 10',3);
INSERT INTO academic_level_detail(academic_level_detail_name,academic_level_id) 
VALUES ('Lớp 11',3);
INSERT INTO academic_level_detail(academic_level_detail_name,academic_level_id) 
VALUES ('Lớp 12',3);

INSERT INTO family_policy(family_policy_name) VALUES ('Xóa đói giảm nghèo');

INSERT INTO country(country_name) VALUES ('Việt Nam');
INSERT INTO country(country_name) VALUES ('Thái lan');
INSERT INTO country(country_name) VALUES ('Singapore');
INSERT INTO country(country_name) VALUES ('Malaysia');
INSERT INTO country(country_name) VALUES ('Indonesia');
INSERT INTO country(country_name) VALUES ('Mỹ');
INSERT INTO country(country_name) VALUES ('Anh');

INSERT INTO province(province_name, country_id) VALUES ('Hồ Chí Minh',1);
INSERT INTO province(province_name, country_id) VALUES ('Hà nội',1);
INSERT INTO province(province_name, country_id) VALUES ('Đồng Nai',1);
INSERT INTO province(province_name, country_id) VALUES ('Đà Nẵng',1);

INSERT INTO major(major_name) VALUES ('Công nghệ thông tin');
INSERT INTO major(major_name) VALUES ('Tài chính marketing');

INSERT INTO scholarship_type(scholarship_type_name) VALUES ('Chính phủ');

