-- Crear la base de datos
CREATE DATABASE VehiculosDB;

-- Seleccionar la base de datos
USE VehiculosDB;

-- Crear la tabla Vehículo
CREATE TABLE Vehiculo (
    IdVehiculo INT AUTO_INCREMENT PRIMARY KEY,
    Patente VARCHAR(50) NOT NULL,
    Marca VARCHAR(50) NOT NULL,
    Modelo VARCHAR(50) NOT NULL,
    AñoFabricacion INT NOT NULL,
    CantidadRuedas INT NOT NULL
);

-- Crear la tabla Siniestro
CREATE TABLE Siniestro (
    IdSiniestro INT AUTO_INCREMENT PRIMARY KEY,
    FechaSiniestro DATE NOT NULL,
    PerdidaEconomica DECIMAL(10, 2) NOT NULL,
    IdVehiculoDenunciado INT NOT NULL,
    FOREIGN KEY (IdVehiculoDenunciado) REFERENCES Vehiculo(IdVehiculo)
);

-- Insertar datos de ejemplo en la tabla Vehículo
INSERT INTO Vehiculo (Patente, Marca, Modelo, AñoFabricacion, CantidadRuedas)
VALUES ( 'ABC123', 'Toyota', 'Corolla', 2015, 4),
       ( 'XYZ789', 'Ford', 'Focus', 2018, 4),
       ('QWE342', 'Chevrolet', 'Onix', '2024', 6);

-- Insertar datos de ejemplo en la tabla Siniestro
INSERT INTO Siniestro (FechaSiniestro, PerdidaEconomica, IdVehiculoDenunciado)
VALUES ('2023-05-21', 1500.00, 1),
       ('2024-01-15', 3000.00, 2),
       ('2024-02-12', 15000.00, 3);
