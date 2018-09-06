create database if not exists books;

use books;

drop table if exists books;


create table books (
  id int(10) not null auto_increment,
  title varchar(100) not null,
  author varchar (100) not null,
  description varchar (255),
  category varchar (32),
  primary key(id)

);

