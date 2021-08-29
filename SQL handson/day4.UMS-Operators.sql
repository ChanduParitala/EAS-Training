-- Excercise 4.1
use ums;
select * from student_info where email_id is not null;

select marks, reg_no from student_marks where marks>50;

select student_marks.reg_no, student_name, subject_code, semester, marks from student_marks join student_info where student_info.reg_no = student_marks.reg_no;

select reg_no, gpa_No from student_result order by is_eligible_scholarship desc;

select student_name, student_info.reg_no, marks, round(marks*(weightage/100)) as weighted_marks from student_marks join student_info on student_info.reg_no=student_marks.reg_no
join subject_info on student_marks.subject_code=subject_info.subject_code;

select * from student_info where student_name like 'M%';

select student_name, student_info.reg_no, marks from student_info join student_marks on student_info.reg_no=student_marks.reg_no and email_id is not null;

select student_name, student_marks.reg_no, marks from student_marks join student_info on student_info.reg_no=student_marks.reg_no and marks between 60 and 100;

select student_name, student_marks.reg_no, marks from student_marks join student_info on student_info.reg_no=student_marks.reg_no and student_name not like 'J%';

select student_name, student_marks.reg_no, marks from student_marks join student_info on student_info.reg_no=student_marks.reg_no and subject_code in ('EE01DCF', 'EC02MUP');

select * from student_info where student_name like '%on';
