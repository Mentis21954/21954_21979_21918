CREATE SCHEMA IF NOT EXISTS login_db DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema university_db
-- -----------------------------------------------------
USE login_db; 

drop table Lessons;
drop table RecommendationLetter;
drop table requests;

-- -----------------------------------------------------
-- Table login_db.`request`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS login_db.`request` (
  id INT NOT NULL AUTO_INCREMENT,
  status VARCHAR(20) NOT NULL,
  situation VARCHAR(20) NOT NULL,
  teacher_email VARCHAR(45) NOT NULL,
  student_email VARCHAR(45) NOT NULL,
  PRIMARY KEY (id)
  /*INDEX fk_request_User1_idx (teacher_email ASC) VISIBLE,
  INDEX fk_request_User2_idx (student_email ASC) VISIBLE,
  CONSTRAINT fk_request_User1
    FOREIGN KEY (teacher_email)
    REFERENCES login_db.`Users` (username)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_request_User2
    FOREIGN KEY (student_email)
    REFERENCES login_db.`Users` (username)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)*/)
ENGINE = InnoDB;

insert into request values (1,'online','for JOB','test@gmail.com','student@gmail.com');

-- -----------------------------------------------------
-- Table login_db.`RecommendationLetter`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS login_db.`RecommendationLetter` (
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
    REFERENCES login_db.`User` (email)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_RecommendationLetter_request1
    FOREIGN KEY (request_id)
    REFERENCES login_db.`request` (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table login_db.`Lesson`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS login_db.`Lesson` (
  id INT NOT NULL AUTO_INCREMENT,
  Name VARCHAR(20) NOT NULL,
  Grade INT NOT NULL,
  Semester INT NOT NULL,
  request_id INT NOT NULL,
  PRIMARY KEY (id),
  INDEX fk_Lesson_request1_idx (request_id ASC) VISIBLE,
  CONSTRAINT fk_Lesson_request1
    FOREIGN KEY (request_id)
    REFERENCES login_db.`request` (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

insert into Lesson values(7,'Programming',10,5,1);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;