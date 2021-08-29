-- Excercise 9.1
use eas;
create view view1 as select associate_id, trainer_id, batch_id from associate_status;

create view view2 as select associate_id, trainer_id, batch_id from associate_status where batch_id='b004';

drop view view2;

create index index1 on associate_info(associate_name);
create unique index index2 on associate_info(associate_name);

drop index index2 on associate_info;

--  when a view uses a WITH CASCADED CHECK OPTION, MySQL checks the rules of the view and also the rules of the underlying views recursively.
create view view3 as select trainer_experience from trainer_info where trainer_experience >5  with cascaded check option;
create view view33 as select * from view3;
insert into view33 values(3);
-- this will result in error, as we used cascaded check


create view view4 as select trainer_experience from trainer_info where trainer_experience >5  with local check option;
create view view44 as select * from view3;
insert into view44 values(3);
-- this will not rise an error, as there is no check from view4 on view44.

-- Excercise 9.2
use ums;
create view student_gpa as select student_name, student_result.reg_no, gpa_no, semester from student_result join student_info on student_info.reg_no= student_result.reg_no;

select student_name, reg_no, gpa_no, semester from student_gpa where gpa_no >5;

drop view student_avg_gpa;
create view student_avg_gpa as select student_name, student_result.reg_no, avg(gpa_no) as gpa_no, semester from student_result join student_info on student_info.reg_no= student_result.reg_no group by semester, reg_no;

select student_name, reg_no, gpa_no, semester from student_avg_gpa where gpa_no>7;

create index index3 on student_marks(semester);
drop index index3 on student_marks;

create unique index index4 on student_info(email_id);
