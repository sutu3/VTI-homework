use testing_system_assignment_1;
select * from department;
select DepartmentID
 from department
where Departmentname like 'sale';

select FullName
from account
where Length(FullName)=(
select Max(length(FullName))
from account
);
select FullName
from account
where PositionID=3 AND Length(FullName)=(
select Max(Length(FullName))
from account
);
select CreateDate
from account
where CreateDate>'2022-10-01';
select count(*) as SLnhanvienid2
from account
where AccountID=2;
select UserName
from account
where UserName LIKE 'D%' And UserName LIKE '%o';
delete 
from account
where cast(account.CreateDate as date)  >'2022-12-20';
update account
set account.AccountID=5, account.Email='loc.nguyenba@vti.com.vn',account.UserName='Loc',account.FullName='Nguyen Ba Loc', account.DepartmentID=6,account.PositionID=2,account.CreateDate='2022-06-01'
where account.AccountID=3;
select *
from account
order by DepartmentID asc;

update account
set account.AccountID=6
where account.AccountID=5;
insert into account(account.AccountID,account.Email,account.UserName,account.FullName,account.DepartmentID,account.PositionID,account.CreateDate)
value (5,'minh12345@gmail.com','Huy','Le Huy',1,8,'2019-5-20')