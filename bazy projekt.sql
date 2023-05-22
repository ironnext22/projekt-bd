-- MariaDB dump 10.19  Distrib 10.4.25-MariaDB, for Win64 (AMD64)
--
-- Host: 127.0.0.1    Database: bazaprojekt
-- ------------------------------------------------------
-- Server version	10.4.25-MariaDB

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
-- Table structure for table `aktor`
--

DROP TABLE IF EXISTS `aktor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aktor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `imie` varchar(100) DEFAULT NULL,
  `nazwisko` varchar(100) DEFAULT NULL,
  `narodowość` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aktor`
--

LOCK TABLES `aktor` WRITE;
/*!40000 ALTER TABLE `aktor` DISABLE KEYS */;
INSERT INTO `aktor` VALUES (1,'Robert','Downey Jr.','USA'),(2,'Christian','Bale','Wielka Brytania'),(3,'Chris','Evans','USA'),(4,'Josequin','Phoenix','Portoryko'),(5,'Jack','Nicholson','USA'),(6,'Leonardo','DiCaprio','USA'),(7,'Al','Pacino','USA'),(8,'Alan','Rickman','Wielka Brytania'),(9,'Johnny','Depp','USA'),(10,'Ian','McKellen','Wielka Brytania'),(11,'Daniel','Radcliffe','Wielka Brytania');
/*!40000 ALTER TABLE `aktor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `filmy`
--

DROP TABLE IF EXISTS `filmy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `filmy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tytul` varchar(100) DEFAULT NULL,
  `reżyser` int(11) DEFAULT NULL,
  `gatunek` int(11) DEFAULT NULL,
  `wytwórnia` int(11) DEFAULT NULL,
  `główna_rola` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `reżyser` (`reżyser`),
  KEY `główna_rola` (`główna_rola`),
  KEY `wytwórnia` (`wytwórnia`),
  KEY `gatunek` (`gatunek`),
  CONSTRAINT `gatunek` FOREIGN KEY (`gatunek`) REFERENCES `gatunek` (`id`),
  CONSTRAINT `główna_rola` FOREIGN KEY (`główna_rola`) REFERENCES `aktor` (`id`),
  CONSTRAINT `reżyser` FOREIGN KEY (`reżyser`) REFERENCES `reżyser` (`id`),
  CONSTRAINT `wytwórnia` FOREIGN KEY (`wytwórnia`) REFERENCES `wytwórnia` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `filmy`
--

LOCK TABLES `filmy` WRITE;
/*!40000 ALTER TABLE `filmy` DISABLE KEYS */;
INSERT INTO `filmy` VALUES (1,'Iron Man',1,1,1,1),(5,'Batman: Początek',2,1,2,2),(6,'Iron Man 2',1,1,1,1),(7,'Iron Man 3',1,1,1,1),(8,'Hobbit: Niezwykła Podróż',6,2,2,10),(9,'Harry Potter i Kamień Filozoficzny',8,2,2,11),(10,'Harry Potter i Komnata Tajemnic',8,2,2,11),(11,'Harry Potter i Więzień Azkabanu',8,2,2,11);
/*!40000 ALTER TABLE `filmy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `filmy2`
--

DROP TABLE IF EXISTS `filmy2`;
/*!50001 DROP VIEW IF EXISTS `filmy2`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `filmy2` (
  `id` tinyint NOT NULL,
  `tytul` tinyint NOT NULL,
  `gatunek` tinyint NOT NULL,
  `reżyser` tinyint NOT NULL,
  `wytwórnia` tinyint NOT NULL,
  `rola_główna` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `filmyl`
--

DROP TABLE IF EXISTS `filmyl`;
/*!50001 DROP VIEW IF EXISTS `filmyl`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `filmyl` (
  `tytul` tinyint NOT NULL,
  `gatunek` tinyint NOT NULL,
  `reżyser` tinyint NOT NULL,
  `wytwórnia` tinyint NOT NULL,
  `rola_główna` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `gatunek`
--

DROP TABLE IF EXISTS `gatunek`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gatunek` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nazwa` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `gatunek_pk` (`nazwa`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gatunek`
--

LOCK TABLES `gatunek` WRITE;
/*!40000 ALTER TABLE `gatunek` DISABLE KEYS */;
INSERT INTO `gatunek` VALUES (1,'Akcji'),(12,'Anime'),(7,'Dramat'),(2,'Fantasy'),(8,'Horror'),(11,'Kryminał'),(10,'Romans'),(6,'Sci-fi'),(9,'Thriller');
/*!40000 ALTER TABLE `gatunek` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `kara`
--

DROP TABLE IF EXISTS `kara`;
/*!50001 DROP VIEW IF EXISTS `kara`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `kara` (
  `tytul` tinyint NOT NULL,
  `klient` tinyint NOT NULL,
  `pesel` tinyint NOT NULL,
  `data_wypożyczenia` tinyint NOT NULL,
  `data_zwrotu` tinyint NOT NULL,
  `dni_wypożyczenia` tinyint NOT NULL,
  `po_terminie` tinyint NOT NULL,
  `kara` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `klienci`
--

DROP TABLE IF EXISTS `klienci`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `klienci` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `imie` varchar(100) DEFAULT NULL,
  `nazwisko` varchar(100) DEFAULT NULL,
  `pesel` mediumtext NOT NULL,
  `adres` varchar(100) DEFAULT NULL,
  `kod_pocztowy` varchar(6) DEFAULT NULL,
  `miejscowość` varchar(100) DEFAULT NULL,
  `nr_telefonu` int(11) DEFAULT NULL,
  `mail` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `klienci`
--

LOCK TABLES `klienci` WRITE;
/*!40000 ALTER TABLE `klienci` DISABLE KEYS */;
INSERT INTO `klienci` VALUES (1,'Wiktor','Kowalski','33333333333','ul. Warszawska','30-000','Kraków',300300300,'aaa@gmail.com'),(2,'Mateusz','Maź','22222222222','ul. Poznańska 60','30-300','Kraków',666666666,'bbb@gmail.com'),(3,'Kacper','Filipek','11111111111','ul. Poznańska 20','30-300','Kraków',222222222,'ccc@gmail.com');
/*!40000 ALTER TABLE `klienci` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reżyser`
--

DROP TABLE IF EXISTS `reżyser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reżyser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Imie` varchar(100) DEFAULT NULL,
  `nazwisko` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reżyser`
--

LOCK TABLES `reżyser` WRITE;
/*!40000 ALTER TABLE `reżyser` DISABLE KEYS */;
INSERT INTO `reżyser` VALUES (1,'Jon','Favreau'),(2,'Christopher','Nolan'),(3,'Joe','Johnston'),(4,'Steven','Spielberg'),(5,'Darren','Aronofsky'),(6,'Peter','Jackson'),(7,'Quentin','Tarantino'),(8,'Chris','Columbus'),(9,'James','Gunn');
/*!40000 ALTER TABLE `reżyser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wypożyczenia`
--

DROP TABLE IF EXISTS `wypożyczenia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wypożyczenia` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `film` int(11) DEFAULT NULL,
  `klient` int(11) DEFAULT NULL,
  `data_wypożyczenia` date DEFAULT NULL,
  `długość` int(11) DEFAULT NULL,
  `cena` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `klient` (`klient`),
  KEY `filmy` (`film`),
  CONSTRAINT `filmy` FOREIGN KEY (`film`) REFERENCES `filmy` (`id`),
  CONSTRAINT `klient` FOREIGN KEY (`klient`) REFERENCES `klienci` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wypożyczenia`
--

LOCK TABLES `wypożyczenia` WRITE;
/*!40000 ALTER TABLE `wypożyczenia` DISABLE KEYS */;
INSERT INTO `wypożyczenia` VALUES (1,1,1,'2023-05-20',7,50),(2,5,2,'2023-05-21',7,25),(3,9,3,'2023-05-21',5,20),(4,8,1,'2023-05-21',4,16);
/*!40000 ALTER TABLE `wypożyczenia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wytwórnia`
--

DROP TABLE IF EXISTS `wytwórnia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wytwórnia` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nazwa` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `wytwórnia_pk` (`nazwa`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wytwórnia`
--

LOCK TABLES `wytwórnia` WRITE;
/*!40000 ALTER TABLE `wytwórnia` DISABLE KEYS */;
INSERT INTO `wytwórnia` VALUES (5,'20th Century Studios'),(6,'Columbia Pictures'),(1,'Marvel Studios'),(4,'Universal'),(7,'Walt Disney Pictures'),(2,'Worner Bros.');
/*!40000 ALTER TABLE `wytwórnia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zwroty`
--

DROP TABLE IF EXISTS `zwroty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zwroty` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `wypożyczenie` int(11) DEFAULT NULL,
  `data_zwrotu` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `wypożyczenie` (`wypożyczenie`),
  CONSTRAINT `wypożyczenie` FOREIGN KEY (`wypożyczenie`) REFERENCES `wypożyczenia` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zwroty`
--

LOCK TABLES `zwroty` WRITE;
/*!40000 ALTER TABLE `zwroty` DISABLE KEYS */;
INSERT INTO `zwroty` VALUES (1,1,'2023-05-28'),(2,3,'2023-05-21');
/*!40000 ALTER TABLE `zwroty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `filmy2`
--

/*!50001 DROP TABLE IF EXISTS `filmy2`*/;
/*!50001 DROP VIEW IF EXISTS `filmy2`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `filmy2` AS select `filmy`.`id` AS `id`,`filmy`.`tytul` AS `tytul`,`gatunek`.`nazwa` AS `gatunek`,concat(`reżyser`.`Imie`,' ',`reżyser`.`nazwisko`) AS `reżyser`,`wytwórnia`.`nazwa` AS `wytwórnia`,concat(`aktor`.`imie`,' ',`aktor`.`nazwisko`) AS `rola_główna` from ((((`filmy` join `reżyser` on(`filmy`.`reżyser` = `reżyser`.`id`)) join `gatunek` on(`filmy`.`gatunek` = `gatunek`.`id`)) join `aktor` on(`filmy`.`główna_rola` = `aktor`.`id`)) join `wytwórnia` on(`filmy`.`wytwórnia` = `wytwórnia`.`id`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `filmyl`
--

/*!50001 DROP TABLE IF EXISTS `filmyl`*/;
/*!50001 DROP VIEW IF EXISTS `filmyl`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `filmyl` AS select `filmy`.`tytul` AS `tytul`,`gatunek`.`nazwa` AS `gatunek`,concat(`reżyser`.`Imie`,' ',`reżyser`.`nazwisko`) AS `reżyser`,`wytwórnia`.`nazwa` AS `wytwórnia`,concat(`aktor`.`imie`,' ',`aktor`.`nazwisko`) AS `rola_główna` from ((((`filmy` join `reżyser` on(`filmy`.`reżyser` = `reżyser`.`id`)) join `gatunek` on(`filmy`.`gatunek` = `gatunek`.`id`)) join `aktor` on(`filmy`.`główna_rola` = `aktor`.`id`)) join `wytwórnia` on(`filmy`.`wytwórnia` = `wytwórnia`.`id`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `kara`
--

/*!50001 DROP TABLE IF EXISTS `kara`*/;
/*!50001 DROP VIEW IF EXISTS `kara`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `kara` AS select `filmy`.`tytul` AS `tytul`,concat(`klienci`.`imie`,' ',`klienci`.`nazwisko`) AS `klient`,`klienci`.`pesel` AS `pesel`,`wypożyczenia`.`data_wypożyczenia` AS `data_wypożyczenia`,`zwroty`.`data_zwrotu` AS `data_zwrotu`,to_days(`zwroty`.`data_zwrotu`) - to_days(`wypożyczenia`.`data_wypożyczenia`) AS `dni_wypożyczenia`,to_days(`zwroty`.`data_zwrotu`) - to_days(`wypożyczenia`.`data_wypożyczenia`) - `wypożyczenia`.`długość` AS `po_terminie`,(to_days(`zwroty`.`data_zwrotu`) - to_days(`wypożyczenia`.`data_wypożyczenia`) - `wypożyczenia`.`długość`) * 15 AS `kara` from (((`zwroty` join `wypożyczenia` on(`zwroty`.`wypożyczenie` = `wypożyczenia`.`id`)) join `filmy` on(`wypożyczenia`.`film` = `filmy`.`id`)) join `klienci` on(`klienci`.`id` = `wypożyczenia`.`klient`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-22 11:09:54

create
    definer = root@localhost procedure filmy()
begin
    drop view if exists filmyl;
    create view filmyl as SELECT tytul, gatunek.nazwa as gatunek, CONCAT(reżyser.Imie,' ',reżyser.nazwisko) as reżyser , wytwórnia.nazwa as wytwórnia, CONCAT(aktor.imie,' ',aktor.nazwisko) as rola_główna  from filmy
    inner join reżyser on filmy.reżyser = reżyser.id
    inner join gatunek on filmy.gatunek = gatunek.id
    inner join aktor on filmy.główna_rola = aktor.id
    inner join wytwórnia on filmy.wytwórnia = wytwórnia.id;
end;

create
    definer = root@localhost procedure filmy2()
begin
    drop view if exists filmy2;
    create view filmy2 as SELECT filmy.id,tytul, gatunek.nazwa as gatunek, CONCAT(reżyser.Imie,' ',reżyser.nazwisko) as reżyser , wytwórnia.nazwa as wytwórnia, CONCAT(aktor.imie,' ',aktor.nazwisko) as rola_główna  from filmy
    inner join reżyser on filmy.reżyser = reżyser.id
    inner join gatunek on filmy.gatunek = gatunek.id
    inner join aktor on filmy.główna_rola = aktor.id
    inner join wytwórnia on filmy.wytwórnia = wytwórnia.id;
end;

create
    definer = root@localhost procedure kary()
begin
    drop view if exists kara;
    create view kara as SELECT filmy.tytul,concat(klienci.imie,' ',klienci.nazwisko) as klient,klienci.pesel as pesel, wypożyczenia.data_wypożyczenia, zwroty.data_zwrotu, DATEDIFF(zwroty.data_zwrotu,wypożyczenia.data_wypożyczenia) as dni_wypożyczenia, (DATEDIFF(zwroty.data_zwrotu,wypożyczenia.data_wypożyczenia)-wypożyczenia.długość) as po_terminie,
    (DATEDIFF(zwroty.data_zwrotu,wypożyczenia.data_wypożyczenia)-wypożyczenia.długość)*15 as kara from zwroty
    inner join wypożyczenia on zwroty.wypożyczenie=wypożyczenia.id
    inner join filmy on wypożyczenia.film = filmy.id
    inner join klienci on   klienci.id = wypożyczenia.klient;
end;


create
    definer = root@localhost procedure klienci()
begin
    SELECT CONCAT(imie,' ',nazwisko) as klient,adres,kod_pocztowy,miejscowość,nr_telefonu,mail from klienci;
end;



create
    definer = root@localhost procedure klienci2()
begin
    SELECT klienci.id,CONCAT(imie,' ',nazwisko) as klient,adres,kod_pocztowy,miejscowość,nr_telefonu,mail from klienci;
end;

create
    definer = root@localhost procedure wypożyczenia()
begin
    SELECT filmy.tytul,CONCAT(klienci.imie,' ',klienci.nazwisko) as klient, data_wypożyczenia, długość, cena from wypożyczenia
    inner join filmy on wypożyczenia.film = filmy.id
    inner join klienci on wypożyczenia.klient = klienci.id;
end;

create
    definer = root@localhost procedure wypożyczenia2()
begin
    SELECT wypożyczenia.id,filmy.tytul,CONCAT(klienci.imie,' ',klienci.nazwisko) as klient, data_wypożyczenia, długość, cena from wypożyczenia
    inner join filmy on wypożyczenia.film = filmy.id
    inner join klienci on wypożyczenia.klient = klienci.id;
end;

