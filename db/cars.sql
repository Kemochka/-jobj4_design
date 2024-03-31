create table car_bodies(
id serial primary key,
name text
);

create table car_engines(
id serial primary key,
name text
);

create table car_transmissions(
id serial primary key,
name text
);

create table cars(
id serial primary key,
name text,
body_id int references car_bodies(id),
engine_id int references car_engines(id),
transmission_id int references car_transmissions(id)
);

insert into car_bodies(id, name) values (1, 'Седан'), (2, 'Хэтчбэк'), (3, 'Пикап');
insert into car_engines(id, name) values (1, 'Бензиновый'), (2, 'Дизельный'), (3, 'Газовый'), (4, 'Электро');
insert into car_transmissions(id, name)
values (1, 'Механическая'), (2, 'Автоматическая'), (3, 'Бусступенчатая'), (4, 'Полуавтоматическая');

insert into cars(id, name, body_id, engine_id, transmission_id) values(1, 'Тойота', 1, 1, 1);
insert into cars(id, name, body_id, engine_id, transmission_id) values(2, 'Хонда', 1, 2, 4);
insert into cars(id, name, body_id, engine_id, transmission_id) values(3, 'Хендай', 2, 3, 1);
insert into cars(id, name, body_id, engine_id, transmission_id) values(4, 'Шкода', 2, null , 2);
insert into cars(id, name, body_id, engine_id, transmission_id) values(5, 'Мерс', 2, 2, 4);
insert into cars(id, name, body_id, engine_id, transmission_id) values(6, 'БМВ', 2, 3, 1);

select c.id, c.name as car_name, cb.name as body_name, ce.name as engine_name, ct.name as transmission_name
from cars c
left join car_bodies cb on c.body_id = cb.id
left join car_engines ce on c.engine_id = ce.id
left join car_transmissions ct on c.transmission_id = ct.id
order by(c.id) asc;

select cb.name as unused_bodies from car_bodies cb
left join cars c on cb.id = c.body_id
where c.body_id is null;

select ce.name as unused_engine from car_engines ce
left join cars c on ce.id = c.engine_id
where c.engine_id is null;

select ct.name as unused_transmission from car_transmissions ct
left join cars c on ct.id = c.engine_id
where c.transmission_id is null;


