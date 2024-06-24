INSERT INTO Users (name, role, username, hashed_password) VALUES
('Alice', 'SUPERVISOR', 'alice', '$2a$10$Ensyjesz9McAic6jcrkw/eNXhiyIoY.TM1rr.jEs1lVorraF07ACu'), -- 12345
('Bob', 'BUYER', 'bob', '$2a$10$Ensyjesz9McAic6jcrkw/eNXhiyIoY.TM1rr.jEs1lVorraF07ACu'), -- 12345
('Charlie', 'SUPERVISOR', 'charlie', '$2a$10$Ensyjesz9McAic6jcrkw/eNXhiyIoY.TM1rr.jEs1lVorraF07ACu'), -- 12345
('Diana', 'BUYER', 'diana', '$2a$10$Ensyjesz9McAic6jcrkw/eNXhiyIoY.TM1rr.jEs1lVorraF07ACu'), -- 12345
('Eve', 'BUYER', 'eve', '$2a$10$Ensyjesz9McAic6jcrkw/eNXhiyIoY.TM1rr.jEs1lVorraF07ACu'); -- 12345

INSERT INTO Warehouses (supervisor_id) VALUES
(1),
(3);

INSERT INTO Sectors (remaining_capacity, type, warehouse_code) VALUES
   (5000, 'FS', 1),
   (3000, 'RF', 1),
   (2000, 'FF', 1),
   (6000, 'FS', 2),
   (3500, 'RF', 2),
   (2500, 'FF', 2);


INSERT INTO Products (name, type, unit_price) VALUES
  ('Apple', 'FS', 0.50),
  ('Orange', 'FS', 0.60),
  ('Banana', 'FS', 0.40),
  ('Strawberry', 'FS', 1.20),
  ('Blueberry', 'FS', 2.50),
  ('Lettuce', 'FS', 1.00),
  ('Tomato', 'FS', 0.70),
  ('Cucumber', 'FS', 0.90),
  ('Carrot', 'FS', 0.45),
  ('Broccoli', 'FS', 1.30),
  ('Milk', 'RF', 1.50),
  ('Cheese', 'RF', 2.00),
  ('Yogurt', 'RF', 1.00),
  ('Butter', 'RF', 2.50),
  ('Cream', 'RF', 1.75),
  ('Ham', 'RF', 3.00),
  ('Bacon', 'RF', 2.80),
  ('Sausage', 'RF', 3.20),
  ('Eggs', 'RF', 1.20),
  ('Fish', 'RF', 4.50),
  ('Ice Cream', 'FF', 3.00),
  ('Frozen Pizza', 'FF', 4.00),
  ('Frozen Vegetables', 'FF', 2.50),
  ('Frozen Berries', 'FF', 3.50),
  ('Frozen Meat', 'FF', 5.00),
  ('Frozen Fish', 'FF', 4.80),
  ('Frozen Dessert', 'FF', 3.20),
  ('Frozen Pasta', 'FF', 3.80),
  ('Frozen Dumplings', 'FF', 4.00),
  ('Frozen Fries', 'FF', 2.80);