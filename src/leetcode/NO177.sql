DECLARE var int;
set vat = n - 1;

SELECT DISTINCT SALARY
from employeE
order by salary desc
limit (n-1),1

-- -- limit后面不能跟表达式