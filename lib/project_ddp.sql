-- MariaDB dump 10.19  Distrib 10.9.4-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: project_ddp
-- ------------------------------------------------------
-- Server version	10.9.4-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `project_ddp`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `project_ddp` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;

USE `project_ddp`;

--
-- Table structure for table `akun`
--

DROP TABLE IF EXISTS `akun`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `akun` (
  `email` varchar(70) NOT NULL,
  `pass` varchar(50) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `alamat` varchar(70) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `akun`
--

LOCK TABLES `akun` WRITE;
/*!40000 ALTER TABLE `akun` DISABLE KEYS */;
INSERT INTO `akun` VALUES
('choir@gmail.com','passwd','fatihul choir','Jember'),
('daffa@gmail.com','khardoang','daffa malik ak','ciputat'),
('isna@gmail.com','password','Dede Isna','Planet Bekasi'),
('mohammed@gmail.com','oskhar.','Mohammed Nashwan','Yaman Selatan'),
('oskhar@gmail.com','khardoang','Muhamad Oskhar Muabrok','Jakarta Barat'),
('tanjung@gmail.com','tjng123','Tanjung Arswendo','Sumatera Selatan');
/*!40000 ALTER TABLE `akun` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `minuman`
--

DROP TABLE IF EXISTS `minuman`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `minuman` (
  `img` varchar(40) NOT NULL,
  `name` varchar(70) NOT NULL,
  `rate` varchar(5) NOT NULL,
  `harga` varchar(30) NOT NULL,
  PRIMARY KEY (`img`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `minuman`
--

LOCK TABLES `minuman` WRITE;
/*!40000 ALTER TABLE `minuman` DISABLE KEYS */;
INSERT INTO `minuman` VALUES
('m1.png','<html>JAVA<br>CHIP</html>','4.3','60000'),
('m2.png','<html>RASBERRY<br>SHAKEN</html>','4.4','60000'),
('m3.png','<html>MANGGO<br>PASSION</html>','4.9','60000'),
('m4.png','<html>GREEN<br>TEA</html>','4.1','60000'),
('m5.png','<html>MOCHA<br>PRALINE</html>','4.8','60000'),
('m6.png','<html>BLUEBERRY<br>MUFIN</html>','4.5','60000'),
('m7.png','<html>DARK<br>MOCHA</html>','4.2','60000'),
('m8.png','<html>CARAMEL<br>MACCHIATO</html>','4','60000');
/*!40000 ALTER TABLE `minuman` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `riwayat`
--

DROP TABLE IF EXISTS `riwayat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `riwayat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(70) NOT NULL,
  `alamat` varchar(70) NOT NULL,
  `hargaTot` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `riwayat`
--

LOCK TABLES `riwayat` WRITE;
/*!40000 ALTER TABLE `riwayat` DISABLE KEYS */;
INSERT INTO `riwayat` VALUES
(1,'Muhamad Oskhar Muabrok','Jakarta Barat','720000'),
(2,'Muhamad Oskhar Muabrok','Jakarta Barat','840000'),
(3,'Muhamad Oskhar Muabrok','Jakarta Barat','120000'),
(4,'Muhamad Oskhar Muabrok','Jakarta Barat','120000'),
(5,'Muhamad Oskhar Muabrok','Jakarta Barat','60000');
/*!40000 ALTER TABLE `riwayat` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-11  6:53:36
