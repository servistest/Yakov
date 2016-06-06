DROP DATABASE IF EXISTS company;
 
CREATE DATABASE company DEFAULT CHARACTER SET 'utf8';
 
USE company;
 
create table company
(
  order_id int unsigned not null auto_increment,
  symbol varchar(255) not null,
  quanity int not null,
  price double not null,
  dateOrder date not null,
  primary key (order_id)
) engine=InnoDB;
 

set names 'utf8';
 
use company;
insert into company (symbol, quanity,price,dateOrder) 
values ('IBM', 100, 250.5,'2016-12-12');
insert into company (symbol, quanity,price,dateOrder) 
values ('AAPL', 40, 100.65,'2016-12-30');
insert into company (symbol, quanity,price,dateOrder) 
values ('MOT', 400, 50.56,'2012-11-03');
insert into company (symbol, quanity,price,dateOrder) 
values ('ORCL', 30, 25.43,'2012-07-19');

use company;
select * from company;