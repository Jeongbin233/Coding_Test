-- 코드를 입력하세요
SELECT distinct a.user_id, a.product_id 
from online_sale as a join online_sale as b
on a.user_id=b.user_id and a.product_id=b.product_id 
where a.sales_date != b.sales_date
order by user_id, product_id desc;