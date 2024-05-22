-- MySQL dump 10.13  Distrib 8.3.0, for macos14.2 (arm64)
--
-- Host: localhost    Database: empresa_seguros
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
-- Table structure for table `siniestros`
--

DROP TABLE IF EXISTS `siniestros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `siniestros` (
  `id` bigint NOT NULL,
  `fecha_de_siniestro` date DEFAULT NULL,
  `perdida_economica` double DEFAULT NULL,
  `vehiculo_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfqmqval6gmj723jjq4pcr9xg0` (`vehiculo_id`),
  CONSTRAINT `FKfqmqval6gmj723jjq4pcr9xg0` FOREIGN KEY (`vehiculo_id`) REFERENCES `vehiculos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `siniestros`
--

LOCK TABLES `siniestros` WRITE;
/*!40000 ALTER TABLE `siniestros` DISABLE KEYS */;
/*!40000 ALTER TABLE `siniestros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `siniestros_seq`
--

DROP TABLE IF EXISTS `siniestros_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `siniestros_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `siniestros_seq`
--

LOCK TABLES `siniestros_seq` WRITE;
/*!40000 ALTER TABLE `siniestros_seq` DISABLE KEYS */;
INSERT INTO `siniestros_seq` VALUES (1);
/*!40000 ALTER TABLE `siniestros_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehiculos`
--

DROP TABLE IF EXISTS `vehiculos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehiculos` (
  `id` bigint NOT NULL,
  `año_de_fabricacion` int DEFAULT NULL,
  `cantidad_de_ruedas` int DEFAULT NULL,
  `marca` varchar(255) DEFAULT NULL,
  `modelo` varchar(255) DEFAULT NULL,
  `patente` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehiculos`
--

LOCK TABLES `vehiculos` WRITE;
/*!40000 ALTER TABLE `vehiculos` DISABLE KEYS */;
INSERT INTO `vehiculos` VALUES (1,2018,4,'Toyota','Corolla','ABC123'),(2,2015,4,'Ford','Fiesta','XYZ456'),(3,2020,4,'Chevrolet','Cruze','DEF789'),(4,2017,4,'Honda','Civic','GHI012'),(5,2024,6,'Volkswagen','Gol','JKL345');
/*!40000 ALTER TABLE `vehiculos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehiculos_seq`
--

DROP TABLE IF EXISTS `vehiculos_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehiculos_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehiculos_seq`
--

LOCK TABLES `vehiculos_seq` WRITE;
/*!40000 ALTER TABLE `vehiculos_seq` DISABLE KEYS */;
INSERT INTO `vehiculos_seq` VALUES (10);
/*!40000 ALTER TABLE `vehiculos_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'empresa_seguros'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-21 13:02:31
