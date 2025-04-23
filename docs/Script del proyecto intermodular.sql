-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema proyectointermodular
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema proyectointermodular
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `proyectointermodular` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ;
USE `proyectointermodular` ;

-- -----------------------------------------------------
-- Table `proyectointermodular`.`contrato`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyectointermodular`.`contrato` (
  `idContrato` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(45) NOT NULL,
  `descripcion` MEDIUMTEXT NULL DEFAULT NULL,
  `ambito` VARCHAR(20) NOT NULL,
  `importe` DECIMAL(12,2) NULL DEFAULT NULL,
  `estado` VARCHAR(20) NOT NULL,
  `fecha_inicio` DATE NULL DEFAULT NULL,
  `fecha_fin` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`idContrato`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `proyectointermodular`.`pais`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyectointermodular`.`pais` (
  `idPais` CHAR(3) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `presupuesto_total` DECIMAL(12,2) NOT NULL,
  `presupuesto_asignado` DECIMAL(12,2) NOT NULL,
  PRIMARY KEY (`idPais`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `proyectointermodular`.`contrato_pais`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyectointermodular`.`contrato_pais` (
  `contrato_id` INT NOT NULL,
  `pais_id` CHAR(3) NOT NULL,
  `aporte` DECIMAL(12,2) NULL DEFAULT NULL,
  PRIMARY KEY (`contrato_id`, `pais_id`),
  INDEX `fk_contrato_pais_pais_idx` (`pais_id` ASC) VISIBLE,
  CONSTRAINT `fk_contrato_pais_contrato`
    FOREIGN KEY (`contrato_id`)
    REFERENCES `proyectointermodular`.`contrato` (`idContrato`),
  CONSTRAINT `fk_contrato_pais_pais`
    FOREIGN KEY (`pais_id`)
    REFERENCES `proyectointermodular`.`pais` (`idPais`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `proyectointermodular`.`empresa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyectointermodular`.`empresa` (
  `idEmpresa` VARCHAR(10) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `sector` VARCHAR(45) NOT NULL,
  `pais_origen_id` CHAR(3) NOT NULL,
  PRIMARY KEY (`idEmpresa`),
  INDEX `fk_empresa_pais_idx` (`pais_origen_id` ASC) VISIBLE,
  CONSTRAINT `fk_empresa_pais`
    FOREIGN KEY (`pais_origen_id`)
    REFERENCES `proyectointermodular`.`pais` (`idPais`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `proyectointermodular`.`empresa_pais`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyectointermodular`.`empresa_pais` (
  `empresa_id` VARCHAR(10) NOT NULL,
  `pais_id` CHAR(3) NOT NULL,
  PRIMARY KEY (`empresa_id`, `pais_id`),
  INDEX `fk_empresa_pais_pais_idx` (`pais_id` ASC) VISIBLE,
  CONSTRAINT `fk_empresa_pais_empresa`
    FOREIGN KEY (`empresa_id`)
    REFERENCES `proyectointermodular`.`empresa` (`idEmpresa`),
  CONSTRAINT `fk_empresa_pais_pais`
    FOREIGN KEY (`pais_id`)
    REFERENCES `proyectointermodular`.`pais` (`idPais`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `proyectointermodular`.`postulacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proyectointermodular`.`postulacion` (
  `empresa_id` VARCHAR(10) NOT NULL,
  `contrato_id` INT NOT NULL,
  `propuesta_importe` DECIMAL(12,2) NULL DEFAULT NULL,
  `resultado` VARCHAR(30) NOT NULL DEFAULT 'pendiente',
  PRIMARY KEY (`empresa_id`, `contrato_id`),
  INDEX `fk_postulacion_contrato_idx` (`contrato_id` ASC) VISIBLE,
  CONSTRAINT `fk_postulacion_contrato`
    FOREIGN KEY (`contrato_id`)
    REFERENCES `proyectointermodular`.`contrato` (`idContrato`),
  CONSTRAINT `fk_postulacion_empresa`
    FOREIGN KEY (`empresa_id`)
    REFERENCES `proyectointermodular`.`empresa` (`idEmpresa`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
