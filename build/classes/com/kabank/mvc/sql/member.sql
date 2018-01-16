
select * from member;
select * from attend;
select * from tab;
select count(*) as count from tab;
select * from member where id like 'kurekure';
update member set addr = '서울' where id = "kurekure";
update member set pass = '$' where id = '@';
DROP TABLE MEMBER WHERE id = "$";
insert into member (id, pass, name) values ('111', '111', '111');