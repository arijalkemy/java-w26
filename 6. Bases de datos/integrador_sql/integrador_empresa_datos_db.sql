INSERT INTO cliente (nombre, apellido, direccion, dni, email, telefono) VALUES
('Juan', 'Pérez', 'Av. Siempre Viva 123', '12345678A', 'juan.perez@example.com', '123456789'),
('María', 'González', 'Calle Falsa 456', '23456789B', 'maria.gonzalez@example.com', '987654321'),
('Carlos', 'López', 'Boulevard de los Sueños 789', '34567890C', 'carlos.lopez@example.com', '456123789'),
('Ana', 'Martínez', 'Plaza Mayor 101', '45678901D', 'ana.martinez@example.com', '321654987'),
('Luis', 'García', 'Camino Real 202', '56789012E', 'luis.garcia@example.com', '654987321'),
('Roberto', 'Hernández', 'Calle Luna 303', '67890123F', 'roberto.hernandez@example.com', '789012345'),
('Elena', 'Torres', 'Calle Sol 404', '78901234G', 'elena.torres@example.com', '890123456'),
('Sofía', 'Ramírez', 'Avenida del Parque 505', '89012345H', 'sofia.ramirez@example.com', '901234567'),
('David', 'Fernández', 'Plaza del Centro 606', '90123456I', 'david.fernandez@example.com', '012345678'),
('Laura', 'Ruiz', 'Calle del Mercado 707', '01234567J', 'laura.ruiz@example.com', '123456780');

INSERT INTO plan (velocidad, precio) VALUES
(50.0, 29.99),
(100.0, 49.99),
(200.0, 69.99),
(300.0, 89.99),
(500.0, 109.99);

INSERT INTO plan_contratado (id_plan, id_cliente) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(1, 6),
(2, 7),
(3, 8),
(4, 9),
(5, 10);