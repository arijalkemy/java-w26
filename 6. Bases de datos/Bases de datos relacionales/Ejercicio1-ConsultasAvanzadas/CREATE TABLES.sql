CREATE Table Empleado(
	cod_emp VARCHAR(10) PRIMARY KEY,
	nombre VARCHAR(200),
	apellido VARCHAR(200),
	puesto VARCHAR(200),
	fecha_alta DATETIME,
	salario DECIMAL(14,2),
	comision DECIMAL(14,2),
	depto_nro VARCHAR(10)
)

CREATE Table Departamento(
	depto_nro VARCHAR(10) PRIMARY KEY,
	nombre_depto VARCHAR(200),
	localidad VARCHAR(200)
)
