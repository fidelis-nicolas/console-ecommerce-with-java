use  mal_ecommerce;
show tables;

CREATE TABLE admin(
	id int not null auto_increment primary KEY,
    username VARCHAR(20),
    password varchar(20)
);

create table customers(
	customer_id int not null auto_increment primary key,
    customer_name VARCHAR(100),
    customer_email VARCHAR(100),
    cusotmer_address VARCHAR(100),
    password varchar(100)
);
create table products(
	product_id int not null auto_increment primary key,
    product_name VARCHAR(100),
    price double,
    description TEXT,
    quantity int
    
);
create table cart(
	cart_id int not null auto_increment primary key,
    customer_id int,
    product_id int,
    foreign key (customer_id) references customers(customer_id),
    foreign key (product_id) references products(product_id)
    
);
create table orders(
	order_id int not null auto_increment primary key,
    product_id int,
    customer_id int,
    oder_date date,
    order_status VARCHAR(30),
    
    foreign key (customer_id) references customers(customer_id),
    foreign key (product_id) references products(product_id)
)
select username, password from admin;
UPDATE admin set username = "test", password = "123456" where id = 1;

SELECT order_id, oder_date, order_status, customer_name, customer_email, cusotmer_address, product_name, price
FROM orders INNER JOIN customers ON orders.customer_id = customers.customer_id
INNER JOIN products ON orders.product_id = products.product_id;

SELECT * FROM products;

INSERT INTO products VALUES(7, 'Chicken', 14.99, 'delicious', 56);
select * FROM customers;
select * from admin;

