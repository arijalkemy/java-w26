-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema empresa_internet
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema empresa_internet
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `empresa_internet` ;
USE `empresa_internet` ;

-- -----------------------------------------------------
-- Table `empresa_internet`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresa_internet`.`Cliente` (
  `id_cliente` INT NOT NULL AUTO_INCREMENT,
  `dni` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `fecha_nacimiento` DATE NOT NULL,
  `provincia` VARCHAR(45) NOT NULL,
  `ciudad` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_cliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `empresa_internet`.`PlanInternet`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresa_internet`.`PlanInternet` (
  `id_planInternet` INT NOT NULL AUTO_INCREMENT,
  `identificacion` VARCHAR(45) NOT NULL,
  `velocidadMB` INT NOT NULL,
  `precio` DECIMAL(5,3) NOT NULL,
  `descuento` INT NOT NULL,
  PRIMARY KEY (`id_planInternet`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `empresa_internet`.`Contratacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresa_internet`.`Contratacion` (
  `id_contratacion` INT NOT NULL AUTO_INCREMENT,
  `PlanInternet_id_planInternet` INT NOT NULL,
  `Cliente_id_cliente` INT NOT NULL,
  PRIMARY KEY (`id_contratacion`),
  INDEX `fk_Contratacion_PlanInternet_idx` (`PlanInternet_id_planInternet` ASC) VISIBLE,
  INDEX `fk_Contratacion_Cliente1_idx` (`Cliente_id_cliente` ASC) VISIBLE,
  CONSTRAINT `fk_Contratacion_PlanInternet`
    FOREIGN KEY (`PlanInternet_id_planInternet`)
    REFERENCES `empresa_internet`.`PlanInternet` (`id_planInternet`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Contratacion_Cliente1`
    FOREIGN KEY (`Cliente_id_cliente`)
    REFERENCES `empresa_internet`.`Cliente` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
