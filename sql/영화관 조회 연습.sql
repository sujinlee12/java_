USE COMMUNITY;

#회원 상태를 추가하는 쿼리(이용중, 기간 정지, 영구 정지, 탈퇴)
INSERT INTO MEMBER_STATE VALUES('이용중'),('기간정지'),('영구정지') ,('탈퇴');

#3명이 각각 회원 가입을 진행할 때 필요한 쿼리
# 아이디 : abc123, 비번 : abc 123, 이메일 : abc123@kh.co.kr 권한 : user
insert into member(me_id, me_pw, me_email, me_ms_state) 
VALUES('abc123','abc123','abc123@kh.co.kr','이용중');

# 아이디 : qwe123, 비번 : qwe 123, 이메일 : qwe123@kh.co.kr 권한 : user
insert into member(ME_ID, ME_PW, ME_EMAIL, me_ms_STATE) 
VALUES('qwe123','qwe123','qwe@kh.co.kr','이용중');

# 아이디 : admin, 비번 : admin, 이메일 : admin@kh.co.kr 권한 : admin 
insert into member(ME_ID, ME_PW, ME_EMAIL,ME_AUTORITY,ME_MS_STATE) 
VALUES('admin','admin','admin@kh.co.kr', 'admin', '이용중');


#관리자가 커뮤니티를 등록(공지, 자유, 토론, 공부)
insert into COMMUNITY(CO_NAME) VALUES('공지');
insert into COMMUNITY(CO_NAME) VALUES('자유');
insert into COMMUNITY(CO_NAME) VALUES('토론');
insert into COMMUNITY(CO_NAME) VALUES('공부');

# ABC123회원이 자유 커뮤니티에 게시글을 등록했을 때 실행되는 쿼리
# 제목 : 테스트, 내용, : 테스트 입니다. 첨부파일 : 없음
INSERT INTO BOARD(BO_CO_NUM, BO_ME_ID, BO_TITLE, BO_CONTENT)
VALUES(2, 'ABC123','테스트','테스트 입니다.');

INSERT INTO BOARD (BO_CO_NUM, BO_ME_ID,BO_TITLE,BO_CONTENT)
SELECT CO_NUM, 'ABC123','테스트','테스트 입니다.' FROM COMMUNITY WHERE CO_NAME = '자유';

SELECT * FROM COMMUNITY;

# ADMIN 관리자가 공지 커뮤니티에 게시글을 등록했을 때 실행되는 쿼리
# 제목 : 공지사항, 내용 : 공지사항입니다. 첨부파일 : 공지사항1.JPG
# 첨부파일은 서버에 업로드 되면 현재 날짜를 기준으로 폴더를 생성해서 업로드 함 
# 업로드된 첨부파일은 /2024/02/14/파일명으로 저장 
INSERT INTO BOARD(BO_CO_NUM,BO_ME_ID, BO_TITLE, BO_CONTENT)
SELECT CO_NUM,'ADMIN','공지사항','공지사항입니다.' FROM COMMUNITY WHERE CO_NAME ='공지';


INSERT FILE (FI_BO_NUM,FI_NAME, FI_ORI_NAME)
VALUES(6,'/2024/02/14/공지사항1.JPG','공지사항1.JPG');

SELECT * FROM `FILE`;
SELECT * FROM 
#VALUES(1,'ADMIN','공지사항','공지사항입니다.'); 
#SELECT * FROM BOARD;

# 공지 커뮤니티에 등록된 모든 게시글을 조회하는 쿼리
SELECT * FROM BOARD JOIN COMMUNITY ON BO_CO_NUM = CO_NUM WHERE CO_NAME = '공지';

# 공지 커뮤니티에 등록된 게시글 중 1페이지에 해당하는 게시글을 조회하는 쿼리
SELECT * FROM BOARD JOIN COMMUNITY ON BO_CO_NUM = CO_NUM 
WHERE CO_NAME = '공지'
ORDER BY BO_NUM DESC
LIMIT 0, 10;

# 3번 게시글을 상세 조회했을 때 실행되는 쿼리 
# 1. 3번 게시글의 조회수를 증가하는 쿼리 증가식은 UPDATE문 사용하기. 
UPDATE BOARD SET BO_VIEW = BO_VIEW +1 WHERE BO_NUM =3;
# 2. 3번 게시글을 조회하는 쿼리
SELECT * FROM BOARD WHERE BO_NUM =3;

# 게시글 목록에서 ABC123 아이디를 클릭했을 때 실행되는 쿼리를 작성하세요
SELECT 
    *
FROM
    BOARD
WHERE
    BO_ME_ID = 'ABC123'
ORDER BY BO_NUM DESC
LIMIT 0,10;

# QWE123 회원이 1번 게시글의 추천 버튼을 클릭했을 때 실행되는 쿼리
UPDATE BOARD SET BO_VIEW = BO_VIEW +1 WHERE BO_NUM = 1
ORDER BY BO_ME_ID = 'QWE123';
SELECT * FROM BOARD;

# QWE123회원이 1번 게시글의 추천 버튼을 클릭 했을 때 실행되는 쿼리
# 1 . QWE123회원이 1번 게시글에 추천한 기록을 조회
SELECT * FROM RECOMMEND WHERE RE_ME_ID = 'ABC123' AND RE_BO_NUM =1;

# 2-1. 추천한 기록이 없다면 추천을 추가
INSERT INTO RECOMMEND(RE_ME_ID, RE_BO_NUM, RE_STATE)
VALUES('ABC123',1,1);
# 2-2. 추천한 기록이 있다면 추천을 수정
# 2-2-1. 추천한 기록이 추천인 경우 => 추천을 취소
UPDATE RECOMMEND SET RE_STATE = 0 WHERE RE_BO_NUM = 1 AND RE_ME_ID ='ABC123';
# 2-2-2. 추천한 기록이 추천이 아닌 경우 => 비추천이거나 추천/비추천을 취소한 경우
UPDATE RECOMMEND SET RE_STATE = 1 WHERE RE_BO_NUM = 1 AND RE_ME_ID ='ABC123';

# 아이디와 게시글이 주어졌을 때 추천을 추가하거나 수정하는 프로시져
DROP PROCEDURE IF EXISTS BOARD_RECOMMEND;

DELIMITER //
CREATE PROCEDURE BOARD_RECOMMEND(
	IN _ID VARCHAR(13),
    IN _BO_NUM INT,
    IN _STATE INT # 1이면 추천, -1이면 비추천
)
BEGIN
	DECLARE _RE_NUM INT;
    DECLARE _RE_STATE INT;
	DECLARE _NEW_STATE INT;
    
    # 1. 아이디, 게시글 번호를 이용하여 등록된 추천 번호를 조회해서 변수에 저장 
	SET _RE_NUM =
		(SELECT RE_NUM FROM RECOMMEND WHERE RE_ME_ID = _ID AND RE_BO_NUM = _BO_NUM);
    #2-1. 추천 번호가 NULL이면 추천 테이블에 추가
	IF _RE_NUM IS NULL THEN 
    INSERT INTO RECOMMEND(RE_ME_ID, RE_BO_NUM, RE_STATE)
	VALUES(_ID,_BO_NUM,_STATE);
    
    #2-2. 추천 번호가 NULL이 아니면 
	ELSE
       --  # 2-2-0. 추천 번호에 맞는 추천 상태를 가져옴 
		SET _RE_STATE = (SELECT RE_STATE FROM RECOMMEND WHERE RE_NUM = _RE_NUM);
        # 2-2-1. 추천 상태가 STATE와 같으면 취소(0) => 0으로 수정 
        IF _RE_STATE = _STATE THEN 
			UPDATE RECOMMEND SET RE_STATE = 0 
			WHERE RE_BO_NUM = _BO_NUM AND RE_ME_ID =_ID;
        
        # 2-2-1 추천 상태가 STATE와 다르면 STATE로 변경 
         IF _RE_STATE = _STATE THEN 
			SET _NEW_STATE = 0;
        
        # 2-2-1 추천 상태가 STATE와 다르면 STATE로 변경 
        ELSE
			SET _NEW_STATE = _STATE;
		END IF;
        ELSE
			UPDATE RECOMMEND SET RE_STATE = _NEW_STATE
			WHERE RE_BO_NUM = _BO_NUM AND RE_ME_ID = ID;
		END IF;
        
		
        UPDATE RECOMMEND SET RE_STATE
    END IF;
END //
DELIMITER ; 

CALL BOARD_RECOMMEND('ABC123',1,1);
SELECT * FROM recommend;
