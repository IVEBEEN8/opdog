create table opdogaccount(
    a_no number(3) primary key,
    a_email varchar2 (2000 char),
    a_firstname varchar2 (2000 char),
    a_lastname varchar2 (2000char),
    a_password varchar2 (2000char),
    a_uprCd varchar2(2000char),
    a_orgCd varchar2(2000char)
);

create table opdoglike (
    d_age varchar2 (2000),
    d_no varchar2 (2000),
    d_kind varchar2 (2000),
    d_color varchar2 (2000),
    d_sex varchar2 (2000),
    d_neuter varchar2 (2000),
    d_mark varchar2 (2000),
    d_center varchar2 (2000),
    d_org varchar2 (2000),
    a_no number(3),
    
    constraint fk_a_no foreign key(a_no) references opdogaccount (a_no)
);

create sequence opdogaccount_seq;

insert into opdogaccount values(opdogaccount_seq.nextval,'abc','aaa','bbb','asd');

insert into opdoglike values(1,2,3,4,5,6,7,8,9,1);

select * from opdogaccount;

select* from opdoglike;

update opdogaccount set a_firstname='kim' where a_no=1;






-- test delete

drop sequence opdogaccount_seq;

drop table opdogaccount;

drop table opdoglike;






