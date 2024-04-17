CREATE TABLE person(
    id integer NOT NULL,
    name character varying,
    company_id integer references company(id),
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

insert into person (id, name, company_id) values (1, 'Alex', 1);
insert into person (id, name, company_id) values (2, 'Victor', 5);
insert into person (id, name, company_id) values (3, 'Max', 4);
insert into person (id, name, company_id) values (4, 'Olga', 5);
insert into person (id, name, company_id) values (5, 'Ivan', 2);
insert into person (id, name, company_id) values (6, 'Kris', 3);
insert into person (id, name, company_id) values (7, 'Vlad', 6);
insert into person (id, name, company_id) values (8, 'Maria', 5);

/*1. В одном запросе получить
- имена всех person, которые не состоят в компании с id = 5;
- название компании для каждого человека.*/
select p.name, (select c.name from company as c where p.company_id = c.id)
from person as p where company_id != 5;

/*2. Необходимо выбрать название компании с максимальным количеством человек
+ количество человек в этой компании.
Нужно учесть, что таких компаний может быть несколько.*/

with company_person_count as (select c.name, count(p.id) as num_people from company as c
left join person as p on c.id = p.company_id
group by(c.name))
select name, num_people from company_person_count
where num_people = (select max(num_people) from company_person_count);
