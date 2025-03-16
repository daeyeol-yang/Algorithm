-- 코드를 입력하세요
# SELECT MEMBER_NAME,	REVIEW_TEXT,	REVIEW_DATE

SELECT MEMBER_NAME,	REVIEW_TEXT, DATE_FORMAT(REVIEW_DATE , '%Y-%m-%d') REVIEW_DATE
FROM MEMBER_PROFILE P
join REST_REVIEW r on p.MEMBER_ID = r.MEMBER_ID
where p.member_id =(
    select member_id from REST_REVIEW 
    group by MEMBER_ID
    order by count(*) desc
    limit 1)
order by REVIEW_DATE , 	REVIEW_TEXT
    

#select member_id from REST_REVIEW group by MEMBER_ID having (count(member_id) = Max(count(member_id)));
# select *
# FROM MEMBER_PROFILE
# where member_id in (
# select (member_id, member_name) from REST_REVIEW 
#     group by MEMBER_ID
#     order by count(*) desc
#     limit 1
#     )


#select member_id , count(*) from REST_REVIEW group by member_id

#select * from MEMBER_PROFILE


# SELECT M.MEMBER_NAME, R.REVIEW_TEXT, DATE_FORMAT(R.REVIEW_DATE, '%Y-%m-%d') AS REVIEW_DATE
# FROM MEMBER_PROFILE M
# JOIN REST_REVIEW R ON M.MEMBER_ID = R.MEMBER_ID
# WHERE R.MEMBER_ID = (
#     SELECT MEMBER_ID 
#     FROM REST_REVIEW R 
#     GROUP BY MEMBER_ID
#     ORDER BY COUNT(*) DESC
#     LIMIT 1)

# ORDER BY REVIEW_DATE ASC, REVIEW_TEXT ASC;