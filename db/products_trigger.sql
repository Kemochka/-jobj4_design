create table products(
    id       serial primary key,
    name     varchar(50),
    producer varchar(50),
    count    integer default 0,
    price    integer
);

insert into products (id, name, producer, count, price)
VALUES (1, 'product_1', 'producer_2', 8, 115);

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

create trigger tax_trigger
    after insert
    on products
    referencing new table as
                    inserted
    for each statement
    execute procedure tax();

insert into products (id, name, producer, count, price)
VALUES (2, 'product_2', 'producer_2', 3, 50);
insert into products (id, name, producer, count, price)
VALUES (3, 'product_4', 'producer_4', 8, 115);

create
or replace function taxProd()
    returns trigger as
$$
    BEGIN
        new.price = new.price + new.price * 0.2;
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';

create trigger taxProd_trigger
    before insert
    on products
    for each row
    execute function taxProd();

insert into products (id, name, producer, count, price)
VALUES (3, 'product_6', 'producer_6', 4, 16);

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
LANGUAGE 'plpgsql';

create trigger history_of_price
    after insert
    on products
    for each row
    execute procedure history();

insert into products (id, name, producer, count, price)
VALUES (4, 'product_7', 'producer_7', 8, 456);
insert into products (id, name, producer, count, price)
VALUES (5, 'product_8', 'producer_9', 9, 46);

