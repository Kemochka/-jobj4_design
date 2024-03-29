create table type(
id serial primary key,
name varchar(255)
);

create table product(
id serial primary key,
name varchar(255),
type_id int references type(id),
expired_date date,
price float
);

insert into type(name) values (1, 'Молоко'), (2, 'Сыр'),
(3, 'Печенье'), (4, 'Колбаса'), (5, 'Макароны'),
(6, 'Творог'), (7, 'Мороженое'), (8, 'Сок');

insert into product(name, type_id, expired_date, price) values ('Молоко топленое', 1, '2024-04-24', 84.9);
insert into product(name, type_id, expired_date, price) values ('Молоко шоколадное', 1, '2024-04-13', 101.5);
insert into product(name, type_id, expired_date, price) values ('Молоко отборное', 1, '2024-03-13', 96.5);
insert into product(name, type_id, expired_date, price) values ('Сыр плавленный', 2, '2024-04-01', 114.6);
insert into product(name, type_id, expired_date, price) values ('Сыр творожный', 2, '2024-03-20', 124.3);
insert into product(name, type_id, expired_date, price) values ('Сыр пармезан', 2, '2024-03-15', 345.6);
insert into product(name, type_id, expired_date, price) values ('Печенье юбилейное', 3, '2024-03-31', 114.3);
insert into product(name, type_id, expired_date, price) values ('Печенье песочное', 3, '2024-07-20', 84.5);
insert into product(name, type_id, expired_date, price) values ('Колбаса вареная ', 4, '2024-04-29', 269.0);
insert into product(name, type_id, expired_date, price) values ('Колбаса копченая', 4, '2024-04-30', 456.5);
insert into product(name, type_id, expired_date, price) values ('Колбаса вкусная', 4, '2024-03-21', 99.9);
insert into product(name, type_id, expired_date, price) values ('Макароны спагетти', 5, '2025-03-05', 78.3);
insert into product(name, type_id, expired_date, price) values ('Макароны ракушки', 5, '2025-03-06', 104.5);
insert into product(name, type_id, expired_date, price) values ('Макароны змейки', 5, '2025-03-10', 78.9);
insert into product(name, type_id, expired_date, price) values ('Творог мягкий', 6, '2024-03-31', 69.0);
insert into product(name, type_id, expired_date, price) values ('Творог в брикете', 6, '2024-03-31', 78.6);
insert into product(name, type_id, expired_date, price) values ('Творог зерновой', 6, '2024-03-28', 94.7);
insert into product(name, type_id, expired_date, price) values ('Мороженое пломбир', 7, '2024-04-10', 66.7);
insert into product(name, type_id, expired_date, price) values ('Мороженое шоколадное', 7, '2024-04-20', 56.7);
insert into product(name, type_id, expired_date, price) values ('Мороженое клубничное', 7, '2024-04-30', 89.0);
insert into product(name, type_id, expired_date, price) values ('Мороженое мягкое', 7, '2024-04-21', 45.8);
insert into product(name, type_id, expired_date, price) values ('Сок яблочный', 8, '2024-06-21', 101.0);
insert into product(name, type_id, expired_date, price) values ('Сок гранатовый', 8, '2024-06-29', 184.5);
insert into product(name, type_id, expired_date, price) values ('Сок апельсиновый', 8, '2024-06-25', 345.8);
insert into product(name, type_id, expired_date, price) values ('Сок ягодный', 8, '2024-03-21', 144.0);

select * from product where type_id = 2; /*тут тоже сыр, только по ID*/

select * from product where name like'%Сыр%';

select * from product where name like '%мороженое%' or name like '%Мороженое%';

select * from product where expired_date < current_date;

select t.name as "Название продукта", type_id as "Тип продукта", max(pr.price) as "Максимальная стоимость"
from product as pr join type as t on pr.type_id = t.id group by type_id, t.name order by (type_id) asc;

select t.name as "Имя продукта", count(*) as "Количество"
from type as t join product as p on t.id=p.type_id group by t.name order by(count(*)) asc;

select * from product where type_id in(1,2);

select t.name as "Имя продукта", count(*) as "Количество"
from type as t join product as p on t.id=p.type_id
group by t.name
having count(*) < 10
order by(count(*)) asc;

select pr.name as "Имя продукта", t.name as "Тип продукта"
from product as pr join type as t on t.id = pr.type_id
group by pr.name, t.name order by(pr.name) asc;