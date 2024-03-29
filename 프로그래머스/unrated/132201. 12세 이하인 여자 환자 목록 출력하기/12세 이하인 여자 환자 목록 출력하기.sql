-- 코드를 입력하세요
# SELECT pt_name, pt_no, gend_cd, age, if(tlno is null, 'NONE', tlno)
# from patient
# where gend_cd = "W" and age<=12
# order by age desc, pt_name;

SELECT pt_name, pt_no, gend_cd, age, IFNULL(tlno, 'NONE') as tlno
from patient
where gend_cd = "W" and age<=12
order by age desc, pt_name;