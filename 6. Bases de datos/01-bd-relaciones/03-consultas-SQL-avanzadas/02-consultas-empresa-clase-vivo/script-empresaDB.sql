-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema empresa_DB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema empresa_DB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `empresa_DB` DEFAULT CHARACTER SET utf8 ;
USE `empresa_DB` ;

-- -----------------------------------------------------
-- Table `empresa_DB`.`departamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresa_DB`.`departamento` (
  `depto_nro` VARCHAR(45) NOT NULL,
  `nombre_depto` VARCHAR(45) NOT NULL,
  `localidad` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`depto_nro`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `empresa_DB`.`empleado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresa_DB`.`empleado` (
  `cod_emp` VARCHAR(10) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `puesto` VARCHAR(45) NOT NULL,
  `fecha_alta` DATE NOT NULL,
  `salario` INT NOT NULL,
  `comision` INT NOT NULL,
  `depto_nro` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`cod_emp`),
  INDEX `fk_empleado_departamento_idx` (`depto_nro` ASC) VISIBLE,
  CONSTRAINT `fk_empleado_departamento`
    FOREIGN KEY (`depto_nro`)
    REFERENCES `empresa_DB`.`departamento` (`depto_nro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
