create table Fashion_kl(
    fs_no number(3) primary key,
    fs_img varchar2(200char),
    fs_title varchar2(200char),
    fs_price number(7),
    fs_brand varchar2(200char) 
);
drop table fashion_kl;
insert into fashion_kl VALUES (fashion_kl_seq.nextval,?,?,?,?);
create sequence fashion_kl_seq start with 1 increment by 1;
DROP SEQUENCE fashion_kl_seq;

select * from fashion_kl;



