-- Insertar datos en la tabla Vehiculo
INSERT INTO Vehiculo (patente, marca, modelo, anio_fabricacion, cantidad_ruedas)
VALUES ('ABC123', 'Toyota', 'Corolla', 2018, 4),
       ('XYZ456', 'Ford', 'Focus', 2019, 4),
       ('DEF789', 'Chevrolet', 'Spark', 2017, 4),
       ('GHI012', 'Honda', 'Civic', 2020, 4);

-- Insertar datos en la tabla Siniestro
INSERT INTO Siniestro (fecha_siniestro, perdida_economica, vehiculo_id)
VALUES ('2022-05-15', 5000.00, 1),
       ('2023-08-20', 8000.00, 2),
       ('2024-01-10', 3000.00, 3),
       ('2024-04-05', 12000.00, 4);