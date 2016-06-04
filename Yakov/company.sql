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
 
insert into company (symbol, quanity,price,order_id) 
values ('IBM', 100, 250.5);
insert into company (symbol, quanity,price,order_id) 
values ('AAPL', 40, 100.65);
insert into company (symbol, quanity,price,order_id) 
values ('MOT', 400, 50.56);
insert into company (symbol, quanity,price,order_id) 
values ('ORCL', 30, 25.43);



use company;
select * from company;