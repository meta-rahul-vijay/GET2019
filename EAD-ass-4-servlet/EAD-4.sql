
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
  
  
  ALTER TABLE `ead-ass-4`.`employee` 

DROP PRIMARY KEY 

, ADD PRIMARY KEY (`employee_id`) 

, ADD UNIQUE INDEX `email_id_UNIQUE` (`email_id` ASC) ;



CREATE  TABLE `ead-ass-4`.`vehicle_form` (

  `name` VARCHAR(45) NULL ,

  `type` VARCHAR(45) NULL ,

  `vehicle_no` INT NOT NULL ,

  `employee_id` INT NULL ,

  `identificartion` VARCHAR(45) NULL ,

  PRIMARY KEY (`vehicle_no`) ,

  INDEX `employee_id` (`employee_id` ASC) );

  
  
  USE `ead-ass-4`;

CREATE  OR REPLACE VIEW `ead-ass-4`.`employee_info` AS (select emp.full_name, emp.email_id, emp.password, emp.employee_id, vf.vehicle_no from Employee emp inner join vehicle_form vf on emp.employee_id = vf.employee_id);

;


USE `ead-ass-4`;

CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `employee_info` AS (select `emp`.`full_name` AS `full_name`,`emp`.`email_id` AS `email_id`,`emp`.`password` AS `password`,`emp`.`employee_id` AS `employee_id`,`vf`.`vehicle_no` AS `vehicle_no` from (`employee` `emp` left join `vehicle_form` `vf` on((`emp`.`employee_id` = `vf`.`employee_id`))));





CREATE  TABLE `ead-ass-4`.`plan` (

  `plan_id` INT NOT NULL AUTO_INCREMENT ,

  `emp_id` INT NULL ,

  `emp_name` VARCHAR(45) NULL ,

  `veh_type` VARCHAR(45) NULL ,

  `veh_no` INT NULL ,

  `plan_type` VARCHAR(45) NULL ,

  PRIMARY KEY (`plan_id`) ,

  INDEX `emp_id` (`emp_id` ASC) );
  
  
  
  
  
  
  
  
  
  
  USE `ead-ass-4`;

CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `employee_info` AS (select `emp`.`full_name` AS `full_name`,`emp`.`email_id` AS `email_id`,`emp`.`password` AS `password`,`emp`.`employee_id` AS `employee_id`,`emp`.`contact` AS `contact`,`vf`.`vehicle_no` AS `vehicle_no`,`vf`.`type` AS `type` from (`employee` `emp` left join `vehicle_form` `vf` on((`emp`.`employee_id` = `vf`.`employee_id`))));


  
  
  
  
  

  

