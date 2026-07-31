drop database bikestores;
create database bikestores;
use bikestores;

-- table1
create table brands(
brand_id int primary key,
brand_name varchar(255)
);

-- table2
create table categories(
category_id int primary key,
category_name varchar(255)
);

-- table 3
create table customers(
customer_id int primary key,
first_name varchar(255),
last_name varchar(255),
phone varchar(25),
email varchar(255),
street varchar(255),
city varchar(50),
state varchar(25),
zip_code varchar(5)
);

-- table 4
create table stores(
store_id int primary key,
store_name varchar(255),
phone varchar(25),
email varchar(255),
street varchar(255),
city varchar(255),
state varchar(10),
zip_code varchar(5)
);
-- table5 
create table products(
product_id int primary key,
product_name varchar(255),
brand_id int,
category_id int,
model_year smallint,
list_price decimal(10,2),

foreign key (brand_id) references brands(brand_id),
foreign key (category_id) references categories(category_id)
);

-- table 6
create table staffs(
staff_id int primary key,
first_name varchar(255),
last_name varchar(255),
email varchar(255),
phone varchar(25),
active tinyint,
store_id int,
manager_id int,

foreign key (store_id ) references stores(store_id),
foreign key (manager_id) references staffs(staff_id)
);

-- table 7
create table orders(
order_id int primary key,
customer_id int,
order_status tinyint,
order_date date,
required_date date,
shipped_date date,
store_id int,
staff_id int,

foreign key (store_id) references stores(store_id),
foreign key (staff_id) references staffs(staff_id),
foreign key (customer_id) references customers(customer_id)
);

-- table8
create table stocks(
store_id int ,
product_id int ,
quantity int,

primary key (store_id,product_id),
foreign key (store_id) references stores(store_id),
foreign key (product_id) references products(product_id)
);


-- table 9
create table order_items(
order_id int ,
item_id int ,
product_id int,
quantity int,
list_price decimal(10,2),
discount decimal(4,2),

primary key (order_id,item_id),
foreign key (order_id) references orders(order_id),
foreign key (product_id) references products(product_id)
);


-- insert brands
INSERT INTO brands (brand_id, brand_name) VALUES
(1, 'Electra'),
(2, 'Haro'),
(3, 'Heller'),
(4, 'Pure Cycles'),
(5, 'Ritchey'),
(6, 'Strider'),
(7, 'Sun Bicycles'),
(8, 'Surly'),
(9, 'Trek');

-- insert categories
INSERT INTO categories (category_id, category_name) VALUES
(1, 'Children Bicycles'),
(2, 'Comfort Bicycles'),
(3, 'Cruisers Bicycles'),
(4, 'Cyclocross Bicycles'),
(5, 'Electric Bikes'),
(6, 'Mountain Bikes'),
(7, 'Road Bikes');

-- insert products
INSERT INTO products (product_id, product_name, brand_id, category_id, model_year, list_price)VALUES
(1, 'Trek 820 - 2016', 9, 6, 2016, 379.99),
(2, 'Ritchey Timberwolf Frameset - 2016', 5, 6, 2016, 749.99),
(3, 'Surly Wednesday Frameset - 2016', 8, 6, 2016, 999.99),
(4, 'Trek Fuel EX 8 29 - 2016', 9, 6, 2016, 2899.99),
(5, 'Heller Shagamaw Frame - 2016', 3, 6, 2016, 1320.99),
(6, 'Surly Ice Cream Truck Frameset - 2016', 8, 6, 2016, 469.99),
(7, 'Trek Slash 8 27.5 - 2016', 9, 6, 2016, 3999.99),
(8, 'Trek Remedy 29 Carbon Frameset - 2016', 9, 6, 2016, 1799.99),
(9, 'Trek Conduit+ - 2016', 9, 5, 2016, 2999.99),
(10, 'Surly Straggler - 2016', 8, 4, 2016, 1549.00);

-- insert customers
INSERT INTO customers(customer_id, first_name, last_name, phone, email, street, city, state, zip_code) VALUES
(1, 'Debra', 'Burks', NULL, 'debra.burks@yahoo.com', '9273 Thorne Ave.', 'Orchard Park', 'NY', '14127'),
(2, 'Kashla', 'Todd', NULL, 'kashla.todd@yahoo.com', '910 Vine Street', 'Campbell', 'CA', '95008'),
(3, 'Tameka', 'Fisher', NULL, 'tameka.fisher@aol.com', '769C Honey Creek St.', 'Redondo Beach', 'CA', '90278'),
(4, 'Daryl', 'Spence', NULL, 'daryl.spence@aol.com', '988 Pearl Lane', 'Uniondale', 'NY', '11553'),
(5, 'Charlotte', 'Rice', '(916) 381-6003', 'charlotte.rice@msn.com', '107 River Dr.', 'Sacramento', 'CA', '95820');

-- insert stores
INSERT INTO stores
(store_id, store_name, phone, email, street, city, state, zip_code)
VALUES
(1, 'Santa Cruz Bikes', '(831) 476-4321', 'santacruz@bikes.shop', '3700 Portola Drive', 'Santa Cruz', 'CA', '95060'),
(2, 'Baldwin Bikes', '(516) 379-8888', 'baldwin@bikes.shop', '4200 Chestnut Lane', 'Baldwin', 'NY', '11432'),
(3, 'Rowlett Bikes', '(972) 530-5555', 'rowlett@bikes.shop', '8000 Fairway Avenue', 'Rowlett', 'TX', '75088');


-- insert stocks
INSERT INTO stocks (store_id, product_id, quantity)
VALUES
(1, 1, 27),
(1, 2, 5),
(1, 3, 6),
(1, 4, 23),
(1, 5, 22),
(1, 6, 0),
(1, 7, 8),
(1, 8, 0),
(1, 9, 11),
(1, 10, 15);


-- insert staffs
INSERT INTO staffs (staff_id,first_name,last_name,email,phone,active,store_id,manager_id
)
VALUES
(1, 'Fabiola', 'Jackson', 'fabiola.jackson@bikes.shop', '(831) 555-5554', 1, 1, NULL),
(2, 'Mireya', 'Copeland', 'mireya.copeland@bikes.shop', '(831) 555-5555', 1, 1, 1),
(3, 'Gennie', 'Serrano', 'gennie.serrano@bikes.shop', '(831) 555-5556', 1, 1, 2),
(4, 'Virgie', 'Wiggins', 'virgie.wiggins@bikes.shop', '(831) 555-5557', 1, 1, 2),
(5, 'Jannette', 'David', 'jannette.david@bikes.shop', '(516) 379-4444', 1, 2, 1);

-- insert orders
INSERT INTO orders (order_id,customer_id,order_status,order_date,required_date,shipped_date,store_id,staff_id)
VALUES
(1, 1, 4, '2016-01-01', '2016-01-03', '2016-01-03', 1, 2),
(2, 2, 4, '2016-01-01', '2016-01-04', '2016-01-03', 2, 5),
(3, 3, 4, '2016-01-02', '2016-01-05', '2016-01-03', 2, 5),
(4, 4, 4, '2016-01-03', '2016-01-04', '2016-01-05', 1, 3),
(5, 5, 4, '2016-01-03', '2016-01-06', '2016-01-06', 2, 4);

-- insert order_items
INSERT INTO order_items (order_id, item_id, product_id, quantity, list_price, discount)
VALUES
(1, 1, 10, 1, 599.99, 0.20),
(1, 2, 8, 2, 1799.99, 0.07),
(1, 3, 10, 2, 1549.00, 0.05),
(1, 4, 10, 2, 599.99, 0.05),
(1, 5, 4, 1, 2899.99, 0.20),
(2, 1, 10, 1, 599.99, 0.07),
(2, 2, 10, 2, 599.99, 0.05),
(3, 1, 3, 1, 999.99, 0.05),
(3, 2, 10, 1, 599.99, 0.05),
(4, 1, 2, 2, 749.99, 0.10);

-- lab2
-- 1
select first_name, last_name, email
from customers;
-- 2
select *
from customers
where state = 'CA';
-- 3
select *
from customers
order by first_name asc;
-- 4
select city,
       count(*) as customer_count
from customers
where state = 'CA'
group by city;

-- 5
select city,
       count(*) as customer_count
from customers
where state = 'CA'
group by city
having count(*) > 10;

-- 6
select product_name,
       model_year
from products
where list_price between 1000 and 2000;

-- 7
select first_name,
       email
from staffs
where active = 1;
-- 8
select product_name,
       brand_id
from products
where model_year = 2016
  and list_price > 1000;
-- 9
select order_id, customer_id
from orders
where shipped_date is not null;
-- 10
select product_id, list_price, quantity
from order_items
where discount > 0
  and quantity = 2;
-- 11
select store_id, count(product_id) as product_count
from stocks
group by store_id
having count(product_id) > 5
order by product_count desc;
-- 12
select *
from customers
where email like '%@yahoo.com%'
order by first_name desc;

-- 13
select category_id,avg(list_price) as avg_price
from products
group by category_id
having avg_price > 500
order by avg_price desc;
-- 14
select brand_id, count(brand_id) as total_products
from products
group by brand_id
having total_products >2
order by total_products desc;

-- JOINs
-- lab2

-- q1
select products.product_name, list_price, brand_name
from products left join brands 
	on products.brand_id = brands.brand_id
where list_price > 1000;

-- q2
select customers.customer_id,first_name, last_name, order_id, order_status
from customers inner join orders
	on customers.customer_id = orders.customer_id
where order_status = 4;
-- test q2
select customers.customer_id,concat(first_name, ' ',last_name) name, order_id, order_status
from customers inner join orders
	on customers.customer_id = orders.customer_id
where order_status = 4;
-- q3 
select employees.first_name as employee_first_name, employees.first_name as employee_first_name, employees.email as employee_email,
		managers.first_name as manager_first_name, managers.first_name as manager_first_name, managers.email as manager_email
from staffs as employees left join staffs as managers 
		on employees.manager_id = managers.staff_id;
-- q4 
select product_name, brand_name
from products left join brands 
	on products.brand_id = brands.brand_id;
    
-- q5
select product_name, model_year, brand_name
from products left join brands 
	on products.brand_id = brands.brand_id
where model_year >= 2016;

-- q6
select order_id, product_name, quantity
from order_items inner join products
	on order_items.product_id = products.product_id;
-- q7 
select product_name, category_name
from products inner join categories
	on products.category_id = categories.category_id
where categories.category_name = 'Mountain Bikes';
-- q8 
select product_name, list_price, category_name, brand_name
from products p inner join categories c
	inner join brands b
    on p.category_id = c.category_id and p.brand_id = b.brand_id
where list_price > 500 and category_name = 'Electric Bikes';
-- q9 
select customers.customer_id, first_name, last_name, order_id, shipped_date
from customers left join orders
	on customers.customer_id = orders.customer_id
    and orders.shipped_date is null;  -- một dạng điểu kiện lọc 
-- q10 
select store_name, count(order_id) order_count
from stores left join orders
	on stores.store_id = orders.store_id
group by stores.store_id;
-- q11
select order_id,  first_name, last_name, order_date
from staffs inner join orders
	on staffs.staff_id = orders.staff_id
where orders.store_id = 1
order by orders.order_id desc;
-- q12 
select concat(first_name, last_name) customer_name, order_id, order_date
from orders inner join customers
	on orders.customer_id = customers.customer_id
where year(order_date) = 2016;
-- q13 
select first_name, last_name, order_id, order_date
from staffs inner join orders
	on staffs.staff_id = orders.order_id
where order_date >= date_sub(curdate(), interval 12 month);

-- trigger test quality stocks và order_items
DELIMITER $$
drop trigger if exists trg_check_stock_before_update;
CREATE TRIGGER trg_check_stock_before_update
BEFORE UPDATE ON order_items
FOR EACH ROW
BEGIN
    DECLARE stock_qty INT;

    SELECT quantity
    INTO stock_qty
    FROM stocks
    WHERE product_id = NEW.product_id
      AND store_id = (
            SELECT store_id
            FROM orders
            WHERE order_id = NEW.order_id
        );

    IF stock_qty IS NULL THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Product not found in stock';
    END IF;

    IF NEW.quantity > stock_qty THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Order quantity exceeds stock quantity';
    END IF;
END$$

DELIMITER ;


DELIMITER //
drop trigger if exists tr_check_stock_before_insert;
create trigger tr_check_stock_before_insert
after insert on order_items
for each row
begin
	declare stock_qty int;
        
    select quantity into stock_qty
    from stocks
    where product_id = new.product_id
		and store_id = (
        select store_id 
        from orders
        where order_id = new.order_id
        );
        
	if stock_qty is null then 
		SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Product not found in stock';    
    end if;
    
    if stock_qty < new.quantity then 
		SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Product not found in stock';    
    end if;
end; //
DELIMITER ; 

INSERT INTO order_items
(order_id, item_id, product_id, quantity,list_price, discount)
VALUES (1, 11, 10, 5,100,0.01);

select * -- into stock_qty
    from stocks 
    where product_id = 1
		and store_id = (
        select store_id 
        from orders
        where order_id = 4
        );
		
