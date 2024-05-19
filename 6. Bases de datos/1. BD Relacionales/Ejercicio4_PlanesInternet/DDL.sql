CREATE DATABASE empresa_internet;

USE empresa_internet;

CREATE TABLE clientes
(
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    dni VARCHAR(20) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    provincia VARCHAR(100),
    ciudad VARCHAR(100)
);

CREATE TABLE planes
(
    codigo INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    identificacion VARCHAR(250) NOT NULL,
    velocidad_megas INT UNSIGNED NOT NULL,
    precio DECIMAL(10, 2) NOT NULL
);

CREATE TABLE planes_clientes
(
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    descuento DECIMAL(10, 2) NOT NULL,
    total DECIMAL(10, 2) NOT NULL,
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE NOT NULL,
    cod_plan INT UNSIGNED NOT NULL,
    id_cliente INT UNSIGNED NOT NULL,
    FOREIGN KEY (cod_plan) REFERENCES planes (codigo),
    FOREIGN KEY (id_cliente) REFERENCES clientes (id)
);
