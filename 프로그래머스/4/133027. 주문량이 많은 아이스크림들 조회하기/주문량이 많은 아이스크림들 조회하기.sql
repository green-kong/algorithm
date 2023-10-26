-- 코드를 입력하세요
select f.flavor
from first_half as f
join (select j.shipment_id, j.flavor, sum(j.total_order) as total_order
        from july as j
        group by j.flavor) as jj
on jj.flavor = f.flavor
order by f.total_order + jj.total_order desc
limit 3



# select * from july
