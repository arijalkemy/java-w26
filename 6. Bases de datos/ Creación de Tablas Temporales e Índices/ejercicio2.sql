-- En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear 
-- la creación del mismo.
-- Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.

CREATE INDEX indx_genero ON genres(name);

SELECT m.title, g.name FROM movies m
JOIN genres g ON g.id = m.genre_id
WHERE g.name = 'Drama';

EXPLAIN SELECT m.title, g.name FROM movies m
JOIN genres g ON g.id = m.genre_id
WHERE g.name = 'Drama';

-- 