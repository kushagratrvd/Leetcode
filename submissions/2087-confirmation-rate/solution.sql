select s.user_id, round( avg(
    case
        when c1.action = 'confirmed' then 1
        else 0
    end),
    2) as confirmation_rate  
from signups as s
left join confirmations as c1 on s.user_id = c1.user_id
group by s.user_id
