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
-- Table `mydb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`user` (
  `iduser` INT NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`iduser`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`wallet`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`wallet` (
  `idwallet` INT NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `user_iduser` INT NOT NULL,
  `total_usd` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idwallet`),
  INDEX `fk_wallet_user1_idx` (`user_iduser` ASC) VISIBLE,
  CONSTRAINT `fk_wallet_user1`
    FOREIGN KEY (`user_iduser`)
    REFERENCES `mydb`.`user` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`transaction`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`transaction` (
  `idtransaction` INT NOT NULL,
  `description` VARCHAR(45) NULL,
  `tx_id` VARCHAR(80) NOT NULL,
  `amount` DOUBLE NOT NULL,
  `neetwork_fee` DOUBLE NOT NULL,
  `block` INT NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  `currency` VARCHAR(45) NOT NULL,
  `user_iduser` INT NOT NULL,
  `wallet_from` INT NOT NULL,
  PRIMARY KEY (`idtransaction`),
  INDEX `fk_transaction_user_idx` (`user_iduser` ASC) VISIBLE,
  INDEX `fk_transaction_wallet1_idx` (`wallet_from` ASC) VISIBLE,
  CONSTRAINT `fk_transaction_user`
    FOREIGN KEY (`user_iduser`)
    REFERENCES `mydb`.`user` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_transaction_wallet1`
    FOREIGN KEY (`wallet_from`)
    REFERENCES `mydb`.`wallet` (`idwallet`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`currency`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`currency` (
  `idcurrency` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(400) NOT NULL,
  `network` VARCHAR(45) NOT NULL,
  `abbreviation` VARCHAR(45) NOT NULL,
  `price` DOUBLE NOT NULL,
  PRIMARY KEY (`idcurrency`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`wallet_has_currency_wallet`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`wallet_has_currency_wallet` (
  `currency_idcurrency` INT NOT NULL,
  `purchase_price` DOUBLE NOT NULL,
  `amount` DOUBLE NOT NULL,
  `wallet_idwallet` INT NOT NULL,
  PRIMARY KEY (`currency_idcurrency`, `wallet_idwallet`),
  INDEX `fk_wallet_has_currency_wallet_currency1_idx` (`currency_idcurrency` ASC) VISIBLE,
  INDEX `fk_wallet_has_currency_wallet_wallet1_idx` (`wallet_idwallet` ASC) VISIBLE,
  CONSTRAINT `fk_wallet_has_currency_wallet_currency1`
    FOREIGN KEY (`currency_idcurrency`)
    REFERENCES `mydb`.`currency` (`idcurrency`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_wallet_has_currency_wallet_wallet1`
    FOREIGN KEY (`wallet_idwallet`)
    REFERENCES `mydb`.`wallet` (`idwallet`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
