INSERT INTO Libro (idLibro, Titulo, Editorial, Area)
VALUES
  (1, 'El Universo: Guía de viaje', 'Salamandra', 'Ciencia Ficción'),
  (2, 'Fundamentos de Base de Datos', 'McGraw-Hill', 'Base de Datos'),
  (3, 'Internet no es lo que pensamos', 'Tezontle', 'Internet'),
  (4, 'Harry Potter y la piedra filosofal', 'Salamandra', 'Realismo Mágico'),
  (5, 'Infierno', 'Alianza', 'Poema Épico');
 
INSERT INTO Autor (idAutor, Nombre, Apellido, Nacionalidad)
VALUES
  (1, 'Douglas Adams', 'Inglés'),
  (2, 'Marcia Bates', 'Estadounidense'),
  (3, 'Justin Smith', 'Canadiense'),
  (4, 'J.K. Rowling', 'Británico'),
  (5, 'Dante Alighieri', 'Italiano');
INSERT INTO Estudiante (idLector, Nombre, Apellido, Carrera, Edad)
VALUES
  (1, 'Juan', 'Pérez', 'Informática', 22),
  (2, 'María', 'Gómez', 'Psicología', 21),
  (3, 'Pedro', 'López', 'Ingeniería', 23),
  (4, 'Ana', 'Martínez', 'Derecho', 20),
  (5, 'Carlos', 'Rodríguez', 'Medicina', 24);
INSERT INTO Prestamo (idPrestamo, idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto)
VALUES
  (1, 1, 1, '2021-04-01', '2021-09-30', TRUE),
  (2, 2, 2, '2021-03-15', '2021-04-10', TRUE),
  (3, 3, 3, '2021-02-01', '2021-11-29', TRUE),
  (4, 4, 4, '2021-01-10', '2021-01-20', FALSE),
  (5, 5, 5, '2020-12-24', '2021-01-05', TRUE);
INSERT INTO AutorLibro (idAutor, idLibro)
VALUES
  (1, 1),
  (2, 2),
  (3, 3),
  (4, 4),
  (5, 5);






