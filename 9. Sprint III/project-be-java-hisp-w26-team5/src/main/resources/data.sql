
INSERT INTO location (id,longitude, latitude) VALUES (1,40.7128, -74.0060);
INSERT INTO location (id,longitude, latitude) VALUES (2,34.0522, -118.2437);
INSERT INTO location (id,longitude, latitude) VALUES (3,41.8781, -87.6298);
INSERT INTO location (id,longitude, latitude) VALUES (4,29.7604, -95.3698);
INSERT INTO location (id,longitude, latitude) VALUES (5,33.4484, -112.0740);

INSERT INTO user_entity (id_user, first_name, last_name, role, username, password, registration_date)
VALUES (718926436, 'John', 'Doe', 'SELLER', 'johndoe', '$2a$12$eXmV975B8NM4gfFghvqJF./xU.mXooIUtgRVpOPTlimxIm44jVjWK',
        CURRENT_TIMESTAMP),
       (12497864, 'Carlos', 'Alcaraz', 'MANAGER', 'calcaraz',
        '$2a$12$eXmV975B8NM4gfFghvqJF./xU.mXooIUtgRVpOPTlimxIm44jVjWK', CURRENT_TIMESTAMP),
       (5, 'Jhon', 'Doe', 'SELLER', 'jndoe', '$2a$12$y9fCb3vmZA34Lr/dhKY.juW5CGu7d6RfzlvN5J/IV9DQWv/tfbEbG',
        CURRENT_TIMESTAMP);

-- Insert into product
INSERT INTO product (id_product, id_seller, name, price, description, type, creation_date)
VALUES (1, 5, 'Apple', 300, 'Description Apple', 'FS', CURRENT_DATE),
       (2, 5, 'Banana', 300, 'Description Banana', 'FS', CURRENT_DATE),
       (3, 5, 'Chicken', 300, 'Description Chicken', 'FF', CURRENT_DATE),
       (4, 718926436, 'Eggs', 300, 'Huevos de gallina de campo 12u.', 'FS', CURRENT_TIMESTAMP);

-- Insert into warehouse
INSERT INTO warehouse (id_warehouse, id_user, name, id_location)
VALUES (1, 12497864, 'Deposito Principal',4),
       (2, 12497864, 'Deposito Sin Uso',5);

-- Insert into sector
INSERT INTO sector (id_warehouse, name, type, temperature)
VALUES (1, 'Sector Frescos', 'FS', 12),
       (1, 'Sector Refrigerados', 'RF', 5),
       (1, 'Sector Congelados', 'FF', 0);

INSERT INTO batch (id_batch, batch_number, id_product, id_sector, current_temperature, minimum_temperature,
                   manufacturing_date, manufacturing_time, expiration_date, initial_quantity, current_quantity,
                   entry_date)
VALUES (0, '20240501-123', 1, 1, 20.0, 15.0, '2024-05-01', '2024-05-01 00:00:00', '2024-07-01', 12, 12,
        CURRENT_TIMESTAMP);

-- Insertar Usuarios (User Entity)
INSERT INTO user_entity (id_user, first_name, last_name, role, username, password, registration_date)
VALUES (100, 'Alice', 'Smith', 'SELLER', 'alice', '$2a$12$/ByXEpbGgKBX.QEIm3t.yOhfeWKIW0L8qREBAhz5d2iGhNJn3Qmgu',
        CURRENT_TIMESTAMP),
       (101, 'Bob', 'Jones', 'MANAGER', 'bob', '$2a$12$/ByXEpbGgKBX.QEIm3t.yOhfeWKIW0L8qREBAhz5d2iGhNJn3Qmgu',
        CURRENT_TIMESTAMP);


INSERT INTO user_entity (id_user, first_name, last_name, role, username, password, registration_date, id_location)
VALUES (102, 'Charlie', 'Brown', 'BUYER', 'charlie', '$2a$12$/ByXEpbGgKBX.QEIm3t.yOhfeWKIW0L8qREBAhz5d2iGhNJn3Qmgu',
        CURRENT_TIMESTAMP,1);

-- Insertar Almacenes (Warehouse)
INSERT INTO warehouse (id_warehouse, id_user, name, id_location)
VALUES (100, 101, 'Main Warehouse',2),
       (101, 101, 'Secondary Warehouse',3);

-- Insertar Sectores (Sector)
INSERT INTO sector (id_sector, id_warehouse, name, type, temperature)
VALUES (100, 100, 'Cold Storage', 'FS', 5.00),
       (101, 101, 'Dry Storage', 'RF', 22.00);

-- Insertar Productos (Product)
INSERT INTO product (id_product, id_seller, price, name, description, type, creation_date)
VALUES (100, 100, 300, 'Milk', 'Fresh milk', 'FS', '2022-01-02'),
       (101, 100, 300, 'Apple', 'Apple', 'FS', '2022-01-02');

-- Insertar Lotes (Batch)
INSERT INTO batch (id_batch, batch_number, id_product, id_sector, current_temperature, minimum_temperature,
                   manufacturing_date, manufacturing_time, expiration_date, initial_quantity, current_quantity,
                   entry_date)
VALUES (100, '20240501-124', 100, 100, 20.0, 15.0, '2024-05-01', '2020-05-01 00:00:00', '2028-07-01', 100, 100,
        CURRENT_TIMESTAMP),
       (101, '20240501-125', 101, 101, 20.0, 15.0, '2025-06-01', '2020-06-01 00:00:00', '2028-08-01', 50, 50,
        CURRENT_TIMESTAMP);

-- Insertar Órdenes (OrderEntity)
INSERT INTO purchase_order (id_purchase_order, id_user, date, status)
VALUES (100, 102, '2022-01-05', 'PENDING'),
       (101, 102, '2022-01-06', 'SHIPPED');

-- Insertar Detalles de Orden (OrderDetail)
INSERT INTO order_detail (id_detail, id_warehouse, id_purchase_order, id_product, quantity, price)
VALUES (100, 100, 100, 100, 10, 300),
       (101, 100,100, 101, 5, 300),
       (102, 100, 101, 100, 20, 300),
       (103, 100, 101, 101, 10, 300);

/*
-- Insert into product
INSERT INTO product (id_product, id_seller, name, description, type, creation_date)
VALUES (1, 718926436, 'Docena de huevos', 'Huevos de gallina de campo 12u.', 'FS', CURRENT_TIMESTAMP);

-- Insert into warehouse
INSERT INTO warehouse (id_warehouse, id_user, name, location)
VALUES (1, 12497864, 'Deposito Principal', 'Avenida Santa Fe 8923'),
(2, 12497864, 'Deposito Sin Uso', 'Avenida Santa Fe 8923');

-- Insert into sector
INSERT INTO sector (id_warehouse, name, type, temperature)
VALUES (1,'Sector Frescos', 'FS', 12),
(1,'Sector Refrigerados', 'RF', 5),
(1,'Sector Congelados', 'FF', 0);
*/
-- Insert into batch
-- INSERT INTO batch (id_batch, batch_number, id_product, id_sector, current_temperature, minimum_temperature, manufacturing_date, manufacturing_time, expiration_date, initial_quantity, current_quantity, entry_date)
-- VALUES (1, 'Batch 1', 1, 1, 20.0, 15.0, '2022-01-01', '2022-01-01 00:00:00', '2023-01-01', 12, 12, CURRENT_TIMESTAMP);