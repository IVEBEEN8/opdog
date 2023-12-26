create table volunteer(
    v_title varchar2(30 char),
    v_img varchar2(300char), 
    v_txt varchar2(5000char),
    v_created DATE DEFAULT TRUNC(SYSDATE),
    v_updated DATE DEFAULT TRUNC(SYSDATE),
    a_no number(3) not null
);


select * from volunteer;

drop table volunteer;

