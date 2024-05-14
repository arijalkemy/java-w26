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

select *
from Autor;

# Listar nombre y edad de los estudiantes

select e.Nombre, e.Edad
from Estudiante e;

# ¿Qué estudiantes pertenecen a la carrera informática?

select e.*
from Estudiante e
where e.Carrera = 'Informatica';

# ¿Qué autores son de nacionalidad francesa o italiana?

select *
from Autor a
where a.Nacionalidad = 'Francia'
   or a.Nacionalidad = 'Italia';

# ¿Qué libros no son del área de internet?

select *
from Libro l
where l.Area <> 'Internet';

# Listar los libros de la editorial Salamandra.

select *
from Libro l
where l.Editorial = 'Salamandra';

# Listar los datos de los estudiantes cuya edad es mayor al promedio.

select *
from Estudiante e
where e.Edad > (select AVG(e2.Edad) from Estudiante e2);

# Listar los nombres de los estudiantes cuyo apellido comience con la letra G.

select
    e.*
from Estudiante e
where e.Apellido like 'G%';

# Listar los autores del libro “El Universo: Guía de viaje”.
# (Se debe listar solamente los nombres).

select
    A.Nombre
from Autor a inner join LibroAutor LA on a.idAutor = LA.idAutor
    inner join Libro L on LA.idLibro = L.idLibro
where L.Titulo = 'El Universo: Guía de viaje';

# ¿Qué libros se prestaron al lector “Filippo Galli”?

select
    l.*
from Libro l inner join Prestamo p on l.idLibro = p.idLibro
    inner join Estudiante on p.idLector = Estudiante.idLector
where Estudiante.Nombre= 'Filippo' and Estudiante.Apellido='Galli';

# Listar el nombre del estudiante de menor edad.

select
    e.*
from Estudiante e
order by e.Edad
limit 1;

# Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.

select
    e.*
from Estudiante e inner join Prestamo on e.idLector = Prestamo.idLector
    inner join Libro l on Prestamo.idLibro = l.idLibro
where l.Area ='Base de Datos';

# Listar los libros que pertenecen a la autora J.K. Rowling.

select
    l.*
from Libro l join LibroAutor la on l.idLibro = la.idLibro
    join Autor a on la.idAutor = a.idAutor
where a.Nombre='J.K. Rowling';

# Listar títulos de los libros que debían devolverse el 16/07/2021.

SELECT
    l.Titulo,
    p.FechaDevolucion
FROM
    Libro l
JOIN
    Prestamo p ON l.idLibro = p.idLibro
WHERE
    p.FechaDevolucion = DATE('2021-07-16');














