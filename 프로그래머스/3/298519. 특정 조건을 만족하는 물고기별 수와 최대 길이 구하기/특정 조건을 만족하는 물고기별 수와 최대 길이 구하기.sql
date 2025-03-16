-- 코드를 작성해주세요

select count(*) FISH_COUNT, Max(length) MAX_LENGTH,FISH_TYPE from  fish_info where fish_type in
(select fish_type from FISH_INFO group by FISH_TYPE	having avg(LENGTH) >=33  )
group by fish_type
order by 3