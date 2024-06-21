-- Insertar tipos de almacenamiento
INSERT INTO storage_type (name)
VALUES ('Fresco'),
       ('Refrigerado'),
       ('Congelado');

-- Insertar almacenes
INSERT INTO warehouses (name, address)
VALUES ('Bogotá Warehouse', 'Bogotá, Colombia'),
       ('Mexico City Warehouse', 'Ciudad de México, México'),
       ('Buenos Aires Warehouse', 'Buenos Aires, Argentina');

-- Insertar compradores
INSERT INTO buyers (nit, name, last_name)
VALUES ('900000001', 'Edwin', 'Villarraga'),
       ('900000002', 'Carlos', 'Cardozo'),
       ('900000003', 'Brayan', 'Algo'),
       ('900000004', 'Monica', 'Algo'),
       ('900000005', 'Santiago', 'Algo'),
       ('900000006', 'Cristian', 'Algo');

-- Insertar estados
INSERT INTO status (description)
VALUES ('carrito'),
       ('vendido'),
       ('rechazado'),
       ('cancelado');

-- Insertar vendedores
INSERT INTO sellers (name, description)
VALUES ('AgroAlimentos S.A.', 'Proveedor de productos frescos, refrigerados y congelados.'),
       ('Distribuidora NutriVida', 'Especialistas en productos frescos, refrigerados y congelados.'),
       ('Alimentos Riquísimos', 'Proveedor confiable de alimentos frescos, refrigerados y congelados.'),
       ('Comercializadora BuenGusto', 'Distribuidor de alimentos frescos, refrigerados y congelados.'),
       ('Mercado Verde', 'Proveedores de alimentos frescos, refrigerados y congelados de alta calidad.');

-- Insertar Productos

-- Productos frescos
INSERT INTO products (description, type_id)
VALUES ('Lechuga', 1),
       ('Tomate', 1),
       ('Manzana', 1),
       ('Zanahoria', 1),
       ('Brócoli', 1),
       ('Pepino', 1),
       ('Espinaca', 1),
       ('Fresa', 1),
       ('Cilantro', 1),
       ('Perejil', 1);

-- Productos refrigerados
INSERT INTO products (description, type_id)
VALUES ('Yogur', 2),
       ('Leche', 2),
       ('Queso', 2),
       ('Jamón', 2),
       ('Mantequilla', 2),
       ('Tocino', 2),
       ('Salchichas', 2),
       ('Crema', 2),
       ('Huevos', 2),
       ('Jugo de Naranja', 2);

-- Productos congelados
INSERT INTO products (description, type_id)
VALUES ('Helado', 3),
       ('Pescado', 3),
       ('Pollo', 3),
       ('Carne de Res', 3),
       ('Camarones', 3),
       ('Verduras Congeladas', 3),
       ('Frutas Congeladas', 3),
       ('Pavo', 3),
       ('Merluza', 3),
       ('Calamares', 3);

-- Insertar secciones

-- Secciones para el warehouse en Bogotá
INSERT INTO sections (name, size, type_id, warehouse_id)
VALUES ('Sección Frescos Bogotá', 10000000, 1, 1),
       ('Sección Refrigerados Bogotá', 10000000, 2, 1),
       ('Sección Congelados Bogotá', 10000000, 3, 1);

-- Secciones para el warehouse en Ciudad de México
INSERT INTO sections (name, size, type_id, warehouse_id)
VALUES ('Sección Frescos Ciudad de México', 150, 1, 2),
       ('Sección Refrigerados Ciudad de México', 250, 2, 2),
       ('Sección Congelados Ciudad de México', 350, 3, 2);

-- Secciones para el warehouse en Buenos Aires
INSERT INTO sections (name, size, type_id, warehouse_id)
VALUES ('Sección Frescos Buenos Aires', 120, 1, 3),
       ('Sección Refrigerados Buenos Aires', 220, 2, 3),
       ('Sección Congelados Buenos Aires', 320, 3, 3);

-- Insertar representantes para los almacenes
INSERT INTO representatives (name, warehouse_id)
VALUES ('Juan Perez', 1),
       ('Ana Gomez', 2),
       ('Carlos Lopez', 3);

INSERT INTO product_seller (price, seller_id, product_id)
VALUES
    -- Productos frescos
    (10.99, 1, 1),
    (8.99, 2, 1),
    (9.49, 3, 1),
    (8.99, 2, 2),
    (9.99, 4, 2),
    (7.99, 5, 2),
    (12.99, 3, 3),
    (10.49, 1, 3),
    (11.99, 5, 3),
    (6.99, 4, 4),
    (7.49, 2, 4),
    (6.49, 1, 4),
    (9.99, 5, 5),
    (8.49, 3, 5),
    (9.49, 2, 5),
    (7.99, 1, 6),
    (7.49, 4, 6),
    (8.99, 3, 6),
    (11.99, 2, 7),
    (10.49, 5, 7),
    (9.99, 1, 7),
    (13.99, 3, 8),
    (12.49, 4, 8),
    (11.49, 2, 8),
    (5.99, 4, 9),
    (6.49, 1, 9),
    (5.49, 3, 9),
    (6.49, 5, 10),
    (6.99, 2, 10),
    (7.49, 3, 10),

    -- Productos refrigerados
    (15.99, 1, 11),
    (14.99, 3, 11),
    (16.49, 2, 11),
    (18.99, 2, 12),
    (17.99, 4, 12),
    (19.49, 5, 12),
    (11.99, 3, 13),
    (12.49, 1, 13),
    (13.99, 4, 13),
    (14.99, 4, 14),
    (13.99, 2, 14),
    (15.49, 1, 14),
    (17.99, 5, 15),
    (18.49, 3, 15),
    (16.99, 2, 15),
    (16.49, 1, 16),
    (15.99, 3, 16),
    (17.49, 2, 16),
    (19.99, 2, 17),
    (18.99, 4, 17),
    (20.49, 5, 17),
    (12.49, 3, 18),
    (13.49, 1, 18),
    (14.99, 4, 18),
    (15.49, 4, 19),
    (14.99, 2, 19),
    (16.49, 1, 19),
    (18.49, 5, 20),
    (17.99, 3, 20),
    (19.49, 2, 20),

    -- Productos congelados
    (20.99, 1, 21),
    (19.99, 3, 21),
    (21.49, 2, 21),
    (22.99, 2, 22),
    (21.99, 4, 22),
    (23.49, 5, 22),
    (25.99, 3, 23),
    (24.99, 1, 23),
    (26.49, 4, 23),
    (21.99, 4, 24),
    (20.99, 2, 24),
    (22.49, 1, 24),
    (24.99, 5, 25),
    (23.49, 3, 25),
    (25.49, 2, 25),
    (23.99, 1, 26),
    (22.99, 3, 26),
    (24.49, 2, 26),
    (26.99, 2, 27),
    (25.99, 4, 27),
    (27.49, 5, 27),
    (27.99, 3, 28),
    (26.49, 1, 28),
    (28.49, 4, 28),
    (22.49, 4, 29),
    (21.99, 2, 29),
    (23.49, 1, 29),
    (26.49, 5, 30),
    (25.49, 3, 30),
    (27.49, 2, 30);

-- Insertar lotes en el warehouse de Bogotá
INSERT INTO batches (batch_number, current_temperature, minimum_temperature, initial_quantity, current_quantity,
                     manufacturing_date, manufacturing_time, due_date, product_seller_id, representative_id, section_id)
VALUES (1, 5.0, 2.0, 100, 50, '2024-05-01', '2024-05-01 08:00:00', '2024-06-05', 1, 1, 1),
       (2, 5.0, 2.0, 100, 70, '2024-05-10', '2024-05-10 08:00:00', '2024-06-10', 2, 1, 1),
       (3, 5.0, 2.0, 100, 90, '2024-05-15', '2024-05-15 08:00:00', '2024-06-20', 3, 1, 1),
       (4, 5.0, 2.0, 100, 80, '2024-05-05', '2024-05-05 08:00:00', '2024-07-20', 4, 1, 1),
       (5, 5.0, 2.0, 100, 60, '2024-05-20', '2024-05-20 08:00:00', '2024-08-25', 4, 1, 1),
       (6, 5.0, 2.0, 100, 50, '2024-05-12', '2024-05-12 08:00:00', '2024-06-30', 8, 1, 1),
       (7, 5.0, 2.0, 100, 70, '2024-05-18', '2024-05-18 08:00:00', '2024-07-05', 9, 1, 1),
       (8, 5.0, 2.0, 100, 80, '2024-05-22', '2024-05-22 08:00:00', '2024-07-10', 11, 1, 1),
       (9, 5.0, 2.0, 100, 60, '2024-05-25', '2024-05-25 08:00:00', '2024-07-15', 12, 1, 1),
       (10, 5.0, 2.0, 100, 50, '2024-05-30', '2024-05-30 08:00:00', '2024-07-20', 16, 1, 1),

       (11, 3.0, 1.0, 100, 90, '2024-05-05', '2024-05-05 08:00:00', '2024-06-10', 34, 1, 2),
       (12, 3.0, 1.0, 100, 80, '2024-05-15', '2024-05-15 08:00:00', '2024-06-20', 35, 1, 2),
       (13, 3.0, 1.0, 100, 70, '2024-05-18', '2024-05-18 08:00:00', '2024-06-25', 31, 1, 2),
       (14, 3.0, 1.0, 100, 60, '2024-05-20', '2024-05-20 08:00:00', '2024-06-30', 32, 1, 2),
       (15, 3.0, 1.0, 100, 50, '2024-05-25', '2024-05-25 08:00:00', '2024-07-05', 37, 1, 2),
       (16, 3.0, 1.0, 100, 40, '2024-05-28', '2024-05-28 08:00:00', '2024-07-10', 38, 1, 2),
       (17, -18.0, -20.0, 100, 30, '2024-05-12', '2024-05-12 08:00:00', '2024-06-15', 61, 1, 3),
       (18, -18.0, -20.0, 100, 20, '2024-05-15', '2024-05-15 08:00:00', '2024-06-25', 62, 1, 3),
       (19, -18.0, -20.0, 100, 10, '2024-05-20', '2024-05-20 08:00:00', '2024-06-30', 64, 1, 3),
       (20, -18.0, -20.0, 100, 5, '2024-05-22', '2024-05-22 08:00:00', '2024-07-05', 65, 1, 3);

-- Insertar lotes en el warehouse de Ciudad de México
INSERT INTO batches (batch_number, current_temperature, minimum_temperature, initial_quantity, current_quantity,
                     manufacturing_date, manufacturing_time, due_date, product_seller_id, representative_id, section_id)
VALUES (21, 5.0, 2.0, 100, 50, '2024-05-10', '2024-05-10 08:00:00', '2024-06-12', 4, 2, 4),
       (22, 5.0, 2.0, 100, 70, '2024-05-12', '2024-05-12 08:00:00', '2024-06-14', 7, 2, 4),
       (23, 3.0, 1.0, 100, 90, '2024-05-15', '2024-05-15 08:00:00', '2024-06-20', 18, 2, 5),
       (24, 3.0, 1.0, 100, 80, '2024-05-18', '2024-05-18 08:00:00', '2024-06-25', 19, 2, 5),
       (25, -18.0, -20.0, 100, 70, '2024-05-20', '2024-05-20 08:00:00', '2024-07-01', 27, 2, 6);

-- Insertar lotes en el warehouse de Buenos Aires
INSERT INTO batches (batch_number, current_temperature, minimum_temperature, initial_quantity, current_quantity,
                     manufacturing_date, manufacturing_time, due_date, product_seller_id, representative_id, section_id)
VALUES (26, 5.0, 2.0, 100, 60, '2024-05-10', '2024-05-10 08:00:00', '2024-06-20', 9, 3, 7),
       (27, 5.0, 2.0, 100, 70, '2024-05-12', '2024-05-12 08:00:00', '2024-06-22', 11, 3, 7);

-- Insertar orden - Comprador 3
INSERT INTO orders (date, total, buyer_id, status_id)
VALUES ('2024-06-11', 694.65, 1, 1);

-- Insertar orden - Comprador 4
INSERT INTO orders (date, total, buyer_id, status_id)
VALUES ('2024-06-15', 532.36, 2, 1);

-- Insertar orden - Comprador 5
INSERT INTO orders (date, total, buyer_id, status_id)
VALUES ('2024-06-20', 251.81, 3, 1);

INSERT INTO order_product_seller (quantity, price, order_id, product_seller_id)
VALUES (5, 10.99, 1, 1),  -- Lechuga de vendedor 1
       (3, 8.99, 1, 6),   -- Tomate de vendedor 2
       (7, 12.99, 1, 11), -- Manzana de vendedor 3
       (6, 15.99, 1, 16), -- Yogur de vendedor 1
       (3, 18.99, 1, 21), -- Helado de vendedor 1
       (4, 22.99, 1, 31), -- Pescado de vendedor 1
       (7, 19.99, 1, 41); -- Pollo de vendedor 1


INSERT INTO order_product_seller (quantity, price, order_id, product_seller_id)
VALUES (3, 10.99, 2, 2),  -- Lechuga de vendedor 2
       (2, 8.99, 2, 7),   -- Tomate de vendedor 3
       (4, 12.99, 2, 12), -- Manzana de vendedor 2
       (5, 6.99, 2, 18),  -- Zanahoria de vendedor 1
       (4, 15.99, 2, 25), -- Queso de vendedor 1
       (3, 22.99, 2, 39), -- Pavo de vendedor 1
       (5, 17.99, 2, 55); -- Salchichas de vendedor 1


INSERT INTO order_product_seller (quantity, price, order_id, product_seller_id)
VALUES (4, 10.99, 3, 3),  -- Lechuga de vendedor 3
       (6, 8.99, 3, 8),   -- Tomate de vendedor 4
       (3, 12.99, 3, 13), -- Manzana de vendedor 3
       (5, 6.99, 3, 24),  -- Brócoli de vendedor 1
       (4, 19.99, 3, 48), -- Pescado de vendedor 3
       (3, 25.99, 3, 61), -- Camarones de vendedor 1
       (5, 11.99, 3, 75); -- Tocino de vendedorr 1