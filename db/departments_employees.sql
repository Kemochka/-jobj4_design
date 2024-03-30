create table departments(
id serial primary key,
name varchar(255)
);

create table employees(
id serial primary key,
name varchar(255),
dep_id int references departments(id)
);

insert into departments(id, name) values (1, 'Dep1'), (2, 'Dep2'), (3, 'Dep3'), (4, 'Dep4');
insert into employees(id, name, dep_id) values (1, 'Name1', 1);
insert into employees(id, name, dep_id) values (2, 'Name2', 2);
insert into employees(id, name, dep_id) values (3, 'Name3', 3);
insert into employees(id, name, dep_id) values (4, 'Name4', 4);
insert into employees(id, name, dep_id) values (5, 'Name5', null);

select * from employees as e left join departments as d on e.dep_id = d.id;
select * from departments as d right join employees as e on e.dep_id = d.id;
select * from employees as e full join departments as d on e.dep_id = d.id;
select * from employees as e cross join departments as d;

select * from employees as e left join departments as d on e.dep_id = d.id where d.id is null;

select * from employees as e left join departments as d on e.dep_id = d.id;
select e.id, e.name, e.dep_id, d.id, d.name from departments as d right
join employees as e on e.dep_id = d.id;/*выводит одинаково, но запрост странный*/

select * from employees as e left join departments as d on e.dep_id = d.id;
select * from employees as e right join departments as d on d.id = e.dep_id;/*не выводит null*/

create table teens(
id serial primary key,
name varchar(255),
gender text
);

insert into teens(id, name, gender) values (1, 'Маша', 'Ж');
insert into teens(id, name, gender) values (2, 'Ваня', 'М');
insert into teens(id, name, gender) values (3, 'Оля', 'Ж');
insert into teens(id, name, gender) values (4, 'Сережа', 'М');
insert into teens(id, name, gender) values (5, 'Катя', 'Ж');
insert into teens(id, name, gender) values (6, 'Даня', 'М');
insert into teens(id, name, gender) values (7, 'Вика', 'Ж');
insert into teens(id, name, gender) values (8, 'Влад', 'М');

select f.name as name1, m.name as name2 from teens as f
cross join teens as m where f.id < m.id and f.gender != m.gender;


