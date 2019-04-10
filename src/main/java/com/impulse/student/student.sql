create database test;
use test;
CREATE TABLE IF NOT EXISTS `test`.`student` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `age` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `test`.`course` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB ;
describe course;

CREATE TABLE IF NOT EXISTS `test`.`student_course` (
  `id` INT NOT NULL,
  `score` INT NOT NULL,
  `student_id` INT NOT NULL,
  `course_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_student_course_student_idx` (`student_id` ASC) VISIBLE,
  INDEX `fk_student_course_course1_idx` (`course_id` ASC) VISIBLE)
ENGINE = InnoDB;
describe student_course;
drop table student_course;





