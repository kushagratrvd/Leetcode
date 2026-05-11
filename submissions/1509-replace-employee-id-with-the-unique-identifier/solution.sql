-- Write your PostgreSQL query statement below
select unique_id, name from EmployeeUNI as e1 right join Employees as e2 on e2.id = e1.id
