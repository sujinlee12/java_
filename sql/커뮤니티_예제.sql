# 공지 커뮤니티 1페이지에 등록된 게시글 목록을 조회하는 쿼리
USE COMMUNITY;
SELECT 
    *
FROM
    BOARD
WHERE
    BO_CO_CUM = (SELECT CO_NUM FROM COMMUNITY WHERE CO_NAME = '공지')
    ORDER BY BO_NUM DESC
    LIMIT 0,10;
    
# 3번 게시글을 상세 조회하는 쿼리
SELECT * FROM BOARD WHERE BO_NUM =3;

CREATE TABLE `COMMENT`;

# ABC123회원이 3번 게시글에 '확인했습니다'라고 댓글을 달았을 때 쿼리
INSERT INTO COMMENT(CM_BO_NUM, CM_ME_ID, CM_CONTENT) 
	VALUES(3, 'ABC123','확인했습니다.');

# 3번 게시글에 등록된 댓글 1페이지를 조회하는 쿼리
SELECT * FROM COMMENT WHERE CM_BO_NUM = 3 ORDER BY CM_NUM DESC LIMIT 0,5;

# 신고 사유 등록
INSERT INTO REPORT_TYPE VALUES('욕설'),('허위사실유포'),('광고'),('음란'),('기타'),('커뮤니티에 맞지 않음');

# ADMIN이 1번 댓글을 신고
INSERT INTO REPORT (RP_ME_ID,RP_RT_NAME,RP_TABLE, RP_CONTENT, RP_STATE, RP_TARGET)
VALUES('ADMIN','기타','COMMENT','','신고접수', 1);

# 관리자가 신고 내역을 조회 => 신고접수된 내역을 조회
SELECT * FROM REPORT WHERE RP_STATE = '신고접수';

# 관리자가 1번 신고내역을 신고반려로 처리
UPDATE REPORT SET RP_STATE = '신고반려' WHERE RP_NUM =1;

# ABC123회원이 1번 게시글을 '기타', '내용없음' 으로 신고
INSERT INTO REPORT (RP_ME_ID, RP_RT_NAME, RP_TABLE, RP_CONTENT, RP_STATE, RP_TARGET)
VALUES('ABC123','기타','BOARD','','신고접수', 1);
# QWE123회원이 1번 게시글을 '기타', '내용없음' 으로 신고
INSERT INTO REPORT (RP_ME_ID,RP_RT_NAME,RP_TABLE, RP_CONTENT, RP_STATE, RP_TARGET)
VALUES('QWE123','기타','BOARD','','신고접수', 1);
# ADMIN 관리자가 1번 게시글을 '기타', '내용없음' 으로 신고
INSERT INTO REPORT (RP_ME_ID,RP_RT_NAME,RP_TABLE, RP_CONTENT, RP_STATE, RP_TARGET)
VALUES('ADMIN','기타','BOARD','','신고접수', 1);

# 관리자가 1번 게시글 신고 내역을 모두 '신고처리'로 처리
UPDATE REPORT SET RP_STATE = '신고처리'
WHERE RP_TARGET = 1 AND RP_TABLE = 'BOARD' AND RP_STATE = '신고접수';

SELECT COUNT(*) FROM REPORT
		WHERE RP_TARGET = 1 AND RP_TABLE = 'BOARD' AND RP_STATE = '신고처리') 
WHERE 
	BO_NUM = 1;
# 신고처리된 게시글의 신고수를 수정 

# 3번 신고된 1번 게시글을 삭제하고, 1번 게시글을 작성한 작성자에게 1달 이용정지를 적용 
# 1번 게시글을 삭제하기 위해 1번 게시글에 달린 댓글들을 삭제
DELETE FROM COMMENT WHERE CM_BO_NUM =1;
# 1번 게시글을 삭제하기 위해 1번 게시글을 추천한 정보를 삭제
DELETE FROM RECOMMEND WHERE RE_BO_NUM =1;
# 1번 게시글을 삭제
DELETE FROM BOARD WHERE BO_NUM =1;
# ABC123 회원을 한달 간 이용 정지
UPDATE MEMBER 
SET 
    ME_MS_STATE = '기간정지',
    ME_STOP = DATE_ADD(NOW(), INTERVAL 1 MONTH)
WHERE
    ME_ID = 'ABC123';

# QWE123회원이 회원을 탈퇴
UPDATE MEMBER SET ME_MS_STATE = '탈퇴' WHERE ME_ID = 'QWE123';
SELECT * FROM MEMBER;








SELECT * FROM REPORT;

