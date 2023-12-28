create table review_kl(
    r_img varchar2(300char) not null, 
    r_title varchar2(200char) not null,
    r_txt varchar2(2000char) not null,
    r_created DATE DEFAULT TRUNC(SYSDATE) NOT NULL,
    r_updated DATE DEFAULT TRUNC(SYSDATE) NOT NULL,
    op_email varchar2 (200 char) primary key
);
create sequence review_kl_seq;
select * from review_kl;
insert into review_kl values (?,?,?,?,?,?); 
insert into review_kl values ('이미지','제목','텍스트','2023-12-07','2023-12-08','dlrufp1213@naver.com');
insert into review_kl values ('이미지','제목','텍스트','2023-12-07',sysdate,'dlrufp1211@naver.com');
drop table review_kl;
ALTER TABLE review_kl
MODIFY r_txt VARCHAR2(4500 CHAR);