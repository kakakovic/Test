SELECT s1.*
FROM stadium AS s1, stadium AS s2, stadium as s3
WHERE
(
  (s1.id + 1 = s2.id AND s1.id + 2 = s3.id)
  OR
  (s1.id - 1 = s2.id AND s1.id + 1 = s3.id)
  OR
  (s1.id - 2 = s2.id AND s1.id - 1 = s3.id)
)
AND s1.people>=100
AND s2.people>=100
AND s3.people>=100

GROUP BY s1.id

-- 先用笛卡尔积列出所有组合，然后做隐式连接操作，再做业务逻辑过滤
-- 这块如果用显示连接，需要把三个单独的结果取并
-- group by的结果如果所有行都一样也可以直接select