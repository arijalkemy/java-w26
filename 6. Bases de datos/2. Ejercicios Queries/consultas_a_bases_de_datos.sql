SELECT * from movies m ;

SELECT a.first_name, a.last_name, a.rating  from actors a ;

SELECT s.title as titulo from series s;

SELECT a.first_name, a.last_name  from actors a where a.rating > 7.5;

SELECT m.title, m.rating, m.awards  from movies m where m.rating > 7.5 and m.awards > 2 ;

SELECT m.title, m.rating  from movies m order by m.rating ASC ;

SELECT * from movies m limit 3;

SELECT * from movies m ORDER by m.rating DESC limit 5;

SELECT * from actors a LIMIT 10;

SELECT m.title, m.rating  from movies m where m.title like "%toy story%";

SELECT * from actors a where a.first_name like "%sam";

SELECT * from movies m where m.release_date BETWEEN "2004-01-01" and "2008-12-31";

SELECT m.title  FROM movies m where m.rating > 3 and m.awards > 1 and m.release_date BETWEEN "1988-01-01" and "2009-12-31" ORDER by m.rating ;


