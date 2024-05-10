create database ventas;

use ventas;

CREATE TABLE Ventas (
    ID_Venta INT PRIMARY KEY AUTO_INCREMENT,
    FechaVenta DATE NOT NULL,
    MontoTotal DECIMAL(10, 2) NOT NULL,
    ID_Cliente INT,
    FOREIGN KEY (ID_Cliente) REFERENCES Clientes(ID_Cliente)
);

CREATE TABLE Articulos (
    ID_Articulo INT PRIMARY KEY AUTO_INCREMENT,
    NombreArticulo VARCHAR(255) NOT NULL,
    Descripcion TEXT,
    Precio DECIMAL(10, 2) NOT NULL,
    CantidadStock INT NOT NULL
);

CREATE TABLE Clientes (
    ID_Cliente INT PRIMARY KEY AUTO_INCREMENT,
    NombreCliente VARCHAR(255) NOT NULL,
    Direccion VARCHAR(255),
    Telefono VARCHAR(20),
    CorreoElectronico VARCHAR(255)
);

CREATE TABLE DetallesVenta (
    ID_Venta INT,
    ID_Articulo INT,
    CantidadVendida INT NOT NULL,
    PRIMARY KEY (ID_Venta, ID_Articulo),
    FOREIGN KEY (ID_Venta) REFERENCES Ventas(ID_Venta),
    FOREIGN KEY (ID_Articulo) REFERENCES Articulos(ID_Articulo)
);
