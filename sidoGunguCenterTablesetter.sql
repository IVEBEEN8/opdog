create table sido (
    s_orgCd varchar2(2000 char),
    s_orgdownNm varchar2(2000 char)
);

select*from sido;

select s_orgCd from sido;

create table gungu (
    g_uprCd varchar2(2000 char),
    g_orgCd varchar2(2000 char),
    g_orgdownNm varchar2(2000 char)
);

select* from gungu;

-- 이상한 값 삭제/변경 추가
--광주광역시 삭제
delete gungu where g_orgCd=6299998; 
--경상북도 삭제
delete gungu where g_orgCd=6479998; 
--null 삭제
delete gungu where g_orgCd=6489999; 
--제주특별자치도 삭제
delete gungu where g_orgCd=6500000; 
--가정보호 삭제
delete gungu where g_orgCd=6119999; 
--서울특별시 이름을 서울연합으로 변경
update gungu set g_orgdownNm='보호센터연합' where g_orgCd=6119998;
--세종시에 군/구 추가
insert into gungu values('5690000','5690000','세종특별자치시');


create table shelter (
    s_uprCd varchar2(2000 char),
    s_orgCd varchar2(2000 char),
    s_careRegNo varchar2(2000 char),
    s_CareNm varchar2(2000 char)   
);
select* from shelter;

select*from shelter where s_uprCd=6310000 and s_orgCd=3710000;
select*from shelter where s_uprCd=6310000 and s_orgCd=3710000;


drop table shelter;