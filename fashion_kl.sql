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
UPDATE fashion_kl
SET fs_title = 'Shiba Dog Padding Vest Winter Clothing General Padding Khaki'
WHERE fs_no = 46;

select * from fashion_kl;
select * from fashion_kl order by fs_price asc;
select * from fashion_kl order by fs_price desc;
select * from fashion_kl where fs_brand like '%B%';

select * from fashion_kl where lower(fs_title) like lower('%wrap%') or lower(fs_brand) like lower('%wrap%');



