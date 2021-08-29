-- Excercise 3.1
use UMS;
select * from student_info;
alter table student_info add date_of_joining datetime default current_timestamp;

select * from subject_info;
ALTER TABLE subject_info MODIFY subject_name varchar(30) NOT NULL, MODIFY weightage integer(3) NOT NULL;

select * from student_marks;
ALTER TABLE student_marks MODIFY semester integer(3) NOT NULL, MODIFY marks integer(3) NOT NULL;
alter table student_marks alter marks set default 0;

select* from student_result;
ALTER TABLE student_result MODIFY semester integer(3) NOT NULL, MODIFY gpa_No float(5,3) NOT NULL;
alter table student_result alter is_eligible_scholarship set default 'Y';

-- Excercise 3.2
ALTER TABLE subject_info ADD CONSTRAINT UC_subject UNIQUE (subject_name);

ALTER TABLE student_info ADD CONSTRAINT UC_contact UNIQUE (contact_number);

ALTER TABLE student_info ADD CONSTRAINT G_dob check(date_of_birth < date_of_joining);

ALTER TABLE student_marks ADD CONSTRAINT G_marks check(marks <= 100);

ALTER TABLE student_result ADD CONSTRAINT G_gpa check(gpa_no <= 10.0);

ALTER TABLE student_result ADD CONSTRAINT G_eligibility check(is_eligible_scholarship = 'Y' or is_eligible_scholarship = 'N');






