drop table skilltracker.associate;

CREATE TABLE skilltracker.associate (
associate_id INT AUTO_INCREMENT,
name VARCHAR(100),
email VARCHAR(100),
mobile VARCHAR(20),
pic LONGBLOB,
status_green CHAR(1),
status_blue CHAR(1),
status_red CHAR(1),
level_1 VARCHAR(100),
level_2 VARCHAR(100),
level_3 VARCHAR(100),
remark VARCHAR(100),
strength VARCHAR(100),
weakness VARCHAR(100),
PRIMARY KEY (associate_id));

drop table skilltracker.skills;

CREATE TABLE skilltracker.skills(
skill_id INT AUTO_INCREMENT,
skill_name VARCHAR(100),
PRIMARY KEY (skill_id));

drop table skilltracker.associate_skills;

CREATE TABLE skilltracker.associate_skills(
associate_skill_id INT  AUTO_INCREMENT,
associate_id INT,
skill_id INT , 
PRIMARY KEY (associate_skill_id),
FOREIGN KEY (associate_id) 
REFERENCES associate(associate_id),
FOREIGN KEY (skill_id) 
REFERENCES skills(skill_id)
);

select * from skills;

select * from associate;


select skills0_.skill_id as skill_id1_2_, skills0_.skill_name as skill_na2_2_ 
from skills skills0_ where skills0_.skill_id=1;


SELECT  a.associate_id, a.name, a.email, a.mobile, a.status_blue, a.status_green,
a.status_red, '' from associate a 
where not exists (select * from associate_skills ask where ask.associate_id = a.associate_id) 
UNION all SELECT  a.associate_id, a.name, a.email, a.mobile, a.status_blue, 
a.status_green, a.status_red, GROUP_CONCAT(s.skill_name) FROM associate a  
INNER JOIN associate_skills ask ON a.associate_id=ask.associate_id 
INNER JOIN skills s ON s.skill_id = ask.skill_id -- AND ask.skill_level > 0 
GROUP BY ask.associate_id;

alter table associate add column gender varchar(10);

alter table associate_skills add skill_rating INT;

select * from associate_skills;

select * from associate;

select * from skills

--update associate set level_1=null
--where associate_id=127

--commit

--delete from associate where associate_id=116


SELECT a.gender, count(DISTINCT a.associate_id) from associate  a 
LEFT OUTER JOIN associate_skills ask ON a.associate_id = ask.associate_id 
WHERE ask.skill_rating > 0 
GROUP BY a.gender;

select associates0_.associate_skill_id as associat1_1_0_, associates0_.associate_id as associat3_1_0_, 
associates0_.skill_id as skill_id4_1_0_, associates0_.skill_rating as skill_ra2_1_0_, 
associate1_.associate_id as associat1_0_1_, associate1_.email as email2_0_1_, 
associate1_.gender as gender3_0_1_, associate1_.level_1 as level_4_0_1_, 
associate1_.level_2 as level_5_0_1_, associate1_.level_3 as level_6_0_1_, 
associate1_.mobile as mobile7_0_1_, associate1_.name as name8_0_1_, associate1_.remark as remark9_0_1_, 
associate1_.status_blue as status_10_0_1_, associate1_.status_green as status_11_0_1_, 
associate1_.status_red as status_12_0_1_, associate1_.strength as strengt13_0_1_, 
associate1_.weakness as weaknes14_0_1_, skills2_.skill_id as skill_id1_2_2_, 
skills2_.skill_name as skill_na2_2_2_ from associate_skills associates0_ 
left outer join associate associate1_ on associates0_.associate_id=associate1_.associate_id 
left outer join skills skills2_ on associates0_.skill_id=skills2_.skill_id 
where associates0_.associate_skill_id=109


