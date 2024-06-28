-- Insertar tipos de almacenamiento
INSERT INTO storage_type (name)
VALUES ('Fresco'),
       ('Refrigerado'),
       ('Congelado');

-- Insertar almacenes
INSERT INTO warehouses (name, address)
VALUES ('Bogotá Warehouse', 'Bogotá, Colombia');

-- Insertar compradores
INSERT INTO buyers (nit, name, last_name)
VALUES ('900000001', 'Edwin', 'Villarraga');

-- Insertar estados
INSERT INTO status (description)
VALUES ('carrito'),
       ('vendido');

-- Insertar vendedores
INSERT INTO sellers (name, description)
VALUES ('AgroAlimentos S.A.', 'Proveedor de productos frescos, refrigerados y congelados.');

-- Insertar productos
INSERT INTO products (description, type_id)
VALUES ('Lechuga', 1),
       ('Yogur', 2),
       ('Helado', 3);

-- Insertar secciones
INSERT INTO sections (name, size, type_id, warehouse_id)
VALUES ('Sección Frescos Bogotá', 100, 1, 1),
       ('Sección Refrigerados Bogotá', 100, 2, 1),
       ('Sección Congelados Bogotá', 100, 3, 1);

-- Insertar representantes para los almacenes
INSERT INTO representatives (name, warehouse_id)
VALUES ('Juan Perez', 1);

-- Insertar product_seller
INSERT INTO product_seller (price, seller_id, product_id)
VALUES (10.99, 1, 1),
       (15.99, 1, 2),
       (20.99, 1, 3);

-- Insertar lotes
INSERT INTO batches (batch_number, current_temperature, minimum_temperature, initial_quantity, current_quantity,
                     manufacturing_date, manufacturing_time, due_date, product_seller_id, representative_id, section_id)
VALUES (1, 5.0, 2.0, 100, 50, '2024-05-01', '2024-05-01 08:00:00', '2024-06-05', 1, 1, 1);

-- Insertar orden
INSERT INTO orders (date, total, buyer_id, status_id)
VALUES ('2024-06-11', 109.90, 1, 1);

-- Insertar order_product_seller
INSERT INTO order_product_seller (quantity, price, order_id, product_seller_id)
VALUES (10, 10.99, 1, 1);