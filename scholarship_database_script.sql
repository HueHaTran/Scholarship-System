CREATE DATABASE ScholarshipDatabase;

USE `ScholarshipDatabase`;

CREATE TABLE `disability`
(
	`disability_id` INT(11) NOT NULL AUTO_INCREMENT,
    `disability_name` NVARCHAR(30) NOT NULL UNIQUE,

    PRIMARY KEY (`disability_id`)
);

CREATE TABLE `terminal_ill`
(
	`terminal_ill_id` INT(11) NOT NULL AUTO_INCREMENT,
    `terminal_ill_name` NVARCHAR(30) NOT NULL UNIQUE,

    PRIMARY KEY (`terminal_ill_id`)
);

CREATE TABLE `academic_level`
(
	`academic_level_id` INT(11) NOT NULL AUTO_INCREMENT,
    `academic_level_name` NVARCHAR(30) NOT NULL UNIQUE,

    PRIMARY KEY (`academic_level_id`)
);

CREATE TABLE `academic_level_detail`
(
	`academic_level_detail_id` INT(11) NOT NULL AUTO_INCREMENT,
    `academic_level_detail_name` NVARCHAR(30) NOT NULL UNIQUE,
    `academic_level_id` INT(11) NOT NULL,

    PRIMARY KEY (`academic_level_detail_id`),
	INDEX (`academic_level_id`),
	FOREIGN KEY (`academic_level_id`) REFERENCES `academic_level`(`academic_level_id`)
);

CREATE TABLE `family_policy`
(
	`family_policy_id` INT(11) NOT NULL AUTO_INCREMENT,
    `family_policy_name` NVARCHAR(30) NOT NULL UNIQUE,

    PRIMARY KEY (`family_policy_id`)
);

CREATE TABLE `form_of_participation`
(
	`form_of_participation_id` INT(11) NOT NULL AUTO_INCREMENT,
    `form_of_participation_name` NVARCHAR(30) NOT NULL UNIQUE,

    PRIMARY KEY (`form_of_participation_id`)
);

CREATE TABLE `major`
(
	`major_id` INT(11) NOT NULL AUTO_INCREMENT,
    `major_name` NVARCHAR(30) NOT NULL UNIQUE,

    PRIMARY KEY (`major_id`)
);

CREATE TABLE `scholarship_type`
(
	`scholarship_type_id` INT(11) NOT NULL AUTO_INCREMENT,
    `scholarship_type_name` NVARCHAR(30) NOT NULL UNIQUE,

    PRIMARY KEY (`scholarship_type_id`)
);

CREATE TABLE `religion`
(
	`religion_id` INT(11) NOT NULL AUTO_INCREMENT,
    `religion_name` NVARCHAR(30) NOT NULL UNIQUE,

    PRIMARY KEY (`religion_id`)
);

CREATE TABLE `ethnic`
(
	`ethnic_id` INT(11) NOT NULL AUTO_INCREMENT,
    `ethnic_name` NVARCHAR(30) NOT NULL UNIQUE,

    PRIMARY KEY (`ethnic_id`)
);

CREATE TABLE `country`
(
	`country_id` INT(11) NOT NULL AUTO_INCREMENT,
    `country_name` NVARCHAR(30) NOT NULL UNIQUE,

    PRIMARY KEY (`country_id`)
);

CREATE TABLE `province`
(
	`province_id` INT(11) NOT NULL AUTO_INCREMENT,
    `province_name` NVARCHAR(30) NOT NULL UNIQUE,
	`country_id` INT NOT NULL,

    PRIMARY KEY (`province_id`),
    INDEX (`country_id`),
    FOREIGN KEY (`country_id`) REFERENCES `country`(`country_id`)
);

CREATE TABLE `school`
(
	`school_id` INT(11) NOT NULL AUTO_INCREMENT,
    `school_name` NVARCHAR(30) NOT NULL UNIQUE,
	`province_id` INT DEFAULT NULL,
    `address` NVARCHAR(255) DEFAULT NULL,
    `phone` VARCHAR(64) DEFAULT NULL,
    `website` VARCHAR(64) DEFAULT NULL,
    `fax` VARCHAR(64) DEFAULT NULL,

    PRIMARY KEY (`school_id`),
    INDEX (`province_id`),
    FOREIGN KEY (`province_id`) REFERENCES `province`(`province_id`)
);

CREATE TABLE `sponsor`
(
	`sponsor_id` INT(11) NOT NULL AUTO_INCREMENT,
    `sponsor_name` NVARCHAR(30) NOT NULL UNIQUE,
	`province_id` INT DEFAULT NULL,
    `address` NVARCHAR(255) DEFAULT NULL,
    `phone` VARCHAR(64) DEFAULT NULL,
    `website` VARCHAR(64) DEFAULT NULL,
    `fax` VARCHAR(64) DEFAULT NULL,

    PRIMARY KEY (`sponsor_id`),
    INDEX (`province_id`),
    FOREIGN KEY (`province_id`) REFERENCES `province`(`province_id`)
);

CREATE TABLE `gender`
(
	`gender_id` INT(11) NOT NULL AUTO_INCREMENT,
    `gender_name` NVARCHAR(30) NOT NULL UNIQUE,

    PRIMARY KEY (`gender_id`)
);

CREATE TABLE `talent`
(
	`talent_id` INT(11) NOT NULL AUTO_INCREMENT,
    `talent_name` NVARCHAR(30) NOT NULL UNIQUE,

    PRIMARY KEY (`talent_id`)
);

CREATE TABLE `scholarship`
(
	`scholarship_id` INT(11) NOT NULL AUTO_INCREMENT,
    `scholarship_name` NVARCHAR(64) NOT NULL,
     `date_end_register` DATE,
	`value_min` INT(11)default -1,
    `value_max` INT(11)default -1,
    
    PRIMARY KEY (`scholarship_id`)
);

CREATE TABLE `scholarship_specification`
(
	`scholarship_id` INT(11) NOT NULL,
    `description` NVARCHAR(512) DEFAULT '',
    `original_link` VARCHAR(256) DEFAULT '',
    `count` INT(6) default -1,
	`student_gender_id` INT(11) DEFAULT NULL,
    `student_citizenship_id` INT(11) DEFAULT NULL,
    `student_ethnic_id` INT(11) DEFAULT NULL, 
    `student_religion_id` INT(11) DEFAULT NULL,
    `student_academic_level_detail_id` INT(11) DEFAULT NULL,
    `scholarship_type_id` INT(11) DEFAULT NULL,
    `school_id` INT(11) DEFAULT NULL,
    `form_of_participation_id` INT(11) DEFAULT NULL,
    `application_description` NVARCHAR(1024) DEFAULT "",
	`support_description` NVARCHAR(1024) DEFAULT "",
    
    PRIMARY KEY (`scholarship_id`),
    INDEX (`student_gender_id`),
    INDEX (`student_citizenship_id`),
    INDEX (`student_ethnic_id`), 
    INDEX (`student_religion_id`),
    INDEX (`student_academic_level_detail_id`),
    INDEX (`school_id`),
    FOREIGN KEY (`scholarship_id`) REFERENCES `scholarship`(`scholarship_id`),
    FOREIGN KEY (`student_gender_id`) REFERENCES `gender`(`gender_id`),
    FOREIGN KEY (`student_citizenship_id`) REFERENCES `country`(`country_id`), 
    FOREIGN KEY (`student_ethnic_id`) REFERENCES `ethnic`(`ethnic_id`),
    FOREIGN KEY (`student_religion_id`) REFERENCES `religion`(`religion_id`),
    FOREIGN KEY (`student_academic_level_detail_id`) REFERENCES `academic_level_detail`(`academic_level_detail_id`),
    FOREIGN KEY (`scholarship_type_id`) REFERENCES `scholarship_type`(`scholarship_type_id`),
    FOREIGN KEY (`school_id`) REFERENCES `school`(`school_id`), 
	FOREIGN KEY (`form_of_participation_id`) REFERENCES `form_of_participation`(`form_of_participation_id`)
);



CREATE TABLE `scholarship_academic_level_detail`
(
	`scholarship_id` INT(11) NOT NULL,
    `academic_level_detail_id` INT(11) NOT NULL,

	PRIMARY KEY (`scholarship_id`, `academic_level_detail_id`),
    INDEX (`scholarship_id`),
    INDEX (`academic_level_detail_id`),
    FOREIGN KEY (`scholarship_id`) REFERENCES `scholarship_specification`(`scholarship_id`),
    FOREIGN KEY (`academic_level_detail_id`) REFERENCES `academic_level_detail`(`academic_level_detail_id`)
);

CREATE TABLE `scholarship_family_policy`
(
	`scholarship_id` INT(11) NOT NULL,
    `family_policy_id` INT(11) NOT NULL,
    
    PRIMARY KEY (`scholarship_id`, `family_policy_id`),
    INDEX(`scholarship_id`),
    INDEX (`family_policy_id`),
    FOREIGN KEY (`scholarship_id`) REFERENCES `scholarship_specification`(`scholarship_id`),
	FOREIGN KEY (`family_policy_id`) REFERENCES `family_policy`(`family_policy_id`)
);

CREATE TABLE `scholarship_disability`
(
	`scholarship_id` INT(11) NOT NULL,
    `disability_id` INT(11) NOT NULL,
    
    PRIMARY KEY (`scholarship_id`, `disability_id`),
    INDEX(`scholarship_id`),
    INDEX (`disability_id`),
    FOREIGN KEY (`scholarship_id`) REFERENCES `scholarship_specification`(`scholarship_id`),
	FOREIGN KEY (`disability_id`) REFERENCES `disability`(`disability_id`)
);

CREATE TABLE `scholarship_terminal_ill`
(
	`scholarship_id` INT(11) NOT NULL,
    `terminal_ill_id` INT(11) NOT NULL,
    
    PRIMARY KEY (`scholarship_id`, `terminal_ill_id`),
    INDEX(`scholarship_id`),
    INDEX (`terminal_ill_id`),
    FOREIGN KEY (`scholarship_id`) REFERENCES `scholarship_specification`(`scholarship_id`),
	FOREIGN KEY (`terminal_ill_id`) REFERENCES `terminal_ill`(`terminal_ill_id`)
);

CREATE TABLE `scholarship_sponsor`
(
	`scholarship_id` INT(11) NOT NULL,
    `sponsor_id` INT(11) NOT NULL,
    
    PRIMARY KEY (`scholarship_id`, `sponsor_id`),
    INDEX(`scholarship_id`),
    INDEX (`sponsor_id`),
    FOREIGN KEY (`scholarship_id`) REFERENCES `scholarship_specification`(`scholarship_id`),
	FOREIGN KEY (`sponsor_id`) REFERENCES `sponsor`(`sponsor_id`)
);

CREATE TABLE `scholarship_major`
(
	`scholarship_id` INT(11) NOT NULL,
    `major_id` INT(11) NOT NULL,
    
    PRIMARY KEY (`scholarship_id`, `major_id`),
    INDEX(`scholarship_id`),
    INDEX (`major_id`),
    FOREIGN KEY (`scholarship_id`) REFERENCES `scholarship_specification`(`scholarship_id`),
	FOREIGN KEY (`major_id`) REFERENCES `major`(`major_id`)
);

CREATE TABLE `scholarship_talent`
(
	`scholarship_id` INT(11) NOT NULL,
    `talent_id` INT(11) NOT NULL,
    
    PRIMARY KEY (`scholarship_id`, `talent_id`),
    INDEX(`scholarship_id`),
    INDEX (`talent_id`),
    FOREIGN KEY (`scholarship_id`) REFERENCES `scholarship_specification`(`scholarship_id`),
	FOREIGN KEY (`talent_id`) REFERENCES `talent`(`talent_id`)
);

CREATE TABLE `scholarship_student_residence`
(
    `scholarship_id` INT(11) NOT NULL,
    `province_id` INT(11) NOT NULL,
    
    PRIMARY KEY (`scholarship_id`, `province_id`),
    INDEX(`scholarship_id`),
    INDEX (`province_id`),
    FOREIGN KEY (`scholarship_id`) REFERENCES `scholarship_specification`(`scholarship_id`),
	FOREIGN KEY (`province_id`) REFERENCES `province`(`province_id`)
)