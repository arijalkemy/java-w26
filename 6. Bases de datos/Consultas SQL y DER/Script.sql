CREATE DATABASE empresa_internet;

USE empresa_internet;

CREATE TABLE client (
	client_id INTEGER NOT NULL,
	dni INTEGER NOT NULL,
	first_name TEXT(20) NOT NULL,
	last_name TEXT(20) NOT NULL,
	birth TEXT(10) DEFAULT (2000-00-00) NOT NULL,
	province TEXT(20) NOT NULL,
	city TEXT(25) NOT NULL,
	CONSTRAINT client_pk PRIMARY KEY (client_id)
)

CREATE TABLE plan (
	plan_id INTEGER NOT NULL,
	client_id INTEGER NOT NULL,
	velocity INTEGER NOT NULL,
	price INTEGER NOT NULL,
	discount INTEGER DEFAULT (0) NOT NULL,
	CONSTRAINT plan_pk PRIMARY KEY (plan_id),
	CONSTRAINT plan_client_FK FOREIGN KEY (client_id) REFERENCES client(client_id)
)

INSERT INTO client (client_id, dni, first_name, last_name, birth, province, city)
VALUES
(1, 123, "Luis", "Meza", "1999-11-12", "Milpa", "CDMX")

INSERT INTO client (client_id, dni, first_name, last_name, birth, province, city)
VALUES
(2, 1234567, 'Juan', 'González', '1990-05-10', 'Madrid', 'Madrid'),
(3, 2345678, 'María', 'Martínez', '1985-08-15', 'Barcelona', 'Barcelona'),
(4, 3456789, 'José', 'López', '1982-12-20', 'Sevilla', 'Sevilla'),
(5, 4567890, 'Ana', 'Sánchez', '1993-04-25', 'Valencia', 'Valencia'),
(6, 5678901, 'Carlos', 'Fernández', '1978-07-30', 'Málaga', 'Málaga'),
(7, 6789012, 'Laura', 'García', '1996-11-05', 'Alicante', 'Alicante'),
(8, 7890123, 'David', 'Rodríguez', '1989-02-15', 'Murcia', 'Murcia'),
(9, 8901234, 'Sara', 'Pérez', '1984-06-20', 'Bilbao', 'Vizcaya'),
(10, 9012345, 'Pablo', 'Fernández', '1991-09-10', 'Zaragoza', 'Zaragoza');

SELECT * FROM plan ;

INSERT INTO plan  (plan_id, client_id, velocity, price, discount)
VALUES
(1, 1, 50, 30, 5),
(2, 2, 100, 45, 10),
(3, 2, 200, 60, 15),
(4, 3, 300, 75, 20),
(5, 1, 500, 90, 25);

--

SELECT plan_id  FROM plan WHERE client_id = 1;
