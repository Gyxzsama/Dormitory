-- a系统管理员	id  aid  aname  asex	apwd  	tel
-- t楼宇管理员	id  tid  tname  tsex	tpwd	tel
-- s学生		id  sid  sname  ssex	spwd  state	 tel
-- b楼宇管理	id  bid  bname  
-- d宿舍管理	id  did  bid 	dtype  	scount	tel   
-- 入住表		id  bid  did  sid  
-- 缺寝记录表    id  sid  date remarks
-- 迁出登记表    id  sid  bid  did remarks
-- 以上作废
DROP database if exists db_dormitory;
create database db_dormitory;
use db_dormitory;
-- a系统管理员
create table admin(
	id int(10) NOT NULL AUTO_INCREMENT,
	auname varchar(30) NOT NULL,
	apwd varchar(30) NOT NULL,
	aname varchar(30) NOT NULL,
	asex char(2) NOT NULL,
	tel varchar(30) DEFAULT NULL,
	PRIMARY KEY (id)
)auto_increment=10000;
-- m管理员
create table manager(
	id 	int(10) NOT NULL AUTO_INCREMENT,
	muname varchar(30) NOT NULL,
	mpwd varchar(30) NOT NULL,
	mname varchar(30) NOT NULL,
	msex char(2) NOT NULL,
	tel varchar(30) DEFAULT NULL,
	PRIMARY KEY (id)
)auto_increment=20000;
-- s学生
create table student(
	id 	int(10) NOT NULL AUTO_INCREMENT,
	suname varchar(30) NOT NULL,
	spwd varchar(30) NOT NULL,
	sname varchar(30) NOT NULL,
	ssex char(2) NOT NULL,
	state int(2) DEFAULT 0,
	tel varchar(30) DEFAULT NULL,
	PRIMARY KEY (id)
)auto_increment=201700001;
-- b楼宇
create table build(
	id int(10) NOT NULL AUTO_INCREMENT,
	bname varchar(30) NOT NULL,
	btype char(2) NOT NULL,
	PRIMARY KEY (id)
)auto_increment=1001;

-- d宿舍   （楼宇）
create table dormitory(
	id int(10) NOT NULL AUTO_INCREMENT,
	d_id int(20) NOT NULL,
	b_id int(20) NOT NULL,
	dtype int(4) NOT NULL,
	scount int(4) DEFAULT 0,	
	tel varchar(30) DEFAULT NULL,
	PRIMARY KEY (id)
);
-- 入住 迁出 缺寝
create table stu_in(
	id int(10) NOT NULL AUTO_INCREMENT,
	s_id int(20) NOT NULL,
	b_id int(20) NOT NULL,
	d_id int(20) NOT NULL,
	PRIMARY KEY (id)
);
create table stu_out(
	id int(10) NOT NULL AUTO_INCREMENT,
	s_id int(20) NOT NULL,
	b_id int(20) NOT NULL,
	d_id int(20) NOT NULL,
	remarks varchar(30) DEFAULT NULL,
	PRIMARY KEY (id)
);
create table stu_lack(
	id int(10) NOT NULL AUTO_INCREMENT,
	s_id int(20) NOT NULL,
	times date NOT NULL,
	remarks varchar(30) DEFAULT NULL,
	PRIMARY KEY (id)
);

ALTER TABLE dormitory ADD CONSTRAINT fk_1 FOREIGN KEY (b_id)
REFERENCES build(id);

ALTER TABLE stu_in ADD CONSTRAINT fk_5 FOREIGN KEY (b_id)
REFERENCES build(id);
ALTER TABLE stu_in ADD CONSTRAINT fk_6 FOREIGN KEY (d_id)
REFERENCES dormitory(id);
ALTER TABLE stu_in ADD CONSTRAINT fk_7 FOREIGN KEY (s_id)
REFERENCES student(id);

ALTER TABLE stu_out ADD CONSTRAINT fk_8 FOREIGN KEY (b_id)
REFERENCES build(id);
ALTER TABLE stu_out ADD CONSTRAINT fk_9 FOREIGN KEY (d_id)
REFERENCES dormitory(id);
ALTER TABLE stu_out ADD CONSTRAINT fk_10 FOREIGN KEY (s_id)
REFERENCES student(id);

ALTER TABLE stu_lack ADD CONSTRAINT fk_11 FOREIGN KEY (s_id)
REFERENCES student(id);

INSERT into admin(auname,apwd,aname,asex)values('admin','123456','XXXX111','男');

INSERT into manager(muname,mpwd,mname,msex)values('mger1','123456','XXXX01','男');
INSERT into manager(muname,mpwd,mname,msex)values('mger2','123456','XXXX02','女');


INSERT into student(suname,spwd,sname,ssex)values('X0001','123456','XXXX01','男');
INSERT into student(suname,spwd,sname,ssex)values('X0002','123456','XXXX02','女');
INSERT into student(suname,spwd,sname,ssex)values('X0003','123456','XXXX03','男');
INSERT into student(suname,spwd,sname,ssex)values('X0004','123456','XXXX04','女');
INSERT into student(suname,spwd,sname,ssex)values('X0005','123456','XXXX05','女');

INSERT into build(bname,btype)values('001','男');
INSERT into build(bname,btype)values('002','男');
INSERT into build(bname,btype)values('003','男');
INSERT into build(bname,btype)values('004','女');
INSERT into build(bname,btype)values('005','女');
INSERT into build(bname,btype)values('006','女');

INSERT into dormitory(d_id,b_id,dtype)values(101,1001,4);
INSERT into dormitory(d_id,b_id,dtype)values(102,1001,4);
INSERT into dormitory(d_id,b_id,dtype)values(103,1001,4);
INSERT into dormitory(d_id,b_id,dtype)values(104,1001,4);

INSERT into dormitory(d_id,b_id,dtype)values(101,1004,4);
INSERT into dormitory(d_id,b_id,dtype)values(102,1004,4);
INSERT into dormitory(d_id,b_id,dtype)values(103,1004,4);
INSERT into dormitory(d_id,b_id,dtype)values(104,1004,4);

