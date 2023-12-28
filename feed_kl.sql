create table Feed_kl(
    f_no number(3) primary key,
    f_img varchar2(200char),
    f_title varchar2(200char),
    f_price number(7),
    f_brand varchar2(200char) 
);

create sequence feed_kl_seq;
insert into feed_kl VALUES (feed_kl_seq.nextval,?,?,?,?);
select * from feed_kl;
drop table feed_kl;
drop sequence feed_kl_seq;