-- MySQL dump 10.13  Distrib 8.3.0, for macos14.2 (arm64)
--
-- Host: localhost    Database: joyas_db
-- ------------------------------------------------------
-- Server version	8.3.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `joya`
--

DROP TABLE IF EXISTS `joya`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `joya` (
  `nro_identificatorio` bigint NOT NULL,
  `material` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `particularidad` varchar(255) DEFAULT NULL,
  `peso` double DEFAULT NULL,
  `posee_piedra` bit(1) DEFAULT NULL,
  `venta_o_no` bit(1) DEFAULT NULL,
  PRIMARY KEY (`nro_identificatorio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `joya`
--

LOCK TABLES `joya` WRITE;
/*!40000 ALTER TABLE `joya` DISABLE KEYS */;
INSERT INTO `joya` VALUES (1,'Gold','Diamond Necklace','Intricate design',25.5,_binary '',_binary '\0'),(2,'Platinum','Sapphire Ring','Engraved with floral patterns',15.2,_binary '',_binary '\0'),(3,'Oro','Prueba actualizar','Particularidad',1.23,_binary '\0',_binary ''),(52,'Rose gold','Pearl Necklace','Layered design with gold accents',18.5,_binary '\0',_binary ''),(102,'Yellow gold','Amethyst Pendant','Heart-shaped with intricate engraving',10.3,_binary '',_binary ''),(202,'Oro','Prueba default value','Particularidad',1.23,_binary '',_binary '');
/*!40000 ALTER TABLE `joya` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `joya_seq`
--

DROP TABLE IF EXISTS `joya_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `joya_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `joya_seq`
--

LOCK TABLES `joya_seq` WRITE;
/*!40000 ALTER TABLE `joya_seq` DISABLE KEYS */;
INSERT INTO `joya_seq` VALUES (301);
/*!40000 ALTER TABLE `joya_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'joyas_db'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-20 15:52:13
