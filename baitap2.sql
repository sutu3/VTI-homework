use lesson4;
select employee.Employee_Number,employee.Employee_Name
from employee inner join employee_skill on employee.Employee_Number=employee_skill.Employee_Number
where employee_skill.Skill_Code like 'react';
select Department_name
from employee as e left join department as a on e.Department_number=a.Department_number
group by Department_name
having count(Department_name)>2;
select Department_Name
from employee as e left join department as d on e.Department_number=d.Department_number
group by Department_Name;
select distinct Department_name
from employee as e left join department as d on e.Department_number=d.Department_number