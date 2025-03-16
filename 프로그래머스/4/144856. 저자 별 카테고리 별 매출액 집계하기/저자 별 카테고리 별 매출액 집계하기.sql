-- 코드를 입력하세요
SELECT a.AUTHOR_ID 	,AUTHOR_NAME,CATEGORY , sum(PRICE* SALES) TOTAL_SALES from
Book b join AUTHOR a on b.AUTHOR_ID	 = a.AUTHOR_ID
join BOOK_SALES s on b.BOOK_ID = s.BOOK_ID
where year(SALES_DATE) = 2022 and month(SALES_DATE) = 1
group by a.AUTHOR_ID ,CATEGORY,AUTHOR_NAME
order by 1 , 3 desc