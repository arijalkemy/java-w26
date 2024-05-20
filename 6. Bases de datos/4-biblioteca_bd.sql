use biblioteca_db;

-- Creación de la tabla Libro
CREATE TABLE IF NOT EXISTS Libro
(
    idLibro   INT PRIMARY KEY,
    Titulo    VARCHAR(100),
    Editorial VARCHAR(100),
    Area      VARCHAR(50)
);

-- Creación de la tabla Autor
CREATE TABLE IF NOT EXISTS Autor
(
    idAutor      INT PRIMARY KEY,
    Nombre       VARCHAR(100),
    Nacionalidad VARCHAR(100)
);

-- Creación de la tabla LibroAutor para la relación muchos-a-muchos entre Libro y Autor
CREATE TABLE IF NOT EXISTS LibroAutor
(
    idAutor INT,
    idLibro INT,
    PRIMARY KEY (idAutor, idLibro),
    FOREIGN KEY (idAutor) REFERENCES Autor (idAutor),
    FOREIGN KEY (idLibro) REFERENCES Libro (idLibro)
);


-- Creación de la tabla Estudiante
CREATE TABLE IF NOT EXISTS Estudiante
(
    idLector  INT PRIMARY KEY,
    Nombre    VARCHAR(100),
    Apellido  VARCHAR(100),
    Direccion VARCHAR(200),
    Carrera   VARCHAR(100),
    Edad      INT
);


-- Creación de la tabla Prestamo
CREATE TABLE IF NOT EXISTS Prestamo
(
    idLector        INT,
    idLibro         INT,
    FechaPrestamo   DATE,
    FechaDevolucion DATE,
    Devuelto        BOOLEAN,
    FOREIGN KEY (idLector) REFERENCES Estudiante (idLector),
    FOREIGN KEY (idLibro) REFERENCES Libro (idLibro)
);

-- Insertar datos en la tabla Libro
INSERT INTO Libro (idLibro, Titulo, Editorial, Area)
VALUES (1, 'El Aleph', 'Sur', 'Ficción'),
       (2, 'Cien años de soledad', 'Sudamericana', 'Realismo mágico'),
       (3, 'El Principito', 'Reynal & Hitchcock', 'Infantil');

-- Insertar datos en la tabla Autor
INSERT INTO Autor (idAutor, Nombre, Nacionalidad)
VALUES (1, 'Jorge Luis Borges', 'Argentina'),
       (2, 'Gabriel García Márquez', 'Colombia'),
       (3, 'Antoine de Saint-Exupéry', 'Francia');

-- Insertar datos en la tabla LibroAutor
INSERT INTO LibroAutor (idAutor, idLibro)
VALUES (1, 1),
       (2, 2),
       (3, 3);

-- Insertar datos en la tabla Estudiante
INSERT INTO Estudiante (idLector, Nombre, Apellido, Direccion, Carrera, Edad)
VALUES (1, 'Juan', 'Pérez', 'Calle 123', 'Historia', 20),
       (2, 'María', 'Gómez', 'Avenida 456', 'Literatura', 22);

-- Insertar datos en la tabla Prestamo
INSERT INTO Prestamo (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto)
VALUES (1, 1, '2024-05-01', '2024-05-10', true),
       (2, 2, '2024-04-15', '2024-04-30', false);

# Listar los datos de los autores.
SELECT *
FROM Autor;

# Listar nombre y edad de los estudiantes
SELECT nombre, edad
FROM Estudiante;

# ¿Qué estudiantes pertenecen a la carrera informática?
SELECT E.*
FROM Estudiante E
WHERE E.carrera = 'informática';

# ¿Qué autores son de nacionalidad francesa o italiana?
SELECT A.*
FROM Autor A
WHERE A.nacionalidad = 'francesa' 
	OR A.nacionalidad = 'italiana';

# ¿Qué libros no son del área de internet?
SELECT L.*
FROM Libros L
WHERE L.area NOT LIKE 'internet';
--
SELECT L.*
FROM Libros L
WHERE L.area <> 'internet';

# Listar los libros de la editorial Salamandra.
SELECT L.*
FROM Libro L
WHERE L.editorial = 'salamandra';

# Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT E.*
FROM Estudiante E
WHERE E.edad > (
		SELECT AVG(E2.edad)
		FROM estudiante E2
        );


# Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT E.nombre
FROM Estudiante E
WHERE E.apellido LIKE 'G%';

# Listar los autores del libro "El Universo: Guía de viaje".
# (Se debe listar solamente los nombres).
SELECT A.nombre
FROM Autor A 
WHERE A.id IN (
	SELECT LA.idAutor
    FROM LibroAutor LA
    INNER JOIN Libro L	
		ON L.id = LA.idLibro
	WHERE L.titulo LIKE 'El Universo: Guía de viaje'
    );
--
SELECT A.Nombre
FROM Autor a 
INNER JOIN LibroAutor LA 
	ON a.idAutor = LA.idAutor
INNER JOIN Libro L 
	ON LA.idLibro = L.idLibro
WHERE L.Titulo = 'El Universo: Guía de viaje';

# ¿Qué libros se prestaron al lector "Filippo Galli"?
SELECT L.*
FROM Libro L 
INNER JOIN Prestamo P 
	ON L.idLibro = P.idLibro
INNER JOIN Estudiante E
	ON P.idLector = E.idLector
WHERE E.Nombre = 'Filippo' AND E.Apellido = 'Galli';

# Listar el nombre del estudiante de menor edad.
SELECT E.*
FROM Estudiante E
ORDER BY E.Edad
LIMIT 1;

# Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT E.*
FROM Estudiante E 
INNER JOIN Prestamo P
	ON E.idLector = P.idLector
INNER JOIN Libro L 
	ON P.idLibro = L.idLibro
WHERE L.area ='Base de Datos';

# Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT L.*
FROM Libro   
JOIN LibroAutor LA 
	ON L.idLibro = LA.idLibro
JOIN Autor A 
	ON LA.idAutor = A.idAutor
WHERE A.nombre='J.K. Rowling';

# Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT L.titulo, P.FechaDevolucion
FROM Libro l
JOIN Prestamo P 
	ON L.idLibro = P.idLibro
WHERE P.FechaDevolucion = STR_TO_DATE('16/07/2021', '%d/%m/%Y');
    
    
SELECT STR_TO_DATE('06-07-2021', '%d-%m-%y');
SELECT STR_TO_DATE('06/07/2021', '%d/%m/%y'); 
    
    
    
    
    