-- MySQL dump 10.13  Distrib 8.0.33, for macos13 (arm64)
--
-- Host: localhost    Database: empresa_internet
-- ------------------------------------------------------
-- Server version	8.4.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Clientes`
--

DROP TABLE IF EXISTS `Clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Clientes` (
  `cliente_id` int NOT NULL,
  `dni` varchar(20) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `fecha_nacimiento` datetime DEFAULT NULL,
  `provincia` varchar(45) DEFAULT NULL,
  `ciudad` varchar(45) DEFAULT NULL,
  `plan_id` int DEFAULT NULL,
  PRIMARY KEY (`cliente_id`),
  KEY `fk_cliente_planInternet_idx` (`plan_id`),
  CONSTRAINT `fk_cliente_planInternet` FOREIGN KEY (`plan_id`) REFERENCES `PlanesInternet` (`plan_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Clientes`
--

LOCK TABLES `Clientes` WRITE;
/*!40000 ALTER TABLE `Clientes` DISABLE KEYS */;
INSERT INTO `Clientes` VALUES (1,'12345678','Juan','Gómez','1980-05-15 00:00:00','Buenos Aires','Chascomus',1),(2,'23456789','María','Pérez','1990-09-20 00:00:00','Santa Fe','Rosario',2),(3,'34567890','Lucía','López','1985-03-10 00:00:00','Córdoba','Villa María',3),(4,'45678901','Pedro','Martínez','2000-11-25 00:00:00','Mendoza','Mendoza',4),(5,'56789012','Ana','Fernández','1982-07-08 00:00:00','Tucumán','San Miguel de Tucumán',5),(6,'67890123','Diego','García','1975-12-30 00:00:00','Salta','Salta',1),(7,'78901234','Laura','Rodríguez','1993-02-18 00:00:00','Entre Ríos','Paraná',2),(8,'89012345','Marcela','González','1988-06-05 00:00:00','Chaco','Resistencia',3),(9,'90123456','Gustavo','Díaz','1997-09-03 00:00:00','San Juan','San Juan',4),(10,'01234567','Carolina','Sánchez','1980-04-12 00:00:00','Misiones','Posadas',5);
/*!40000 ALTER TABLE `Clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PlanesInternet`
--

DROP TABLE IF EXISTS `PlanesInternet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PlanesInternet` (
  `plan_id` int NOT NULL,
  `velocidad` int DEFAULT NULL,
  `precio` int DEFAULT NULL,
  `descuento` int DEFAULT NULL,
  PRIMARY KEY (`plan_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PlanesInternet`
--

LOCK TABLES `PlanesInternet` WRITE;
/*!40000 ALTER TABLE `PlanesInternet` DISABLE KEYS */;
INSERT INTO `PlanesInternet` VALUES (1,10,110,5),(2,25,275,10),(3,50,550,15),(4,100,1000,20),(5,250,2500,25);
/*!40000 ALTER TABLE `PlanesInternet` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-15 12:12:29
