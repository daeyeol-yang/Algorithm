-- 코드를 입력하세요

# select month(start_date) MONTH , c.CAR_ID , RECORDS
# from CAR_RENTAL_COMPANY_RENTAL_HISTORY c join(
# SELECT car_id , count(car_id) RECORDS from CAR_RENTAL_COMPANY_RENTAL_HISTORY where '2022-8-1' <= START_DATE and start_date < '2022-11-1' group by car_id
# having RECORDS >= 5) t on c.car_id = t.car_id
# where month(start_Date) is not null
# group by MONTH , CAR_ID
# order by 1, 2 desc

SELECT MONTH(A.START_DATE) AS MONTH, A.CAR_ID, COUNT(A.CAR_ID) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY AS A
JOIN (
    SELECT CAR_ID, COUNT(CAR_ID) AS RECORDS
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
    GROUP BY CAR_ID
    HAVING RECORDS >= 5
) AS B
ON A.CAR_ID = B.CAR_ID
WHERE A.START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
GROUP BY MONTH(A.START_DATE), A.CAR_ID
ORDER BY MONTH ASC, A.CAR_ID DESC;
