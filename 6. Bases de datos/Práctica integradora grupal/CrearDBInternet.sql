-- Crear la base de datos
CREATE DATABASE empresa_internet;

-- Usar la base de datos creada
USE empresa_internet;

-- Crear la tabla de clientes
CREATE TABLE IF NOT EXISTS clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    dni VARCHAR(20) UNIQUE,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    fecha_nacimiento DATE,
    provincia VARCHAR(50),
    ciudad VARCHAR(50),
    id_plan INT
);

-- Crear la tabla de planes de internet
CREATE TABLE planes_internet (
    id_plan INT PRIMARY KEY,
    velocidad_megas INT,
    precio DECIMAL(10, 2),
    descuento DECIMAL(5, 2)
);
