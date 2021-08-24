-- Excercise 3.1
-- Apply all integrity constraints
use EAS;
-- select * from trainer_info;

ALTER TABLE trainer_info
 alter salutation set default null, alter trainer_name set default null, alter trainer_location set default null, alter trainer_track set default null,
 alter trainer_qualification set default null, alter trainer_experience set default null, alter trainer_email set default null, alter trainer_password set default null;
 
 ALTER TABLE trainer_info MODIFY salutation varchar(7) NOT NULL, MODIFY trainer_name varchar(30) NOT NULL, MODIFY trainer_location varchar(30) NOT NULL,MODIFY trainer_track varchar(15) NOT NULL,MODIFY trainer_qualification varchar(100) NOT NULL,
 MODIFY trainer_email varchar(100) NOT NULL,MODIFY trainer_password varchar(20) NOT NULL;
 
 ALTER TABLE trainer_info ADD CHECK (trainer_id like "F%");
 
 -- select * from batch_info;

ALTER TABLE batch_info
 alter batch_owner set default null, alter batch_BU_name set default null;
 
 ALTER TABLE batch_info MODIFY batch_id varchar(20) NOT NULL, MODIFY batch_owner varchar(30) NOT NULL, MODIFY batch_BU_name varchar(30) NOT NULL;
 
 ALTER TABLE batch_info ADD CHECK (batch_id like "B%");
 
 
 -- select * from module_info;

ALTER TABLE module_info
 alter module_name set default null, alter module_duration set default null;
 
 ALTER TABLE module_info MODIFY module_id varchar(20) NOT NULL, MODIFY module_name varchar(40) NOT NULL, MODIFY module_duration varchar(11) NOT NULL;
 
 ALTER TABLE batch_info ADD CHECK (batch_id = upper(batch_id));
 
-- select * from associate_info;
 
 ALTER TABLE Associate_info
 alter salutation set default null, alter Associate_name set default null, alter Associate_location set default null, alter Associate_track set default null,
 alter Associate_qualification set default null, alter Associate_experience set default null, alter Associate_email set default null, alter Associate_password set default null;
 
 ALTER TABLE Associate_info MODIFY salutation varchar(7) NOT NULL, MODIFY Associate_name varchar(30) NOT NULL, MODIFY Associate_location varchar(30) NOT NULL,MODIFY Associate_track varchar(15) NOT NULL,MODIFY Associate_qualification varchar(100) NOT NULL,
 MODIFY Associate_email varchar(100) NOT NULL,MODIFY Associate_password varchar(20) NOT NULL;
 
 ALTER TABLE Associate_info ADD CHECK (Associate_id like "A%");
 
 -- select * from Questions;

ALTER TABLE questions
 alter module_id set default null, alter question_text set default null;
 
 ALTER TABLE questions MODIFY question_id varchar(20) NOT NULL, MODIFY question_text varchar(900) NOT NULL;
 
 ALTER TABLE questions ADD CHECK (question_id like "Q%");
 
 -- select * from associate_status;

 alter table associate_status  alter Module_Id set default null,  alter Batch_Id set default null,  alter Trainer_Id set default null,  alter Start_Date set default null,
 alter End_Date set default null, alter AFeedbackGiven set default null, alter TFeedbackGiven set default null;
 
-- select * from trainer_feedback

alter table trainer_feedback  alter trainer_id set default null,  alter question_id set default null,  alter batch_id set default null,  alter module_id set default null, alter trainer_rating set default null;

 ALTER TABLE trainer_feedback MODIFY trainer_rating integer(11) NOT NULL;
 
 
-- select * from associate_feedback

alter table associate_feedback  alter associate_id set default null,  alter question_id set default null,  alter module_id set default null, alter associate_rating set default null;

 ALTER TABLE associate_feedback MODIFY associate_rating integer(11) NOT NULL;
 
 -- -------------------------------------------------------------------------------------------------------------------------------------------------------------
 -- Excercise 3.2
 -- Disabling key adds inconsistent data in table, which must be updated carefully.
 
 create table product(product_id varchar(10) primary key, product_name varchar(20), product_price integer(5) not null);
 
 create table user(user_id varchar(10) primary key, product_id varchar(10) references product(product_id), user_name varchar(20));
 alter table user add foreign key(product_id) references product(product_id);
 
 insert into product(product_id, product_name, product_price) values
 (	1,'A Dongle',290), (2,'B Dongle',1250);
 
 -- unable to insert as per integrity constraint.
 -- insert into product(product_id, product_name) values (3,'C Dongle');
 
 SET FOREIGN_KEY_CHECKS=0;
 
 insert into user(user_id, product_id, user_name) values ('U001',1,'Ramesh'),('U002',11,'Mahesh');
 
 select* from user;
 select * from product;
 SET FOREIGN_KEY_CHECKS=1;
 -- we can see that only in user table prod_id =11 is updated.
 
 
 
