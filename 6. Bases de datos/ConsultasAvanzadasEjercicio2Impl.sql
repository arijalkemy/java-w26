INSERT INTO LIBRO (idLibro, Titulo, Editorial, Area) VALUES (1, 'Cien años de soledad', 'Sudamericana', 'Literatura');
INSERT INTO LIBRO (idLibro, Titulo, Editorial, Area) VALUES (2, 'El origen de las especies', 'John Murray', 'Ciencia');
INSERT INTO LIBRO (idLibro, Titulo, Editorial, Area) VALUES (3, '1984', 'Secker & Warburg', 'Ficción');
INSERT INTO LIBRO (idLibro, Titulo, Editorial, Area) VALUES (4, 'El principito', 'Reynal & Hitchcock', 'Infantil');
INSERT INTO LIBRO (idLibro, Titulo, Editorial, Area) VALUES (5, 'Historia del tiempo', 'Bantam Dell', 'Internet');

INSERT INTO AUTOR (idAutor, Nombre, Nacionalidad) VALUES (1, 'Gabriel García Márquez', 'Colombiana');
INSERT INTO AUTOR (idAutor, Nombre, Nacionalidad) VALUES (2, 'Charles Darwin', 'Británica');
INSERT INTO AUTOR (idAutor, Nombre, Nacionalidad) VALUES (3, 'George Orwell', 'Británica');
INSERT INTO AUTOR (idAutor, Nombre, Nacionalidad) VALUES (4, 'Antoine de Saint-Exupéry', 'Francesa');
INSERT INTO AUTOR (idAutor, Nombre, Nacionalidad) VALUES (5, 'Stephen Hawking', 'Británica');

INSERT INTO LIBROAUTOR (idAutor, idLibro) VALUES (1, 1);
INSERT INTO LIBROAUTOR (idAutor, idLibro) VALUES (2, 2);
INSERT INTO LIBROAUTOR (idAutor, idLibro) VALUES (3, 3);
INSERT INTO LIBROAUTOR (idAutor, idLibro) VALUES (4, 4);
INSERT INTO LIBROAUTOR (idAutor, idLibro) VALUES (5, 5);

INSERT INTO ESTUDIANTE (idLector, Nombre, Apellido, Direccion, Carrera, Edad) VALUES (1, 'Juan', 'Pérez', 'Calle Falsa 123', 'Literatura', 20);
INSERT INTO ESTUDIANTE (idLector, Nombre, Apellido, Direccion, Carrera, Edad) VALUES (2, 'Ana', 'Lopez', 'Av Siempre Viva 456', 'Biología', 22);
INSERT INTO ESTUDIANTE (idLector, Nombre, Apellido, Direccion, Carrera, Edad) VALUES (3, 'Luis', 'Martínez', 'Diagonal 789', 'Ciencias Políticas', 21);
INSERT INTO ESTUDIANTE (idLector, Nombre, Apellido, Direccion, Carrera, Edad) VALUES (4, 'Sofía', 'González', 'Paseo de Gracia 101', 'Física', 23);
INSERT INTO ESTUDIANTE (idLector, Nombre, Apellido, Direccion, Carrera, Edad) VALUES (5, 'Carlos', 'Fernández', 'Gran Vía 202', 'Matemáticas', 24);

INSERT INTO PRESTAMO (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) VALUES (1, 1, '2023-01-01', '2023-01-15', true);
INSERT INTO PRESTAMO (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) VALUES (2, 2, '2023-02-01', '2023-02-15', false);
INSERT INTO PRESTAMO (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) VALUES (3, 3, '2023-03-01', '2023-03-15', true);
INSERT INTO PRESTAMO (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) VALUES (4, 4, '2023-04-01', '2023-04-15', false);
INSERT INTO PRESTAMO (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) VALUES (5, 5, '2023-05-01', '2023-05-15', true);


