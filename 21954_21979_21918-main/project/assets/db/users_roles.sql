SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema login_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema login_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `login_db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `login_db` ;

drop table users_roles;
drop table roles;
drop table Lessons;
drop table requests;
drop table users;

-- -----------------------------------------------------
-- Table `login_db`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `login_db`.`users` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(60) NOT NULL,
  `enabled` INT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `login_db`.`requests`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `login_db`.`requests` (
  `id_request` INT NOT NULL AUTO_INCREMENT,
  `purpose` VARCHAR(45) NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  `sender_id` INT NOT NULL,
  `receiver_id` INT NOT NULL,
  PRIMARY KEY (`id_request`),
  INDEX `fk_requests_users2_idx` (`sender_id` ASC) VISIBLE,
  INDEX `fk_requests_users1_idx` (`receiver_id` ASC) VISIBLE,
  CONSTRAINT `fk_requests_users1`
    FOREIGN KEY (`receiver_id`)
    REFERENCES `login_db`.`users` (`user_id`),
  CONSTRAINT `fk_requests_users2`
    FOREIGN KEY (`sender_id`)
    REFERENCES `login_db`.`users` (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `login_db`.`lessons`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `login_db`.`lessons` (
  `lesson_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `grade` VARCHAR(45) NOT NULL,
  `requests_id` INT NOT NULL,
  PRIMARY KEY (`lesson_id`),
  INDEX `fk_lessons_requests1_idx` (`requests_id` ASC) VISIBLE,
  CONSTRAINT `fk_lessons_requests1`
    FOREIGN KEY (`requests_id`)
    REFERENCES `login_db`.`requests` (`id_request`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `login_db`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `login_db`.`roles` (
  `role_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`role_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `login_db`.`users_roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `login_db`.`users_roles` (
  `user_id` INT NOT NULL,
  `role_id` INT NOT NULL,
  INDEX `fk_users_roles_users_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_users_roles_roles1_idx` (`role_id` ASC) VISIBLE,
  CONSTRAINT `fk_users_roles_roles1`
    FOREIGN KEY (`role_id`)
    REFERENCES `login_db`.`roles` (`role_id`),
  CONSTRAINT `fk_users_roles_users`
    FOREIGN KEY (`user_id`)
    REFERENCES `login_db`.`users` (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


use login_db;
insert into users values ('1','test@gmail.com','$2a$12$jsvf6S4wD3MexUJDdFaaKOJDNtaMn57BICEQ65y7uxX8fBP/gIPe.',1);
insert into users values ('2','student@gmail.com','$2a$12$jsvf6S4wD3MexUJDdFaaKOJDNtaMn57BICEQ65y7uxX8fBP/gIPe.',1);
insert into users values ('3','teacher@gmail.com','$2a$12$jsvf6S4wD3MexUJDdFaaKOJDNtaMn57BICEQ65y7uxX8fBP/gIPe.',1);


insert into roles values ('1','ADMIN');
insert into roles values ('2','STUDENT');
insert into roles values ('3','TEACHER');

insert into users_roles values('1','1');
insert into users_roles values('2','2');
insert into users_roles values('3','3');

insert into requests values (1,'online','for JOB',2,3);

select * from users;
select * from requests;
