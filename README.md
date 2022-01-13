Οδηγίες εκτέλεσης προγράμματος με το docker & IntelliJIDEA

1. Κατεβάστε την εφαρμογή Docker 

<https://docs.docker.com/desktop/windows/install/>

1. Δημιουργήστε λογαριασμό στο Docker.
1. Ανοίξτε το command Promt και τρέξτε τις ακόλουθε εντολές.

**docker run --name mysqldb -p 3306:3306 -e MYSQL\_ROOT\_PASSWORD=students123 -d mysql**

Για να ελέγξεις ότι η εντολή του έτρεξε σωστά τρέξε την εντολή

**docker ps**

1. Κατεβάστε την εφαρμογή MYSQL

https://dev.mysql.com/downloads/mysql/

1. Δημιούργησε ένα Connection πατώντας το εικονίδιο +
1. Συμπλήρωσε τα στοιχεία που σου ζητούνται. Ο κωδικός είναι students123 και το username root.

1. Δημιούργησε ένα login\_db sheme. Με τις ακόλουθες εντολές

-- MySQL Workbench Forward EngineeringSET @OLD\_UNIQUE\_CHECKS=@@UNIQUE\_CHECKS, UNIQUE\_CHECKS=0;SET @OLD\_FOREIGN\_KEY\_CHECKS=@@FOREIGN\_KEY\_CHECKS, FOREIGN\_KEY\_CHECKS=0;SET @OLD\_SQL\_MODE=@@SQL\_MODE, SQL\_MODE='ONLY\_FULL\_GROUP\_BY,STRICT\_TRANS\_TABLES,NO\_ZERO\_IN\_DATE,NO\_ZERO\_DATE,ERROR\_FOR\_DIVISION\_BY\_ZERO,NO\_ENGINE\_SUBSTITUTION';-- ------------------------------------------------------- Schema mydb-- ------------------------------------------------------- ------------------------------------------------------- Schema login\_db-- ------------------------------------------------------- ------------------------------------------------------- Schema login\_db-- -----------------------------------------------------CREATE SCHEMA IF NOT EXISTS `login\_db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4\_0900\_ai\_ci ;USE `login\_db` ;-- ------------------------------------------------------- Table `login\_db`.`users`-- -----------------------------------------------------CREATE TABLE IF NOT EXISTS `login\_db`.`users` (  `user\_id` BIGINT NOT NULL AUTO\_INCREMENT,  `enabled` INT(1) NOT NULL,  `password` VARCHAR(255) NOT NULL,  `username` VARCHAR(255) NOT NULL,  PRIMARY KEY (`user\_id`),  UNIQUE INDEX `UK\_r43af9ap4edm43mmtq01oddj6` (`username` ASC) VISIBLE)ENGINE = InnoDBAUTO\_INCREMENT = 6DEFAULT CHARACTER SET = utf8mb4COLLATE = utf8mb4\_0900\_ai\_ci;-- ------------------------------------------------------- Table `login\_db`.`requests`-- -----------------------------------------------------CREATE TABLE IF NOT EXISTS `login\_db`.`requests` (  `id` BIGINT NOT NULL AUTO\_INCREMENT,  `purpose` VARCHAR(45) NOT NULL,  `status` VARCHAR(45) NOT NULL,  `receiver\_id` BIGINT NOT NULL,  `sender\_id` BIGINT NOT NULL,  PRIMARY KEY (`id`),  INDEX `FK8kh2eaehckhr55seyhe5k7vdy` (`receiver\_id` ASC) VISIBLE,  INDEX `FKg1js12lxokyqtj936eqv1mvmx` (`sender\_id` ASC) VISIBLE,  CONSTRAINT `FK8kh2eaehckhr55seyhe5k7vdy`    FOREIGN KEY (`receiver\_id`)    REFERENCES `login\_db`.`users` (`user\_id`),  CONSTRAINT `FKg1js12lxokyqtj936eqv1mvmx`    FOREIGN KEY (`sender\_id`)    REFERENCES `login\_db`.`users` (`user\_id`))ENGINE = InnoDBAUTO\_INCREMENT = 19DEFAULT CHARACTER SET = utf8mb4COLLATE = utf8mb4\_0900\_ai\_ci;-- ------------------------------------------------------- Table `login\_db`.`lessons`-- -----------------------------------------------------CREATE TABLE IF NOT EXISTS `login\_db`.`lessons` (  `lesson\_id` BIGINT NOT NULL AUTO\_INCREMENT,  `grade` VARCHAR(45) NOT NULL,  `name` VARCHAR(45) NOT NULL,  `semester` INT NOT NULL,  `requests\_id` BIGINT NOT NULL,  PRIMARY KEY (`lesson\_id`),  INDEX `FKksjm8u46p73j5mskyy61c5t93` (`requests\_id` ASC) VISIBLE,  CONSTRAINT `FKksjm8u46p73j5mskyy61c5t93`    FOREIGN KEY (`requests\_id`)    REFERENCES `login\_db`.`requests` (`id`))ENGINE = InnoDBAUTO\_INCREMENT = 7DEFAULT CHARACTER SET = utf8mb4COLLATE = utf8mb4\_0900\_ai\_ci;-- ------------------------------------------------------- Table `login\_db`.`recommendation\_letter`-- -----------------------------------------------------CREATE TABLE IF NOT EXISTS `login\_db`.`recommendation\_letter` (  `letter\_id` BIGINT NOT NULL AUTO\_INCREMENT,  `text` TEXT NOT NULL,  `requests\_id` BIGINT NOT NULL,  PRIMARY KEY (`letter\_id`),  INDEX `fk\_recommendationLetter\_requests1\_idx` (`requests\_id` ASC) VISIBLE,  CONSTRAINT `fk\_recommendationLetter\_requests1`    FOREIGN KEY (`requests\_id`)    REFERENCES `login\_db`.`requests` (`id`)    ON DELETE NO ACTION    ON UPDATE NO ACTION)ENGINE = InnoDBDEFAULT CHARACTER SET = utf8mb4COLLATE = utf8mb4\_0900\_ai\_ci;-- ------------------------------------------------------- Table `login\_db`.`roles`-- -----------------------------------------------------CREATE TABLE IF NOT EXISTS `login\_db`.`roles` (  `role\_id` INT NOT NULL AUTO\_INCREMENT,  `name` VARCHAR(255) NOT NULL,  PRIMARY KEY (`role\_id`))ENGINE = InnoDBAUTO\_INCREMENT = 4DEFAULT CHARACTER SET = utf8mb4COLLATE = utf8mb4\_0900\_ai\_ci;-- ------------------------------------------------------- Table `login\_db`.`users\_roles`-- -----------------------------------------------------CREATE TABLE IF NOT EXISTS `login\_db`.`users\_roles` (  `user\_id` BIGINT NOT NULL,  `role\_id` INT NOT NULL,  PRIMARY KEY (`user\_id`, `role\_id`),  INDEX `FKj6m8fwv7oqv74fcehir1a9ffy` (`role\_id` ASC) VISIBLE,  CONSTRAINT `FK2o0jvgh89lemvvo17cbqvdxaa`    FOREIGN KEY (`user\_id`)    REFERENCES `login\_db`.`users` (`user\_id`),  CONSTRAINT `FKj6m8fwv7oqv74fcehir1a9ffy`    FOREIGN KEY (`role\_id`)    REFERENCES `login\_db`.`roles` (`role\_id`))ENGINE = InnoDBDEFAULT CHARACTER SET = utf8mb4COLLATE = utf8mb4\_0900\_ai\_ci;SET SQL\_MODE=@OLD\_SQL\_MODE;SET FOREIGN\_KEY\_CHECKS=@OLD\_FOREIGN\_KEY\_CHECKS;SET UNIQUE\_CHECKS=@OLD\_UNIQUE\_CHECKS;use login\_db;insert into users (user\_id,username,password,enabled) values ('1','admin@gmail.com','$2a$12$jsvf6S4wD3MexUJDdFaaKOJDNtaMn57BICEQ65y7uxX8fBP/gIPe.',1);insert into users (user\_id,username,password,enabled) values ('2','student@gmail.com','$2a$12$wmpePALL618K9K1PnsQw9u12zBkzb2namL60yRAmCB3hPlnChTptu',1);insert into users (user\_id,username,password,enabled) values ('3','teacher@gmail.com','$2a$12$jsvf6S4wD3MexUJDdFaaKOJDNtaMn57BICEQ65y7uxX8fBP/gIPe.',1);insert into roles(role\_id,name) values ('1','ADMIN');insert into roles (role\_id,name) values ('2','STUDENT');insert into roles (role\_id,name) values ('3','TEACHER');insert into users\_roles values('1','1');insert into users\_roles values('2','2');insert into users\_roles values('3','3');

1. Κατέβασε τον κώδικα από τον gitHub.


1. Σύνδεσε το πρόγραμμα με την login\_db βάση.


O κωδικός είναι: students123

User : root

Database :login\_db


1. Φροντίστε ότι το docker mysqldb τρέχει κανονικά και τρέξτε τον κωδικά.


Στην βάση υπάρχουν 3 defualt users με 3 διαφορετικούς ρόλους. Δοκιμάστε να τρέξετε το πρόγραμμα με τα στοιχεία τους. Στο login ο κωδικός τους είναι 123 και το username <admin@gmail.com>, <student@gmail.com> , <teacher@gmail.com>


