create database sms;
use sms;

-- 1
create table customers (
customer_id int auto_increment primary key,
customer_name varchar(255) not null
);
-- 2
create table employees(
employee_id int auto_increment primary key,
employee_name varchar(255) not null,
salary decimal(10,2) not null,
supervisor_id int,
foreign key (supervisor_id) references employees(employee_id)
);
-- 3
create table products(
product_id int auto_increment primary key,
product_name varchar(255) not null,
list_price decimal(10,2) not null
);

-- 4
create table orders(
order_id int auto_increment primary key,
order_date datetime not null,
customer_id int not null,
employee_id int not null,
total decimal(10,2) ,

foreign key (customer_id) references customers(customer_id),
foreign key (employee_id) references employees(employee_id)
);
-- 5
create table line_items(
order_id int not null ,
product_id int not null ,
quantity int not null,
price decimal(10,2),

foreign key (order_id) references orders(order_id),
foreign key (product_id) references products(product_id)
);

-- table test
-- 1 customers table
INSERT INTO customers(customer_name)
VALUES
('Debra Burks'),
('Kashla Todd'),
('Tameka Fisher'),
('Daryl Spence'),
('Charlotte Rice');

-- 2 employees 
INSERT INTO employees (employee_id, employee_name, salary, supervisor_id)
VALUES
(1, 'Fabiola Jackson', 1000, NULL),
(2, 'Mireya Copeland', 600, 1),
(3, 'Gennie Serrano', 300, 2),
(4, 'Virgie Wiggins', 400, 2),
(5, 'Jannette David', 500, 1);
-- 3 product 
insert into products (product_id, product_name,list_price)
values
(1, 'Trek 820 - 2016', 379.99),
(2, 'Ritchey Timberwolf Frameset - 2016', 749.99),
(3, 'Surly Wednesday Frameset - 2016', 999.99),
(4, 'Trek Fuel EX 8 29 - 2016', 2899.99),
(5, 'Heller Shagamaw Frame - 2016', 1320.99),
(6, 'Surly Ice Cream Truck Frameset - 2016', 469.99),
(7, 'Trek Slash 8 27.5 - 2016', 3999.99),
(8, 'Trek Remedy 29 Carbon Frameset - 2016', 1799.99),
(9, 'Trek Conduit+ - 2016', 2999.99),
(10, 'Surly Straggler - 2016', 1549.00);

-- 4 orders table

INSERT INTO orders (order_id, customer_id, order_date, employee_id, total)
VALUES
(1, 1, '2016-01-01', 2,null),
(2, 2, '2016-01-01', 5,null),
(3, 3, '2016-01-02', 5,null),
(4, 4, '2016-01-03', 3,null),
(5, 5, '2016-01-03', 4,null);

-- 5 line items
INSERT INTO line_items (order_id, product_id, quantity, price)
VALUES
(1, 10, 1, null),
(1, 8, 2, null),
(1, 10, 2, null),
(1, 10, 2, null),
(1, 4, 1, null),
(2, 10, 1, null),
(2, 10, 2, null),
(3, 3, 1, null),
(3, 10, 1, null),
(4, 2, 2, null);


select @@sql_safe_updates;
set sql_safe_updates = 0; -- cap nhat để set price

update line_items left join products
	on line_items.product_id = products.product_id
set price = line_items.quantity*products.list_price
where line_items.product_id is not null
	and line_items.order_id is not null;
-- -----------------------    


-- Functions, Stored Procedures and Triggers 
-- q1 
select customers.customer_id, customer_name
from customers inner join orders
	on customers.customer_id =  orders.customer_id;

-- q2
drop procedure if exists list_order_given_a_customer;
delimiter $$
create procedure list_order_given_a_customer(in p_customer_id int)
begin
select order_id, order_date, customer_id, employee_id, total
from orders
where orders.customer_id = p_customer_id;
end $$
delimiter ;

call list_order_given_a_customer(1);

-- update q2
select order_id, order_date, customer_id, employee_id, total
from orders;

-- q3
drop procedure if exists list_items_for_an_order;
delimiter $$
create procedure list_items_for_an_order(in p_order_id int)
begin
select *
from orders
where orders.order_id = p_order_id;
end $$
delimiter ;

call list_items_for_an_order(1);
-- update q3
select *
from orders;

-- q4 function
drop function if exists total_order;
delimiter $$
create function total_order( p_order_id int)
returns decimal(10,2)
reads sql data
begin
		declare v_total decimal(10,2);
        
        select sum(quantity*price) into v_total
        from line_items
        where order_id = p_order_id;
        
        return v_total;
        
end $$
delimiter ;

-- q5 procedure
drop procedure if exists sp_insert_customer;
delimiter $$
create procedure sp_insert_customer(in p_customer_name varchar(255))
begin
	insert into customers (customer_name) values (p_customer_name);
end $$
delimiter ;

call sp_insert_customer('MT Quyen 2');

-- q6 
-- 3 procedure 
-- 1 xoa line items
-- 2 xoa order
-- 3 xoa customer 

-- test
drop procedure if exists sp_delete_customer;

delimiter $$
create procedure sp_delete_customer(in p_customer_id int)
begin
	delete line_items from line_items inner join orders 
        on orders.order_id = line_items.order_id
		where customer_id = p_customer_id;

    delete orders from orders
		where customer_id = p_customer_id;

    delete from customers
		where customer_id = p_customer_id;
end $$
delimiter ;

-- q7 
drop procedure if exists update_customer;

delimiter $$
create procedure update_customer(in p_customer_id int,in p_customer_name varchar(255))
begin
    update customers
    set customer_name = p_customer_name
    where customer_id = p_customer_id;
end $$
delimiter ;

-- q8 
drop procedure if exists create_order;

delimiter $$
create procedure create_order(in p_order_id int,in p_order_date datetime,in p_customer_id int,in p_employee_id int,in p_total decimal(10,2))
begin
    insert into orders (order_id,order_date,customer_id,employee_id,total)
    value (p_order_id,p_order_date,p_customer_id,p_employee_id,p_total);
end $$
delimiter ;
-- update q8
insert into orders(order_date,customer_id,employee_id)
		value ('2026-06-07',4,3);

-- q9 
drop procedure if exists create_line_item;

delimiter $$
create procedure create_line_item(in p_order_id int,in p_product_id int,in p_quantity int,in p_price decimal(10,2))
begin
    insert into line_items(order_id,product_id,quantity,price)
    values(p_order_id,p_product_id,p_quantity,p_price);
end $$
delimiter ;

-- update q9
insert into line_items(order_id,product_id,quantity,price)
    value(6, 5,5,null);


-- q10 
drop procedure if exists update_order_total;

delimiter $$
create procedure update_order_total(in p_order_id int,in p_total decimal(10,2))
begin
    update orders
    set total = p_total
    where order_id = p_order_id;
end $$
delimiter ;

-- update q10
-- set total in order

update orders
set total = total_order(order_id)
where order_id > 0;











