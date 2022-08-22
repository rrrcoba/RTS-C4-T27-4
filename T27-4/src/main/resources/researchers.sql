use heroku_c32affd8800ea8e;

DROP TABLE IF EXISTS `reservations`;
DROP TABLE IF EXISTS `researchers`;
DROP TABLE IF EXISTS `teams`;
DROP TABLE IF EXISTS `faculties`;

CREATE TABLE `faculties` (
  `id` int NOT NULL auto_increment,
  `name` nvarchar(255) NOT NULL,
  PRIMARY KEY (`id`)
);
INSERT INTO `faculties` (`name`) VALUES ('Hogwarts') , ('Wartshog') , ('Reus');

CREATE TABLE `researchers` (
  `id` int NOT NULL auto_increment,
  `DNI` nvarchar(9) NOT NULL,
  `name_surname` nvarchar(255) NOT NULL,
  `faculty` int NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `researchers_ibfk_1` FOREIGN KEY (`faculty`) REFERENCES `faculties` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);
INSERT INTO `researchers` (`DNI`,`name_surname`,`faculty`) VALUES ('11111111A','Pepito','1') , ('22222222B','Pepi','11') , ('33333333C','Estallo Viendo','21');

CREATE TABLE `teams` (
  `id` int NOT NULL auto_increment,
  `name` nvarchar(255) NOT NULL,
  `faculty` int NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `teams_ibfk_1` FOREIGN KEY (`faculty`) REFERENCES `faculties` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);
INSERT INTO `teams` (`name`,`faculty`) VALUES ('Omega','1') , ('Alpha','11') , ('Betta', '21');

CREATE TABLE `reservations` (
  `id` int NOT NULL auto_increment,
  `id_researcher` int NOT NULL,
  `id_team` int NOT NULL,
  `start` dateTime NOT NULL,
  `finish` dateTime NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `reservations_ibfk_1` FOREIGN KEY (`id_researcher`) REFERENCES `researchers` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `reservations_ibfk_2` FOREIGN KEY (`id_team`) REFERENCES `teams` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);
INSERT INTO `reservations` (`id_researcher`, `id_team`,`start`,`finish`) VALUES ('1','1','2022-08-17','2022-08-17') , ('11','11','2022-08-17','2022-08-17') , ('21','21','2022-08-17','2022-08-17');

commit;