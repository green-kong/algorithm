-- 코드를 입력하세요
select 
    car_id, 
    if(car_id in (
        select car_id
        from CAR_RENTAL_COMPANY_RENTAL_HISTORY
        where start_date <= '2022-10-16' and '2022-10-16' <= end_date
        )
    ,"대여중", "대여 가능") as AVAILABILITY
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by car_id
order by car_id desc