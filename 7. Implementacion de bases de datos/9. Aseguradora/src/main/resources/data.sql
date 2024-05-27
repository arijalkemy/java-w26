INSERT INTO vehiculo (patente, marca, modelo, anio_fabricacion, cantidad_ruedas)
VALUES ('ABC123', 'Toyota', 'Corolla', 2015, 4),
       ('DEF456', 'Honda', 'Civic', 2018, 4),
       ('GHI789', 'Ford', 'Fiesta', 2012, 4),
       ('JKL012', 'Chevrolet', 'Malibu', 2024, 5),
       ('MNO345', 'Nissan', 'Altima', 2019, 4);

INSERT INTO siniestro (fecha_siniestro, perdida_economica, vehiculo_id)
VALUES ('2023-01-15', 5000.00, 1),
       ('2023-02-20', 3000.00, 1),
       ('2023-03-10', 15000.00, 2),
       ('2023-04-25', 8000.00, 2),
       ('2023-05-05', 12000.00, 3),
       ('2023-06-15', 7000.00, 3),
       ('2023-07-20', 9500.00, 4),
       ('2023-08-30', 11000.00, 4),
       ('2023-09-10', 6000.00, 5),
       ('2023-10-22', 4500.00, 5);
