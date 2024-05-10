# Planteamiento del problema

Una mueblería necesita la implementación de una base de datos para controlar las ventas que realiza por día, el stock de sus artículos (productos) y la lista de sus clientes que realizan las compras.

# Entidades que se evidencian 

En el problema se puede observar que nos dan 4 entidades fundamentales en el negocio: Productos, Stock, Clientes y Compras. La entidad de compras se podría traducir como las facturas que tiene un cliente en la mueblería.

## Cardinalidad

 1. Un cliente puede tener varias facturas (Compras) pero una factura
    solo puede tener un cliente, en este primer caso vemos una relación
    **uno a muchos**.
 2. Ahora, una factura puede tener muchos productos y un producto puede tener muchas facturas, por lo que, en este caso podemos evidencias una relación  **muchos a muchos** por lo que necesitaremos una tabla intermedia que será llamada **FacturasProductos** que hará la relación entre ambas entidades.
 3. También un producto tiene un stock reservado, y un stock (Cantidad en bodega) igualmente solo tiene un producto, evidenciando una relación **uno a uno** por lo que la clave foránea puede ir en cualquiera de las dos entidades, en este caso la agregaremos en Stock

## Atributos

 1. **Clientes:**
	 - ID
	 - nombre
	 - identificación
	 
2. **Factura:**
	- ID
	- cliente_id (FK)
	- total
	- fecha

3. **FacturasProductos:**
	- ID
	- id_factura (FK)
	- id_producto (FK)

4. **Productos:**
	- ID
	- nombre
	- precio

5. **Stock:**
	- ID
	- cantidad
	- id_producto (FK)