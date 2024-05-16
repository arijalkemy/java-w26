-- Active: 1715349678349@@127.0.0.1@3306@empresa_internet
create table Cliente (
    id_cliente int(11) NOT NULL AUTO_INCREMENT,
    dni int(15) NOT NULL,
    nombre varchar(45) NOT NULL,
    apellido varchar(45) NOT NULL,
    fecha_nacimiento date NOT NULL,
    provincia varchar(45) NOT NULL,
    ciudad varchar(45) NOT NULL,
    id_plan int(11) NOT NULL,
    PRIMARY KEY (id_cliente),
    Foreign Key (id_plan) REFERENCES plan_internet(id_plan)
)


create table plan_internet
(
    id_plan int(11) NOT NULL AUTO_INCREMENT,
    velocidad_megas INTEGER(45) NOT NULL,
    precio decimal(10,2) NOT NULL,
    descuento DOUBLE(10,2),
    PRIMARY KEY (id_plan)
)


-- Insert 5 planes
INSERT INTO plan_internet (velocidad_megas, precio, descuento)
VALUES 
    (100, 50.00, 0.00),
    (200, 75.00, 0.10),
    (300, 100.00, 0.15),
    (400, 125.00, 0.20),
    (500, 150.00, 0.25);


    -- Insert 10 clientes
    INSERT INTO Cliente (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, id_plan)
    VALUES 
        (123456789, 'John', 'Doe', '1990-01-01', 'California', 'Los Angeles', 1),
        (987654321, 'Jane', 'Smith', '1995-02-15', 'New York', 'New York City', 2),
        (456789123, 'Michael', 'Johnson', '1985-05-10', 'Texas', 'Houston', 3),
        (789123456, 'Emily', 'Williams', '1992-09-20', 'Florida', 'Miami', 4),
        (321654987, 'David', 'Brown', '1988-03-05', 'Illinois', 'Chicago', 5),
        (654987321, 'Sarah', 'Davis', '1998-07-12', 'Arizona', 'Phoenix', 1),
        (987321654, 'Daniel', 'Miller', '1993-11-25', 'Colorado', 'Denver', 2),
        (741852963, 'Olivia', 'Wilson', '1991-04-30', 'Washington', 'Seattle', 3),
        (369258147, 'James', 'Anderson', '1987-08-15', 'Massachusetts', 'Boston', 4),
        (852963741, 'Sophia', 'Taylor', '1996-12-10', 'Nevada', 'Las Vegas', 5);


#Consultas

-- 1. Obtener clientes por plan

select nombre,apellido from `Cliente` where id_plan = 1;

-- 
SELECT COUNT() FROM `Cliente` WHERE id_cliente = 3;

-- 3. Calcular promedio de precios}
SELECT AVG(precio) AS promedio_precios FROM plan_internet;

-- 4. Obtener clientes con descuento
SELECT * FROM `Cliente` WHERE descuento > 0;

-- 5. Obtener clientes por provincia
SELECT * FROM `Cliente` WHERE provincia = 'California';

-- 6. Obtener clientes por ciudad
SELECT * FROM `Cliente` WHERE ciudad = 'Los Angeles';

-- 7. Obtener clientes por rango de fechas de nacimiento

SELECT * FROM `Cliente` WHERE fecha_nacimiento BETWEEN '1990-01-01' AND '1995-02-15';

-- 8. Obtener clientes por rango de precios
SELECT * FROM `Cliente` WHERE precio BETWEEN 50.00 AND 100.00;

-- 9. Obtener clientes por rango de velocidades
SELECT * FROM `Cliente` WHERE velocidad_megas BETWEEN 100 AND 300;

-- 10. Obtener clientes por rango de descuentos
SELECT * FROM `Cliente` WHERE descuento BETWEEN 0.10 AND 0.20;



