 CREATE TABLE IF NOT EXISTS `citizens` (
 `id` int(6) NOT NULL AUTO_INCREMENT,
 `name` varchar(30) NOT NULL,
 `lastName` varchar(30) NOT NULL,
 `birthDate` DATE,
 `homeAddress` varchar(30) NOT NULL,
 `documentNumber` varchar(12) NOT NULL,
 `documentType` varchar(12) NOT NULL,
 `documentCreatedDate` date,
 `documentExpiredDate` date, 
 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;