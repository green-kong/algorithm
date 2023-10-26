-- 코드를 입력하세요
SELECT i.ANIMAL_ID,	i.ANIMAL_TYPE, i.NAME
from animal_ins as i
inner join animal_outs as o
on i.animal_id = o.animal_id
where i.SEX_UPON_INTAKE like 'Intact%' and (o.SEX_UPON_OUTCOME not like 'Intact%')
order by i.animal_id