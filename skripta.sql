CREATE DATABASE  IF NOT EXISTS `vezba`;
USE `vezba`;

--
-- Table structure for table `cities`
--
DROP TABLE IF EXISTS `studenti`;
DROP TABLE IF EXISTS `gradovi`;
CREATE TABLE `gradovi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(50) NOT NULL,
  `update_time_utc` bigint,
  `update_by_username` varchar(200),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `gradovi`
--

INSERT INTO `gradovi` 
VALUES 
(1,'Beograd', null, null),
(2,'Novi Sad', null, null);


--
-- Table structure for table `studenti`
--


CREATE TABLE `studenti` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(50) NOT NULL,
  `prezime` varchar(68) NOT NULL,
  `datum_rodjenja` date NOT NULL,
  `gradID` int(11) NOT NULL,
  `update_time_utc` bigint,
  `update_by_username` varchar(200),
  PRIMARY KEY (`id`),
  FOREIGN KEY (`gradID`) REFERENCES `gradovi` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `studenti` 
VALUES 
(1,'Petar','Relic','1993-11-01',1, null, null),
(2,'Petar2','Relic2','1993-11-01',1, null, null),
(3,'Petar3','Relic3','1993-11-01',2, null, null);

