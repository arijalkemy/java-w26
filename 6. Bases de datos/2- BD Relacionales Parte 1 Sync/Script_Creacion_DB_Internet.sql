CREATE TABLE cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    dni VARCHAR(20),
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    fecha_nacimiento DATE,
    provincia VARCHAR(50),
    ciudad VARCHAR(50)
);
CREATE TABLE plan (
    id INT AUTO_INCREMENT PRIMARY KEY,
    identificacion_plan VARCHAR(50),
    velocidad_ofrecida_megas INT,
    precio DECIMAL(10, 2),
    descuento DECIMAL(5, 2)
);


ALTER TABLE cliente
ADD FOREIGN KEY (plan_id) REFERENCES plan(id);