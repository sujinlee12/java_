

USE MOVIE;

# 상영관에 좌석이 추가되면 상영관 전체 좌석수와 영화관 전체 좌석수를 업데이트하는 트리거
# SEAT 테이블에 좌석이 추가되면, SCREEN테이블과 THEATER 테이블의 좌석수를 수정하는 트리거
DROP TRIGGER IF EXISTS INSERT_SEAT;

DELIMITER // 
CREATE TRIGGER INSERT_SEAT AFTER INSERT ON SEAT
FOR EACH ROW
BEGIN 
	#변수선언, 지역변수는 앞에 _ 를 해서 속성과 구분해서 사용
	DECLARE _SC_NUM INT;
    DECLARE _SC_SEAT INT;
    DECLARE _TH_NUM INT; #영화관번호
    DECLARE _TH_SEAT INT; # 영화관 좌석수
    
    # 상영관 번호
    SET _SC_NUM = NEW .SE_SC_NUM;
	# 상영관에 있는 전체 좌석수 계산
    SET _SC_SEAT= (SELECT COUNT(*) FROM SEAT WHERE SE_SC_NUM = _SC_NUM);
    # 상영관에 있는 전체 좌석수를 업데이트
    UPDATE SCREEN SET SC_SEAT = _SE_SEAT WHERE SC_NUM = _SC_NUM;
	
    # 영화관 번호
    SET _TH_NUM = (SELECT SC_TH_NUM FROM SCREEN WHERE SC_NUM = _SC_NUM);
    # 영화관 전체 좌석수
    SET _TH_SEAT = ();
		(SELECT COUNT(*) FROM SEAT 
		WHERE SE_SC_NUM IN (SELECT SC_NUM FROM SCREEN WHERE SC_TH_NUM = _TH_NUM));
	# 영화관에 있는 전체 좌석수를 업데이트
    UPDATE THEATER SET TH_SEAT = _TH_SEAT WHERE TH_NUM =_TH_NUM;
	
	
END // 
DELIMITER ; 

