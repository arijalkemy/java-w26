select * from Cliente;

select nombre, apellido from Cliente where idPlan=4;

select nombre, apellido, idPlan as plan from Cliente where provincia like 'Buenos Aires';

select nombre, apellido, provincia from Cliente where apellido like 'Pérez';

select dni, nombre, apellido from Cliente where idplan >2 and year(fechaNacimiento) between 1985 and 1995;

select idPlan as Plan, velocidad, precio from Planes where velocidad>200;

select nombre, apellido, idPlan as Plan from Cliente order by idPlan;

select dni, nombre, year(fechaNacimiento), idPlan as Plan from Cliente order by fechaNacimiento asc;

select nombre, apellido, provincia, ciudad from Cliente where provincia not like 'Mendoza';

select nombre, ciudad, idPlan as Plan from Cliente where year(fechaNacimiento)>1986 and provincia like 'Mendoza';