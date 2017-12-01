-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Person` (
  `persID` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`persID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Address` (
  `aID` INT NOT NULL,
  `number` INT NULL,
  `street` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `state` VARCHAR(45) NULL,
  `zipcode` VARCHAR(5) NULL,
  PRIMARY KEY (`aID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Patient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Patient` (
  `pID` INT NOT NULL,
  `persID` INT NOT NULL,
  PRIMARY KEY (`pID`),
  FOREIGN KEY (`persID`) REFERENCES Person(`persID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Medication`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Medication` (
  `mID` INT NOT NULL,
  `medName` VARCHAR(45) NULL,
  PRIMARY KEY (`mID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Worker`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Worker` (
  `wID` INT NOT NULL,
  `persID` INT NOT NULL,
  `type` VARCHAR(45) NULL,
  PRIMARY KEY (`wID`),
  FOREIGN KEY (`persID`) REFERENCES Person(`persID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Shift`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Shift` (
  `sID` INT NOT NULL,
  `startTime` DATETIME(6) NULL,
  `endTime` DATETIME(6) NULL,
  `day` INT NULL,
  `month` INT NULL,
  `year` INT NULL,
  PRIMARY KEY (`sID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Perscription`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Perscription` (
  `pID` INT NOT NULL,
  `dID` INT NOT NULL,
  `mID` INT NOT NULL,
  `date` DATE NULL,
  `docType` VARCHAR(45) NULL,
  `dosage` VARCHAR(45) NULL,
  PRIMARY KEY (`pID`, `dID`, `mID`),
  FOREIGN KEY (`pID`) REFERENCES Patient(`pID`),
  FOREIGN KEY (`dID`) REFERENCES Doctor(`dID`),
  FOREIGN KEY (`mID`) REFERENCES Medication(`mID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Nurse`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Nurse` (
  `nID` INT NOT NULL,
  `wID` INT NOT NULL,
  PRIMARY KEY (`nID`),
  FOREIGN KEY (`wID`) REFERENCES Worker(`wID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Doctor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Doctor` (
  `dID` INT NOT NULL,
  `wID` INT NOT NULL,
  PRIMARY KEY (`dID`),
  FOREIGN KEY (`wID`) REFERENCES Worker(`wID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Person-Address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Person-Address` (
  `persID` INT NOT NULL,
  `aID` INT NOT NULL,
  PRIMARY KEY (`persID`, `aID`),
  FOREIGN KEY (`persID`) REFERENCES Person(`persID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Phone`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Phone` (
  `persID` INT NOT NULL,
  `telephone` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`persID`, `telephone`),
  FOREIGN KEY (`persID`) REFERENCES  Person(`persID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`WorksIn`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`WorksIn` (
  `sID` INT NOT NULL,
  `wID` INT NOT NULL,
  PRIMARY KEY (`sID`, `wID`),
  FOREIGN KEY (`sID`) REFERENCES Shift(`sID`),
  FOREIGN KEY (`wID`) REFERENCES Worker(`wID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Visits`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Visits` (
  `pID` INT NOT NULL,
  `sID` INT NOT NULL,
  `result` VARCHAR(45) NULL,
  PRIMARY KEY (`pID`, `sID`),
  FOREIGN KEY (`pID`) REFERENCES Patient(`pID`),
  FOREIGN KEY (`sID`) REFERENCES Shift (`sID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Administers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Administers` (
  `nID` INT NOT NULL,
  `pID` INT NOT NULL,
  `mID` INT NOT NULL,
  PRIMARY KEY (`nID`, `pID`, `mID`),
  FOREIGN KEY (`nID`) REFERENCES Nurse(`nID`),
  FOREIGN KEY (`pID`) REFERENCES Patient(`pID`),
  FOREIGN KEY (`mID`) REFERENCES Medication(`mID`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
