create table toy_test(
    t_no number(3) primary key,
    t_img varchar2(200char),
    t_title varchar2(200char),
    t_price number(7),
    t_brand varchar2(200char) 
);

create sequence toy_test_seq;
insert into toy_test VALUES (toy_test_seq.nextval,?,?,?,?);
select * from toy_test;
drop table toy_test;
drop sequence toy_test;