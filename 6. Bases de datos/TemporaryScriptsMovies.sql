CREATE TEMPORARY TABLE TWD(
	Id INT, 
    Nombre_Capitulo Varchar(50),
    Temporada INT, 
    Duracion INT
);

INSERT INTO TWD (Id, Nombre_Capitulo, Temporada, Duracion) VALUES
(1, 'Days Gone Bye', 1, 67),
(2, 'Guts', 1, 42),
(3, 'Tell It to the Frogs', 1, 45),
(4, 'Vatos', 1, 44),
(5, 'Wildfire', 1, 45),
(6, 'TS-19', 1, 45),
(7, 'What Lies Ahead', 2, 63),
(8, 'Bloodletting', 2, 42),
(9, 'Save the Last One', 2, 43),
(10, 'Cherokee Rose', 2, 42);

SELECT Nombre_Capitulo, Temporada 
FROM TWD
WHERE Temporada = 1;