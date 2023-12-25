create table volunteer(
    v_title varchar2(30 char) not null,
    v_img varchar2(300char) not null, 
    v_txt varchar2(5000char) not null,
    v_created DATE DEFAULT TRUNC(SYSDATE) NOT NULL,
    v_updated DATE DEFAULT TRUNC(SYSDATE) NOT NULL,
    a_no number(3) not null
);


select * from volunteer;

drop table volunteer;

