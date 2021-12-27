CREATE SCHEMA IF NOT EXISTS mydb DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema university_db
-- -----------------------------------------------------
USE mydb ;

-- -----------------------------------------------------
-- Table mydb.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS mydb.`User` (
  email VARCHAR(45) NOT NULL,
  firstName VARCHAR(45) NOT NULL,
  lastName VARCHAR(45) NOT NULL,
  password VARCHAR(45) NOT NULL,
  role VARCHAR(10) NOT NULL,
  enabled TINYINT NOT NULL,
  PRIMARY KEY (email))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table mydb.`request`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS mydb.`request` (
  id INT NOT NULL AUTO_INCREMENT,
  status VARCHAR(20) NOT NULL,
  situation VARCHAR(20) NOT NULL,
  teacher_email VARCHAR(45) NOT NULL,
  student_email VARCHAR(45) NOT NULL,
  PRIMARY KEY (id),
  INDEX fk_request_User1_idx (teacher_email ASC) VISIBLE,
  INDEX fk_request_User2_idx (student_email ASC) VISIBLE,
  CONSTRAINT fk_request_User1
    FOREIGN KEY (teacher_email)
    REFERENCES mydb.`User` (email)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_request_User2
    FOREIGN KEY (student_email)
    REFERENCES mydb.`User` (email)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table mydb.`RecommendationLetter`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS mydb.`RecommendationLetter` (
  id INT NOT NULL AUTO_INCREMENT,
  text VARCHAR(200) NOT NULL,
  teacher_email VARCHAR(45) NOT NULL,
  request_id INT NOT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX id_UNIQUE (id ASC) VISIBLE,
  INDEX fk_RecommendationLetter_User_idx (teacher_email ASC) VISIBLE,
  INDEX fk_RecommendationLetter_request1_idx (request_id ASC) VISIBLE,
  CONSTRAINT fk_RecommendationLetter_User
    FOREIGN KEY (teacher_email)
    REFERENCES mydb.`User` (email)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_RecommendationLetter_request1
    FOREIGN KEY (request_id)
    REFERENCES mydb.`request` (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table mydb.`Lesson`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS mydb.`Lesson` (
  id INT NOT NULL AUTO_INCREMENT,
  Name VARCHAR(20) NOT NULL,
  Grade INT(2) NOT NULL,
  Semester INT(1) NOT NULL,
  request_id INT NOT NULL,
  PRIMARY KEY (id),
  INDEX fk_Lesson_request1_idx (request_id ASC) VISIBLE,
  CONSTRAINT fk_Lesson_request1
    FOREIGN KEY (request_id)
    REFERENCES mydb.`request` (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;