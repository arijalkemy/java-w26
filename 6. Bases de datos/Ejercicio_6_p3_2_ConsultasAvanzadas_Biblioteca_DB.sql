CREATE DATABASE biblioteca;

USE biblioteca;

CREATE TABLE libro(
	idLibro INT(11) AUTO_INCREMENT PRIMARY KEY,
	titulo VARCHAR(50),
    editorial VARCHAR(50),
    area VARCHAR(50)
);

CREATE TABLE autor(
	idAutor INT(11) AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(50),
    nacionalidad VARCHAR(50)
);

CREATE TABLE estudiante(
	idLector INT(11) AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(50),
    apellido VARCHAR(50),
    direccion VARCHAR(50),
    carrera VARCHAR(50),
    edad INT(3)
);

CREATE TABLE libroAutor(
	idLibro VARCHAR(50),
    idAutor VARCHAR(50),
    PRIMARY KEY(idLibro, idAutor)
);

CREATE TABLE prestamo(
	id INT AUTO_INCREMENT PRIMARY KEY,
	idLector INT(11),
	idLibro INT(11),
    fechaPrestamo DATE,
    fechaDevolucion DATE,
    devuelto BOOL,
    FOREIGN KEY (idLector) REFERENCES estudiante(idLector),
    FOREIGN KEY (idLibro) REFERENCES libro(idLibro)
);





