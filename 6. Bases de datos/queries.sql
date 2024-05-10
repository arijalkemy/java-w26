# 1. Traer los planes de un cliente con id = 1

SELECT * FROM plan p WHERE p.id_cliente = 1;

# 2. Traer planes con precio > 30

SELECT * FROM plan p WHERE p.precio > 30;

# 3. Traer promedio de precio de los planes

SELECT AVG(precio) AS 'Precio promedio' FROM plan;

# 4. Traer plan mas caro

SELECT id_plan,velocidad, precio, descuento
FROM plan
WHERE precio = (SELECT MAX(precio) FROM plan);

# 5. Ordenar clientes por orden alfabetico

SELECT * FROM cliente c ORDER BY c.nombre;

# 6. Ordenar clientes por edad

SELECT * FROM cliente c ORDER BY c.fecha_nacimiento ;

# 7. Traer el plan mas rapido

SELECT * FROM plan p ORDER BY p.velocidad DESC;

# 8. Traer el plan que tiene mas descuento

SELECT * FROM plan p ORDER BY p.descuento  DESC;

# 9. Traer los planes en un rango de precio

SELECT * FROM plan p WHERE p.precio BETWEEN 35 AND 40;


# 10. Traer todos los clientes de buenos aires

SELECT * FROM cliente c WHERE c.provincia = 'Buenos Aires';

