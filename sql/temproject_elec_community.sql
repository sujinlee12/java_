DROP DATABASE IF EXISTS elec_community;
CREATE DATABASE IF NOT EXISTS elec_community;

use elec_community;


DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
	`me_id`	varchar(20)	PRIMARY KEY,
	`active`	varchar(10)	NOT NULL, 
	`me_pw`	varchar(20)	NOT NULL,
	`me_email`	varchar(30)	NOT NULL,
	`me_addr`	varchar(30)	NOT NULL,
	`me_name`	varchar(20)	NOT NULL,
	`me_phone`	varchar(13)	NOT NULL,
	`me_try_count`	varchar(5)	NOT NULL
);

DROP TABLE IF EXISTS `post`;

CREATE TABLE `post` (
	`po_num`	int	PRIMARY KEY AUTO_INCREMENT,
	`comu_num`	int	NOT NULL,
	`po_li_num`	int	NOT NULL,
	`po_me_id`	varchar(20)	NOT NULL,
	`po_catrgory`	varchar(10)	NOT NULL,
	`po_divice`	varchar(10)	NULL,
	`po_title`	varchar(50)	NULL,
	`po_writer`	varchar(20)	NULL,
	`po_date`	date	NOT NULL,
	`po_content`	text	NOT NULL,
	`po_view`	int	NOT NULL
);

drop table if exists `event`;

CREATE TABLE `event` (
   `eve_num`   int   PRIMARY KEY AUTO_INCREMENT,
   `me_id`   varchar(20)   NOT NULL,
   `co_num`   int   NOT NULL,
   `eve_content`   text   NOT NULL,
   `date`   date   NOT NULL
);
DROP TABLE IF EXISTS `link`;

CREATE TABLE `link` (
	`li_num`	int PRIMARY KEY AUTO_INCREMENT,
	`li_vidio`	varchar(100)	NULL,
	`li_img`	varchar(100)	NULL,
	`li_origin`	varchar(100)	NULL
);

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
	`co_num`	int	PRIMARY KEY AUTO_INCREMENT,
	`co_me_id`	varchar(20)	NOT NULL,
	`co_po_num`	int	NOT NULL,
	`co_content`	text	NOT NULL,
	`co_date`	dateTime	NOT NULL
);

DROP TABLE IF EXISTS `community`;

CREATE TABLE `community` (
	`comu_num`	int	primary key auto_increment,
	`comu_name`	varchar(30)	NOT NULL
);

DROP TABLE IF EXISTS `report`;

CREATE TABLE `report` (
	`rep_num`	int	PRIMARY KEY AUTO_INCREMENT,
	`rep_me_id`	varchar(20)	NOT NULL,
	`rep_rec_type`	varchar(30)	NOT NULL,
	`rep_type`	varchar(50)	NOT NULL,
	`rep_content`	text	NOT NULL,
	`rep_result`	varchar(15)	NOT NULL,
	`rep_many`	int	NOT NULL
);

DROP TABLE IF EXISTS `report_count`;

CREATE TABLE `report_count` (
	`rec_type`	varchar(30)	PRIMARY KEY
);

DROP TABLE IF EXISTS `active`;

CREATE TABLE `active` (
	`active`	varchar(10) PRIMARY KEY
);

ALTER TABLE `member` ADD CONSTRAINT `FK_active_TO_member_1` FOREIGN KEY (
	`active`
)
REFERENCES `active` (
	`active`
);

ALTER TABLE `post` ADD CONSTRAINT `FK_community_TO_post_1` FOREIGN KEY (
	`comu_num`
)
REFERENCES `community` (
	`comu_num`
);

ALTER TABLE `post` ADD CONSTRAINT `FK_link_TO_post_1` FOREIGN KEY (
	`po_li_num`
)
REFERENCES `link` (
	`li_num`
);

ALTER TABLE `post` ADD CONSTRAINT `FK_member_TO_post_1` FOREIGN KEY (
	`po_me_id`
)
REFERENCES `member` (
	`me_id`
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

ALTER TABLE `report` ADD CONSTRAINT `FK_report_count_TO_report_1` FOREIGN KEY (
	`rep_rec_type`
)
REFERENCES `report_count` (
	`rec_type`
);