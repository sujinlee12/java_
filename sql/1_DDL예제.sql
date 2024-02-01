create database if not exists university;
use university;
#테이블 생성
CREATE TABLE IF NOT EXISTS professor(
	pr_num varchar(10) PRIMARY KEY,
    pr_name varchar(10) NOT NULL,
    pr_room varchar(50) NOT NULL,
    pr_major varchar(13) NOT NULL UNIQUE
);
DESC MEMBER;
CREATE TABLE IF NOT EXISTS MEMBER(
	st_num varchar(10) PRIMARY KEY,
    st_name varchar(10) NOT NULL,
    st_major varchar(50) NOT NULL,
    st_grade varchar(13) NOT NULL UNIQUE
);
DESC MEMBER;