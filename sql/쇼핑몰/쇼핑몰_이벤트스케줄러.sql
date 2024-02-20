
#지정 시간에 이벤트가 1번만 실행되고 이벤트를 삭제 : NOT PRESERVE
CREATE EVENT DELETE_CERTIFICATION
ON SCHEDULE 

AT '2024-02-15 09:45:00'
on completion not preserve

DO
	DELETE FROM certification WHERE CE_LIMIT <= NOW();

select * from shoppingmall.certification;

# 이벤트 조회
SELECT * FROM information_schema.EVENT;
# 이벤트 삭제
drop event delete_certification;


