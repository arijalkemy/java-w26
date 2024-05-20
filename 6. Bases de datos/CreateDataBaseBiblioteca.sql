DROP DATABASE IF EXISTS biblioteca;
CREATE DATABASE biblioteca;

USE biblioteca;

DROP TABLE IF EXISTS libro;
CREATE TABLE libro(
	id_libro INT NOT NULL AUTO_INCREMENT,
    titulo varchar(50) NOT NULL,
    editorial VARCHAR(50) NOT NULL,
    area VARCHAR(50) NOT NULL,
    PRIMARY KEY (id_libro)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

DROP TABLE IF EXISTS autor;
CREATE TABLE autor(
	id_autor INT NOT NULL AUTO_INCREMENT,
    nombre varchar(50) NOT NULL,
    nacionalidad VARCHAR(50) NOT NULL,
    PRIMARY KEY (id_autor)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

DROP TABLE IF EXISTS estudiante;
CREATE TABLE estudiante(
	id_lector INT NOT NULL AUTO_INCREMENT,
    nombre varchar(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    direccion VARCHAR(50) NOT NULL,
    carrera VARCHAR(50) NOT NULL,
    edad int NOT NULL,
    PRIMARY KEY (id_lector)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

DROP TABLE IF EXISTS libro_autor;
CREATE TABLE libro_autor(
	id INT NOT NULL AUTO_INCREMENT,
	id_autor INT NOT NULL,
    id_libro INT NOT NULL,
    PRIMARY KEY (id),
    KEY `libro_autor_id_libro_foreign` (`id_libro`),
    CONSTRAINT `libro_autor_id_libro_foreign` FOREIGN KEY (`id_libro`) REFERENCES `libro` (`id_libro`),
    KEY `libro_autor_id_autor_foreign` (`id_autor`),
    CONSTRAINT `libro_autor_id_autor_foreign` FOREIGN KEY (`id_autor`) REFERENCES `autor` (`id_autor`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

DROP TABLE IF EXISTS prestamo;
CREATE TABLE prestamo(
	id INT NOT NULL AUTO_INCREMENT,
	id_lector INT NOT NULL,
    id_libro INT NOT NULL,
    fecha_prestamo DATE NOT NULL,
    fecha_devolucion DATE NOT NULL,
    devuelto BIT NOT NULL,
    PRIMARY KEY (id),
    KEY `prestamo_id_lector_foreign` (`id_lector`),
    CONSTRAINT `prestamo_id_lector_foreign` FOREIGN KEY (`id_lector`) REFERENCES `estudiante` (`id_lector`),
    KEY `prestamo_id_libro_foreign` (`id_libro`),
    CONSTRAINT `prestamo_id_libro_foreign` FOREIGN KEY (`id_libro`) REFERENCES `libro` (`id_libro`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Inserciones de datos de prueba para la tabla libro
INSERT INTO libro (titulo, editorial, area) VALUES
('El nombre del viento', 'Penguin Random House', 'Fantasía'),
('Cien años de soledad', 'Editorial Sudamericana', 'Realismo mágico'),
('1984', 'Debolsillo', 'Ciencia ficción'),
('Don Quijote de la Mancha', 'Real Academia Española', 'Novela'),
('Harry Potter y la piedra filosofal', 'Salamandra', 'Fantasía');

-- Inserciones de datos de prueba para la tabla autor
INSERT INTO autor (nombre, nacionalidad) VALUES
('Patrick Rothfuss', 'Estadounidense'),
('Gabriel García Márquez', 'Colombiano'),
('George Orwell', 'Británico'),
('Miguel de Cervantes', 'Español'),
('J.K. Rowling', 'Británica');

-- Inserciones de datos de prueba para la tabla estudiante
INSERT INTO estudiante (nombre, apellido, direccion, carrera, edad) VALUES
('Juan', 'Pérez', 'Calle Principal 123', 'Literatura', 20),
('María', 'Gómez', 'Avenida Central 456', 'Historia', 22),
('Carlos', 'López', 'Plaza Mayor 789', 'Ingeniería', 21),
('Ana', 'Martínez', 'Callejón Secreto 321', 'Psicología', 23),
('Luis', 'Hernández', 'Paseo del Parque 654', 'Biología', 19);

-- Inserciones de datos de prueba para la tabla libro_autor
INSERT INTO libro_autor (id_autor, id_libro) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

-- Inserciones de datos de prueba para la tabla prestamo
INSERT INTO prestamo (id_lector, id_libro, fecha_prestamo, fecha_devolucion, devuelto) VALUES
(1, 1, '2024-05-01', '2024-05-15', 1),
(2, 3, '2024-05-03', '2024-05-17', 1),
(3, 5, '2024-05-05', '2024-05-20', 0),
(4, 2, '2024-05-07', '2024-05-22', 0),
(5, 4, '2024-05-09', '2024-05-24', 0);