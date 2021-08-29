-- Excercise 6.1
use eas;
select count(associate_id) as no_of_associates, start_date from associate_status group by start_date;

select count(associate_id), start_date from associate_status where trainer_id='f001' group by start_date;

select count(associate_id), start_date from associate_status where trainer_id='f001' group by start_date having count(associate_id)>2;

select * from module_info order by module_duration;

select associate_name,concat( module_name,' ', associate_status.module_id), module_infra_fee from associate_status join associate_info on
associate_info.associate_id = associate_status.associate_id
join module_info on associate_status.module_id= module_info.module_id order by module_infra_fee desc;

-- Excercise 6.2
use ums;
select student_name, student_result.reg_no, gpa_no from student_result join student_info on
student_info.reg_no = student_result.reg_no order by gpa_no desc;

select * from student_info order by student_name;

select * from student_info order by date_of_birth;

select student_info.reg_no, student_name, semester, gpa_no from student_result join student_info on student_info.reg_no=student_result.reg_no order by gpa_no;

select reg_no, gpa_no from student_result order by is_eligible_scholarship desc;

select student_name, student_info.reg_no, max(gpa_no) from student_result join student_info on student_info.reg_no = student_result.reg_no group by semester;

select student_name, student_info.reg_no, min(gpa_no) from student_result join student_info on student_info.reg_no = student_result.reg_no group by semester;
