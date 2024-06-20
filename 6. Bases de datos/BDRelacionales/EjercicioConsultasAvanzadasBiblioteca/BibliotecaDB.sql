-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Biblioteca
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Biblioteca
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Biblioteca` DEFAULT CHARACTER SET utf8 ;
USE `Biblioteca` ;

-- -----------------------------------------------------
-- Table `Biblioteca`.`ESTUDIANTE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Biblioteca`.`ESTUDIANTE` (
  `idLector` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `carrera` VARCHAR(45) NOT NULL,
  `edad` INT NOT NULL,
  PRIMARY KEY (`idLector`),
  UNIQUE INDEX `idLector_UNIQUE` (`idLector` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Biblioteca`.`LIBRO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Biblioteca`.`LIBRO` (
  `idLibro` INT NOT NULL,
  `titulo` VARCHAR(45) NOT NULL,
  `editorial` VARCHAR(45) NOT NULL,
  `area` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idLibro`),
  UNIQUE INDEX `idLibro_UNIQUE` (`idLibro` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Biblioteca`.`AUTOR`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Biblioteca`.`AUTOR` (
  `idAutor` INT NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `Nacionalidad` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idAutor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Biblioteca`.`PRESTAMO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Biblioteca`.`PRESTAMO` (
  `idLector` INT NOT NULL,
  `idLibro` INT NOT NULL,
  `fechaPrestamo` DATETIME NOT NULL,
  `fechaDevolucion` DATETIME NOT NULL,
  `devuelto` TINYINT NOT NULL,
  PRIMARY KEY (`idLector`, `idLibro`),
  INDEX `fk_ESTUDIANTE_has_LIBRO_LIBRO1_idx` (`idLibro` ASC) VISIBLE,
  INDEX `fk_ESTUDIANTE_has_LIBRO_ESTUDIANTE_idx` (`idLector` ASC) VISIBLE,
  CONSTRAINT `fk_ESTUDIANTE_has_LIBRO_ESTUDIANTE`
    FOREIGN KEY (`idLector`)
    REFERENCES `Biblioteca`.`ESTUDIANTE` (`idLector`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ESTUDIANTE_has_LIBRO_LIBRO1`
    FOREIGN KEY (`idLibro`)
    REFERENCES `Biblioteca`.`LIBRO` (`idLibro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Biblioteca`.`LIBROAUTOR`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Biblioteca`.`LIBROAUTOR` (
  `idAutor` INT NOT NULL,
  `idLibro` INT NOT NULL,
  PRIMARY KEY (`idAutor`, `idLibro`),
  INDEX `fk_AUTOR_has_LIBRO_LIBRO1_idx` (`idLibro` ASC) VISIBLE,
  INDEX `fk_AUTOR_has_LIBRO_AUTOR1_idx` (`idAutor` ASC) VISIBLE,
  CONSTRAINT `fk_AUTOR_has_LIBRO_AUTOR1`
    FOREIGN KEY (`idAutor`)
    REFERENCES `Biblioteca`.`AUTOR` (`idAutor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_AUTOR_has_LIBRO_LIBRO1`
    FOREIGN KEY (`idLibro`)
    REFERENCES `Biblioteca`.`LIBRO` (`idLibro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
