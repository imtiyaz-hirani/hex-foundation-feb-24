-- MySQL Workbench Forward Engineering


-- -----------------------------------------------------
-- Schema ticketbooking_feb_hex_24
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ticketbooking_feb_hex_24
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ticketbooking_feb_hex_24` DEFAULT CHARACTER SET utf8 ;
USE `ticketbooking_feb_hex_24` ;

-- -----------------------------------------------------
-- Table `ticketbooking_feb_hex_24`.`venue`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ticketbooking_feb_hex_24`.`venue` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `venue_name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ticketbooking_feb_hex_24`.`event`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ticketbooking_feb_hex_24`.`event` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `event_name` VARCHAR(45) NULL,
  `event_date` DATE NULL,
  `event_time` TIME NULL,
  `total_seats` INT NULL,
  `available_seats` INT NULL,
  `ticket_price` DOUBLE NULL,
  `event_type` VARCHAR(45) NULL,
  `venue_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_event_venue_idx` (`venue_id` ASC),
  CONSTRAINT `fk_event_venue`
    FOREIGN KEY (`venue_id`)
    REFERENCES `ticketbooking_feb_hex_24`.`venue` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ticketbooking_feb_hex_24`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ticketbooking_feb_hex_24`.`customer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `customer_name` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `phone_number` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ticketbooking_feb_hex_24`.`booking`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ticketbooking_feb_hex_24`.`booking` (
  `event_id` INT NOT NULL,
  `customer_id` INT NOT NULL,
  `num_tickets` INT NULL,
  `total_cost` DOUBLE NULL,
  `booking_date` DATE NULL,
  PRIMARY KEY (`event_id`, `customer_id`),
  INDEX `fk_event_has_customer_customer1_idx` (`customer_id` ASC) ,
  INDEX `fk_event_has_customer_event1_idx` (`event_id` ASC) ,
  CONSTRAINT `fk_event_has_customer_event1`
    FOREIGN KEY (`event_id`)
    REFERENCES `ticketbooking_feb_hex_24`.`event` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_event_has_customer_customer1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `ticketbooking_feb_hex_24`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

