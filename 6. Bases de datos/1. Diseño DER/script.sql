-- MySQL Script generated by MySQL Workbench
-- Fri May 10 12:19:04 2024
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`cliente` (
  `idcliente` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `direccion` VARCHAR(45) NULL,
  PRIMARY KEY (`idcliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`serivicio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`serivicio` (
  `idservicio` INT NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idservicio`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`autos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`autos` (
  `idventa` INT NOT NULL,
  `idcliente` INT NOT NULL,
  `marca` VARCHAR(45) NULL,
  `modelo` VARCHAR(45) NULL,
  `color` VARCHAR(45) NULL,
  PRIMARY KEY (`idventa`),
  INDEX `fk_venta_cliente_idx` (`idcliente` ASC) VISIBLE,
  CONSTRAINT `fk_venta_cliente`
    FOREIGN KEY (`idcliente`)
    REFERENCES `mydb`.`cliente` (`idcliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`autoservicios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`autoservicios` (
  `idautoservicios` INT NOT NULL,
  `autos_idventa` INT NOT NULL,
  `serivicio_idservicio` INT NOT NULL,
  `fecha` TIMESTAMP NOT NULL,
  `duracion` TIME NOT NULL,
  `precio` FLOAT NOT NULL,
  PRIMARY KEY (`idautoservicios`),
  INDEX `fk_autoservicios_autos1_idx` (`autos_idventa` ASC) VISIBLE,
  INDEX `fk_autoservicios_serivicio1_idx` (`serivicio_idservicio` ASC) VISIBLE,
  CONSTRAINT `fk_autoservicios_autos1`
    FOREIGN KEY (`autos_idventa`)
    REFERENCES `mydb`.`autos` (`idventa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_autoservicios_serivicio1`
    FOREIGN KEY (`serivicio_idservicio`)
    REFERENCES `mydb`.`serivicio` (`idservicio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
