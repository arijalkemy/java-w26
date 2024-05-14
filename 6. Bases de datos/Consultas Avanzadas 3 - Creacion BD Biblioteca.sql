CREATE DATABASE `biblioteca_db`;


CREATE TABLE `Autor` (
  `idAutor` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `nacionalidad` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idAutor`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- biblioteca_db.Estudiante definition

CREATE TABLE `Estudiante` (
  `idLector` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `apellido` varchar(100) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `carrera` varchar(100) DEFAULT NULL,
  `edad` int DEFAULT NULL,
  PRIMARY KEY (`idLector`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- biblioteca_db.Libro definition

CREATE TABLE `Libro` (
  `idLibro` int NOT NULL,
  `titulo` varchar(100) DEFAULT NULL,
  `editorial` varchar(100) DEFAULT NULL,
  `area` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idLibro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- biblioteca_db.LibroAutor definition

CREATE TABLE `LibroAutor` (
  `idAutor` int NOT NULL AUTO_INCREMENT,
  `idLibro` int NOT NULL,
  PRIMARY KEY (`idAutor`),
  KEY `LibroAutor_Libro_FK` (`idLibro`),
  CONSTRAINT `LibroAutor_Autor_FK` FOREIGN KEY (`idAutor`) REFERENCES `Autor` (`idAutor`),
  CONSTRAINT `LibroAutor_Libro_FK` FOREIGN KEY (`idLibro`) REFERENCES `Libro` (`idLibro`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- biblioteca_db.Prestamo definition

CREATE TABLE `Prestamo` (
  `idLector` int NOT NULL AUTO_INCREMENT,
  `idLibro` int NOT NULL,
  `fechaPrestamo` date NOT NULL,
  `fechaDevolucion` date DEFAULT NULL,
  `devuelto` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idLector`),
  KEY `Prestamo_Libro_FK` (`idLibro`),
  CONSTRAINT `Prestamo_Estudiante_FK` FOREIGN KEY (`idLector`) REFERENCES `Estudiante` (`idLector`),
  CONSTRAINT `Prestamo_Libro_FK` FOREIGN KEY (`idLibro`) REFERENCES `Libro` (`idLibro`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- popular bd

INSERT INTO biblioteca_db.Autor
(nombre, nacionalidad)
VALUES('Garcia Marquez', 'Colombiano');
INSERT INTO biblioteca_db.Autor
(nombre, nacionalidad)
VALUES('Murakami', 'Japones');
INSERT INTO biblioteca_db.Autor
(nombre, nacionalidad)
VALUES('Paulo Coelho', 'Brasilero');
INSERT INTO biblioteca_db.Autor
(nombre, nacionalidad)
VALUES('Francesco Rossi', 'Italiana');
INSERT INTO biblioteca_db.Autor
(nombre, nacionalidad)
VALUES('J.K. Rowling', 'Britanica');

INSERT INTO biblioteca_db.LibroAutor
(idLibro)
VALUES(1);
INSERT INTO biblioteca_db.LibroAutor
(idLibro)
VALUES(2);
INSERT INTO biblioteca_db.LibroAutor
(idLibro)
VALUES(3);
INSERT INTO biblioteca_db.LibroAutor
(idLibro)
VALUES(4);
INSERT INTO biblioteca_db.LibroAutor
(idLibro)
VALUES(5);

INSERT INTO biblioteca_db.Libro
(idLibro, titulo, editorial, area)
VALUES(1, 'Harry Potter', 'Santillana', 'Cuentos');
INSERT INTO biblioteca_db.Libro
(idLibro, titulo, editorial, area)
VALUES(2, 'Javascript', 'Clara', 'Informatica');
INSERT INTO biblioteca_db.Libro
(idLibro, titulo, editorial, area)
VALUES(3, 'El universo: Guia de viaje', 'Paidos', 'Cuentos');
INSERT INTO biblioteca_db.Libro
(idLibro, titulo, editorial, area)
VALUES(4, 'BD Relacionales', 'Hann', 'Bases de datos');
INSERT INTO biblioteca_db.Libro
(idLibro, titulo, editorial, area)
VALUES(5, 'Java Code', 'Salamandra', 'Informatica');

INSERT INTO biblioteca_db.Prestamo
(idLibro, fechaPrestamo, fechaDevolucion, devuelto)
VALUES(1, '2024-05-02', '2024-05-05', 1);
INSERT INTO biblioteca_db.Prestamo
(idLibro, fechaPrestamo, fechaDevolucion, devuelto)
VALUES(2, '2024-05-02', '2024-05-06', 1);
INSERT INTO biblioteca_db.Prestamo
(idLibro, fechaPrestamo, fechaDevolucion, devuelto)
VALUES(3, '2021-07-10', '2021-07-16', 1);
INSERT INTO biblioteca_db.Prestamo
(idLibro, fechaPrestamo, fechaDevolucion, devuelto)
VALUES(4, '2024-05-02', '2024-05-08', 1);
INSERT INTO biblioteca_db.Prestamo
(idLibro, fechaPrestamo, fechaDevolucion, devuelto)
VALUES(5, '2021-07-04', '2021-07-16', 1);

INSERT INTO biblioteca_db.Estudiante
(nombre, apellido, direccion, carrera, edad)
VALUES('Juan', 'Perez', 'Direccion 123', 'Ingenieria', 20);
INSERT INTO biblioteca_db.Estudiante
(nombre, apellido, direccion, carrera, edad)
VALUES('Pedro', 'Pe', 'Avenida Gaona 32', 'Abogacia', 22);
INSERT INTO biblioteca_db.Estudiante
(nombre, apellido, direccion, carrera, edad)
VALUES('Luz', 'Guzman', 'Av. Directorio 432', 'Relaciones Publicas', 25);
INSERT INTO biblioteca_db.Estudiante
(nombre, apellido, direccion, carrera, edad)
VALUES('John', 'Doe', 'Lope de vega 54', 'Ingenieria', 23);
INSERT INTO biblioteca_db.Estudiante
(nombre, apellido, direccion, carrera, edad)
VALUES('Filippo', 'Galli', 'Ortega 4321', 'Informatica', 26);