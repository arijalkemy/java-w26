CREATE TABLE AUTOR (
	id_autor VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(50),
    nacionalidad VARCHAR(50)
);

CREATE TABLE LIBRO (
	id_libro VARCHAR(10) PRIMARY KEY,
    titulo VARCHAR(50),
    editorial VARCHAR(50),
    area VARCHAR(50)
);

CREATE TABLE LIBRO_AUTOR (
    id_autor VARCHAR(10),
    id_libro VARCHAR(10),
    PRIMARY KEY (id_autor, id_libro),
    FOREIGN KEY (id_autor) REFERENCES AUTOR(id_autor),
    FOREIGN KEY (id_libro) REFERENCES LIBRO(id_libro)
);

CREATE TABLE ESTUDIANTE (
    id_lector VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    direccion VARCHAR(100),
    carrera VARCHAR(50),
    edad INT
);

CREATE TABLE PRESTAMO (
    id_lector VARCHAR(10),
    id_libro VARCHAR(10),
    fecha_prestamo DATE,
    fecha_devolucion DATE,
    devuelto BOOLEAN,
    PRIMARY KEY (id_lector, id_libro),
    FOREIGN KEY (id_lector) REFERENCES ESTUDIANTE(id_lector),
    FOREIGN KEY (id_libro) REFERENCES LIBRO(id_libro)
);

-- Insertar datos de autores
INSERT INTO AUTOR (id_autor, nombre, nacionalidad) VALUES
('A001', 'Gabriel García Márquez', 'Colombiana'),
('A002', 'J.K. Rowling', 'Británica'),
('A003', 'Haruki Murakami', 'Japonesa'),
('A004', 'Elena Ferrante', 'Italiana'),
('A005', 'Marcel Proust', 'Francesa');

-- Insertar datos de libros
INSERT INTO LIBRO (id_libro, titulo, editorial, area) VALUES
('L001', 'Cien años de soledad', 'Salamandra', 'Ficción'),
('L002', 'Harry Potter y la piedra filosofal', 'Salamandra', 'Fantasía'),
('L003', 'Norwegian Wood', 'Tusquets', 'Ficción'),
('L004', 'La amiga estupenda', 'Lumen', 'Ficción'),
('L005', 'En busca del tiempo perdido', 'Alianza Editorial', 'Ficción');

-- Insertar relación autor-libro
INSERT INTO LIBRO_AUTOR (id_autor, id_libro) VALUES
('A001', 'L001'),
('A002', 'L002'),
('A003', 'L003'),
('A004', 'L004'),
('A005', 'L005');

-- Insertar datos de estudiantes
INSERT INTO ESTUDIANTE (id_lector, nombre, apellido, direccion, carrera, edad) VALUES
('E001', 'Juan', 'García', 'Calle 123, Ciudad', 'Informática', 20),
('E002', 'María', 'López', 'Avenida Principal, Pueblo', 'Biología', 22),
('E003', 'Carlos', 'Martínez', 'Plaza Central, Villa', 'Informática', 21),
('E004', 'Ana', 'Pérez', 'Carrera 45, Pueblo', 'Literatura', 23),
('E005', 'Pedro', 'Gómez', 'Avenida Norte, Ciudad', 'Informática', 19);

-- Insertar datos de préstamos
INSERT INTO PRESTAMO (id_lector, id_libro, fecha_prestamo, fecha_devolucion, devuelto) VALUES
('E001', 'L001', '2024-05-01', '2024-05-15', true),
('E002', 'L002', '2024-05-02', '2024-05-16', true),
('E003', 'L003', '2024-05-03', '2024-05-17', true),
('E004', 'L004', '2024-05-04', '2024-05-18', false),
('E005', 'L005', '2024-05-05', '2024-05-19', false);

