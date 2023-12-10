create table opdogaccount_test(
    op_email varchar2 (200 char) primary key,
    op_firstname varchar2 (200 char) not null,
    op_lastname varchar2 (200 char) not null,
    op_pw varchar2 (200 char) not null
);


select * from opdogaccount_test;


drop table opdogaccount_test;


DROP SEQUENCE opdogaccount_test_seq;