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
