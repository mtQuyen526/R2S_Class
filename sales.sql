create database sales;
use sales;
-- tao1
CREATE TABLE employees (
employee_id INT AUTO_INCREMENT PRIMARY KEY,
last_name VARCHAR(20) NOT NULL,
first_name VARCHAR(10) NOT NULL,
birth_date DATE,
supervisor_id INT
);
-- tao 2
CREATE TABLE customers (
customer_id INT AUTO_INCREMENT PRIMARY KEY,
customer_name VARCHAR(255),
contact_name VARCHAR(255),
address VARCHAR(255),
city VARCHAR(255),
postal_code VARCHAR(10),
country VARCHAR(50)
);

-- tao 3
CREATE TABLE orders (
order_id INT AUTO_INCREMENT PRIMARY KEY,
customer_id INT,
employee_id INT,
order_date DATETIME DEFAULT CURRENT_TIMESTAMP,
FOREIGN KEY (customer_id) REFERENCES customers(customer_id),
FOREIGN KEY (employee_id) REFERENCES employees(employee_id)
);

-- Data Manipulation Language (DML) 

Insert into customers (customer_name, contact_name, address, city, postal_code, country)
values ('Trần Bình', 'Trọng', 'Quận 8', 'HCM', 70000, 'VN'),
('Tran Bao', 'An', 'Bình Thạnh', 'HCM', 70000, 'VN'),
('Tasty', 'Finn', 'Streetroad 19B', 'Liverpool', 'L1 0AA', 'UK');

-- test 

INSERT INTO employees (employee_id,first_name,last_name,birth_date,supervisor_id
)
VALUES
(1, 'Fabiola', 'Jackson','1997-01-01', NULL),
(2, 'Mireya', 'Copeland','1998-01-01', 1),
(3, 'Gennie', 'Serrano','1999-01-01', 2),
(4, 'Virgie', 'Wiggins','1997-02-01', 2),
(5, 'Jannette', 'David','1997-03-01', 1);

INSERT INTO orders (order_id,customer_id,employee_id,order_date)
VALUES
(1, 1, 2,'2016-01-01'),
(2, 2,5, '2016-01-01'),
(3, 3,5, '2016-01-02'),
(4, 3,3, '2016-01-03'),
(5, 2,4, '2016-01-03');

-- q1
select customer_id, customer_name, contact_name,address, city, postal_code, country
from customers;
-- q2
select distinct country
from customers;
-- q3
select *
from customers
where country = 'VN';
-- q4
select country, count(customer_id) NumberOfCustomer
from customers
group by country;
-- q5
select country, count(customer_id) NumberOfCustomer
from customers
group by country
having count(customer_id)>=2;
-- q6
select *
from customers
order by contact_name;

-- join

update orders set customer_id = 2 where order_id = 1;
-- q1
select order_id, customers.customer_id, customer_name
from customers INNER JOIN orders
on customers.customer_id = orders.customer_id;

-- q2
select customers.customer_id, customer_name, order_id
from customers LEFT JOIN orders
on orders.customer_id = customers.customer_id;
-- q3
SELECT a.employee_id ,CONCAT(a.last_name,' ', a.first_name) as 'Employee Name',b.employee_id AS 'Supervisor ID',CONCAT(b.last_name,' ', b.first_name) AS 'Supervisor Name'
FROM employees a inner join employees b
on a.supervisor_id = b.employee_id; 
-- q4
SELECT A.customer_id, A.customer_name, A.country
FROM customers A inner join customers B
on A.customer_id <> B.customer_id
Where A.country = B.country;
-- q5 
select
order_id, customer_name,
CONCAT(first_name, ' ', last_name) EmployeeName,
order_date
from employees E INNER join orders O
on E.employee_id = O.employee_id
INNER JOIN customers C
on C.customer_id = O.customer_id
