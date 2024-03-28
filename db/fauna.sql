create table fauna(
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);

insert into fauna(name, avg_age, discovery_date) values ('fish perch', 8935, '1814-01-01');
insert into fauna(name, avg_age, discovery_date) values ('pike fish', 4380, '1230-01-01');
insert into fauna(name, avg_age, discovery_date) values ('sparrow bird', 1095, '1870-01-01');
insert into fauna(name, avg_age, discovery_date) values ('siamese cat', 5840, '1350-01-01');
insert into fauna(name, avg_age, discovery_date) values ('bulldog dog', 3650, '1896-01-01');
insert into fauna(name, avg_age, discovery_date) values ('insect ant', 730, '1758-01-01');
insert into fauna(name, avg_age, discovery_date) values ('clam octopus', 1825, '1910-01-01');
insert into fauna(name, avg_age, discovery_date) values ('clam snail', 1460, '1858-01-01');
insert into fauna(name, avg_age, discovery_date) values ('mammal horse', 10950, '1881-01-01');
insert into fauna(name, avg_age, discovery_date) values ('chimpanzee primate', 14235, '1641-01-01');

select * from fauna where name like '%fish%';
select * from fauna where avg_age between 10000 and 20000;
select * from fauna where discovery_date is null;
select * from fauna where EXTRACT(year FROM discovery_date) < 1950;



