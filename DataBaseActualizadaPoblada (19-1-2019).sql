-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: control_notas
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `acceso`
--

DROP TABLE IF EXISTS `acceso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `acceso` (
  `id_acceso` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(50) DEFAULT NULL,
  `contrasena` varchar(50) DEFAULT NULL,
  `nivel_acceso` varchar(50) DEFAULT NULL,
  `estado` varchar(20) DEFAULT NULL,
  `campo` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_acceso`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acceso`
--

LOCK TABLES `acceso` WRITE;
/*!40000 ALTER TABLE `acceso` DISABLE KEYS */;
INSERT INTO `acceso` VALUES (1,'cheyo','123456','profesor','activo','gdgdgdgdg'),(13,'Albert','Albert930','Director','Activo',NULL),(14,'Mauric','Mauric341','Director','Activo',NULL),(15,'Armand','Armand325','Director','Activo',NULL),(16,'Ruth N','Ruth N902','Director','Activo',NULL),(17,'AlvRod','AlvRod420','Profesor','Activo',''),(18,'Hola Q','Hola Q503','Director','Activo',NULL),(19,'jorRam','jorRam211','Profesor','Activo',''),(20,'Hola E','Hola E664','Director','Activo',NULL),(21,'DIR625290','625290','director','activo',NULL),(22,'EST5466','5466','estudiante','activo',NULL),(23,'majano','majano205','Director','Activo',NULL),(24,'DIR257914','257914','director','activo',NULL),(25,'EST8808','8808','estudiante','activo',NULL),(26,'carlos','carlos174','Director','Activo',NULL),(27,'carlos','carlos884','Director','Activo',NULL),(28,'Martha','Martha228','Director','Activo',NULL),(29,'Martha','Martha715','Director','Activo',NULL),(30,'Martha','Martha904','Director','Activo',NULL),(31,'Martha','Martha931','Director','Activo',NULL),(32,'Martha','Martha465','Director','Activo',NULL),(33,'Martha','Martha948','Director','Activo',NULL),(34,'Martha','Martha255','Director','Activo',NULL),(35,'Martha','Martha718','Director','Activo',NULL),(36,'Martha','Martha189','Director','Activo',NULL),(37,'Martha','Martha897','Director','Activo',NULL),(38,'Oscar ','Oscar 940','Director','Activo',NULL),(39,'Franci','Franci477','Director','Activo',NULL),(40,'Franci','Franci308','Director','Activo',NULL),(41,'Franci','Franci660','Director','Activo',NULL),(42,'Franci','Franci823','Director','Activo',NULL),(43,'Franci','Franci978','Director','Activo',NULL),(44,'Franci','Franci601','Director','Activo',NULL),(45,'Franci','Franci316','Director','Activo',NULL),(46,'Franci','Franci1008','Director','Activo',NULL),(47,'Franci','Franci932','Director','Activo',NULL),(48,'Franci','Franci514','Director','Activo',NULL),(49,'Franci','Franci900','Director','Activo',NULL),(50,'Franci','Franci317','Director','Activo',NULL),(51,'Franci','Franci846','Director','Activo',NULL),(52,'Franci','Franci519','Director','Activo',NULL),(53,'Franci','Franci222','Director','Activo',NULL),(54,'Franci','Franci885','Director','Activo',NULL),(55,'Franci','Franci504','Director','Activo',NULL),(56,'Franci','Franci985','Director','Activo',NULL),(57,'Franci','Franci846','Director','Activo',NULL),(58,'Franci','Franci528','Director','Activo',NULL),(59,'Franci','Franci915','Director','Activo',NULL),(60,'Franci','Franci684','Director','Activo',NULL),(61,'Franci','Franci1071','Director','Activo',NULL),(62,'Franci','Franci386','Director','Activo',NULL),(63,'Franci','Franci702','Director','Activo',NULL),(64,'Franci','Franci826','Director','Activo',NULL),(65,'Franci','Franci1022','Director','Activo',NULL),(66,'Franci','Franci529','Director','Activo',NULL),(67,'Franci','Franci837','Director','Activo',NULL),(68,'Franci','Franci463','Director','Activo',NULL),(69,'Franci','Franci732','Director','Activo',NULL),(70,'Franci','Franci227','Director','Activo',NULL),(71,'Franci','Franci589','Director','Activo',NULL),(72,'Franci','Franci501','Director','Activo',NULL),(73,'Franci','Franci774','Director','Activo',NULL),(74,'Franci','Franci993','Director','Activo',NULL),(75,'Franci','Franci352','Director','Activo',NULL),(76,'Franci','Franci218','Director','Activo',NULL),(77,'Franci','Franci244','Director','Activo',NULL),(78,'Franci','Franci587','Director','Activo',NULL),(79,'Franci','Franci834','Director','Activo',NULL),(80,'Juan J','Juan J903','Director','Activo',NULL);
/*!40000 ALTER TABLE `acceso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alumnos`
--

DROP TABLE IF EXISTS `alumnos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `alumnos` (
  `nie` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `direccion` varchar(200) DEFAULT NULL,
  `edad` int(2) DEFAULT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `fecha_nacimiento` varchar(20) DEFAULT NULL,
  `fecha_registro` varchar(20) DEFAULT NULL,
  `id_acceso` int(11) NOT NULL,
  `codigo_escuela` int(11) NOT NULL,
  `grado` varchar(20) NOT NULL,
  `estado` varchar(20) DEFAULT NULL,
  `campo` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`nie`),
  KEY `id_acceso` (`id_acceso`),
  KEY `codigo_escuela` (`codigo_escuela`),
  KEY `grado` (`grado`),
  CONSTRAINT `alumnos_ibfk_1` FOREIGN KEY (`id_acceso`) REFERENCES `acceso` (`id_acceso`),
  CONSTRAINT `alumnos_ibfk_2` FOREIGN KEY (`codigo_escuela`) REFERENCES `escuelas` (`codigo_escuela`),
  CONSTRAINT `alumnos_ibfk_3` FOREIGN KEY (`grado`) REFERENCES `nivel` (`grado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumnos`
--

LOCK TABLES `alumnos` WRITE;
/*!40000 ALTER TABLE `alumnos` DISABLE KEYS */;
INSERT INTO `alumnos` VALUES (71,'alberto','ramirez','ggdfdf','ss',19,'21545367','21/09/1999','21/09/1999',1,1,'primero','activo',NULL),(2548,'Ruth Noemi','Ramos Gómez','noemirg310@gmail.com','ss',19,'24516598','21/06/2000','21/06/2000',16,1,'quinto','activo',NULL),(5457,'Hola Q','Solo Prueba','hqsPrueba@gmail.com','ciudad delgado',14,NULL,'21/04/2006','21/05/2006',18,213424,'quinto','activo',NULL),(54554,'Hola Es','Prueba','hpff@ejemplo.com','por Hay',25,NULL,'06/03/1994','09/01/2019',20,5525,'sexto','activo',NULL);
/*!40000 ALTER TABLE `alumnos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `escuelas`
--

DROP TABLE IF EXISTS `escuelas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `escuelas` (
  `codigo_escuela` int(11) NOT NULL,
  `nombre_escuela` varchar(100) DEFAULT NULL,
  `direccion` varchar(200) DEFAULT NULL,
  `municipio` varchar(20) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `correo` varchar(20) DEFAULT NULL,
  `longitud` double DEFAULT NULL,
  `latitud` double DEFAULT NULL,
  `nombre_director` varchar(50) DEFAULT NULL,
  `id_acceso` int(11) NOT NULL,
  `estado` varchar(20) DEFAULT NULL,
  `campo` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`codigo_escuela`),
  KEY `id_acceso` (`id_acceso`),
  CONSTRAINT `escuelas_ibfk_1` FOREIGN KEY (`id_acceso`) REFERENCES `acceso` (`id_acceso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `escuelas`
--

LOCK TABLES `escuelas` WRITE;
/*!40000 ALTER TABLE `escuelas` DISABLE KEYS */;
INSERT INTO `escuelas` VALUES (1,'Centro Escolar República de Costa Rica','Sexta calle oriente y sexta avenida sur numero cuatro cientos dieciséis.','san salvador','22341221','costaRica@gmail.com',-89.188916,13.695697,'CarlosGarcia',1,'inactivo',NULL),(5525,'Centro escolar francisco campos','Cuarta calle oriente numero ochenta y tres barrio san esteban.','San Salvador','(503)2248-5455','campos@gmail.edu.sv',-89.18468,13.696179,'Jaime Bladimir Torres Burgos',15,'Activo',NULL),(10999,'Centro escolar Walter Thilo Deninger','calle principal contiguo a ex alcaldia municipal, antiguo cuscatlan.','Antiguo Cuscatlan','(503)2243-1356','cewtd@hotmail.com',-89.242499,13.673429,'Francisco Antonio Castellon Benavid',23,'Activo',NULL),(11597,'Centro Escolar Juan Ramón Jimenez','Final calle los duraznos n10, contiguo al complejo municipal cancha chapupo, col.san fran','San Salvador','(503)2531-3156','cejr11597@gmail.com',-89.225475,13.685146,'Toni Alexander Ramirez Abrego',27,'Activo',NULL),(11658,'Centro Escolar España','Calle san antonio abad y avenida don bosco.','San Salvador','(503)2226-0733','',-89.206084,13.715476,'Oscar Antonio Magaña Cortez',38,'Activo',NULL),(11671,'Complejo educativo concha viuda de escalon','81 av.norte y 5 calle poniente col.escalon San Salvador ','San Salvador','(503)2519-4647','cecove@hotmail.com',-89.237566,13.705585,'Consuelo de Jesus Hernandez',26,'Activo',NULL),(90111,'Centro Escolar Republica de Paraguay','Calle modelo y final primera avenida sur barrio candelaria','San Salvador','(503)2531-3156','paraguay@yahoo.com',-89.192778,13.6911843,'Francisco Alfredo Cruz',80,'Activo',NULL),(170930,'Centro Escolar la Ceiba','San Salvador','San Salvador','(503)2591-9567','ceceiba@edu.sv',-89.203469,13.716102,'Ricardo Castillo',1,'inactivo',NULL),(213424,'Centro Escolar Republica de Ecuador','17 avenida sur y calle francisco menendez barrio santa anita.','San Salvador','(503)2242-0829','Ecuador@gmail.com',-89.201423,13.689015,'Ismael Antonio Guerra Mejia',13,'activo',NULL),(548585,'CE Republica De Argentina','6a calle oriente y 8a avenida sur #435','San Salvador','(503)2131-7481','argentina@gmail.com',-89.188613,13.696174,'Tomasa de Jesus Caldeon de Calderon',14,'activo',NULL),(864495,'Centro Escolar la Ceiba','San Salvador','San Salvador','(503)2591-9567','ceceiba@edu.sv',-89.203469,13.716102,'Ricardo Castillo',1,'inactivo',NULL);
/*!40000 ALTER TABLE `escuelas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materias`
--

DROP TABLE IF EXISTS `materias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `materias` (
  `nombre_materia` varchar(50) NOT NULL,
  `grado` varchar(20) NOT NULL,
  `ponderacion_1` double(5,2) DEFAULT NULL,
  `ponderacion_2` double(5,2) DEFAULT NULL,
  `ponderacion_3` double(5,2) DEFAULT NULL,
  `ponderacion_4` double(5,2) DEFAULT NULL,
  `ponderacion_5` double(5,2) DEFAULT NULL,
  `ponderacion_6` double(5,2) DEFAULT NULL,
  `periodo` varchar(20) DEFAULT NULL,
  `estado_periodo` varchar(20) DEFAULT NULL,
  `estado` varchar(20) DEFAULT NULL,
  `campo` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`nombre_materia`),
  KEY `grado` (`grado`),
  CONSTRAINT `materias_ibfk_1` FOREIGN KEY (`grado`) REFERENCES `nivel` (`grado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materias`
--

LOCK TABLES `materias` WRITE;
/*!40000 ALTER TABLE `materias` DISABLE KEYS */;
INSERT INTO `materias` VALUES ('10999 - 1° Grado - Ciencias','10999 - 1° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('10999 - 1° Grado - Lenguage','10999 - 1° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('10999 - 1° Grado - Matematicas','10999 - 1° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('10999 - 1° Grado - Sociales','10999 - 1° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('10999 - 2° Grado - Ciencias','10999 - 2° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('10999 - 2° Grado - Lenguage','10999 - 2° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('10999 - 2° Grado - Matematicas','10999 - 2° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('10999 - 2° Grado - Sociales','10999 - 2° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('10999 - 3° Grado - Ciencias','10999 - 3° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('10999 - 3° Grado - Lenguage','10999 - 3° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('10999 - 3° Grado - Matematicas','10999 - 3° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('10999 - 3° Grado - Sociales','10999 - 3° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('10999 - 4° Grado - Ciencias','10999 - 4° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('10999 - 4° Grado - Lenguage','10999 - 4° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('10999 - 4° Grado - Matematicas','10999 - 4° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('10999 - 4° Grado - Sociales','10999 - 4° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('10999 - 5° Grado - Ciencias','10999 - 5° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('10999 - 5° Grado - Lenguage','10999 - 5° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('10999 - 5° Grado - Matematicas','10999 - 5° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('10999 - 5° Grado - Sociales','10999 - 5° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('10999 - 6° Grado - Ciencias','10999 - 6° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('10999 - 6° Grado - Lenguage','10999 - 6° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('10999 - 6° Grado - Matematicas','10999 - 6° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('10999 - 6° Grado - Sociales','10999 - 6° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('10999 - 7° Grado - Ciencias','10999 - 7° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('10999 - 7° Grado - Lenguage','10999 - 7° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('10999 - 7° Grado - Matematicas','10999 - 7° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('10999 - 7° Grado - Sociales','10999 - 7° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('10999 - 8° Grado - Ciencias','10999 - 8° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('10999 - 8° Grado - Lenguage','10999 - 8° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('10999 - 8° Grado - Matematicas','10999 - 8° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('10999 - 8° Grado - Sociales','10999 - 8° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('10999 - 9° Grado - Ciencias','10999 - 9° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('10999 - 9° Grado - Lenguage','10999 - 9° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('10999 - 9° Grado - Matematicas','10999 - 9° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('10999 - 9° Grado - Sociales','10999 - 9° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11597 - 1° Grado - Ciencias','11597 - 1° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11597 - 1° Grado - Lenguage','11597 - 1° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11597 - 1° Grado - Matematicas','11597 - 1° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11597 - 1° Grado - Sociales','11597 - 1° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11597 - 2° Grado - Ciencias','11597 - 2° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11597 - 2° Grado - Lenguage','11597 - 2° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11597 - 2° Grado - Matematicas','11597 - 2° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11597 - 2° Grado - Sociales','11597 - 2° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11597 - 3° Grado - Ciencias','11597 - 3° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11597 - 3° Grado - Lenguage','11597 - 3° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11597 - 3° Grado - Matematicas','11597 - 3° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11597 - 3° Grado - Sociales','11597 - 3° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11597 - 4° Grado - Ciencias','11597 - 4° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11597 - 4° Grado - Lenguage','11597 - 4° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11597 - 4° Grado - Matematicas','11597 - 4° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11597 - 4° Grado - Sociales','11597 - 4° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11597 - 5° Grado - Ciencias','11597 - 5° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11597 - 5° Grado - Lenguage','11597 - 5° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11597 - 5° Grado - Matematicas','11597 - 5° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11597 - 5° Grado - Sociales','11597 - 5° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11597 - 6° Grado - Ciencias','11597 - 6° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11597 - 6° Grado - Lenguage','11597 - 6° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11597 - 6° Grado - Matematicas','11597 - 6° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11597 - 6° Grado - Sociales','11597 - 6° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11597 - 7° Grado - Ciencias','11597 - 7° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11597 - 7° Grado - Lenguage','11597 - 7° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11597 - 7° Grado - Matematicas','11597 - 7° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11597 - 7° Grado - Sociales','11597 - 7° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11597 - 8° Grado - Ciencias','11597 - 8° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11597 - 8° Grado - Lenguage','11597 - 8° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11597 - 8° Grado - Matematicas','11597 - 8° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11597 - 8° Grado - Sociales','11597 - 8° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11597 - 9° Grado - Ciencias','11597 - 9° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11597 - 9° Grado - Lenguage','11597 - 9° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11597 - 9° Grado - Matematicas','11597 - 9° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11597 - 9° Grado - Sociales','11597 - 9° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11658 - 1° Grado - Ciencias','11658 - 1° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11658 - 1° Grado - Lenguage','11658 - 1° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11658 - 1° Grado - Matematicas','11658 - 1° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11658 - 1° Grado - Sociales','11658 - 1° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11658 - 2° Grado - Ciencias','11658 - 2° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11658 - 2° Grado - Lenguage','11658 - 2° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11658 - 2° Grado - Matematicas','11658 - 2° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11658 - 2° Grado - Sociales','11658 - 2° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11658 - 3° Grado - Ciencias','11658 - 3° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11658 - 3° Grado - Lenguage','11658 - 3° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11658 - 3° Grado - Matematicas','11658 - 3° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11658 - 3° Grado - Sociales','11658 - 3° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11658 - 4° Grado - Ciencias','11658 - 4° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11658 - 4° Grado - Lenguage','11658 - 4° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11658 - 4° Grado - Matematicas','11658 - 4° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11658 - 4° Grado - Sociales','11658 - 4° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11658 - 5° Grado - Ciencias','11658 - 5° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11658 - 5° Grado - Lenguage','11658 - 5° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11658 - 5° Grado - Matematicas','11658 - 5° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11658 - 5° Grado - Sociales','11658 - 5° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11658 - 6° Grado - Ciencias','11658 - 6° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11658 - 6° Grado - Lenguage','11658 - 6° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11658 - 6° Grado - Matematicas','11658 - 6° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11658 - 6° Grado - Sociales','11658 - 6° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11658 - 7° Grado - Ciencias','11658 - 7° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11658 - 7° Grado - Lenguage','11658 - 7° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11658 - 7° Grado - Matematicas','11658 - 7° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11658 - 7° Grado - Sociales','11658 - 7° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11658 - 8° Grado - Ciencias','11658 - 8° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11658 - 8° Grado - Lenguage','11658 - 8° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11658 - 8° Grado - Matematicas','11658 - 8° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11658 - 8° Grado - Sociales','11658 - 8° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11658 - 9° Grado - Ciencias','11658 - 9° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11658 - 9° Grado - Lenguage','11658 - 9° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11658 - 9° Grado - Matematicas','11658 - 9° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11658 - 9° Grado - Sociales','11658 - 9° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11671 - 1° Grado - Ciencias','11671 - 1° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11671 - 1° Grado - Lenguage','11671 - 1° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11671 - 1° Grado - Matematicas','11671 - 1° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11671 - 1° Grado - Sociales','11671 - 1° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11671 - 2° Grado - Ciencias','11671 - 2° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11671 - 2° Grado - Lenguage','11671 - 2° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11671 - 2° Grado - Matematicas','11671 - 2° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11671 - 2° Grado - Sociales','11671 - 2° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11671 - 3° Grado - Ciencias','11671 - 3° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11671 - 3° Grado - Lenguage','11671 - 3° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11671 - 3° Grado - Matematicas','11671 - 3° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11671 - 3° Grado - Sociales','11671 - 3° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11671 - 4° Grado - Ciencias','11671 - 4° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11671 - 4° Grado - Lenguage','11671 - 4° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11671 - 4° Grado - Matematicas','11671 - 4° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11671 - 4° Grado - Sociales','11671 - 4° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11671 - 5° Grado - Ciencias','11671 - 5° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11671 - 5° Grado - Lenguage','11671 - 5° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11671 - 5° Grado - Matematicas','11671 - 5° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11671 - 5° Grado - Sociales','11671 - 5° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11671 - 6° Grado - Ciencias','11671 - 6° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11671 - 6° Grado - Lenguage','11671 - 6° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11671 - 6° Grado - Matematicas','11671 - 6° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11671 - 6° Grado - Sociales','11671 - 6° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11671 - 7° Grado - Ciencias','11671 - 7° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11671 - 7° Grado - Lenguage','11671 - 7° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11671 - 7° Grado - Matematicas','11671 - 7° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11671 - 7° Grado - Sociales','11671 - 7° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11671 - 8° Grado - Ciencias','11671 - 8° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11671 - 8° Grado - Lenguage','11671 - 8° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11671 - 8° Grado - Matematicas','11671 - 8° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11671 - 8° Grado - Sociales','11671 - 8° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11671 - 9° Grado - Ciencias','11671 - 9° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11671 - 9° Grado - Lenguage','11671 - 9° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11671 - 9° Grado - Matematicas','11671 - 9° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('11671 - 9° Grado - Sociales','11671 - 9° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('170930 - 1° Grado - Ciencias','170930 - 1° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('170930 - 1° Grado - Lenguage','170930 - 1° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('170930 - 1° Grado - Matematicas','170930 - 1° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('170930 - 1° Grado - Sociales','170930 - 1° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('170930 - 2° Grado - Ciencias','170930 - 2° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('170930 - 2° Grado - Lenguage','170930 - 2° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('170930 - 2° Grado - Matematicas','170930 - 2° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('170930 - 2° Grado - Sociales','170930 - 2° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('170930 - 3° Grado - Ciencias','170930 - 3° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('170930 - 3° Grado - Lenguage','170930 - 3° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('170930 - 3° Grado - Matematicas','170930 - 3° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('170930 - 3° Grado - Sociales','170930 - 3° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('170930 - 4° Grado - Ciencias','170930 - 4° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('170930 - 4° Grado - Lenguage','170930 - 4° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('170930 - 4° Grado - Matematicas','170930 - 4° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('170930 - 4° Grado - Sociales','170930 - 4° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('170930 - 5° Grado - Ciencias','170930 - 5° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('170930 - 5° Grado - Lenguage','170930 - 5° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('170930 - 5° Grado - Matematicas','170930 - 5° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('170930 - 5° Grado - Sociales','170930 - 5° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('170930 - 6° Grado - Ciencias','170930 - 6° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('170930 - 6° Grado - Lenguage','170930 - 6° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('170930 - 6° Grado - Matematicas','170930 - 6° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('170930 - 6° Grado - Sociales','170930 - 6° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('170930 - 7° Grado - Ciencias','170930 - 7° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('170930 - 7° Grado - Lenguage','170930 - 7° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('170930 - 7° Grado - Matematicas','170930 - 7° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('170930 - 7° Grado - Sociales','170930 - 7° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('170930 - 8° Grado - Ciencias','170930 - 8° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('170930 - 8° Grado - Lenguage','170930 - 8° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('170930 - 8° Grado - Matematicas','170930 - 8° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('170930 - 8° Grado - Sociales','170930 - 8° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('170930 - 9° Grado - Ciencias','170930 - 9° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('170930 - 9° Grado - Lenguage','170930 - 9° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('170930 - 9° Grado - Matematicas','170930 - 9° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('170930 - 9° Grado - Sociales','170930 - 9° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('864495 - 1° Grado - Ciencias','864495 - 1° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('864495 - 1° Grado - Lenguage','864495 - 1° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('864495 - 1° Grado - Matematicas','864495 - 1° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('864495 - 1° Grado - Sociales','864495 - 1° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('864495 - 2° Grado - Ciencias','864495 - 2° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('864495 - 2° Grado - Lenguage','864495 - 2° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('864495 - 2° Grado - Matematicas','864495 - 2° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('864495 - 2° Grado - Sociales','864495 - 2° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('864495 - 3° Grado - Ciencias','864495 - 3° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('864495 - 3° Grado - Lenguage','864495 - 3° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('864495 - 3° Grado - Matematicas','864495 - 3° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('864495 - 3° Grado - Sociales','864495 - 3° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('864495 - 4° Grado - Ciencias','864495 - 4° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('864495 - 4° Grado - Lenguage','864495 - 4° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('864495 - 4° Grado - Matematicas','864495 - 4° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('864495 - 4° Grado - Sociales','864495 - 4° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('864495 - 5° Grado - Ciencias','864495 - 5° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('864495 - 5° Grado - Lenguage','864495 - 5° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('864495 - 5° Grado - Matematicas','864495 - 5° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('864495 - 5° Grado - Sociales','864495 - 5° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('864495 - 6° Grado - Ciencias','864495 - 6° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('864495 - 6° Grado - Lenguage','864495 - 6° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('864495 - 6° Grado - Matematicas','864495 - 6° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('864495 - 6° Grado - Sociales','864495 - 6° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('864495 - 7° Grado - Ciencias','864495 - 7° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('864495 - 7° Grado - Lenguage','864495 - 7° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('864495 - 7° Grado - Matematicas','864495 - 7° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('864495 - 7° Grado - Sociales','864495 - 7° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('864495 - 8° Grado - Ciencias','864495 - 8° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('864495 - 8° Grado - Lenguage','864495 - 8° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('864495 - 8° Grado - Matematicas','864495 - 8° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('864495 - 8° Grado - Sociales','864495 - 8° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('864495 - 9° Grado - Ciencias','864495 - 9° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('864495 - 9° Grado - Lenguage','864495 - 9° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('864495 - 9° Grado - Matematicas','864495 - 9° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('864495 - 9° Grado - Sociales','864495 - 9° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('90111 - 1° Grado - Ciencias','90111 - 1° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('90111 - 1° Grado - Lenguage','90111 - 1° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('90111 - 1° Grado - Matematicas','90111 - 1° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('90111 - 1° Grado - Sociales','90111 - 1° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('90111 - 2° Grado - Ciencias','90111 - 2° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('90111 - 2° Grado - Lenguage','90111 - 2° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('90111 - 2° Grado - Matematicas','90111 - 2° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('90111 - 2° Grado - Sociales','90111 - 2° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('90111 - 3° Grado - Ciencias','90111 - 3° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('90111 - 3° Grado - Lenguage','90111 - 3° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('90111 - 3° Grado - Matematicas','90111 - 3° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('90111 - 3° Grado - Sociales','90111 - 3° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('90111 - 4° Grado - Ciencias','90111 - 4° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('90111 - 4° Grado - Lenguage','90111 - 4° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('90111 - 4° Grado - Matematicas','90111 - 4° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('90111 - 4° Grado - Sociales','90111 - 4° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('90111 - 5° Grado - Ciencias','90111 - 5° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('90111 - 5° Grado - Lenguage','90111 - 5° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('90111 - 5° Grado - Matematicas','90111 - 5° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('90111 - 5° Grado - Sociales','90111 - 5° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('90111 - 6° Grado - Ciencias','90111 - 6° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('90111 - 6° Grado - Lenguage','90111 - 6° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('90111 - 6° Grado - Matematicas','90111 - 6° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('90111 - 6° Grado - Sociales','90111 - 6° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('90111 - 7° Grado - Ciencias','90111 - 7° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('90111 - 7° Grado - Lenguage','90111 - 7° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('90111 - 7° Grado - Matematicas','90111 - 7° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('90111 - 7° Grado - Sociales','90111 - 7° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('90111 - 8° Grado - Ciencias','90111 - 8° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('90111 - 8° Grado - Lenguage','90111 - 8° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('90111 - 8° Grado - Matematicas','90111 - 8° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('90111 - 8° Grado - Sociales','90111 - 8° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('90111 - 9° Grado - Ciencias','90111 - 9° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('90111 - 9° Grado - Lenguage','90111 - 9° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('90111 - 9° Grado - Matematicas','90111 - 9° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('90111 - 9° Grado - Sociales','90111 - 9° Grado',0.00,0.00,0.00,0.00,0.00,0.00,'2019','en curso','activo',NULL),('ggfdgfd','cuarto',0.00,0.00,0.00,0.00,0.00,0.00,'1','activo','activo',NULL),('Lenguaje','cuarto',0.00,0.00,0.00,0.00,0.00,0.00,'1','activo','activo',NULL),('Matematica','decimo',2.00,3.00,1.00,0.25,0.25,0.50,'2','activo','activo',NULL),('matematicas','primero',3.20,2.50,2.50,5.30,2.80,5.80,'1','activo','activo',NULL);
/*!40000 ALTER TABLE `materias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nivel`
--

DROP TABLE IF EXISTS `nivel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `nivel` (
  `grado` varchar(20) NOT NULL,
  `codigo_escuela` int(11) NOT NULL,
  `estado` varchar(20) DEFAULT NULL,
  `campo` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`grado`),
  KEY `codigo_escuela` (`codigo_escuela`),
  CONSTRAINT `nivel_ibfk_1` FOREIGN KEY (`codigo_escuela`) REFERENCES `escuelas` (`codigo_escuela`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nivel`
--

LOCK TABLES `nivel` WRITE;
/*!40000 ALTER TABLE `nivel` DISABLE KEYS */;
INSERT INTO `nivel` VALUES ('10999 - 1° Grado',10999,'activo',NULL),('10999 - 2° Grado',10999,'activo',NULL),('10999 - 3° Grado',10999,'activo',NULL),('10999 - 4° Grado',10999,'activo',NULL),('10999 - 5° Grado',10999,'activo',NULL),('10999 - 6° Grado',10999,'activo',NULL),('10999 - 7° Grado',10999,'activo',NULL),('10999 - 8° Grado',10999,'activo',NULL),('10999 - 9° Grado',10999,'activo',NULL),('11597 - 1° Grado',11597,'activo',NULL),('11597 - 2° Grado',11597,'activo',NULL),('11597 - 3° Grado',11597,'activo',NULL),('11597 - 4° Grado',11597,'activo',NULL),('11597 - 5° Grado',11597,'activo',NULL),('11597 - 6° Grado',11597,'activo',NULL),('11597 - 7° Grado',11597,'activo',NULL),('11597 - 8° Grado',11597,'activo',NULL),('11597 - 9° Grado',11597,'activo',NULL),('11658 - 1° Grado',11658,'activo',NULL),('11658 - 2° Grado',11658,'activo',NULL),('11658 - 3° Grado',11658,'activo',NULL),('11658 - 4° Grado',11658,'activo',NULL),('11658 - 5° Grado',11658,'activo',NULL),('11658 - 6° Grado',11658,'activo',NULL),('11658 - 7° Grado',11658,'activo',NULL),('11658 - 8° Grado',11658,'activo',NULL),('11658 - 9° Grado',11658,'activo',NULL),('11671 - 1° Grado',11671,'activo',NULL),('11671 - 2° Grado',11671,'activo',NULL),('11671 - 3° Grado',11671,'activo',NULL),('11671 - 4° Grado',11671,'activo',NULL),('11671 - 5° Grado',11671,'activo',NULL),('11671 - 6° Grado',11671,'activo',NULL),('11671 - 7° Grado',11671,'activo',NULL),('11671 - 8° Grado',11671,'activo',NULL),('11671 - 9° Grado',11671,'activo',NULL),('170930 - 1° Grado',170930,'activo',NULL),('170930 - 2° Grado',170930,'activo',NULL),('170930 - 3° Grado',170930,'activo',NULL),('170930 - 4° Grado',170930,'activo',NULL),('170930 - 5° Grado',170930,'activo',NULL),('170930 - 6° Grado',170930,'activo',NULL),('170930 - 7° Grado',170930,'activo',NULL),('170930 - 8° Grado',170930,'activo',NULL),('170930 - 9° Grado',170930,'activo',NULL),('864495 - 1° Grado',864495,'activo',NULL),('864495 - 2° Grado',864495,'activo',NULL),('864495 - 3° Grado',864495,'activo',NULL),('864495 - 4° Grado',864495,'activo',NULL),('864495 - 5° Grado',864495,'activo',NULL),('864495 - 6° Grado',864495,'activo',NULL),('864495 - 7° Grado',864495,'activo',NULL),('864495 - 8° Grado',864495,'activo',NULL),('864495 - 9° Grado',864495,'activo',NULL),('90111 - 1° Grado',90111,'activo',NULL),('90111 - 2° Grado',90111,'activo',NULL),('90111 - 3° Grado',90111,'activo',NULL),('90111 - 4° Grado',90111,'activo',NULL),('90111 - 5° Grado',90111,'activo',NULL),('90111 - 6° Grado',90111,'activo',NULL),('90111 - 7° Grado',90111,'activo',NULL),('90111 - 8° Grado',90111,'activo',NULL),('90111 - 9° Grado',90111,'activo',NULL),('abcds',5525,'activo',NULL),('cuarto',1,'activo',NULL),('decimo',1,'activo',NULL),('noveno',213424,'activo',NULL),('primero',1,'activo',NULL),('quinto',213424,'activo',NULL),('segundo',1,'activo',NULL),('septimo',213424,'activo',NULL),('sexto',1,'activo',NULL),('tercero',213424,'inactivo',NULL);
/*!40000 ALTER TABLE `nivel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notas`
--

DROP TABLE IF EXISTS `notas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `notas` (
  `id_nota` int(11) NOT NULL AUTO_INCREMENT,
  `nie` int(11) NOT NULL,
  `nombre_materia` varchar(50) NOT NULL,
  `nota_1` double(5,2) DEFAULT NULL,
  `nota_2` double(5,2) DEFAULT NULL,
  `nota_3` double(5,2) DEFAULT NULL,
  `nota_4` double(5,2) DEFAULT NULL,
  `nota_5` double(5,2) DEFAULT NULL,
  `nota_6` double(5,2) DEFAULT NULL,
  `promerio` double(5,2) DEFAULT NULL,
  `reposicion` double(5,2) DEFAULT NULL,
  `final` double(5,2) DEFAULT NULL,
  `estado_alumno` varchar(20) DEFAULT NULL,
  `estado_notas` varchar(20) DEFAULT NULL,
  `campo` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_nota`),
  KEY `nie` (`nie`),
  KEY `nombre_materia` (`nombre_materia`),
  CONSTRAINT `notas_ibfk_1` FOREIGN KEY (`nie`) REFERENCES `alumnos` (`nie`),
  CONSTRAINT `notas_ibfk_2` FOREIGN KEY (`nombre_materia`) REFERENCES `materias` (`nombre_materia`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notas`
--

LOCK TABLES `notas` WRITE;
/*!40000 ALTER TABLE `notas` DISABLE KEYS */;
INSERT INTO `notas` VALUES (1,71,'matematicas',7.00,7.00,8.00,6.00,7.00,8.00,6.00,8.00,6.00,'activo','activo',NULL),(2,71,'matematicas',5.00,4.00,3.00,7.00,4.00,4.00,9.00,10.00,7.00,'activo','activo',NULL),(3,71,'matematicas',9.00,7.00,5.00,3.00,6.00,5.00,7.00,5.00,8.10,'activo','activo',NULL),(4,71,'matematicas',8.00,7.00,5.00,9.00,3.00,10.00,7.00,2.00,8.40,'activo','activo',NULL),(5,71,'matematicas',8.00,6.00,4.00,7.00,5.00,7.00,6.00,4.00,8.00,'activo','activo',NULL),(6,71,'matematicas',4.00,2.00,6.00,8.00,2.00,7.00,4.00,8.00,5.00,'activo','activo',NULL),(7,71,'matematicas',7.00,5.00,3.00,9.00,5.00,5.00,7.90,6.00,8.10,'activo','activo',NULL),(8,71,'matematicas',3.00,3.00,4.00,6.00,2.00,1.00,5.00,5.00,5.00,'activo','activo',NULL),(9,71,'matematicas',0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,NULL,NULL,NULL),(10,71,'matematicas',0.00,0.00,0.00,0.00,0.00,0.00,0.00,7.50,0.00,'activo','activo',NULL),(11,71,'matematicas',0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,'activo','activo',NULL),(12,71,'matematicas',0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,'activo','activo',NULL),(13,71,'matematicas',0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00,'activo','activo',NULL);
/*!40000 ALTER TABLE `notas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesores`
--

DROP TABLE IF EXISTS `profesores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `profesores` (
  `escalafon` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `direccion` varchar(200) DEFAULT NULL,
  `edad` int(2) DEFAULT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `fecha_nacimiento` varchar(20) DEFAULT NULL,
  `fecha_registro` varchar(20) DEFAULT NULL,
  `id_acceso` int(11) NOT NULL,
  `codigo_escuela` int(11) NOT NULL,
  `grado` varchar(20) NOT NULL,
  `estado` varchar(20) DEFAULT NULL,
  `campo` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`escalafon`),
  KEY `id_acceso` (`id_acceso`),
  KEY `codigo_escuela` (`codigo_escuela`),
  KEY `grado` (`grado`),
  CONSTRAINT `profesores_ibfk_1` FOREIGN KEY (`id_acceso`) REFERENCES `acceso` (`id_acceso`),
  CONSTRAINT `profesores_ibfk_2` FOREIGN KEY (`codigo_escuela`) REFERENCES `escuelas` (`codigo_escuela`),
  CONSTRAINT `profesores_ibfk_3` FOREIGN KEY (`grado`) REFERENCES `nivel` (`grado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesores`
--

LOCK TABLES `profesores` WRITE;
/*!40000 ALTER TABLE `profesores` DISABLE KEYS */;
INSERT INTO `profesores` VALUES (300,'jorge','Ramirez','jRamirez@gmail.com','san salvador',35,'(503)3564-8751','04/08/1983','07/01/2019',19,1,'cuarto','activo',NULL),(350,'Erick Alejandro','Ramirez','dfvdvfbg.com','ss',31,'2456-8925','21/06/1987','21/06/1987',1,1,'cuarto','activo',NULL),(356,'Alvaro Agustìn','Rodriguez ','ffgdgghghgf.com','S.S.',31,'(503)3556-4488','21/07/1973','13/12/2018',17,1,'decimo','activo',NULL);
/*!40000 ALTER TABLE `profesores` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-19 10:24:23
