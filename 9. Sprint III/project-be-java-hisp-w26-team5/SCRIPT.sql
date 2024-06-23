use freshprods;

CREATE TABLE IF NOT EXISTS user_entity (
    id_user INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(25) NOT NULL,
    last_name VARCHAR(25) NOT NULL,
    role ENUM('BUYER', 'SELLER', 'MANAGER') NOT NULL,
    username VARCHAR(25) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE IF NOT EXISTS product (
    id_product INT PRIMARY KEY AUTO_INCREMENT,
    id_seller INT NOT NULL,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    price DECIMAL(5,2) NOT NULL,
    type ENUM('FS', 'RF', 'FF') NOT NULL,
    creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_seller) REFERENCES user_entity(id_user)
);

CREATE TABLE IF NOT EXISTS warehouse (
    id_warehouse INT PRIMARY KEY AUTO_INCREMENT,
    id_user INT NOT NULL,
    name VARCHAR(50) NOT NULL,
    location VARCHAR(50) NOT NULL,
    FOREIGN KEY (id_user) REFERENCES user_entity(id_user)
);
CREATE TABLE IF NOT EXISTS sector (
    id_sector INT PRIMARY KEY AUTO_INCREMENT,
    id_warehouse INT NOT NULL,
    name VARCHAR(50) NOT NULL,
    type ENUM('FS', 'RF', 'FF') NOT NULL,
    temperature DECIMAL(5,2) NOT NULL,
    FOREIGN KEY (id_warehouse) REFERENCES warehouse(id_warehouse)
);
CREATE TABLE IF NOT EXISTS batch (
    id_batch INT PRIMARY KEY AUTO_INCREMENT,
    id_product INT NOT NULL,
    id_sector INT NOT NULL,
    expiration_date DATE NOT NULL,
    manufacturing_date DATE NOT NULL,
    manufacturing_time DATETIME NOT NULL,
    batch_number VARCHAR(100) NOT NULL,
    current_quantity INT NOT NULL,
    initial_quantity INT NOT NULL,
    minimum_temperature DECIMAL(5,2) NOT NULL,
    current_temperature DECIMAL(5,2) NOT NULL,
    entry_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_sector) REFERENCES sector(id_sector),
    FOREIGN KEY (id_product) REFERENCES product(id_product)
);
CREATE TABLE IF NOT EXISTS purchase_order (
    id_purchase_order INT PRIMARY KEY AUTO_INCREMENT,
    id_user INT NOT NULL,
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(100) NOT NULL,
    FOREIGN KEY (id_user) REFERENCES user_entity(id_user)
);
CREATE TABLE IF NOT EXISTS order_detail (
    id_detail INT PRIMARY KEY AUTO_INCREMENT,
    id_purchase_order INT NOT NULL,
    id_product INT NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(5,2) NOT NULL,
    FOREIGN KEY (id_purchase_order) REFERENCES purchase_order(id_purchase_order),
    FOREIGN KEY (id_product) REFERENCES product(id_product)
);

select * from product;

-- Insert into product
INSERT INTO product (id_product, id_seller, name, price, description, type, creation_date)
VALUES (1, 1, 'Apple', 300, 'Description Apple', 'FS', CURRENT_DATE),
       (2, 1, 'Banana', 300, 'Description Banana', 'FS', CURRENT_DATE),
       (3, 1, 'Chicken', 300, 'Description Chicken', 'FF', CURRENT_DATE),
       (4, 1, 'Eggs', 300, 'Huevos de gallina de campo 12u.', 'FS', CURRENT_TIMESTAMP);

-- Insert into warehouse
INSERT INTO warehouse (id_warehouse, id_user, name, location)
VALUES (1, 3, 'Deposito Principal', 'Avenida Santa Fe 8923'),
       (2, 3, 'Deposito Sin Uso', 'Avenida Santa Fe 8923');

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

-- Insertar Almacenes (Warehouse)
INSERT INTO warehouse (id_warehouse, id_user, name, location)
VALUES (100, 3, 'Main Warehouse', 'New York'),
       (101, 3, 'Secondary Warehouse', 'Los Angeles');

-- Insertar Sectores (Sector)
INSERT INTO sector (id_sector, id_warehouse, name, type, temperature)
VALUES (100, 100, 'Cold Storage', 'FS', 5.00),
       (101, 101, 'Dry Storage', 'RF', 22.00);

-- Insertar Productos (Product)
INSERT INTO product (id_product, id_seller, price, name, description, type, creation_date)
VALUES (100, 1, 300, 'Milk', 'Fresh milk', 'FS', '2022-01-02'),
       (101, 1, 300, 'Apple', 'Apple', 'FS', '2022-01-02');

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
VALUES (100, 2, '2022-01-05', 'PENDING'),
       (101, 2, '2022-01-06', 'SHIPPED');

-- Insertar Detalles de Orden (OrderDetail)
INSERT INTO order_detail (id_detail, id_purchase_order, id_product, quantity, price)
VALUES (100, 100, 100, 10, 300),
       (101, 100, 101, 5, 300),
       (102, 101, 100, 20, 300),
       (103, 101, 101, 10, 300);
