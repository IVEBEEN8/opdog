CREATE TABLE centerinfo_test (
    c_no NUMBER(3) PRIMARY KEY,
    c_careNm VARCHAR2(200 CHAR),
    c_careAddr VARCHAR2(200 CHAR),
    c_lat FLOAT(20),
    c_lng FLOAT(20),
    c_vetPersonCnt NUMBER(2),
    c_careTel VARCHAR2(200 CHAR)
);

create sequence centerinfo_test_seq;
insert into centerinfo_test values (centerinfo_test_seq.nextval,c_carenm,c_careaddr,c_lat,c_lng,c_vetpersoncnt,c_caretel);
select * from centerinfo_test;


ALTER TABLE CENTERINFO_TEST MODIFY (C_LAT DEFAULT 0);
ALTER TABLE CENTERINFO_TEST MODIFY (C_LNG DEFAULT 0);
ALTER TABLE CENTERINFO_TEST MODIFY (C_VETPERSONCNT DEFAULT 0);
DROP SEQUENCE centerinfo_test_seq;
DROP TABLE centerinfo_test;
delete centerinfo_test;
ALTER SESSION SET "_optim_peek_user_binds" = false;
alter session set "_optimizer_join_elimination_enabled"=false;
grant create view, create session, create table, create procedure to sys;
select * from sys.dba_users;

UPDATE centerinfo_test
SET c_lat = 33.2738571
WHERE c_no =85;

update centerinfo_test
set c_lng = 126.609931
where c_no =85;

select * from centerinfo_test;
SELECT JSON_OBJECT('lat',c_lat,'lng',c_lng) AS json_data
FROM centerinfo_test;
