-- Consultar todos los clientes con plan de 250 GB
select c.* 
from Clientes c
inner join PlanesInternet pi on pi.plan_id = c.plan_id
where pi.velocidad = 250;

-- Consultar todos los clientes de Cordoba
select *
from Clientes 
where provincia like 'Cordoba';

-- Consutar todos los planes que tengan descuento mayor al 15%
select *
from PlanesInternet
where descuento > 15;

-- Aumentar el precio un 10% a los planes cuya velocidad es de 10, 25 y 50 GB
update PlanesInternet
set precio = precio * 1.1
where velocidad in (10, 25, 50);

-- Consultar los nombres y apellido de todos los clientes cuyo apellido termine en 'EZ'
select nombre, apellido
from Clientes
where apellido like '%ez';

-- Actualizar la ciudad del cliente con dni 12345678 a 'Chascomus'
update Clientes
set ciudad = 'Chascomus'
where dni like '12345678';

-- Obtener el nombre, apellido, nacimiento y velocidad de internet de las personas nacidas antes de 1985
select c.nombre, c.apellido, c.fecha_nacimiento, pi.velocidad
from Clientes c 
inner join PlanesInternet pi on pi.plan_id = c.plan_id
where c.fecha_nacimiento < '1985-01-01';

-- Obtener todos los datos del Cliente Diego Garcia
select *
from Clientes c
inner join PlanesInternet pi on pi.plan_id = c.plan_id
where c.nombre like 'Diego'
and c.apellido like 'Garcia';

-- Consultar todos los planes de internet ordenados decrecientemente por precio
select *
from PlanesInternet
order by precio desc;

-- Consultar cuanto recauda la empresa por cada plan 
select pi.plan_id, sum(pi.precio * (1 - (pi.descuento/100))) as recaudacion
from Clientes c
inner join PlanesInternet pi on pi.plan_id = c.plan_id
group by pi.plan_id;
