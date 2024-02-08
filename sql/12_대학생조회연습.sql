# 컴퓨터공학 고길동 학생이 수강신청한 강의 개수를 조회하는 쿼리
SELECT 
ST_NAME AS "이름", ST_MAJOR AS "전공", COUNT(*) AS "신청한 강의 수" ,SUM(LE_POINT) AS "수강신청학점"
FROM 
	COURSE 
		JOIN 
	STUDENT ON CO_ST_NUM = ST_NUM
		JOIN
    LECTURE ON CO_LE_NUM = LE_NUM
WHERE
	ST_MAJOR = "컴퓨터공학" AND ST_NAME = "고길동";

#컴퓨터 공학 고길동 학생이 수강 신청한 학점을 조회하는 쿼리 3개의 TABLE을 조인해서 몇 학점인지 조회하기
SELECT ST_NAME AS "이름" , ST_MAJOR AS "전공", COUNT(*) AS "수강 신청한 학점"
FROM COURSE JOIN STUDENT ON CO_ST_NUM = ST_NUM 
WHERE ST_MAJOR = "컴퓨터공학" AND ST_NAME = "고길동";

# 24학년 신입생을 조회하는 쿼리
SELECT * FROM STUDENT WHERE ST_NUM LIKE "2024%" AND ST_GRADE = 1;

# 각 전공별 학생 수를 조회하는 쿼리
SELECT ST_MAJOR, COUNT(*) AS "학생수" 
FROM STUDENT 
GROUP BY ST_MAJOR;



 
