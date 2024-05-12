-- Insertar registros en la tabla de clientes
INSERT INTO clientes (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, id_plan) VALUES
('12345678A', 'Juan', 'Perez', '1990-05-15', 'Buenos Aires', 'La Plata', 1),
('87654321B', 'Maria', 'Gomez', '1985-10-20', 'Córdoba', 'Córdoba', 2),
('56789012C', 'Pedro', 'Rodriguez', '1988-03-12', 'Mendoza', 'Mendoza', 3),
('90123456D', 'Laura', 'Lopez', '1995-07-02', 'Santa Fe', 'Rosario', 4),
('34567890E', 'Carlos', 'Martinez', '1979-12-30', 'Buenos Aires', 'Mar del Plata', 5),
('78901234F', 'Ana', 'Fernandez', '1982-09-25', 'Tucumán', 'San Miguel de Tucumán', 1),
('23456789G', 'Diego', 'Diaz', '1993-04-18', 'Salta', 'Salta', 2),
('67890123H', 'Silvia', 'Sanchez', '1976-11-05', 'Entre Ríos', 'Paraná', 3),
('45678901I', 'Jorge', 'Gonzalez', '1980-08-22', 'Chaco', 'Resistencia', 4),
('89012345J', 'Andrea', 'Ramirez', '1998-01-10', 'Neuquén', 'Neuquén', 5);

-- Insertar registros en la tabla de planes de internet
INSERT INTO planes_internet (id_plan, velocidad_megas, precio, descuento) VALUES
(1, 50, 30.00, 0.10),
(2, 100, 45.00, 0.15),
(3, 200, 60.00, 0.20),
(4, 500, 80.00, 0.25),
(5, 1000, 100.00, 0.30);
