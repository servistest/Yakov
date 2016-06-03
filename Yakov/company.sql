DROP DATABASE IF EXISTS company;
 
CREATE DATABASE company DEFAULT CHARACTER SET 'utf8';
 
USE company;
 
create table company
(
  order_id int unsigned not null auto_increment,
  symbol varchar(255) not null,
  quanity int not null,
  price int not null,
  primary key (order_id)
) engine=InnoDB;
 

set names 'utf8';
 
insert into company (symbol, quanity,price) 
values ('IBM', 100, 250);
insert into company (symbol, quanity,price) 
values ('AAPL', 40, 100);
insert into company (symbol, quanity,price) 
values ('MOT', 400, 50);
insert into company (symbol, quanity,price) 
values ('ORCL', 30, 25);
