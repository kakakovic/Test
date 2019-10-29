找一个学生成绩最好的三门课
select * from
(select t.*, row_number over (partition by 用户名 order by 成绩 desc) as flag from t)
where flag <= 3
