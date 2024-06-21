-- Example of inserting data into the Warehouse table
INSERT INTO warehouse (id, warehouse_location)
VALUES (1, 'La Plata'),
       (2, 'Burzaco');

INSERT INTO users (username, role)
VALUES ('manager', 'MANAGER'),
       ('buyer', 'BUYER');

-- Agregar user a warehouse
INSERT INTO warehouse_manager (user_id, warehouse_id)
VALUES (1, 1),
       (2, 2);

-- Inserción de datos en la tabla ProductType
INSERT INTO product_type (description)
VALUES ('FRESCO'),
       ('REFRIGERADO'),
       ('CONGELADO');

-- Inserción de datos en la tabla Product
INSERT INTO product (product_Type_id, description, product_price)
VALUES (1, 'Lechuga', 1.50),
       (1, 'Manzana', 0.80),
       (1, 'Tomate', 1.20), -- frescos
       (2, 'Leche', 0.99),
       (2, 'Yogur', 0.60),
       (2, 'Queso', 2.50),  -- refrigerado
       (3, 'Carne', 3.50),
       (3, 'Helado', 1.80),
       (3, 'Pescado', 4.00);
-- congelado


-- Inserción de datos en la tabla Section
INSERT INTO section (id, capacity, product_type, warehouse_id)
VALUES (1, 1000, 1, 1), -- 1 fresco, 2 refrigerado y 3 congelado
       (4, 1500, 2, 1),
       (2, 2000, 3, 1),
       (3, 2500, 1, 2),
       (5, 3000, 2, 2);


-- Inserción de datos en la tabla InboundOrder
INSERT INTO inbound_order (order_date, order_number, warehouse_id, section_id)
VALUES ('2023-06-01', 1001, 1, 1),
       ('2023-07-15', 1002, 1, 2),
       ('2023-08-20', 1003, 1, 3),
       ('2023-09-10', 1004, 2, 4),
       ('2023-10-05', 1005, 2, 1);

-- Inserción de datos en la tabla Batch
INSERT INTO batch (id, current_temperature, minimum_temperature, manufacturing_date,
                   initial_quantity, current_quantity, due_date, manufacturing_time, product_id,
                   order_number)
VALUES (1, 10.0, 0.0, '2023-06-01', 100, 80, '2024-06-01', '2023-06-01 08:00:00', 1, 1001),
       (2, 5.0, -5.0, '2023-07-15', 200, 150, '2024-06-28', '2023-07-15 09:30:00', 2, 1001),
       (3, -18.0, -20.0, '2023-08-20', 300, 250, '2024-06-25', '2023-08-20 10:45:00', 7, 1001),
       (4, 5.0, -5.0, '2023-07-15', 200, 150, '2024-06-27', '2023-07-15 09:30:00', 4, 1001),
       (5, -18.0, -20.0, '2023-08-20', 300, 250, '2024-06-26', '2023-08-20 10:45:00', 3, 1001),
       (6, 12.0, 5.0, '2023-09-10', 150, 120, '2024-09-10', '2023-09-10 11:15:00', 3, 1001),
       (7, -10.0, -18.0, '2023-10-05', 250, 200, '2024-10-05', '2023-10-05 07:50:00', 2, 1001);

-- Inserción de datos en la tabla section_batch
INSERT INTO section_batch (section_id, batch_id)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (4, 4),
       (5, 5),
       (5, 6);

-- Inserción de datos en la tabla PurchaseOrder
INSERT INTO purchase_order (date, status, buyer)
VALUES ('2023-06-01', 'Carrito', 2),
       ('2023-07-15', 'Carrito', 2),
       ('2023-08-20', 'Carrito', 2),
       ('2023-09-10', 'Carrito', 2),
       ('2023-10-05', 'Carrito', 2);

-- Inserción de datos en la tabla product_order
-- Nota: Aquí se asume que la estructura de ProductOrder y sus campos están definidos
-- En caso contrario, necesitaríamos esa información para generar datos específicos
INSERT INTO product_order (purchase_order_id, product_id, quantity)
VALUES (1, 1, 10), -- Lechuga
       (1, 4, 5),  -- Leche
       (2, 7, 20), -- Helado
       (3, 2, 15), -- Manzana
       (4, 9, 8),  -- Pescado
       (5, 1, 12); -- Lechuga
