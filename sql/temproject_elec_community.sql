DROP DATABASE IF EXISTS elec_community;
CREATE DATABASE IF NOT EXISTS elec_community;

USE elec_community;

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
	`me_id`	varchar(20)	PRIMARY KEY,
	`me_active`	varchar(10)	NOT NULL,
	`me_pw`	varchar(20)	NOT NULL,
	`me_email`	varchar(30)	NOT NULL,
	`me_name`	varchar(20)	NOT NULL,
	`me_phone`	varchar(13)	NOT NULL,
	`me_access`	varchar(10)	NOT NULL,
	`me_try_count`	varchar(5)	NOT NULL
);

DROP TABLE IF EXISTS `post`;

CREATE TABLE `post` (
	`po_num`	int	PRIMARY KEY AUTO_INCREMENT,
	`po_ca_num`	int	NOT NULL,
	`po_di_num`	int	NOT NULL,
	`po_me_id`	varchar(20)	NOT NULL,
	`po_title`	varchar(50)	NOT NULL,
	`po_date`	date	NOT NULL,
	`po_content`	text	NOT NULL,
	`po_view`	int	NOT NULL
);

DROP TABLE IF EXISTS `link`;

CREATE TABLE `link` (
	`li_name`	varchar(100)	PRIMARY KEY,
	`li_origin`	varchar(100)	NOT NULL,
	`li_po_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
	`co_num`	int PRIMARY KEY AUTO_INCREMENT,
	`co_me_id`	varchar(20)	NOT NULL,
	`co_po_num`	int	NOT NULL,
	`co_content`	text	NOT NULL,
	`co_date`	date	NOT NULL
);

DROP TABLE IF EXISTS `report`;

CREATE TABLE `report` (
	`rep_num`	int	PRIMARY KEY AUTO_INCREMENT,
	`rep_me_id`	varchar(20)	NOT NULL,
	`rep_rt_type`	varchar(30)	NOT NULL,
	`rep_content`	text	NOT NULL,
	`rep_result`	varchar(15)	NOT NULL,
	`rep_side`	varchar(15)	NOT NULL,
	`Field`	VARCHAR(255)	NOT NULL
);

DROP TABLE IF EXISTS `report_type`;

CREATE TABLE `report_type` (
	`rt_type`	varchar(30)	PRIMARY KEY
);

DROP TABLE IF EXISTS `active`;

CREATE TABLE `active` (
	`active`	varchar(10)	PRIMARY KEY
);

DROP TABLE IF EXISTS `divice`;

CREATE TABLE `divice` (
	`di_num`	int	PRIMARY KEY AUTO_INCREMENT,
	`di_title`	varchar(10)	NOT NULL
);

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
	`ca_num`	int	PRIMARY KEY AUTO_INCREMENT,
	`ca_title`	varchar(10)	NOT NULL,
	`ca_comu_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `community`;

CREATE TABLE `community` (
	`comu_num`	int	PRIMARY KEY AUTO_INCREMENT,
	`comu_name`	varchar(30)	NOT NULL
);

ALTER TABLE `member` ADD CONSTRAINT `FK_active_TO_member_1` FOREIGN KEY (
	`me_active`
)
REFERENCES `active` (
	`active`
);

ALTER TABLE `post` ADD CONSTRAINT `FK_category_TO_post_1` FOREIGN KEY (
	`po_ca_num`
)
REFERENCES `category` (
	`ca_num`
);

ALTER TABLE `post` ADD CONSTRAINT `FK_divice_TO_post_1` FOREIGN KEY (
	`po_di_num`
)
REFERENCES `divice` (
	`di_num`
);

ALTER TABLE `post` ADD CONSTRAINT `FK_member_TO_post_1` FOREIGN KEY (
	`po_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `link` ADD CONSTRAINT `FK_post_TO_link_1` FOREIGN KEY (
	`li_po_num`
)
REFERENCES `post` (
	`po_num`
);

ALTER TABLE `comment` ADD CONSTRAINT `FK_member_TO_comment_1` FOREIGN KEY (
	`co_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `comment` ADD CONSTRAINT `FK_post_TO_comment_1` FOREIGN KEY (
	`co_po_num`
)
REFERENCES `post` (
	`po_num`
);

ALTER TABLE `report` ADD CONSTRAINT `FK_member_TO_report_1` FOREIGN KEY (
	`rep_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `report` ADD CONSTRAINT `FK_report_type_TO_report_1` FOREIGN KEY (
	`rep_rt_type`
)
REFERENCES `report_type` (
	`rt_type`
);

ALTER TABLE `category` ADD CONSTRAINT `FK_community_TO_category_1` FOREIGN KEY (
	`ca_comu_num`
)
REFERENCES `community` (
	`comu_num`
);