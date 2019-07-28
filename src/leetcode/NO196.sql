delete
from person
where id not in
(
    select id
    from
    (
        select min(id) as id
        from person
        group by email
    ) as tmp
)

-- 不能在查询表的过程中更新表，所以需要引入临时表