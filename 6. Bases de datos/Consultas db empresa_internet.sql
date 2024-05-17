-- Ejercicio 3.a
CREATE DATABASE IF NOT EXISTS empresa_internet;

USE empresa_internet;

CREATE TABLE cliente (
    id_cliente INT PRIMARY KEY AUTO_INCREMENT,
    dni INT NOT NULL,
    nombre VARCHAR(30) NOT NULL,
    apellido VARCHAR(30) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    provincia VARCHAR(50) NOT NULL,
    ciudad VARCHAR(50) NOT NULL,
    direccion VARCHAR(50) NOT NULL
);

CREATE TABLE plan (
    id_plan INT PRIMARY KEY AUTO_INCREMENT,
    velocidad SMALLINT NOT NULL,
    precio FLOAT NOT NULL,
    descuento FLOAT NOT NULL
);

CREATE TABLE clientexplan (
    id_cliente INT,
    id_plan INT,
    PRIMARY KEY (id_cliente, id_plan),
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente),
    FOREIGN KEY (id_plan) REFERENCES plan(id_plan)
);

