create
or replace procedure delete_data(u_count integer, tax float, u_id integer)
language 'plpgsql'
as $$
begin
    if u_count % 2 = 0 then
        delete from products where id = u_id;
    end if;
end;
$$;
call delete_data(10, 0, 3);

create
or replace function p_delete_data(i_name varchar, prod varchar, i_count integer, i_price integer)
returns void
language 'plpgsql'
as
$$
begin
if i_count < 10 then
delete from products where name = i_name;
end if;
end;
$$;
select p_delete_data('product_1', 'producer_1', 3, 100);
