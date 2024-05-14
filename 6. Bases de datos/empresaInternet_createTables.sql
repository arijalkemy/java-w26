INSERT INTO Plan (velocidad, precio, descuento) VALUES
(50, 29.99, 5.00),
(100, 39.99, 7.50),
(200, 49.99, 10.00),
(300, 59.99, 15.00),
(500, 69.99, 20.00);


INSERT INTO Cliente (dni, nombre, apellido, fechaNacimiento, provincia, ciudad, Plan_idPlan) VALUES
('12345678', 'Juan', 'Pérez', '1985-02-15', 'Buenos Aires', 'La Plata', 5),
('23456789', 'Laura', 'García', '1990-07-23', 'Córdoba', 'Córdoba', 1),
('34567890', 'Carlos', 'Fernández', '1975-03-30', 'Santa Fe', 'Rosario', 2),
('45678901', 'Alicia', 'López', '1988-11-10', 'Mendoza', 'Mendoza', 3),
('56789012', 'Mariano', 'Martínez', '1992-05-05', 'Tucumán', 'San Miguel de Tucumán',4),
('67890123', 'Carmen', 'Rojas', '1978-01-17', 'Salta', 'Salta', 5),
('78901234', 'Pablo', 'Gomez', '1967-08-19', 'Chaco', 'Resistencia', 1),
('89012345', 'Sofía', 'Torres', '1999-12-25', 'Chubut', 'Comodoro Rivadavia', 2),
('90123456', 'Lucas', 'Alvarez', '1982-09-15', 'Tierra del Fuego', 'Ushuaia', 3),
('01234567', 'Ana', 'Sánchez', '1972-04-28', 'La Pampa', 'Santa Rosa', 4);