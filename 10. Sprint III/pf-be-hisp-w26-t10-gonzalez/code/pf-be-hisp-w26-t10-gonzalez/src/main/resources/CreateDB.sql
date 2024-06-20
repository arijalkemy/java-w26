-- Create User Account Table
CREATE TABLE user_account (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    user_role VARCHAR(50),
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    password VARCHAR(255),
    email VARCHAR(100)
);

-- Create Category Table
CREATE TABLE category (
    category_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100)
);

-- Create Product Table
CREATE TABLE product (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    category_id INT,
    name VARCHAR(255),
    price DOUBLE,
    seller_id INT NOT NULL,
    FOREIGN KEY (category_id) REFERENCES category(category_id),
    FOREIGN KEY (seller_id) REFERENCES user_account(user_id
);

-- Create Warehouse Table
CREATE TABLE warehouse (
    warehouse_id INT AUTO_INCREMENT PRIMARY KEY,
    supervisor_id INT,
    name VARCHAR(255),
    FOREIGN KEY (supervisor_id) REFERENCES user_account(user_id)
);

-- Create Shopping Cart Table
CREATE TABLE shopping_cart (
    shopping_cart_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT UNIQUE	,
    order_date DATE,
    order_state VARCHAR(50),
    total DOUBLE,
	FOREIGN KEY (user_id) REFERENCES user_account(user_id)
);

-- Create Purchase Order Product Table
CREATE TABLE shopping_cart_product (
	shopping_cart_product_id INT AUTO_INCREMENT PRIMARY KEY,
    shopping_cart_id INT,
    product_id INT,
    quantity INT,
    FOREIGN KEY (shopping_cart_id) REFERENCES shopping_cart(shopping_cart_id),
    FOREIGN KEY (product_id) REFERENCES product(product_id)
);

-- Create Sector Table
CREATE TABLE sector (
    sector_id INT AUTO_INCREMENT PRIMARY KEY,
    warehouse_id INT,
    category_id INT,
    name VARCHAR(100),
    description VARCHAR(255),
    FOREIGN KEY (warehouse_id) REFERENCES warehouse(warehouse_id),
    FOREIGN KEY (category_id) REFERENCES category(category_id)
);

-- Create Inbound Order Table
CREATE TABLE inbound_order (
    inbound_id INT AUTO_INCREMENT PRIMARY KEY,
    warehouse_id INT,
    order_number INT,
    FOREIGN KEY (warehouse_id) REFERENCES warehouse(warehouse_id)
);

-- Create Batch Table
CREATE TABLE `batch` (
    batch_id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT,
    sector_id INT,
    inbound_id INT,
    batch_number INT,
    current_temperature DOUBLE,
    minimum_temperature DOUBLE,
    initial_quantity INT,
    current_quantity INT,
    manufacturing_date DATE,
    manufacturing_time TIME,
    due_date DATE,
    FOREIGN KEY (product_id) REFERENCES product(product_id),
    FOREIGN KEY (sector_id) REFERENCES sector(sector_id),
    FOREIGN KEY (inbound_id) REFERENCES inbound_order(inbound_id)
);
