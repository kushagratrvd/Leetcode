# Write your MySQL query statement below
select s.user_id, round( avg(if(c1.action = 'confirmed', 1, 0)), 2) as confirmation_rate  
from signups as s
left join confirmations as c1 on s.user_id = c1.user_id
group by s.user_id
