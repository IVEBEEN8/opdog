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
SET s_title = 'Dog Birthday Cake Handmade Snack Custom-made 9 cm Mini Sweet Potato Grain Cake Store Pick-up'
WHERE s_no = 8;

select * from snack_kl;
drop table snack_kl;
drop sequence snack_kl;
