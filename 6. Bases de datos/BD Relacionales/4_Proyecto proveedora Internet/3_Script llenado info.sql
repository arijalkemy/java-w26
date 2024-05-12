-- Insertar 20 registros en la tabla cliente
INSERT INTO cliente (id_cliente, dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, direccion) VALUES
(1,'123456789A', 'Juan', 'García', '1990-05-10', 'Madrid', 'Madrid', 'Calle Mayor, 1'),
(2,'987654321B', 'María', 'López', '1985-08-15', 'Barcelona', 'Barcelona', 'Avenida Diagonal, 100'),
(3,'567890123C', 'Pedro', 'Martínez', '1988-12-20', 'Valencia', 'Valencia', 'Calle Gran Vía, 50'),
(4,'345678901D', 'Ana', 'Sánchez', '1995-04-25', 'Sevilla', 'Sevilla', 'Plaza de España, 15'),
(5,'901234567E', 'Luis', 'Fernández', '1980-11-30', 'Alicante', 'Alicante', 'Calle San Vicente, 20'),
(6,'789012345F', 'Laura', 'Gómez', '1992-07-05', 'Málaga', 'Málaga', 'Paseo del Parque, 10'),
(7,'234567890G', 'Carlos', 'Rodríguez', '1983-09-12', 'Murcia', 'Murcia', 'Calle Mayor, 5'),
(8,'678901234H', 'Elena', 'Pérez', '1987-03-18', 'Bilbao', 'Vizcaya', 'Calle Gran Bilbao, 30'),
(9,'456789012I', 'Miguel', 'Ruiz', '1998-01-28', 'Zaragoza', 'Zaragoza', 'Paseo Independencia, 25'),
(10,'890123456J', 'Sara', 'Hernández', '1982-06-08', 'Granada', 'Granada', 'Calle Reyes Católicos, 12'),
(11,'789012345K', 'Eduardo', 'González', '1993-08-22', 'Madrid', 'Madrid', 'Calle Gran Vía, 100'),
(12,'890123456L', 'Carmen', 'Torres', '1984-05-18', 'Barcelona', 'Barcelona', 'Avenida Diagonal, 200'),
(13,'901234567M', 'Antonio', 'Díaz', '1977-12-11', 'Valencia', 'Valencia', 'Calle del Mar, 50'),
(14,'012345678N', 'Sandra', 'López', '1990-03-25', 'Sevilla', 'Sevilla', 'Avenida de la Constitución, 30'),
(15,'123456789O', 'Javier', 'Martín', '1986-11-09', 'Alicante', 'Alicante', 'Calle San Vicente, 10'),
(16,'234567890P', 'María', 'García', '1995-07-14', 'Málaga', 'Málaga', 'Calle Larios, 20'),
(17,'345678901Q', 'David', 'Pérez', '1981-09-02', 'Murcia', 'Murcia', 'Calle Mayor, 5'),
(18,'456789012R', 'Laura', 'Ruiz', '1998-01-28', 'Bilbao', 'Vizcaya', 'Calle Gran Bilbao, 30'),
(19,'567890123S', 'Carlos', 'Hernández', '1983-06-15', 'Zaragoza', 'Zaragoza', 'Paseo Independencia, 25'),
(20,'678901234T', 'Sara', 'Sánchez', '1982-04-08', 'Granada', 'Granada', 'Calle Reyes Católicos, 12');


-- Insertar 5 registros en la tabla plan
INSERT INTO plan (id_plan, nombre, descripcion, velocidad, precio) VALUES
('P001','Plan Básico', 'Plan básico con velocidades de hasta 10 Mbps', 10, 29.99),
('P002','Plan Estándar', 'Plan estándar con velocidades de hasta 50 Mbps', 50, 59.99),
('P003','Plan Gold', 'Plan gold con velocidades de hasta 100 Mbps', 100, 99.99),
('P004','Plan Premium', 'Plan premium con velocidades de hasta 200 Mbps', 200, 149.99),
('P005','Plan Platinium', 'Plan platinium con velocidades de hasta 500 Mbps', 500, 249.99);

-- Insertar 4 registros estados de cuenta en la tabla estado
INSERT INTO estado (id_estado, nombre, descripcion) VALUES
(101,'Activo', 'El estado de la cuenta indica que el cliente tiene acceso activo a los servicios de Internet.'),
(102,'Inactivo', 'El estado de la cuenta indica que el cliente no tiene acceso activo a los servicios de Internet, pero la cuenta aún está activa.'),
(103,'Suspendido', 'El estado de la cuenta indica que el acceso del cliente ha sido suspendido temporalmente debido a pagos atrasados u otros problemas.'),
(104,'Cancelado', 'El estado de la cuenta indica que la cuenta del cliente ha sido cancelada y ya no tiene acceso a los servicios de Internet.');

COMMIT;

-- Insertar 20 registros en la tabla detalle_plan
INSERT INTO detalle_plan (id_plan, id_estado, id_cliente, fecha_inicio, fecha_corte, fecha_fin, descuento) VALUES
('P001', 101, 1, DATE_ADD(NOW(), INTERVAL -10 DAY), DATE_ADD(NOW(), INTERVAL 20 DAY), NULL, 10.00),
('P002', 102, 2, DATE_ADD(NOW(), INTERVAL -8 DAY), DATE_ADD(NOW(), INTERVAL 18 DAY), NULL, 5.00),
('P003', 103, 3, DATE_ADD(NOW(), INTERVAL -6 DAY), DATE_ADD(NOW(), INTERVAL 16 DAY), NULL, 15.00),
('P004', 104, 4, DATE_ADD(NOW(), INTERVAL -4 DAY), DATE_ADD(NOW(), INTERVAL 14 DAY), '2024-05-10', 8.00),
('P005', 101, 5, DATE_ADD(NOW(), INTERVAL -2 DAY), DATE_ADD(NOW(), INTERVAL 12 DAY), NULL, 12.00),
('P001', 101, 6, DATE_ADD(NOW(), INTERVAL -9 DAY), DATE_ADD(NOW(), INTERVAL 19 DAY), NULL, 20.00),
('P002', 102, 7, DATE_ADD(NOW(), INTERVAL -7 DAY), DATE_ADD(NOW(), INTERVAL 17 DAY), NULL, 3.00),
('P003', 103, 8, DATE_ADD(NOW(), INTERVAL -5 DAY), DATE_ADD(NOW(), INTERVAL 15 DAY), NULL, 7.00),
('P004', 104, 9, DATE_ADD(NOW(), INTERVAL -3 DAY), DATE_ADD(NOW(), INTERVAL 13 DAY), '2024-05-10', 18.00),
('P005', 101, 10, DATE_ADD(NOW(), INTERVAL -1 DAY), DATE_ADD(NOW(), INTERVAL 11 DAY), NULL, 14.00),
('P001', 101, 11, DATE_ADD(NOW(), INTERVAL -10 DAY), DATE_ADD(NOW(), INTERVAL 20 DAY), NULL, 6.00),
('P002', 102, 12, DATE_ADD(NOW(), INTERVAL -8 DAY), DATE_ADD(NOW(), INTERVAL 18 DAY), NULL, 9.00),
('P003', 103, 13, DATE_ADD(NOW(), INTERVAL -6 DAY), DATE_ADD(NOW(), INTERVAL 16 DAY), NULL, 13.00),
('P004', 104, 14, DATE_ADD(NOW(), INTERVAL -4 DAY), DATE_ADD(NOW(), INTERVAL 14 DAY), '2024-05-10', 11.00),
('P005', 101, 15, DATE_ADD(NOW(), INTERVAL -2 DAY), DATE_ADD(NOW(), INTERVAL 12 DAY), NULL, 16.00),
('P001', 101, 16, DATE_ADD(NOW(), INTERVAL -9 DAY), DATE_ADD(NOW(), INTERVAL 19 DAY), NULL, 4.00),
('P002', 102, 17, DATE_ADD(NOW(), INTERVAL -7 DAY), DATE_ADD(NOW(), INTERVAL 17 DAY), NULL, 17.00),
('P003', 103, 18, DATE_ADD(NOW(), INTERVAL -5 DAY), DATE_ADD(NOW(), INTERVAL 15 DAY), NULL, 21.00),
('P004', 104, 19, DATE_ADD(NOW(), INTERVAL -3 DAY), DATE_ADD(NOW(), INTERVAL 13 DAY), '2024-05-10', 22.00),
('P005', 101, 20, DATE_ADD(NOW(), INTERVAL -1 DAY), DATE_ADD(NOW(), INTERVAL 11 DAY), NULL, 25.00);

COMMIT;














