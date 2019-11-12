DROP SCHEMA Student_Management_System;
CREATE DATABASE Student_Management_System;
USE Student_Management_System;

CREATE TABLE student_information(
    student_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    email_id VARCHAR(30) NOT NULL UNIQUE,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    father_name VARCHAR(40) NOT NULL,
    class INT NOT NULL,
    age INT NOT NULL);
    
SELECT * FROM student_information;

create table users (
    username varchar(50) not null primary key,
    password varchar(120) not null,
    enabled boolean not null
);

create table authorities (
    username varchar(50) not null,
    authority varchar(50) not null,
    foreign key (username) references users (username)
);

insert into users(username, password, enabled)values('admin','{noop}admin',true);
insert into authorities(username,authority)values('admin','ROLE_ADMIN');

insert into users(username, password, enabled)values('user','{noop}user',true);
insert into authorities(username,authority)values('user','ROLE_USER');