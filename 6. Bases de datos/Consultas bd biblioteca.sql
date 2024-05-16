# EJERCICIO 2

CREATE SCHEMA IF NOT EXISTS libros_db;
USE libros_db;

DROP TABLE IF EXISTS autor;

CREATE TABLE autor (
	idAutor INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(60) NOT NULL,
    Nacionalidad VARCHAR(60) NOT NULL
);

DROP TABLE IF EXISTS estudiante;

CREATE TABLE estudiante(
	idLector INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(60) NOT NULL,
    Apellido VARCHAR(60) NOT NULL,
    Direccion VARCHAR(100),
    Carrera VARCHAR(100),
    Edad INT
);

DROP TABLE IF EXISTS libro;

CREATE TABLE libro(
	idLibro INT AUTO_INCREMENT PRIMARY KEY,
	Titulo VARCHAR(150) NOT NULL,
    Editorial VARCHAR(60) NOT NULL,
    Area VARCHAR(60) NOT NULL
);

DROP TABLE IF EXISTS libroautor;

CREATE TABLE libroautor(
    idAutor INT NOT NULL,
    idLibro INT NOT NULL,
    PRIMARY KEY (idAutor, idLibro),
    FOREIGN KEY (idAutor) REFERENCES autor(idAutor),
    FOREIGN KEY (idLibro) REFERENCES libro(idLibro)
);

DROP TABLE IF EXISTS prestamo;

CREATE TABLE prestamo(
	idLector INT NOT NULL,
    idLibro INT NOT NULL,
    FechaPrestamo DATE NOT NULL,
    FechaDevolucion DATE NOT NULL,
    Devuelto BOOLEAN NOT NULL DEFAULT(false),
    PRIMARY KEY (idLector, idLibro),
    FOREIGN KEY (idLector) REFERENCES estudiante(idLector),
    FOREIGN KEY (idLibro) REFERENCES libro(idLibro)
);

-- Insertar autores
INSERT INTO autor (Nombre, Nacionalidad) VALUES
    ('Gabriel García Márquez', 'Colombiano'),
    ('J.K. Rowling', 'Británica'),
    ('Haruki Murakami', 'Japonés'),
    ('Isabel Allende', 'Chilena'),
    ('Stephen King', 'Estadounidense');

-- Insertar estudiantes
INSERT INTO estudiante (Nombre, Apellido, Direccion, Carrera, Edad) VALUES
    ('Ana', 'Gómez', 'Calle 123, Bogotá', 'Informatica', 20),
    ('Carlos', 'Pérez', 'Av. Principal, Medellín', 'Medicina', 22),
    ('Laura', 'Rodríguez', 'Carrera 7, Cali', 'Derecho', 21),
    ('Pedro', 'Martínez', 'Calle 10, Barranquilla', 'Economía', 23),
    ('María', 'López', 'Calle 5, Cartagena', 'Arquitectura', 19);

-- Insertar libros
INSERT INTO libro (Titulo, Editorial, Area) VALUES
    ('Cien años de soledad', 'Sudamericana', 'Realismo mágico'),
    ('Harry Potter y la piedra filosofal', 'Bloomsbury', 'Fantasía'),
    ('Tokio Blues', 'Kodansha', 'Contemporánea'),
    ('La casa de los espíritus', 'Plaza & Janés', 'Realismo mágico'),
    ('It', 'Salamandra', 'Terror'),
	('El Universo: Guía de viaje', 'Salamandra', 'Fantasia');

-- Asociar autores con libros
INSERT INTO libroautor (idAutor, idLibro) VALUES
    (1, 1), -- Gabriel García Márquez con "Cien años de soledad"
    (2, 2), -- J.K. Rowling con "Harry Potter y la piedra filosofal"
    (3, 3), -- Haruki Murakami con "Tokio Blues"
    (4, 4), -- Isabel Allende con "La casa de los espíritus"
    (5, 5), -- Stephen King con "It"
	(1, 6),
    (2, 6);
    
-- Registrar préstamos
INSERT INTO prestamo (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) VALUES
    (1, 1, '2024-05-14', '2024-06-14', true),
    (2, 3, '2024-05-15', '2024-06-15', false),
    (3, 2, '2024-05-16', '2024-06-16', false),
    (4, 4, '2024-05-17', '2024-06-17', true),
    (5, 5, '2024-05-18', '2024-06-18', false);
    
# EJERCICIO 1

# 1. Listar los datos de los autores.
SELECT *
FROM autor;

# 2. Listar nombre y edad de los estudiantes
SELECT Nombre, Edad
FROM estudiante;

# 3. ¿Qué estudiantes pertenecen a la carrera informática?
SELECT *
FROM estudiante
WHERE Carrera = 'Informatica';

# 4. ¿Qué autores son de nacionalidad francesa o italiana?
SELECT *
FROM autor
WHERE Nacionalidad = 'Francesa' OR Nacionalidad = 'Italiana';

# 5. ¿Qué libros no son del área de internet?
SELECT *
FROM libro
WHERE Area != 'Internet';

# 6. Listar los libros de la editorial Salamandra.
SELECT *
FROM libro
WHERE Editorial = 'Salamandra';

# 7. Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT *
FROM estudiante
WHERE Edad > (SELECT AVG(Edad) FROM estudiante);

# 8. Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT Nombre, Apellido
FROM estudiante
WHERE Apellido Like 'G%';

# 9. Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT Nombre
FROM autor a 
INNER JOIN libroautor la ON a.idAutor=la.idAutor
INNER JOIN libro l ON l.idLibro = la.idLibro
WHERE l.Titulo='El Universo: Guía de viaje';

# 10. ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT l.Titulo, l.Editorial
FROM estudiante e 
INNER JOIN prestamo p ON e.idLector = p.idLector
INNER JOIN libro l ON l.idLibro = p.idLibro
WHERE e.Nombre = 'Filippo' AND e.Apellido = 'Galli';

# 11. Listar el nombre del estudiante de menor edad.
SELECT Nombre, Apellido, Edad
FROM estudiante
WHERE Edad < 18;

# 12. Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT e.Nombre, e.Apellido
FROM estudiante e 
INNER JOIN prestamo p ON e.idLector = p.idLector
INNER JOIN libro l ON l.idLibro = p.idLibro;

# 13. Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.Titulo, l.Editorial
FROM libro l 
INNER JOIN libroautor la ON la.idLibro = l.idLibro
INNER JOIN autor a ON a.idAutor = la.idAutor
WHERE a.Nombre = 'J.K. Rowling';

# 14. Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT l.Titulo, l.Editorial
FROM libro l INNER JOIN prestamo p ON p.idLibro = l.idLibro
WHERE p.FechaDevolucion = '2021-07-16';
