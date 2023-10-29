-- 코드를 입력하세요
SELECT category, sum(sales) as total_sales
from BOOK_SALES as s
join book as b
on b.book_id = s.book_id
where year(sales_date) = 2022 and month(sales_date) = 1
group by category
order by category