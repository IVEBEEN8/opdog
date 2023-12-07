create table Fashion_test(
    fs_no number(3) primary key,
    fs_img varchar2(200char),
    fs_title varchar2(200char),
    fs_price number(7),
    fs_brand varchar2(200char) 
);

create sequence fashion_test_seq;
insert into fashion_test VALUES (fashion_test_seq.nextval,?,?,?,?);
select * from fashion_test;
drop table feed_test;
drop sequence feed_test;