create table categories(
id serial primary key,
name text
);

create table users(
id serial primary key,
name varchar(255)
);

create table products(
id serial primary key,
name text,
price float,
category_id int references categories(id)
);

create table orders(
id serial primary key,
order_date date,
user_id int references users(id),
product_id int references products(id)
);

insert into categories(id, name) values (1, 'Молоко'), (2, 'Сыр'), (3, 'Сок');
insert into users(id, name) values (1, 'Иван'), (2, 'Ольга'), (3, 'Мария'), (4, 'Влад');
insert into products(id, name, price, category_id)
values (1, 'Молоко топленое', 124.5, 1), (2, 'Сыр творожный', 134.5, 2),
(3, 'Сок мультифрукт', 234.5, 3), (4, 'Молоко коровье', 1234.5, 1);
insert into orders(id, order_date, user_id, product_id)
values (1, '2024-01-01', 1, 1), (2, '2024-01-01', 1, 2), (3, '2024-01-01', 1, 3),
(4, '2024-01-01', 2, 1), (5, '2024-01-01', 2, 2),
(6, '2024-01-01', 3, 2), (7, '2024-01-01', 4, 3), (8, '2024-01-01', 4, 1);

select u.name as user_name, sum(p.price) as total_cost
from users u
join orders o on u.id=o.user_id
join products p on p.id = o.product_id
group by u.name;

create view total_cost
as
select u.name as user_name, sum(p.price) as total_cost
from users u
left join orders o on u.id=o.user_id
left join products p on p.id = o.product_id
group by u.name;

select * from total_cost;




