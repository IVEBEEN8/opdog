create table Feed_test(
    f_no number(3) primary key,
    f_img varchar2(200char),
    f_title varchar2(200char),
    f_price number(7),
    f_brand varchar2(200char) 
);

create sequence feed_test_seq;
insert into feed_test VALUES (feed_test_seq.nextval,?,?,?,?);
select * from feed_test;
drop table feed_test;
drop sequence feed_test;