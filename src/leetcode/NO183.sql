select name as customers
from customers left join orders on customers.id = orders.customerid
where orders.id is null

-- 判断是否等于null 要用is null，不能用 = null