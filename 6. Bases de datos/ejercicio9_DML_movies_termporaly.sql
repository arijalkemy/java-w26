-- Se utiliza la tabla de movies
USE movies_db;

-- Se crea la tabla temporal
CREATE TEMPORARY TABLE IF NOT EXISTS  TWD (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
temporada INT,
episodio INT,
titulo VARCHAR(255)
);

-- Se insertan valores a la tabla temporal
INSERT INTO TWD (temporada, episodio, titulo) VALUES
(1, 1, 'Days Gone Bye'),
(1, 2, 'Guts'),
(1, 3, 'Tell It to the Frogs'),
(1, 4, 'Vatos'),
(2, 1, 'What Lies Ahead'),
(2, 2, 'Bloodletting'),
(2, 3, 'Save the Last One'),
(2, 4, 'Cherokee Rose');

-- Se consulta a la tabla temporal para ver los episodios de la primera temporada.
SELECT * FROM TWD WHERE temporada = 1;

-- Se crea el index de last_name para las busquedas de apellidos de los actores
CREATE INDEX index_last_name
ON actors (last_name);

-- Se muestran los indexes que existen en la tabla de actors
SHOW INDEX FROM actors;

-- Se realiza la consulta de los actores
SELECT * FROM actors WHERE last_name = "Depp";

-- Se selecciona el last name como index ya que, este es uno de los campos más comunes que posiblemente se realice la consulta a la tabla