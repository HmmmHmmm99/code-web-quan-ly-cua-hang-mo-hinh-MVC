-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: ecom_spring
-- ------------------------------------------------------
-- Server version	5.7.30-log

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES ('cong','cong'),('han','han'),('ncc24319@gmail.com',NULL),('nguyenchi.dev@gmail.com',NULL),('vohinh2431999@gmail.com',NULL),('nguyenchicong@gmail.com','congnguyen');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(50) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `category_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (7,'camera category description',_binary '','Camera'),(3,'tesss',_binary '\0','Clothes'),(4,'tessss',_binary '','Electonic'),(6,'book category description',_binary '','Book');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(250) DEFAULT NULL,
  `path` varchar(250) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `title` varchar(250) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2n9w8d0dp4bsfra9dcg0046l4` (`category_id`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (1,';lll','kindle.png',0.2,3,'book1',3),(4,'#camera','8.jpg',1232.9,9,'Camara Canon EOS R3',4),(5,'sony camera','f3.jpg',2001.9,11,'Camera Sony A6300',4),(8,'Andre Aciman\'s Call Me by Your Name','98fbb7ffdcccb5d6679b9818e8a27e6b.jpg',13.6,17,'Call Me By Your Name ',6),(9,'Sherlock Holmes by Conan Doyle.','img930_2.jpg',23.5,21,'Sherlock Holmes Series',6),(11,'You want to learn about the patterns that matter--why to use them, when to use them, how to use them (and when NOT to use them). But you don\'t just want to see how patterns look in a book, you want to know how they look \"in the wild\".','91bobQSPQrL.jpg',19.9,17,'Head First Design Patterns',6),(12,'This textbook presents 42 design patterns, including 23 GoF patterns. Categories include: Basic, Creational, Collectional, Structural, Behavioral, and Concurrency, with multiple examples for each','images.jpg',21.1,9,'Software Architecture Design Patterns in Java',6),(13,'The authors begin by describing what patterns are and how they can help you design object-oriented software. They then go on to systematically name, explain, evaluate, and catalog recurring designs in object-oriented systems','51szD9HC9pL._SX395_BO1,204,203,200_.jpg',14.9,11,'Design Patterns: Elements of Reusable Object-Oriented Software',6),(14,'Dual beamforming microphones, Dual optical sensors, Motion-detecting accelerometer, Speech-detecting accelerometer','71zny7BTRlL._AC_SL1500_.jpg',249.7,5,'Apple AirPods Pro',4),(15,'Li-Po 9720 mAh, non-removable (36.71 Wh)\r\nCharging	Reverse charging\r\nFast charging 18W','815ztYEEwYL._AC_SL1500_.jpg',797.1,4,'2020 Apple iPad Pro (11-inch, Wi-Fi, 256GB)',4),(17,'100% Polyester\r\nImported\r\nNeeds Update\r\nNeeds Update','71hxO4ApQYL._AC_SL1500_.jpg',18.1,7,'Jack Wolfskin Men\'s Light Valley Shirt',3),(18,'The Wrangler authentic short sleeve classic fit woven shirt is made from 100 percent cotton and is the perfect staple for any guy','35bbe0001c2490cfba996527debfaa11.jpg',19.9,6,'Wrangler Authentics Men\'s Short Sleeve Classic Woven Shirt',3);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `username` varchar(50) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `fullname` varchar(50) DEFAULT NULL,
  `gender` bit(1) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-24  0:34:42
