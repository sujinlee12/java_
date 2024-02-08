
# 컴퓨터 공학을 다니는 학생 정보를 조회(X)
# SELECT * from student;
SELECT *
FROM STUDENT
WHERE ST_MAJOR = '컴퓨터공학';

# 컴퓨터 공학을 다니는 1학년 학생 정보를 조회(O)
SELECT * FROM STUDENT WHERE ST_GRADE=1 AND ST_MAJOR = '컴퓨터공학';

#컴퓨터공학 또는 화학공학을 다니는 1학년 학생 정보를 조회(O)

SELECT * FROM STUDENT WHERE (ST_MAJOR ='컴퓨터공학' OR ST_MAJOR='화학공학') AND ST_GRADE=1;
SELECT * FROM STUDENT WHERE ST_MAJOR IN ('컴퓨터공학','화학공학') AND ST_GRADE =1;

# 컴퓨터공학을 다니는 학생 수를 조회
SELECT COUNT(*) FROM STUDENT WHERE ST_MAJOR ='컴퓨터공학' GROUP BY ST_MAJOR;
# 학생들이 등록된 학과를 조회(x)
SELECT DISTINCT ST_MAJOR FROM STUDENT;
# GROUP BY ST_MAJOR;

# 학생들이 3명 이상 등록된 학과들을 조회(x)
SELECT st_major FROM student GROUP BY st_major HAVING COUNT(st_num) >= 3;
 
# 컴퓨터개론을 수강하는 학생 수를 조회
# SELECT count(st_num) From student where st_major = '컴퓨터공학';

SELECT 
    count(*)
FROM
    course
        JOIN
    lecture ON co_le_num = le_num
WHERE
	le_title = '컴퓨터개론'
group by co_le_num;

# 각 강의별 수강하는 학생 수를 조회

SELECT 
    le_title, COUNT(co_st_num)
FROM
    course join lecture on co_le_num = le_num
GROUP BY co_le_num; 

# 홍길동 학생이 수강하는 강의 목록(x)
SELECT 
    *
FROM
    course
        JOIN
    student ON co_st_num = st_num
    JOIN
    lecture on co_le_num = le_num
WHERE
    st_name = '홍길동'; 
# 기계공학에 소속된 교수의 수를 조회(o)
SELECT count(*) FROM professor where pr_major = "기계공학";

# 김교수가 강의하는 강의명을 조회(x)
SELECT 
    pr_name, le_title
FROM
    course
        JOIN
    lecture ON co_le_num = le_num
        JOIN
    professor ON le_pr_num = pr_num
WHERE
    pr_name = '김교수';
    





