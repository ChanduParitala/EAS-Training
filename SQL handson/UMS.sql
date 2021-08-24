-- Excercise 2.1
-- Build a UMS with tables like, Student_info, subject_info, Student_marks, Student_result.
create database UMS;
use UMS;
commit;

-- Excercise 2.2

create table student_info(Reg_No varchar(10) primary key, Student_Name Varchar(30) , Branch Varchar(10),Contact_Number Varchar(10),
Date_of_Birth Date, Date_of_Joining Date, Address Varchar(250), Email_id Varchar(250));

create table subject_info(subject_code varchar(10), subject_name varchar(30), weigthage integer(3));
alter table subject_info add primary key(subject_code);


create table student_marks(Reg_No varchar(10), subject_code varchar(10), semester integer(1), marks integer(3));
alter table student_marks add foreign key(Reg_No) references student_info(Reg_No);
alter table student_marks add foreign key(subject_code) references subject_info(subject_code);

create table student_result(reg_no varchar(10), semester integer(1), Gpa_No float(5,3), is_eligible_scholarship varchar(3));
alter table student_result add foreign key(Reg_No) references student_info(Reg_No);

-- Excercise 2.3

select * from student_info;
select * from subject_info;

insert into student_marks(Reg_No, subject_code, semester, marks) values('MC101301', 'EC02MUP',1,65),('MC101301','MC06DIP',1,70),
('BEC111402','EE01DCF',1,55),('BEC111402','EC02MUP',1,80),('BEC111402','MC06DIP',1,60),
('BEEI101204','EE01DCF',1,85),('BEEI101204','EC02MUP',1,78),('BEEI101204','MC06DIP',1,80),
('BEEI101204','MB03MAR',2,75),('BEEI101204','EI05IP',2,65),('BEEI101204','CPSC02DS',2,75),
('MB111305','EE01DCF',1,65),('MB111305','EC02MUP',1,68),('MB111305','MC06DIP',1,63),
('MB111305','MB03MAR',2,85),('MB111305','EI05IP',2,74),('MB111305','CPSC02DS',2,62);

insert into student_result(Reg_No, semester, Gpa_No, is_eligible_scholarship) values('MC101301',1,7.5,'Y'),
('BEC111402',1,7.1,'Y'),
('BEEI101204',1,8.3,'Y'),
('BEEI101204',2,6.9,'N'),
('MB111305',1,6.5,'N'),
('MB111305',2,6.8,'N');





