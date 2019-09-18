
CREATE SCHEMA `EAD-ass-4` ;



CREATE  TABLE `ead-ass-4`.`Employee` (

  `full_name` VARCHAR(45) NULL ,

  `gender` VARCHAR(45) NULL ,

  `email_id` VARCHAR(45) NOT NULL ,

  `password` VARCHAR(45) NULL ,

  `confirm_password` VARCHAR(45) NULL ,

  `contact` VARCHAR(45) NULL ,

  `organization` VARCHAR(45) NULL ,

  PRIMARY KEY (`email_id`) );