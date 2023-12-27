create table volunteer(
    v_no number(3) primary key,
    v_title varchar2(30 char),
    v_img varchar2(300char), 
    v_txt varchar2(5000char),
    v_created DATE DEFAULT TRUNC(SYSDATE),
    v_updated DATE DEFAULT TRUNC(SYSDATE),
    v_status varchar2(30char),
    a_no number(3) not null
);

create sequence volunteer_seq;

select * from volunteer;

insert into volunteer values(volunteer_seq.nextval, ?,?,?,sysdate,sysdate,?,?);

drop table volunteer;

