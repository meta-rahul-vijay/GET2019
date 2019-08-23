use test;


create table user(
user_id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
password varchar(45) 
);

create table admin(
admin_name varchar(45),
email_id varchar(45),
admin_id int NOT NULL,
foreign key (admin_id) references user(user_id)
);


create table shopper(
shopper_name varchar(45),
email_id varchar(50),
address_id int,
shopper_id int not null,
foreign key (shopper_id) references user(user_id)
);


CREATE  TABLE `test`.`address` (

  `address_id` INT NOT NULL ,

  `address` VARCHAR(45) NULL ,

  PRIMARY KEY (`address_id`) 
);


CREATE  TABLE `test`.`product` (

  `product_id` INT NOT NULL AUTO_INCREMENT ,

  `product_name` VARCHAR(45) NULL ,

  `category_id` INT NOT NULL ,

  `price` INT NULL ,

  `stock` INT NULL ,
  
  `isActive` boolean,
  
  `created` DATETIME NULL,
  
   PRIMARY KEY (`product_id`),
   
   PRIMARY KEY (`category_id`));
  
  
  
  ALTER TABLE `test`.`product` 

  ADD CONSTRAINT `category_id`

  FOREIGN KEY (`category_id` )

  REFERENCES `test`.`category` (`category_id` )

  ON DELETE NO ACTION

  ON UPDATE NO ACTION

, ADD INDEX `category_id` (`category_id` ASC) ;


CREATE  TABLE `test`.`category` (

  `category_id` INT NOT NULL ,

  `parent_id` INT NULL ,

  `category_name` VARCHAR(45) NULL ,

  PRIMARY KEY (`category_id`) ,

  INDEX (`category_id` ASC) );
  
  
  CREATE  TABLE `test`.`images` (

  `product_id` INT NOT NULL ,

  `image_src` VARCHAR(45) NULL ,

  INDEX `product_id` (`product_id` ASC));
  
  ALTER TABLE `test`.`images` 

  ADD CONSTRAINT `product_id`

  FOREIGN KEY (`product_id` )

  REFERENCES `test`.`product` (`product_id` )

  ON DELETE NO ACTION

  ON UPDATE NO ACTION;


  

CREATE  TABLE `test`.`cart` (

  `cart_id` INT NOT NULL ,

  `product_id` INT NOT NULL ,
  
  `quantity` INT NULL,
  
  `price` INT NULL,
  
  `status` INT NULL,

  `date_added` DATETIME NULL ,

  PRIMARY KEY (`cart_id`, `product_id`) ,
    
  INDEX `product_id` (`product_id` ASC) );


CREATE  TABLE `test`.`order` (

  `order_id` INT NOT NULL ,
  
  `cart_id` INT NULL ,

  `total_price` INT NULL ,
  
  `address_id` INT NULL ,

  `created` DATETIME NULL ,
  
  `status` VARCHAR(45) NULL ,

  PRIMARY KEY (`order_id`, `product_id`) ,

  INDEX `cart_id` (`cart_id` ASC) ,
  
  INDEX `address_id` (`address_id` ASC) );




CREATE  TABLE `test`.`order_history` (

  `order_id` INT NOT NULL ,

  `total_price` INT NULL ,

  `ordered_date` DATETIME NULL ,

  PRIMARY KEY (`order_id`) ,

  INDEX `order_id` (`order_id` ASC) );





SET SQL_SAFE_UPDATES=0;
SET SQL_SAFE_UPDATES=1;






