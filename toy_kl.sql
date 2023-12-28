create table toy_kl(
    t_no number(3) primary key,
    t_img varchar2(200char),
    t_title varchar2(200char),
    t_price number(7),
    t_brand varchar2(200char) 
);

create sequence toy_kl_seq;
insert into toy_kl VALUES (toy_kl_seq.nextval,?,?,?,?);
select * from toy_kl;
drop table toy_kl;
drop sequence toy_kl;