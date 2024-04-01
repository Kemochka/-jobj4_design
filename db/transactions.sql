Kristinas-MacBook-Air:~ kemochka$ psql -U kemochka -d car
psql (14.11 (Homebrew))
Type "help" for help.
car=# start transaction;
START TRANSACTION

car=# select * from cars;
 id |  name  | model
----+--------+-------
  1 | Тойота |    12
  2 | Мазда  |     9
  3 | Хендай |    11
(3 rows)

car=# insert into cars(id, name, model) values (4, 'Хонда', 1);
INSERT 0 1
car=# delete from cars where id = 1;
DELETE 1
car=# select * from cars;
 id |  name  | model
----+--------+-------
  2 | Мазда  |     9
  3 | Хендай |    11
  4 | Хонда  |     1
(3 rows)

car=# begin transaction;
BEGIN
car=*# select * from cars;
 id |  name  | model
----+--------+-------
  2 | Мазда  |     9
  3 | Хендай |    11
  4 | Хонда  |     5
(3 rows)

car=*# insert into cars(id, name, model) values (5, 'Майбах', 1);
INSERT 0 1
car=*# delete from cars where id = 2;
DELETE 1
car=*# update cars set model = 3 where name = 'Хонда';
UPDATE 1
car=*# select * from cars;
 id |  name  | model
----+--------+-------
  3 | Хендай |    11
  5 | Майбах |     1
  4 | Хонда  |     3
(3 rows)

car=*# commit;
COMMIT


car=# begin transaction isolation level repeatable read;
BEGIN
car=*# select * from cars;
 id |  name  | model
----+--------+-------
  3 | Хендай |    11
  5 | Майбах |     1
  4 | Хонда  |     3
(3 rows)

car=*# insert into cars(id, name, model) values (6, 'БМВ', 4);
INSERT 0 1
car=*# delete from cars where id = 3;
DELETE 1
car=*# update cars set model = 6 where name = 'Хонда';
UPDATE 1
car=!# rollback;
ROLLBACK

car=# begin transaction isolation level serializable;
BEGIN
car=*# select sum(model) from cars;
 sum
-----
 468
(1 row)

car=*# update cars set model = 46 where name = 'Хонда';
UPDATE 1
car=*# commit;
ERROR:  could not serialize access due to read/write dependencies among transactions
DETAIL:  Reason code: Canceled on identification as a pivot, during commit attempt.
HINT:  The transaction might succeed if retried.
car=#
