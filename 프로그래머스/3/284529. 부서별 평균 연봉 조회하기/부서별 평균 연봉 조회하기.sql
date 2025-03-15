-- 코드를 작성해주세요
select d.DEPT_ID,	DEPT_NAME_EN,round(	d.AVG_SAL ,0) AVG_SAL
from (select dept_id , avg(sal) AVG_SAL from HR_EMPLOYEES
group by dept_id) d
join HR_DEPARTMENT h on h.dept_id = d.dept_id
order by 3 desc

# where dept_id in(
# select dept_id , avg(sal) AVG_SAL from HR_EMPLOYEES
# group by dept_id)