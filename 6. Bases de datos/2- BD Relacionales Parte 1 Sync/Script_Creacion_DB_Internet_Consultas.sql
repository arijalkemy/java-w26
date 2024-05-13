
INSERT INTO plan VALUES(1, "EXTRA 300 MB", 300, 3500.50, 0.1);

INSERT INTO plan VALUES(2, "EXTRA 1GB", 1, 7500.50, 0.5);

INSERT INTO plan VALUES(3, "INCIAL 20MB", 20, 1500.50, 0.5);

INSERT INTO cliente VALUES(1, 1, "42722378", "Martin", "Ramirez", '2000-02-20', "Buenos Aires", "CABA");

INSERT INTO cliente VALUES(2, 2, "32443453", "Ady", "Junior", '1990-05-01', "Buenos Aires", "CABA");

SELECT nombre, apellido FROM cliente WHERE nombre = "Martin"

SELECT descuento FROM plan WHERE descuento > 0.3;

SELECT nombre, apellido FROM cliente order by nombre DESC;






