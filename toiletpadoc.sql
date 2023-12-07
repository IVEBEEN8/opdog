create table toiletpad_test(
    t_no number(3) primary key,
    t_img varchar2(200char),
    t_title varchar2(200char),
    t_price number(7),
    t_brand varchar2(200char) 
);

create sequence toiletpad_test_seq;
insert into toiletpad_test VALUES (toiletpad_test_seq.nextval,?,?,?,?);
select * from toiletpad_test;
drop table toiletpad_test;
drop sequence toiletpad_test;