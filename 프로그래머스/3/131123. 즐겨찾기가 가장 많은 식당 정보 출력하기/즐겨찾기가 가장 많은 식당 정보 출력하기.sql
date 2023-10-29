-- 코드를 입력하세요
# 은돼지 734, 따띠따띠뜨 102,  스시사카우스 230
select o.food_type, o.rest_id, o.rest_name, o.favorites
from rest_info as o
where (food_type, favorites) in(
    select food_type, max(favorites) as favorites
    from rest_info
    group by food_type)
order by food_type desc
