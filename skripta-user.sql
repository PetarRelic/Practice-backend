USE `vezba`;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL UNIQUE,
  `username` varchar(50) NOT NULL,
  `password` char(68) NOT NULL,
  `enabled` boolean NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `users` 
VALUES 
(1,'admin','test123',true);

