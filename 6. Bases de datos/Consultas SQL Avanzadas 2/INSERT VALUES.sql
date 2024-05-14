INSERT INTO Libro (idLibro, Titulo, Editorial, Area)
VALUES
  (1, 'El Universo: Guía de viaje', 'Salamandra', 'Ciencia Ficción'),
  (2, 'Fundamentos de Base de Datos', 'McGraw-Hill', 'Informática'),
  (3, 'El Señor de los Anillos', 'HarperCollins', 'Fantasía'),
  (4, 'Cien años de soledad', 'Alfaguara', 'Realismo Mágico'),
  (5, 'El Principito', 'Gallimard', 'Literatura Infantil');
 
INSERT INTO Autor (idAutor, Nombre, Nacionalidad)
VALUES
  (1, 'Douglas Adams', 'Inglés'),
  (2, 'Marcia Bates', 'Estadounidense'),
  (3, 'J.R.R. Tolkien', 'Inglés'),
  (4, 'Gabriel García Márquez', 'Colombiano'),
  (5, 'Antoine de Saint-Exupéry', 'Francés');
INSERT INTO Estudiante (idLector, Nombre, Apellido, Carrera, Edad)
VALUES
  (1, 'Juan', 'Pérez', 'Informática', 22),
  (2, 'María', 'Gómez', 'Psicología', 21),
  (3, 'Pedro', 'López', 'Ingeniería', 23),
  (4, 'Ana', 'Martínez', 'Derecho', 20),
  (5, 'Carlos', 'Rodríguez', 'Medicina', 24);
INSERT INTO Prestamo (idPrestamo, idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto)
VALUES
  (1, 1, 1, '2024-04-01', '2024-04-30', TRUE),
  (2, 2, 2, '2024-03-15', '2024-04-10', TRUE),
  (3, 3, 3, '2024-02-01', '2024-02-29', TRUE),
  (4, 4, 4, '2024-01-10', '2024-01-20', FALSE),
  (5, 5, 5, '2023-12-24', '2024-01-05', TRUE);
INSERT INTO AutorLibro (idAutor, idLibro)
VALUES
  (1, 1),
  (2, 2),
  (3, 3),
  (4, 4),
  (5, 5);






