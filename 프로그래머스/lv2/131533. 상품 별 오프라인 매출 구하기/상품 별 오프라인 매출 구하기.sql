-- 코드를 입력하세요
select p.product_code as product_code, sum(o.sales_amount)*price as sales
from product as p join offline_sale as o on p.product_id = o.product_id
group by product_code
order by sales desc, product_code asc;