select t.id
from weather as t inner join weather as y on TO_DAYS(t.RecordDate) - 1 = TO_DAYS(y.RecordDate)
where t.temperature > y.temperature

-- 需要利用MySQL内置的TO_DAYS函数