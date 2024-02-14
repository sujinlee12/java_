create user 'SUIJN'@'%' identified BY 'ABC123'; # 사용자 계정 추가

SET PASSWORD FOR 'SUJIN'@'%' = 'DEF123'; # 사용자 비번 변경

DROP USER 'SUJIN'@'%'; # 사용자 삭제

SELECT user(), host from mysql.user;

# GRANT 권한종류 DB명. 테이블명 TO '사용자명'@' 호스트명';
GRANT ALL PRIVILEGES ON `SHOPPINGMALL`.PRODUCT TO 'SUJIN'@'%';

# 권한 제거 : revoke 권한 종류 on DB명. 테이블명 FROM '사용자명'@'호스트명';
REVOKE ALL privileges ON `SHOPPINGMALL`.PRODUCT FROM 'sujin'@'%';

GRANT ALL PRIVILEGES ON `SHOPPINGMALL`.* TO 'SUJIN'@'%';
