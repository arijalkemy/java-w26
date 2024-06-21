-- Example of inserting data into the Warehouse table
INSERT INTO Warehouse (id, warehouse_location)
VALUES (1, 'La Plata'),
       (2, 'Burzaco');

INSERT INTO users (username, role) VALUES
                                       ('manager', 'MANAGER'),
                                       ('buyer', 'BUYER'),
                                       ('seller', 'SELLER');

-- Agregar user a warehouse
INSERT INTO warehouse_manager (user_id, warehouse_id) VALUES
                                                          (1, 1),
                                                          (2, 2);

-- Inserción de datos en la tabla ProductType
INSERT INTO Product_Type (description)
VALUES ('FRESCO'),
       ('REFRIGERADO'),
       ('CONGELADO');

-- Inserción de datos en la tabla Product
INSERT INTO Product (product_Type_id, description, product_price)
VALUES (1, 'Lechuga', 1.50),
       (1, 'Manzana', 0.80),
       (1, 'Tomate', 1.20), --frescos
       (2, 'Leche', 0.99),
       (2, 'Yogur', 0.60),
       (2, 'Queso', 2.50),--refrigerado
       (3, 'Carne', 3.50),
       (3, 'Helado', 1.80),
       (3, 'Pescado', 4.00);--congelado


-- Inserción de datos en la tabla Section
INSERT INTO Section (id, capacity, product_type, warehouse_id)
VALUES (1, 1000, 1, 1), --1 fresco, 2 refrigerado y 3 congelado
       (4, 1500, 2, 1),
       (2, 2000, 3, 1),
       (3, 2500, 1, 2),
       (5, 3000, 2, 2);


-- Inserción de datos en la tabla InboundOrder
INSERT INTO Inbound_Order (order_date, order_number, warehouse_id, section_id)
VALUES ('2023-06-01', 1001, 1, 1),
       ('2023-07-15', 1002, 1, 2),
       ('2023-08-20', 1003, 1, 3),
       ('2023-09-10', 1004, 2, 4),
       ('2023-10-05', 1005, 2, 1);

-- Inserción de datos en la tabla Batch
INSERT INTO Batch (id, current_temperature, minimum_temperature, manufacturing_date, initial_quantity, current_quantity, due_date, manufacturing_time, product_id, order_number) VALUES
(1, 10.0, 0.0, '2023-06-01', 100, 80, '2024-06-01', '2023-09-01 08:00:00', 1, 1001),
(2, 5.0, -5.0, '2023-07-15', 200, 150, '2024-06-28', '2023-07-15 09:30:00', 2, 1001),
(3, -18.0, -20.0, '2023-08-20', 300, 250, '2024-06-25', '2023-08-20 10:45:00', 7, 1001),
(4, 5.0, -5.0, '2023-07-15', 200, 150, '2024-06-27', '2023-07-15 09:30:00', 4, 1001),
(5, -18.0, -20.0, '2023-08-20', 300, 250, '2024-06-26', '2023-08-20 10:45:00', 6, 1001),
(6, 12.0, 5.0, '2023-09-10', 150, 120, '2024-09-10', '2023-09-10 11:15:00', 3, 1001),
(7, -10.0, -18.0, '2023-10-05', 250, 200, '2024-10-05', '2023-10-05 07:50:00', 5, 1001);



-- Inserción de datos en la tabla section_batch
INSERT INTO section_batch (section_id, batch_id)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (4, 4),
       (5, 5),
       (5, 6);

-- Inserción de datos en la tabla PurchaseOrder
INSERT INTO Purchase_Order (date, status, buyer) VALUES
('2023-06-01', 'Carrito', 2),
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
INSERT INTO product_Promo (id, product_type_id, description, price_original, price_promo, start_date, end_date)
VALUES
    (1, 1, 'lechuga', 20.0, 13.2, '2024-06-01', '2024-06-30'),
    (2, 2, 'leche', 149.99, 129.99, '2024-06-05', '2024-07-05'),
    (3, 3, 'helado', 79.99, 64.99, '2024-06-10', '2024-06-25'),
    (4, 3, 'Carne', 59.99, 39.99, '2024-06-15', '2024-06-30'),
    (5, 2, 'queso', 100.99, 80.99, '2024-06-20', '2024-07-10'),
    (6, 1, 'tomate', 149.99, 99.99, '2024-06-25', '2024-07-15');