select a.id as id, b.student as student
from seat as a, seat as b
where
(a.id % 2 != 0 and b.id = a.id + 1)
or
(a.id % 2 = 0 and b.id = a.id - 1)
or
(a.id % 2 != 0 and a.id = (select count(*) from seat) and b.id = a.id)
order by a.id

-- 如果语法不通过，先加个括号试试