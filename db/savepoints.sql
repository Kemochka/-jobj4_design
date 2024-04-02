[car=# start transaction;
START TRANSACTION
[car=*# set transaction isolation level repeatable read;
SET
[car=*# select * from cars;
car=*# delete from cars;
[ALTER SEQUENCE cars_id_sea RESTART WITH 1;
DELETE 3
ALTER SEQUENCE
(car=*# insert into cars(id, name, model)
values (1, 'Тойота', 1), (2, 'Хонда', 2), (3, 'Мазда', 3);
INSERT 0 3
[car=*# select * from cars;
car=*# savepoint point1;
SAVEPOINT
car=*# insert into cars(id, name, model) values (4, 'Хендай', 4);
INSERT 0 1
[car=*# select * from cars;
[car=*# commit;
COMMIT
[car=# begin transaction;
BEGIN
[car=*# delete from cars;
DELETE 4
[car=*# drop table cars;
DROP TABLE
[car=*# rollback transaction;
ROLLBACK
(car=# select * from cars;
(car=# begin transaction;
BEGIN
(car=*# insert into cars(id, name, model) values (5, 'Майбах', 5);
INSERT 8 1
car=*# savepoint point2;
(car=*# delete from cars where model = 4;
DELETE 1
(car=*# select * from cars;
(car=*# rollback to point2;
ROLLBACK
[car=*# select * from cars;
(5 rows)
[car=*# commit;
COMMIT
