CREATE DATABASE IF NOT EXISTS empresa_internet;

create table
    Plan (
        id_plan INT NOT NULL AUTO_INCREMENT,
        velocidad_megas INT NOT NULL,
        precio DOUBLE (10, 2) NOT NULL,
        descuento DOUBLE (10, 2),
        PRIMARY KEY (id_plan)
    );

create table
    Cliente (
        id_cliente INT NOT NULL AUTO_INCREMENT,
        dni INT NOT NULL,
        nombre varchar(45) NOT NULL,
        apellido varchar(45) NOT NULL,
        fecha_nacimiento date NOT NULL,
        provincia varchar(45) NOT NULL,
        ciudad varchar(45) NOT NULL,
        id_plan INT NOT NULL,
        PRIMARY KEY (id_cliente),
        Foreign Key (id_plan) REFERENCES Plan (id_plan)
    );

-- Insertar 5 planes
INSERT INTO
    Plan (velocidad_megas, precio, descuento)
VALUES
    (100, 50.00, 0.00),
    (200, 75.00, 0.10),
    (300, 100.00, 0.15),
    (400, 125.00, 0.20),
    (500, 150.00, 0.25);

-- Insertar 10 clientes
INSERT INTO
    Cliente (
        dni,
        nombre,
        apellido,
        fecha_nacimiento,
        provincia,
        ciudad,
        id_plan
    )
VALUES
    (
        123456789,
        'John',
        'Doe',
        '1990-01-01',
        'California',
        'Los Angeles',
        1
    ),
    (
        987654321,
        'Jane',
        'Smith',
        '1995-02-15',
        'New York',
        'New York City',
        2
    ),
    (
        456789123,
        'Michael',
        'Johnson',
        '1985-05-10',
        'Texas',
        'Houston',
        3
    ),
    (
        789123456,
        'Emily',
        'Williams',
        '1992-09-20',
        'Florida',
        'Miami',
        4
    ),
    (
        321654987,
        'David',
        'Brown',
        '1988-03-05',
        'Illinois',
        'Chicago',
        5
    ),
    (
        654987321,
        'Sarah',
        'Davis',
        '1998-07-12',
        'Arizona',
        'Phoenix',
        1
    ),
    (
        987321654,
        'Daniel',
        'Miller',
        '1993-11-25',
        'Colorado',
        'Denver',
        2
    ),
    (
        741852963,
        'Olivia',
        'Wilson',
        '1991-04-30',
        'Washington',
        'Seattle',
        3
    ),
    (
        369258147,
        'James',
        'Anderson',
        '1987-08-15',
        'Massachusetts',
        'Boston',
        4
    ),
    (
        852963741,
        'Sophia',
        'Taylor',
        '1996-12-10',
        'Nevada',
        'Las Vegas',
        5
    );