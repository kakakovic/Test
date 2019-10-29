select class
from courses
group by class
having count(distinct student) >= 5

-- 计算不同取值时必须制定列名