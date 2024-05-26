INSERT INTO VEHICULOS (patente, marca, modelo, ano_de_fabricacion, cantidad_de_ruedas)
VALUES
    ('ABC123', 'Toyota', 'Corolla', 2019, 4),
    ('DEF456', 'Ford', 'Focus', 2018, 4),
    ('GHI789', 'Chevrolet', 'Cruze', 2020, 4);

INSERT INTO SINIESTROS (vehiculo_id, fecha, perdida_economica)
VALUES
    (1, '2023-01-15', 15000.00),
    (1, '2023-05-20', 8000.00),
    (2, '2023-03-10', 12000.00),
    (3, '2023-02-28', 20000.00),
    (3, '2023-06-05', 18000.00);