create table appliedvol(
    ap_no number(3) primary key,
    a_no number(3) not null,
    v_no number(3),
    ap_status varchar2(200 char),
    ap_title varchar2(200 char),
    ap_postdate Date,
    ap_applieddate Date default trunc(sysdate),
    ap_img varchar2(300 char),
    ap_txt varchar2(5000 char),
    a_email varchar2(200 char)
);

create sequence appliedvol_seq;

insert into appliedvol values(appliedvol_seq.nextval, ?,?,?,?,?,sysdate,?,?,?);

select * from appliedvol;



drop table appliedvol;

drop sequence appliedvol_seq;

--중복체크 방지 
ALTER TABLE appliedvol
ADD CONSTRAINT unique_appliedvol_combination UNIQUE (v_no);

SELECT v.*, a.A_EMAIL FROM VOLUNTEER v
JOIN OPDOGACCOUNT a ON v.A_NO = a.A_NO and v.v_title like '%%' order by v_no;

drop table volunteer cascade constraint purge;
create sequence volunteer_seq;

select * from volunteer;
drop table volunteer;
drop sequence volunteer_seq;

create table volunteer(
v_no number(3) primary key,
v_title varchar2(300 char) not null,
v_img varchar2(500 char) not null,
v_txt varchar2(1500 char) not null,
v_created date not null,
v_status varchar2(30 char) not null,
a_no number(3) not null,
v_locate varchar2(30 char) not null,
constraint fk_a_no_foreign foreign key (a_no) references opdogaccount(a_no) on delete cascade
);

insert into volunteer values(volunteer_seq.nextval, 'test','a.jpg','asdasd',sysdate, 'complete',21,'seoul');
insert into volunteer values(volunteer_seq.nextval, 'test2','a.jpg','asdasd',sysdate, 'complete',21,'seoul');
insert into volunteer values(volunteer_seq.nextval, 'test3','a.jpg','asdasd',sysdate, 'complete',21,'seoul');
insert into volunteer values(volunteer_seq.nextval, 'test4','a.jpg','asdasd',sysdate, 'complete',21,'seoul');
insert into volunteer values(volunteer_seq.nextval, 'test5','a.jpg','asdasd',sysdate, 'complete',21,'seoul');
insert into volunteer values(volunteer_seq.nextval, 'test6','a.jpg','asdasd',sysdate, 'complete',21,'seoul');
insert into volunteer values(volunteer_seq.nextval,?,?,?,sysdate,?,?,?)
		
create table volunteerApply(
va_no number(3) primary key,
va_id varchar2(30 char) not null,
va_apply_date date not null,
va_v_no number(3) not null,
CONSTRAINT fk_va_v_no FOREIGN KEY (va_v_no) REFERENCES volunteer(v_no) On delete cascade
);
select * from centerinfo1;


