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
-- Table structure for table `Cliente`
--

DROP TABLE IF EXISTS `Cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Cliente` (
  `idCliente` int NOT NULL AUTO_INCREMENT,
  `dni` int NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `fechaNacimiento` datetime NOT NULL,
  `provincia` varchar(45) NOT NULL,
  `ciudad` varchar(45) NOT NULL,
  `idPlan` int NOT NULL,
  PRIMARY KEY (`idCliente`,`idPlan`),
  UNIQUE KEY `idCliente_UNIQUE` (`idCliente`),
  KEY `fk_Cliente_Planes_idx` (`idPlan`),
  CONSTRAINT `fk_Cliente_Planes` FOREIGN KEY (`idPlan`) REFERENCES `Planes` (`idPlan`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cliente`
--

LOCK TABLES `Cliente` WRITE;
/*!40000 ALTER TABLE `Cliente` DISABLE KEYS */;
INSERT INTO `Cliente` VALUES (1,12345678,'Juan','Pérez','1985-04-12 00:00:00','Buenos Aires','Buenos Aires',1),(2,23456789,'María','González','1990-07-23 00:00:00','Córdoba','Córdoba',2),(3,34567890,'Carlos','Pérez','1975-02-15 00:00:00','Santa Fe','Santa Fe',3),(4,45678901,'Laura','Martínez','1988-11-30 00:00:00','Mendoza','Mendoza',4),(5,56789012,'Ana','Rodríguez','1993-03-05 00:00:00','Tucumán','San Miguel de Tucumán',5),(6,67890123,'Diego','Hernández','1980-01-22 00:00:00','Salta','Salta',1),(7,78901234,'Sofía','González','1995-09-14 00:00:00','Chubut','Rawson',2),(8,89012345,'Ricardo','Sánchez','1978-05-27 00:00:00','Buenos Aires','La Plata',3),(9,90123456,'Elena','Ramírez','1983-12-16 00:00:00','La Rioja','La Rioja',4),(10,1234567,'Miguel','Martínez','1991-08-25 00:00:00','Mendoza','San Rafael',5);
/*!40000 ALTER TABLE `Cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Planes`
--

DROP TABLE IF EXISTS `Planes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Planes` (
  `idPlan` int NOT NULL AUTO_INCREMENT,
  `velocidad` int NOT NULL,
  `precio` double NOT NULL,
  `descuento` double DEFAULT NULL,
  PRIMARY KEY (`idPlan`),
  UNIQUE KEY `idPlan_UNIQUE` (`idPlan`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Planes`
--

LOCK TABLES `Planes` WRITE;
/*!40000 ALTER TABLE `Planes` DISABLE KEYS */;
INSERT INTO `Planes` VALUES (1,50,29.99,5),(2,100,49.99,10),(3,200,69.99,15),(4,300,89.99,20),(5,500,109.99,25);
/*!40000 ALTER TABLE `Planes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-10 16:02:47
