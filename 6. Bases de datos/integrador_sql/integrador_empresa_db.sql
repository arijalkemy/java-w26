-- Se solicita crear una nueva base de datos llamada “empresa_internet”.
CREATE DATABASE empresa_internet;

USE empresa_internet;

CREATE TABLE cliente(
	id_cliente INT AUTO_INCREMENT NOT NULL,
    nombre VARCHAR(45) NOT NULL,
    apellido VARCHAR(45) NOT NULL,
    direccion VARCHAR(100) NOT NULL,
    dni VARCHAR(20) NOT NULL,
	email VARCHAR(150) NOT NULL,
    telefono VARCHAR(100) NOT NULL,
    CONSTRAINT pk_id_cliente PRIMARY KEY(id_cliente)
);

CREATE TABLE plan(
	id_plan INT AUTO_INCREMENT NOT NULL,
    velocidad DECIMAL(10, 2) NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
    CONSTRAINT pk_id_plan PRIMARY KEY(id_plan)
);

CREATE TABLE plan_contratado(
	id_contrato INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    id_plan INT NOT NULL,
    id_cliente INT NOT NULL,
	CONSTRAINT fk_id_plan FOREIGN KEY (id_plan) REFERENCES plan(id_plan),
    CONSTRAINT fk_id_cliente FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente),
    CONSTRAINT pk_id_contrato UNIQUE(id_plan, id_cliente)
)

