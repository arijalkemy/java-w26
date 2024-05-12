-- Se crea la BD
CREATE DATABASE empresa_internet
use empresa_internet

-- se crea la tabla Cliente con sus atributos y su llave primaria
CREATE TABLE empresa_internet.Cliente (
	id_cliente INT NOT NULL,
	dni varchar(20) NOT NULL,
	nombre varchar(15) NOT NULL,
	apellido varchar(15) NOT NULL,
	fecha_nacimiento DATETIME NOT NULL,
	provincia varchar(20) NOT NULL,
	ciudad varchar(20) NOT NULL,
	direccion varchar(30) NOT NULL,
	CONSTRAINT Cliente_PK PRIMARY KEY (id_cliente)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

-- se crea la tabla Estado con sus atributos y su llave primaria
CREATE TABLE empresa_internet.Estado(
	id_estado INT NOT NULL,
	nombre VARCHAR(15) NOT NULL,
	descripcion VARCHAR(255) NOT NULL,
	CONSTRAINT Estado_PK PRIMARY KEY (id_estado)
)
ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- se crea la tabla Plan con sus atributos y su llave primaria
CREATE TABLE empresa_internet.Plan(
	id_plan VARCHAR(4) NOT NULL,
	nombre VARCHAR(15) NOT NULL,
	descripcion VARCHAR(255) NOT NULL,
	velocidad INT NOT NULL,
	precio DOUBLE NOT NULL,
	CONSTRAINT Plan_id PRIMARY KEY (id_plan)
)
ENGINE = InnoDB
DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- se crea la tabla Detalle_Plan con sus atributos y llaves (primarias y foraneas)
CREATE TABLE empresa_internet.Detalle_Plan (
	id_detalle_plan INT auto_increment NOT NULL,
	id_plan varchar(4) NOT NULL,
	id_estado INT NOT NULL,
	id_cliente INT NOT NULL,
	fecha_inicio DATETIME NOT NULL,
	fecha_corte DATETIME NOT NULL,
	fecha_fin DATETIME NULL,
	descuento FLOAT NOT NULL,
	CONSTRAINT Detalle_Plan_PK PRIMARY KEY (id_detalle_plan),
	CONSTRAINT Detalle_Plan_Cliente_FK FOREIGN KEY (id_cliente) REFERENCES empresa_internet.Cliente(id_cliente),
	CONSTRAINT Detalle_Plan_Estado_FK FOREIGN KEY (id_estado) REFERENCES empresa_internet.Estado(id_estado),
	CONSTRAINT Detalle_Plan_Plan_FK FOREIGN KEY (id_plan) REFERENCES empresa_internet.Plan(id_plan)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;
