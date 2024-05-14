SELECT *
FROM Autor; 

SELECT nombre, edad
FROM Estudiante;

SELECT nombre, apellido
FROM Estudiante
Where carrera LIKE "%Informatica%";

SELECT nombre 
FROM Autor
WHERE Nacionalidad LIKE "Italiana" OR Nacionalidad LIKE "Francesa";

SELECT Titulo 
FROM Libro
WHERE Area <> "Internet";

SELECT Titulo 
FROM Libro
WHERE Editorial LIKE "Sudamericana";

SELECT Nombre, Edad
FROM Estudiante 
WHERE Edad > (SELECT AVG(Edad)
				FROM Estudiante);
                
SELECT Nombre, Apellido
FROM Estudiante 
WHERE Apellido LIKE "G%";

SELECT l.titulo
FROM prestamo as p
INNER JOIN Libro as l
ON p.idLibro = l.idLibro 
INNER JOIN Estudiante as e
ON e.idLector = l.idLibro 
WHERE e.nombre LIKE "Filippo";

SELECT nombre 
FROM Estudiante 
WHERE Edad < 18;

SELECT e.nombre 
FROM Prestamo
INNER JOIN Estudiante as e
ON Prestamo.idLector = e.idLector
