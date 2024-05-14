-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema biblioteca_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema biblioteca_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `biblioteca_db` DEFAULT CHARACTER SET utf8 ;
USE `biblioteca_db` ;

-- -----------------------------------------------------
-- Table `biblioteca_db`.`Libro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca_db`.`Libro` (
  `idLibro` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(45) NOT NULL,
  `editorial` VARCHAR(45) NOT NULL,
  `area` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idLibro`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `biblioteca_db`.`Autor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca_db`.`Autor` (
  `idAutor` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `nacionalidad` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idAutor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `biblioteca_db`.`LibroAutor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca_db`.`LibroAutor` (
  `idAutor` INT NOT NULL,
  `idLibro` INT NOT NULL,
  INDEX `fk_LibroAutor_Autor_idx` (`idAutor` ASC) VISIBLE,
  INDEX `fk_LibroAutor_Libro1_idx` (`idLibro` ASC) VISIBLE,
  CONSTRAINT `fk_LibroAutor_Autor`
    FOREIGN KEY (`idAutor`)
    REFERENCES `biblioteca_db`.`Autor` (`idAutor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_LibroAutor_Libro1`
    FOREIGN KEY (`idLibro`)
    REFERENCES `biblioteca_db`.`Libro` (`idLibro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `biblioteca_db`.`Estudiante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca_db`.`Estudiante` (
  `idLector` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `carrera` VARCHAR(45) NOT NULL,
  `edad` INT NOT NULL,
  PRIMARY KEY (`idLector`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `biblioteca_db`.`Prestamo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca_db`.`Prestamo` (
  `idLibro` INT NOT NULL,
  `idLector` INT NOT NULL,
  `fechaPrestamo` DATE NOT NULL,
  `fechaDevolucion` DATE NOT NULL,
  `devuelto` TINYINT NOT NULL,
  INDEX `fk_Prestamo_Libro1_idx` (`idLibro` ASC) VISIBLE,
  INDEX `fk_Prestamo_Estudiante1_idx` (`idLector` ASC) VISIBLE,
  CONSTRAINT `fk_Prestamo_Libro1`
    FOREIGN KEY (`idLibro`)
    REFERENCES `biblioteca_db`.`Libro` (`idLibro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Prestamo_Estudiante1`
    FOREIGN KEY (`idLector`)
    REFERENCES `biblioteca_db`.`Estudiante` (`idLector`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
