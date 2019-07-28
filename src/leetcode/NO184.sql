select a.name as department, b.name as employee, a.salary as salary
from
(
    select max(salary) as salary, d.id as id, d.name as name
    from employee as e inner join department as d on e.departmentID = d.id
    group by d.id, d.name
) as a inner join employee as b on a.id = b.departmentId
where a.salary = b.salary