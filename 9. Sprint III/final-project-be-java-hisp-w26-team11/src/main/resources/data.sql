-- Inserción de tipos de productos
INSERT INTO product_types (name, acronym) VALUES
('Fresco', 'FS'),
('Refrigerado', 'RF'),
('Congelado', 'FF');
-- Inserción de estados
INSERT INTO status (status_code) VALUES
('Carrito');
-- Inserción de usuarios con diferentes roles
INSERT INTO users (role, username, first_name, last_name, password) VALUES
('WAREHOUSE', 'rep_user1', 'Carlos', 'Martínez', '$2a$10$6yzTNiH0uCwkSrPSKipgk.KrK4YMyWSDo0Foq5Qog7GIi8iVSvhxO'),
('SELLER', 'seller_user1', 'María', 'García', '$2a$10$6yzTNiH0uCwkSrPSKipgk.KrK4YMyWSDo0Foq5Qog7GIi8iVSvhxO'),
('BUYER', 'buyer_user1', 'José', 'López', '$2a$10$6yzTNiH0uCwkSrPSKipgk.KrK4YMyWSDo0Foq5Qog7GIi8iVSvhxO'),
('BUYER', 'buyer_user2', 'Jesus', 'López', '$2a$10$6yzTNiH0uCwkSrPSKipgk.KrK4YMyWSDo0Foq5Qog7GIi8iVSvhxO'),
('BUYER', 'buyer_user3', 'Juan', 'López', '$2a$10$6yzTNiH0uCwkSrPSKipgk.KrK4YMyWSDo0Foq5Qog7GIi8iVSvhxO');
-- Inserción de warehouses
INSERT INTO warehouses (warehouse_code, representative_id) VALUES
(1001, 1),
(1002, 2),
(1003, 3);
-- Inserción de secciones en cada warehouse
INSERT INTO sections (warehouse_id, product_type_id, section_code, capacity) VALUES
(1, 1, 1, 200),
(1, 1, 2, 200),
(1, 2, 3, 200),
(1, 2, 4, 200),
(1, 3, 5, 200),
(1, 3, 6, 200),
(2, 1, 7, 1000),
(2, 1, 8, 200),
(2, 2, 9, 200),
(2, 2, 10, 200),
(2, 3, 11, 200),
(2, 3, 12, 200),
(3, 1, 13, 200),
(3, 1, 14, 200),
(3, 2, 15, 200),
(3, 2, 16, 200),
(3, 3, 17, 200),
(3, 3, 18, 200);
-- Inserción de productos
INSERT INTO products (name, price) VALUES
('Lechuga Fresca', 10.00),
('Tomates Orgánicos', 15.00),
('Queso Cheddar', 30.00),
('Yogur Natural', 25.00),
('Helado de Vainilla', 50.00),
('Pollo Congelado', 45.00),
('Manzanas Fuji', 20.00),
('Carne de Res', 80.00),
('Papas Congeladas', 35.00),
('Pescado Congelado', 60.00);
INSERT INTO inboud_orders (order_date, order_number, user_id) VALUES
('2023-05-01', 1, 1),
('2023-05-02', 2, 1),
('2023-05-03', 3, 1),
('2023-05-04', 4, 1),
('2023-05-05', 5, 1);

INSERT INTO batches(batch_number, current_quantity, current_temperature, due_date, initial_quantity, manufacturing_date, manufacturing_time, minimum_temperature, inboud_order_id, product_id, section_id) VALUES
(1, 100.00, 10.23, '2023-05-30', 500.00, '2023-05-10', '2023-05-10 11:11:11', 1.05, 1, 1, 7),
(2, 7.00, 10.23, '2024-08-30', 10.00, '2024-07-10', '2024-07-10 11:11:11', 1.05, 1, 1, 7),
(3, 100.00, 10.23, '2025-07-04', 1000.00, '2024-07-10', '2024-07-10 11:11:11', 1.05, 1, 3, 7),
(4, 100.00, 10.23, '2025-07-04', 1000.00, '2024-07-10', '2024-07-10 11:11:11', 1.05, 1, 3, 7);

INSERT INTO purchase_orders (user_id, status_id, date)
VALUES
    (3, 1, '2023-05-01'),
    (4, 1, '2024-01-01');

INSERT INTO purchase_order_products (product_quantity, purchase_order_id, product_id) VALUES
(10, 1, 1),
(20, 1, 2),
(30, 1, 3),
(10, 2, 1),
(20, 2, 2),
(30, 2, 3);