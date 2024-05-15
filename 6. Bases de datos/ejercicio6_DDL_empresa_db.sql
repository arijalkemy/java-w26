CREATE SCHEMA IF NOT EXISTS empleado_db;

USE empleado_db;

CREATE TABLE
    IF NOT EXISTS departamento (
        depto_nro VARCHAR(10) NOT NULL PRIMARY KEY,
        nombre_depto VARCHAR(50),
        localidad VARCHAR(50)
    );

CREATE TABLE
    IF NOT EXISTS empleado (
        cod_emp VARCHAR(10) NOT NULL PRIMARY KEY,
        nombre VARCHAR(50),
        apellido VARCHAR(50),
        puesto VARCHAR(50),
        fecha_alta DATE,
        salario INT,
        comision INT,
        depto_nro VARCHAR(10),
        FOREIGN KEY (depto_nro) REFERENCES departamento (depto_nro) ON UPDATE CASCADE ON DELETE CASCADE
    );

INSERT INTO
    departamento
VALUES
    ("D-000-1", "Software", "Los Tigres"),
    ("D-000-2", "Sistemas", "Guadaplupe"),
    ("D-000-3", "Contabilidad", "La Roca"),
    ("D-000-4", "Ventas", "Plata");

INSERT INTO
    empleado 
VALUES
    (
        "E-0001",
        "Cesar",
        "Piñero",
        "Vendedor",
        "2018-05-12",
        80000,
        15000,
        "D-000-4"
    ),
    (
        "E-0002",
        "Yosep",
        "Kowaleski",
        "Analista",
        "2015-07-14",
        140000,
        0,
        "D-000-2"
    ),
    (
        "E-0003",
        "Mariela",
        "Barrios",
        "Director",
        "2014-06-05",
        185000,
        0,
        "D-000-3"
    ),
    (
        "E-0004",
        "Jonathan",
        "Aguilera",
        "Vendedor",
        "2015-06-04",
        85000,
        10000,
        "D-000-4"
    ),
    (
        "E-0005",
        "Daniel",
        "Brezezicki",
        "Vendedor",
        "2018-03-03",
        83000,
        10000,
        "D-000-4"
    ),
    (
        "E-0006",
        "Mito",
        "Barchuk",
        "Presidente",
        "2014-06-05",
        190000,
        0,
        "D-000-3"
    ),
    (
        "E-0007",
        "Emilio",
        "Galarza",
        "Desarrollador",
        "2014-08-02",
        60000,
        0,
        "D-000-1"
    );