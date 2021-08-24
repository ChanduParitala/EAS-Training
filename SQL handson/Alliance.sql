create database EAS;

use EAS;
commit;

-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- Exercise :1.1

-- Trainer Info Table
create table Trainer_Info( Trainer_Id varchar(20) primary key, Salutation varchar(7), Trainer_Name varchar(30), Trainer_Location varchar(30),
 Trainer_Qualification varchar(100), Trainer_Experience varchar(11), Trainer_Track varchar(15), Trainer_Email varchar(100), Trainer_Password varchar(20)); 
 
 -- Batch Info Table
 create table Batch_Info(Batch_Id varchar(20) primary key, Batch_Owner varchar(30), Batch_BU_Name varchar(30));
 
 -- Module Info Table 
  create table Module_Info(Module_Id varchar(20) primary key, Module_Name varchar(40), Module_Duration varchar(11));
  
-- Associate Info Table
create table Associate_Info( Associate_Id varchar(20) primary key, Salutation varchar(7), Associate_Name varchar(30), Associate_Location varchar(30),
 Associate_Qualification varchar(100), Associate_Experience varchar(11), Associate_Track varchar(15), Associate_Email varchar(100), Associate_Password varchar(20)); 
 
 -- Questions Table
 create table Questions(Question_Id varchar(20) primary key, Module_Id varchar(20) references Module_Info(Module_Id) , Question_Text varchar(900));
 alter table Questions add foreign key(Module_Id) references Module_Info(Module_Id);
 
 -- Associate_Status Table
 drop table associate_status;
 create table Associate_Status(Associate_Id	varchar(20) ,Module_Id varchar(20) references Module_Info(Module_Id),Start_Date varchar(20),End_Date varchar(20),
 AFeedbackGiven varchar(20),TFeedbackGiven	varchar(20));
  alter table associate_status add foreign key(Module_Id) references Module_Info(Module_Id);

-- Trainer_FeedBack Table  
create table Trainer_Feedback(Trainer_Id varchar(20),Question_Id varchar(20),Batch_Id varchar(20),Module_Id varchar(20),Trainer_Rating integer(11),
FOREIGN KEY (Trainer_Id) REFERENCES Trainer_Info(Trainer_Id),
FOREIGN KEY (Question_Id) REFERENCES Questions(Question_Id),
FOREIGN KEY (Batch_Id) REFERENCES Batch_Info(Batch_Id),
FOREIGN KEY (Module_Id) REFERENCES Module_Info(Module_Id));

-- Associate_FeedBack Table
create table Associate_Feedback(Associate_Id varchar(20),Question_Id varchar(20),Module_Id varchar(20),Associate_Rating integer(11),
FOREIGN KEY (Associate_Id) REFERENCES Associate_Info(Associate_Id),
FOREIGN KEY (Question_Id) REFERENCES Questions(Question_Id),
FOREIGN KEY (Module_Id) REFERENCES Module_Info(Module_Id));

-- Login Details Table
create table Login_Details(User_Id varchar(20), User_Password varchar(20));

-- --------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- Excercise 1.2
-- Modify Associate_Status add FKs batch_id & trainer_id
alter table Associate_status add batch_id varchar(20), add trainer_id varchar(20);
alter table Associate_status add foreign key(Batch_Id) references batch_info(batch_id), add foreign key(trainer_id) references trainer_info(trainer_id);

-- Modify Associate_Status change columns start_date & end_date to DATE datatype
alter table Associate_status drop column start_date, drop column end_date;
alter table Associate_status add start_date date, add end_date date;

-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- Exercise 1.3
insert into Trainer_Info(Trainer_Id,Salutation,Trainer_Name,Trainer_Location,Trainer_Track,Trainer_Qualification,Trainer_Experience,Trainer_Email,Trainer_Password)
values ('F001','Mr.','PANKAJ GHOSH','Pune','Java','Bachelor of Technology','12','Pankaj.Ghosh@alliance.com','fac1@123'),
('F002','Mr.','SANJAY RADHAKRISHNAN ','Bangalore','DotNet','Bachelor of Technology','12','Sanjay.Radhakrishnan@alliance.com','fac2@123'),
('F003','Mr.','VIJAY MATHUR','Chennai','Mainframe','Bachelor of Technology','10','Vijay.Mathur@alliance.com','fac3@123'),
('F004','Mrs.','NANDINI NAIR','Kolkata','Java','Master of Computer Applications','9','Nandini.Nair@alliance.com','fac4@123'),
('F005','Miss.','ANITHA PAREKH','Hyderabad','Testing','Master of Computer Applications','6','Anitha.Parekh@alliance.com','fac5@123'),
('F006','Mr.','MANOJ AGRAWAL ','Mumbai','Mainframe','Bachelor of Technology','9','Manoj.Agrawal@alliance.com','fac6@123'
);

select * from Trainer_info; 

insert into batch_info(Batch_Id,Batch_Owner,Batch_BU_Name) values
('B001','MRS.SWATI ROY','MSP'),
('B002','MRS.ARURNA K','HEALTHCARE'),
('B003','MR.RAJESH KRISHNAN','LIFE SCIENCES'),
('B004','MR.SACHIN SHETTY','BFS'),
('B005','MR.RAMESH PATEL','COMMUNICATIONS'),
('B006','MRS.SUSAN CHERIAN','RETAIL & HOSPITALITY'
);

select * from batch_info;

insert into Module_Info
(Module_Id,Module_Name,Module_Duration) values
('O10SQL','Oracle 10g SQL ','16'),
('O10PLSQL','Oracle 10g PL/ SQL ','16'),
('J2SE','Core Java SE 1.6','288'),
('J2EE','Advanced Java EE 1.6','80'),
('JAVAFX','JavaFX 2.1','80'),
('DOTNT4','.Net Framework 4.0 ','50'),
('SQL2008','MS SQl Server 2008','120'),
('MSBI08','MS BI Studio 2008','158'),
('SHRPNT','MS Share Point ','80'),
('ANDRD4','Android 4.0','200'),
('EM001','Instructor','0'),
('EM002','Course Material','0'),
('EM003','Learning Effectiveness','0'),
('EM004','Environment','0'),
('EM005','Job Impact','0'),
('TM001','Attendees','0'),
('TM002','Course Material','0'),
('TM003','Environment','0');

select * from module_info;

insert into Associate_Info
(Associate_Id,Salutation,Associate_Name,Associate_Location,Associate_Track,Associate_Qualification,Associate_Email,Associate_Password) values
('A001','Miss.','GAYATHRI NARAYANAN','Gurgaon','Java','Bachelor of Technology','Gayathri.Narayanan@hp.com','tne1@123'),
('A002','Mrs.','RADHIKA MOHAN','Kerala','Java','Bachelor of Engineering In Information Technology','Radhika.Mohan@cognizant.com','tne2@123'),
('A003','Mr.','KISHORE SRINIVAS','Chennai','Java','Bachelor of Engineering In Computers','Kishore.Srinivas@ibm.com','tne3@123'),
('A004','Mr.','ANAND RANGANATHAN','Mumbai','DotNet','Master of Computer Applications','Anand.Ranganathan@finolex.com','tne4@123'),
('A005','Miss.','LEELA MENON','Kerala','Mainframe','Bachelor of Engineering In Information Technology','Leela.Menon@microsoft.com','tne5@123'),
('A006','Mrs.','ARTI KRISHNAN','Pune','Testing','Master of Computer Applications','Arti.Krishnan@cognizant.com','tne6@123');

select * from associate_info;

insert into Questions	 
(Question_Id,Module_Id,Question_Text) values
('Q001','EM001','Instructor knowledgeable and able to handle all your queries'),
('Q002','EM001','All the topics in a particular course handled by the trainer without any gaps or slippages'),
('Q003','EM002','The course materials presentation, handson,  etc. refered during the training are relevant and useful.'),
('Q004','EM002','The Hands on session adequate enough to grasp the understanding of the topic.'),
('Q005','EM002','The reference materials suggested for each module are adequate.'),
('Q006','EM003','Knowledge and skills presented in this training are applicatible at your work'),
('Q007','EM003','This training increases my proficiency level'), 
('Q008','EM004','The physical environment e.g. classroom space, air-conditioning was conducive to learning.');

select * from questions;

insert into Associate_Status
(Associate_Id,Module_Id,Batch_Id,Trainer_Id,Start_Date,End_Date) values
('A001','O10SQL','B001','F001','2000-12-15','2000-12-25'),
('A002','O10SQL','B001','F001','2000-12-15','2000-12-25'),
('A003','O10SQL','B001','F001','2000-12-15','2000-12-25'),
('A001','O10PLSQL','B002','F002','2001-2-1','2001-2-12'),
('A002','O10PLSQL','B002','F002','2001-2-1','2001-2-12'),
('A003','O10PLSQL','B002','F002','2001-2-1','2001-2-12'),
('A001','J2SE','B003','F003','2002-8-20','2002-10-25'),
('A002','J2SE','B003','F003','2002-8-20','2002-10-25'),
('A001','J2EE','B004','F004','2005-12-1','2005-12-25'),
('A002','J2EE','B004','F004','2005-12-1','2005-12-25'),
('A003','J2EE','B004','F004','2005-12-1','2005-12-25'),
('A004','J2EE','B004','F004','2005-12-1','2005-12-25'),
('A005','JAVAFX','B005','F006','2005-12-4','2005-12-20');

select * from associate_status;

-- Excercise 1.4
update Trainer_info set Trainer_password='nn4@123' where trainer_id='F004';  

-- Excercise 1.5
delete from associate_status where associate_id = 'A003' and module_id='J2EE' and batch_id='B004' and trainer_id='F004' and start_date='2005-12-1' and end_date='2005-12-25';

-- Excercise 1.6 
SELECT * FROM eas.trainer_info order by Trainer_Experience desc limit 5;

-- Excercise 1.7
start transaction;
insert into Login_details(user_id, user_password) values('U001','Admin1@123'), ('U002','Admin2@123');
-- use commit for permanent data from rollbacks;
select * from login_details;
rollback;
select * from login_details;

-- Excercise 1.8
-- NA

-- Excercise 1.9
drop table login_details;
select * from login_details;
