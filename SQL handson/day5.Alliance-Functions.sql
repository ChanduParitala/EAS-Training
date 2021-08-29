-- Excercise 5.1
use eas;
alter table module_info modify module_infra_fee float(10,2);
select * from module_info;

select module_name, round(module_infra_fee,2) from module_info;

select module_id, module_name from module_info where substring(module_name,1,2) = upper(substring(module_name,1,2));

select module_info.module_id,datediff(now(), start_date) as no_of_days from module_info join associate_status on module_info.module_id=associate_status.module_id;

select concat('<',module_name,'><', module_id,'>') as module from module_info;

select upper(module_name) from module_info;

select substring(module_name,1,3) from module_info;

select  avg(if(module_infra_fee is not null, module_infra_fee, 0)) as average_fee from module_info;

select sum(cast(substring(trainer_id,2) as unsigned)+100000) as sum from trainer_info;

select concat('The Base Fees Amount for the module name <',Module_Name,'> is <.',convert(module_infra_fee, char(10)),'>') as fee from module_info;

select count(module_id) as tuples from module_info;

select sum(module_infra_fee) as sum from module_info;

select min(module_infra_fee) as min, max(module_infra_fee) as max from module_info;




