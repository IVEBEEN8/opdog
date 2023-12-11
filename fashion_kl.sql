create table Fashion_kl(
    fs_no number(3) primary key,
    fs_img varchar2(200char),
    fs_title varchar2(200char),
    fs_price number(7),
    fs_brand varchar2(200char) 
);

create sequence fashion_kl_seq;
insert into fashion_kl VALUES (fashion_test_seq.nextval,?,?,?,?);
select * from fashion_kl;
drop table fashion_kl;
drop sequence fashion_kl;