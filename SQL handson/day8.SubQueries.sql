-- Excercise 8.1
use eas;
select trainer_id from associate_status where associate_id in (select associate_id from associate_info where associate_name like '%i%');

select trainer_id from associate_status where associate_id not in (select associate_id from associate_info where associate_name like '%i%');

select trainer_id, tfeedbackgiven from associate_status where module_id = 'J2EE';

CREATE TABLE Trainer_Info_Sabbatical
(
	Trainer_Id	VARCHAR(20) PRIMARY KEY,
	Salutation	VARCHAR(7)	NOT NULL,
	Trainer_Name	VARCHAR(30) NOT NULL,
	Trainer_Location	VARCHAR(30) NOT NULL,
	Trainer_Track	VARCHAR(15)	NOT NULL,
	Trainer_Qualification	VARCHAR(100) NOT NULL,
	Trainer_Experiance	int ,
	Trainer_Email	VARCHAR(100)	NOT NULL,
	Trainer_Password	VARCHAR(20) NOT NULL
);
insert into Trainer_Info values ('F011','Mr.','Shyju K', 'Kochi','Java','Bachelor of Technology',9,'shyju@alliance.com','fac11@123');
insert into Trainer_Info values ('F012','Mr.','Raviraj Kumar', 'Kochi','Java','Bachelor of Technology',8,'raviarajkumar@alliance.com','fac12@123');
insert into Trainer_Info values ('F013','Mr.','Suresh Babu N', 'Mumbai','Testing','Bachelor of Technology',19,'sureshbabun@alliance.com','fac13@123');

insert into trainer_info_sabbatical select * from trainer_info where trainer_id in ('F011','F012','F013');

update trainer_info set trainer_location='kochi' where trainer_id in (select trainer_id from trainer_info_sabbatical where trainer_experience>10);

delete from trainer_info where trainer_id in (select trainer_id from trainer_info_sabbatical where trainer_experience>12);

select * from trainer_info where trainer_id in (select trainer_id from trainer_info_sabbatical);

-- Excercise 8.2
use ums;
select student_name, reg_no from student_info where reg_no in (select reg_no from student_marks where marks = (select max(marks) from student_marks));

select student_name, reg_no from student_info where reg_no in (select reg_no from student_marks where marks = (select max(marks) from student_marks where subject_code='EI05IP'));

select student_name, reg_no from student_info where reg_no in (select reg_no from student_marks where marks = 
(SELECT MAX(marks) FROM student_marks WHERE marks <> (SELECT MAX(marks) FROM student_marks where subject_code='EI05IP')));


select student_name, reg_no from student_info where reg_no in (select reg_no from student_marks where marks > (select avg(marks) from student_marks where subject_code='EI05IP'));


