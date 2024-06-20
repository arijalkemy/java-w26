-- Inserting data into user_account table

INSERT INTO user_account (first_name, last_name, password, user_role, username) VALUES
                                                                                    ('nicolas', 'hoyos', '', 'BUYER', 'nhoyosp'),
                                                                                    ('juan', 'gonzalez', '$2a$10$HApgftcY3m4qgHFiaPZQkuIck/Fxios/Vwn2HvPS5ccw1NPhjWxx.', 'BUYER', 'jgonz'),
                                                                                    ('luis', 'meza', '$2a$10$dSxd1Ydm74kQeaQNqnWE9./ufOIPWWcfcO1AcK7WMivLBqyOyYBva', 'BUYER', 'mluis'),
                                                                                    ('stiven', 'garcia', '$2a$10$iSeMgntSPi8x1d1eTYAvO.4N8PAiFIMlYmEDHbrfRz8IzbJklRVsS', 'BUYER', 'gstiven'),
                                                                                    ('nicolas', 'imbachi', '$2a$10$4yGUSbLw2AAL6NDF/p5dPuemzpDUk5cBVR2CM/00mupeaIyU.1gTi', 'BUYER', 'inicolas'),
                                                                                    ('jose', 'gomez', '$2a$10$uLxyNN4XaUBe157PGY5q3uJtYPTjkRmA9jp6bHIukxj1Ki0pQJ2qu', 'BUYER', 'gjose'),
                                                                                    ('mateo', 'caldera', '$2a$10$uIBcaiVxrohx46v3Hj.keeLHKL7TOjY4JiYYaI3Kvzl9/U.J2esA.', 'BUYER', 'cmateo'),
                                                                                    ('paco', 'gomez', '$2a$10$3LBlB/0bjtY6cAHQa.LhC.RfdN0HFMul.YvC.AmpMEcWUq5sax7Za', 'SELLER', 'gpaco'),
                                                                                    ('marcos', 'zapata', '$2a$10$A41s47KxikbLvBPru/4XfOc8HFgdNXivrXRYFBsq7JHfNsQ0ZiXku', 'SELLER', 'zmarcos'),
                                                                                    ('laura', 'jimenez', '$2a$10$QEVeq1PdFum/M0CqrIHVQuMTkuYSI.CkdI6wEikAwwTiomrye2/Ha', 'SUPERVISOR', 'jlaura');


-- Inserting data into category table
INSERT INTO category (name) VALUES
                                ('FF'), -- Congelado
                                ('RF'), -- Refrigerado
                                ('FS'); -- Fresco

-- Inserting data into product table
INSERT INTO product (category_id, name, price, seller_id) VALUES
                                                   (1, 'Pizza de Pepperoni', 8.99,8),
                                                   (2, 'Zumo de Naranja Natural', 2.49,8),
                                                   (3, 'Lechuga Iceberg', 1.99,9),
                                                   (1, 'Filete de Salmón', 12.99,9),
                                                   (2, 'Yogur Natural', 0.99,9),
                                                   (3, 'Manzanas Gala', 3.49,9),
                                                   (1, 'Helado de Chocolate', 3.99,9),
                                                   (2, 'Queso Cheddar', 4.49,9),
                                                   (3, 'Ensalada César', 5.99,9),
                                                   (1, 'Pollo Congelado', 7.99,9),
                                                    (2, 'Queso Panela', 11.99,9),
                                                    (2, 'Gelatina Dani', 5.99,9);

-- Inserting data into warehouse table
INSERT INTO warehouse (supervisor_id, name) VALUES
                                                (10, 'Almacén Principal'),
                                                (10, 'Almacén Secundario'),
                                                (10, 'Almacén de Distribución'),
                                                (10, 'Almacén de Logística'),
                                                (10, 'Almacén de Cadenas de Frío'),
                                                (10, 'Almacén de Suministros'),
                                                (10, 'Almacén de Productos Electrónicos'),
                                                (10, 'Almacén de Artículos para el Hogar'),
                                                (10, 'Almacén de Alimentos No Perecederos'),
                                                (10, 'Almacén Central');

-- Inserting data into shopping_cart table
INSERT INTO shopping_cart (user_id, order_date, order_state, total) VALUES
                                                                        (1, '2024-06-13', 'shopping_cart', 0.00),
                                                                        (2, '2024-06-13', 'shopping_cart', 0.00),
                                                                        (3, '2024-06-13', 'shopping_cart', 22.99),
                                                                        (4, '2024-06-12', 'shopping_cart', 0.00),
                                                                        (5, '2024-06-12', 'shopping_cart', 0.00),
                                                                        (6, '2024-06-11', 'shopping_cart', 16.45),
                                                                        (7, '2024-06-11', 'shopping_cart', 8.98),
                                                                        (8, '2024-06-10', 'shopping_cart', 0.00),
                                                                        (9, '2024-06-10', 'shopping_cart', 45.67),
                                                                        (10, '2024-06-10', 'shopping_cart', 109.99);

-- Inserting data into shopping_cart_product table
INSERT INTO shopping_cart_product (shopping_cart_id, product_id, quantity) VALUES
                                                                               (3, 1, 2),
                                                                               (5, 3, 1),
                                                                               (3, 5, 3),
                                                                               (4, 8, 1),
                                                                               (5, 10, 5),
                                                                               (6, 2, 1),
                                                                               (7, 4, 2),
                                                                               (8, 6, 2),
                                                                               (9, 7, 3),
                                                                               (10, 9, 1),
                                                                               (1, 2, 3),
                                                                               (2, 4, 1),
                                                                               (3, 6, 2),
                                                                               (4, 8, 3),
                                                                               (5, 10, 4),
                                                                               (6, 1, 1),
                                                                               (7, 3, 2),
                                                                               (8, 5, 3),
                                                                               (9, 7, 1),
                                                                               (10, 9, 2),
                                                                               (1, 10, 1),
                                                                               (2, 8, 2),
                                                                               (3, 6, 3),
                                                                               (4, 4, 1),
                                                                               (5, 2, 2),
                                                                               (6, 3, 1),
                                                                               (7, 5, 2),
                                                                               (8, 7, 3),
                                                                               (9, 9, 4),
                                                                               (10, 1, 1),
                                                                               (1, 2, 2),
                                                                               (2, 4, 3),
                                                                               (3, 6, 1),
                                                                               (4, 8, 2),
                                                                               (5, 10, 3),
                                                                               (6, 1, 1),
                                                                               (7, 3, 2),
                                                                               (8, 5, 3),
                                                                               (9, 7, 1),
                                                                               (10, 9, 2),
                                                                               (1, 10, 1),
                                                                               (2, 8, 2),
                                                                               (3, 6, 3),
                                                                               (4, 4, 1),
                                                                               (5, 2, 2),
                                                                               (6, 3, 3),
                                                                               (7, 5, 1),
                                                                               (8, 7, 2),
                                                                               (9, 9, 3),
                                                                               (10, 1, 1),
                                                                               (1, 2, 2),
                                                                               (2, 4, 3),
                                                                               (3, 6, 1),
                                                                               (4, 8, 2),
                                                                               (5, 10, 3);

-- Inserting data into sector table
INSERT INTO sector (warehouse_id, category_id, name, description) VALUES
                                                                      (1, 1, 'Alimentos Congelados', 'Almacenamiento de productos congelados'),
                                                                      (2, 3, 'Productos Frescos', 'Almacenamiento de productos frescos'),
                                                                      (3, 2, 'Productos Refrigerados', 'Almacenamiento de productos refrigerados'),
                                                                      (4, 1, 'Carnes Congeladas', 'Almacenamiento de carnes congeladas'),
                                                                      (5, 3, 'Frutas Frescas', 'Almacenamiento de frutas frescas'),
                                                                      (6, 2, 'Lácteos Refrigerados', 'Almacenamiento de productos lácteos refrigerados'),
                                                                      (7, 1, 'Postres Congelados', 'Almacenamiento de postres congelados'),
                                                                      (8, 2, 'Bebidas Refrigeradas', 'Almacenamiento de bebidas refrigeradas'),
                                                                      (9, 3, 'Verduras Frescas', 'Almacenamiento de verduras frescas'),
                                                                      (10, 1, 'Pescados Congelados', 'Almacenamiento de pescados y mariscos congelados');

-- Inserting data into inbound_order table
INSERT INTO inbound_order (warehouse_id, order_number) VALUES
                                                           (1, 1001),
                                                           (2, 1002),
                                                           (3, 1003),
                                                           (4, 1004),
                                                           (5, 1005),
                                                           (6, 1006),
                                                           (7, 1007),
                                                           (8, 1008),
                                                           (9, 1009),
                                                           (10, 1010);

-- Inserting data into batch table
INSERT INTO `batch` (product_id, sector_id, inbound_id, batch_number, current_temperature, minimum_temperature, initial_quantity, current_quantity, manufacturing_date, manufacturing_time, due_date) VALUES
                                                                                                                                                                                                          (1, 1, 1, 12345, -18.0, -20.0, 100, 100, '2024-06-12', '08:00:00', '2024-07-30'),
                                                                                                                                                                                                          (1, 1, 1, 350532, -18.0, -20.0, 200, 150, '2024-06-12', '08:00:00', '2024-08-15'),
                                                                                                                                                                                                          (1, 1, 1, 250832, -18.0, -20.0, 300, 300, '2024-06-12', '08:00:00', '2024-08-30'),
                                                                                                                                                                                                          (3, 2, 2, 54321, 4.0, 2.0, 50, 50, '2024-06-10', '10:00:00', '2024-06-20'),
                                                                                                                                                                                                          (5, 3, 3, 98765, 25.0, 20.0, 200, 200, '2024-06-08', '12:00:00', '2024-06-18'),
                                                                                                                                                                                                          (7, 4, 4, 13579, 8.0, 5.0, 150, 150, '2024-06-06', '09:30:00', '2024-06-16'),
                                                                                                                                                                                                          (9, 5, 5, 24680, 22.0, 20.0, 80, 80, '2024-06-04', '11:15:00', '2024-06-14'),
                                                                                                                                                                                                          (2, 6, 6, 86420, -10.0, -15.0, 120, 120, '2024-06-02', '14:00:00', '2024-06-12'),
                                                                                                                                                                                                          (4, 7, 7, 97531, 4.0, 2.0, 100, 100, '2024-06-01', '16:30:00', '2024-06-11'),
                                                                                                                                                                                                          (6, 8, 8, 75309, 22.0, 20.0, 90, 90, '2024-05-30', '08:45:00', '2024-06-09'),
                                                                                                                                                                                                          (8, 9, 9, 35791, NULL, NULL, 200, 200, '2024-05-28', '10:45:00', '2024-06-08'),
                                                                                                                                                                                                          (10, 10, 10, 15937, NULL, NULL, 120, 120, '2024-05-26', '13:20:00', '2024-06-06');
