-- Write your PostgreSQL query statement below
with q2 as (select query_name, count(query_name) as total from queries group by query_name)

select q1.query_name,
 round(sum(q1.rating::decimal/q1.position)/q2.total, 2) as quality, 
 round(count(CASE WHEN q1.rating < 3 THEN 1 END)*100.0/q2.total, 2) as poor_query_percentage 
 from queries q1 join q2 
 on q1.query_name = q2.query_name
group by q1.query_name, q2.total

