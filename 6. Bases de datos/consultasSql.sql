create table client (
	id_client int primary key auto_increment,
    first_name varchar(30),
    last_name varchar(30),
    dni varchar(10),
    birthdate date,
    country varchar(30),
    city varchar(30)
);

create table internet_plan(
	id_plan int primary key auto_increment,
    speed_in_mb int,
    price decimal(2)
);

create table client_internet_plan(
	id_client_internet_plan int primary key auto_increment,
    id_client int not null,
    id_plan int not null,
    discount float,
    price decimal(2),
    start_date date,
    end_date date,
    constraint foreign key fk_id_client (id_client)
    references client (id_client),
    constraint foreign key fk_id_plan (id_plan)
    references internet_plan (id_plan)
);


-- Insertar registros en la tabla de clientes
INSERT INTO client (first_name, last_name, dni, birthdate, country, city) VALUES
('John', 'Doe', '1234567890', '1990-05-15', 'USA', 'New York'),
('Alice', 'Smith', '0987654321', '1985-08-20', 'Canada', 'Toronto'),
('Michael', 'Johnson', '3456789012', '1995-02-10', 'UK', 'London'),
('Emily', 'Brown', '5678901234', '1982-11-30', 'Australia', 'Sydney'),
('Daniel', 'Martinez', '7890123456', '1978-04-25', 'Spain', 'Madrid'),
('Sophia', 'Garcia', '9012345678', '1999-09-05', 'Mexico', 'Mexico City'),
('Emma', 'Kim', '2345678901', '1993-07-12', 'South Korea', 'Seoul'),
('William', 'Lee', '4567890123', '1987-01-08', 'Germany', 'Berlin'),
('Olivia', 'Wang', '6789012345', '1975-06-18', 'China', 'Beijing'),
('James', 'Chen', '8901234567', '1980-12-22', 'Japan', 'Tokyo');

-- Insertar registros en la tabla de planes de internet
INSERT INTO internet_plan (speed_in_mb, price) VALUES
(50, 29.99),
(100, 39.99),
(200, 49.99),
(500, 59.99),
(1000, 79.99);

INSERT INTO client_internet_plan (id_client, id_plan, discount, price, start_date, end_date) VALUES
(1, 1, 0, 29.99, '2024-05-01', '2024-06-01'),
(2, 3, 0.1, 44.99, '2024-05-05', '2024-06-05'),
(3, 2, 0.05, 37.99, '2024-05-10', '2024-06-10'),
(4, 4, 0, 59.99, '2024-05-15', '2024-06-15'),
(5, 5, 0, 79.99, '2024-05-20', '2024-06-20'),
(6, 1, 0.1, 26.99, '2024-05-25', '2024-06-25'),
(7, 2, 0, 49.99, '2024-05-30', '2024-06-30'),
(8, 3, 0.1, 44.99, '2024-06-01', '2024-07-01'),
(9, 4, 0, 59.99, '2024-06-05', '2024-07-05'),
(10, 5, 0.05, 75.99, '2024-06-10', '2024-07-10');

select * from client_internet_plan;

-- Obtener todos los clientes y
-- sus planes de internet correspondientes:
SELECT c.*, p.*
FROM client c
JOIN client_internet_plan cp ON c.id_client = cp.id_client
JOIN internet_plan p ON cp.id_plan = p.id_plan;

-- Obtener todos los clientes y
-- sus planes de internet correspondientes:

SELECT c.*
FROM client c
JOIN client_internet_plan cp ON c.id_client = cp.id_client
JOIN internet_plan p ON cp.id_plan = p.id_plan
WHERE p.speed_in_mb >= 200;

-- Calcular el total gastado por todos 
-- los clientes en planes de internet:

SELECT SUM(cp.price) AS total_gastado
FROM client_internet_plan cp;

-- Encontrar los clientes que viven en España y 
-- sus planes de internet correspondientes:

SELECT c.*, p.*
FROM client c
JOIN client_internet_plan cp ON c.id_client = cp.id_client
JOIN internet_plan p ON cp.id_plan = p.id_plan
WHERE c.country = 'Spain';

-- Mostrar los planes de internet ordenados 
-- por su precio de forma descendente:

SELECT *
FROM internet_plan
ORDER BY price DESC;

-- Calcular el promedio de velocidad de
-- los planes de internet disponibles:

SELECT AVG(speed_in_mb) AS velocidad_promedio
FROM internet_plan;

-- Encontrar el cliente con el nombre más largo:

SELECT *
FROM client
ORDER BY LENGTH(first_name) + LENGTH(last_name) DESC
LIMIT 1;

-- Contar cuántos clientes tienen planes de internet
-- con descuento:

SELECT COUNT(*)
FROM client_internet_plan
WHERE discount > 0;

-- Mostrar los clientes que tienen planes
-- de internet activos en el mes actual:

SELECT c.*, p.*
FROM client c
JOIN client_internet_plan cp ON c.id_client = cp.id_client
JOIN internet_plan p ON cp.id_plan = p.id_plan
WHERE cp.start_date <= CURDATE() AND cp.end_date >= CURDATE();

-- Calcular el total gastado por cada país
-- en planes de internet:

SELECT c.country, SUM(cp.price) AS total_gastado
FROM client c
JOIN client_internet_plan cp ON c.id_client = cp.id_client
GROUP BY c.country;