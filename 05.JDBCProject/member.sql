create user jspuserc identified by jsp1234;

-- SQL
-- 1) ������ ���� ��� (DDL) : create, alter, drop
-- 2) ������ ���� ��� (DML) : insert, update, delete, select
-- 3) ������ ���� ��� (DCL) : grant, revoke

-- ���̺� ����
create table member
(
	id	  		varchar2(15)	primary key,
	password	varchar2(10),
	name		varchar2(20),
	age			number,
	gender		char(1),
	addr		varchar2(100),
	regdatqa	date			default sysdate --����Ŭ���� ���� ���� ���� ���ִ� ��ɾ�
)

select * from member
where id = 'test1'

insert into member
values('test1', '1234', 'ȫ�浿', 20, '1', '���ѹα� �����', '2015-04-17')

drop table member

update member
set addr = '��⵵'
where id='test1'	--���� �ִ°�!


delete member
where id='test1' --test1�� ���� �� �� ����