INSERT INTO CATEGORIES (id_category, name, description)
VALUES (1, 'Fresco', 'Producto fresco');

INSERT INTO CATEGORIES (id_category, name, description)
VALUES (2, 'Refrigerado', 'Producto refrigerado');

INSERT INTO CATEGORIES (id_category, name, description)
VALUES (3, 'Congelado', 'Producto congelado');

--

INSERT INTO PRODUCTS (id_product, name, price, id_category)
VALUES (1, 'Banana', 1500.0, 1);

INSERT INTO PRODUCTS (id_product, name, price, id_category)
VALUES (2, 'Manzana', 200.0, 1);

INSERT INTO PRODUCTS (id_product, name, price, id_category)
VALUES (3, 'Carne', 2030.0, 2);

INSERT INTO PRODUCTS (id_product, name, price, id_category)
VALUES (4, 'Pollo', 150.0, 2);

INSERT INTO PRODUCTS (id_product, name, price, id_category)
VALUES (5, 'Milanesa', 1300.0, 3);

--

INSERT INTO ROLES (id_role, name, description)
VALUES (1, 'Admin', 'Administrador');

INSERT INTO ROLES (id_role, name, description)
VALUES (2, 'Buyer', 'Comprador');

--

INSERT INTO USERS (id_user, username, password, email, id_role)
VALUES (1, 'juan', '$2a$10$.BdBEEvZIoGLJgmem3h/Q.Nij6Sy0ROVR4qaCT.9u6VVdfVZUVPs6', 'juan@gmail.com', 1);

INSERT INTO USERS (id_user, username, password, email, id_role)
VALUES (2, 'joaquin', '$2a$12$bu56MPYHpkVnjp.q9ADgJe56NkHs7pR8SrW11Z4pB9W8PippB5rl6', 'joaquin@gmail.com', 1);

INSERT INTO USERS (id_user, username, password, email, id_role)
VALUES (3, 'eliana', '$2a$12$TtLH7HfrWlpFQFpoorSKp.6NaMtBrUviNQP7mLVgTHe42FkeAL/a6', 'eliana@gmail.com', 2);

--

INSERT INTO WAREHOUSES (id_warehouse, name, city, province, id_user)
VALUES (1, 'Warehouse A', 'Cordoba', 'Cordoba', 1);

INSERT INTO WAREHOUSES (id_warehouse, name, city, province, id_user)
VALUES (2, 'Warehouse B', 'Formosa', 'Formosa', 2);

--

INSERT INTO SECTIONS (id_section, id_warehouse, id_category, max_batch_capacity)
VALUES (1, 1, 1, 100);

INSERT INTO SECTIONS (id_section, id_warehouse, id_category, max_batch_capacity)
VALUES (2, 1, 2, 50);

INSERT INTO SECTIONS (id_section, id_warehouse, id_category, max_batch_capacity)
VALUES (3, 1, 3, 30);

INSERT INTO SECTIONS (id_section, id_warehouse, id_category, max_batch_capacity)
VALUES (4, 2, 1, 20);

INSERT INTO SECTIONS (id_section, id_warehouse, id_category, max_batch_capacity)
VALUES (5, 2, 2, 60);

INSERT INTO SECTIONS (id_section, id_warehouse, id_category, max_batch_capacity)
VALUES (6, 2, 3, 150);

--

INSERT INTO INBOUND_ORDER (id_inbound_order, order_date, id_section)
VALUES (1, '2022-10-05', 1);

INSERT INTO INBOUND_ORDER (id_inbound_order, order_date, id_section)
VALUES (2, '2022-10-07', 2);

--

INSERT INTO BATCHES (id_batch, id_product, id_inbound_order, current_temperature, minimum_temperature, initial_quantity, current_quantity, manufacturing_date, manufacturing_time, due_date)
VALUES (1, 1, 1, 25.0, 20.0, 100, 70, '2022-10-05', '2022-10-05T10:00:00', '2025-04-01');

INSERT INTO BATCHES (id_batch, id_product, id_inbound_order, current_temperature, minimum_temperature, initial_quantity, current_quantity, manufacturing_date, manufacturing_time, due_date)
VALUES (2, 2, 1, 22.0, 18.0, 50, 50, '2022-10-07', '2022-10-07T11:00:00', '2025-04-07');

INSERT INTO BATCHES (id_batch, id_product, id_inbound_order, current_temperature, minimum_temperature, initial_quantity, current_quantity, manufacturing_date, manufacturing_time, due_date)
VALUES (3, 3, 2, 24.0, 17.0, 50, 50, '2022-10-07', '2022-10-07T11:00:00', '2023-04-07');

INSERT INTO BATCHES (id_batch, id_product, id_inbound_order, current_temperature, minimum_temperature, initial_quantity, current_quantity, manufacturing_date, manufacturing_time, due_date)
VALUES (4, 4, 2, 21.0, 19.0, 50, 50, '2022-10-07', '2022-10-07T11:00:00', '2023-04-07');

INSERT INTO BATCHES (id_batch, id_product, id_inbound_order, current_temperature, minimum_temperature, initial_quantity, current_quantity, manufacturing_date, manufacturing_time, due_date)
VALUES (5, 1, 2, 24.0, 17.0, 50, 30, '2022-10-07', '2022-10-07T11:00:00', '2025-04-20');

INSERT INTO BATCHES (id_batch, id_product, id_inbound_order, current_temperature, minimum_temperature, initial_quantity, current_quantity, manufacturing_date, manufacturing_time, due_date)
VALUES (6, 1, 2, 24.0, 17.0, 50, 12, '2022-10-07', '2022-10-07T11:00:00', '2025-04-07');

--

INSERT INTO PURCHASE_ORDERS (id_purchase_order, date, id_user)
VALUES (1, '2022-10-07', 2);

--

INSERT INTO ORDER_ITEMS (id_order_item, id_purchase_order, id_product, quantity)
VALUES (1, 1, 1, 10);

INSERT INTO ORDER_ITEMS (id_order_item, id_purchase_order, id_product, quantity)
VALUES (2, 1, 2, 20);