create table products(
    id       serial primary key,
    name     varchar(50),
    producer varchar(50),
    count    integer default 0,
    price    integer
);

insert into products (id, name, producer, count, price)
VALUES (1, 'product_3', 'producer_3', 8, 115);
insert into products (id, name, producer, count, price)
VALUES (2, 'product_1', 'producer_1', 3, 50);

create
or replace function tax()
    returns trigger as
$$
    BEGIN
        update products
        set price = price + price * 0.2
        where id = (select id from inserted);
        return new;
    END;
$$
LANGUAGE 'plpgsql';

create trigger tax_trigger_prod
    after insert
    on products
    referencing new table as
                    inserted
    for each statement
    execute procedure tax();

insert into products (id, name, producer, count, price)
VALUES (3, 'product_4', 'producer_4', 8, 115);

create
or replace function taxProd()
    returns trigger as
$$
    BEGIN
        update products
        set price = price + price * 0.2
        where id = new.id;
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';

create trigger taxProd_trigger
    before insert
    on products
    for each row
    execute procedure taxProd();

insert into products (id, name, producer, count, price)
VALUES (5, 'product_6', 'producer_6', 4, 16);

create
or replace function history()
returns trigger as
$$
begin
insert into history_of_price(name, price, date)
values (new.name, new.price, now());
return new;
end;
$$
LANGUAGE 'plpgsql';;

create trigger history_of_price
    after insert
    on products
    for each row
    execute procedure history();

insert into products (id, name, producer, count, price)
VALUES (6, 'product_7', 'producer_7', 8, 456);


