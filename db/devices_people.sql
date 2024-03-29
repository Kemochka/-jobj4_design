create table devices(
    id    serial primary key,
    name  varchar(255),
    price float
);

create table people(
    id   serial primary key,
    name varchar(255)
);

create table devices_people(
    id        serial primary key,
    device_id int references devices (id),
    people_id int references people (id)
);

insert into devices(id, name, price) values (1,'Redmi A1', 14990.5);
insert into devices(id, name, price) values (2,'Apple watch', 24990.5);
insert into devices(id, name, price) values (3,'Trimer Gilette', 1490.5);
insert into devices(id, name, price) values (4,'Apple airtag', 2490.5);
insert into devices(id, name, price) values (5,'Iphone 13', 65990.0);
insert into devices(id, name, price) values (6,'Caffee machine', 35000.0);
insert into devices(id, name, price) values (7,'Homor', 21000.0);
insert into devices(id, name, price) values (8,'Iphone 15', 100000.0);

insert into people(id, name) values (1, 'Ivan'), (2, 'Oleg'), (3, 'Vlad'), (4, 'Olga');

insert into devices_people(id, device_id, people_id) values (1, 1, 1);
insert into devices_people(id, device_id, people_id) values (2, 2, 1);
insert into devices_people(id, device_id, people_id) values (3, 3, 1);
insert into devices_people(id, device_id, people_id) values (4, 4, 2);
insert into devices_people(id, device_id, people_id) values (5, 5, 2);
insert into devices_people(id, device_id, people_id) values (6, 6, 2);
insert into devices_people(id, device_id, people_id) values (7, 7, 2);
insert into devices_people(id, device_id, people_id) values (8, 8, 3);
insert into devices_people(id, device_id, people_id) values (9, 1, 3);
insert into devices_people(id, device_id, people_id) values (10, 2, 3);
insert into devices_people(id, device_id, people_id) values (11, 3, 3);
insert into devices_people(id, device_id, people_id) values (12, 4, 4);
insert into devices_people(id, device_id, people_id) values (13, 5, 4);
insert into devices_people(id, device_id, people_id) values (14, 6, 4);
insert into devices_people(id, device_id, people_id) values (15, 7, 4);
insert into devices_people(id, device_id, people_id) values (16, 8, 4);

select avg(price) from devices;
select min(price) from devices;
select max(price) from devices;

select p.name as person_name, avg(d.price) as avg_price
from devices_people as dp join people p on dp.people_id = p.id
join devices as d on dp.device_id = d.id group by p.name;

select p.name as person_name, avg(d.price) as avg_price
from devices_people as dp join people p on dp.people_id = p.id
join devices as d on dp.device_id = d.id group by p.name
having avg(d.price) > 5000;
