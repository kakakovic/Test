select d.name as department, e.name as employee, e.salary
from department as d inner join employee as e on  e.departmentId = d.id
where
(
    Select count(distinct salary)
    from employee tmp
    where tmp.departmentId = d.id and tmp.salary > e.Salary
) <= 2