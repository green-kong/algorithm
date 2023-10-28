-- 코드를 입력하세요
select c.CAR_ID, c.CAR_TYPE, round(c.daily_fee * ((100-p.discount_rate)/100) * 30) as fee
from CAR_RENTAL_COMPANY_CAR as c
join CAR_RENTAL_COMPANY_DISCOUNT_PLAN as p
on p.car_type = c.car_type
where 
    p.duration_type = '30일 이상' and
    (round(c.daily_fee * ((100-p.discount_rate)/100) * 30) between 500000 and 2000000-1) and
    c.car_id not in (
        SELECT c.car_id
        from CAR_RENTAL_COMPANY_RENTAL_HISTORY as h
        join CAR_RENTAL_COMPANY_CAR as c
        on h.car_id = c.car_id
        where c.car_type in ('suv', '세단')
        and end_date >= '2022-11-01' and start_date <= '2022-11-30'
        order by c.car_id
        )
order by fee desc, car_type, car_id desc