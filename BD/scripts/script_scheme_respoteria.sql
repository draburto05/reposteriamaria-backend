-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema reposteria_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema reposteria_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `reposteria_BK` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema reposteria_db
-- -----------------------------------------------------
USE `reposteria_BK` ;

-- -----------------------------------------------------
-- Table `reposteria_db`.`client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `reposteria_BK`.`client` (
  `idcliente` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `appaterno` VARCHAR(45) NOT NULL,
  `apmaterno` VARCHAR(45) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `contrasena` VARCHAR(100) NOT NULL,
  `telefono` VARCHAR(15) NOT NULL,
  `direccion` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`idcliente`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  UNIQUE INDEX `telefono_UNIQUE` (`telefono` ASC) VISIBLE)
ENGINE = InnoDB;


-- reposteria_db
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `reposteria_BK`.`order_buy` (
  `idorder` INT NOT NULL AUTO_INCREMENT,
  `fecha` TIMESTAMP NOT NULL,
  `precio` DECIMAL UNSIGNED NOT NULL,
  `tipo_entrega` VARCHAR(45) NOT NULL,

  `client_idcliente` INT NOT NULL,
  PRIMARY KEY (`idorder`),
  INDEX `fk_order_client_idx` (`client_idcliente` ASC) VISIBLE,
  CONSTRAINT `fk_order_client`
    FOREIGN KEY (`client_idcliente`)
    REFERENCES `reposteria_BK`.`client` (`idcliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `reposteria_db`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `reposteria_BK`.`category` (
  `idcategory` INT NOT NULL AUTO_INCREMENT,
  `nombre_categoria` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(250) NOT NULL,
  PRIMARY KEY (`idcategory`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `reposteria_db`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `reposteria_BK`.`product` (
  `idproduct` INT NOT NULL AUTO_INCREMENT,
  `nombre_producto` VARCHAR(100) NOT NULL,
  `precio_producto` DECIMAL UNSIGNED NOT NULL,
  `stock` INT UNSIGNED NOT NULL,
  `order_idorder` INT NOT NULL,
  `category_idcategory` INT NOT NULL,
  `tamano` VARCHAR(45) NOT NULL,
  `sabor` VARCHAR(45) NOT NULL,
  `imagen` BLOB NOT NULL,
  UNIQUE INDEX `nombre_producto_UNIQUE` (`nombre_producto` ASC) VISIBLE,
  INDEX `fk_product_order1_idx` (`order_idorder` ASC) VISIBLE,
  INDEX `fk_product_category1_idx` (`category_idcategory` ASC) VISIBLE,
  PRIMARY KEY (`idproduct`),
  CONSTRAINT `fk_product_order1`
    FOREIGN KEY (`order_idorder`)
    REFERENCES `reposteria_BK`. `order_buy` (`idorder`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_category1`
    FOREIGN KEY (`category_idcategory`)
    REFERENCES `reposteria_BK`.`category` (`idcategory`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `reposteria_db`.`shipment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `reposteria_BK`.`shipment` (
  `idshipment` INT NOT NULL AUTO_INCREMENT,
  `direccion_entrega` VARCHAR(200) NOT NULL,
  `num_seguimiento` INT UNSIGNED NOT NULL,
  `estatus` VARCHAR(45) NOT NULL,
  `order_idorder` INT NOT NULL,
  PRIMARY KEY (`idshipment`, `order_idorder`),
  INDEX `fk_shipment_order1_idx` (`order_idorder` ASC) VISIBLE,
  CONSTRAINT `fk_shipment_order1`
    FOREIGN KEY (`order_idorder`)
    REFERENCES `reposteria_BK`.`order_buy` (`idorder`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `reposteria_db`.`payment_method`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `reposteria_BK`.`payment_method` (
  `idpayment_method` INT NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idpayment_method`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `reposteria_db`.`payment_method_has_order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `reposteria_BK`.`payment_method_has_order` (
  `payment_method_idpayment_method` INT NOT NULL AUTO_INCREMENT,
  `order_idorder` INT NOT NULL,
  PRIMARY KEY (`payment_method_idpayment_method`, `order_idorder`),
  INDEX `fk_payment_method_has_order_order1_idx` (`order_idorder` ASC) VISIBLE,
  INDEX `fk_payment_method_has_order_payment_method1_idx` (`payment_method_idpayment_method` ASC) VISIBLE,
  CONSTRAINT `fk_payment_method_has_order_payment_method1`
    FOREIGN KEY (`payment_method_idpayment_method`)
    REFERENCES `reposteria_BK`.`payment_method` (`idpayment_method`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_payment_method_has_order_order1`
    FOREIGN KEY (`order_idorder`)
    REFERENCES `reposteria_BK`.`order_buy` (`idorder`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;