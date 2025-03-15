-- 코드를 입력하세요
select a.CAR_ID, ifNull(AVAILABILITY,'대여 가능') AVAILABILITY
from CAR_RENTAL_COMPANY_RENTAL_HISTORY a left join
(SELECT CAR_ID, '대여중' AVAILABILITY  from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where date('2022-10-16') between START_DATE and	END_DATE) b on a.CAR_ID = b.CAR_ID
group by 1
order by 1 desc;