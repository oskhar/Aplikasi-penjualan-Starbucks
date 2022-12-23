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
('','oskhar','',''),
('aidil@gmail.com','pass12','aidil riyan','cinere'),
('choir@gmail.com','passwd','fatihul choir','Jember'),
('daffa@gmail.com','khardoang','daffa malik ak','ciputat'),
('fajargans@gmail.com','fajar aja','fajar ganefi','pamulang'),
('isna@gmail.com','password','Dede Isna','Planet Bekasi'),
('mohammed@gmail.com','oskhar12','Mohammed Nashwan','Yaman Selatan'),
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
  `qty` varchar(6) NOT NULL,
  `penjualan` varchar(6) NOT NULL,
  PRIMARY KEY (`img`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `minuman`
--

LOCK TABLES `minuman` WRITE;
/*!40000 ALTER TABLE `minuman` DISABLE KEYS */;
INSERT INTO `minuman` VALUES
('m1.png','<html>JAVA<br>CHIP</html>','4.3','58000','60','0'),
('m2.png','<html>RASBERRY<br>SHAKEN</html>','4.4','42000','40','0'),
('m3.png','<html>MANGGO<br>PASSION</html>','4.9','45000','40','0'),
('m4.png','<html>GREEN<br>TEA</html>','4.1','55000','35','0'),
('m5.png','<html>MOCHA<br>PRALINE</html>','4.8','53000','35','0'),
('m6.png','<html>BLUEBERRY<br>MUFIN</html>','4.5','45000','30','0'),
('m7.png','<html>DARK<br>MOCHA</html>','4.2','58000','30','0'),
('m8.png','<html>CARAMEL<br>MACCHIATO</html>','4','53000','25','0');
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
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `riwayat`
--

LOCK TABLES `riwayat` WRITE;
/*!40000 ALTER TABLE `riwayat` DISABLE KEYS */;
INSERT INTO `riwayat` VALUES
(65,'Dede Isna','Planet Bekasi','156000'),
(66,'Muhamad Oskhar Muabrok','Jakarta Barat','45000'),
(67,'Muhamad Oskhar Muabrok','Jakarta Barat','58000'),
(68,'Dede Isna','Planet Bekasi','42000');
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

-- Dump completed on 2022-12-23 23:15:17
