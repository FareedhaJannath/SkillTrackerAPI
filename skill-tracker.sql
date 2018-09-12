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

select skills0_.skill_id as skill_id1_2_, skills0_.skill_name as skill_na2_2_ 
from skills skills0_ where skills0_.skill_id=1


SELECT  a.associate_id, a.name, a.email, a.mobile, a.status_blue, a.status_green,
a.status_red, '' from associate a 
where not exists (select * from associate_skills ask where ask.associate_id = a.associate_id) 
UNION all SELECT  a.associate_id, a.name, a.email, a.mobile, a.status_blue, 
a.status_green, a.status_red, GROUP_CONCAT(s.skill_name) FROM associate a  
INNER JOIN associate_skills ask ON a.associate_id=ask.associate_id 
INNER JOIN skills s ON s.skill_id = ask.skill_id -- AND ask.skill_level > 0 
GROUP BY ask.associate_id

alter table associate add column gender varchar(10);

alter table associate_skills add skill_rating INT;
