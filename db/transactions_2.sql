Kristinas-MacBook-Air:~ kemochka$ psql -U kemochka -d car
psql (14.11 (Homebrew))
Type "help" for help.

car=# start transaction;
START TRANSACTION
car=*# select * from cars;
 id |  name  | model
----+--------+-------
  1 | Тойота |    12
  2 | Мазда  |     9
  3 | Хендай |    11
(3 rows)

car=*# select * from cars;
 id |  name  | model
----+--------+-------
  2 | Мазда  |     9
  3 | Хендай |    11
  4 | Хонда  |     5
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

car=*# select * from cars;
 id |  name  | model
----+--------+-------
  2 | Мазда  |     9
  3 | Хендай |    11
  4 | Хонда  |     5
(3 rows)

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

car=*# update cars set model = 6 where name = 'Хонда';
UPDATE 1
car=*# select * from cars;
 id |  name  | model
----+--------+-------
  3 | Хендай |    11
  5 | Майбах |     1
  4 | Хонда  |     6
(3 rows)

car=!# commit;
ROLLBACK

car=# begin transaction isolation level serializable;
BEGIN
car=*# update cars set model = 9 where name = 'Хонда';


car=# begin transaction isolation level serializable;
BEGIN
car=*# select sum(model) from cars;
 sum
-----
 468
(1 row)

car=*# update cars set model = 46 where name = 'Майбах';
UPDATE 1
car=*# commit;
COMMIT
car=#
