-- 코드를 입력하세요


select ID,	NAME,	p.HOST_ID
from PLACES p
join(
SELECT host_id
from PLACES
group by host_id
having count(*)>=2) t on t.HOST_ID = p.host_id
order by 1