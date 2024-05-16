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
    FOREIGN KEY (idAutor) REFERENCES autor(idAutor) ,
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
    FOREIGN KEY (idLector) REFERENCES estudiante(idLector) ,
    FOREIGN KEY (idLibro)  REFERENCES libro(idLibro)
);


/* Insert data */

INSERT INTO autor (Nombre, Nacionalidad) VALUES ('J.K. Rowling','Inglesa');
INSERT INTO autor (Nombre, Nacionalidad) VALUES ('Gabriel Garcia Marquez','Colombiana');
INSERT INTO autor (Nombre, Nacionalidad) VALUES ('Jane Austen','Italiana');
INSERT INTO autor (Nombre, Nacionalidad) VALUES ('Victor Hugo','Francesa');
INSERT INTO autor (Nombre, Nacionalidad) VALUES ('Charles Bukowski','Alemana');

INSERT INTO libro (Titulo, Editorial,Area) VALUES ('El Universo: Guía de viaje','Salamandra','Ciencia');
INSERT INTO libro (Titulo, Editorial,Area) VALUES ('Cien años de soledad','Norma','Fantasia');
INSERT INTO libro (Titulo, Editorial,Area) VALUES ('Harry Potter','Norma','Fantasia');
INSERT INTO libro (Titulo, Editorial,Area) VALUES ('NET','Norma','Internet');
INSERT INTO libro (Titulo, Editorial,Area) VALUES ('El coronel no tiene quien le escriba','Salamandra','Novela');


INSERT INTO estudiante (Nombre, Apellido, Direccion, Carrera, Edad) VALUES ('Filippo', 'Galli','Calle Falsa 123','Informática',17);
INSERT INTO estudiante (Nombre, Apellido, Direccion, Carrera, Edad) VALUES ('Pepito', 'Perez','Calle Falsa 123','Sociales',20);
INSERT INTO estudiante (Nombre, Apellido, Direccion, Carrera, Edad) VALUES ('Daniel', 'Fernandez','Calle Falsa 123','Artes plasticas',18);
INSERT INTO estudiante (Nombre, Apellido, Direccion, Carrera, Edad) VALUES ('Armando', 'Gonzales','Calle Falsa 123','Contables',17);
INSERT INTO estudiante (Nombre, Apellido, Direccion, Carrera, Edad) VALUES ('Felipe', 'Casas','Calle Falsa 123','Informática',16);

INSERT INTO libroautor VALUES (1,1);
INSERT INTO libroautor VALUES (1,3);
INSERT INTO libroautor VALUES (2,2);
INSERT INTO libroautor VALUES (3,3);
INSERT INTO libroautor VALUES (4,4);
INSERT INTO libroautor VALUES (5,5);

INSERT INTO prestamo VALUES (1,1,'2021-06-30','2021-07-16',FALSE);
INSERT INTO prestamo VALUES (1,2,'2021-05-20','2021-07-01',FALSE);
INSERT INTO prestamo VALUES (2,3,'2021-04-25','2021-06-28',TRUE);
INSERT INTO prestamo VALUES (4,4,'2021-05-31','2021-06-16',FALSE);
INSERT INTO prestamo VALUES (5,4,'2021-06-30','2021-07-16',TRUE);
