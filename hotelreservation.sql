use hotelreservation;

-- insert into customer (first_name, last_name) values ('James', 'Bond');
-- insert into customer (first_name, last_name) values ('Gan', 'Nina');
-- insert into customer (first_name, last_name) values ('Sian Loong', 'Li');
-- insert into customer (first_name, last_name) values ('Nima', 'Cao');
-- insert into customer (first_name, last_name) values ('Pay', 'Me');

-- insert into room (room_type, price) values ('standard', 100);
-- insert into room (room_type, price) values ('deluxe', 150);
-- insert into room (room_type, price) values ('president', 200);
-- insert into room (room_type, price) values ('suite', 500);

-- insert into reservation (customer_id, room_id, start_date, end_date, total_cost) 
-- values (2, 3, '2023-02-01','2023-02-03', 200);
-- insert into reservation (customer_id, room_id, start_date, end_date, total_cost) 
-- values (3, 1, '2023-01-21','2023-02-15', 1500);
-- insert into reservation (customer_id, room_id, start_date, end_date, total_cost) 
-- values (4, 1, '2023-02-01','2023-02-05', 100);
-- insert into reservation (customer_id, room_id, start_date, end_date, total_cost) 
-- values (5, 2, '2023-02-04','2023-02-09', 300);

/*
select resv.id resv_id, cust.id cust_id, cust.first_name, cust.last_name, resv.start_date, resv.end_date, resv.total_cost, room.price, room.room_type
from customer cust
inner join reservation resv
on cust.id = resv.customer_id
inner join room 
on resv.room_id = room.id
order by start_date;
*/
/*
insert into reservation (customer_id, room_id, start_date, end_date, total_cost) 
values (1, 1, '2023-03-01','2023-03-03', 200);
insert into reservation (customer_id, room_id, start_date, end_date, total_cost) 
values (2, 2, '2023-02-21','2023-03-15', 1500);
insert into reservation (customer_id, room_id, start_date, end_date, total_cost) 
values (3, 3, '2023-03-01','2023-03-05', 100);
insert into reservation (customer_id, room_id, start_date, end_date, total_cost) 
values (4, 4, '2023-03-04','2023-03-05', 300);
insert into reservation (customer_id, room_id, start_date, end_date, total_cost) 
values (5, 1, '2023-03-01','2023-03-07', 200);
insert into reservation (customer_id, room_id, start_date, end_date, total_cost) 
values (1, 2, '2023-02-21','2023-03-15', 1500);
insert into reservation (customer_id, room_id, start_date, end_date, total_cost) 
values (2, 3, '2023-03-01','2023-03-12', 100);
insert into reservation (customer_id, room_id, start_date, end_date, total_cost) 
values (3, 4, '2023-03-08','2023-03-09', 300);
*/
/*
select 'Feb 2023' as period, room_id, count(*) cnt 
from reservation
where start_date between '2023-02-01' and '2023-02-29'
group by room_id
union
select 'Mar 2023' as period, room_id, count(*) cnt 
from reservation
where start_date between '2023-03-01' and '2023-03-31'
group by room_id;
*/
/*
select 'Feb 2023' as period, room_id, count(*) as cnt
from reservation
where start_date >= '2023-02-01' and start_date <= '2023-02-28'
group by room_id
union
select 'Mar 2023' as period, room_id, count(*) cnt 
from reservation
where start_date between '2023-03-01' and '2023-03-31'
group by room_id
having cnt > 1;
*/
/*
insert into customer(first_name, last_name) values ('Desmond','Koh');
insert into customer(first_name, last_name) values ('Pei Ling','Tin');
insert into customer(first_name, last_name) values ('Nicole','Seah');
insert into customer(first_name, last_name) values ('Bong','Moonga');
insert into customer(first_name, last_name) values ('Pang','Jamie');
insert into customer(first_name, last_name) values ('Ang','Felicia');
*/


/*create table customer2 as select * from customer;
*/
/*
update customer2
set first_name = "Kuan Yew",
last_name = "Lee"
where id=9;
*/
/*
insert into employee (first_name, last_name, salary) values ('Gary', 'Chao', 5000);
insert into employee (first_name, last_name, salary) values ('John', 'Lim', 6000);
insert into employee (first_name, last_name, salary) values ('Jason', 'Tan', 4500);

insert into dependent (employee_id, dependent_name, birthdate, relationship) values(1, 'Priscilla','1994-03-11','father');
insert into dependent (employee_id, dependent_name, birthdate, relationship) values(1, 'Prissy','1996-03-11','father');
insert into dependent (employee_id, dependent_name, birthdate, relationship) values(2, 'Apple','2000-06-11','mother');
insert into dependent (employee_id, dependent_name, birthdate, relationship) values(3, 'Min','2005-06-11','father');
*/

select e.id emp_id, e.first_name, e.last_name, e.salary, d.id dep_id, d.dependent_name dep_name, d.relationship, d.birthdate from employee e
inner join dependent d
on e.id = d.employee_id;





