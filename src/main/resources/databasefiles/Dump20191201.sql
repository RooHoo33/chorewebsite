CREATE DATABASE  IF NOT EXISTS `users` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `users`;
-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: users
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `committee`
--

DROP TABLE IF EXISTS `committee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `committee` (
  `committee_entry_id` int(11) NOT NULL AUTO_INCREMENT,
  `committee_name` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`committee_entry_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `committee`
--

LOCK TABLES `committee` WRITE;
/*!40000 ALTER TABLE `committee` DISABLE KEYS */;
INSERT INTO `committee` VALUES (1,'maintenance',17);
/*!40000 ALTER TABLE `committee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `complete_chore_charts`
--

DROP TABLE IF EXISTS `complete_chore_charts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `complete_chore_charts` (
  `chore_chart_id` int(11) NOT NULL,
  `dishes_friday` varchar(255) DEFAULT NULL,
  `dishes_monday` varchar(255) DEFAULT NULL,
  `dishes_thursday` varchar(255) DEFAULT NULL,
  `dishes_tuesday` varchar(255) DEFAULT NULL,
  `dishes_wednesday` varchar(255) DEFAULT NULL,
  `large_dishes_friday` varchar(255) DEFAULT NULL,
  `large_dishes_monday` varchar(255) DEFAULT NULL,
  `large_dishes_thursday` varchar(255) DEFAULT NULL,
  `large_dishes_tuesday` varchar(255) DEFAULT NULL,
  `week_and_year` varchar(255) NOT NULL,
  `spykes_friday` varchar(255) DEFAULT NULL,
  `spykes_monday` varchar(255) DEFAULT NULL,
  `spykes_thursday` varchar(255) DEFAULT NULL,
  `spykes_tuesday` varchar(255) DEFAULT NULL,
  `spykes_wednesday` varchar(255) DEFAULT NULL,
  `sweep_friday` varchar(255) DEFAULT NULL,
  `sweep_monday` varchar(255) DEFAULT NULL,
  `sweep_thursday` varchar(255) DEFAULT NULL,
  `sweep_tuesday` varchar(255) DEFAULT NULL,
  `sweep_wednesday` varchar(255) DEFAULT NULL,
  `tables_up_friday` varchar(255) DEFAULT NULL,
  `tables_up_monday` varchar(255) DEFAULT NULL,
  `tables_up_thursday` varchar(255) DEFAULT NULL,
  `tables_up_tuesday` varchar(255) DEFAULT NULL,
  `tables_up_wednesday` varchar(255) DEFAULT NULL,
  `upper_quad_friday` varchar(255) DEFAULT NULL,
  `upper_quad_monday` varchar(255) DEFAULT NULL,
  `upper_quad_thursday` varchar(255) DEFAULT NULL,
  `upper_quad_tuesday` varchar(255) DEFAULT NULL,
  `upper_quad_wednesday` varchar(255) DEFAULT NULL,
  `large_dishes_wednesday` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`chore_chart_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `complete_chore_charts`
--

LOCK TABLES `complete_chore_charts` WRITE;
/*!40000 ALTER TABLE `complete_chore_charts` DISABLE KEYS */;
INSERT INTO `complete_chore_charts` VALUES (21,'Boo Associate','1400','1499','1399','1400','XXX','XXX','XXX','XXX','2019-W47','XXX','XXX','XXX','1499','XXX','Boo Associate','1399','1400','Boo Associate','1399','XXX','XXX','XXX','XXX','XXX','XXX','1499','XXX','XXX','XXX','XXX'),(22,'Boo Associate','1400','1499','1399','1400','XXX','XXX','XXX','XXX','2019-W47','XXX','XXX','XXX','1499','XXX','Boo Associate','1399','1400','Boo Associate','1399','XXX','XXX','XXX','XXX','XXX','XXX','1499','XXX','XXX','XXX','XXX'),(23,'1400','1400','1499','Boo Associate','1399','XXX','XXX','XXX','XXX','2019-W48','XXX','XXX','XXX','1499','XXX','1400','Boo Associate','1399','1399','Boo Associate','XXX','XXX','XXX','XXX','XXX','XXX','1499','XXX','XXX','XXX','XXX'),(24,'Boo Associate','1400','1499','1399','1400','XXX','XXX','XXX','XXX','2019-W48','XXX','XXX','XXX','1499','XXX','Boo Associate','1399','1400','Boo Associate','1399','XXX','XXX','XXX','XXX','XXX','XXX','1499','XXX','XXX','XXX','XXX');
/*!40000 ALTER TABLE `complete_chore_charts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (25);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `preferences`
--

DROP TABLE IF EXISTS `preferences`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `preferences` (
  `user_id` int(11) DEFAULT NULL,
  `preference_id` int(11) NOT NULL,
  `week_number` varchar(255) DEFAULT NULL,
  `chores_list` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`preference_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preferences`
--

LOCK TABLES `preferences` WRITE;
/*!40000 ALTER TABLE `preferences` DISABLE KEYS */;
INSERT INTO `preferences` VALUES (1,1,'1','1,2,0,0,0,0,2,7,0,0,0,0,3,8,0,0,0,0,4,9,0,0,0,0,5,10,0,0,0,0'),(3,2,'1','1,6,0,0,0,0,2,7,0,0,0,0,3,8,0,0,0,0,4,9,0,0,0,0,5,10,0,0,0,0'),(17,3,'1','1,6,0,0,0,0,2,7,0,4,0,0,3,8,0,0,0,0,4,9,0,0,0,0,5,10,0,0,0,0'),(18,4,'1','1,6,0,0,0,0,2,7,0,0,0,0,3,8,0,0,0,0,4,9,0,0,0,0,5,10,0,0,0,0'),(5,20,'2019-W47','1,6,0,0,0,0,2,7,0,0,0,0,3,8,0,0,0,0,4,9,0,0,0,0,5,10,0,0,0,0');
/*!40000 ALTER TABLE `preferences` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_and_id`
--

DROP TABLE IF EXISTS `user_and_id`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_and_id` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `kappa_sigma` int(11) DEFAULT '0',
  `brother` tinyint(1) DEFAULT '0',
  `password` varchar(255) DEFAULT NULL,
  `big` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_and_id`
--

LOCK TABLES `user_and_id` WRITE;
/*!40000 ALTER TABLE `user_and_id` DISABLE KEYS */;
INSERT INTO `user_and_id` VALUES (1,'notRightUserName','Bill','First',1400,1,'goodbye',2),(2,'user_name_thing','Fred','Second',1401,1,'hello',3),(3,'thirdUser','Boo','Associate',0,0,'hello2',4),(16,'form','asdf','asdflast',1450,1,'passwordForm',5),(17,'testAgain','third','notFourth',1499,1,'hello',6),(18,'test','test','test2',1399,1,'$2a$10$2h4mL/OgrDyTHUMjWmNqn.SWXlHcR70pXpHgzdxm20WLYb2wmktsm',1);
/*!40000 ALTER TABLE `user_and_id` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-01 11:12:07
