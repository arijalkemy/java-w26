INSERT INTO clientes (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad) 
VALUES 
    ('12345678A', 'Juan', 'García', '1990-05-15', 'Bogotá D.C.', 'Bogotá'),
    ('23456789B', 'María', 'López', '1985-09-20', 'Antioquia', 'Medellín'),
    ('34567890C', 'Pedro', 'Martínez', '1982-07-10', 'Valle del Cauca', 'Cali'),
    ('45678901D', 'Laura', 'González', '1995-03-25', 'Atlántico', 'Barranquilla'),
    ('56789012E', 'Ana', 'Fernández', '1978-12-03', 'Bogotá D.C.', 'Bogotá'),
    ('67890123F', 'David', 'Pérez', '1989-11-08', 'Cundinamarca', 'Soacha'),
    ('78901234G', 'Sara', 'Sánchez', '1992-08-14', 'Nariño', 'Pasto'),
    ('89012345H', 'Carlos', 'Rodríguez', '1980-06-30', 'Bogotá D.C.', 'Bogotá'),
    ('90123456I', 'Elena', 'Romero', '1987-04-18', 'Caldas', 'Manizales'),
    ('01234567J', 'Pablo', 'Díaz', '1984-10-22', 'Huila', 'Neiva');


INSERT INTO planes (identificacion, velocidad_megas, precio)
VALUES 
    ('Plan Básico', 50, 29.99),
    ('Plan Estándar', 100, 39.99),
    ('Plan Avanzado', 200, 49.99),
    ('Plan Premium', 500, 59.99),
    ('Plan Ultimate', 1000, 79.99);

INSERT INTO planes_clientes (descuento, total, fecha_inicio, fecha_fin, cod_plan, id_cliente)
VALUES 
    (5.00, 24.99, '2023-11-10', '2024-03-15', 1, 1),
    (0.00, 39.99, '2023-11-20', '2024-04-25', 2, 2),
    (10.00, 44.99, '2023-12-05', '2024-03-30', 3, 3),
    (0.00, 59.99, '2023-12-15', '2024-04-05', 4, 4),
    (8.00, 71.99, '2024-01-01', '2024-04-10', 5, 5),
    (0.00, 29.99, '2024-01-10', '2024-04-20', 1, 6),
    (12.00, 37.99, '2024-01-20', '2024-04-30', 2, 7),
    (0.00, 59.99, '2024-02-05', '2024-04-15', 3, 8),
    (0.00, 49.99, '2024-02-15', '2024-04-25', 3, 9),
    (5.00, 74.99, '2024-03-01', '2024-04-30', 3, 10);