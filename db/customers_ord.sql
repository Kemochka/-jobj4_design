CREATE TABLE customers(
    id         serial primary key,
    first_name text,
    last_name  text,
    age        int,
    country    text
);

insert into customers(id, first_name, last_name, age, country)
values (1, 'Август', 'Иванов', 21, 'Россия');
insert into customers(id, first_name, last_name, age, country)
values (2, 'Петр', 'Васильев', 22, 'Россия');
insert into customers(id, first_name, last_name, age, country)
values (3, 'Василий', 'Петров', 23, 'Беларусь');
insert into customers(id, first_name, last_name, age, country)
values (4, 'Влад', 'Сорокин', 24, 'Россия');
insert into customers(id, first_name, last_name, age, country)
values (5, 'Иван', 'Воробьев', 25, 'Беларусь');

select id, first_name, last_name, age, country
from customers where age = ((select min(age) from customers));

CREATE TABLE orders(
    id          serial primary key,
    amount      int,
    customer_id int references customers (id)
);

insert into orders(id, amount, customer_id)
values (1, 2, 1);
insert into orders(id, amount, customer_id)
values (2, 3, 2);
insert into orders(id, amount, customer_id)
values (3, 4, 3);
insert into orders(id, amount, customer_id)
values (4, 5, 4);

select * from customers where customers.id not in (select customer_id from orders);

