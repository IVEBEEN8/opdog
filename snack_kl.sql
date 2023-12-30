create table snack_kl(
    s_no number(3) primary key,
    s_img varchar2(200char),
    s_title varchar2(200char),
    s_price number(7),
    s_brand varchar2(200char) 
);

create sequence snack_kl_seq;
insert into snack_kl VALUES (snack_kl_seq.nextval,?,?,?,?);
UPDATE snack_kl
SET s_title = 'Dental gum, which eats dog gum for a long time, is 100g of Korean beef''s Whoopi twisted chicken'
WHERE s_no = 43;

select * from snack_kl;
drop table snack_kl;
drop sequence snack_kl;
