CREATE TABLE company(
    id integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);

insert into company(id, name) values (1, 'Apple');
insert into company(id, name) values (2, 'Honor');
insert into company(id, name) values (3, 'Samsung');
insert into company(id, name) values (4, 'Ozon');
insert into company(id, name) values (5, 'Wildberries');
insert into company(id, name) values (6, 'Sony');
