#Create a DB 
create database hexfeb2024;
show databases; #shows all created DBs 
use hexfeb2024; #selecting the DB for further ops

show tables; #shows all the tables 

#Create a Table 
create table student
(id int primary key auto_increment,
name varchar(255)  NOT NULL ,
email varchar(255) NOT NULL,
college varchar(255),
city varchar(255) default 'chennai',
branch varchar(255)); 

#NOT NULL is a constraint which makes the field mandatory 

describe student; #-- shows the structure of the entire table with columns  

drop table student; #-- drops the table 

#Insert sample data in it 
#single record insert 
insert into student(name,email,college,city,branch) 
	values ('harry potter','harry@gmail.com','hogwards','mumbai','CMPN');

insert into student(name,email,college,branch) 
	values ('ronald weasley','ronald@gmail.com','hogwards','CMPN');
    
insert into student(name,email,college,branch) 
	values (null,'hermione@gmail.com','hogwards','CMPN'); #--name cannot be null as the constraint NOT NULL is defined 

#multiple inserts 
insert into student(name,email,college,city,branch) 
	values ('hermione granger','hermione@gmail.com','hogwards','mumbai','CMPN') ,
    ('neville longbottom','neville@gmail.com','kingston','delhi','IT'),
    ('draco malfoy','draco@gmail.com','kingston','delhi','CMPN');
    
    
#work with some queries 
select * from student; 
delete from student where id=3;  # deletes record with id=3 

select * from student where college='hogwards'; #displays all records that have college=hogwards

#displays all records that have college=hogwards and city=mumbai -- both condition must be true for AND 
select * from student where college='hogwards' AND city='mumbai';

#displays all records that have (college=hogwards and city=mumbai) OR could be from IT branch 
-- any one condition must be true for OR 

select * from student where (college='hogwards' AND city='mumbai') OR branch='IT';

#display all recrods that belong to following list of cities 
select * from student where city IN ('mumbai','delhi');
-- whenever you have to fetch records where a list of values in given to u, always use IN. 
-- inverse of IN is NOT IN which works similar to IN. 
select * from student where city NOT IN ('mumbai');

#Work with grouping ops 

/* 
Q. Display number of students from each city having students more than 1. print largest first. 

Sample Output:- 
mumbai 	2
chennai 1
*/

select city,count(id) as number_of_students
from student 
group by city;

/* 
city='mumbai'
|  1 | harry potter       | harry@gmail.com    | hogwards | mumbai  | CMPN   |
|  4 | hermione granger   | hermione@gmail.com | hogwards | mumbai  | CMPN   |

city='chennai'
|  2 | ronald weasley     | ronald@gmail.com   | hogwards | chennai | CMPN   |

city='delhi'
|  5 | neville longbottom | neville@gmail.com  | kingston | delhi   | IT     |
|  6 | draco malfoy       | draco@gmail.com    | kingston | delhi   | CMPN   |
*/

select city,count(id) as number_of_students
from student 
-- where count(id) > 1 -- cannot use grouping function in where clause as grouping happens after where..  
group by city
having number_of_students>1
order by number_of_students DESC; #this will order the result set in descending order- default is ASC 

#working with employee table 

create table employee
(id int primary key auto_increment, 
name varchar(255) NOT NULL, 
city varchar(255) default 'chennai', 
salary double default 0, 
date_of_joining date,
department varchar(255) not null,
manager_id int);

describe employee;

#inserts 
insert into employee(name,city,salary,date_of_joining,department,manager_id)
values ('albus dumbledore', 'chennai',340000,'1999-03-21','IT',null);

insert into employee(name,city,salary,date_of_joining,department,manager_id)
values ('severus snape', 'bangalore',230000,'2004-02-01','Management',1);

insert into employee(name,city,salary,date_of_joining,department,manager_id)
values 
('harry potter', 'mumbai' , 90000, '2023-03-01','IT',1),
('ronald weasley', 'chennai' , 78000, '2023-03-10','TESTING',1),
('hermione granger', 'mumbai' , 95000, '2023-01-01','Management',1);

insert into employee(name,city,salary,date_of_joining,department,manager_id)
values 
('draco malfoy', 'bangalore' , 88000, '2023-01-01','Management',5);

#update the record 
#update the manager of hermione(id=4) from 'albus dumbledore(id=1)' to 'severus snape(id=5)'

/* 
update <table_name>
SET <column> = <new_value>
where <condition>
*/
update employee
SET manager_id = 5
WHERE id=4; 

/* 
|  4 | hermione granger | mumbai    |  95000 | 2023-01-01      | Management |          1 |

|  4 | hermione granger | mumbai    |  95000 | 2023-01-01      | Management |          5 |
*/

#Q1. Display all employees who have joined in the year 2023.
-- 2023-01-01 to 2023-12-31

select *
from employee 
where date_of_joining >= '2023-01-01' AND date_of_joining < '2023-12-31';

-- alternatively, 
select *
from employee 
where date_of_joining BETWEEN '2023-01-01' AND '2023-12-31';
-- Note: dates are supposed to be passed as strings(''). DB manager will convert it into appropriate
-- date value and perform operation. 

#Q2. Display list of employee who are earning more than 80000 and less than 90000. 
select *
from employee
where salary BETWEEN 80000 and 90000
ORDER BY salary ASC; 

# Searching with LIKE 
-- search the records on the basis of name of the employee 

select * 
from employee 
where name LIKE '%harry%';

-- note: % operators are to ensure than the given string is searched anywhere in the actual value. 

# Display number of employees that are managed by each manager 
/* 
Manager_ID 	Number_of_Employees
1		 		34
*/

select  manager_id as Manager_ID, count(id) as Number_of_Employees  
from employee
where manager_id IS NOT null
group by manager_id;
