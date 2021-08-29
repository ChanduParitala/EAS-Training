-- Excercise 4.1
use EAS;
select * from trainer_info where trainer_email=null;

select Trainer_id, trainer_name, trainer_track, trainer_location from trainer_info where trainer_experience > 4;

select * from module_info where module_duration>200;

select trainer_id, trainer_name from trainer_info where trainer_qualification='Bachelor of Technology';

select * from module_info where module_duration between 200 and 300; 

select trainer_id, trainer_name from trainer_info where trainer_name like 'M%';

select trainer_id, trainer_name from trainer_info where trainer_name like '%O%';

select module_name from module_info where module_name is not null; 