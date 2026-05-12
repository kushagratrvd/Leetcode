-- Write your PostgreSQL query statement below
select result.name from ( select e1.name, e2.managerId, count(e2.managerId) as e3 from Employee e1
join Employee e2 on e1.id = e2.managerId 
group by e1.name, e2.managerId ) as result where result.e3 > 4 
