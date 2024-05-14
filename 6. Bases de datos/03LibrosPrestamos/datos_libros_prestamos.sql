CREATE TABLE `libro` (
  `idLibro` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(100) NOT NULL,
  `editorial` varchar(100) NOT NULL,
  `area` varchar(100) NOT NULL,
  PRIMARY KEY (`idLibro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `prestamo` (
  `idLector` int NOT NULL,
  `idLibro` int NOT NULL,
  `fechaPrestamo` timestamp NOT NULL,
  `fechaDevolucion` timestamp NOT NULL,
  `devuelto` tinyint(1) NOT NULL,
  `idPrestamo` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idPrestamo`),
  KEY `prestamo_libro_FK` (`idLibro`),
  KEY `prestamo_estudiante_FK` (`idLector`),
  CONSTRAINT `prestamo_estudiante_FK` FOREIGN KEY (`idLector`) REFERENCES `estudiante` (`idLector`),
  CONSTRAINT `prestamo_libro_FK` FOREIGN KEY (`idLibro`) REFERENCES `libro` (`idLibro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `libroAutor` (
  `idLibroAutor` int NOT NULL AUTO_INCREMENT,
  `idLibro` int NOT NULL,
  `idAutor` int NOT NULL,
  PRIMARY KEY (`idLibroAutor`),
  KEY `libroAutor_libro_FK` (`idLibro`),
  KEY `libroAutor_autor_FK` (`idAutor`),
  CONSTRAINT `libroAutor_autor_FK` FOREIGN KEY (`idAutor`) REFERENCES `autor` (`idAutor`),
  CONSTRAINT `libroAutor_libro_FK` FOREIGN KEY (`idLibro`) REFERENCES `libro` (`idLibro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `autor` (
  `idAutor` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `nacionalidad` varchar(100) NOT NULL,
  PRIMARY KEY (`idAutor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `estudiante` (
  `idLector` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `carrera` varchar(100) NOT NULL,
  `edad` int NOT NULL,
  PRIMARY KEY (`idLector`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Datos de ejemplo para la tabla 'libro'
INSERT INTO libro (titulo, editorial, area) VALUES
('El Señor de los Anillos', 'Minotauro', 'Fantasía'),
('Cien años de soledad', 'Diana', 'Realismo mágico'),
('1984', 'Debolsillo', 'Ciencia ficción'),
('Harry Potter y la piedra filosofal', 'Salamandra', 'Fantasía'),
('El código Da Vinci', 'Umbriel', 'Misterio'),
('El Principito', 'Salamandra', 'Infantil');
-- Datos de ejemplo para la tabla 'autor'
INSERT INTO autor (nombre, nacionalidad) VALUES
('J.R.R. Tolkien', 'Inglaterra'),
('Gabriel García Márquez', 'Colombia'),
('George Orwell', 'Inglaterra'),
('J.K. Rowling', 'Reino Unido'),
('Dan Brown', 'Estados Unidos'),
('Antoine de Saint-Exupéry', 'Francia');
-- Datos de ejemplo para la tabla 'estudiante'
INSERT INTO estudiante (nombre, apellido, direccion, carrera, edad) VALUES
('Juan', 'Perez', 'Calle 123', 'Informática', 20),
('Maria', 'Gomez', 'Avenida 456', 'Arquitectura', 22),
('Luis', 'Martinez', 'Carrera 789', 'Derecho', 21),
('Ana', 'Rodriguez', 'Calle Principal', 'Medicina', 23),
('Carlos', 'Sanchez', 'Avenida Central', 'Administración', 24);
-- Datos de ejemplo para la tabla 'libroAutor'
INSERT INTO libroAutor (idLibro, idAutor) VALUES
(1, 1), -- El Señor de los Anillos - J.R.R. Tolkien
(2, 2), -- Cien años de soledad - Gabriel García Márquez
(3, 3), -- 1984 - George Orwell
(4, 4), -- Harry Potter y la piedra filosofal - J.K. Rowling
(5, 5), -- El código Da Vinci - Dan Brown
(6, 6); -- El Principito - Antoine de Saint-Exupéry
-- Datos de ejemplo para la tabla 'prestamo'
INSERT INTO prestamo (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto) VALUES
(1, 1, '2024-05-01 10:00:00', '2024-05-15 10:00:00', 1), -- Juan prestó El Señor de los Anillos
(2, 2, '2024-05-02 10:00:00', '2024-05-16 10:00:00', 0), -- Maria prestó Cien años de soledad (no devuelto aún)
(3, 3, '2024-05-03 10:00:00', '2024-05-17 10:00:00', 1), -- Luis prestó 1984
(4, 4, '2024-05-04 10:00:00', '2024-05-18 10:00:00', 1), -- Ana prestó Harry Potter y la piedra filosofal
(5, 5, '2024-05-05 10:00:00', '2024-05-19 10:00:00', 0); -- Carlos prestó El código Da Vinci (no devuelto aún)libro