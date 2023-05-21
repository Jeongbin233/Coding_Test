-- 코드를 입력하세요
SELECT i.ingredient_type as ingredient_type, sum(f.total_order) as total_order
from first_half as f, icecream_info as i
where i.flavor = f.flavor
group by i.ingredient_type
order by total_order;