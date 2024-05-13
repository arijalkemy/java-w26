-- MySQL dump 10.13  Distrib 8.0.36, for macos14 (arm64)
--
-- Host: localhost    Database: empresa_internet
-- ------------------------------------------------------
-- Server version	8.3.0

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
-- Table structure for table `CLIENTES`
--

DROP TABLE IF EXISTS `CLIENTES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CLIENTES` (
  `id_cliente` int NOT NULL AUTO_INCREMENT,
  `dni` varchar(20) DEFAULT NULL,
  `provincia` varchar(100) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `fecha_nacimiento` datetime DEFAULT NULL,
  `apellido` varchar(100) DEFAULT NULL,
  `ciudad` varchar(100) DEFAULT NULL,
  `id_plan` int DEFAULT NULL,
  PRIMARY KEY (`id_cliente`),
  KEY `id_plan` (`id_plan`),
  CONSTRAINT `clientes_ibfk_1` FOREIGN KEY (`id_plan`) REFERENCES `PLANES` (`id_plan`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CLIENTES`
--

LOCK TABLES `CLIENTES` WRITE;
/*!40000 ALTER TABLE `CLIENTES` DISABLE KEYS */;
INSERT INTO `CLIENTES` VALUES (11,'12345678A','Provincia A','Juan','1980-01-01 00:00:00','Pérez','Ciudad A',1),(12,'23456789B','Provincia B','María','1985-02-02 00:00:00','García','Ciudad B',2),(13,'34567890C','Provincia C','Luis','1990-03-03 00:00:00','López','Ciudad C',3),(14,'45678901D','Provincia D','Ana','1995-04-04 00:00:00','Martínez','Ciudad D',4),(15,'56789012E','Provincia E','Pedro','2000-05-05 00:00:00','Sánchez','Ciudad E',5),(16,'67890123F','Provincia F','Laura','1975-06-06 00:00:00','Fernández','Ciudad F',1),(17,'78901234G','Provincia G','Carlos','1988-07-07 00:00:00','Rodríguez','Ciudad G',2),(18,'89012345H','Provincia H','Sofía','1992-08-08 00:00:00','Gómez','Ciudad H',3),(19,'90123456I','Provincia I','Marta','1983-09-09 00:00:00','Díaz','Ciudad I',4),(20,'01234567J','Provincia J','Miguel','1979-10-10 00:00:00','Torres','Ciudad J',5);
/*!40000 ALTER TABLE `CLIENTES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PLANES`
--

DROP TABLE IF EXISTS `PLANES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PLANES` (
  `id_plan` int NOT NULL AUTO_INCREMENT,
  `velocidad_mb` int DEFAULT NULL,
  `precio` float DEFAULT NULL,
  `descuento` float DEFAULT NULL,
  PRIMARY KEY (`id_plan`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PLANES`
--

LOCK TABLES `PLANES` WRITE;
/*!40000 ALTER TABLE `PLANES` DISABLE KEYS */;
INSERT INTO `PLANES` VALUES (1,10,29.99,5),(2,50,49.99,10),(3,100,69.99,15),(4,200,89.99,20),(5,500,109.99,25);
/*!40000 ALTER TABLE `PLANES` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-13 16:57:35
