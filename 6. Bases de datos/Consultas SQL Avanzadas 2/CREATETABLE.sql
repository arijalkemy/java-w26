CREATE TABLE Libro (
  idLibro INT PRIMARY KEY,
  Titulo VARCHAR(50) NOT NULL,
  Editorial VARCHAR(50) NOT NULL,
  Area VARCHAR(50) NOT NULL
);
CREATE TABLE Autor (
  idAutor INT PRIMARY KEY,
  Nombre VARCHAR(50) NOT NULL,
  Nacionalidad VARCHAR(50) NOT NULL
);
CREATE TABLE Estudiante (
  idLector INT PRIMARY KEY,
  Nombre VARCHAR(50) NOT NULL,
  Apellido VARCHAR(50) NOT NULL,
  Carrera VARCHAR(50) NOT NULL,
  Edad INT NOT NULL
);
CREATE TABLE Prestamo (
  idPrestamo INT PRIMARY KEY,
  idLector INT NOT NULL,
  idLibro INT NOT NULL,
  FechaPrestamo DATE NOT NULL,
  FechaDevolucion DATE,
  Devuelto BOOLEAN NOT NULL,
  FOREIGN KEY (idLector) REFERENCES Estudiante(idLector),
  FOREIGN KEY (idLibro) REFERENCES Libro(idLibro)
);
CREATE TABLE AutorLibro (
  idAutor INT NOT NULL,
  idLibro INT NOT NULL,
  PRIMARY KEY (idAutor, idLibro),
  FOREIGN KEY (idAutor) REFERENCES Autor(idAutor),
  FOREIGN KEY (idLibro) REFERENCES Libro(idLibro)
);