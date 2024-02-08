# 영화 웡카의 영화 정보를 검색하는 쿼리(배우x, 감독 x, 제작국가 x, 장르 x)
USE MOVIE;
select * from movie where mo_title = '웡카';

# 영화 웡카에 출연한 배우 및 감독을 조회하는 쿼리
SELECT 
    mo_title as 제목, ch_name as 이름, mp_role as 구분
FROM
    movie
        JOIN
    `join` ON jo_mo_num = mo_num
        JOIN
    movie_person ON mp_num = jo_mp_num
		JOIN
	`character` on mp_ch_num = ch_num
WHERE
	mo_title = '웡카';
    
# 영화 웡카를 상영하고 있는 극장을 조회하는 쿼리 , 4개 테이블 합치기,distinct 중복 제거
SELECT distinct
    th_name, mo_title
FROM
    theater
        JOIN
    screen ON sc_th_num = sc_th_num
        JOIN
    schedule ON sh_sc_num = sc_num
        JOIN
    movie ON mo_num = sh_mo_num
WHERE
    mo_title = '웡카';
    
    
# CGV 강남 1상영관에 웡카 상영 시간을 조회하는 쿼리
SELECT 
    mo_title as 영화, th_name as 극장, sh_date as 날짜, sh_time as 시간
FROM
    schedule
        JOIN
    screen ON sh_sc_num = sc_num
        JOIN
    theater ON th_num = sc_th_num
    join
moive on mo_num = sh_mo_num
where 
th_name = 'CGV강남' and sc_num = 1 and mo_title ='웡카';


# cgv강남 1상영관에 있는 좌석들을 조회하는 쿼리,
SELECT 
    se_name
FROM
    seat
    join
    screen on sc_num = se_sc_num
    join
    theater on th_num = sc_th_num
	where 
th_name = 'cgv강남' and sc_num = 1 ;

# 2월 9일 10:30분 CGV강남 1상영관에서 상영하는 웡카 예매 가능한 좌석을 조회하는 쿼리를 작성(x)
SELECT 
    sh_date, sh_title, se_name
FROM
    seat
        JOIN
    screen ON sc_num = se_sc_num
        JOIN
    theater ON th_num = sc_th_num
        JOIN
    schedule ON sh_sc_num = sc_num
WHERE
    th_name = 'CGV강남' AND sc_name = 1
        AND sh_date = '2024-02-09'
        AND sh_time = '10:30';
        
select * from member;

#cgv강남 1상영관 2월 9일 10:30 웡카를 예매한 좌석들을 조회

# 1번 스케줄을 예매한 좌석들을 조회
SELECT 
    *
FROM
    schedule
join 
	ticketing 
on
	ti_sh_num = sh_num
join 
	ticketing_list
    
on ti_ti_num = ti_num
join
seat 
on se_num = ti_se_num
WHERE
    sh_num = 1;

# 1번 스케줄에서 좌석들 예약 확인을 하는 쿼리
SELECT 
    se_name AS 좌석, IFNULL(ti_num, 'o')
FROM
    seat
        JOIN
    screen ON sc_num = se_sc_num
        JOIN
    schedule ON sh_sc_num = sc_num
        LEFT JOIN
    (SELECT 
        *
    FROM
        ticketing_list
    JOIN ticketing ON ti_num = ti_ti_num
    WHERE
        ti_sh_num = 1) 
	AS t ON ti_se_num = se_num
WHERE
    sh_num = 1;
    
# abc123회원이 예매한 영화 목록을 조회하는 쿼리
# ticketing과 schedule과 movie를 join해서 조회

SELECT distinct
    mo_title
FROM
    ticketing
        JOIN
    schedule ON sh_num = ti_sh_num
        JOIN
    movie ON mo_num = sh_mo_num
WHERE
    ti_me_id = 'abc123';
    
# 1번 상영시간(윙카, cgv강남 1상영관 10:30 스케줄)이 예매된 수량을 조회
SELECT 
    SUM(ti_adult) + SUM(ti_teenager) AS 예매수량
FROM
    ticketing
WHERE
    ti_sh_num = 1;
# 폴 킹 감독이 감독으로 연출한 영화를 조회하는 쿼리
SELECT 
    mo_title
FROM
    movie
        JOIN
    `join` ON jo_mo_num = mo_num
        JOIN
    movie_person ON mp_num = jo_mp_num
        JOIN
    `character` ON ch_num = mp_num
WHERE
    mp_role = '감독' AND ch_name = '폴킹';
 # 장르별 등록된 영화 개수를 조회하는 쿼리
 SELECT 
    ge_name, COUNT(gi_mo_num)
FROM
    genre_inclde
		right join 
        genre on ge_name = gi_ge_name
GROUP BY ge_name;
# 판타지로 등록된 모든 영화를 조회하는 쿼리
SELECT 
    *
FROM
    movie
        JOIN
    genre_include ON gi_mo_num = mo_num
WHERE
    gi_ge_name = '판타지';
# 상영 예정인 영화를 조회하는 쿼리 / 오늘 날짜를 기준으로 이후면 상영 예정 / 
SELECT 
    *
FROM
    movie
where mo_date <= '2024-02-08'; 

# 전체관람가 영화를 조회하는 쿼리
select * from movie
where mo_ag_name = '전체관람가';         

# 영화 제목에 카를 포함하는 영화를 조회하는 쿼리
select * from movie where mo_title like '%카%';




    

