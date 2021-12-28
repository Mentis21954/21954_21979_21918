CREATE SCHEMA IF NOT EXISTS `login_db` DEFAULT CHARACTER SET utf8 ;
USE `login_db` ;

-- -----------------------------------------------------
-- Table `login_db`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `login_db`.`users` (
  `user_id` INT(11) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(60) NOT NULL,
  `enabled` TINYINT(1) NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `login_db`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `login_db`.`roles` (
  `role_id` INT(11) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`role_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `login_db`.`users_roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `login_db`.`users_roles` (
  `user_id` INT(11) NOT NULL,
  `role_id` INT NOT NULL,
  INDEX `fk_users_roles_users_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_users_roles_roles1_idx` (`role_id` ASC) VISIBLE,
  CONSTRAINT `fk_users_roles_users`
    FOREIGN KEY (`user_id`)
    REFERENCES `login_db`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_users_roles_roles1`
    FOREIGN KEY (`role_id`)
    REFERENCES `login_db`.`roles` (`role_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


use login_db;
insert into users values ('1','test@gmail.com','$2a$12$jsvf6S4wD3MexUJDdFaaKOJDNtaMn57BICEQ65y7uxX8fBP/gIPe.',0);
insert into users values ('2','student@gmail.com','$2a$12$jsvf6S4wD3MexUJDdFaaKOJDNtaMn57BICEQ65y7uxX8fBP/gIPe.',0);

insert into roles values ('1','ADMIN');
insert into roles values ('2','STUDENT');

insert into users_roles values('1','1');
insert into users_roles values('2','2');
