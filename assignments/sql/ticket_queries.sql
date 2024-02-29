#ticket booking Case study 
use ticketbooking_feb_hex_24;
#insertions 
insert into venue(venue_name,address) values 
('mumbai', 'marol andheri(w)'),
('chennai', 'IT Park'),
('pondicherry ', 'state beach');

select * from venue;

insert into customer(customer_name,email,phone_number) 
values
('harry potter','harry@gmail.com','45454545'),
('ronald weasley','ron@gmail.com','45454545'),
('hermione granger','her@gmail.com','45454545'),
('draco malfoy','drac@gmail.com','45454545'),
('ginni weasley','ginni@gmail.com','45454545');

select * from customer; 

insert into event(event_name,event_date,event_time,total_seats,available_seats,ticket_price,event_type,venue_id)
values 
('Late Ms. Lata Mangeshkar Musical', '2021-09-12','20:00',320,270,600,'concert',3),
('CSK vs RCB', '2024-04-11','19:30',23000,3,3600,'sports',2),
('CSK vs RR', '2024-04-19','19:30',23000,10,3400,'sports',2),
('MI vs KKR', '2024-05-01','15:30',28000,100,8000,'sports',1);

select * from event; 

insert into booking values 
(4,1,2,640,'2021-09-12'),
(4,4,3,960,'2021-09-12'),
(5,1,3,10800,'2024-04-11'),
(5,3,5,18000,'2024-04-10'),
(6,5,10,34000,'2024-04-15'),
(7,2,4,32000,'2024-05-01');

#SQL Queries - Task 2

-- 2. Write a SQL query to list all Events.
select * from event; 

update event SET event_name='Conferece CUP' where id=7;

--  Write a SQL query to select events name partial match with ‘cup’.
select * 
from event
where event_name LIKE '%cup%';

/* Output: 
+----+---------------+------------+------------+-------------+-----------------+--------------+------------+----------+
| id | event_name    | event_date | event_time | total_seats | available_seats | ticket_price | event_type | venue_id |
+----+---------------+------------+------------+-------------+-----------------+--------------+------------+----------+
|  7 | Conferece CUP | 2024-05-01 | 15:30:00   |       28000 |             100 |         8000 | sports     |        1 |
+----+---------------+------------+------------+-------------+-----------------+--------------+------------+----------+
*/

-- Write a SQL query to retrieve events with dates falling within a specific range

select * 
from event
where event_date BETWEEN '2024-04-11' AND '2024-05-01';

/*
+----+---------------+------------+------------+-------------+-----------------+--------------+------------+----------+
| id | event_name    | event_date | event_time | total_seats | available_seats | ticket_price | event_type | venue_id |
+----+---------------+------------+------------+-------------+-----------------+--------------+------------+----------+
|  5 | CSK vs RCB    | 2024-04-11 | 19:30:00   |       23000 |               3 |         3600 | sports     |        2 |
|  6 | CSK vs RR     | 2024-04-19 | 19:30:00   |       23000 |              10 |         3400 | sports     |        2 |
|  7 | Conferece CUP | 2024-05-01 | 15:30:00   |       28000 |             100 |         8000 | sports     |        1 |
+----+---------------+------------+------------+-------------+-----------------+--------------+------------+----------+
*/

-- 8. Write a SQL query to retrieve customers in batches of 5, starting from the 6th user.

select * 
from customer
limit 3,2;

select * 
from customer
limit 5,5; #records 6-10

/* 
LIMIT <offset>,<number_of_records>
- offest is the record after which we start counting - so if offset is 3 we start from 4
- number_of_records given will be displayed  
*/

-- 10. Write a SQL query to retrieve customer information whose phone number end with ‘000’

select * 
from customer 
where phone_number LIKE '%000'; # ends number with 000 

-- Write a SQL query to retrieve the events in order whose seat capacity more than 15000.
select * 
from event
where total_seats > 15000
order by total_seats ASC ; 

-- 12. Write a SQL query to select events name not start with ‘x’, ‘y’, ‘z’

select * 
from event
where event_name NOT LIKE 'c%' AND event_name NOT LIKE 'x%'; 


#Level 2: Multi Table Queries using Manual Mapping Technique 

-- display list of events hosted by venue 'chennai'.

select e.id,e.event_name,e.event_date,e.event_time,e.total_seats
from event e,venue v
where v.id = e.venue_id AND v.venue_name='chennai';

-- select customers that have booked tickes for event 'csk v rcb'  game with id=5; 

select c.customer_name,email,phone_number
from customer c, booking b
where c.id = b.customer_id AND b.event_id=5;

-- display event details that have booking num_tickets > 1000

select b.event_id,b.num_tickets
from event e , booking b
where e.id = b.event_id AND b.num_tickets > 5;


/* 
	Display the names of venues visited by customer with email 'harry@gmail.com'
*/

select v.venue_name,v.address,c.customer_name
from venue v,booking b,event e,customer c
where v.id=e.venue_id AND 
e.id = b.event_id AND 
b.customer_id = c.id AND 
c.email='harry@gmail.com';

/* 
. Write a SQL query to List Venues and Their Average Ticket Prices.
-  Write a SQL query to calculate the average Ticket Price for Events in Each Venue.
*/

select e.venue_id,v.venue_name,AVG(e.ticket_price ) 
from event e, venue v
where v.id = e.venue_id
group by e.venue_id;

#note: We can join multiple tables like venue and fetch extra info from there like venue_name. 

/* 
	Write a SQL query to Calculate the Total Revenue Generated by Events.
*/

select SUM((total_seats  - available_seats) *  ticket_price) #We can perform arithmetic ops in select statement
from event;

/* 
	Write a SQL query to find the event with the highest ticket sales
*/

select event_name,MAX((total_seats  - available_seats) *  ticket_price) as total_sales
from event
group by event_name
order by total_sales DESC
limit 0,1;

/*
Write a SQL query to Calculate the Total Number of Tickets Sold for Each Event.
*/

select event_name, total_seats  - available_seats as total_tickets_sold
from event 
group by event_name;

/* 
. Write a SQL query to Find Events with No Ticket Sales.
*/

/* 
Write a SQL query to Find the Customer Who Has Booked the Most Tickets.
*/

#plan: first, find the tickets booked by each customer. then find the most 

select customer_name, SUM(b.num_tickets) as tickets_booked 
from booking b, customer c
where b.customer_id = c.id
group by customer_name
order by tickets_booked DESC
limit 0,1;

/*
	Write a SQL query to calculate the total Number of Tickets Sold for Each Event Typ
*/

/*
	 Write a SQL query to list customer who have booked tickets for multiple events.
*/

#plan- first display all customer_name and event_name with seats booked and then
#step 2: I will find those customers who have booked for multiple events

select e.event_name, c.customer_name, b.num_tickets
from event e,customer c, booking b
where e.id = b.event_id AND 
b.customer_id = c.id; 

/* 
+----------------------------------+------------------+-------------+
| event_name                       | customer_name    | num_tickets |
+----------------------------------+------------------+-------------+
| Late Ms. Lata Mangeshkar Musical | harry potter     |           2 |
| CSK vs RCB                       | harry potter     |           3 |
| Conferece CUP                    | ronald weasley   |           4 |
| CSK vs RCB                       | hermione granger |           5 |
| Late Ms. Lata Mangeshkar Musical | draco malfoy     |           3 |
| CSK vs RR                        | ginni weasley    |          10 |
+----------------------------------+------------------+-------------+
*/
# step 2: I vl group by customer_name to get info of number_of events booked. 

select c.customer_name , count(c.id) as events_booked
from event e,customer c, booking b
where e.id = b.event_id AND 
b.customer_id = c.id
group by c.customer_name ;
 
 /*
 customer_name = harry potter
| Late Ms. Lata Mangeshkar Musical | harry potter     |           2 |
| CSK vs RCB                       | harry potter     |           3 |

 customer_name = ronald weasley
| Conferece CUP                    | ronald weasley   |           4 |

customer_name = hermione granger 
| CSK vs RCB                       | hermione granger |           5 |

customer_name = draco malfoy  
| Late Ms. Lata Mangeshkar Musical | draco malfoy     |           3 |

customer_name = ginni weasley  
| CSK vs RR                        | ginni weasley    |          10 |

+------------------+---------------+
| customer_name    | events_booked |
+------------------+---------------+
| draco malfoy     |             1 |
| ginni weasley    |             1 |
| harry potter     |             2 |
| hermione granger |             1 |
| ronald weasley   |             1 |
+------------------+---------------+
 */
 
 #now I vl display the records that have events_booked>1
 select c.customer_name , count(c.id) as events_booked
from event e,customer c, booking b
where e.id = b.event_id AND 
b.customer_id = c.id
group by c.customer_name 
having events_booked>1;

-- having events_booked>1;

/* 
 | harry potter     |             2 |
*/
# JOIN Queries 

/*
Write a SQL query to calculate the Total Revenue Generated by Events for Each Customer

Sample O/P: 
Customer	   Revenue
Harry Potter   23000  
Ronald Weasley 4500
*/


use ticketbooking_feb_hex_24;


-- step 1: Join and bring the tables togather. 
select * 
from  event e  JOIN booking b  ON e.id = b.event_id JOIN  customer c ON c.id = b.customer_id;

-- step 2: group by customer name as we need to compute revenue for each customer which will
-- give customer_name and number of bookings 

select c.customer_name, count(c.id) as Number_Of_bookings
from  event e  JOIN booking b  ON e.id = b.event_id JOIN  customer c ON c.id = b.customer_id
group by c.customer_name;

-- Step 3: We need to calculate sum of total couse for each customer, so updating above query 
select c.customer_name as Customer_Name, sum(b.total_cost) as Revenue
from  event e  JOIN booking b  ON e.id = b.event_id JOIN  customer c ON c.id = b.customer_id
group by c.customer_name
order by Revenue DESC;

/* 
o/p:
+------------------+---------+
| Customer_Name    | Revenue |
+------------------+---------+
| ginni weasley    |   34000 |
| ronald weasley   |   32000 |
| hermione granger |   18000 |
| harry potter     |   11440 |
| draco malfoy     |     960 |
+------------------+---------+
*/

-- 14. Write a SQL query to list Users and the Total Number of Tickets They've Purchased in the 
 -- Last 30 Days.
 
select c.customer_name, SUM(b.num_tickets) as Number_Of_tickets
from  event e  JOIN booking b  ON e.id = b.event_id JOIN  customer c ON c.id = b.customer_id
where b.booking_date between DATE_SUB('2024-04-30',INTERVAL 30 DAY) and  '2024-04-30'
group by c.customer_name;

-- now() gives todays date 
 








