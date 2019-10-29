select distinct t1.num as consecutivenums
from logs as t1 inner join logs as t2 on ti.id = t2.id - 1 inner join logs as t3 on t2.id = t3.id - 1
where t1.num = t2.num and t1.num = t3.num

-- 做内连接后，所有列都保存，并不会把取值相同的列合并成一个