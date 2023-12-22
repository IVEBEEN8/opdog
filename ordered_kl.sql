create table ordered_kl(
    o_no number(3) primary key,
    o_title varchar2(200char),
    o_price number(7),
    o_brand varchar2(200char),
    o_sPrice number(7),
    o_date DATE DEFAULT TRUNC(SYSDATE) NOT NULL,
    a_no number(3)not null
);

create sequence ordered_kl_seq start with 1 increment by 1;
DROP SEQUENCE ordered_kl_seq;
drop table ordered_kl;
select * from ordered_kl;
