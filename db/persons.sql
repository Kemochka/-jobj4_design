create table persons(
	id serial primary key,
	name text,
	age integer,
	birthday DATE
);
insert into persons(name, age, birthday) values('Kris', '25', '02.07.1999');
update persons set name = 'Kristina';
select * from persons;
delete from persons;
select * from persons;