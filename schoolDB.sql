create database if not exists school;

use school;

drop table if exists class;


create table class (
  id int(10) not null auto_increment,
  name varchar(50) not null,
  class_num int (3) not null,
  class_desc varchar(255) not null,
  primary key(id)

);

