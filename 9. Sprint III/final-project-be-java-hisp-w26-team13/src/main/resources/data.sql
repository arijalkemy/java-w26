INSERT INTO roles (name)
VALUES ('representante'),
       ('buyer');

INSERT INTO users (rol_id, username, password)
VALUES (1, 'user1', '$2a$10$jRPGjlk2uf3TD2S3cEfz2u4ze1u6apXqjxLxL4b17ETWk0s94M3BK'),
       (1, 'user2', '$2a$10$jRPGjlk2uf3TD2S3cEfz2u4ze1u6apXqjxLxL4b17ETWk0s94M3BK'),
       (2, 'mia', '$2a$10$NzCTdQaQu73yvM7a0Xpzru7KF.Sd.Ff5h8bHNLQVW7lOVRtEAO.Rq');

-- Insertar datos en PRODUCT
INSERT INTO products (name, price)
VALUES ('Producto A', 10.20),
       ('Producto B', 25.00),
       ('Producto C', 50.25),
       ('Producto D', 10.20);

INSERT INTO warehouses (name,warehouse_code)
VALUES ('WH1',2013),
       ('WH2',1234);

INSERT INTO sections (name, warehouse_id)
VALUES ('Refrigerado', 1),
       ('Congelado', 1),
       ('Fresco', 1),
       ('Refrigerado', 2),
       ('Congelado', 2),
       ('Fresco', 2);

INSERT INTO orders (order_number, order_date, section_id)
VALUES (1, '2024-06-12', 1),
       (2, '2024-06-13', 2),
       (3, '2024-06-14', 3),
       (4, '2024-8-10', 1);

-- Insertar datos en CART
INSERT INTO carts (buyer_id, date, status, total_price)
VALUES (1, '2024-06-17', 'Carrito', 300.00),
       (1, '2024-06-17', 'Carrito', 5000.00),
       (1, '2024-08-10', 'Carrito', 300.00);

-- Insertar datos en CART_DETAIL
INSERT INTO cart_details (cart_id, product_id, quantity, unit_price)
VALUES (1, 1, 10, 10.20),
       (2, 2, 5, 25.29),
       (3, 4, 10, 10.20);

INSERT INTO batchs (product_id, batch_number, current_temperature, minimum_temperature, initial_quantity,
                    current_quantity, manufacturing_date, manufacturing_time, order_id,due_date)
VALUES (1, 'B001', 4.5, 2.0, 100, 100, '2024-06-10', '08:00:00', 1,'2024-08-10'),
       (2, 'B002', -10.0, -15.0, 50, 50, '2024-06-11', '09:00:00', 2,'2024-06-25'),
       (3, 'B003', -1.0, -5.0, 25, 25, '2024-06-11', '09:00:00', 2,'2024-06-26'),
       (4, 'B004', 4.5, 2.0, 100, 100, '2024-06-10', '08:00:00', 1,'2024-08-10'),
       (4, 'B005', 3.0, 2.0, 100, 80, '2024-06-10', '08:00:00', 1,'2024-08-9'),
       (4, 'B006', 2.5, 2.0, 100, 60, '2024-06-10', '09:00:00', 1,'2024-08-8');
