# Ejercicio 1

# A. Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD”
# y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
CREATE TEMPORARY TABLE TWD (
	SELECT e.id, e.title, e.`number`, e.release_date, e.rating, e.season_id, e.created_at, e.updated_at FROM episodes e
	INNER JOIN seasons s ON e.season_id = s.id
	INNER JOIN series se ON s.serie_id = se.id
	WHERE se.title = "The Walking Dead"
);

# B. Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
SELECT * FROM TWD;



# Ejercicio 2
# A. En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.
CREATE INDEX index_gender_movies ON movies (genre_id);

# B. Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.
-- creamos index ya que en la tablas de peliculas se consulta mucho el genero.
