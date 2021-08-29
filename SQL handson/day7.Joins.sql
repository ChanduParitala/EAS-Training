-- Excercise 7.1
use eas;
select batch_id, trainer_id from trainer_info join batch_info;

select * from associate_status join batch_info on associate_status.batch_id= batch_info.batch_id;

select associate_id, associate_status.trainer_id from associate_status right join trainer_info on trainer_info.trainer_id=associate_status.trainer_id;

select associate_id, associate_status.trainer_id from trainer_info left join associate_status on trainer_info.trainer_id=associate_status.trainer_id;

select associate_id, associate_status.trainer_id from associate_status right join trainer_info on trainer_info.trainer_id=associate_status.trainer_id
union
select associate_id, associate_status.trainer_id from trainer_info left join associate_status on trainer_info.trainer_id=associate_status.trainer_id;

-- Excercise 7.2
use ums;
select student_name, subject_code, marks from student_marks join student_info on student_info.reg_no = student_marks.reg_no;

select student_name, subject_code, marks from student_marks join student_info on student_info.reg_no = student_marks.reg_no and marks>= 65;

select student_name, student_info.reg_no, max(gpa_no) from student_result join student_info on student_info.reg_no = student_result.reg_no;

create table backup_student_info(Reg_No varchar(10) primary key, Student_Name Varchar(30) , Branch Varchar(10),Contact_Number Varchar(10),
Date_of_Birth Date, Date_of_Joining Date, Address Varchar(250), Email_id Varchar(250));

insert into backup_student_info select reg_no, student_name, branch, contact_number, date_of_birth, date_of_joining, address, email_id from student_info;

INSERT INTO `ums`.`student_info` (`Reg_No`, `Student_Name`, `branch`, `Contact_Number`, `Date_of_Birth`, `Address`, `Email_id`, `date_of_joining`) VALUES 
('EE101301', 'Chandan', 'ECE', '9032032345', '2020-09-08', 'Vja, South california', 'chandan@gmail.com', '2021-08-25 13:07:30');

select * from student_info left join backup_student_info on student_info.reg_no = backup_student_info.reg_no;

select * from backup_student_info right join student_info on student_info.reg_no = backup_student_info.reg_no;


