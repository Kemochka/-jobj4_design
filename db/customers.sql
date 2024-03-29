create table customers(
id serial primary key,
name varchar(255)
);

create table orders(
id serial primary key,
customer_id int references customers(id),
orders_date date
);

insert into customers(id, name) values (1, 'Kris');
insert into customers(id, name) values (2, 'Olga');
insert into customers(id, name) values (3, 'Oleg');
insert into customers(id, name) values (4, 'Vlad');

insert into orders(id, customer_id, orders_date) values (1, 1, '2024-01-01');
insert into orders(id, customer_id, orders_date) values (2, 1, '2024-01-01');
insert into orders(id, customer_id, orders_date) values (3, 3, '2024-01-02');

select od.orders_date, cu.name from orders as od join customers as cu on od.customer_id = cu.id;
select od.orders_date as Дата, cu.name as Имя from orders as od join customers as cu on od.customer_id = cu.id;
select od.orders_date as "Дата заказа", cu.name Имя from orders as od join customers as cu on od.customer_id = cu.id;