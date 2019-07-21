select
    a.score as score,
    (
        select count(distinct score)
        from scores as b
        where b.score >= a.score
    ) as rank
from scores as a
order by a.score desc