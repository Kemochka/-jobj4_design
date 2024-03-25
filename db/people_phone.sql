create table phone(
id serial primary key,
number varchar(20)
);

create table people(
id serial primary key,
name varchar(255),
number_id references phone(id) unique
);