CREATE DATABASE  IF NOT EXISTS `biblioteca_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `biblioteca_db`;
-- MySQL dump 10.13  Distrib 8.0.36, for macos14 (arm64)
--
-- Host: localhost    Database: biblioteca_db
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
-- Table structure for table `libro`
--

DROP TABLE IF EXISTS `libro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `libro` (
  `idLibro` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `editorial` varchar(50) NOT NULL,
  `area` varchar(50) NOT NULL,
  PRIMARY KEY (`idLibro`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libro`
--

LOCK TABLES `libro` WRITE;
/*!40000 ALTER TABLE `libro` DISABLE KEYS */;
INSERT INTO `libro` VALUES (1,'Harry Potter and the Sorcerer\'s Stone','Bloomsbury Publishing','Fantasy'),(2,'Harry Potter and the Chamber of Secrets','Bloomsbury Publishing','Fantasy'),(3,'Harry Potter and the Prisoner of Azkaban','Bloomsbury Publishing','Fantasy'),(4,'Harry Potter and the Goblet of Fire','Bloomsbury Publishing','Fantasy'),(5,'Harry Potter and the Order of the Phoenix','Bloomsbury Publishing','Fantasy'),(6,'Cien años de soledad','Editorial Sudamericana','Magical Realism'),(7,'El amor en los tiempos del cólera','Editorial Sudamericana','Romance'),(8,'Crónica de una muerte anunciada','Editorial Sudamericana','Literary Fiction'),(9,'El coronel no tiene quien le escriba','Editorial La Oveja Negra','Literary Fiction'),(10,'Memoria de mis putas tristes','Editorial Norma','Literary Fiction'),(11,'Pride and Prejudice','T. Egerton','Romance'),(12,'Sense and Sensibility','T. Egerton','Romance'),(13,'Emma','John Murray','Romance'),(14,'Mansfield Park','Thomas Egerton','Romance'),(15,'Northanger Abbey','John Murray','Romance'),(16,'War and Peace','The Russian Messenger','Historical Fiction'),(17,'Anna Karenina','The Russian Messenger','Romance'),(18,'The Death of Ivan Ilyich','The Russian Messenger','Literary Fiction'),(19,'Resurrection','The Russian Messenger','Literary Fiction'),(20,'The Cossacks','The Russian Messenger','Historical Fiction'),(21,'Norwegian Wood','Kodansha','Literary Fiction'),(22,'1Q84','Shinchosha','Literary Fiction'),(23,'Kafka on the Shore','Shinchosha','Literary Fiction'),(24,'The Wind-Up Bird Chronicle','Shinchosha','Literary Fiction'),(25,'Colorless Tsukuru Tazaki and His Years of Pilgrimage','Bungeishunjū','Literary Fiction');
/*!40000 ALTER TABLE `libro` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-14 13:24:16
