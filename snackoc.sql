create table snack_test(
    s_no number(3) primary key,
    s_img varchar2(200char),
    s_title varchar2(200char),
    s_price number(7),
    s_brand varchar2(200char) 
);

create sequence snack_test_seq;
insert into snack_test VALUES (snack_test_seq.nextval,?,?,?,?);
select * from snack_test;
drop table snack_test;
drop sequence snack_test;