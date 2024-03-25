create table customers(
id serial primary key,
name varchar(255)
);

create table orders(
id serial primary key,
customers_id int references customer(id),
orders_date date
);