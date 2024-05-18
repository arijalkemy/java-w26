CREATE SCHEMA IF NOT EXISTS libros_db;
USE libros_db;

DROP TABLE IF EXISTS autor;

CREATE TABLE autor (
	idAutor INT AUTO_INCREMENT,
    Nombre VARCHAR(60) NOT NULL,
    Nacionalidad VARCHAR(60) NOT NULL,
    CONSTRAINT pk_idAutor PRIMARY KEY(idAutor)
);

DROP TABLE IF EXISTS estudiante;

CREATE TABLE estudiante(
	idLector INT AUTO_INCREMENT,
    Nombre VARCHAR(60) NOT NULL,
    Apellido VARCHAR(60) NOT NULL,
    Direccion VARCHAR(100),
    Carrera VARCHAR(100),
    Edad INT,
    CONSTRAINT pk_idLector PRIMARY KEY (idLector)
);

DROP TABLE IF EXISTS libro;

CREATE TABLE libro(
	idLibro INT AUTO_INCREMENT,
	Titulo VARCHAR(150) NOT NULL,
    Editorial VARCHAR(60) NOT NULL,
    Area VARCHAR(60) NOT NULL,
	CONSTRAINT pk_idLibro PRIMARY KEY (idLibro)
);

DROP TABLE IF EXISTS libroautor;

CREATE TABLE libroautor(
    idAutor INT NOT NULL,
    idLibro INT NOT NULL,
    PRIMARY KEY (idAutor, idLibro),
    CONSTRAINT fk_idAutor FOREIGN KEY autor(idAutor) REFERENCES autor(idAutor),
    CONSTRAINT fk_idLibro FOREIGN KEY libro(idLibro) REFERENCES libro(idLibro)
);

DROP TABLE IF EXISTS prestamo;

CREATE TABLE prestamo(
	idLector INT NOT NULL,
    idLibro INT NOT NULL,
    FechaPrestamo DATE NOT NULL,
    FechaDevolucion DATE NOT NULL,
    Devuelto BOOLEAN NOT NULL DEFAULT(false),
    PRIMARY KEY (idLector, idLibro),
    CONSTRAINT fk_idLector FOREIGN KEY estudiante(idLector) REFERENCES estudiante(idLector),
    CONSTRAINT fk_idLibroPrestamo FOREIGN KEY libro(idLibro) REFERENCES libro(idLibro)
);


INSERT INTO libro (Titulo, Editorial, Area) VALUES
('Cien Años de Soledad', 'Editorial Sudamericana', 'Novela'),
('Don Quijote de la Mancha', 'Francisco de Robles', 'Novela'),
('El Aleph', 'Editorial Losada', 'Cuento'),
('Ficciones', 'Editorial Sur', 'Cuento'),
('Rayuela', 'Editorial Sudamericana', 'Novela'),
('El Universo: Guía de viaje', 'Salamandra', 'Ciencia'),
('Harry Potter y la Piedra Filosofal', 'Salamandra', 'Fantasía'),
('El Señor de los Anillos', 'Minotauro', 'Fantasía'),
('Introducción a la Informática', 'Alianza Editorial', 'Informática'),
('Base de Datos', 'Pearson', 'Informática');


INSERT INTO autor (Nombre, Nacionalidad) VALUES
('Gabriel García Márquez', 'Colombiana'),
('Miguel de Cervantes', 'Española'),
('Jorge Luis Borges', 'Argentina'),
('Julio Cortázar', 'Argentina'),
('J.K. Rowling', 'Británica'),
('J.R.R. Tolkien', 'Británica'),
('Pierre Simon', 'Francesa'),
('Marco Rossi', 'Italiana');

INSERT INTO libroautor (idLibro, idAutor) VALUES
(1, 1),  -- 'Cien Años de Soledad' por 'Gabriel García Márquez'
(2, 2),  -- 'Don Quijote de la Mancha' por 'Miguel de Cervantes'
(3, 3),  -- 'El Aleph' por 'Jorge Luis Borges'
(4, 3),  -- 'Ficciones' por 'Jorge Luis Borges'
(5, 4),  -- 'Rayuela' por 'Julio Cortázar'
(6, 7),  -- 'El Universo: Guía de viaje' por 'Pierre Simon'
(7, 5),  -- 'Harry Potter y la Piedra Filosofal' por 'J.K. Rowling'
(8, 6),  -- 'El Señor de los Anillos' por 'J.R.R. Tolkien'
(9, 8),  -- 'Introducción a la Informática' por 'Marco Rossi'
(10, 8); -- 'Base de Datos' por 'Marco Rossi'


INSERT INTO estudiante (idLector, Nombre, Apellido, Direccion, Carrera, Edad) VALUES
(1, 'Juan', 'Pérez', 'Calle Falsa 123', 'Ingeniería', 21),
(2, 'María', 'González', 'Avenida Siempre Viva 456', 'Medicina', 23),
(3, 'Luis', 'Martínez', 'Calle Luna 789', 'Derecho', 22),
(4, 'Ana', 'Rodríguez', 'Pasaje Estrella 101', 'Arquitectura', 20),
(5, 'Pedro', 'López', 'Boulevard Sol 102', 'Economía', 24),
(6, 'Carla', 'Gómez', 'Calle Sol 104', 'Informática', 22),
(7, 'José', 'Fernández', 'Calle Estrella 105', 'Informática', 25),
(8, 'Filippo', 'Galli', 'Via Roma 206', 'Informática', 21);


INSERT INTO prestamo (idLibro, idLector, FechaPrestamo, FechaDevolucion, Devuelto) VALUES
(1, 1, '2024-01-01', '2024-01-15', 1),  -- 'Cien Años de Soledad' prestado y devuelto
(2, 2, '2024-02-01' , '2024-02-15', 0),  -- 'Don Quijote de la Mancha' prestado y no devuelto
(3, 3, '2024-03-01', '2024-03-10', 1),  -- 'El Aleph' prestado y devuelto
(4, 3, '2024-04-01', '2024-04-20', 0),  -- 'Ficciones' prestado y no devuelto
(5, 4, '2024-05-01', '2024-05-10', 1),  -- 'Rayuela' prestado y devuelto
(6, 8, '2024-06-01', '2024-06-15', 0),  -- 'El Universo: Guía de viaje' prestado a Filippo Galli
(10, 8, '2021-07-01', '2021-07-16', 1); -- 'Base de Datos' prestado y devuelto

