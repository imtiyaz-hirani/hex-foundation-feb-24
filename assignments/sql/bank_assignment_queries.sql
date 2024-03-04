use bank_hex_feb_24;
show tables;

insert into customer(first_name,last_name,dob) values 
('harry','potter','2002-03-21'),
('ronald','weasley','2001-02-10'),
('hermione','granger','2002-11-15');

/* 
+----+------------+-----------+------------+
| id | first_name | last_name | dob        |
+----+------------+-----------+------------+
|  1 | harry      | potter    | 2002-03-21 |
|  2 | ronald     | weasley   | 2001-02-10 |
|  3 | hermione   | granger   | 2002-11-15 |
+----+------------+-----------+------------+
*/

insert into account(account_type,balance,customer_id) values 
('savings',50000,1) ,
('current',120000,2) ,
('zero_balance',100000,3),
('current',150000,1) ,
('savings',30000,3);

/* 
+----+--------------+---------+-------------+
| id | account_type | balance | customer_id |
+----+--------------+---------+-------------+
|  1 | savings      |   50000 |           1 |
|  2 | current      |  120000 |           2 |
|  3 | zero_balance |  100000 |           3 |
|  4 | current      |  150000 |           1 |
|  5 | savings      |   30000 |           3 |
+----+--------------+---------+-------------+
*/

insert into transaction(transaction_type,amount,transaction_date,account_id) 
values 
('deposit', 10000, '2024-02-01',1),
('withdrawal', 5000, '2024-02-02',1),
('deposit', 20000, '2024-02-02',2),
('withdrawal', 8000, '2024-02-02',3),
('transfer', 20000, '2024-02-01',4),
('transfer', 7000, '2024-02-05',5);

/* 
+----+------------------+--------+------------------+------------+
| id | transaction_type | amount | transaction_date | account_id |
+----+------------------+--------+------------------+------------+
|  1 | deposit          |  10000 | 2024-02-01       |          1 |
|  2 | withdrawal       |   5000 | 2024-02-02       |          1 |
|  3 | deposit          |  20000 | 2024-02-02       |          2 |
|  4 | withdrawal       |   8000 | 2024-02-02       |          3 |
|  5 | transfer         |  20000 | 2024-02-01       |          4 |
|  6 | transfer         |   7000 | 2024-02-05       |          5 |
+----+------------------+--------+------------------+------------+
*/
-- Task 2
/* 
2. Write SQL queries for the following tasks:
1. Write a SQL query to retrieve the name, account type and email of all customers. 
2. Write a SQL query to list all transaction corresponding customer.
3. Write a SQL query to increase the balance of a specific account by a certain amount.
4. Write a SQL query to Combine first and last names of customers as a full_name.
5. Write a SQL query to remove accounts with a balance of zero where the account 
type is savings.
6. Write a SQL query to Find customers living in a specific city.
7. Write a SQL query to Get the account balance for a specific account.
8. Write a SQL query to List all current accounts with a balance greater than $1,000.
9. Write a SQL query to Retrieve all transactions for a specific account.
10. Write a SQL query to Calculate the interest accrued on savings accounts based on a 
given interest rate.
11. Write a SQL query to Identify accounts where the balance is less than a specified 
overdraft limit.
12. Write a SQL query to Find customers not living in a specific city.
*/

-- Task 3
/* 1. Write a SQL query to Find the average account balance for all customers.  */

select customer_id, AVG(balance)
from account 
group by customer_id; 

/* 
O/P:
+-------------+--------------+
| customer_id | AVG(balance) |
+-------------+--------------+
|           1 |       100000 |
|           2 |       120000 |
|           3 |        65000 |
+-------------+--------------+
*/

/* 
2. Write a SQL query to Retrieve the top 10 highest account balances.
*/
select balance 
from account
order by balance DESC
limit 0,3; 

/* 3. Write a SQL query to Calculate Total Deposits for All Customers in specific date. Also display name of the customer  */

select c.first_name,c.last_name,t.transaction_type, t.amount, t.transaction_date
from transaction t JOIN account a ON a.id = t.account_id JOIN customer c ON c.id = a.customer_id
where t.transaction_date = '2024-02-02' AND t.transaction_type='withdrawal';

/* 4. Write a SQL query to Find the Oldest and Newest Customers. */

(select first_name,dob,'oldest' as status from customer order by dob limit 0,1)
UNION
(select first_name,dob,'youngest' as status from customer order by dob DESC limit 0,1);

/* 
O/P: 
+------------+------------+----------+
| first_name | dob        | status   |
+------------+------------+----------+
| ronald     | 2001-02-10 | oldest   |
| hermione   | 2002-11-15 | youngest |
+------------+------------+----------+
*/

/* 
5. Write a SQL query to Retrieve transaction details along with the account type.
*/

/* 
6. Write a SQL query to Get a list of customers along with their account details.
*/

/* 
7. Write a SQL query to Retrieve transaction details along with customer information for a 
specific account.
*/

/* 
8. Write a SQL query to Identify customers who have more than one account.
*/

select c.first_name,count(c.id) as Number_of_accounts
from customer c JOIN account a ON c.id = a.customer_id
-- where count(c.id) > 1 - 0	Invalid use of group function 
group by a.customer_id
having Number_of_accounts>1;

/* 
a.customer_id=1 (2)
	1	harry	potter	2002-03-21	1	savings	50000	1
	1	harry	potter	2002-03-21	4	current	150000	1
a.customer_id=2 (1)
	2	ronald	weasley	2001-02-10	2	current	120000	2
a.customer_id=3 (2)
	3	hermione	granger	2002-11-15	3	zero_balance	100000	3
	3	hermione	granger	2002-11-15	5	savings	30000	3
*/

/* 
9. Write a SQL query to Calculate the difference in transaction amounts between deposits and 
withdrawals.

*/
select MAX(amount) - MIN(amount) as difference
from
((select transaction_type ,SUM(amount) as amount, 'deposit' as op
from transaction
where transaction_type ='deposit' ) 
union
(select transaction_type , SUM(amount) as amount, 'withdrawal' as op
from transaction
where transaction_type ='withdrawal')) AS T;

/* 
We find deposit amount using 1 query 
and withdrawal amount using another query. 

then we bring the result togather in a Derived table called as T. 

T
--
30K
13K 

from this T(which is a table in itself) we compute MAX and MIN and do the arithmetic and get the result 
*/

-- alternatively 
select 
((select SUM(amount) 
from transaction
where transaction_type ='deposit' ) -  (select  SUM(amount) 
from transaction
where transaction_type ='withdrawal')) as diff;

/* 
10. Write a SQL query to Calculate the average daily balance for each account over a specified 
period.
11. Calculate the total balance for each account type.
12. Identify accounts with the highest number of transactions order by descending order.
13. List customers with high aggregate account balances, along with their account types.
14. Identify and list duplicate transactions based on transaction amount, date, and account
*/

use bank_hex_feb_24;
-- Task 4: Sub query
/* 
	2. Calculate the average account balance for customers who have more than one account.
*/

-- find customers having more than 1 account 

select customer_id    
from account
group by customer_id
having count(id) > 1; -- (1,3) 

-- find avg account balance for all customers 
select avg(balance)
from account; 

-- for specific customer from above query
select avg(balance)
from account
where customer_id IN (select customer_id    
					  from account
					  group by customer_id
					  having count(id) > 1);

/*
avg(balance)
'82500'
*/

/* 
10. Calculate the total balance for each account type, including a subquery within the SELECT
clause.
*/

--  In Select, we can do arithmetic operations. If sub query returns multiple rows then it cannot be written in select. 
 
 
 select account_type, SUM(balance) as total_balance
from account
group by account_type;
 
/* 
	account_type	total_balance
	current			270000
	savings			80000
	zero_balance	100000
*/

/* 9. Retrieve all transactions for a customer with a given customer_id. */

-- S1: fetch all account_id for a given customer 
select id
from account
where customer_id=1;
 
-- S2: fetch all transactions for accounts from step 1 
select * 
from transaction 
where account_id IN (select id
					 from account
					 where customer_id=1);
                     
/* 
	1	deposit	10000	2024-02-01	1
	2	withdrawal	5000	2024-02-02	1
	5	transfer	20000	2024-02-01	4
*/                     

/* 
4. Identify customers who have no recorded transactions.
*/
select id,first_name
from customer
where id IN (select customer_id from account where id NOT IN (select account_id from transaction));

insert into customer(first_name,last_name,dob) values ('draco','malfoy','2000-05-06');
insert into account(account_type,balance,customer_id) values ('zero_balance',40000,4);
select * from customer;
select * from account; 

-- troubleshooting 
select distinct account_id from transaction; -- (1,2,3,4,5)
select customer_id from account where id NOT IN (1,2,3,4,5); -- (6)
select * from customer where id IN (4);


/* 
Tasks 4: Subquery and its type:
1. Retrieve the customer(s) with the highest account balance.
2. Calculate the average account balance for customers who have more than one account.
3. Retrieve accounts with transactions whose amounts exceed the average transaction amount.
4. Identify customers who have no recorded transactions.
5. Calculate the total balance of accounts with no recorded transactions.
6. Retrieve transactions for accounts with the lowest balance.
7. Identify customers who have accounts of multiple types.
8. Calculate the percentage of each account type out of the total number of accounts.
9. Retrieve all transactions for a customer with a given customer_id.
10. Calculate the total balance for each account type, including a subquery within the SELECT
clause.
*/

