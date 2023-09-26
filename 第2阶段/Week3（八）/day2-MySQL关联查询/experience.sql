#统计60、70、90号部门的最高工资
select * from t_employees GROUP BY DEPARTMENT_ID
select * from t_employees GROUP BY DEPARTMENT_ID HAVING department_id in (60,70,90)
select department_id,MAX(salary) from t_employees GROUP BY DEPARTMENT_ID HAVING department_id in (60,70,90)

#查询表中前五名员工的所有信息
select * from t_employees limit 0,5	
select * from t_employees limit 4,10

#子查询
#查询工资大于Bruce 的员工信息
select * from t_employees where salary >(select salary from t_employees where first_name='Bruce')

#查询与名为'King'同一部门的员工信息
select department_id from t_employees where last_name = 'King'
select * from t_employees where department_id in(select department_id from t_employees where last_name = 'King')

#工资高于60部门所有人的信息 
select salary from t_employees where department_id=60
select * from t_employees where salary > all(select salary from t_employees where department_id=60
)
select * from t_employees where salary > any(select salary from t_employees where department_id=60
)

#查询员工表中工资排名前 5 名的员工信息
select * from t_employees order by salary desc limit 0,5

#合并两张表的结果，去除重复记录

#内连接：
select * from t1,t2 where t1.id = t2.id2