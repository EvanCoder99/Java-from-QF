#作业1
#1 查询2张表的数据，使用内连接和左外连接
#内连接
select * from teacher t,course c where t.tno = c.tno;
select * from teacher t inner join course c on t.tno=c.tno
#左外连接
select * from teacher t left join course c on t.tno=c.tno
#2 查询部门101和105部门所有员工工资，并按照降序排列
select salary from emp where dno in(101,105) order by salary desc;
#3 查询部门101和105所有员工工资，并且按照工资降序排列，如果部门中工资相同，则按照性别排列（女在前）
select * from emp where dno in(101,105) order by salary desc, esex;
#4 查询部门名称为主公的所有员 工信息
select * from emp where dno = (select dno from dept where dname='主公')
#5 查询102部门的所有员工人数
select * from emp where dno = 102
#6 查询105部门的平均工资
select avg(salary) from emp where dno = 105
#7 查询103部门中工资最高的和最低的
select * from emp where salary=(select max(salary) from emp where dno = 103) and salary=(select min(salary) from emp where dno = 103) and dno = 103 
#8 查询每一个部门的工资总和并按照降序排列
select dno,sum(salary) from emp group by dno order by sum(salary) desc
#9 查询每一个部门的工资总和,要求只显示总工资大于90w的部门信息
select dno,sum(salary) from emp group by dno having sum(salary)>900000 order by sum(salary) desc

#作业2
#1、 查询Student表中的所有记录的Sname、Ssex和Class列。
select sname,ssex,class from Student
#2、 查询教师所有的单位即不重复的Depart列。
select distinct depart from teacher
#3、 查询Student表的所有记录。
select * from student
#4、 查询Score表中成绩在60到80之间的所有记录。
select * from score where degree between 60 and 80;
#5、 查询Score表中成绩为85，86或88的记录。
select * from score where degree in(85,86,88);
#6、 查询Student表中“95031”班或性别为“女”的同学记录。
select * from student where class = 95031 or ssex = '女'
#7、 以Class降序查询Student表的所有记录。
select * from student order by class desc;
#8、 以Cno升序、Degree降序查询Score表的所有记录。
select * from score order by sno,degree desc;
#9、 查询“95031”班的学生人数。
select count(*) from student where class = '95031'