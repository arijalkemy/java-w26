CREATE DATABASE biblioteca;
USE biblioteca;

CREATE TABLE biblioteca.libro (
	idLibro INT NOT NULL,
	titulo varchar(50) NOT NULL,
	editorial varchar(40) NOT NULL,
	Area varchar(30) NOT NULL,
	CONSTRAINT libro_pk PRIMARY KEY (idLibro)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE biblioteca.autor (
	idAutor INT NOT NULL,
	nombre varchar(60) NOT NULL,
	nacionalidad varchar(50) NOT NULL,
	CONSTRAINT autor_pk PRIMARY KEY (idAutor)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE biblioteca.LibroAutor (
	idAutor INT NOT NULL,
	idLibro INT NOT NULL,
	CONSTRAINT LibroAutor_libro_FK FOREIGN KEY (idLibro) REFERENCES biblioteca.libro(idLibro),
	CONSTRAINT LibroAutor_autor_FK FOREIGN KEY (idAutor) REFERENCES biblioteca.autor(idAutor)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE biblioteca.estudiante (
	idLector INT NOT NULL,
	nombre varchar(50) NOT NULL,
	apellido varchar(50) NOT NULL,
	direccion varchar(40) NOT NULL,
	carrera varchar(30) NOT NULL,
	edad INT NOT NULL,
	CONSTRAINT estudiante_pk PRIMARY KEY (idLector)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE biblioteca.prestamo (
	idLector INT NOT NULL,
	idLibro INT NOT NULL,
	fechaPrestamo DATETIME NOT NULL,
	fechaDevolucion DATETIME NOT NULL,
	devuelto BOOL NOT NULL,
	CONSTRAINT prestamo_pk PRIMARY KEY (idLector,idLibro),
	CONSTRAINT prestamo_libro_FK FOREIGN KEY (idLibro) REFERENCES biblioteca.libro(idLibro),
	CONSTRAINT prestamo_estudiante_FK FOREIGN KEY (idLector) REFERENCES biblioteca.estudiante(idLector)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;
