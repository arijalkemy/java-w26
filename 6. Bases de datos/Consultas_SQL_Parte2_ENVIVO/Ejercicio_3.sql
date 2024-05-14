/*Crreacion de la bd*/
CREATE DATABASE `plan_internet_db` 
/*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ 
/*!80016 DEFAULT ENCRYPTION='N' */;
CREATE TABLE `Cliente` (
  `id_cliente` int NOT NULL AUTO_INCREMENT,
  `dni` varchar(100) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `provincia` varchar(100) NOT NULL,
  `ciudad` varchar(100) NOT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `Plan` (
  `id_plan` int NOT NULL AUTO_INCREMENT,
  `velocidad` int NOT NULL,
  `precio` float NOT NULL,
  `descuento` float DEFAULT NULL,
  PRIMARY KEY (`id_plan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `ClientePlan` (
  `id_cliente` int NOT NULL,
  `id_plan` int NOT NULL,
  KEY `ClientePlan_Cliente_FK` (`id_cliente`),
  KEY `ClientePlan_Plan_FK` (`id_plan`),
  /*Relaciones*/
  CONSTRAINT `ClientePlan_Cliente_FK` FOREIGN KEY (`id_cliente`) REFERENCES `Cliente` (`id_cliente`),
  CONSTRAINT `ClientePlan_Plan_FK` FOREIGN KEY (`id_plan`) REFERENCES `Plan` (`id_plan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Inserciones personas*/
INSERT INTO Cliente VALUES (null, "A2121", "Laura", "Diaz", "2010-10-2", "Cundinamarca","Soacha");
INSERT INTO Cliente VALUES (null, "A21221", "David", "Duque", "2010-10-12", "Choco","Chia");
INSERT INTO Cliente VALUES (null, "A21321", "Andres", "Uribe", "2011-09-01", "Meta","Chia");
INSERT INTO Cliente VALUES (null, "A21421", "Ramiro", "Murcia", "2009-06-3", "Guaviare","Chia");
INSERT INTO Cliente VALUES (null, "A21521", "Kevin", "Mendez", "2008-05-4", "Cundinamarca","Chia");
INSERT INTO Cliente VALUES (null, "A21621", "Xamir", "Bello", "2007-07-5", "Bogota","Bogota");
INSERT INTO Cliente VALUES (null, "A21721", "Maxi", "Messi", "2006-08-6", "Amazonaas","Leticia");
INSERT INTO Cliente VALUES (null, "A21281", "Lionel", "Arias", "2005-09-7", "Casanare","Paz de Ariporo");
INSERT INTO Cliente VALUES (null, "A21921", "James", "Rodriguez", "2004-10-8", "Boyaca","Tunja");
INSERT INTO Cliente VALUES (null, "A21221", "Laura", "Lopez", "2004-11-9", "Guajira","Barracas");
/*Inserciones planes*/
INSERT INTO Plan VALUES(null, 100, 25.000, 12.5);
INSERT INTO Plan VALUES(null, 110, 35.000, 8);
INSERT INTO Plan VALUES(null, 120, 45.000, 9.5);
INSERT INTO Plan VALUES(null, 130, 55.000, 10.5);
INSERT INTO Plan VALUES(null, 150, 65.000, 11.5);
/*Inserciones de ClientePLan*/
INSERT INTO ClientePlan Values (2, 1);
INSERT INTO ClientePlan Values (3, 4);
INSERT INTO ClientePlan Values (4, 2);
INSERT INTO ClientePlan Values (5, 6);
INSERT INTO ClientePlan Values (6, 6);
