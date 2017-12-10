/*
 * Write a SQL query to get the second highest salary from the Employee table.

+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
For example, given the above Employee table, the query should return 200 as the second highest salary. If there is no second highest salary, then the query should return null.

+---------------------+
| SecondHighestSalary |
+---------------------+
| 200                 |
+---------------------+
 * 
 * 
 * 
 * 
 * 代码示例: 
语句1：select * from student limit 9,4 
语句2：slect * from student limit 4 offset 9 
//语句1和2均返回表student的第10、11、12、13行   
//语句2中的4表示返回4行，9表示从表的第十行开始
例2，通过limit和offset或只通过limit可以实现分页功能。
假设numberperpage表示每页要显示的条数，pagenumber表示页码，那么返回第pagenumber页，每页条数为numberperpage的sql语句：
 

代码示例: 
语句3：select * from studnet limit (pagenumber-1)*numberperpage,numberperpage 
语句4：select * from student limit numberperpage offset (pagenumber-1)*numberperpage
 * 
 * 
 * 
 * 
 * */
select 
	ifnull(
	(select distinct Salary
	 from Employee
	 order by Salary desc
	 limit 1 offset 1
	)
	,null) as SecondHighestSalary
