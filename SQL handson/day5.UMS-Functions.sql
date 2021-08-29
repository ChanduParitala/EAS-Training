-- Excercise 5.1
use ums;
select upper(student_name) as student_name, upper(branch) as branch from student_info; 

select lower(reg_no) as reg_no, lower(subject_code) as subject_code, semester, marks from student_marks;

select reg_no, date_format(date_of_birth,'%Y/%m/%d') as DOB from student_info;
select reg_no, date_format(date_of_birth,'%M %d,%Y') as DOB from student_info;

select student_name, contact_number, email_id, floor(DATEDIFF(now(),date_of_birth)/365.25) as age from student_info;

select student_marks.reg_no, student_name, avg(marks),semester from student_info join student_marks on student_info.reg_no=student_marks.reg_no group by semester,reg_no;

select student_marks.reg_no, student_name, max(marks), semester from student_info join student_marks on student_info.reg_no=student_marks.reg_no group by semester,reg_no;

select student_marks.reg_no, student_name, max(marks) from student_info join student_marks on student_info.reg_no=student_marks.reg_no and subject_code = 'EI05IP';

select semester, avg(gpa_No) from student_result group by semester;

select reg_no, student_name, branch, contact_number, address, date_of_birth, if(email_id is not null, email_id, 'no valid email address') as email_id from student_info;

alter table student_info modify branch varchar(100);
select student_info.reg_no, student_name, case 
when branch = 'ECE' then 'Electronics and Communication Engineering'
when branch = 'EEE' then 'Electrical and Electronic Engineering'
else branch
end as branch, semester, gpa_no from student_result join student_info on  student_info.reg_no=student_result.reg_no;

