create table people(
id serial primary key,
name varchar(255)
);

create table dance(
id serial primary key,
name varchar(255)
);

create table people_dance(
id serial primary key,
people_id int references people(id),
dance_is int references dance(id)
);