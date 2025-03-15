-- 코드를 입력하세요
select u.USER_ID,	u.NICKNAME,	concat( CITY," ",STREET_ADDRESS1," ",STREET_ADDRESS2)  전체주소 , concat(Left(TLNO,3),"-",substring(tlno, 4,4),"-",right(tlno,4)) 전화번호

from USED_GOODS_USER u
join(
SELECT * from USED_GOODS_BOARD
group by WRITER_ID
having count(*) >=3) board on board.writer_id = u.user_id
order by user_id desc