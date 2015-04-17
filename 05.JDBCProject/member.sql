create user jspuserc identified by jsp1234;

-- SQL
-- 1) 데이터 정의 언어 (DDL) : create, alter, drop
-- 2) 데이터 조작 언어 (DML) : insert, update, delete, select
-- 3) 데이터 제어 언어 (DCL) : grant, revoke

-- 테이블 생성
create table member
(
	id	  		varchar2(15)	primary key,
	password	varchar2(10),
	name		varchar2(20),
	age			number,
	gender		char(1),
	addr		varchar2(100),
	regdatqa	date			default sysdate --오라클에서 오늘 날자 들어가게 해주는 명령어
)

select * from member
where id = 'test1'

insert into member
values('test1', '1234', '홍길동', 20, '1', '대한민국 서울시', '2015-04-17')

drop table member

update member
set addr = '경기도'
where id='test1'	--조건 주는거!


delete member
where id='test1' --test1에 관한 것 다 지움