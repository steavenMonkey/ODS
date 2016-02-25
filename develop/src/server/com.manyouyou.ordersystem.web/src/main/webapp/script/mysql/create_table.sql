
--用户信息表userinfo
drop table if exists userinfo;
create table userinfo (
	  userid int not null ,
	  username varchar(45) not null,
	  password varchar(45) not null,
	  phonenum varchar(45) null,
	  constraint pk_userinfo_userid primary key(userid),
	  constraint uk_userinfo_username unique(username)
 );
 alter table userinfo modify userid int auto_increment;
  
 
  --客户信息表customerinfo
  drop table if exists customerinfo;
  create table customerinfo (
	  customerid int not null,
	  customername varchar(45) null,
	  phonenum varchar(45) null,
	  remark varchar(200) null,
	  extend3 varchar(45) null,
	  extend1 varchar(45) null,
	  extend2 varchar(45) null,
	  constraint pk_customerinfo_customerid primary key(customerid),
	  constraint uk_customerinfo_customername unique(customername)
 );
  alter table customerinfo modify customerid int auto_increment;

  
  --客户地址信息表addressinfo
  drop table if exists addressinfo;
  create table addressinfo (
  addressid int not null,
  customerid int null,
  address varchar(200) null,
  remark varchar(200) null,
  extend1 varchar(45) null,
  extend2 varchar(45) null,
  extend3 varchar(45) null,
  constraint pk_addressinfo_addressid primary key(addressid),
  constraint fk_addressinfo_customerid foreign key (customerid) references customerinfo(customerid)
 );
  
alter table addressinfo modify addressid int auto_increment;


  --产品信息表productinfo
  drop table if exists productinfo;
  create table productinfo (
  productid int not null,
  productname varchar(45) null,
  price varchar(45) not null default 0,
  standard varchar(45) not null,
  storenum int(45) null default 0,
  salenum int(45) null default 0,
  remark varchar(200) null,
  constraint pk_productinfo_productid primary key(productid),
  constraint uk_productinfo_productname unique(productname)
);
alter table productinfo modify productid int auto_increment;

  --订单信息表orderino
  drop table if exists orderinfo;
  create table orderinfo (
	  orderid int not null,
	  productid int not null,
	  ordernum int(45) not null,
	  consumername varchar(45) not null,
	  receiveaddress varchar(200) not null,
	  cphonenum varchar(45) not null,
	  hasdeliver int null default 0,
	  haspay int null default 0,
	  orderdate date null,
	  delivercompany varchar(45) null,
	  delivernum varchar(45) null,
	  remark varchar(200) null,
	  salerid int null,
	  extend1 varchar(45) null,
	  extend2 varchar(45) null,
	  extend3 varchar(45) null,
	  constraint pk_orderino_orderid primary key(orderid),
	  constraint fk_orderinfo_salerid foreign key (salerid) references userinfo(userid)
 );
 
 alter table orderinfo modify orderid int auto_increment;





