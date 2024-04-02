idea_db=# BEGIN;
DECLARE
cursor_products cursor for
select * from products;
BEGIN
DECLARE CURSOR
idea_db=*# fetch 20 from cursor_products;
 id |    name    | producer | count | price
----+------------+----------+-------+-------
  1 | product_1  |          |     1 |     7
  2 | product_2  |          |     2 |    14
  3 | product_3  |          |     3 |    22
  4 | product_4  |          |     4 |    29
  5 | product_5  |          |     5 |    36
  6 | product_6  |          |     6 |    43
  7 | product_7  |          |     7 |    50
  8 | product_8  |          |     8 |    58
  9 | product_9  |          |     9 |    65
 10 | product_10 |          |    10 |    72
 11 | product_11 |          |    11 |    79
 12 | product_12 |          |    12 |    86
 13 | product_13 |          |    13 |    94
 14 | product_14 |          |    14 |   101
 15 | product_15 |          |    15 |   108
 16 | product_16 |          |    16 |   115
 17 | product_17 |          |    17 |   122
 18 | product_18 |          |    18 |   130
 19 | product_19 |          |    19 |   137
 20 | product_20 |          |    20 |   144
(20 rows)

idea_db=*# move backward 5 from cursor_products;
MOVE 5
idea_db=*# fetch prior from cursor_products;
 id |    name    | producer | count | price
----+------------+----------+-------+-------
 14 | product_14 |          |    14 |   101
(1 row)

idea_db=*# fetch next from cursor_products;
 id |    name    | producer | count | price
----+------------+----------+-------+-------
 15 | product_15 |          |    15 |   108
(1 row)

idea_db=*# move backward 8 from cursor_products;
MOVE 8
idea_db=*# fetch prior from cursor_products;
 id |   name    | producer | count | price
----+-----------+----------+-------+-------
  6 | product_6 |          |     6 |    43
(1 row)

idea_db=*# fetch next from cursor_products;
 id |   name    | producer | count | price
----+-----------+----------+-------+-------
  7 | product_7 |          |     7 |    50
(1 row)

idea_db=*# move backward 5 from cursor_products;
MOVE 5
idea_db=*# fetch prior from cursor_products;
 id |   name    | producer | count | price
----+-----------+----------+-------+-------
  1 | product_1 |          |     1 |     7
(1 row)

idea_db=*# fetch first from cursor_products;
 id |   name    | producer | count | price
----+-----------+----------+-------+-------
  1 | product_1 |          |     1 |     7
(1 row)

idea_db=*# fetch last from cursor_products;
 id |    name    | producer | count | price
----+------------+----------+-------+-------
 20 | product_20 |          |    20 |   144
(1 row)

idea_db=*# close cursor_products;
CLOSE CURSOR
idea_db=*# commit;
COMMIT
idea_db=#
