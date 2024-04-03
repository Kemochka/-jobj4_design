CREATE TABLE movie(
    id       SERIAL PRIMARY KEY,
    name     text,
    director text
);

CREATE TABLE book(
    id     SERIAL PRIMARY KEY,
    title  text,
    author text
);
/*- выведите названия всех фильмов, которые сняты по книге;*/
select name from movie
intersect
select title from book;

/*выведите все названия книг, у которых нет экранизации;*/
select title from book
except
select name from movie;
/*выведите все уникальные названия произведений
из таблиц movie и book (т.е фильмы, которые сняты
не по книге, и книги без экранизации)*/
select name from movie
except
(select name from movie
intersect
select title from book)
union
(select title from book
except
select name from movie);


