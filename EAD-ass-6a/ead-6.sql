CREATE  TABLE `ead-ass-6a`.`book` (

  `bookId` INT NOT NULL ,

  `title` VARCHAR(45) NULL ,

  `writer` VARCHAR(45) NULL ,

  `publisher` VARCHAR(45) NULL ,

  `publishedYear` INT NULL ,

  PRIMARY KEY (`bookId`) );

  
  
  ALTER TABLE `ead-ass-6a`.`book` CHANGE COLUMN `bookId` `book_id` INT(11) NOT NULL  , CHANGE COLUMN `publishedYear` `published_year` INT(11) NULL DEFAULT NULL  ;
