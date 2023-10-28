-- 코드를 입력하세요
SELECT user_id, u.nickname, sum(price) as total_sales 
from used_goods_board as b
join used_goods_user as u
on u.user_id = b.writer_id
where b.status = 'DONE'
group by writer_id
having total_sales >= 700000
order by total_sales


