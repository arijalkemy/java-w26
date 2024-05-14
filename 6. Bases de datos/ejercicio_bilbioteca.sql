-- MySQL dump 10.13  Distrib 8.0.33, for macos13 (arm64)
--
-- Host: 127.0.0.1    Database: ejercicio_biblioteca
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
-- Table structure for table `Autores`
--

DROP TABLE IF EXISTS `Autores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Autores` (
  `idAutor` int NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `nacionalidad` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idAutor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Autores`
--

LOCK TABLES `Autores` WRITE;
/*!40000 ALTER TABLE `Autores` DISABLE KEYS */;
INSERT INTO `Autores` VALUES (1,'J.R.R. Tolkien','Reino Unido'),(2,'Gabriel García Márquez','Colombia'),(3,'Miguel de Cervantes Saavedra','España'),(4,'J.R.R. Tolkien','Francia'),(5,'Gabriel García Márquez','Italia');
/*!40000 ALTER TABLE `Autores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Estudiantes`
--

DROP TABLE IF EXISTS `Estudiantes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Estudiantes` (
  `idLector` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `carrera` varchar(45) DEFAULT NULL,
  `edad` int DEFAULT NULL,
  PRIMARY KEY (`idLector`),
  UNIQUE KEY `idLector_UNIQUE` (`idLector`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Estudiantes`
--

LOCK TABLES `Estudiantes` WRITE;
/*!40000 ALTER TABLE `Estudiantes` DISABLE KEYS */;
INSERT INTO `Estudiantes` VALUES (1,'Juan','Perez','Calle 123, 456','Ingeniería Informática',22),(2,'María','Gómez','Avenida 789, 1011','Derecho',23),(3,'Pedro','López','Calle 456, 789','Medicina',24),(4,'Filippo','Galli','Calle 123, 456','Ingeniería Informática',22);
/*!40000 ALTER TABLE `Estudiantes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Libros`
--

DROP TABLE IF EXISTS `Libros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Libros` (
  `idLibro` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(45) DEFAULT NULL,
  `editorial` varchar(45) DEFAULT NULL,
  `area` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idLibro`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Libros`
--

LOCK TABLES `Libros` WRITE;
/*!40000 ALTER TABLE `Libros` DISABLE KEYS */;
INSERT INTO `Libros` VALUES (1,'El Señor de los Anillos','Editorial Planeta','1'),(2,'Cien años de soledad','Editorial Sudamericana','2'),(3,'Don Quijote de la Mancha','Editorial Penguin Classics','3'),(4,'Internet y Redes','Editorial Salamandra','4'),(5,'El Universo: Guía de viaje','Editorial Salamandra','3'),(6,'Bases de Datos relacionales','Editorial Pepito','5');
/*!40000 ALTER TABLE `Libros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `LibrosAutores`
--

DROP TABLE IF EXISTS `LibrosAutores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `LibrosAutores` (
  `idAutor` int NOT NULL,
  `idLibro` int NOT NULL,
  PRIMARY KEY (`idAutor`,`idLibro`),
  KEY `idLibro_idx` (`idLibro`),
  CONSTRAINT `idAutor` FOREIGN KEY (`idAutor`) REFERENCES `Autores` (`idAutor`),
  CONSTRAINT `idLibro` FOREIGN KEY (`idLibro`) REFERENCES `Libros` (`idLibro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LibrosAutores`
--

LOCK TABLES `LibrosAutores` WRITE;
/*!40000 ALTER TABLE `LibrosAutores` DISABLE KEYS */;
INSERT INTO `LibrosAutores` VALUES (1,1),(2,1),(2,2),(3,3),(1,5),(2,5),(2,6),(3,6);
/*!40000 ALTER TABLE `LibrosAutores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Prestamos`
--

DROP TABLE IF EXISTS `Prestamos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Prestamos` (
  `idLector` int NOT NULL,
  `idLibro` int NOT NULL,
  `fechaPrestamo` datetime DEFAULT NULL,
  `fechaDevolucion` datetime DEFAULT NULL,
  `devuelto` tinyint DEFAULT NULL,
  PRIMARY KEY (`idLector`,`idLibro`),
  KEY `idLibro_prestamo_idx` (`idLibro`),
  CONSTRAINT `idLector_prestamo` FOREIGN KEY (`idLector`) REFERENCES `Estudiantes` (`idLector`),
  CONSTRAINT `idLibro_prestamo` FOREIGN KEY (`idLibro`) REFERENCES `Libros` (`idLibro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Prestamos`
--

LOCK TABLES `Prestamos` WRITE;
/*!40000 ALTER TABLE `Prestamos` DISABLE KEYS */;
INSERT INTO `Prestamos` VALUES (1,1,'2024-05-14 00:00:00',NULL,0),(1,6,'2024-05-13 00:00:00','2024-05-14 00:00:00',1),(2,2,'2024-05-13 00:00:00','2024-05-14 00:00:00',1),(3,3,'2024-05-10 00:00:00',NULL,0),(3,6,'2024-05-10 00:00:00',NULL,0),(4,2,'2024-05-13 00:00:00','2024-05-14 00:00:00',1),(4,3,'2024-05-10 00:00:00',NULL,0);
/*!40000 ALTER TABLE `Prestamos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-14 15:59:57
